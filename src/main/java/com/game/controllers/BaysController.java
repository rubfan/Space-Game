package com.game.controllers;

import com.game.model.dao.BaysDAO;
import com.game.model.entity.BayEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BaysController extends HttpServlet {
/*
Создать класс: com.game.controllers.BaysController который будет наследоваться от
HttpServlet класса и в нем заоверрайдить метод
"public doGet(HttpServletRequest req, HttpServletResponse resp)"
В этом методе вам необходимо вызвать соответствующий метод DAO класса получить данные
и вывести их с помошью PrintWriter в поток, при этом обернуть данные полученные из базы
данных в тэги HTML разметки такие как: <table>, <tr>, <th>, <td>.
(использовать пример изученный на уроке)
Сервлет должен мапится на следующую строку запроса(в браузере):
localhost:8080/api/bay/all
*/
    private BaysDAO baysDAO = new BaysDAO();
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/tempProj?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BayEntity> bays = baysDAO.getBayList(JDBC_DRIVER, DATABASE_URL, USER, PASSWORD);

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = response.getWriter();

        String tableData = "    <th>Resource_Id</th>\n" +
                          "    <th>Resource_Name</th>\n" +
                          "    <th>Resource_Description</th>\n" +
                          "    <th>Group_Id</th>\n" +
                          "    <th>Group_Name</th>\n" +
                          "    <th>Group_Description</th>\n" +
                          "    </tr>\n";

        tableData = readBayInfo(bays, tableData);

        printTable(tableData, writer);

        writer.println(request.getMethod());
        writer.println(request.getRequestURI());
        writer.println("\n" +
                "</body>\n" +
                "</html>");
    }

    private void printTable(String baysInfo, PrintWriter writer) {
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
                baysInfo +
                "</table>\n");
    }

    private String readBayInfo(List<BayEntity> bays, String baysInfo) {
        for (int i = 0; i < bays.size(); i++) {
            baysInfo += "  <tr>\n" +
                    "    <td>" + bays.get(i).getResourceId() + "</td>\n" +
                    "    <td>" + bays.get(i).getResourceName() + "</td>\n" +
                    "    <td>" + bays.get(i).getResourceDescription() + "</td>\n" +
                    "    <td>" + bays.get(i).getGroupId() + "</td>\n" +
                    "    <td>" + bays.get(i).getGroupName() + "</td>\n" +
                    "    <td>" + bays.get(i).getGroupDescription() + "</td>\n" +
                    "  </tr>\n";
        }
        return baysInfo;
    }
}
