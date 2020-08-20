package com.game.model.dao;

import com.game.model.entity.FighterEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FightersDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<FighterEntity> getFighterList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Fighters.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Fighters LEFT JOIN Resources ON Fighters.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<FighterEntity> fighterEntityList = new ArrayList<FighterEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(fighterEntityList, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return fighterEntityList;
    }


    private void registrationJDBSDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load class.");
            e.printStackTrace();
        }
    }

    private Connection connectionJDBSDriver(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    private Statement creatingStatement() throws SQLException {
        statement = connectionJDBSDriver(dbURL, user, password).createStatement();
        return statement;
    }

    public void createJDBCDateInformation(String dbURL, String user, String password) {
        this.dbURL = dbURL;
        this.user = user;
        this.password = password;
    }

    private void prepareEntityProperties(List<FighterEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            FighterEntity fighterEntity = new FighterEntity();
            fighterEntity.setResourceId(resultSet.getInt("resource_id"));
            fighterEntity.setResourceName(resultSet.getString("Resources.name"));
            fighterEntity.setResourceDescription(resultSet.getString("Resources.description"));
            fighterEntity.setGroupId(resultSet.getInt("group_id"));
            fighterEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            fighterEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(fighterEntity);
        }
    }
}
