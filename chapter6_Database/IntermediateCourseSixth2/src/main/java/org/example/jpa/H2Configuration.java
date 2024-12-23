package org.example.jpa;

import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Configuration {

    private static String h2Driver = "org.h2.Driver";
    private static String h2Addr = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static String user = "";
    private static String password = "";


    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        Class.forName(h2Driver);

        connection = DriverManager.getConnection(h2Addr, user, password);

        return  connection;
    }

}
