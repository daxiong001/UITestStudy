package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActionSelenium {
    public WebDriver driver;
    /*初始化浏览器驱动*/
    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\WorkSpace\\UITestStudy\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");   //设置浏览器静默模式，后台运行浏览器
        driver = new ChromeDriver(options);
        driver.get("http://www.imooc.com/user/newlogin/from_url");
        driver.manage().window().maximize();
    }

    public void inputBox(){
        driver.findElement(By.name("email")).sendKeys("17576075478");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("email")).clear();
    }

    public static void main(String[] args) {
        ActionSelenium as = new ActionSelenium();
        as.InitDriver();
        as.inputBox();
    }
}
