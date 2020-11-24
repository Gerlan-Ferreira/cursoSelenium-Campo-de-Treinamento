package test;

import static core.DriverFactory.killDriver;
import static core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.DSL;
import page.CampoTreinamentoPage;

public class TesteValidarRegrasDeNegocio {
	
	private DSL dsl;
	private CampoTreinamentoPage pageCadastro;
	
	@Before
	public void inicializar() {
		
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	
		dsl = new DSL();
	
		pageCadastro = new CampoTreinamentoPage();
	
	}


	@After public void finaliza() { 
	
		killDriver();
	
	}
	 
	
	@Test
	public void ValidarCamposFirefox() {
		
		/*
		 * driverFirefox.findElement(By.id("elementosForm:cadastrar")).click();
		 * 
		 * Alert alertFireNome = driverFirefox.switchTo().alert();
		 * 
		 * String txtNome = alertFireNome.getText();
		 * 
		 * Assert.assertEquals("Nome eh obrigatorio", txtNome);
		 * 
		 * alertFireNome.accept();
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:nome")).sendKeys("Gerlan");
		 * 
		 * 
		 * //Sobrenome
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:cadastrar")).click();
		 * 
		 * Alert alertFireSobreNome = driverFirefox.switchTo().alert();
		 * 
		 * String txtSobreNome = alertFireSobreNome.getText();
		 * 
		 * Assert.assertEquals("Sobrenome eh obrigatorio", txtSobreNome);
		 * 
		 * alertFireSobreNome.accept();
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:sobrenome")).sendKeys(
		 * "Ferreira");
		 * 
		 * //Sexo
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:cadastrar")).click();
		 * 
		 * Alert alertFireSexo = driverFirefox.switchTo().alert();
		 * 
		 * String txtSexo = alertFireSexo.getText();
		 * 
		 * Assert.assertEquals("Sexo eh obrigatorio", txtSexo);
		 * 
		 * alertFireSexo.accept();
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:sexo:0")).click();
		 * 
		 * //Qual sua Comida favorita?
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:cadastrar")).click();
		 * 
		 * Alert alertFireComidaFavorita = driverFirefox.switchTo().alert();
		 * 
		 * String txtComidaFavorita = alertFireComidaFavorita.getText();
		 * 
		 * Assert.assertEquals("Tem certeza que voce eh vegetariano?",
		 * txtComidaFavorita);
		 * 
		 * alertFireComidaFavorita.accept();
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		 * 
		 * //Pratica Esportes?
		 * 
		 * Select comboFireEsportes = new
		 * Select(driverFirefox.findElement(By.id("elementosForm:esportes")));
		 * 
		 * comboFireEsportes.selectByVisibleText("Corrida");
		 * 
		 * comboFireEsportes.selectByVisibleText("O que eh esporte?");
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:cadastrar")).click();
		 * 
		 * Alert alertFireEsportes = driverFirefox.switchTo().alert();
		 * 
		 * String txtEsportes = alertFireEsportes.getText();
		 * 
		 * Assert.assertEquals("Voce faz esporte ou nao?", txtEsportes);
		 * 
		 * alertFireEsportes.accept();
		 * 
		 * comboFireEsportes.deselectByVisibleText("O que eh esporte?");
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:cadastrar")).click();
		 * 
		 * //Validando o resultado do que foi inserido
		 * Assert.assertTrue(driverFirefox.findElement(By.id("resultado")).getText()
		 * .endsWith(driverFirefox.findElement(By.id("resultado")).getText()));
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descNome")).getText()
		 * .endsWith(driverFirefox.findElement(By.id("descNome")).getText()));
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descSobrenome")).getText()
		 * .endsWith(driverFirefox.findElement(By.id("descSobrenome")).getText()));
		 * 
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descSexo")).getText()
		 * .endsWith(driverFirefox.findElement(By.id("descSexo")).getText()));
		 * 
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descComida")).getText()
		 * .endsWith(driverFirefox.findElement(By.id("descComida")).getText()));
		 * 
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descEscolaridade")).
		 * getText()
		 * .endsWith(driverFirefox.findElement(By.id("descEscolaridade")).getText()));
		 * 
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descEsportes")).getText()
		 * .endsWith(driverFirefox.findElement(By.id("descEsportes")).getText()));
		 * 
		 * driverFirefox.quit();
		 */
		
		
		pageCadastro.setNome("Gerlan");
		pageCadastro.setSobrenome("Ferreira");
		pageCadastro.setSexoMasculino();
		pageCadastro.setComidaCarne();
		pageCadastro.setEsporte("Futebol","O que eh esporte?");
		pageCadastro.Cadastrar();
		
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.ObterTextoAlertFirefox());
		dsl.aceitaAlertFirefox();
		
	}
	
}
