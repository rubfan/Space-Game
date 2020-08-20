package com.game.model.dao;

import com.game.model.entity.DroneEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DronesDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<DroneEntity> getDroneList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Drones.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Drones LEFT JOIN Resources ON Drones.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<DroneEntity> droneEntityList = new ArrayList<DroneEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(droneEntityList, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return droneEntityList;
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

    private void prepareEntityProperties(List<DroneEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            DroneEntity droneEntity = new DroneEntity();
            droneEntity.setResourceId(resultSet.getInt("resource_id"));
            droneEntity.setResourceName(resultSet.getString("Resources.name"));
            droneEntity.setResourceDescription(resultSet.getString("Resources.description"));
            droneEntity.setGroupId(resultSet.getInt("group_id"));
            droneEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            droneEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(droneEntity);
        }
    }
}
