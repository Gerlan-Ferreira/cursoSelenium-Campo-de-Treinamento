package test;

import static core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.DSL;

public class TestePrimeFace {
	
	private DSL dsl;
	

	@Before
	public void inicializar() {
		
		dsl = new DSL();
		
	}
	
	@After
	public void finaliza() {
		//killDriver();
	}
	
	@Test
	public void deveInteragirComRadioPrimeFace() {
		
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		
		dsl.clicarRadioByFirefox(By.xpath("//input[@id='j_idt726:console:0']/../..//span"));
		
		dsl.isRadioMarcadoFirefox("j_idt726:console:0");
		
		//Outra forma de clicar no mesmo Radio pois o ID desse radio é dinamico, então podemos usar o texto do radio.
		dsl.clicarRadioByFirefox(By.xpath("//label[.='PS4']/..//span"));
		
		dsl.isRadioMarcadoFirefox("j_idt726:console:1");
		
	}
	
	@Test
	public void desafioPrimeFaceAula59 () {
		
		//j_idt726:console_input
		//PS4
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		
		dsl.clicarRadioByFirefox(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-s ui-c'][1]"));
		dsl.clicarRadioByFirefox(By.xpath("//ul[@id='j_idt726:console_items']//li[.='PS4']"));
		
		System.out.println(dsl.obterValorLabelByXpathId("j_idt726:console_label"));
		Assert.assertEquals("PS4", dsl.obterValorLabelByXpathId("j_idt726:console_label"));
		
	}
	

}
