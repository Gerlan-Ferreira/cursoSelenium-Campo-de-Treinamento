package test;

import static core.DriverFactory.killDriver;
import static core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.DSL;


public class TestesFramesEJanelas {
	
	private DSL dsl;
	

	@Before
	public void inicializar() {

		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		dsl = new DSL();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	@Test
	public void deveInteragirComFrames() {
	
	//Mudando o foco do selenium para dentro de um Frame
	getDriver().switchTo().frame("frame1");
	
	getDriver().findElement(By.id("frameButton")).click();
	
	Alert alertFire = getDriver().switchTo().alert();
	
	String txt = alertFire.getText();
	
	Assert.assertEquals("Frame OK!", txt);
	
	alertFire.accept();
	
	//Trazendo o foco do selenium para a pagina principal devido a termos iniciado o foco no Frame
	getDriver().switchTo().defaultContent();
	
	getDriver().findElement(By.id("elementosForm:nome")).sendKeys(txt);

	}
	
	@Test
	public void deveInteragirComJanelas() {
	
	getDriver().findElement(By.id("buttonPopUpEasy")).click();
	
	//Mudando o foco do selenium para dentro de uma Janela de PopUp
	getDriver().switchTo().window("Popup");
	
	getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	
	getDriver().close();
	
	//Retornando para a tela principal
	getDriver().switchTo().window("");
	
	getDriver().findElement(By.tagName("textarea")).sendKeys("e agora?");
	}
	
	@Test
	public void deveInteragirComJanelasSemTitulo() {
		
	getDriver().findElement(By.id("buttonPopUpHard")).click();
	
	/* Imprimindo o ID de uma janela que não possui ID */
	System.out.println(getDriver().getWindowHandle());
	
	/* Imprimindo vários ID's das janelas que não possuem ID */
	System.out.println(getDriver().getWindowHandles());
	
	/*Mudando o foco para a janela utilizando o seu ID atraves do getWindowhandles, transformando em um 
	array e pegando o valor do seu segundo índice. Também tem que fazer um CAST para String por conta do 
	switchTo().window*/
	getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
	
	getDriver().findElement(By.tagName("textarea")).sendKeys("Deu certo?");
	
	/* Mudando o foco para a janela principal*/
	getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[0]);
	
	getDriver().findElement(By.tagName("textarea")).sendKeys("E agora?");
	
	}
	
	@Test
	public void interagirComFrameEscondido() {
		
		WebElement frame = getDriver().findElement(By.id("frame2"));
		/*Usando o comando window.scrollBy para fazer com que o JS ajuste o botão para ficar visível 
		 * dentro da tela, usando as coordenadas X e Y da tela. Nesse caso capturamos o Y pois o botão
		 * se move verticalmente de cima para baixo e deixamos o X que é na horizontal zerado. Capturamos
		 * essas coordenadas com o método getlocation() */
		dsl.executarJS("window.scrollBy(0, arguments[0])",frame.getLocation().y);
		dsl.entrarFrame("frame2");
		dsl.clicarBotaoFirefox("frameButton");
		String txt = dsl.ObterTextoAlertFirefox();
		dsl.aceitaAlertFirefox();
		Assert.assertEquals("Frame OK!", txt);
		
	}
	
	
}
