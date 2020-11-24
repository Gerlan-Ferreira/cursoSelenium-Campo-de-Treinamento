package test;

import static core.DriverFactory.killDriver;
import static core.DriverFactory.getDriver;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.DSL;

public class TesteCampoTreinamento {
	
	//instanciando a DSL
	private DSL dsl;
	
	/*Utilizando a anotação @Before faz com que antes de todos os testes seja rodado esse método criado. 
	  Mas uma maneira de reutilizar código	*/
	@Before
	public void inicializar() {

		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		dsl = new DSL();
	}
	
	/*Utilizando a anotação @After faz com que depois de todos os testes seja rodado esse método criado. 
	  Mas uma maneira de reutilizar código	*/
	@After
	public void finaliza() {
		killDriver();
	}
	
//	@Test
//	public void teste() {
//		
//		WebDriver driverFirefox = new FirefoxDriver();
//		WebDriver driverChrome = new ChromeDriver();
//		
//		getDriver().manage().window().maximize();
//		driverChrome.manage().window().maximize();
//
//		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		driverChrome.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
//		
//		Assert.assertEquals("Campo de Treinamento", getDriver().getTitle());
//		Assert.assertEquals("Campo de Treinamento", driverChrome.getTitle());
//		
//		getDriver().quit();
//	}
	
	@Test
	public void testeTextField() {
		
		//buscando formulario por id e setando o texto
		//getDriver().findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		//driverChrome.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		
		
		//Comparando o valor que está escrito dentro do input
		//Assert.assertEquals("Teste de escrita", driverChrome.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		//Assert.assertEquals("Teste de escrita", getDriver().findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		dsl.escreveFirefox("elementosForm:nome", "Teste de escrita");
		
		Assert.assertEquals("Teste de escrita", dsl.obterValorCampoFirefox("elementosForm:nome"));
	}
	
	@Test
	public void deveInteragirComTextArea() {
	
		//Para escrever em várias linhas do Textarea basta usar o \n dentro do sendKeys e da continuidade ao texto.
		//getDriver().findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\nteste");
		//driverChrome.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\nteste");
		
		//Assert.assertEquals("teste\nteste", getDriver().findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		//Assert.assertEquals("teste\nteste", driverChrome.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		dsl.escreveFirefox("elementosForm:sugestoes", "teste\nteste");
		
		Assert.assertEquals("teste\nteste", dsl.obterValorCampoFirefox("elementosForm:sugestoes"));

	}
	
	@Test
	public void deveInteragirComRaidButton() {
		
		//clicando dentro do RaidButton
		//getDriver().findElement(By.id("elementosForm:sexo:0")).click();
		//driverChrome.findElement(By.id("elementosForm:sexo:0")).click();
		
		//Verificar se o RaidButton está clicado ou selecionado
		//Assert.assertTrue(getDriver().findElement(By.id("elementosForm:sexo:0")).isSelected());
		//Assert.assertTrue(driverChrome.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		dsl.clicarRadioFirefox("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcadoFirefox("elementosForm:sexo:0"));
		
	}
	
	@Test
	public void deveInteragirComCehckBox() {
		
		//clicando dentro do CheckBox
		//getDriver().findElement(By.id("elementosForm:comidaFavorita:2")).click();
		//driverChrome.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		
		//Verificar se o CheckBox está clicado ou selecionado
		//Assert.assertTrue(getDriver().findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		//Assert.assertTrue(driverChrome.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		dsl.clicarRadioFirefox("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isRadioMarcadoFirefox("elementosForm:comidaFavorita:2"));
		
	}
	
	@Test
	public void deveInteragirComCombo() {
		
		//Configurando o objeto padrão que o selenium retorna o Web Element
		//WebElement elementFire = getDriver().findElement(By.id("elementosForm:escolaridade"));
		//WebElement elementChrome = driverChrome.findElement(By.id("elementosForm:escolaridade"));
		
		//Transformando o combo em uma instancia de um Select para selecionar
		//Select comboFire = new Select(elementFire);
		//Select comboChrome = new Select(elementChrome);
		
		//Selecionando o indice que quero no combo
		//comboFire.selectByIndex(2);
		//comboChrome.selectByIndex(2);
		
		//Selecionando por value
		//comboFire.selectByValue("superior");
		//comboChrome.selectByValue("superior");
		
		//Selecionando o texto que está visível
		//comboFire.selectByVisibleText("Mestrado");
		//comboChrome.selectByVisibleText("Mestrado");
		
		//Verificando o valor que está selecionado no campo
		//Assert.assertEquals("Mestrado", comboFire.getFirstSelectedOption().getText());
		//Assert.assertEquals("Mestrado", comboChrome.getFirstSelectedOption().getText());
		
		
		dsl.selecionarComboFirefox("elementosForm:escolaridade", "Mestrado");
		Assert.assertEquals("Mestrado", dsl.obterValorComboFirefox("elementosForm:escolaridade"));
		
	}
	
	@Test
	public void deveVerificarValoresDoCombo() {
		
		WebElement elementFire = getDriver().findElement(By.id("elementosForm:escolaridade"));
		
		Select comboFire = new Select(elementFire);
		
		//Criando uma lista das opções presentes no combo
		List<WebElement> optionsFire = comboFire.getOptions();
		
		//Comparando o tamanho da minha coleção
		Assert.assertEquals(8, optionsFire.size());
		
		//Checar se alguma determinada opção está disponível no combo
		
		boolean encontrouFire = false;
		
		for (WebElement optionFire: optionsFire) {
			
			if (optionFire.getText().equals("Mestrado")) {
				encontrouFire = true;
				break;
			}
		}
		//Verificando se a informação é verdadeira se ele encontrou realmente
		Assert.assertTrue(encontrouFire);
		
	}
	
	@Test
	public void deveVerificarValoresDoComboMultiplo() {
		
		WebElement elementFire = getDriver().findElement(By.id("elementosForm:esportes"));
		
		Select comboFire = new Select(elementFire);
		
		//comboFire.selectByVisibleText("Natacao");
		//comboFire.selectByVisibleText("Corrida");
		//comboFire.selectByVisibleText("O que eh esporte?");
		dsl.selecionarComboFirefox("elementosForm:esportes", "Natacao");
		dsl.selecionarComboFirefox("elementosForm:esportes", "Corrida");
		dsl.selecionarComboFirefox("elementosForm:esportes", "O que eh esporte?");
		
		//Retorna uma lista de WebElement
		List<WebElement> allSelectedOptions = comboFire.getAllSelectedOptions();
		
		//Checando se a quantidade de itens selecionas é igual a 3
		Assert.assertEquals(3, allSelectedOptions.size());
		
		//Desselecionando um item do combo multi
		comboFire.deselectByVisibleText("Corrida");
		
		allSelectedOptions = comboFire.getAllSelectedOptions();
		
		Assert.assertEquals(2, allSelectedOptions.size());
		
	}
	
	
	@Test
	public void deveInteragirComBotoes() {
		
		WebElement botaoFire = getDriver().findElement(By.id("buttonSimple"));
		
		//botaoFire.click();
		dsl.clicarBotaoFirefox("buttonSimple");
		
		//Checando o value alterado quando clica no botão
		Assert.assertEquals("Obrigado!", botaoFire.getAttribute("value"));
		
	}
	
	@Test
	//Para ignorar o teste e não ser executado podemos usar essa anotação do Junit
	//@Ignore 
	public void deveInteragirComLinks() {
		
		/*
		 * //Buscando o elemento de acordo com o texto que está visível no link, quando
		 * não tiver ID. //Caso tenha busque pelo ID.
		 * getDriver().findElement(By.linkText("Voltar")).click();
		 * 
		 * 
		 * 
		 * //Para não esquecer testes incompletos podemos usar esse comando para falhar
		 * os testes //Assert.fail();
		 * 
		 * Assert.assertEquals("Voltou!",
		 * getDriver().findElement(By.id("resultado")).getText());
		 * 
		 * //Procedimento para o Chrome
		 * 
		 * //Buscando o elemento de acordo com o texto que está visível no link, quando
		 * não tiver ID. Caso tenha busque pelo ID.
		 * driverChrome.findElement(By.linkText("Voltar")).click();
		 * 
		 * //Assert.fail();
		 * 
		 * Assert.assertEquals("Voltou!",
		 * driverChrome.findElement(By.id("resultado")).getText());
		 */
		
		
		dsl.clicarLinkFirefox("Voltar");
		
		Assert.assertEquals("Voltou!", dsl.obterTextoFirefox("resultado"));
		
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		
		//buscando elementos na pagina pela TAG e printando no console
		//System.out.println(getDriver().findElement(By.tagName("body")).getText());
		
		//Verificando através do contains se o texto que estou passando por parâmetro existe dentro da busca que fiz na TAG
//		Assert.assertTrue(getDriver().findElement(By.tagName("body"))
//				.getText().contains("Campo de Treinamento"));
//		
		//Checando se o elemento Campo de treinamento existe em uma determinada TAG
		Assert.assertEquals("Campo de Treinamento", 
				dsl.obterTextoByFirefox(By.tagName("h3")));
		
		//Checando se o elemento existe na pagina e buscando o mesmo através da Class
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				dsl.obterTextoByFirefox(By.className("facilAchar")));
		
	}
	
	@Test
	public void testTextFieldDuplo() {
		
		dsl.escreveFirefox("elementosForm:nome", "Gerlan");
		Assert.assertEquals("Gerlan", dsl.obterValorCampoFirefox("elementosForm:nome"));
		

		dsl.escreveFirefox("elementosForm:nome", "Ferreira");
		Assert.assertEquals("Ferreira", dsl.obterValorCampoFirefox("elementosForm:nome"));
	}
	
	@Test
	public void testJavaScript() {
		/*Instanciando o objeto para executar os scripts JS, 
		para tal tem que ser usado um cast para poder usa o driver.*/
		//JavascriptExecutor js = (JavascriptExecutor) driverFirefox;
		
		/*Excutando um script do tipo alert no browser*/
		//js.executeScript("alert('Testando js via selenium')");
		
		//Setando um valor via JS buscando pelo Id
		//js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via JS'");
		
		//Altrando o tipo do campo via JS bucando pelo Id
		//js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		
		/*Usando o primeiro argumento que é o element e setando as cores no campo usando os dados do
		 * arguments[1] que é o segundo argumento do script */
		//js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
		
		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		dsl.executarJS("document.getElementById('elementosForm:nome').value = 'Escrito via JS'");
		dsl.executarJS("document.getElementById('elementosForm:sobrenome').type = 'radio'");
		dsl.executarJS("arguments[0].style.border = arguments[1]", element, "solid 4px red");
		
		WebElement element2 = getDriver().findElement(By.xpath("//div[@role='alert']"));
		dsl.executarJS("object.onmouseover", element2);
		
	}
	
	@Test
	public void deveClicarBotaoTabela() {
		
		dsl.ClicarBotaoTabela("Escolaridade", "Doutorado", "Botao", "'elementosForm:tableUsuarios'");
	}
}
