package pagemobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalPage extends BasePage {

    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By logoLabel = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");
    private final By profileButton = By.xpath("//a[@href='/account/profile']");
    private final By logoutButton = By.xpath("//li[@class='Account_listItem__35dAP']/button");

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Загрузка главной страницы")
    public void waitForLoadMainPage() {
        waitForVisibility(profileButton);
    }

    @Step("Видимость: Профиль")
    public boolean isProfileButtonVisible() {
        return driver.findElement(profileButton).isDisplayed();
    }

    @Step("Клик по кнопке: Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик: логотип")
    public void clickLogo() {
        driver.findElement(logoLabel).click();
    }

    @Step("Клик по кнопке: Выход")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}