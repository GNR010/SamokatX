package edu.praktikum.samokat;

import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)
public class TestClass {

    private final String  name;
    private final String  surname;
    private final String  address;
    private final String  metro;
    private final String  phone;
    private final String date;
    private final String time;
    private final String color;
    private final String comment;

    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new FirefoxDriver();

    public TestClass(String name, String surname, String address, String metro, String phone, String date, String time, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getUserData() {
        return new Object[][]{
                {"Имя", "Фамилия", "Московская 22 - 124", "Красносельская", "+79001234567", "26.07.2023", "сутки", "black", "Коммент"},
                {"Александр", "Павлов", "Пушкина 1 - 12", "Лубянка", "+79998765432", "30.07.2023", "четверо суток", "grey", "Комментарий"}
        };
    }

    @Test
    public void orderTestTopButton() {

        driver.get(MainPage.mainUrl);

        MainPagelocators.getOrderTopButton(driver).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(OrderPage.nameField).sendKeys(name);
        driver.findElement(OrderPage.surnameField).sendKeys(surname);
        driver.findElement(OrderPage.addressField).sendKeys(address);
        driver.findElement(OrderPage.metroField).sendKeys(metro);
        driver.findElement(By.xpath(".//*[text()='" + metro + "']")).click();
        driver.findElement(OrderPage.phoneField).sendKeys(phone);

        driver.findElement(OrderPage.nextButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.findElement(OrderPage.timeField).click();
        driver.findElement(By.xpath(".//*[text()='" + time + "']")).click();
        driver.findElement(By.id(color)).click();
        driver.findElement(OrderPage.commentField).sendKeys(comment);
        driver.findElement(OrderPage.dateField).sendKeys(date);

        driver.findElement(OrderPage.completeOrderButton).click();
        driver.findElement(OrderPage.yesButton).click();

        assertEquals("Заказ не удался", "Посмотреть статус", driver.findElement(OrderPage.showStatusButton).getText());

    }

    @Test
    public void orderTestBottomButton() {

        driver.get(MainPage.mainUrl);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", MainPagelocators.getOrderBottomButton(driver));

        // Выполняем заказ со вторым элементом массива orderTestData и локатором bottomOrderButton
        MainPagelocators.getOrderBottomButton(driver).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(OrderPage.nameField).sendKeys(name);
        driver.findElement(OrderPage.surnameField).sendKeys(surname);
        driver.findElement(OrderPage.addressField).sendKeys(address);
        driver.findElement(OrderPage.metroField).sendKeys(metro);
        driver.findElement(By.xpath(".//*[text()='" + metro + "']")).click();
        driver.findElement(OrderPage.phoneField).sendKeys(phone);

        driver.findElement(OrderPage.nextButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.findElement(OrderPage.timeField).click();
        driver.findElement(By.xpath(".//*[text()='" + time + "']")).click();
        driver.findElement(By.id(color)).click();
        driver.findElement(OrderPage.commentField).sendKeys(comment);
        driver.findElement(OrderPage.dateField).sendKeys(date);

        driver.findElement(OrderPage.completeOrderButton).click();
        driver.findElement(OrderPage.yesButton).click();

        assertEquals("Заказ не удался", "Посмотреть статус", driver.findElement(OrderPage.showStatusButton).getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}


