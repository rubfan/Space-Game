package com.game.model.dao;

import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BaysDAOTest {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/tempProj?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private BaysDAO baysDAO = new BaysDAO();

    @Test
    public void printBayList() {
        Collection collection = baysDAO.getBayList(JDBC_DRIVER, DATABASE_URL, USER, PASSWORD);
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.toArray()[i].toString());
        }
    }
}
