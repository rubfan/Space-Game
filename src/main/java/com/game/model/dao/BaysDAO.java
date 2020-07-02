package com.game.model.dao;

import com.game.model.entity.BayEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaysDAO {
    /*
    Метод должен делать запрос в базу данных и возвращать соответстующий список Entity
    */
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/tempProj?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DB_SELECT_STATEMENT =
                    "SELECT ResourcesGroups.id, ResourcesGroups.name, " +
                    "ResourcesGroups.description,\n" +
                    "Resources.name, Resources.description, Resources.group_id\n" +
                    "FROM ResourcesGroups\n LEFT JOIN Resources " +
                    "ON ResourcesGroups.id=Resources.group_id;";

    public List<BayEntity> getBayList() {
        List<BayEntity> bayEntityList = new ArrayList<BayEntity>();

//        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DB_SELECT_STATEMENT);
            setEntityProperties(bayEntityList, resultSet);
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

    private void setEntityProperties(List<BayEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            BayEntity bayEntity = new BayEntity();
            bayEntity.setResourceId(resultSet.getInt("id"));
            bayEntity.setResourceName(resultSet.getString("Resources.name"));
            bayEntity.setResourceDescription(resultSet.getString("Resources.description"));
            bayEntity.setGroupId(resultSet.getInt("group_id"));
            bayEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            bayEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(bayEntity);
        }
    }
}


