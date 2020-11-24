package core;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static core.DriverFactory.getDriver;


/*Criando uma classe DSL para ser melhor ainda o reuso de código podendo criar métodos para serem reutilizados
em todas as classes do projeto.*/

public class DSL {
	
	//Método para escrever texto nos campos de texto
	public void escreveFirefox(String id_campo, String texto) {
		
		getDriver().findElement(By.id(id_campo)).clear(); //o clear limpa o campo antes de escrever
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
		
	}
	//Método para se obter valor de um campo
	
	//obtem o valor do Label pelo atributo "for"
	public String obterValorLabelByXpath(String id) {
		
		return  obterTextoByFirefox(By.xpath("//label[@for="+id+"]"));
	}
	
	//obtem o valor do Label pelo atributo "id"
	public String obterValorLabelByXpathId(String id) {
		
		return  obterTextoByFirefox(By.xpath("//label[@id='"+id+"']"));
	}
	
	
	public String obterValorCampoFirefox(String id_campo) {
		
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
		
	}
	
	//Método para clicar no RaidButton
	public void clicarRadioByFirefox(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarRadioFirefox(String id) {
		
		clicarRadioByFirefox(By.id(id));
	}
	
	//Método para checar se o Raid está selecionado
	public boolean isRadioMarcadoFirefox(String id) {
		
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	//Selecionando valor no combo pelo texto visivel
	public void selecionarComboFirefox(String id, String valor) {
		
		WebElement elementFire = getDriver().findElement(By.id(id));
		
		Select comboFire = new Select(elementFire);
		
		comboFire.selectByVisibleText(valor);
		
	}
	
	public void selecionarComboFirefoxXpath(By by, String valor) {
		
		WebElement elementFire = getDriver().findElement(by);
		
		Select comboFire = new Select(elementFire);
		
		List<WebElement> optionsFire = comboFire.getOptions();
		
		for (WebElement optionFire: optionsFire) {
			
			if (optionFire.getText().equals(valor)) {
				
				comboFire.selectByVisibleText(valor);
				
				break;
			}
		}
	}
	
	public void selecionarComboFirefoxValue(String id, String valor) {
		
		WebElement elementFire = getDriver().findElement(By.id(id));
		
		Select comboFire = new Select(elementFire);
		
		comboFire.selectByValue(valor);
		

		
	}

	//Método para obter valor do combo
	public String obterValorComboFirefox(String id) {
	
		WebElement elementFire = getDriver().findElement(By.id(id));
		
		Select comboFire = new Select(elementFire);
		
		return comboFire.getFirstSelectedOption().getText();
		
	}
	
	//Método para clicar no botão
	public void clicarBotaoFirefox(String id) {
		
		getDriver().findElement(By.id(id)).click();
		
	}
	
	//Método para clicar no Link
	public void clicarLinkFirefox(String link) {
		
		getDriver().findElement(By.linkText(link)).click();
		
	}

	//Método para obter texto através de tag usando o By
	public String obterTextoByFirefox(By by) {
		
		return getDriver().findElement(by).getText();
	}
	
	//Método para obter texto
	public String obterTextoFirefox(String id) {
		
		//Reutilizando o método anterior com o By
		return obterTextoByFirefox(By.id(id));
	}
	
	
	public boolean VerificarTextoNoInicioFirefox(String id) {
		
		return getDriver().findElement(By.id(id)).getText()
				.startsWith(getDriver().findElement(By.id(id)).getText());
	}
	
	public boolean VerificarTextoNoFinalFirefox(String id, String result) {
		
		return getDriver().findElement(By.id(id)).getText()
				.endsWith(getDriver().findElement(By.id(result)).getText());
	}
	
	/****************** Alert ******************/
	
	public String ObterTextoAlertFirefox() {
		
		Alert alerta = getDriver().switchTo().alert(); // mudando o foco para o alert
		return alerta.getText(); // verificando o texto do alert

	}
	public void aceitaAlertFirefox() {
		getDriver().switchTo().alert().accept();
		
	}
	
	public void negaAlertFirefox() {
		getDriver().switchTo().alert().dismiss();
		
	}
	
	/******************* Framas/Janelas ***********************/
	
	public void entrarFrame(String id) {
		
		getDriver().switchTo().frame(id);
		
		
	}
	/******************* JavaScript ***********************/
	
	public Object executarJS(String comando, Object... parametros) {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(comando, parametros);
		
		/*Criado um método que retorna um Objeto e passado os parametros que será o comando que irá
		 * executar e os parametros desse comando*/
	}
	
	/******************* Tabela ***********************/
	
	public void ClicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		
		//procurar coluna do registro na tabela
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id="+idTabela+"]")); /*Criando o webelement da tabela através do seu Xpath*/

		
		int idColuna = obterIndiceColuna(colunaBusca, tabela);//Como o método retorna um inteiro. Capturamos ele e gravamos no idColuna
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		
		//procurar coluna do botão
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela); /*Reutilizando o mesmo método de busca da coluna para o Botão.
		 															Mudando apenas o parâmetro para pegar o colunaBotão.*/
		
		//clicar no botao da célula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		/*buscando o elemento para o botão, informando sua linha e coluna, encontrados nos métodos anteriores.*/
		
		celula.findElement(By.xpath(".//input")).click(); /*Acessando o botão que quero clicar através do
		Xpath com o .//input e por fim clicando no mesmo.*/
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));		
		/*Transformando tudo em uma lista de elementos e acessando a linha da
		 coluna que deseja de acordo com o ID que peguei e salvei na variável idColuna.*/
		
		int idLinha = -1;
		
		for (int i = 0; i < linhas.size(); i++) {
			
			if (linhas.get(i).getText().equals(valor)) { 
				/*Comparando se o valor capturado é igual ao que foi passado por parametro (valor) 
				E se encontrado armazenamos esse valor na variável idLinha*/
				
				idLinha = i+1;
				break;
				
			}
			
		}
		return idLinha;
		
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		
		List<WebElement> colunas =  tabela.findElements(By.xpath(".//th"));
		/*Criando uma lista para pegar todos os elementos através do findElements com Xpath*/
		
		int idColuna = -1; /*Criado essa variável para armazenar o valor achado no FOR abaixo. 
		Ele começa em -1 pq se começar >= 0 quer dizer que foi achado.*/
		
		for (int i = 0; i < colunas.size(); i++) { /*laço de repetição que varre toda a lista de colunas da tabela*/
			
			if (colunas.get(i).getText().equals(coluna)) { 
				/*Comparando se o valor capturado é igual ao que foi passado por parametro. 
				E se encontrado armazenamos esse valor na variável idColuna*/
				
				idColuna = i+1; //setando o i+1 para que o valor seja mais 1 por conta que o indice no Xpath começa em 1.
				break;
				
			}
			
		}
		return idColuna;
	}
}
