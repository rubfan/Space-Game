package com.game.model.dao;

import com.game.model.entity.AchievementEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AchievementDAO {
    public List<AchievementEntity> getAchievementList(String jdbcDriver, String databaseLink,
                                                      String userName, String userPass) {
        Connection connection = getConnected(jdbcDriver, databaseLink, userName, userPass);
        ResultSet resultSet = getData(connection);
        List<AchievementEntity> result = buildList(resultSet);
        closeConnection(connection);
        return result;
    }

    private Connection getConnected(String jdbcDriver, String databaseLink,
                                    String userName, String userPass) {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(
                    databaseLink,
                    userName,
                    userPass);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver error");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return connection;
    }

    private ResultSet getData(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM Resources " +
                            "INNER JOIN ResourcesGroups " +
                            "ON Resources.group_id = ResourcesGroups.id " +
                            "WHERE group_id = 10");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("SQL query execution failed");
            closeConnection(connection);
            e.printStackTrace();
        }
        return null;
    }

    private List<AchievementEntity> buildList(ResultSet rs) {
        List<AchievementEntity> aeList = new ArrayList<AchievementEntity>();
        while (true) {
            try {
                if (!rs.next()) break;
                AchievementEntity ae = new AchievementEntity();
                ae.setGroupId(rs.getInt("ResourcesGroups.id"));
                ae.setGroupName(rs.getString("ResourcesGroups.name"));
                ae.setGroupDescription(rs.getString("ResourcesGroups.description"));
                ae.setResourceId(rs.getInt("Resources.id"));
                ae.setResourceName(rs.getString("Resources.name"));
                ae.setResourceDescription(rs.getString("Resources.description"));
                aeList.add(ae);
            } catch (SQLException e) {
                System.out.println("Failed to read database data");
                e.printStackTrace();
            }
        }
        return aeList;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection closure failed");
            e.printStackTrace();
        }
    }
}
