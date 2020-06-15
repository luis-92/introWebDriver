package testcases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SongsSinatraParent {
    public static WebDriver driver;


    public static void navegar(String url) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);;
    }


    public static void realizarLoginCorrecto(String usuario, String password) {
        WebElement linkLogin = driver.findElement(By.linkText("log in"));
        linkLogin.click();
        WebElement usernameTxt = driver.findElement(By.id("username"));
        WebElement passwordTxt = driver.findElement(By.id("password"));
        usernameTxt.sendKeys(usuario);
        passwordTxt.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.cssSelector("[value='Log In']"));
        loginBtn.click();
    }


    public static void validarHomePage() {
        WebElement imgSinatra = driver.findElement(By.cssSelector("[src='/images/sinatra.jpg']"));
        WebElement linkLogin = driver.findElement(By.linkText("log in"));
        if(imgSinatra.isDisplayed() && linkLogin.isDisplayed()){
            System.out.println("Se cargó la página principal");
        }else{
            System.err.println("No se cargó");
            System.exit(-1);
        }
    }


    public static void validarMensajeBienvenida(String mensajeBienvenida) {
        WebElement mensajeBienvenidaElement = driver.findElement(By.id("flash"));
        WebElement linkLogout = driver.findElement(By.cssSelector("[href='/logout']"));
        if(mensajeBienvenidaElement.getText().equals(mensajeBienvenida) && linkLogout.isDisplayed()){
            System.out.println("Pasó");
        }else{
            System.err.println("No pasó");
        }
    }


    public static void cerrarBrowser() {
        driver.quit();
    }
}










