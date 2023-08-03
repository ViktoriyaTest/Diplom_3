package pagemobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage extends BasePage {

    private final By resetPasswordLabel = By.xpath("//h2[text()='Восстановление пароля']");
    private final By loginButton = By.xpath("//a[@href='/login']");

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке: Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Загрузка страницы восстановления пароля")
    public void waitForLoadPage() {
        waitForVisibility(resetPasswordLabel);
    }
}