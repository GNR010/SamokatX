package page.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private static final String mainUrl = "https://qa-scooter.praktikum-services.ru/";

    private By accordeonList = By.className("accordion");


    public WebElement getAccordeonList() {
        return driver.findElement(accordeonList);
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void findAndClickQuestion(String question) {
        driver.findElement(By.xpath(".//*[text()='" + question + "']")).click();
    }

    public String findAnswerText(String question) {
        return driver.findElement(By.id(driver.findElement(By.xpath(".//*[text()='" + question + "']")).getAttribute("aria-controls"))).getText();
    }


}