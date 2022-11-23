package kg.megaco.miniTinder.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DbHelper {
    PreparedStatement getPrepareStatement(String sql) throws SQLException;
}
