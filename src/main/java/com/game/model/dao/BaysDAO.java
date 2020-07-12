package com.game.model.dao;

import com.game.model.entity.BayEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaysDAO {
    /*
    Метод должен делать запрос в базу данных и возвращать соответстующий список Entity
    */

    public List<BayEntity> getBayList(String jdbcDriver, String dbUrl,
                                      String userName, String userPass) {
        final String DB_SELECT_STATEMENT =
                                        "SELECT Bays.resource_id, Resources.name, Resources.description, " +
                                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description\n" +
                                        "FROM  Bays LEFT JOIN Resources ON Bays.resource_id=Resources.id\n" +
                                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<BayEntity> bayEntityList = new ArrayList<BayEntity>();
        downloadJdbcDriver(jdbcDriver);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, userName, userPass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DB_SELECT_STATEMENT);
            prepareEntityProperties(bayEntityList, resultSet);
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
        return bayEntityList;
    }

    private void downloadJdbcDriver(String jdbcDriver) {
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
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
