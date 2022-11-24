package kg.megaco.miniTinder.services;

import kg.megaco.miniTinder.models.Orders;
import kg.megaco.miniTinder.models.Users;

import java.util.List;

public interface OrderService {
    void save(Orders order);
    void update(Orders order);
    List<Orders> findAll();
    Orders findById(Long id);
    Orders findBySenderId(Users senderId, Users recipientId);
    List<Orders> findAllWhereIsMatch(Users users);
    List<Orders> findAllYourOrders(Users users);
    List<Orders> findAllOrdersToYou(Users users);
}
