package com.game.model.dao;

import com.game.model.entity.WeaponEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeaponsDAO {
        private String dbURL;
        private String user;
        private String password;
        private Connection connection;
        private Statement statement;

        public List<WeaponEntity> getWeaponList() throws SQLException {
            final String DB_SELECT_STATEMENT =
                    "SELECT Weapons.resource_id, Resources.name, Resources.description, " +
                            "Resources.group_id, ResourcesGroups.name, ResourcesGroups.description" + "\n" +
                            "FROM  Weapons LEFT JOIN Resources ON Weapons.resource_id=Resources.id" + "\n" +
                            "LEFT JOIN ResourcesGroups ON Resources.group_id = ResourcesGroups.id;";

            List<WeaponEntity> weaponEntityList = new ArrayList<WeaponEntity>();
            registrationJDBSDriver();
            ResultSet resultSet = creatingStatement().executeQuery(DB_SELECT_STATEMENT);
            prepareEntityProperties(weaponEntityList, resultSet);
            resultSet.close();
            statement.close();
            connection.close();

            return weaponEntityList;
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

        private void prepareEntityProperties(List<WeaponEntity> list, ResultSet resultSet) throws SQLException {
            while (resultSet.next()) {
                WeaponEntity weaponEntity = new WeaponEntity();
                weaponEntity.setResourceId(resultSet.getInt("resource_id"));
                weaponEntity.setResourceName(resultSet.getString("Resources.name"));
                weaponEntity.setResourceDescription(resultSet.getString("Resources.description"));
                weaponEntity.setGroupId(resultSet.getInt("group_id"));
                weaponEntity.setGroupName(resultSet.getString("ResourcesGroups.name"));
                weaponEntity.setGroupDescription(resultSet.getString("ResourcesGroups.description"));
                list.add(weaponEntity);
            }
        }
    }
