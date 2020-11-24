package test;

import static core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.BaseTest;
import core.DSL;
import page.CampoTreinamentoPage;


public class TesteCadastroComSucesso extends BaseTest{
	
	private DSL dsl;
	private CampoTreinamentoPage pageCadastro;
	
	@Before
	public void inicializar() {
		
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		dsl = new DSL();
		
		pageCadastro = new CampoTreinamentoPage();
		
	}

	


	@Test
	public void TesteDesafioCadastrComSucesso() {
	
		/*
		 * driverFirefox.findElement(By.id("elementosForm:nome")).sendKeys("Gerlan");
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:sobrenome")).sendKeys(
		 * "Ferreira");
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:sexo:0")).click();
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		 * 
		 * WebElement elementFire =
		 * driverFirefox.findElement(By.id("elementosForm:escolaridade"));
		 * 
		 * Select comboFire = new Select(elementFire);
		 * 
		 * comboFire.selectByVisibleText("Superior");
		 * 
		 * elementFire = driverFirefox.findElement(By.id("elementosForm:esportes"));
		 * 
		 * Select comboFire2 = new Select(elementFire);
		 * 
		 * comboFire2.selectByVisibleText("Futebol");
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:sugestoes")).
		 * sendKeys("Galego mortooo!");
		 * 
		 * driverFirefox.findElement(By.id("elementosForm:cadastrar")).click();
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("resultado")).getText().
		 * contains("Cadastrado!"));
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descNome")).getText().
		 * contains("Gerlan"));
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descSobrenome")).getText()
		 * .contains("Ferreira"));
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descSexo")).getText().
		 * contains("Masculino"));
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descComida")).getText().
		 * contains("Pizza"));
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descEscolaridade")).
		 * getText().contains("superior"));
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descEsportes")).getText().
		 * contains("Futebol"));
		 * 
		 * Assert.assertTrue(driverFirefox.findElement(By.id("descSugestoes")).getText()
		 * .contains("Galego mortooo!"));
		 * 
		 * driverFirefox.quit();
		 
	
	//Outra forma de verificar string na pagina é usando o startsWhit() ele verifica se inicia com:
	//Assert.assertTrue(driverFirefox.findElement(By.id("resultado")).getText()
	//.startsWith(driverFirefox.findElement(By.id("resultado")).getText()));
	
	//A outra forma é o endsWhit() ele verifica se termina com:
	//Assert.assertTrue(driverFirefox.findElement(By.id("resultado")).getText()
	//.endsWith(driverFirefox.findElement(By.id("descNome")).getText()));
		 */
	
					//Usando a DSL
		/*
		 * dsl.escreveFirefox("elementosForm:nome", "Gerlan");
		 * 
		 * dsl.escreveFirefox("elementosForm:sobrenome", "Ferreira");
		 * 
		 * dsl.clicarRadioFirefox("elementosForm:sexo:0");
		 * 
		 * dsl.clicarRadioFirefox("elementosForm:comidaFavorita:2");
		 * 
		 * dsl.selecionarComboFirefoxValue("elementosForm:escolaridade", "superior");
		 * 
		 * dsl.selecionarComboFirefoxValue("elementosForm:esportes", "futebol");
		 * 
		 * dsl.escreveFirefox("elementosForm:sugestoes", "Galego mortooo!");
		 * 
		 * dsl.clicarBotaoFirefox("elementosForm:cadastrar");
		 * 
		 * Assert.assertTrue(dsl.VerificarTextoNoInicioFirefox("resultado"));
		 * 
		 * Assert.assertTrue (dsl.obterTextoFirefox("descNome")
		 * .endsWith(dsl.obterTextoFirefox("elementosForm:nome")));
		 * 
		 * Assert.assertTrue (dsl.obterTextoFirefox("descSobrenome")
		 * .endsWith(dsl.obterTextoFirefox("elementosForm:sobrenome")));
		 * 
		 * Assert.assertTrue (dsl.obterTextoFirefox("descSexo")
		 * .endsWith(dsl.obterTextoFirefox("elementosForm:sexo:0")));
		 * 
		 * Assert.assertTrue (dsl.obterTextoFirefox("descComida")
		 * .endsWith(dsl.obterTextoFirefox("elementosForm:comidaFavorita:2")));
		 * 
		 * Assert.assertTrue (dsl.obterTextoFirefox("descEscolaridade")
		 * .endsWith(dsl.obterValorComboFirefox("elementosForm:escolaridade").
		 * toLowerCase()));
		 * 
		 * Assert.assertTrue (dsl.obterTextoFirefox("descEsportes")
		 * .endsWith(dsl.obterValorComboFirefox("elementosForm:esportes")));
		 * 
		 * Assert.assertTrue (dsl.obterTextoFirefox("descSugestoes")
		 * .endsWith(dsl.obterTextoFirefox("elementosForm:sugestoes")));
		 * 
		 * 
		 */	
		
	//Usando o padrão Page Object
	
	pageCadastro.setNome("Gerlan");
	pageCadastro.setSobrenome("Ferreira");
	pageCadastro.setSexoMasculino();
	pageCadastro.setComidaPizza();
	pageCadastro.setEscolaridade("Superior");
	pageCadastro.setEsporte("Futebol");
	pageCadastro.Cadastrar();
	
	Assert.assertEquals("Cadastrado!", pageCadastro.obterResultadoCadastro());
	
	Assert.assertEquals(dsl.obterValorCampoFirefox("elementosForm:nome"), pageCadastro.obterNomeCadastro());

	Assert.assertEquals(dsl.obterValorCampoFirefox("elementosForm:sobrenome"),pageCadastro.obterSobrenomeCadastro());
	
	Assert.assertEquals(dsl.obterValorLabelByXpath("'elementosForm:sexo:0'") , pageCadastro.obterSexoCadastro());
	
	Assert.assertEquals(dsl.obterValorLabelByXpath("'elementosForm:comidaFavorita:2'") , pageCadastro.obterComidaCadastro());
	
	Assert.assertEquals(dsl.obterValorComboFirefox("elementosForm:escolaridade").toLowerCase() , pageCadastro.obterEscolaridadeCadastro());

	Assert.assertEquals(dsl.obterValorComboFirefox("elementosForm:esportes"), pageCadastro.obterEsporteCadastro());
	
	Assert.assertEquals(dsl.obterTextoFirefox("elementosForm:sugestoes"), pageCadastro.obterSugestoesCadastro());

	}
	
}

