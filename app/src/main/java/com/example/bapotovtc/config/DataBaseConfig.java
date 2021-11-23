package com.example.bapotovtc.config;


import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConfig {

    private static LogManager LogManager;
    private static final Logger LOGGER;

    static {
        assert LogManager != null;
        LOGGER = LogManager.getLogger("DataBaseConfig");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        LOGGER.info("Create DB connection");
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bapoto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=FALSE", "root", "Jeremie92");


    }

    public void closeConnection(final Connection con) {
        if (con != null) {
            try {
                con.close();
                LOGGER.info("Closing DB connection");
            } catch (SQLException e) {
                LOGGER.info("Error while closing connection");
            }
        }
    }

    public void closePreparedStatement(final PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
                LOGGER.info("Closing Prepared Statement");
            } catch (SQLException e) {
                LOGGER.info("Error while closing prepared statement");
            }
        }
    }

    public void closeResultSet(final ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                LOGGER.info("Closing Result Set");
            } catch (SQLException e) {
                LOGGER.info("Error while closing result set");
            }
        }
    }


}
