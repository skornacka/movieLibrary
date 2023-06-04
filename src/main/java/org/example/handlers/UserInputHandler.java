package org.example.handlers;

import org.example.models.Actor;

import java.util.Scanner;

public class UserInputHandler {
    private static Scanner scanner = new(System.in);

    public static MenuOptions getMenuOptionFromUser(){
        return MenuOptions.values()[getSelectedOptionFromUser()-1];

    }

    private static int getSelectedOptionFromUser() {
        int result = getIntegerFromUser();
        scanner.nextLine();
        if(result>0 && result<MenuOptions.values().length + 1)
        {
            return result;
        }
        else {
            System.out.println("You selectes non existing option " + result);
            System.out.println("Please try again");
            return getSelectedOptionFromUser();
        }
    }

    private static int getIntegerFromUser() {
        while (!scanner.hasNext()){
            scanner.nextLine();
            System.out.println("It is not integar, try again");
        }
        return scanner.nextInt();
    }
    public static Actor getActorFromUser(){
        System.out.println("Enter actor name");
        String[] s = scanner.nextLine().split(" ");
        return new Actor(s[0],s[1]);
    }
}
