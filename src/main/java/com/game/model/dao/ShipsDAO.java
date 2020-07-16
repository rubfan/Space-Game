package com.game.model.dao;

import com.game.model.entity.ShipEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ShipsDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<ShipEntity> getShipList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Ships.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Ships LEFT JOIN Resources ON Ships.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<ShipEntity> shipEntityList = new ArrayList<ShipEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(shipEntityList, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return shipEntityList;
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

    private void prepareEntityProperties(List<ShipEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            ShipEntity shipEntity = new ShipEntity();
            shipEntity.setResourceId(resultSet.getInt("resource_id"));
            shipEntity.setResourceName(resultSet.getString("Resources.name"));
            shipEntity.setResourceDescription(resultSet.getString("Resources.description"));
            shipEntity.setGroupId(resultSet.getInt("group_id"));
            shipEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            shipEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(shipEntity);
        }
    }


}
