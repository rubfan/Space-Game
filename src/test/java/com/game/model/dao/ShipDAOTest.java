package com.game.model.dao;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Collection;

public class ShipDAOTest {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/basebase";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private ShipsDAO shipsDAO = new ShipsDAO();

    @Test
    public void printShipList() throws SQLException {
        shipsDAO.createJDBCDateInformation(DATABASE_URL, USER, PASSWORD);
        Collection collection = shipsDAO.getShipList();
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.toArray()[i].toString());
        }
    }
}

