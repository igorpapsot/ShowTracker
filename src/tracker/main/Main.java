package tracker.main;

import tracker.shows.Show;

public class Main {
    public static void main(String[] args){
        Show.loadShows();
        Show.readShows();
        Show newShow = new Show(4, "Najnoviji", 100, 2017 ,20, false);

        //Show.addShow(newShow);
        //Show.updateShow(3,newShow);
        //Show.deleteShow(2);
        //Show.readShows();
    }
}
