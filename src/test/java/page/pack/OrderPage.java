package page.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrderPage {
    private WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    private By orderButton = By.xpath(".//button[text()='Заказать']");
    public List<WebElement> getOrderButtons(WebDriver driver) {
        return driver.findElements(orderButton);
    }

    public WebElement getOrderTopButton(WebDriver driver) {
        return getOrderButtons(driver).get(0);
    }

    public WebElement getOrderBottomButton(WebDriver driver) {
        return getOrderButtons(driver).get(1);
    }
    private By completeOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']");
    private By nextButton = By.xpath(".//button[text()='Далее']");
    private By yesButton = By.xpath(".//button[text()='Да']");
    private By showStatusButton = By.xpath(".//button[text()='Посмотреть статус']");


    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By timeField = By.className("Dropdown-placeholder");

    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    public By getCompleteOrderButton() {
        return completeOrderButton;
    }
    public By getNextButton() {
        return nextButton;
    }
    public By getYesButton() {
        return yesButton;
    }
    public By getShowStatusButton() {
        return showStatusButton;
    }
    public By getNameField() {
        return nameField;
    }
    public By getSurnameField() {
        return surnameField;
    }

    public By getAddressField() {
        return addressField;
    }
    public By getMetroField() {
        return metroField;
    }
    public By getPhoneField() {
        return phoneField;
    }
    public By getDateField() {
        return dateField;
    }
    public By getTimeField() {
        return timeField;
    }
    public By getCommentField() {
        return commentField;
    }
    public String getButtonText(By field) {
        return driver.findElement(field).getText();
    }

    public void findByTextClick(String text) {
        driver.findElement(By.xpath(".//*[text()='" + text + "']")).click();
    }

    public void findAndSendKeys(By field, String keys) {
        driver.findElement(field).sendKeys(keys);
    }

    public void findFieldAndClick(By field) {
        driver.findElement(field).click();
    }

    public void waitForLoad() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void findAndClickColor(String color) {
        driver.findElement(By.id(color)).click();
    }
}
