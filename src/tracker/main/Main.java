package tracker.main;

import tracker.shows.Show;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Show.loadShows();

        System.out.println("Shows: ");
        Show.readShows();
        System.out.println();

        printMenuOtpions();
        menuOptionScanner();
    }

    private static void printMenuOtpions() {
        System.out.println("1 - Add show ");
        System.out.println("2 - Update show");
        System.out.println("3 - Delete show");
        System.out.println("4 - Exit\n");
    }

    private static void menuOptionScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your choice: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println(option);
                break;
            case 2:
                System.out.println(option);
                break;
            case 3:
                System.out.println(option);
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
        }
    }

    private static void showAdder(){

    }

    private static void showDeleter(){

    }

    private static void show(){

    }



}
