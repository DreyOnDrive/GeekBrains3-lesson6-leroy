import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasketPage extends BaseView {
    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public String getBasketPriceText(){
        webDriverWait.until(ExpectedConditions.jsReturnsValue("return document.querySelector(\"#root > uc-app >" +
                " uc-container > main > uc-basket\").shadowRoot.querySelector(\"section:nth-child(4) > div > h1\").textContent == \"Корзина\""));
        String basketPriceText = ((JavascriptExecutor) driver).executeScript("return document.querySelector(\"#root >" +
                " uc-app > uc-container > main > uc-basket\").shadowRoot.querySelector(\"section:nth-child(10) > aside > div >" +
                " div > div.summary-information-block__total > span.summary-information-block__total-price\").textContent").toString();
        basketPriceText = basketPriceText.substring(0, basketPriceText.length()-2).replaceAll("[^0-9/.]", "");
        return  basketPriceText;
    }

    public String getNameBasketItem (String item) {
        String nameBasketItem = null;
        if (item.equals("item1")){
            nameBasketItem = ((JavascriptExecutor) driver).executeScript("return document.querySelector(\"#root > uc-app >" +
                    " uc-container > main > uc-basket\").shadowRoot.querySelector(\"section:nth-child(10) > section >" +
                    " item-basket-card:nth-child(4)\").shadowRoot.querySelector(\"layout-basket-card > div > a\").textContent").toString();
        }
        if (item.equals("item2")){
            nameBasketItem = ((JavascriptExecutor) driver).executeScript("return document.querySelector(\"#root > uc-app >" +
                    " uc-container > main > uc-basket\").shadowRoot.querySelector(\"section:nth-child(10) > section >" +
                    " item-basket-card:nth-child(5)\").shadowRoot.querySelector(\"layout-basket-card > div > a\").textContent").toString();
        }
        return nameBasketItem;
    }


    public OrderPage clickOrderButton () {
        webDriverWait.until(ExpectedConditions.jsReturnsValue("return document.querySelector(\"#root > uc-app >" +
                " uc-container > main > uc-basket\").shadowRoot.querySelector(\"section:nth-child(4) > div > h1\").textContent == \"Корзина\""));
        ((JavascriptExecutor) driver).executeScript("return document.querySelector(\"#root > uc-app > uc-container > main" +
                " > uc-basket\").shadowRoot.querySelector(\"section:nth-child(12) > aside > div > div > uc-button > button\").click()");
        return new OrderPage(driver);
    }

}
