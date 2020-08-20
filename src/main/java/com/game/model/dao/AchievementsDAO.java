package com.game.model.dao;

import com.game.model.entity.AchievementEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AchievementsDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<AchievementEntity> getAchievementList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Achievements.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Achievements LEFT JOIN Resources ON Achievements.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<AchievementEntity> Achievements = new ArrayList<AchievementEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(Achievements, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return Achievements;
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

    private void prepareEntityProperties(List<AchievementEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            AchievementEntity achievementEntity = new AchievementEntity();
            achievementEntity.setResourceId(resultSet.getInt("resource_id"));
            achievementEntity.setResourceName(resultSet.getString("Resources.name"));
            achievementEntity.setResourceDescription(resultSet.getString("Resources.description"));
            achievementEntity.setGroupId(resultSet.getInt("group_id"));
            achievementEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            achievementEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(achievementEntity);
        }
    }
}
