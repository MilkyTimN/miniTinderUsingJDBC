package kg.megaco.miniTinder.uiTerminal;

import kg.megaco.miniTinder.models.Users;
import kg.megaco.miniTinder.models.enums.Gender;
import kg.megaco.miniTinder.services.UserService;
import kg.megaco.miniTinder.services.impl.UserServiceImpl;

import java.util.Arrays;
import java.util.Scanner;

public class SignUp {
    public void signUp(){
        Scanner scanner = new Scanner(System.in);
        Users users = new Users();
        UserService userService = new UserServiceImpl();

        System.out.println("Введите name");
        users.setName(scanner.next());


        System.out.println("Enter login");
        while(true) {
            String login = scanner.next();
            if (userService.findByLoginToCheckPresent(login))
                System.out.println("This login already exists");
             else
                 users.setLogin(login);
                 break;
        }

        System.out.println("Enter password");
        users.setPassword(scanner.next());

        System.out.println("Enter age");
        users.setAge(scanner.nextInt());

        System.out.println("Enter gender");
        Arrays.stream(Gender.values()).forEach(x -> System.out.println(x.ordinal() + ": " + x));
        switch (scanner.nextInt()) {
            case 1: users.setGender(Gender.MALE);
            break;
            case 2: users.setGender(Gender.FEMALE);
            break;
            case 3: users.setGender(Gender.OTHER);
            break;
        }

        System.out.println("Write something about yourself");
        users.setInfo(scanner.next());

        userService.save(users);

    }
}
