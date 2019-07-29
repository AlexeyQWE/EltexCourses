package eltex.tasks;

import eltex.tasks.database.tables.Address;
import eltex.tasks.database.tables.Languages;
import eltex.tasks.database.tables.Passports;
import eltex.tasks.database.tables.Users;
import eltex.tasks.database.tables.records.AddressRecord;
import eltex.tasks.database.tables.records.LanguagesRecord;
import eltex.tasks.database.tables.records.PassportsRecord;
import eltex.tasks.database.tables.records.UsersRecord;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        properties.load(fis);
        
        Connection connection = DriverManager.getConnection(properties.getProperty("db.host"),
            properties.getProperty("db.login"),
            properties.getProperty("db.password"));

        DSLContext context = DSL.using(connection, SQLDialect.MYSQL);
        
        context.insertInto(Users.USERS)
            .set(Users.USERS.ID, 10L)
            .set(Users.USERS.FIO, "Alexey Vashov")
            .set(Users.USERS.ADDRESS_ID, 21L)
            .set(Users.USERS.PASSPORT_ID, 15L)
            .execute();

        Result<UsersRecord> users1 = context.selectFrom(Users.USERS).fetch();

        for (UsersRecord user : users1)
            System.out.println(user.getFio());

        context.insertInto(Passports.PASSPORTS)
            .set(Passports.PASSPORTS.ID, 10L)
            .set(Passports.PASSPORTS.SERIES, "42 02")
             .set(Passports.PASSPORTS.NUMBER, "542011")
            .execute();

        Result<PassportsRecord> pass = context.selectFrom(Passports.PASSPORTS).fetch();

        for (PassportsRecord pas : pass)
            System.out.println(pas.getSeries());


        context.insertInto(Address.ADDRESS)
            .set(Address.ADDRESS.ID, 10L)
            .set(Address.ADDRESS.CITY, "Moscow")
            .set(Address.ADDRESS.STREET, "Tverskaya")
            .set(Address.ADDRESS.BUILDING, "45")
            .execute();

        Result<AddressRecord> addrs = context.selectFrom(eltex.tasks.database.tables.Address.ADDRESS).fetch();

        for (AddressRecord addr : addrs)
            System.out.println(addr.getCity());

         context.insertInto(Languages.LANGUAGES)
            .set(Languages.LANGUAGES.ID, 10)
            .set(Languages.LANGUAGES.TITLE, "C")
            .execute();

        Result<LanguagesRecord> lngs = context.selectFrom(Languages.LANGUAGES).fetch();

        for (LanguagesRecord lng : lngs)
            System.out.println(lng.getTitle());

        connection.close();
    }
}
