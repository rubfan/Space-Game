package com.game.model.dao;

import com.game.model.entity.BayEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaysDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<BayEntity> getBayList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Bays.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Bays LEFT JOIN Resources ON Bays.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<BayEntity> bayEntityList = new ArrayList<BayEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(bayEntityList, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return bayEntityList;
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

    private void prepareEntityProperties(List<BayEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            BayEntity bayEntity = new BayEntity();
            bayEntity.setResourceId(resultSet.getInt("resource_id"));
            bayEntity.setResourceName(resultSet.getString("Resources.name"));
            bayEntity.setResourceDescription(resultSet.getString("Resources.description"));
            bayEntity.setGroupId(resultSet.getInt("group_id"));
            bayEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            bayEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(bayEntity);
        }
    }
}
