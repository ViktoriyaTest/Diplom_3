import api.RestClient;
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
import pagemobject.ResetPasswordPage;

public class LoginTest extends Driver {

    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    User user;
    ResetPasswordPage resetPasswordPage;
    String name;
    String email;
    String password;
    String accessToken;

    @Before
    public void setUp() {
        webDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        resetPasswordPage = new ResetPasswordPage(driver);
        driver.get(RestClient.BASE_URL);
        name = User.generateUserRandom().getName();
        email = User.generateUserRandom().getEmail();
        password = User.generateUserRandom().getPassword();
        user = new User(email, password, name);
        UserClient.createUser(user);
    }

    @Test
    @DisplayName("Вход по кнопке: Войти в аккаунт")
    public void loginOnMainPageTest() {
        mainPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка 'Оформить заказ' не появилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход по кнопке: Личный кабинет")
    public void loginPersonalPageTest() {
        mainPage.clickPersonalButton();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка 'Оформить заказ' не появилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через Войти на форме регистрации")
    public void loginRegistrationPageTest() {
        mainPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.clickRegisterButton();
        registerPage.waitForLoadRegisterPage();
        registerPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка 'Оформить заказ' не появилась", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку на форме восстановления пароля")
    public void loginPasswordResetPageTest() {
        mainPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.clickResetPasswordButton();
        resetPasswordPage.waitForLoadPage();
        resetPasswordPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Кнопка 'Оформить заказ' не появилась", mainPage.isOrderButtonVisible());
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
        driver.quit();
    }
}