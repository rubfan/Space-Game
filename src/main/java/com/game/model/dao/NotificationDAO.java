package com.game.model.dao;

import com.game.model.entity.NotificationEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<NotificationEntity> getNotificationList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Notifications.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Notifications LEFT JOIN Resources ON Notifications.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<NotificationEntity> notificationEntityList = new ArrayList<NotificationEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(notificationEntityList, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return notificationEntityList;
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

    private void prepareEntityProperties(List<NotificationEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            NotificationEntity notificationEntity = new NotificationEntity();
            notificationEntity.setResourceId(resultSet.getInt("resource_id"));
            notificationEntity.setResourceName(resultSet.getString("Resources.name"));
            notificationEntity.setResourceDescription(resultSet.getString("Resources.description"));
            notificationEntity.setGroupId(resultSet.getInt("group_id"));
            notificationEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            notificationEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(notificationEntity);
        }
    }
}
