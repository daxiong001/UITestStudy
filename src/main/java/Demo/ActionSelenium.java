package Demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class ActionSelenium {
    /*初始化浏览器驱动*/
    public WebDriver driver;
    public void InitDriver(){
        //System.setProperty("webdriver.chrome.driver","D:\\WorkSpace\\UITestStudy\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","E:\\StudyWorkspace\\src\\main\\resources\\chromedriver.exe");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");   //设置浏览器静默模式，后台运行浏览器
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.get("http://www.imooc.com/user/newlogin/from_url");
        driver.manage().window().maximize();
    }

    /*操作input输入框*/
    public void inputBox(){
        driver.findElement(By.name("email")).sendKeys("17576075478");
        driver.findElement(By.name("password")).sendKeys("daixiongkun123");
        driver.findElement(By.className("moco-btn")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*操作单选框*/
    public void radioBox(){
        driver.get("https://www.imooc.com/user/setprofile");
        driver.findElement(By.className("pull-right")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"profile\"]/div[4]/div/label//input"));//定位到label下的当前选中的input元素
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //循环到下一个元素
        for (WebElement radio:elements
             ) {
            boolean flag = radio.isSelected();
            //判断是否被选中
            if (flag == false){
                radio.click();
                break;
            }else {
                System.out.println("选中了");
            }
        }
    }

    /*多选框*/
    public void checkBox(){
        WebElement check = driver.findElement(By.id("auto-signin"));
        System.out.println("是否选中"+check.isSelected());//判断是否选中
        System.out.println("是否有效"+check.isEnabled());//判断是否有效
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        check.click();
    }

    /*按钮*/
    public void button(){
        WebElement login = driver.findElement(By.className("moco-btn"));
        System.out.println("是否有效"+login.isEnabled());
        System.out.println(login.getAttribute("value"));//获取当前按钮属性值
        login.click();
    }

    /*表单form*/
    public void webForm(){

    }

    /*上传文件*/
    public void upFile(){
        driver.get("https://www.imooc.com/user/setbindsns");
        String jsString = "document.getElementsByClassName(\"update-avator\")[0].style.bottom=\"0\"";
        JavascriptExecutor js = (JavascriptExecutor) driver;//将driver强制转换成js类型
        js.executeScript(jsString);//将字符串转换成js
        driver.findElement(By.className("js-avator-link")).click();
        driver.findElement(By.id("upload")).sendKeys("C:\\Users\\Administrator\\Desktop\\1.png");
        driver.findElement(By.linkText("确定")).click();
    }

    /*下拉框*/
    public void selectBox(){
        driver.get("https://www.imooc.com/user/setprofile");
        driver.findElement(By.linkText("编辑")).click();
        WebElement ele = driver.findElement(By.id("profile"));//层级定位，先定位父节点
        WebElement element = ele.findElement(By.id("job"));//再定位子节点
        Select select = new Select(element);//创建一个下拉框对象
        //select.selectByValue("5");//通过具体的value值选择
        //select.selectByIndex(2);//通过角标选择
        select.selectByVisibleText("移动开发工程师");//通过显示出来的文本值选择
    }

    public static void main(String[] args) {
        ActionSelenium as = new ActionSelenium();
        as.InitDriver();
        //as.checkBox();
        as.inputBox();
        //as.radioBox();
        //as.button();
        //as.upFile();
       // as.selectBox();
        as.selectBox();
    }
}




