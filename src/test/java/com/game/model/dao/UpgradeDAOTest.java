package com.game.model.dao;

import org.junit.Test;

public class UpgradeDAOTest {
    private final String URL = "jdbc:mysql://localhost/5_upgrades?useUnicode=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "1000";
    private final UpgradeDAO upgradeDAO = new UpgradeDAO();

    @Test
    public void checkUpdateList() {
        System.out.println(upgradeDAO.getUpgradeList(URL, USER, PASSWORD));
    }
}
