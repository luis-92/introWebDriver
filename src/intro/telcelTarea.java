package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class telcelTarea {


    static WebDriver driver;

    public static void main(String[] args) {
        navegarSitio("https://www.telcel.com");
        verificarLandingPage();
        listarTelefonos();
        seleccionarEstado("Jalisco");
        verificarPaginaResultados();
        Celular primerCelular;
        primerCelular = capturarDatosCelular(1);
        seleccionarCelular(1);
        validarDatosCelular(primerCelular);
    }



    private static void navegarSitio(String url) {
        driver = new ChromeDriver();

        driver.navigate().to(url);
    }

    private static void verificarLandingPage() {
        //verificar que existen estos elementos
//        logoTelcel:  css="[src='/content/dam/htmls/img/icons/logo-telcel.svg']"
        WebElement logoTelcel = driver.findElement(By.cssSelector("[src='/content/dam/htmls/img/icons/logo-telcel.svg']"));
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        WebElement campoBusqueda = driver.findElement(By.cssSelector("#buscador-menu-input"));
        driver.manage().window().maximize();
        if(logoTelcel.isDisplayed() &&
                tiendaEnLinea.isDisplayed() &&
                campoBusqueda.isDisplayed() && campoBusqueda.isEnabled()) {
            System.out.println("Si cargo la pagina principal de telcel");
        } else {
            System.out.println("No cargo la pagina");
            System.exit(-1);
        }
//        linkTiendaEnLinea:css="[data-nombreboton='Tienda en linea superior']"

//        campoBusqueda: css= "#buscador-menu-input" 


    }

    private static void listarTelefonos() {
        WebElement tiendaEnLinea = driver.findElement(By.cssSelector("[data-nombreboton='Tienda en linea superior']"));
        tiendaEnLinea.click();
        WebElement linkTelefonosCelulares = driver.findElement(By.cssSelector(".shortcut-container [data-nombreboton='Telefonos y smartphones']"));
        linkTelefonosCelulares.click();

    }


    private static void seleccionarEstado(String nombreEstado) {

        WebElement botonEstados = elementoEsperado(By.cssSelector(".chosen-single"));
        WebElement estado = driver.findElement(By.cssSelector(".chosen-search input"));
        WebElement botonEntrarEstado = driver.findElement(By.id("entrarPerfilador"));

        if(botonEstados.isDisplayed()&& botonEstados.isEnabled()){
            botonEstados.click();
            estado.sendKeys("Jalisco");
            estado.sendKeys(Keys.ENTER);
            botonEntrarEstado.click();

        }
    }

    private static void verificarPaginaResultados() {


    }

    private static Celular capturarDatosCelular(int i) {
        return null;
    }

    private static void seleccionarCelular(int numCelular) {
    }

    private static void validarDatosCelular(Celular primerCelular) {
    }

    private static WebElement  elementoEsperado(By by){
        //To wait for element visible
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement elementoEsperado = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return elementoEsperado;
    }
}
