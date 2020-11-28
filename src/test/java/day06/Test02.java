package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test02 {
    public static void main(String[] args) {
        //1. http://zero.webappsecurity.com sayfasina gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com");
        driver.manage().window().maximize();
        // 2. Signin buttonuna tiklayin

        WebElement signInTıkla = driver.findElement(By.id("signin_button"));
        signInTıkla.click();


        // 3. Login alanine  “username” yazdirin

        WebElement loginUser = driver.findElement(By.xpath("//input[@id='user_login']"));
        String userName = "username";
        loginUser.sendKeys(userName);

        // 4. Password alanine “password” yazdirin
        WebElement loginPsw = driver.findElement(By.xpath("//input[@id='user_password']"));
        String password = "password";
        loginPsw.sendKeys(password);

        // 5. Sign in buttonuna tiklayin
        WebElement signin = driver.findElement(By.xpath("//input[@type='submit']"));
        signin.submit();

        // 6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();


        // 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement paraYatir = driver.findElement(By.id("sp_amount"));
        String paraEkle = "2000";
        paraYatir.sendKeys(paraEkle);
        // 8. tarih kismina “2020-09-10”
        WebElement tarihKutusu = driver.findElement(By.id("sp_date"));
        tarihKutusu.sendKeys("2020-09-10");

        // 9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        // 10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement basariYazisi = driver.findElement(By.id("alert_content"));
        if (basariYazisi.isDisplayed()) {
            System.out.println("test PASS");

        }else{
            System.out.println("Test FAILED");
        }
        driver.close();

    }
}
