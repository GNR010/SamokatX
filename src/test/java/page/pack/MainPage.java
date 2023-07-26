package page.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private static final String MAIN_URL = "https://qa-scooter.praktikum-services.ru/";

    private By accordeonList = By.className("accordion");

    private By orderButton = By.xpath(".//button[text()='Заказать']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getOrderButtons(WebDriver driver) {
        return driver.findElements(orderButton);
    }

    public WebElement getOrderTopButton(WebDriver driver) {
        return getOrderButtons(driver).get(0);
    }

    public WebElement getOrderBottomButton(WebDriver driver) {
        return getOrderButtons(driver).get(1);
    }
    public WebElement getAccordeonList() {
        return driver.findElement(accordeonList);
    }

    public String getMainUrl() {
        return MAIN_URL;
    }

    public void findAndClickQuestion(String question) {
        driver.findElement(By.xpath(".//*[text()='" + question + "']")).click();
    }

    public String findAnswerText(String question) {
        return driver.findElement(By.id(driver.findElement(By.xpath(".//*[text()='" + question + "']")).getAttribute("aria-controls"))).getText();
    }

}