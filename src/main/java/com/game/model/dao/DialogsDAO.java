package com.game.model.dao;

import com.game.model.entity.DialogEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DialogsDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<DialogEntity> getDialogList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Dialogs.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Dialogs LEFT JOIN Resources ON Dialogs.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<DialogEntity> dialogEntityList = new ArrayList<DialogEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(dialogEntityList, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return dialogEntityList;
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

    private void prepareEntityProperties(List<DialogEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            DialogEntity dialogEntity = new DialogEntity();
            dialogEntity.setResourceId(resultSet.getInt("resource_id"));
            dialogEntity.setResourceName(resultSet.getString("Resources.name"));
            dialogEntity.setResourceDescription(resultSet.getString("Resources.description"));
            dialogEntity.setGroupId(resultSet.getInt("group_id"));
            dialogEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            dialogEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(dialogEntity);
        }
    }
}
