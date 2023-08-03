import api.User;
import api.UserClient;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pagemobject.LoginPage;
import pagemobject.MainPage;
import pagemobject.RegisterPage;

public class RegisterTest extends Driver {
    String name;
    String email;
    String password;
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    String accessToken;

    @Before
    public void setUp() {
        webDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        driver.get(UserClient.BASE_URL);
        mainPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.clickRegisterButton();
        registerPage.waitForLoadRegisterPage();
    }

    @Test
    @DisplayName("Проверка регистрации")
    public void registrationTest() {
        name = User.generateUserRandom().getName();
        email = User.generateUserRandom().getEmail();
        password = User.generateUserRandom().getPassword();
        registerPage.fillRegistrationForm(name, email, password);
        registerPage.clickRegisterButton();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Регистрация не выполнена", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Регистрация: Слишком короткий пароль")
    public void tooShortPasswordTest() {
        name = User.generateUserRandom().getName();
        email = User.generateUserRandom().getEmail();
        password = "12345";
        registerPage.fillRegistrationForm(name, email, password);
        registerPage.clickRegisterButton();
        Assert.assertTrue("Ошибка о некорректном пароле не появилась",
                registerPage.isIncorrectPasswordLabelVisible());
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
        driver.quit();
    }
}