package com.game.model.dao;

import com.game.model.entity.AugmentationEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AugmentationsDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<AugmentationEntity> getAugmentationList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Augmentations.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Augmentations LEFT JOIN Resources ON Augmentations.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<AugmentationEntity> augmentationEntityList = new ArrayList<AugmentationEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(augmentationEntityList, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return augmentationEntityList;
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

    private void prepareEntityProperties(List<AugmentationEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            AugmentationEntity augmentationEntity = new AugmentationEntity();
            augmentationEntity.setResourceId(resultSet.getInt("resource_id"));
            augmentationEntity.setResourceName(resultSet.getString("Resources.name"));
            augmentationEntity.setResourceDescription(resultSet.getString("Resources.description"));
            augmentationEntity.setGroupId(resultSet.getInt("group_id"));
            augmentationEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            augmentationEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(augmentationEntity);
        }
    }
}
