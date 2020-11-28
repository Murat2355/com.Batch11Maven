package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test03 {
    public static void main(String[] args) {
        //1. “https://www.saucedemo.com” Adresine gidin

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        //2. Username kutusuna “standard_user” yazdirin
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String UrunIsmi = ilkUrun.getText();
        ilkUrun.click();


        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrun = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepettekiUrunIsmi = sepettekiUrun.getText();
        if (UrunIsmi.equals(sepettekiUrunIsmi)){
            System.out.println("alısveris sepeti testi PASS");
        }else{
            System.out.println("alısveris sepeti testi FAİLED");
            System.out.println("sectigin urun ile sepetteki urun ayni degil");
        }
        //9. Sayfayi kapatin
        driver.close();
    }
}
