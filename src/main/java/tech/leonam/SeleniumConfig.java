package tech.leonam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumConfig {
    private static WebDriver driver;

    private SeleniumConfig(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }

    public static WebDriver config(){
        if(driver == null){
            new SeleniumConfig();
        }
        return driver;
    }
}
