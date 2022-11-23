package kg.megaco.miniTinder.dao.exception;

public class SqlException extends RuntimeException{
    public SqlException(String message) {
        super(message);
    }
}
