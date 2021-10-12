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
        System.out.println("1 - Add show");
        System.out.println("2 - Update show");
        System.out.println("3 - Delete show");
        System.out.println("4 - Update current ep");
        System.out.println("5 - Read shows");
        System.out.println("6 - Exit\n");
    }

    private static void menuOptionScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input your choice: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                showAdder();
                printMenuOtpions();
                menuOptionScanner();
                break;
            case 2:
                showUpdater();
                printMenuOtpions();
                menuOptionScanner();
                break;
            case 3:
                showDeleter();
                printMenuOtpions();
                menuOptionScanner();
                break;
            case 4:
                episodeUpdater();
                printMenuOtpions();
                menuOptionScanner();
                break;
            case 5:
                Show.readShows();
                printMenuOtpions();
                menuOptionScanner();
                break;
            case 6:
                System.out.println("Exiting...");
                System.exit(0);
                break;
        }
        sc.close();
    }


    private static void showAdder(){
        Scanner sc = new Scanner(System.in);
        Show show = new Show();

        show.setId(Show.getNextId());

        System.out.println("Enter show name: ");
        String name = sc.nextLine();
        show.setShowName(name);

        System.out.println("Enter total episodes: ");
        String totalEp = sc.nextLine();
        show.setTotalEpisodes(Integer.parseInt(totalEp));

        System.out.println("Enter total seasons: ");
        String totalSeasons = sc.nextLine();
        show.setTotalSeasons(Integer.parseInt(totalSeasons));

        System.out.println("Enter release year: ");
        String releaseYear = sc.nextLine();
        show.setReleaseYear(Integer.parseInt(releaseYear));

        show.setDeleted(false);
        Show.addShow(show);
        System.out.println("Added " + show.getShowName());
        System.out.println();
    }

    private static void showDeleter(){

    }

    private static void showUpdater(){

    }

    private static  void episodeUpdater(){

    }




}
