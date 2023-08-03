package pagemobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By LKButton = By.linkText("Личный Кабинет");
    private final By makeBurgerLabel = By.xpath("//h1[@class='text text_type_main-large mb-5 mt-10']");
    private final By activeBun = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By inactiveBun = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");
    private final By activeSauce = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By inactiveSauce = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");
    private final By activeFilling = By.xpath("//div[@class='tab_tab__1SPyG " +
            "tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By inactiveFilling = By.xpath("//div[@class='tab_tab__1SPyG  " +
            "pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Загрузка главной страницы")
    public void waitForLoad() {
        waitForVisibility(makeBurgerLabel);
    }

    @Step("Клик на: Соусы")
    public void clickSauce() {
        driver.findElement(inactiveSauce).click();
    }

    @Step("Проверка активности: Соусы")
    public boolean isSauceActive() {
        return driver.findElement(activeSauce).isDisplayed();
    }

    @Step("Клик на: Начинки")
    public void clickFilling() {
        driver.findElement(inactiveFilling).click();
    }

    @Step("Проверка активности: Начинки")
    public boolean isFillingActive() {
        return driver.findElement(activeFilling).isDisplayed();
    }

    @Step("Клик на: Булки")
    public void clickBun() {
        driver.findElement(inactiveBun).click();
    }

    @Step("Проверка активности: Булки")
    public boolean isBunButton() {
        return driver.findElement(activeBun).isDisplayed();
    }

    @Step("Клик по кнопке на главной странице: Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Видимости кнопки: Оформить заказ")
    public boolean isOrderButtonVisible() {
        return driver.findElement(orderButton).isDisplayed();
    }

    @Step("Клик по кнопке: Личный кабинет")
    public void clickPersonalButton() {
        driver.findElement(LKButton).click();
    }
}