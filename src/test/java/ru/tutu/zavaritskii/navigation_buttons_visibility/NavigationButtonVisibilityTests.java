package ru.tutu.zavaritskii.navigation_buttons_visibility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NavigationButtonVisibilityTests {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutu.ru");
    }



    @Test
    @DisplayName("NAV_BTN_VTS_001: Проверка отображения кнопки 'Отели'")
    void testHotelsButtonIsVisible() {
        // Поиск кнопки "Отели" по xpath
        List<WebElement> hotelsButton =
                driver.findElements(By.xpath("//button[.//i[contains(@class, 'oim-bed-double')]]"));

        // Проверка, что кнопка найдена
        assertFalse(hotelsButton.isEmpty(), "Кнопка отели найдена");
        // Проверка, что найден только один элемент
        assertEquals(hotelsButton
                .size(), 1, "Ожидался ровно один элемент, но найдено: " + hotelsButton.size());
        // Проверка, что кнопка отображается на странице
        WebElement element = hotelsButton.get(0);
        assertTrue(element.isDisplayed(), "Кнопка 'Отели' должна быть видима на странице");
    }



    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
