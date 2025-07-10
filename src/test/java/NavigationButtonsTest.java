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
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NavigationButtonsTest {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutu.ru/");
    }

    @Test
    @DisplayName ("Проверка кнопки переключения на раздел 'Отели'")
    void testHotelButton() {
        WebElement hotelButton = driver.findElement(
                By.xpath("//button[.//i[contains(@class, 'oim-bed-double')]]"));
        hotelButton.click();

        // Проверка
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[@data-ti='submit-button' and .//div[text()='Найти отели']]")
                )
        );
        assertNotNull(searchButton);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
