package eltex.tasks;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DUMP {

    public static void toMySQL(Developer[] dev, Manager[] mng) throws SQLException, IOException {

        Connection connection = null;
        Statement statement = null;

        Properties pr = new Properties();

        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        pr.load(fis);

        String host = pr.getProperty("db.host");
        String login = pr.getProperty("db.login");
        String password = pr.getProperty("db.password");

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE developer (id Integer(100), fio varchar(50), phone varchar(12), email varchar(50))");

            for (int i = 0; i < 3; ++i) {
                statement.executeUpdate("INSERT INTO developer VALUES (" + dev[i].getId() + ", '" + dev[i].getFio() + "', '" + dev[i].getPhone() + "', '"
                        + dev[i].getEmail() +  "')");
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE manager (id Integer(100), fio varchar(50), phone varchar(12), email varchar(50))");

            for (int i = 0; i < 3; ++i) {
                statement.executeUpdate("INSERT INTO manager VALUES (" + mng[i].getId() + ", '" + mng[i].getFio() + "', '" + mng[i].getPhone() + "', '"
                        + mng[i].getEmail() +  "')");
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE languages (id Integer(100), language varchar(50))");
            connection.commit();

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    statement.executeUpdate("INSERT INTO languages VALUES (" + dev[i].getLangId(j) + ", '" + dev[i].getLangTitle(j) + "')");
                }
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE id_lang_dev (id Integer(100), id_dev Integer(100), id_lang Integer(100))");

            int k = 1;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    statement.executeUpdate("INSERT INTO id_lang_dev VALUES ("+ k +", "+ dev[i].getId() + ", " +  dev[i].getLangId(j) + ")");
                    ++k;
                }
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE sales (id Integer(100), title varchar(50), price varchar(50))");
            connection.commit();

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    statement.executeUpdate("INSERT INTO sales VALUES (" + mng[i].getSaleId(j) + ", '" + mng[i].getTitle(j) +"', '" + mng[i].getPrice(j) + "')");
                }
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.execute("CREATE TABLE id_sale_mng (id Integer(100), id_mng Integer(100), id_sale Integer(100))");

            int k = 1;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    statement.executeUpdate("INSERT INTO id_sale_mng VALUES ("+ k +", "+ mng[i].getId() + ", " +  mng[i].getSaleId(j) + ")");
                    ++k;
                }
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }
    }

    public static void fromMySQL(Developer[] dev, Manager[] mng) throws SQLException, IOException {

        Connection connection = null;
        Statement statement = null;

        Properties pr = new Properties();

        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        pr.load(fis);

        String host = pr.getProperty("db.host");
        String login = pr.getProperty("db.login");
        String password = pr.getProperty("db.password");

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM developer");
            resultSet.next();

            for (int i = 0; i < 3; ++i, resultSet.next()) {
                dev[i].setId(resultSet.getInt("id"));
                dev[i].setFio(resultSet.getString("fio"));
                dev[i].setPhone(resultSet.getString("phone"));
                dev[i].setEmail(resultSet.getString("email"));
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM languages");
            resultSet.next();

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j, resultSet.next()) {
                    dev[i].setLangId(resultSet.getInt("id"), j);
                    dev[i].setLangTitle(resultSet.getString("language"), j);
                }
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM manager");
            resultSet.next();

            for (int i = 0; i < 3; ++i, resultSet.next()) {
                mng[i].setId(resultSet.getInt("id"));
                mng[i].setFio(resultSet.getString("fio"));
                mng[i].setPhone(resultSet.getString("phone"));
                mng[i].setEmail(resultSet.getString("email"));
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(host, login, password);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sales");
            resultSet.next();

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j, resultSet.next()) {
                    mng[i].setSaleId(resultSet.getInt("id"), j);
                    mng[i].setTitle(resultSet.getString("title"), j);
                    mng[i].setPrice(resultSet.getString("price"), j);
                }
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        }
    }

    public static void UNION() throws IOException {

        Properties pr = new Properties();

        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        pr.load(fis);
        
        String host = pr.getProperty("db.host");
        String login = pr.getProperty("db.login");
        String password = pr.getProperty("db.password");


        try {
            Connection connection = DriverManager.getConnection(host, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, fio, phone from developer union select id, fio, phone from manager");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                System.out.println("id - " + id);
                String fio = resultSet.getString("fio");
                System.out.println("fio - " + fio);
                String phone = resultSet.getString("phone");
                System.out.println("phone - " + phone + '\n');
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
