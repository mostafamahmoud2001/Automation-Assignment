package Task1.PageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemPage {
    WebDriver driver ;
    @FindBy(id = "add-to-cart-button")
    WebElement addToCartBtn;
    By selectSizeText = By.xpath("//span[text()=\" To buy, select \"]");
    By sizeDropdown= By.xpath("//span[@data-csa-c-content-id=\"dropdown_selected_size_name\"]");
    By firstSize = By.xpath("id=\"native_dropdown_selected_size_name_2\"");
    By messageLoc = By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS");
    public ItemPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
   public void addToCart()
   {
       boolean sizeable = false;
       try {
           sizeable = driver.findElement(selectSizeText).isDisplayed();
       }catch (Exception e){
           System.out.println("doesn't need to select the size");
       }
        if(sizeable){
            driver.findElement(sizeDropdown).click();
            driver.findElement(firstSize).click();
            addToCartBtn.click();
        }
        else {addToCartBtn.click();}
   }
   public String getMessageAfterAdding(){return driver.findElement(messageLoc).getText();}

}
