package edu.praktikum.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Класс с локаторами
class Locators {
    static By accordeonList = By.className("accordion");
    static By accordeonHeading = By.className("accordion__button");
    static By accordeonPanel = By.className("accordion__panel");
}

// Класс с тестовыми данными
class TestData {
    static String[] expectedText = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };
}

public class dropdownList {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void testClass() {

        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.xpath(".//button[text()='Заказать']"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(Locators.accordeonList));

        List<WebElement> elements = driver.findElements(Locators.accordeonHeading);


        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);

            element.click();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            assertEquals("Текст не совпадает", TestData.expectedText[i], driver.findElement(By.id("accordion__panel-" + i)).getText());

        }

    }

    @After
    public void teardown() {
        driver.quit();
    }

}


