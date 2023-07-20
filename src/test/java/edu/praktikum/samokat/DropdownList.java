package edu.praktikum.samokat;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)
public class DropdownList {
    WebDriver driver = new FirefoxDriver();
    private final String question;
    private final String answer;

    public DropdownList(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    @Parameterized.Parameters
    public static Object[][] getAccordeonData() {
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void testClass() {

        driver.get(MainPage.mainUrl);

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(MainPagelocators.accordeonList));

        driver.findElement(By.xpath(".//*[text()='" + question + "']")).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        assertEquals("Текст не совпадает", answer, driver.findElement(By.id(driver.findElement(By.xpath(".//*[text()='" + question + "']")).getAttribute("aria-controls"))).getText());

    }

    @After
    public void teardown() {
        driver.quit();
    }

}


