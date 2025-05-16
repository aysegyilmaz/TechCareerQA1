import Bases.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {


    @Test(description = "Başarılı kullanıcı girişi")
    public void loginSuccessful() {
        loginPage
                .fillUsername(username)
                .fillPassword(password)
                .clickLogin();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/dashboard/index"));

        assertEqualsText(getCurrentUrl(), loginUrl);
    }

    @Test(description = "Başarısız kullanıcı girişi")
    public void loginUnSuccessful() {
        loginPage
                .fillUsername(username)
                .fillPassword("wrongpassword")
                .clickLogin();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content")));

        String errorText = loginPage.getErrorMessage();
        assertEqualsText(errorText, errorMessage);
    }

    @Test(description = "Zorunlu karakter kontrolü")
    public void loginRequiredFieldControl() {
        loginPage
                .fillUsername(username)
                .clickLogin();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content")));

        String errorText = loginPage.getErrorMessageRequired();
        assertEqualsText(errorText,requiredFieldMessage);
    }
}
