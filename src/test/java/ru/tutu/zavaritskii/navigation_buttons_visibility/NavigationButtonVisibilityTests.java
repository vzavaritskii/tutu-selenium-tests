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
        assertFalse(hotelsButton.isEmpty(), "Кнопка 'Отели' не найдена");
        // Проверка, что найден только один элемент
        assertEquals(hotelsButton
                .size(), 1, "Ожидался ровно один элемент, но найдено: " + hotelsButton.size());
        // Проверка, что кнопка отображается на странице
        WebElement element = hotelsButton.get(0);
        assertTrue(element.isDisplayed(), "Кнопка 'Отели' не видна на странице");
    }

    @Test
    @DisplayName("NAV_BTN_VTS_002: Проверка отображения кнопки 'Авиабилеты'")
    void testFlyTicketsButtonIsVisible() {
        // Поиск кнопки "Авиабилеты" по xpath
        List<WebElement> flyTicketsButton =
                driver.findElements(By.xpath("//button[.//i[contains(@class, 'oim-plane')]]"));
        // Проверка, что кнопка найдена
        assertFalse(flyTicketsButton.isEmpty(), "Кнопка 'Авиабилеты' не найдена");
        // Проверка, что найден только один элемент
        assertEquals(flyTicketsButton
                .size(), 1, "Ожидался ровно один элемент, но найдено: " + flyTicketsButton.size());
        // Проверка, что кнопка отображается на странице
        WebElement element = flyTicketsButton.get(0);
        assertTrue(element.isDisplayed(), "Кнопка 'Авиабилеты' не видна на странице");
    }


    @Test
    @DisplayName("NAV_BTN_VTS_003: Проверка отображения кнопки 'Ж/д билеты'")
    void testTrainTicketsButtonIsVisible() {
        // Поиск кнопки "Ж/д билеты" по xpath
        List<WebElement> trainTicketsButton =
                driver.findElements(By.xpath("//button[.//i[contains(@class, 'oim-train')]]"));
        // Проверка, что кнопка найдена
        assertFalse(trainTicketsButton.isEmpty(), "Кнопка 'Ж/д билеты' не найдена");
        // Проверка, что найден только один элемент
        assertEquals(trainTicketsButton
                .size(), 1, "Ожидался ровно один элемент, но найдено: " + trainTicketsButton.size());
        // Проверка, что кнопка отображается на странице
        WebElement element = trainTicketsButton.get(0);
        assertTrue(element.isDisplayed(), "Кнопка 'Ж/д билеты' не видна на странице");
    }



    @Test
    @DisplayName("NAV_BTN_VTS_004: Проверка отображения кнопки 'Автобусы'")
    void testBusesButtonIsVisible() {
        // Поиск кнопки "Автобусы" по xpath
        List<WebElement> busesButton =
                driver.findElements(By.xpath("//button[.//i[contains(@class, 'oim-bus')]]"));
        // Проверка, что кнопка найдена
        assertFalse(busesButton.isEmpty(), "Кнопка 'Автобусы' не найдена");
        // Проверка, что найден только один элемент
        assertEquals(busesButton
                .size(), 1, "Ожидался ровно один элемент, но найдено: " + busesButton.size());
        // Проверка, что кнопка отображается на странице
        WebElement element = busesButton.get(0);
        assertTrue(element.isDisplayed(), "Кнопка 'Автобусы' не видна на странице");
    }



    @Test
    @DisplayName("NAV_BTN_VTS_005: Проверка отображения кнопки 'Электрички'")
    void testEtrainButtonIsVisible() {
        // Поиск кнопки "Электрички" по xpath
        List<WebElement> etrainButton =
                driver.findElements(By.xpath(
                                "//div[contains(@data-ti, 'search-form')]" +
                                        "//a[.//i[contains(@class, 'oim-etrain')]]"));
        // Проверка, что кнопка найдена
        assertFalse(etrainButton.isEmpty(), "Кнопка 'Электрички' не найдена");
        // Проверка, что найден только один элемент
        assertEquals(etrainButton
                .size(), 1, "Ожидался ровно один элемент, но найдено: " + etrainButton.size());
        // Проверка, что кнопка отображается на странице
        WebElement element = etrainButton.get(0);
        assertTrue(element.isDisplayed(), "Кнопка 'Электрички' не видна на странице'");
    }



    @Test
    @DisplayName("NAV_BTN_VTS_006: Проверка отображения кнопки 'Туры'")
    void testToursButtonIsVisible() {
        // Поиск кнопки "Туры" по xpath
        List<WebElement> toursButton =
                driver.findElements(By.xpath(
                        "//button[.//i[contains(@class, 'oim-island')]]"));
        // Проверка, что кнопка найдена
        assertFalse(toursButton.isEmpty(), "Кнопка 'Туры' не найдена");
        // Проверка, что найден только один элемент
        assertEquals(toursButton
                .size(), 1, "Ожидался ровно один элемент, но найдено: " + toursButton.size());
        // Проверка, что кнопка отображается на странице
        WebElement element = toursButton.get(0);
        assertTrue(element.isDisplayed(), "Кнопка 'Туры' не видна на странице'");
    }



    @Test
    @DisplayName("NAV_BTN_VTS_007: Убедиться, что кнопка 'Приключения' отображается на главной странице сайта.")
    void testAdventureButtonIsVisible() {
        // Поиск кнопки "Приключения" по xpath
        List<WebElement> adventureButtons = driver.findElements(By.xpath(
                "//div[contains(@data-ti, 'search-form')]" +
                        "//a[.//i[contains(@class, 'oim-aerostat')]]"));
        // Проверка, что кнопка найдена
        assertFalse(adventureButtons.isEmpty(), "Кнопка 'Приключения' не найдена");
        // Проверка, что найден только один элемент
        assertEquals(adventureButtons.size(), 1, "Ожидался ровно один элемент, но найдено: " +
                adventureButtons.size());
        // Проверка, что кнопка отображается на странице
        WebElement element = adventureButtons.get(0);
        assertTrue(element.isDisplayed(), "Кнопка 'Приключения' не видна на странице");
    }



    @Test
    @DisplayName("NAV_BTN_VTS_008: Убедиться, что кнопка 'Джарвел' отображается на главной странице сайта.")
    void testJarvelButtonIsVisible() {
        // Поиск кнопки "Джарвел" по xpath
        List<WebElement> jarvelButton = driver.findElements(By.xpath(
                "//button[.//i[contains(@class, 'oim-jarvel')]]"));
        // Проверка, что кнопка найдена
        assertFalse(jarvelButton.isEmpty(), "Кнопка 'Джарвел' не найдена");
        // Проверка, что найден только один элемент
        assertEquals(jarvelButton.size(), 1, "Ожидался ровно один элемент, но найдено: " +
                jarvelButton.size());
        // Проверка, что кнопка отображается на странице
        WebElement element = jarvelButton.get(0);
        assertTrue(element.isDisplayed(), "Кнопка 'Джарвел' не видна на странице");
    }



    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
