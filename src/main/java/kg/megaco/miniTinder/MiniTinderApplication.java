package kg.megaco.miniTinder;

import kg.megaco.miniTinder.models.Users;
import kg.megaco.miniTinder.uiTerminal.SignIn;
import kg.megaco.miniTinder.uiTerminal.SignUp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

public class MiniTinderApplication {
	static Users mainUsers = null;

	public static Users getMainUsers (){
		return mainUsers;
	}

	public static void setMainUsers(Users mainUsers) {
		MiniTinderApplication.mainUsers = mainUsers;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		SignUp signUp = new SignUp();
		SignIn signIn = new SignIn();
		System.out.println("Welcome to Mini Tinder!");


		while (true) {

			System.out.println("Select action");
			System.out.println("1: Sign in");
			System.out.println("2: Sign up");
			switch (scanner.nextInt()) {
				case 1:
					signIn.signIn();
					break;
				case 2:
					signUp.signUp();
					break;
			}
		}

	}
}
