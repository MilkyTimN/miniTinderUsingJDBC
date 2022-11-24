package kg.megaco.miniTinder.services.crud;

import kg.megaco.miniTinder.MiniTinderApplication;
import kg.megaco.miniTinder.models.Orders;
import kg.megaco.miniTinder.services.OrderService;
import kg.megaco.miniTinder.services.impl.OrderServiceImpl;

import java.util.List;

public class ViewMatch {

    Checking checking = new Checking();
    OrderService orderService = new OrderServiceImpl();
    List<Orders> ordersList = null;

    public void viewMatch(){
        ordersList = orderService.findAllWhereIsMatch(MiniTinderApplication.getMainUsers());

        for (Orders o: ordersList) {
            if(o.getRecipientId().getId() == MiniTinderApplication.getMainUsers().getId()){
                System.out.println("Order id: " + o.getId().toString() + "\n" + o.getSenderId());
            } else {
                System.out.println("Order id: " + o.getId().toString() + "\n" + o.getRecipientId());
            }
        }

    }
}
