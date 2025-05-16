import Bases.BaseTest;
import Pages.AddUserPage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class AddUserTest extends BaseTest {

    @Test(description = "Ekleme işlemi")
    @Story("Geçerli bilgilerle yeni kullanıcı kaydı yapılmalı")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Geçerli verilerle kayıt işleminin başarılı şekilde tamamlanması test edilir.")

    public void testAddUserSuccessfully() {

        loginPage
                .fillUsername(username)
                .fillPassword(password)
                .clickLogin();


        addUserPage.clickAdminMenu()
                .clickUserManagement()
                .clickAddButton()
                .selectUserRole("Admin")
                .fillEmployeeName("Admin  Admin123")
                .fillUsername("testuser123")
                .selectStatus("Enabled")
                .fillPassword("Pass123!")
                .fillConfirmPassword("Pass123!")
                .clickSaveButton();

    }
}