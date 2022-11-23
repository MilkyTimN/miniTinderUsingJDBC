package kg.megaco.miniTinder.services.crud;

import kg.megaco.miniTinder.models.Orders;
import kg.megaco.miniTinder.services.OrderService;
import kg.megaco.miniTinder.services.impl.OrderServiceImpl;

import java.util.List;

public class ViewYourOrders {

    Checking checking = new Checking();
    OrderService orderService = new OrderServiceImpl();
    List<Orders> ordersList = null;

    public void viewYourOrders(){
        ordersList = orderService.findAllYourOrders(checking.getSignedInUser());
        ordersList.forEach(u -> System.out.println(u.getId() + ": " + u.getRecipientId()
                + "\n" + u.getSenderId() + "\n" + "----------"));
    }
}
