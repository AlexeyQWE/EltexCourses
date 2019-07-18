package eltex.tasks;

import java.sql.*;

public class ExecuteQuery {

    private static final String DB_URL = "host";

    public static void main(String[] args) {

        String id = null, fio = null, phone = null;

        try {
            Connection connection = DriverManager.getConnection(DB_URL, "root", "NOT_A_PASSWORD_ACTUALLY");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO developer VALUES (4, 'Ramus', '+79521529085')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM developer");

            while (resultSet.next()) {
                id = resultSet.getString("id");
                fio = resultSet.getString("fio");
                phone = resultSet.getString("phone");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("id: " + id);
        System.out.println("fio: " + fio);
        System.out.println("phone " + phone);
    }
}
