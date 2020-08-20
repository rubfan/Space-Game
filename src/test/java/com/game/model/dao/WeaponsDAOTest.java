package com.game.model.dao;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Collection;

public class WeaponsDAOTest {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/basebase";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private WeaponsDAO weaponsDAO = new WeaponsDAO();

    @Test
    public void printWeaponsList() throws SQLException {
        weaponsDAO.createJDBCDateInformation(DATABASE_URL, USER, PASSWORD);
        Collection collection = weaponsDAO.getWeaponList();
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.toArray()[i].toString());
        }
    }
}

