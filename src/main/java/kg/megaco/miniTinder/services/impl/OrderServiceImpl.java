package kg.megaco.miniTinder.services.impl;

import kg.megaco.miniTinder.dao.DbHelper;
import kg.megaco.miniTinder.dao.exception.SqlException;
import kg.megaco.miniTinder.dao.impl.DbHelperImpl;
import kg.megaco.miniTinder.models.Orders;
import kg.megaco.miniTinder.models.Users;
import kg.megaco.miniTinder.models.enums.Gender;
import kg.megaco.miniTinder.services.OrderService;
import kg.megaco.miniTinder.services.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    DbHelper dbHelper = new DbHelperImpl();
    UserService userService = new UserServiceImpl();

    @Override
    public void save(Orders order) {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("INSERT INTO tb_orders (sender_id, recipient_id, message, match) VALUES (?,?,?,?)")) {

            preparedStatement.setLong(1, order.getSenderId().getId());
            preparedStatement.setLong(2, order.getRecipientId().getId());
            preparedStatement.setString(3, order.getMessage());
            preparedStatement.setBoolean(4, false);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to save order");
        }
    }

    @Override
    public void update(Orders order) {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("UPDATE tb_orders SET match =? WHERE id =?")) {

            preparedStatement.setBoolean(1, true);
            preparedStatement.setLong(2, order.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new SqlException("Error to update order");
        }
    }

    @Override
    public List<Orders> findAll() {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_orders")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Orders> ordersList = new ArrayList<>();
            while (resultSet.next()){
                Orders order = new Orders();
                order.setId(resultSet.getLong("id"));
                order.setSenderId(userService.findById(resultSet.getLong("id")));
                order.setRecipientId(userService.findById(resultSet.getLong("id")));
                order.setMessage(resultSet.getString("message"));
                order.setMatch(resultSet.getBoolean("match"));

                ordersList.add(order);
            } return ordersList;

        } catch (SQLException e) {
            throw new SqlException("Error to find all orders");
        }
    }

    @Override
    public Orders findById(Long id) {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_orders WHERE id =?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Orders order = new Orders();
            while (resultSet.next()){

                order.setId(resultSet.getLong("id"));
                order.setSenderId(userService.findById(resultSet.getLong("id")));
                order.setRecipientId(userService.findById(resultSet.getLong("id")));
                order.setMessage(resultSet.getString("message"));
                order.setMatch(resultSet.getBoolean("match"));

            } return order;

        } catch (SQLException e) {
            throw new SqlException("Error to find all orders");
        }
    }

    @Override
    public Orders findBySenderId(Users senderId, Users recipientId) {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_orders WHERE sender_id =? AND recipient_id =?")) {
            preparedStatement.setLong(1, recipientId.getId());
            preparedStatement.setLong(2, senderId.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            Orders order = new Orders();
            while (resultSet.next()){

                order.setId(resultSet.getLong("id"));
                order.setSenderId(userService.findById(resultSet.getLong("sender_id")));
                order.setRecipientId(userService.findById(resultSet.getLong("recipient_id")));
                order.setMessage(resultSet.getString("message"));
                order.setMatch(resultSet.getBoolean("match"));

            } return order;

        } catch (SQLException e) {
            throw new SqlException("Error to find all orders");
        }
    }

    @Override
    public List<Orders> findAllWhereIsMatch(Users users) {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_orders WHERE (sender_id =? OR recipient_id =?) AND match =?")) {
            preparedStatement.setLong(1, users.getId());
            preparedStatement.setLong(2, users.getId());
            preparedStatement.setBoolean(3, true);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Orders> ordersList = new ArrayList<>();
            while (resultSet.next()){
                Orders order = new Orders();
                order.setId(resultSet.getLong("id"));
                order.setSenderId(userService.findById(resultSet.getLong("sender_id")));
                order.setRecipientId(userService.findById(resultSet.getLong("recipient_id")));
                order.setMessage(resultSet.getString("message"));
                order.setMatch(resultSet.getBoolean("match"));

                ordersList.add(order);
            } return ordersList;

        } catch (SQLException e) {
            throw new SqlException("Error to find all orders");
        }
    }

    @Override
    public List<Orders> findAllYourOrders(Users users) {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_orders WHERE sender_id =?  AND match =?")) {
            preparedStatement.setLong(1, users.getId());
            preparedStatement.setBoolean(2, false);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Orders> ordersList = new ArrayList<>();
            while (resultSet.next()){
                Orders order = new Orders();
                order.setId(resultSet.getLong("id"));
                order.setSenderId(userService.findById(resultSet.getLong("sender_id")));
                order.setRecipientId(userService.findById(resultSet.getLong("recipient_id")));
                order.setMessage(resultSet.getString("message"));
                order.setMatch(resultSet.getBoolean("match"));

                ordersList.add(order);
            } return ordersList;

        } catch (SQLException e) {
            throw new SqlException("Error to find all orders");
        }
    }

    @Override
    public List<Orders> findAllOrdersToYou(Users users) {
        try(PreparedStatement preparedStatement = dbHelper.getPrepareStatement
                ("SELECT * FROM tb_orders WHERE recipient_id =? AND match =?")) {
            preparedStatement.setLong(1, users.getId());
            preparedStatement.setBoolean(2, false);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Orders> ordersList = new ArrayList<>();
            while (resultSet.next()){
                Orders order = new Orders();
                order.setId(resultSet.getLong("id"));
                order.setSenderId(userService.findById(resultSet.getLong("sender_id")));
                order.setRecipientId(userService.findById(resultSet.getLong("recipient_id")));
                order.setMessage(resultSet.getString("message"));
                order.setMatch(resultSet.getBoolean("match"));

                ordersList.add(order);
            } return ordersList;

        } catch (SQLException e) {
            throw new SqlException("Error to find all orders");
        }
    }
}
