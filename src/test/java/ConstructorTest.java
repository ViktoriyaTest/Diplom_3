import api.RestClient;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pagemobject.MainPage;

public class ConstructorTest extends Driver {
    MainPage mainPage;

    @Before
    public void setUp() {
        webDriver();
        mainPage = new MainPage(driver);
        driver.get(RestClient.BASE_URL);
    }

    @Test
    @DisplayName("Переход в блок: Соусы")
    public void SaucesBlockTest() {
        mainPage.clickSauce();
        Assert.assertTrue("Соусы не активны", mainPage.isSauceActive());
    }

    @Test
    @DisplayName("Переход в блок: Начинки")
    public void FillingBlockTest() {
        mainPage.clickFilling();
        Assert.assertTrue("Начинки не активны", mainPage.isFillingActive());
    }

    @Test
    @DisplayName("Переход в блок: Булки")
    public void BunBlockTest() {
        mainPage.clickFilling();
        mainPage.clickBun();
        Assert.assertTrue("Булки не активны", mainPage.isBunButton());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}