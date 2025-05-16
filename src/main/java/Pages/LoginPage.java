package Pages;
import Bases.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BaseTest {
    public LoginPage() {

    }

    @Step("Username alanı doldurulur")
    public LoginPage fillUsername(String username) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        webDriver.findElement(By.name("username")).sendKeys(username);
        return this;
    }

    @Step("Password alanı doldurulur")
    public LoginPage fillPassword(String password) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        webDriver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    @Step("Login butonuna tıklanır")
    public LoginPage clickLogin() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".orangehrm-login-button")));
        webDriver.findElement(By.cssSelector(".orangehrm-login-button")).click();
        return this;
    }

    @Step("Hata mesajı alınır")
    public String getErrorMessage() {
        String errorText = webDriver.findElement(By.cssSelector("[class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
        screenshot();
        return errorText;
    }

    @Step("Hata mesajı alınır")
    public String getErrorMessageRequired() {
        String errorText1 = webDriver.findElement(By.cssSelector("[class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).getText();
        screenshot();
        return errorText1;
    }

}
