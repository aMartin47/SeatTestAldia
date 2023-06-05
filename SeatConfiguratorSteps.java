import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeatConfiguratorSteps {

	@Given("^Usuario accede a la página de Seat$")
	public void goToURL (){
		//Accedemos a la página del configurador de Seat
		driver.get("https://configurador.seat.es/");
	}
	
	@When("^selecciona el model seat ibiza$")
	public void selectModel () {
		//buscamos y clicamos en el modelo deseado
		WebElement model = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//main[@class='vertical']/div[text()='IBIZA']")));
        model.click();
	}
	
	@And("^selecciona la version FR XS$")
	public void selectVersion () {
		//buscamos y seleccionamos la version deseada
		WebElement version = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'start-config-button')]//seat-button)));
        version.click();
	}
															  
	@And("^continuar con los valores por defecto$")
	public void continueDefault () {
		//pulsamos en siguiente dejando los valores por defecto hasta que muestre el código de configuración del vehículo
		WebElement btnContinue = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//footer//b[text()='Siguiente']")));
		//Continuamos sin elegir motor     
        	btnContinue.click();
		//Continuamos sin elegir color ni llantas     
		btnContinue.click();
		//Continuamos sin elegir tapicería     
		btnContinue.click();
		//Continuamos sin añadir paquetes     
		btnContinue.click();													     
	}														  

	@Then("^accedemos a la última página y descargamos la configuración$")
	public void showConfiguration () {
		//Descargamos la configuración del vehículo
		WebElement btnDownload = new WebDriverWait(driver, 10).untirl(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'descarga tu configuración')]")));
		btnDownload.click();												      
	}
	//Cerramos el navegador
	driver.quit();
	
}
