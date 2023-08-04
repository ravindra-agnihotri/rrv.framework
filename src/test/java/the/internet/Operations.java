package the.internet;

import base.DriverInvoker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Operations {
    public static WebDriver driver= DriverInvoker.getDriver();

    @Test(enabled = false)
    public void fileUpload(){
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("/Users/ravindraagnihotri/Documents/resume and my docs/Ravindra_Agnihotri_Resume.pdf");
        System.out.println(driver.getWindowHandle());
    }

    @Test
    public void windowOpen(){
        driver.get("https://the-internet.herokuapp.com/windows");
      String parentWindow=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
       Set<String> windows= driver.getWindowHandles();

        for (String s:windows) {
           if (!s.equals(parentWindow)){
               driver.switchTo().window(s);
           }
        }
        System.out.println(driver.getCurrentUrl());
        
    }
    //@Test
    public void foreach(){
        Set<String> collection= new HashSet<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        collection.add("d");
        for (String data:collection) {
            if (data.equals("c"))
            System.out.println(data);
        }




    }
}
