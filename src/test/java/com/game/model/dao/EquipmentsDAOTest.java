package com.game.model.dao;

import org.junit.Test;
import java.sql.SQLException;
import java.util.Collection;

public class EquipmentsDAOTest {
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/basebase";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private EquipmentsDAO equipmentsDAO = new EquipmentsDAO();

    @Test
    public void printShipsList() throws SQLException {
        equipmentsDAO.createJDBCDateInformation(DATABASE_URL, USER, PASSWORD);
        Collection collection = equipmentsDAO.getEquipmentList();
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.toArray()[i].toString());
        }
    }
}
