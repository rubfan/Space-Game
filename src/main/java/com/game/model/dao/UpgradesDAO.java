package com.game.model.dao;

import com.game.model.entity.UpgradeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UpgradesDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<UpgradeEntity> getUpgradeList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Upgrades.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Upgrades LEFT JOIN Resources ON Upgrades.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<UpgradeEntity> upgradeEntityList = new ArrayList<UpgradeEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(upgradeEntityList, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return upgradeEntityList;
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

    private void prepareEntityProperties(List<UpgradeEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            UpgradeEntity upgradeEntity = new UpgradeEntity();
            upgradeEntity.setResourceId(resultSet.getInt("resource_id"));
            upgradeEntity.setResourceName(resultSet.getString("Resources.name"));
            upgradeEntity.setResourceDescription(resultSet.getString("Resources.description"));
            upgradeEntity.setGroupId(resultSet.getInt("group_id"));
            upgradeEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            upgradeEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(upgradeEntity);
        }
    }
}
