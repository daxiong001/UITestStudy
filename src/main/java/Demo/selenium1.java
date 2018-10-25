package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class selenium1 {
    public static void main(String[] args) {
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\WorkSpace\\UITestStudy\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.imooc.com/user/newlogin/from_url");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("立即注册")).click();
        driver.findElement(By.partialLinkText("直接")).click();
        driver.findElement(By.name("email")).sendKeys("17576075478");
        driver.findElement(By.name("password")).sendKeys("daixiongkun");
        WebElement ele = driver.findElement(By.id("auto-signin"));
        if (ele.isSelected()){
            driver.findElement(By.className("moco-btn")).click();
        }else {
            ele.click();
            driver.findElement(By.className("moco-btn")).click();
        }
        driver.findElement(By.tagName("input")).click();
        driver.get("https://www.imooc.com/");
        WebElement element = driver.findElement(By.className("nav-item"));
        List<WebElement> elements = element.findElements(By.tagName("li"));
        elements.get(3).click();

    }
}
