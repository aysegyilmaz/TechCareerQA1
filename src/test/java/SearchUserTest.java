import Bases.BaseTest;
import Pages.AddUserPage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SearchUserTest extends BaseTest {

    @Test(description = "Ekleme işlemi")
    @Story("Geçerli bilgilerle yeni kullanıcı kaydı yapılmalı")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Geçerli verilerle kayıt işleminin başarılı şekilde tamamlanması test edilir.")

    public void testSearchUserSuccessfully() {

        loginPage
                .fillUsername(username)
                .fillPassword(password)
                .clickLogin();

        addUserPage.clickAdminMenu();
        addUserPage.clickUserManagement();

        searchUserPage
                .fillUsername1("Admin")
                .selectUserRole1("Admin")
                .fillEmployeeName1("Admin  Admin123")
                .selectStatus1("Enabled")
                .clickSearchButton();

    }
}