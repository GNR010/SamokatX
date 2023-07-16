package edu.praktikum.samokat;

import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

class OrderLocators {
    static By orderButton = By.xpath(".//button[text()='Заказать']");
    static By bottomOrderButton = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");
    static By completeOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']");
    static By nextButton = By.xpath(".//button[text()='Далее']");
    static By yesButton = By.xpath(".//button[text()='Да']");
    static By showStatusButton = By.xpath(".//button[text()='Посмотреть статус']");


    static By nameField = By.xpath(".//input[@placeholder='* Имя']");
    static By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    static By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    static By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    static By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    static By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    static By timeField = By.className("Dropdown-placeholder");

    static By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
}

class OrderTestData {
    static String[][] orderTestData = {
            {"Имя", "Фамилия", "Московская 22 - 124", "Красносельская", "+79001234567", "26.07.2023", "сутки", "black", "Коммент"},
            {"Александр", "Павлов", "Пушкина 1 - 12", "Лубянка", "+79998765432", "30.07.2023", "четверо суток", "grey", "Комментарий"}
    };
}

public class pageOrder {

    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new FirefoxDriver();


    @Test
    public void testClass() {

        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPage objOrderPage = new OrderPage(driver);

        // Выполняем заказ с первым элементом массива orderTestData и локатором orderButton
        objOrderPage.orderStages(OrderTestData.orderTestData[0], OrderLocators.orderButton);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(OrderLocators.bottomOrderButton));

        // Выполняем заказ со вторым элементом массива orderTestData и локатором bottomOrderButton
        objOrderPage.orderStages(OrderTestData.orderTestData[1], OrderLocators.bottomOrderButton);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

// Класс страницы заказа
class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }



    public void setName(String name) {
        driver.findElement(OrderLocators.nameField).sendKeys(name);
    }
    public void setSurname(String surname) {
        driver.findElement(OrderLocators.surnameField).sendKeys(surname);
    }
    public void setAddress(String address) {
        driver.findElement(OrderLocators.addressField).sendKeys(address);
    }
    public void setMetro(String metro) {
        driver.findElement(OrderLocators.metroField).sendKeys(metro);
        driver.findElement(By.xpath(".//*[text()='" + metro + "']")).click();
    }
    public void setPhone(String phone) {
        driver.findElement(OrderLocators.phoneField).sendKeys(phone);
    }
    public void setDate(String date) {
        driver.findElement(OrderLocators.dateField).sendKeys(date);
    }
    public void setTime(String time) {

        driver.findElement(OrderLocators.timeField).click();
        driver.findElement(By.xpath(".//*[text()='" + time + "']")).click();

    }
    public void clickColor(String color) {
        driver.findElement(By.id(color)).click();
    }
    public void setComment(String comment) {
        driver.findElement(OrderLocators.commentField).sendKeys(comment);
    }

    public void clickButton(By button) {
        driver.findElement(button).click();
    }

    public void waitForLoadButton() {
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void orderStages(String[] orderTestData, By orderButtonLocator ){
        clickButton(orderButtonLocator);
        waitForLoadButton();

        setName(orderTestData[0]);
        setSurname(orderTestData[1]);
        setAddress(orderTestData[2]);
        setMetro(orderTestData[3]);
        setPhone(orderTestData[4]);

        clickButton(OrderLocators.nextButton);
        waitForLoadButton();

        setTime(orderTestData[6]);
        clickColor(orderTestData[7]);
        setComment(orderTestData[8]);
        setDate(orderTestData[5]);

        clickButton(OrderLocators.completeOrderButton);
        clickButton(OrderLocators.yesButton);

        assertEquals("Заказ не удался", "Посмотреть статус", driver.findElement(OrderLocators.showStatusButton).getText());

    }
}
