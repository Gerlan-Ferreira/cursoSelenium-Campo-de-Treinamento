package test;

import static core.DriverFactory.killDriver;
import static core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DSL;

public class TesteSincronismo {
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
	public void deveUtilizarEsperaFixa () throws InterruptedException {
													/*Esse throws ele captura os erros e nos mostra*/ 
		
		
		dsl.clicarBotaoFirefox("buttonDelay"); //Ao clicar nesse botão há um delay para abrir o campo de texto
		
		//Espera Fixa
		Thread.sleep(5000);
		/*Esse método serve para que o selenium espere 5 segundos para poder 
		executar o próximo método logo abaixo, e com isso conseguir escrever*/
		
		
		dsl.escreveFirefox("novoCampo", "Deu certo");
		
	}
	
	@Test
	public void deveUtilizarEsperaImplicita () throws InterruptedException {
		
		dsl.clicarBotaoFirefox("buttonDelay");
		
		//Espera Implícita
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*Fazendo com que o driver fique esperando até 5 segundos de forma implicita até realizar o método abaixo.
		 * Caso o campo TextField apareça em menos que 5 segundos ele escreverá antes de acabar o tempo, e caso estoure
		 * os 5 segundos ele não apareça, será informado uma msg de erro, ou seja, essa é a ideia da Espera Implicita*/
		
		
		dsl.escreveFirefox("novoCampo", "Deu certo");
		
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//Zerando o tempo para não influenciar nos outros testes
		
	}
	
	@Test
	public void deveUtilizarEsperaExplicita () throws InterruptedException {
		/*Na espera explicita vc nao define um valor específico para toda a aplicação. Ao invés disso
		 nos pontos onde estão aparecendo falha de sincronismo, vc define explicitamente uma espre para esse elemento.*/
		
		dsl.clicarBotaoFirefox("buttonDelay");
		
		//Espera Explícita
		WebDriverWait wait = new WebDriverWait(getDriver(), 30); //Ele irá esperar para realizar a ação por até 30 segundos
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		/*Esse método acima irá esperar até que o campo de texto apareça, assim que ele 
		 aparecer irá executar o método abaixo. Caso ele não apareça não será feito nada.*/
		
		
		dsl.escreveFirefox("novoCampo", "Deu certo");
		
	}

}
