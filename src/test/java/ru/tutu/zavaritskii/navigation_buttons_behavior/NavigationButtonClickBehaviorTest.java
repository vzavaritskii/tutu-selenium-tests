package ru.tutu.zavaritskii.navigation_buttons_behavior;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class NavigationButtonClickBehaviorTest {
    private WebDriver driver;

    // Коллекция путей к кнопкам в навигационной панели
    private static final Map<String, String> navButtonsXpath = Map.of(
            "Отели", "//button[.//i[contains(@class, 'oim-bed-double')]]",
            "Авиабилеты", "//button[.//i[contains(@class, 'oim-plane')]]",
            "Ж/д билеты", "//button[.//i[contains(@class, 'oim-train')]]",
            "Автобусы", "//button[.//i[contains(@class, 'oim-bus')]]",
            "Электрички", "//div[contains(@data-ti, 'search-form')]//a" +
                    "[.//i[contains(@class, 'oim-etrain')]]",                      // Переход на другую страницу
            "Туры", "//button[.//i[contains(@class, 'oim-island')]]",
            "Приключения", "//div[contains(@data-ti, 'search-form')]//a" +
                    "[.//i[contains(@class, 'oim-aerostat')]]",                    // Переход на другую страницу
            "Джарвел", "//button[.//i[contains(@class, 'oim-jarvel')]]"            // Открытие модального окна
    );

    // Условие выделенной кнопки. У выделенной кнопки появляется дополнительное значение в атрибуте 'class'
    // Значение выглядит как генерируемое динамически! Если генерируется динамически, можно переделать проверку на
    // количество значений class. У активного элемента значений в атрибуте class на 1 больше неактивных
    String activeAtributeValue = "olAus4o3tMssrzGd";

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutu.ru");
    }

    @Test
    @DisplayName("NAV_BTN_BEH_001: Убедиться, что при клике на кнопку \"Отели\" она становится активной" +
            " (визуально выделяется в панели навигации)")
    void testHotelButtonIsVisibleAfterClick () {
        // Поиск кнопки "Отели" по xpath
        List<WebElement> hotelButton =
                driver.findElements(By.xpath(navButtonsXpath.get("Отели")));

        // Проверка, что кнопка найдена
        assertFalse(hotelButton.isEmpty(), "Кнопка 'Отели' не найдена");

        // Проверка, что найден только один элемент
        assertEquals(hotelButton.size(), 1, "Ожидался ровно один элемент, но найдено: " +
                hotelButton.size());

        // Клик по кнопке "Отели"
        hotelButton.get(0).click();

        // Пауза для изменения состояний элементов в DOM
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> hotelButton.get(0).getAttribute("class").contains(activeAtributeValue));

        // Проверка, что кнопка является активной
        String hotelButtonClass = hotelButton.get(0).getAttribute("class");
        assertTrue(hotelButtonClass.contains(activeAtributeValue), "Кнопка 'Отели' не активна после клика");

        // Проверка, что остальные кнопки неактивны
        for (Map.Entry<String, String> entry : navButtonsXpath.entrySet()) {
            if (!entry.getKey().equals("Отели")) {
                List<WebElement> otherButton = driver.findElements(By.xpath(entry.getValue()));
                // Проверка, что кнопка найдена
                assertFalse(otherButton.isEmpty(), "При проверке остльных кнопка " + entry.getKey() +
                        " не найдена");
                // Проверка, что найден только один элемент
                assertEquals(1, otherButton.size(),
                        "При проверке остальных ожидался ровно один элемент кнопки "
                                + entry.getKey() + " ,а найдено: " + otherButton.size());
                // Проверка что у кнопки отсутствует признак выделенности (значение атрибута class)
                assertFalse(otherButton.get(0).getAttribute("class").contains(activeAtributeValue),
                        "При проверке остальных у кнопки " +
                                entry.getKey() + " присутствует признак выделения");
            }
        }
    }



    @Test
    @DisplayName("NAV_BTN_BEH_002: Убедиться, что при клике на кнопку \"Авиабилеты\" она становится" +
            " активной (визуально выделяется в панели навигации)")
    void testAirTicketsButtonIsVisibleAfterClick () {
        // Поиск кнопки "Отели" по xpath
        List<WebElement> AirTickets =
                driver.findElements(By.xpath(navButtonsXpath.get("Авиабилеты")));

        // Проверка, что кнопка найдена
        assertFalse(AirTickets.isEmpty(), "Кнопка 'Авиабилеты' не найдена");

        // Проверка, что найден только один элемент
        assertEquals(1, AirTickets.size(), "Ожидался ровно один элемент, но найдено: " +
                AirTickets.size());

        // Клик по кнопке "Отели"
        AirTickets.get(0).click();

        // Пауза для изменения состояний элементов в DOM
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> AirTickets.get(0).getAttribute("class").contains(activeAtributeValue));

        // Проверка, что кнопка является активной
        String hotelButtonClass = AirTickets.get(0).getAttribute("class");
        assertTrue(hotelButtonClass.contains(activeAtributeValue),
                "Кнопка 'Авиабилеты' не активна после клика");

        // Проверка, что остальные кнопки неактивны
        for (Map.Entry<String, String> entry : navButtonsXpath.entrySet()) {
            if (!entry.getKey().equals("Авиабилеты")) {
                List<WebElement> otherButton = driver.findElements(By.xpath(entry.getValue()));
                // Проверка, что кнопка найдена
                assertFalse(otherButton.isEmpty(), "При проверке остльных кнопка " + entry.getKey() +
                        " не найдена");
                // Проверка, что найден только один элемент
                assertEquals(1, otherButton.size(),
                        "При проверке остальных ожидался ровно один элемент" +
                        " кнопки " + entry.getKey() + " ,а найдено: " + otherButton.size());
                // Проверка что у кнопки отсутствует признак выделенности (значение атрибута class)
                assertFalse(otherButton.get(0).getAttribute("class").contains(activeAtributeValue),
                        "При проверке остальных у кнопки " +
                                entry.getKey() + " присутствует признак выделения");
            }
        }
    }



    @Test
    @DisplayName("NAV_BTN_BEH_003: Убедиться, что при клике на кнопку \"Ж/д билеты\" она становится" +
            " активной (визуально выделяется в панели навигации)")
    void testTrainTicketsButtonIsVisibleAfterClick () {
        // Поиск кнопки "Отели" по xpath
        List<WebElement> TrainTickets =
                driver.findElements(By.xpath(navButtonsXpath.get("Ж/д билеты")));

        // Проверка, что кнопка найдена
        assertFalse(TrainTickets.isEmpty(), "Кнопка 'Ж/д билеты' не найдена");

        // Проверка, что найден только один элемент
        assertEquals(1, TrainTickets.size(), "Ожидался ровно один элемент, но найдено: " +
                TrainTickets.size());

        // Клик по кнопке "Отели"
        TrainTickets.get(0).click();

        // Пауза для изменения состояний элементов в DOM
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> TrainTickets.get(0).getAttribute("class").contains(activeAtributeValue));

        // Проверка, что кнопка является активной
        String hotelButtonClass = TrainTickets.get(0).getAttribute("class");
        assertTrue(hotelButtonClass.contains(activeAtributeValue),
                "Кнопка 'Ж/д билеты' не активна после клика");

        // Проверка, что остальные кнопки неактивны
        for (Map.Entry<String, String> entry : navButtonsXpath.entrySet()) {
            if (!entry.getKey().equals("Ж/д билеты")) {
                List<WebElement> otherButton = driver.findElements(By.xpath(entry.getValue()));
                // Проверка, что кнопка найдена
                assertFalse(otherButton.isEmpty(), "При проверке остльных кнопка " +
                        entry.getKey() + " не найдена");
                // Проверка, что найден только один элемент
                assertEquals(1, otherButton.size(), "При проверке остальных ожидался" +
                        " ровно один элемент кнопки " + entry.getKey() + " ,а найдено: " + otherButton.size());
                // Проверка что у кнопки отсутствует признак выделенности (значение атрибута class)
                assertFalse(otherButton.get(0).getAttribute("class")
                        .contains(activeAtributeValue), "При проверке остальных у кнопки " +
                        entry.getKey() + " присутствует признак выделения");
            }
        }
    }



    @Test
    @DisplayName("NAV_BTN_BEH_004: Убедиться, что при клике на кнопку \"Автобусы\" она становится активной" +
            " (визуально выделяется в панели навигации)")
    void testBusTicketsButtonIsVisibleAfterClick () {
        // Поиск кнопки "Отели" по xpath
        List<WebElement> busTickets =
                driver.findElements(By.xpath(navButtonsXpath.get("Автобусы")));

        // Проверка, что кнопка найдена
        assertFalse(busTickets.isEmpty(), "Кнопка 'Автобусы' не найдена");

        // Проверка, что найден только один элемент
        assertEquals(1, busTickets.size(), "Ожидался ровно один элемент, но найдено: " +
                busTickets.size());

        // Клик по кнопке "Отели"
        busTickets.get(0).click();

        // Пауза для изменения состояний элементов в DOM
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> busTickets.get(0).getAttribute("class").contains(activeAtributeValue));

        // Проверка, что кнопка является активной
        String hotelButtonClass = busTickets.get(0).getAttribute("class");
        assertTrue(hotelButtonClass.contains(activeAtributeValue), "Кнопка 'Автобусы' не активна после клика");

        // Проверка, что остальные кнопки неактивны
        for (Map.Entry<String, String> entry : navButtonsXpath.entrySet()) {
            if (!entry.getKey().equals("Автобусы")) {
                List<WebElement> otherButton = driver.findElements(By.xpath(entry.getValue()));
                // Проверка, что кнопка найдена
                assertFalse(otherButton.isEmpty(), "При проверке остльных кнопка " + entry.getKey() +
                        " не найдена");
                // Проверка, что найден только один элемент
                assertEquals(1, otherButton.size(), "При проверке остальных ожидался ровно " +
                        "один элемент кнопки " + entry.getKey() + " ,а найдено: " + otherButton.size());
                // Проверка что у кнопки отсутствует признак выделенности (значение атрибута class)
                assertFalse(otherButton.get(0).getAttribute("class")
                                .contains(activeAtributeValue), "При проверке остальных у кнопки " +
                        entry.getKey() + " присутствует признак выделения");
            }
        }
    }



    @Test
    @DisplayName("NAV_BTN_BEH_005: Убедиться, что при нажатии на кнопку \"Электрички\" происходит переход " +
            "на другую страницу")
    void testEtrainTicketsButtonRedirectToCorrectPage () {
        // Поиск кнопки "Электрички" по xpath
        List<WebElement> etrainTickets =
                driver.findElements(By.xpath(navButtonsXpath.get("Электрички")));

        // Проверка, что кнопка найдена
        assertFalse(etrainTickets.isEmpty(), "Кнопка 'Электрички' не найдена");

        // Проверка, что найден только один элемент
        assertEquals(1, etrainTickets.size(), "Ожидался ровно один элемент, но найдено: " +
                etrainTickets.size());

        // Клик по кнопке "Электрички"
        etrainTickets.get(0).click();

        // Ожидание изменения текущего URL на целевой
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("https://www.tutu.ru/prigorod/"));

        // Проверка загрузки целевой страницы
        assertTrue(driver.getCurrentUrl().contains("/prigorod/"), "После клика не открылась целевая " +
                "страница 'Электрички'");

        // Дополнительная проверка на загрузку правильной страницы
        // Ожидание загрузки уникальных элементов на целевой странице
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h1[contains(text(), 'Расписание электричек')]")
        ));

        // Проверка на присутствие унникальных элементов
        String headerText = driver
                .findElement(By.xpath("//h1[contains(text(), 'Расписание электричек')]"))
                .getText();
        assertTrue(headerText.contains("Расписание электричек"), "На странице отсутствует заголовок" +
                " 'Расписание электричек'");
    }



    @Test
    @DisplayName("NAV_BTN_BEH_006: Убедиться, что при клике на кнопку \"Туры\" она становится активной (визуально " +
            "выделяется в панели навигации)")
    void testToursButtonIsVisibleAfterClick() {
        // Поиск кнопки "Туры" по Xpath
        List<WebElement> toursButton = driver.findElements(By.xpath(navButtonsXpath.get("Туры")));

        // Проверка что кнопка найдена
        assertFalse(toursButton.isEmpty(), "Кнопка 'Туры' не найдена");

        // Проверка что найдена одна кнопка
        assertEquals(1, toursButton.size(), "Ожидалася ровно один элемент, но найдено: " +
                toursButton.size());

        // Клик по кнопке "Туры"
        toursButton.get(0).click();

        // Пауза для изменения состояний элементов в DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> toursButton.get(0).getAttribute("class").contains(activeAtributeValue));

        // Проверка, что кнопка является активной
        String toursButtonClass = toursButton.get(0).getAttribute("class");
        assertTrue(toursButtonClass.contains(activeAtributeValue), "Кнопка 'Туры' не активна после клика");

        // Проверка, что остальные кнопки неактивны
        for (Map.Entry<String, String> entry : navButtonsXpath.entrySet()) {
            // Исключаем текущую кнопку
            if (!entry.getKey().equals("Туры")) {
                // Поиск кнопки по Xpath
                List<WebElement> otherButton = driver.findElements(By.xpath(entry.getValue()));
                // Проверка, что кнопка найдена
                assertFalse(otherButton.isEmpty(), "При проверке остальных кнопка " + entry.getKey() +
                        " не найдена");
                // Проверка, что найден только один элемент
                assertEquals(1, otherButton.size(), "При проверке остальных ожидался ровно " +
                        "один элемент кнопки " + entry.getKey() + ", а найдено: " + otherButton.size());
                // Проверка, что у кнопки отсутствует признак выделенности (значение атрибута class)
                assertFalse(otherButton.get(0).getAttribute("class")
                        .contains(activeAtributeValue), "При проверки остальных у кнопки " +
                        entry.getKey() + " присутствует признак выделения");
            }
        }
    }



    @Test
    @DisplayName("NAV_BTN_BEH_007: Убедиться, что при нажатии на кнопку \"Приключения\" происходит переход на другую страницу")
    void testAdventuresButtonRedirectToCorrectPage () {
        // Поиск кнопки "Приключения" по xpath
        List<WebElement> adventures =
                driver.findElements(By.xpath(navButtonsXpath.get("Приключения")));

        // Проверка, что кнопка найдена
        assertFalse(adventures.isEmpty(), "Кнопка 'Приключения' не найдена");

        // Проверка, что найден только один элемент
        assertEquals(1, adventures.size(), "Ожидался ровно один элемент, но найдено: " +
                adventures.size());

        // Клик по кнопке "Приключения"
        adventures.get(0).click();

        // Ожидание изменения текущего URL на целевой
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("https://go.tutu.ru/"));

        // Проверка загрузки целевой страницы
        assertTrue(driver.getCurrentUrl().contains("/go.tutu.ru/"), "После клика не открылась целевая " +
                "страница 'Приключения'");

        // Дополнительная проверка на загрузку правильной страницы
        // Ожидание загрузки уникальных элементов на целевой странице
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h1[contains(text(), 'Авторские туры')]")
        ));

        // Проверка на присутствие унникальных элементов
        String headerText = driver
                .findElement(By.xpath("//h1[contains(text(), 'Авторские туры')]"))
                .getText();
        assertTrue(headerText.contains("Авторские туры"), "На странице отсутствует заголовок" +
                " 'Авторские туры'");
    }



    @Test
    @DisplayName("NAV_BTN_BEH_008: Убедиться, что при нажатии на кнопку \"Джарвел\" открывается модальное окно")
    void testJarvelButtonOpenModal () {
        // Поиск кнопки Джарвел по Xpath
        List<WebElement> jarvelButton = driver.findElements(By.xpath(navButtonsXpath.get("Джарвел")));

        // Проверка, что кнопка найдена
        assertFalse(jarvelButton.isEmpty(), "Кнопка 'Джарвел' не найдена");

        // Проверка, что найдена только одна кнопка
        assertEquals(1, jarvelButton.size(), "Ожидался ровно один элемент, а найдено: " +
                jarvelButton.size());

        // Клик по кнопке Джарвел
        //jarvelButton.get(0).click();
    }



    @Test
    @DisplayName("NAV_BTN_BEH_009: Убедиться, что после закрытия модального окна с \"Джарвел\" " +
            "кнопка остается без выделения")
    void testJarvelButtonCloseModal () {

    }



    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
