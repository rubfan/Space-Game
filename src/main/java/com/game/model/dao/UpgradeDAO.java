package com.game.model.dao;

import com.game.model.entity.UpgradeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UpgradeDAO {
     List<UpgradeEntity> updateEntity = new ArrayList<>();

    public List<UpgradeEntity> getUpgradeList(String url, String user, String password) {
        Connection con;
        Statement stmt;
        ResultSet rs;
        UpgradeEntity upgradeQuery = new UpgradeEntity();
        String query = getQuery();

        try {
            con = getConnection(url, user, password);
            stmt = getStatement(con);
            rs = getResultSet(stmt, query);

            while (rs.next()) {
                fillingTheSet(rs, upgradeQuery);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return updateEntity;
    }

    private ResultSet getResultSet(Statement stmt, String query) throws SQLException {
        ResultSet rs;
        rs = stmt.executeQuery(query);
        return rs;
    }

    private Statement getStatement(Connection con) throws SQLException {
        Statement stmt;
        stmt = con.createStatement();
        return stmt;
    }

    private Connection getConnection(String url, String user, String password) throws SQLException {
        Connection con;
        con = DriverManager.getConnection(url, user, password);
        return con;
    }

    private String getQuery() {
        return "SELECT resources.id, resources.name, resources.description, \n" +
                "resourcesgroups.id, resourcesgroups.name, resourcesgroups.description\n" +
                "FROM resources\n" +
                "LEFT JOIN resourcesgroups ON resources.group_id = resourcesgroups.id;";
    }

    private void fillingTheSet(ResultSet rs, UpgradeEntity upgradeQuery) throws SQLException {
        upgradeQuery.setGroupId(rs.getInt(1));
        upgradeQuery.setGroupName(rs.getString(2));
        upgradeQuery.setGroupDescription(rs.getString(3));
        upgradeQuery.setResourceId(rs.getInt(4));
        upgradeQuery.setResourceName(rs.getString(5));
        upgradeQuery.setResourceDescription(rs.getString(6));
        this.updateEntity.add(upgradeQuery);
    }
}
