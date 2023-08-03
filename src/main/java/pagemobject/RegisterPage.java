package pagemobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private final By registerLabel = By.xpath("//h2[text()='Регистрация']");
    private final By nameField = By.xpath("//label[text()='Имя']/../input");
    private final By emailField = By.xpath("//label[text()='Email']/../input");
    private final By passwordField = By.xpath("//label[text()='Пароль']/../input");
    private final By registerButton = By.xpath("//button[@class='button_button__33qZ0 " +
            "button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final By loginButton = By.xpath("//a[@href='/login']");
    private final By errorPasswordLabel = By.xpath("//p[@class='input__error text_type_main-default']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Загрузка страницы: Регистрация")
    public void waitForLoadRegisterPage() {
        waitForVisibility(registerLabel);
    }

    @Step("Заполнить форму: Регистрация")
    public void fillRegistrationForm(String name, String email, String password) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке: Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Видимости надписи: Некорректный пароль")
    public boolean isIncorrectPasswordLabelVisible() {
        return driver.findElement(errorPasswordLabel).isDisplayed();
    }

    @Step("Клик по кнопке: Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}