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
import pagemobject.PersonalPage;
import pagemobject.RegisterPage;

public class PersonalPageTest extends Driver {
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    User user;
    PersonalPage personalPage;
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
        personalPage = new PersonalPage(driver);
        driver.get(RestClient.BASE_URL);
        name = User.generateUserRandom().getName();
        email = User.generateUserRandom().getEmail();
        password = User.generateUserRandom().getPassword();
        user = new User(email, password, name);
        UserClient.createUser(user);
        mainPage.clickLoginButton();
        loginPage.waitForLoad();
        loginPage.fillLoginForm(email, password);
        loginPage.clickLoginButton();
        mainPage.waitForLoad();
    }

    @Test
    @DisplayName("Нажать на кнопку: Личный кабинет")
    public void goPersonalPageTest() {
        mainPage.clickPersonalButton();
        personalPage.waitForLoadMainPage();
        Assert.assertTrue("Вход в ЛК не выполнен", personalPage.isProfileButtonVisible());
    }

    @Test
    @DisplayName("ЛК: кликнуть по кнопке: Конструктор")
    public void clickConstructorButtonTest() {
        mainPage.clickPersonalButton();
        personalPage.waitForLoadMainPage();
        personalPage.clickConstructorButton();
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не выполнен", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("ЛК: переход в конструктор по клику на логотип: Stellar Burgers")
    public void constructorClickLogoTest() {
        mainPage.clickPersonalButton();
        personalPage.waitForLoadMainPage();
        personalPage.clickLogo();
        mainPage.waitForLoad();
        Assert.assertTrue("Переход в конструктор не выполнен", mainPage.isOrderButtonVisible());
    }

    @Test
    @DisplayName("Выход по кнопке")
    public void exitButtonTest() {
        mainPage.clickPersonalButton();
        personalPage.waitForLoadMainPage();
        personalPage.clickLogoutButton();
        loginPage.waitForLoad();
        Assert.assertTrue("Выход не выполнен", loginPage.isEnterLabelVisible());
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
        driver.quit();
    }
}