package ru.tutu.zavaritskii.navigation_buttons_active_state;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;

public class NavigationActiveButtonTest {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutu.ru");
    }


    @Test
    @DisplayName("NAV_BTN_ACT_001: Убедиться, что при загрузке главной страницы сайта в панели навигации по умолчанию" +
            "активна (визуально выделена) кнопка 'Авиабилеты'")
    void testAviabiletyButtonIsActiveByDefault() {
        Map<String, String> navButtons = Map.of(
                "Отели", "//button[.//i[contains(@class, 'oim-bed-double')]]",
                "Авиабилеты", "//button[.//i[contains(@class, 'oim-plane')]]",
                "Ж/д билеты", "//button[.//i[contains(@class, 'oim-train')]]",
                "Автобусы", "//button[.//i[contains(@class, 'oim-bus')]]",
                "Электрички", "//div[contains(@data-ti, 'search-form')]" +
                        "//a[.//i[contains(@class, 'oim-etrain')]]",
                "Туры", "//button[.//i[contains(@class, 'oim-island')]]",
                "Приключения", "//div[contains(@data-ti, 'search-form')]" +
                        "//a[.//i[contains(@class, 'oim-aerostat')]]",
                "Джарвел", "//button[.//i[contains(@class, 'oim-jarvel')]]"
        );

        String actualActiveButton = null;
        int maxClassCount = -1;

        for (Map.Entry<String,String> entry : navButtons.entrySet()) {
            String name = entry.getKey();
            String xpath = entry.getValue();

            List<WebElement> button = driver.findElements(By.xpath(xpath));
            assertFalse(button.isEmpty(), "Кнопка не найдена");
            assertEquals(button.size(), 1, "По xpath найдено более одного элемента");

            String classAtr = button.get(0).getAttribute("class");
            int classCount = classAtr == null ? 0 : classAtr.trim().split("\\s+").length;

            if (classCount > maxClassCount) {
                maxClassCount = classCount;
                actualActiveButton = name;
            }
        }

        assertEquals("Авиабилеты", actualActiveButton, "Ожидалась активная кнопка 'Авиабилеты', " +
                "но активна '" + actualActiveButton + "'");
    }



    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
