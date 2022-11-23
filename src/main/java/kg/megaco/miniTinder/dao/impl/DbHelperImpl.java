package kg.megaco.miniTinder.dao.impl;

import kg.megaco.miniTinder.dao.DbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHelperImpl implements DbHelper {
    @Override
    public PreparedStatement getPrepareStatement(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mini_tinder_db",
                "postgres", "1006");

        return connection.prepareStatement(sql);
    }
}
