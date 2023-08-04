package pagemobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By inputField = By.xpath("//h2[text()='Вход']");
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By inputButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx " +
            "button_button_size_medium__3zxIa']");
    private final By registerButton = By.xpath("//a[@href='/register']");
    private final By forgotPasswordButton = By.xpath("//a[@href='/forgot-password']");
    private final By logoField = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Загрузка страницы авторизации")
    public void waitForLoad() {
        waitForVisibility(inputField);
    }

    @Step("Проверка видимости: 'Войти'")
    public boolean isEnterLabelVisible() {
        return driver.findElement(inputField).isDisplayed();
    }

    @Step("Заполнить форму: Авторизация")
    public void fillLoginForm(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке: Войти")
    public void clickLoginButton() {
        driver.findElement(inputButton).click();
    }

    @Step("Клик на кнопку: Восстановить пароль")
    public void clickResetPasswordButton() {
        driver.findElement(forgotPasswordButton).click();
    }

    @Step("Клик по кнопке: Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Клик на: Логотип")
    public void clickLogoButton() {
        driver.findElement(logoField).click();
    }
}