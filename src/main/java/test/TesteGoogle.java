package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteGoogle {
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * //Configurando o driver para o firefox 
	 * WebDriver driver = new FirefoxDriver();
	 * 
	 * //Acessando o site 
	 * driver.get("https://www.portalmenew.com.br");
	 * 
	 * //pritando no console o title da pagina
	 * System.out.println(driver.getTitle()); }
	 */
	
	//Usando o JUnit
	@Test
	public void teste() {
		
		WebDriver driverFirefox = new FirefoxDriver();
		WebDriver driverChrome = new ChromeDriver();
		
		driverChrome.get("https://www.portalmenew.com.br");
		driverFirefox.get("https://www.portalmenew.com.br");
		
		//Ajustando a posição da tela do browser
		driverFirefox.manage().window().setPosition(new Point(100,100));
		driverChrome.manage().window().setPosition(new Point(100,100));
		
		//Ajustando o tamanho da tela do browser
		driverFirefox.manage().window().setSize(new Dimension(1200,765));
		driverChrome.manage().window().setSize(new Dimension(1200,765));
		
		//Maximizar a tela
		driverFirefox.manage().window().maximize();
		driverChrome.manage().window().maximize();
		
		//Comparando o valor do title usando Junit
		Assert.assertEquals("Portal Menew | MVarandas Tecnologia", driverChrome.getTitle());
		Assert.assertEquals("Portal Menew | MVarandas Tecnologia", driverFirefox.getTitle());
		
		//Fechando o browser automaticamente
		driverFirefox.quit();
		driverChrome.quit();
	
	}

}
