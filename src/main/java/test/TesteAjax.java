package test;

import static core.DriverFactory.killDriver;
import static core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DSL;

public class TesteAjax {
	
	private DSL dsl;
	

	@Before
	public void inicializar() {
		
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void testAjax() {
		//j_idt725:name
		//span[.='Submit']
		//span[@id='j_idt725:display']
		
		dsl.escreveFirefox("j_idt725:name", "Teste");
		
		dsl.clicarBotaoFirefox("j_idt725:j_idt728");
		
		//Utilizando a espera explícita
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		
		/*Esperando até que o texto que foi escrito na caixa de texto apareça.*/
			
		//wait.until(ExpectedConditions.textToBe(By.id("j_idt725:display"), "Teste"));
		
		
		/*Esperando até que a imagem de "Loading" que aparece ao clicar no botão de Submit desapareça*/
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt799_start")));
		
		Assert.assertEquals("Teste", dsl.obterTextoByFirefox(By.id("j_idt725:display")));
		
	}

}
