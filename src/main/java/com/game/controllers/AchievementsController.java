package com.game.controllers;

import com.game.model.dao.AchievementDAO;
import com.game.model.entity.AchievementEntity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AchievementsController extends HttpServlet {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DATABASE_LINK = "jdbc:mysql://localhost:3306/game?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private final String USER = "root";
    private final String PASS = "root";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AchievementEntity> data = getDatabaseData();
        String result = buildHtml(data);

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(result);
    }

    private List<AchievementEntity> getDatabaseData() {
        AchievementDAO achievementDAO = new AchievementDAO();
        List<AchievementEntity> data = achievementDAO.getAchievementList(
                JDBC_DRIVER, DATABASE_LINK, USER, PASS);
        return data;
    }

    private String buildHtml(List<AchievementEntity> data) {
        String result = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                getStyle() +
                "</head>\n" +
                "<body>\n" +
                getTable(data) +
                "</body>\n" +
                "</html>";
        return result;
    }

    private String getStyle() {
        String result = "<style>\n" +
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
                "</style>\n";
        return result;
    }

    private String getTable(List<AchievementEntity> data) {
        String result = "<table>\n" + getHeader();
        for (AchievementEntity line : data) {
            String col1 = "<tr>\n<td>" + line.getResourceId() + "</td>\n";
            String col2 = "<td>" + line.getResourceName() + "</td>\n";
            String col3 = "<td>" + line.getResourceDescription() + "</td>\n";
            String col4 = "<td>" + line.getGroupId() + "</td>\n";
            String col5 = "<td>" + line.getGroupName() + "</td>\n";
            String col6 = "<td>" + line.getGroupDescription() + "</td>\n</tr>\n";
            result += col1 + col2 + col3 + col4 + col5 + col6;
        }
        return result + "</table>\n";
    }

    private String getHeader() {
        String result = "<tr>\n<th>Resource Id</th>\n" +
                "<th>Resource Name</th>\n" +
                "<th>Resource Description</th>\n" +
                "<th>Group Id</th>\n" +
                "<th>Group Name</th>\n" +
                "<th>Group Description</th>\n</tr>\n";
        return result;
    }
}