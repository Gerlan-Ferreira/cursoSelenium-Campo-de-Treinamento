package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	/*Método para Instanciar o driver*/
	public static WebDriver getDriver() {
	/*O método está estático para que não precise instanciar ele nas outras classes ao chamar.*/
		
		if (driver == null) {
		/*Criando um switch para qual browser irá ser executado de acordo com o que foi setado na Enum*/
			switch (Propriedades.browser) {
			
			case FIREFOX:
				
				driver = new FirefoxDriver();
				
				break;
				
			case CHROME:
				
				driver = new ChromeDriver();
				
				break;
			}
			driver.manage().window().setSize(new Dimension (1200,765));
			
		}
		
		return driver;
	}

	/*Método para Finalizar o driver*/
	public static void killDriver() {
		
		if (driver != null) {
			
			driver.quit();
			driver = null;
			
		}
	}

}
