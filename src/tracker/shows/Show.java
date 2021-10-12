package tracker.shows;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Show {

    protected int id;

    protected String showName;

    protected int totalEpisodes;

    protected int totalSeasons;

    protected int releaseYear;

    protected boolean deleted;

    protected int lastWatchedEp;

    public static ArrayList<Show> showList = new ArrayList<>();


    static Path showFilePath = Paths.get("src", "tracker", "shows", "shows.txt");
    static String showsFile = showFilePath.toString();

    public Show(){
        this.id = 0;
        this.showName = "";
        this.totalEpisodes = 0;
        this.releaseYear = 0;
        this.totalSeasons = 0;
        this.deleted = false;
        this.lastWatchedEp = 0;
    }

    public Show(int id, String showName, int totalEpisodes, int releaseYear, int totalSeasons, boolean deleted, int lastWatchedEp){
        this.id = id;
        this.showName = showName;
        this.totalEpisodes = totalEpisodes;
        this.releaseYear = releaseYear;
        this.totalSeasons = totalSeasons;
        this.deleted = deleted;
        this.lastWatchedEp = lastWatchedEp;
    }

    static public void loadShows(){

        File file = new File(showsFile);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                String[] split = line.split("/");
                Show show = new Show();
                show.valueAssignment(split);
                showList.add(show);

            }
        } catch (IOException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
    }

    public static void addShow(Show show){

        File file = new File(showsFile);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("\n" + show.getId() + "/" + show.getShowName() + "/" + show.getTotalEpisodes() + "/" + show.getTotalSeasons() + "/" + show.getReleaseYear() + "/" + show.isDeleted() + "/" + show.getLastWatchedEp());
            writer.close();
            showList.add(show);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readShows(){
        for(Show show: showList){
            System.out.println(show);
        }
        System.out.println();
    }

    public static void updateShow(int id, Show targetedShow){

        File file = new File(showsFile);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(Show show : showList){
                if(show.getId() == id){
                    update(targetedShow, show);
                }
                builder.append(show.getId()).append("/").append(show.getShowName()).append("/").append(show.getTotalEpisodes()).append("/").append(show.getTotalSeasons()).append("/").append(show.getReleaseYear()).append("/").append(show.isDeleted()).append("/").append(show.getLastWatchedEp()).append("\n");
            }
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void update(Show targetedShow, Show show) {
        System.out.println("found");
        show.setDeleted(targetedShow.getDeleted());
        show.setShowName(targetedShow.getShowName());
        show.setLastWatchedEp(targetedShow.getLastWatchedEp());
        show.setReleaseYear(targetedShow.getReleaseYear());
        show.setId(targetedShow.getId());
        show.setTotalEpisodes(targetedShow.getTotalEpisodes());
        show.setTotalSeasons(targetedShow.getTotalSeasons());
    }

    public static void deleteShow(int id){

        File file = new File(showsFile);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(Show show : showList){
                if(show.getId() == id){
                    show.setDeleted(true);
                }
                builder.append(show.getId()).append("/").append(show.getShowName()).append("/").append(show.getTotalEpisodes()).append("/").append(show.getTotalSeasons()).append("/").append(show.getReleaseYear()).append("/").append(show.isDeleted()).append("/").append(show.getLastWatchedEp()).append("\n");
            }
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int getNextId(){
        int id = 1;
        for(Show show : showList){
            if(show.getId() > id){
                id = show.getId();
            }
        }
        return id + 1;
    }

    private void valueAssignment(String[] split){

        this.id = Integer.parseInt(split[0]);
        this.showName = split[1];
        this.totalEpisodes = Integer.parseInt(split[2]);
        this.releaseYear = Integer.parseInt(split[4]);
        this.totalSeasons = Integer.parseInt(split[3]);
        this.deleted = Boolean.parseBoolean(split[5]);
        this.lastWatchedEp = Integer.parseInt(split[6]);

    }

    public boolean getDeleted(){
        return deleted;
    }

    public String isDeleted() {
        if(deleted){
            return "Y";
        }
        else {
            return "N";
        }
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public static ArrayList<Show> getShowList() {
        return showList;
    }

    public static void setShowList(ArrayList<Show> showList) {
        Show.showList = showList;
    }

    public int getLastWatchedEp() {
        return lastWatchedEp;
    }

    public void setLastWatchedEp(int lastWatchedEp) {
        this.lastWatchedEp = lastWatchedEp;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", showName='" + showName + '\'' +
                ", totalEpisodes=" + totalEpisodes +
                ", totalSeasons=" + totalSeasons +
                ", releaseYear=" + releaseYear +
                ", lastWatchedEp=" + lastWatchedEp;
    }
}
