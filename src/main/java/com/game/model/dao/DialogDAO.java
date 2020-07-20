package com.game.model.dao;

import com.game.model.entity.DialogEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DialogDAO {
    public List<DialogEntity> getDialogList(String jdbcDriver, String dbUrl,
                                            String userName, String userPass) {
        final String DB_SELECT_STATEMENT =
                "SELECT Dialogs.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description\n" +
                        "FROM  Dialogs LEFT JOIN Resources ON Dialogs.resource_id=Resources.id\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<DialogEntity> dialogEntityList = new ArrayList<DialogEntity>();
        downloadJdbcDriver(jdbcDriver);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, userName, userPass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DB_SELECT_STATEMENT);
            prepareEntityProperties(dialogEntityList, resultSet);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Connection close failed.");
                System.err.println(e.getMessage());
            }
        }
        return dialogEntityList;
    }

    private void downloadJdbcDriver(String jdbcDriver) {
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
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

