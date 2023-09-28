package tech.leonam;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Run(new ArrayList<>(Arrays.asList(List.urls)));
        SeleniumConfig.config().close();
    }
}