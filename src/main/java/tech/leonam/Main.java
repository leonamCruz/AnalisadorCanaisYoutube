package tech.leonam;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var list = new ArrayList<String>();
        list.add("https://www.youtube.com/channel/UCnOZBkQgiuOmWBFCQ9GdTrQ");
        list.add("https://www.youtube.com/@PontoemComum");
        list.add("https://www.youtube.com/@GMKrikor");
        list.add("https://www.youtube.com/@AguiarDev91");
        list.add("https://www.youtube.com/@nabishev_ahmad");
        list.add("https://www.youtube.com/@Aleatoriamente1");
        list.add("https://www.youtube.com/@Aquelescanaldecasaletc");
        list.add("https://www.youtube.com/@AtilaIamarino");
        list.add("https://www.youtube.com/@attekitadev");
        new Run(list);
        SeleniumConfig.config().close();
    }
}