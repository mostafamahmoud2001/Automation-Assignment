package Task1.PageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class TodayDeals {
    WebDriver driver ;
    String addedItem;
    @FindBy(xpath = "//a[@aria-labelledby=\"see-more-departments-label\"]")
    WebElement seeMoreDepartments;
    By itemsLoc = By.className("ProductCard-module__card_uyr_Jh7WpSkPx4iEpn4w");
    public String getCardXpath(int row){
        String xpath = "//div[@data-testid=\"virtuoso-item-list\"]/div[@data-index=\""+row+"\"]/div/div/div/div";
        System.out.println(xpath);
        return xpath;
    }

    public TodayDeals (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void getTheItems(){
        List<WebElement> items = driver.findElements(itemsLoc);
        System.out.println(items.size());

    }
    public void selectItem (int row){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        String xpath= getCardXpath(row);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int pixel = 0;
        while (true) {
            try {
                driver.findElements(By.xpath(xpath)).get(0).click();;
                break;
            } catch (Exception e) {
                js.executeScript("window.scrollTo(0, "+pixel+");");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            pixel+=300;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
