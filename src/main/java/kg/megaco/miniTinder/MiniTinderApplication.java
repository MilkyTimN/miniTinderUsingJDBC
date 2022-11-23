package kg.megaco.miniTinder;

import kg.megaco.miniTinder.uiTerminal.SignUp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

public class MiniTinderApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SignUp signUp = new SignUp();
		System.out.println("Welcome to Mini Tinder!");

		while (true) {

			System.out.println("Select action");
			System.out.println("1: Sign in");
			System.out.println("2: Sign up");
			switch (scanner.nextInt()) {
				case 1:
					break;
				case 2:
					signUp.signUp();
					break;
			}
		}

	}
}
