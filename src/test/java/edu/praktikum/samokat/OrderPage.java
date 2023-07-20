package edu.praktikum.samokat;

import org.openqa.selenium.By;

public class OrderPage {
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
