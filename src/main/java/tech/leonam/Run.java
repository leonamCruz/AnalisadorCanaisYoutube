package tech.leonam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Run {
    private final ArrayList<String> url;
    private final ArrayList<Channel> channels;

    public Run(ArrayList<String> url) throws InterruptedException {
        this.url = url;
        channels = new ArrayList<>();
        startSearch();
        ranking();
        print();
    }

    private void startSearch() throws InterruptedException {
        for(var daVez:url){
           channels.add(new Search(daVez).urlToChannel());
        }
    }

    private void ranking() {
        for(var daVez : channels){
            var subscribers = extractSubscribers(daVez.getSubscribers());
            daVez.setSubscribers(subscribers);
        }
        Collections.sort(channels);
    }

    private void print() {
        var i = 1;
        for(var thisTime : channels){
            System.out.println("Posição em relação os inscritos: " + i);
            System.out.println("Canal: " + thisTime.getName());
            System.out.println("Inscritos: " + thisTime.getSubscribers());
            System.out.println("URL: " + thisTime.getUrl());
            System.out.println("----------------------------------------------------------");
            i++;
        }
    }

    public static String extractSubscribers(String subscribers) {
        var pattern = Pattern.compile("(\\d+([.,]\\d{1,3})?)(?:\\s*(?:mi|mil)\\s*de\\s*inscritos)?");
        var matcher = pattern.matcher(subscribers);

        if (matcher.find()) {
            var number = matcher.group(1);

            number = number.replaceAll(",", ".");
            var subscribersInNumber = Double.parseDouble(number);

            if (subscribers.contains("mil")) {
                subscribersInNumber *= 1000.0;
            }
            else if (subscribers.contains("mi")){
                subscribersInNumber *= 1000000.0;
            }

            return String.format("%.0f", subscribersInNumber);
        }

        return subscribers;
    }
}
