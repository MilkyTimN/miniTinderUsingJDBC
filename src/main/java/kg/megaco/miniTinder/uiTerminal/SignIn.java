package kg.megaco.miniTinder.uiTerminal;

import kg.megaco.miniTinder.models.Users;
import kg.megaco.miniTinder.services.UserService;
import kg.megaco.miniTinder.services.crud.*;
import kg.megaco.miniTinder.services.impl.UserServiceImpl;

import java.util.Scanner;

public class SignIn {
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserServiceImpl();
    Users users = new Users();
    Checking checking = new Checking();
    CreateOrder createOrder = new CreateOrder();
    private Boolean active = true;
    ViewMatch viewMatch = new ViewMatch();
    ViewYourOrders viewYourOrders = new ViewYourOrders();
    ViewOrdersToYou viewOrdersToYou = new ViewOrdersToYou();

    public void signIn(){

        while(true) {
            System.out.println("Enter login");
            String login = scanner.next();
            System.out.println("Enter password");
            String password = scanner.next();
            if (userService.findByLoginToSignIn(login, password)) {
                System.out.println("You signed in successfully");
               // System.out.println("Welcome " + checking.getSignedInUser().getName());
                System.out.println("Welcome");
                break;
            } else {
                System.out.println("Incorrect data");
            }
        }

        while (active){
            System.out.println("Choose action:");
            System.out.println("1: View your orders");
            System.out.println("2: View orders to you");
            System.out.println("3: View match");
            System.out.println("4: Make new order");
            System.out.println("5: Sign out");
            switch (scanner.nextInt()){
                case 1:
                    viewYourOrders.viewYourOrders();
                    break;
                case 2:
                    viewOrdersToYou.viewYourOrders();
                    break;
                case 3:
                    viewMatch.viewMatch();
                    break;
                case 4:
                    createOrder.makeNewOrder();
                    break;
                case 5: {
                    checking.setSignedInUserNull();
                    createOrder.setOrderNull();
                    createOrder.setSameOrderNull();
                    System.out.println("See you");
                    active = false;
                    break;
                }
            }
        }
    }
}
