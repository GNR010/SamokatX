package test.pack;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.pack.MainPage;
import page.pack.OrderPage;

import static org.junit.Assert.*;

class OrderTestData {
    static String[] testDataTop = {
            "Имя", "Фамилия", "Московская 22 - 124", "Красносельская", "+79001234567", "26.07.2023", "сутки", "black", "Коммент"
    };
    static String[] testDataBottom = {
            "Александр", "Павлов", "Пушкина 1 - 12", "Лубянка", "+79998765432", "30.07.2023", "четверо суток", "grey", "Комментарий"
    };
}

public class OrderTestClass {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }


    @Test
    public void orderTestTopButton() {

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        driver.get(mainPage.getMainUrl());

        orderPage.getOrderTopButton(driver).click();
        orderPage.waitForLoad();

        orderPage.findAndSendKeys(orderPage.getNameField(), OrderTestData.testDataTop[0]);
        orderPage.findAndSendKeys(orderPage.getSurnameField(), OrderTestData.testDataTop[1]);
        orderPage.findAndSendKeys(orderPage.getAddressField(), OrderTestData.testDataTop[2]);
        orderPage.findAndSendKeys(orderPage.getMetroField(), OrderTestData.testDataTop[3]);
        orderPage.findByTextClick(OrderTestData.testDataTop[3]);
        orderPage.findAndSendKeys(orderPage.getPhoneField(), OrderTestData.testDataTop[4]);

        orderPage.findFieldAndClick(orderPage.getNextButton());
        orderPage.waitForLoad();

        orderPage.findFieldAndClick(orderPage.getTimeField());
        orderPage.findByTextClick(OrderTestData.testDataTop[6]);
        orderPage.findAndClickColor(OrderTestData.testDataTop[7]);
        orderPage.findAndSendKeys(orderPage.getCommentField(), OrderTestData.testDataTop[8]);
        orderPage.findAndSendKeys(orderPage.getDateField(), OrderTestData.testDataTop[5]);

        orderPage.findFieldAndClick(orderPage.getCompleteOrderButton());
        orderPage.findFieldAndClick(orderPage.getYesButton());

        assertEquals("Заказ не удался", "Посмотреть статус", orderPage.getButtonText(orderPage.getShowStatusButton()));

    }

    @Test
    public void orderTestBottomButton() {

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);

        driver.get(mainPage.getMainUrl());
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderPage.getOrderBottomButton(driver));

        orderPage.getOrderBottomButton(driver).click();
        orderPage.waitForLoad();

        orderPage.findAndSendKeys(orderPage.getNameField(), OrderTestData.testDataBottom[0]);
        orderPage.findAndSendKeys(orderPage.getSurnameField(), OrderTestData.testDataBottom[1]);
        orderPage.findAndSendKeys(orderPage.getAddressField(), OrderTestData.testDataBottom[2]);
        orderPage.findAndSendKeys(orderPage.getMetroField(), OrderTestData.testDataBottom[3]);
        orderPage.findByTextClick(OrderTestData.testDataBottom[3]);
        orderPage.findAndSendKeys(orderPage.getPhoneField(), OrderTestData.testDataBottom[4]);

        orderPage.findFieldAndClick(orderPage.getNextButton());
        orderPage.waitForLoad();

        orderPage.findFieldAndClick(orderPage.getTimeField());
        orderPage.findByTextClick(OrderTestData.testDataBottom[6]);
        orderPage.findAndClickColor(OrderTestData.testDataBottom[7]);
        orderPage.findAndSendKeys(orderPage.getCommentField(), OrderTestData.testDataBottom[8]);
        orderPage.findAndSendKeys(orderPage.getDateField(), OrderTestData.testDataBottom[5]);

        orderPage.findFieldAndClick(orderPage.getCompleteOrderButton());
        orderPage.findFieldAndClick(orderPage.getYesButton());

        assertEquals("Заказ не удался", "Посмотреть статус", orderPage.getButtonText(orderPage.getShowStatusButton()));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}


