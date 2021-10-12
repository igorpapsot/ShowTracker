package tracker.test;

import tracker.shows.Show;

public class Main {
    public static void main(String[] args){
        Show.loadShows();
        Show.readShows();
        Show newShow = new Show(4, "Najnoviji", 100, 2017 ,20, false, 67);

        System.out.println("adding show");
        Show.addShow(newShow);
        Show.readShows();
        System.out.println("show added\n");

        System.out.println("updating show");
        Show.updateShow(3,newShow);
        Show.readShows();
        System.out.println("show updated\n");

        System.out.println("deleting show");
        Show.deleteShow(2);
        Show.readShows();
        System.out.println("show deleted\n");


    }
}
