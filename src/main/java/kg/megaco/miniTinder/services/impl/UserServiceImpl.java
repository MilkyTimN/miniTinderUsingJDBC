package kg.megaco.miniTinder.services.impl;

import kg.megaco.miniTinder.dao.DbHelper;
import kg.megaco.miniTinder.dao.exception.SqlException;
import kg.megaco.miniTinder.dao.impl.DbHelperImpl;
import kg.megaco.miniTinder.models.Users;
import kg.megaco.miniTinder.models.enums.Gender;
import kg.megaco.miniTinder.services.UserService;
import kg.megaco.miniTinder.services.crud.Checking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    DbHelper dbHelper = new DbHelperImpl();
    Checking checking = new Checking();

    @Override
    public void save(Users users) {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("INSERT INTO tb_users (name, login, password, gender, info, age) VALUES (?,?,?,?,?,?)")) {

            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getLogin());
            preparedStatement.setString(3, users.getPassword());
            preparedStatement.setString(4, users.getGender().toString());
            preparedStatement.setString(5, users.getInfo());
            preparedStatement.setInt(6, users.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to save user");
        }

    }

    @Override
    public void update(Users users) {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("UPDATE tb_users SET(name, login, password, id_tb_shop) VALUES (?,?,?,?)")) {

            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getLogin());
            preparedStatement.setString(3, users.getPassword());
            preparedStatement.setString(4, users.getGender().toString());
            preparedStatement.setString(5, users.getInfo());
            preparedStatement.setInt(6, users.getAge());
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            throw new SqlException("Error to update user");
        }
    }

    @Override
    public List<Users> findAll() {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_users")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            return addUsersToList(resultSet);

        } catch (SQLException e) {
            throw new SqlException("Error to find all users");
        }
    }

    @Override
    public Users findById(Long id) {
        try (PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_users WHERE id =?")){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Users user = new Users();
            while (resultSet.next()){

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                user.setInfo(resultSet.getString("info"));
                user.setGender(Gender.valueOf(resultSet.getString("gender")));
            } return user;

        } catch (SQLException e) {
            throw new SqlException("Error to find users by id");
        }
    }

    @Override
    public Boolean findByLoginToCheckPresent(String login) {
        try (PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_users WHERE login =?")) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            Users user = new Users();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                user.setInfo(resultSet.getString("info"));
                user.setGender(Gender.valueOf(resultSet.getString("gender")));
            }

            return checking.checkForUniqueLogin(user);

        } catch (SQLException e) {
            throw new SqlException("Error");
        }
    }

    @Override
    public Boolean findByLoginToSignIn(String login, String password) {
        try (PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_users WHERE login =?")) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            Users user = new Users();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                user.setInfo(resultSet.getString("info"));
                user.setGender(Gender.valueOf(resultSet.getString("gender")));
            }

            return checking.checkForUsersLoginAndPassword(user, login, password);

        } catch (SQLException e) {
            throw new SqlException("Error");
        }
    }

    @Override
    public List<Users> findAllFemaleUsers() {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_users WHERE gender =?")) {
            preparedStatement.setString(1, "FEMALE");
            ResultSet resultSet = preparedStatement.executeQuery();

            return addUsersToList(resultSet);

        } catch (SQLException e) {
            throw new SqlException("Error to find all users");
        }
    }

    @Override
    public List<Users> findAllMaleUsers() {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_users WHERE gender =?")) {
            preparedStatement.setString(1, "MALE");
            ResultSet resultSet = preparedStatement.executeQuery();

            return addUsersToList(resultSet);

        } catch (SQLException e) {
            throw new SqlException("Error to find all users");
        }
    }

    @Override
    public List<Users> findAllOtherUsers() {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_users WHERE gender =?")) {
            preparedStatement.setString(1, "OTHER");
            ResultSet resultSet = preparedStatement.executeQuery();

            return addUsersToList(resultSet);

        } catch (SQLException e) {
            throw new SqlException("Error to find all users");
        }
    }

    public List<Users> addUsersToList(ResultSet resultSet) throws SQLException {
        List<Users> usersList = new ArrayList<>();
        while (resultSet.next()){
            Users user = new Users();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getInt("age"));
            user.setInfo(resultSet.getString("info"));
            user.setGender(Gender.valueOf(resultSet.getString("gender")));

            usersList.add(user);
        } return usersList;
    }
}
