package Task1.PageOpject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class ShoppingCart {
    WebDriver driver ;
    String addedItem;
    @FindBy(className = "sc-list-item-content")
    List<WebElement> items;
    public ShoppingCart (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean checkTheItem(String itemName){
        for(WebElement item:items) {
            String itemTextInShoppingCart = item.findElement(By.className("sc-grid-item-product-title")).getText();
            itemTextInShoppingCart = itemTextInShoppingCart.substring(0, itemTextInShoppingCart.length() - 3);
            if(itemName.contains(itemTextInShoppingCart))
            {
                System.out.println(itemName);
                System.out.println(itemTextInShoppingCart);
                return true;
            }
        }
        return false;
    }

}
