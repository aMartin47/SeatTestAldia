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
		WebElement version = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'start-config-button')]//seat-button));
        version.click();
	}

	@Then("^accede a la configuración$")
	public void showConfiguration () {
		//comprobamos que hemos llegado a la página de configuración. Ya que no tiene un título, comprobamos que existe la frase "Elegir motor" ya que es el primer paso dentro de la configuración del vehículo
		Assertions.assertEquals(driver.findElement(By.xpath("//*[text()='Elegir motor']"), "Elegir motor");
	}
	//Cerramos el navegador
	driver.quit();
	
}