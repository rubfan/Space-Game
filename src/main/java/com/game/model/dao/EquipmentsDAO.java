package com.game.model.dao;

import com.game.model.entity.EquipmentEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EquipmentsDAO {
    private String dbURL;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public List<EquipmentEntity> getEquipmentList() throws SQLException {
        final String DB_SELECT_STATEMENT =
                "SELECT Equipments.resource_id, Resources.name, Resources.description, " +
                        "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                        "FROM  Equipments LEFT JOIN Resources ON Equipments.resource_id=Resources.id" + "\n" +
                        "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

        List<EquipmentEntity> equipmentEntityList = new ArrayList<EquipmentEntity>();
        registrationJDBSDriver();
        ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
        prepareEntityProperties(equipmentEntityList, resultSet);
        resultSet.close();
        statement.close();
        connection.close();

        return equipmentEntityList;
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

    private void prepareEntityProperties(List<EquipmentEntity> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            EquipmentEntity equipmentEntity = new EquipmentEntity();
            equipmentEntity.setResourceId(resultSet.getInt("resource_id"));
            equipmentEntity.setResourceName(resultSet.getString("Resources.name"));
            equipmentEntity.setResourceDescription(resultSet.getString("Resources.description"));
            equipmentEntity.setGroupId(resultSet.getInt("group_id"));
            equipmentEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
            equipmentEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
            list.add(equipmentEntity);
        }
    }
}
