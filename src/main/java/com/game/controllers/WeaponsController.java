package com.game.controllers;

import com.game.model.dao.WeaponsDAO;
import com.game.model.entity.WeaponEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class WeaponsController extends HttpServlet {
    WeaponsDAO weaponsDAO = new WeaponsDAO();
    List<WeaponEntity> date;
    String title;

    public void getDate(WeaponsDAO weaponsDAO) throws SQLException {
        weaponsDAO.createJDBCDateInformation("jdbc:mysql://localhost:3306/basebase", "root", "root");
        date = weaponsDAO.getWeaponList();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            getDate(weaponsDAO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        title = "    <th>ResourceId</th>\n" + "    <th>ResourceName</th>\n" + "    <th>ResourceDescription</th>\n" +
                "    <th>GroupId</th>\n" + "    <th>GroupName</th>\n" + "    <th>GroupDescription</th>\n" + "  </tr>\n";

        for (int i = 0; i < date.size(); i++) {
            title += "  <tr>\n" +
                    "    <td>" + date.get(i).getResourceId() + "</td>\n" +
                    "    <td>" + date.get(i).getResourceName() + "</td>\n" +
                    "    <td>" + date.get(i).getResourceDescription() + "</td>\n" +
                    "    <td>" + date.get(i).getGroupId() + "</td>\n" +
                    "    <td>" + date.get(i).getGroupName() + "</td>\n" +
                    "    <td>" + date.get(i).getGroupDescription() + "</td>\n" +
                    "  </tr>\n";
        }

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();
        writer.println("<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table {\n" +
                "  font-family: arial, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "td, th {\n" +
                "  border: 1px solid #dddddd;\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "tr:nth-child(even) {\n" +
                "  background-color: #dddddd;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>HTML Table</h2>\n" +
                "<table>\n" +
                "  <tr>\n" +
                title +
                "</table>\n");
        writer.println(request.getMethod());
        writer.println(request.getRequestURI());
        writer.println("\n" +
                "</body>\n" +
                "</html>");
    }
}