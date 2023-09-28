package tech.leonam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {
    private static final String X_PATH_NOME = "//*[@id=\"text\"]";
    private static final String X_PATH_INSCRITOS = "//*[@id=\"subscriber-count\"]";
    private final WebDriver driver;
    private final String url;
    public Search(String url){
        driver = SeleniumConfig.config();
        this.url = url;
    }

    public Channel urlToChannel() throws InterruptedException {
        var channel = new Channel();

        driver.get(url);
        Thread.sleep(450);
        var name = "";
        var subscriber = "";
        try {
            name = driver.findElement(By.xpath(X_PATH_NOME)).getText();
            subscriber = driver.findElement(By.xpath(X_PATH_INSCRITOS)).getText();
        }catch (Exception e){
            name = "Não foi possivel localizar";
            subscriber = "Não foi possivel localizar";
        }

        channel.setName(name);
        channel.setSubscribers(subscriber);
        channel.setUrl(url);

        return channel;
    }
}