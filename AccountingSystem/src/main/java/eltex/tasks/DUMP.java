package eltex.tasks;

import java.sql.*;

public class DUMP {

    private static final String DB_URL = "host";

    public static void toMySQL(Developer [] dev, Manager [] mng) throws SQLException {

        Connection connection = null;
        Statement statement = null;

        long startTime = System.nanoTime();
       try {
            connection = DriverManager.getConnection(DB_URL, "login", "password");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
           // statement.execute("CREATE TABLE developer (id Integer(100), fio varchar(50), phone varchar(12), email varchar(50), language varchar(50))");

           for (int j = 0; j < 1001; ++j) {
            for (int i = 0; i < 3; ++i) {
                statement.executeUpdate("INSERT INTO developer VALUES (" + dev[i].getId() + ", '" + dev[i].getFio() + "', '" + dev[i].getPhone() + "', '"
                         + dev[i].getEmail()+ "', '" + dev[i].getLang() + "')");
            }}
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.out.println(e.getMessage());
        }
        long stopTime = System.nanoTime();
        System.out.println("Commit "+ (stopTime - startTime) *  1e-9 + ".sec");

        startTime = System.nanoTime();
        try {
            connection = DriverManager.getConnection(DB_URL, "login", "password");
            //connection.setAutoCommit(false);
            statement = connection.createStatement();
           // statement.execute("CREATE TABLE manager (id Integer(100), fio varchar(50), phone varchar(12), email varchar(50), title varchar(50), price varchar(50))");
            for (int j = 0; j < 1001; ++j) {
            for (int i = 0; i < 3; ++i) {
                statement.executeUpdate("INSERT INTO manager VALUES (" + mng[i].getId() + ", '" + mng[i].getFio() + "', '" + mng[i].getPhone() + "', '"
                        + mng[i].getEmail() +"' ,'" + mng[i].getTitle() + "', '" + mng[i].getPrice() + "')");
            }}
           // connection.commit();
            connection.close();
        } catch (SQLException e) {
           // connection.rollback();
            System.out.println(e.getMessage());
        }
        stopTime = System.nanoTime();
        System.out.println("NoCommit "+ (stopTime - startTime) *  1e-9 + ".sec");
    }

    public static void fromMySQL(Developer [] dev, Manager [] mng) throws SQLException {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, "login", "password");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM developer");
            resultSet.next();
            for (int i = 0; i < 3; ++i, resultSet.next()) {
                dev[i].setId(resultSet.getString("id"));
                dev[i].setFio(resultSet.getString("fio"));
                dev[i].setPhone(resultSet.getString("phone"));
                dev[i].setEmail(resultSet.getString("email"));
                String str = resultSet.getString("language");
                String [] arg = str.split(";");
                
                for (int j = 0; j < 3; ++j)      
                    dev[i].setLang(arg[j], j);
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.out.println(e.getMessage());
        }

       try {
            connection = DriverManager.getConnection(DB_URL, "login", "password");
             connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM manager");
           resultSet.next();
           for (int i = 0; i < 3; ++i, resultSet.next()) {
                mng[i].setId(resultSet.getString("id"));
                mng[i].setFio(resultSet.getString("fio"));
                mng[i].setPhone(resultSet.getString("phone"));
                mng[i].setEmail(resultSet.getString("email"));
                String str = resultSet.getString("title");
                String str1 = resultSet.getString("price");
                String [] arg = str.split(";");
                String [] arg1 = str1.split(";");
                
                for (int j = 0; j < 3; ++j) {      
                    mng[i].setTitle(arg[j], j);
                    mng[i].setPrice(arg1[j], j);
                }
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
           connection.rollback();
            System.out.println(e.getMessage());
        }
    }
}
