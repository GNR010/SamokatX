package edu.praktikum.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

class MainPage {
    static String mainUrl = "https://qa-scooter.praktikum-services.ru/";
}

class MainPagelocators {
    static By accordeonList = By.className("accordion");
    static By orderButton = By.xpath(".//button[text()='Заказать']");
    static List<WebElement> getOrderButtons(WebDriver driver) {
        return driver.findElements(orderButton);
    }

    static WebElement getOrderTopButton(WebDriver driver) {
        return getOrderButtons(driver).get(0);
    }

    static WebElement getOrderBottomButton(WebDriver driver) {
        return getOrderButtons(driver).get(1);
    }
}