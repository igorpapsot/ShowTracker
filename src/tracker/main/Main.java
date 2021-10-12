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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter show id of targeted show: ");
        int choice = sc.nextInt();
        Show.deleteShow(choice);
        System.out.println("Show " + choice + " deleted\n");
    }

    private static void showUpdater(){
        Scanner sc = new Scanner(System.in);
        Show show = new Show();

        System.out.println("Enter id: ");
        String id = sc.nextLine();
        show.setId(Integer.parseInt(id));

        System.out.println("Enter show name: ");
        String name = sc.nextLine();
        show.setShowName(name);

        System.out.println("Enter number of episodes: ");
        String allEps = sc.nextLine();
        show.setTotalEpisodes(Integer.parseInt(allEps));

        System.out.println("Enter number of seasons: ");
        String seasons = sc.nextLine();
        show.setTotalSeasons(Integer.parseInt(seasons));

        System.out.println("Enter release year: ");
        String year = sc.nextLine();
        show.setReleaseYear(Integer.parseInt(year));

        System.out.println("Enter current episode: ");
        String ep = sc.nextLine();
        show.setLastWatchedEp(Integer.parseInt(ep));

        show.setDeleted(false);
        Show.updateShow(Integer.parseInt(id),show);

    }

    private static  void episodeUpdater(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = sc.nextInt();

        System.out.println("Enter current episode: ");
        int ep = sc.nextInt();
        Show.updateCurrentEp(id,ep);
    }




}
