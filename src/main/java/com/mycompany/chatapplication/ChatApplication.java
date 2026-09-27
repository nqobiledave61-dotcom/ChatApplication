package com.mycompany.chatapplication;

import java.util.Scanner;

public class ChatApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("             CHAT APPLICATION");
        System.out.println("==========================================");
        System.out.println();

        // Registration
        System.out.println("REGISTER ACCOUNT");
        System.out.println("----------------");

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your South African cell phone number: ");
        String cellPhoneNumber = scanner.nextLine();

        // Create the Login object
        Login login = new Login(
                firstName,
                lastName,
                username,
                password,
                cellPhoneNumber
        );

        System.out.println();
        System.out.println("REGISTRATION RESULT");
        System.out.println("-------------------");

        // Register the user
        String registrationMessage = login.registerUser();

        System.out.println(registrationMessage);

        // Check whether registration was successful
        if (login.checkUserName()
                && login.checkPasswordComplexity()
                && login.checkCellPhoneNumber()) {

            System.out.println();
            System.out.println("Registration successful.");
            System.out.println();

            // Login
            System.out.println("LOGIN");
            System.out.println("-----");

            System.out.print("Enter your username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = scanner.nextLine();

            // Attempt to log in
            boolean loginResult = login.loginUser(
                    loginUsername,
                    loginPassword
            );

            System.out.println();

            if (loginResult) {
                System.out.println(login.returnLoginStatus());
            } else {
                System.out.println(login.returnLoginStatus());
            }

        } else {

            System.out.println();
            System.out.println(
                    "Please correct your registration details and try again."
            );
        }

        scanner.close();
    }
}