package kg.megaco.miniTinder.services.crud;

import kg.megaco.miniTinder.models.Orders;
import kg.megaco.miniTinder.models.Users;
import kg.megaco.miniTinder.services.OrderService;
import kg.megaco.miniTinder.services.UserService;
import kg.megaco.miniTinder.services.impl.OrderServiceImpl;
import kg.megaco.miniTinder.services.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateOrder {
    Checking checking = new Checking();
    Scanner scanner = new Scanner(System.in);
    Orders orders = new Orders();
    UserService userService = new UserServiceImpl();
    List<Users> usersList = null;
    Users recipientUser = null;
    OrderService orderService = new OrderServiceImpl();
    Orders sameOrder = null;

    public void setSameOrderNull() {
        sameOrder =null;
    }
    public void setOrderNull(){
        orders = null;
    }

    public void makeNewOrder(){
        System.out.println("Choose user id to send order");
        switch (checking.getSignedInUser().getGender()) {
            case FEMALE: usersList = userService.findAllMaleUsers();
            break;
            case MALE: usersList = userService.findAllFemaleUsers();
            break;
            case OTHER: usersList = userService.findAllOtherUsers();
        }
        usersList.forEach(u -> System.out.println(u.getId() + ": "
                + u.getName() + "| age: " + u.getAge() + "\n" + u.getInfo() + "\n" + "----------"));

        orders.setSenderId(checking.getSignedInUser());
        orders.setRecipientId(userService.findById(scanner.nextLong()));
        recipientUser = orders.getRecipientId();
        orders.setMessage(scanner.next());
        sameOrder = orderService.findBySenderId(checking.getSignedInUser(), recipientUser);
        if (sameOrder.getId() != 0) {
            orderService.update(sameOrder);
            System.out.println("You have match!");
        } else {
            orderService.save(orders);
            System.out.println("Your order delivered");
        }


    }
}
