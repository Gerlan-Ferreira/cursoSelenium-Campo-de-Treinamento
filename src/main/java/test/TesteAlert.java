package test;

import static core.DriverFactory.killDriver;
import static core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;



public class TesteAlert {
	
	@Before
	public void inicializar() {
		
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
	}

	
	@After public void finaliza() { 
		
		killDriver();
		
	}
	
	@Test
	public void deveInteragirComAlertSimples() {
		
		getDriver().findElement(By.id("alert")).click();
		
		//Mudar o foco da tela para o Alert do JS
		Alert alertFire = getDriver().switchTo()
				.alert(); /* Como alert(); retorna um objeto de Alert tem que instanciar ele.*/
		
		//Armazenando o texto do alert em uma variavel para setar ele no formulario
		String texto = alertFire.getText();
		
		Assert.assertEquals("Alert Simples", alertFire.getText());
		
		//Aceitando o Alert
		alertFire.accept();
		
		//Setando valor dentro de um campo de formulario com o texto que o alert está retornando.
		getDriver().findElement(By.id("elementosForm:nome")).sendKeys(texto);
				
	}
	@Test
	public void deveInteragirComAlertConfirm() {
	
		getDriver().findElement(By.id("confirm")).click();
	
		Alert alertFire = getDriver().switchTo().alert();
		
		Assert.assertEquals("Confirm Simples", alertFire.getText());
		
		//Aceitando o alert
		alertFire.accept();
		
		Assert.assertEquals("Confirmado", alertFire.getText());
		
		//Aceitando a msg de bloqueio do navegador para poder clicar novamente
		alertFire.accept();
		
		
		//Clicando de novo para "cancelar" o alert
		
		getDriver().findElement(By.id("confirm")).click();
		
		//Setando o foco no alert
		alertFire = getDriver().switchTo().alert();
		
		Assert.assertEquals("Confirm Simples", alertFire.getText());
		 	
		//Cancelando o alert
		alertFire.dismiss();
		
		Assert.assertEquals("Negado", alertFire.getText());
		
		//Aceitando a msg de bloqueio do navegador para poder clicar novamente
		alertFire.accept();
		
	}
	
	@Test
	public void deveInteragirComAlertPrompt() {
	
		getDriver().findElement(By.id("prompt")).click();
	
		Alert alertFire = getDriver().switchTo().alert();
		
		Assert.assertEquals("Digite um numero", alertFire.getText());
		
		//Escrevendo no prompt
		alertFire.sendKeys("666");
		
		alertFire.accept();
		
		Assert.assertEquals("Era 666?", alertFire.getText());
		
		alertFire.accept();
		
		Assert.assertEquals(":D", alertFire.getText());
		
		alertFire.accept();

	}
}
