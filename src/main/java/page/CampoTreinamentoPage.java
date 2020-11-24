package page;

import org.openqa.selenium.By;

import core.BasePage;

public class CampoTreinamentoPage extends BasePage{

	public void setNome(String nome) {
		
		dsl.escreveFirefox("elementosForm:nome", nome);
		
	}
	
	public void setSobrenome(String sobrenome) {
		
		dsl.escreveFirefox("elementosForm:sobrenome", sobrenome);
		
	}
	
	public void setSexoMasculino() {
		
		dsl.clicarRadioFirefox("elementosForm:sexo:0");
		
	}
	
	public void setSexoFeminino() {
		
		dsl.clicarRadioFirefox("elementosForm:sexo:1");
		
	}
	public void setComidaCarne() {
		
		dsl.clicarRadioFirefox("elementosForm:comidaFavorita:0");
		
	}
	public void setComidaFrango() {
		
		dsl.clicarRadioFirefox("elementosForm:comidaFavorita:1");
		
	}
	
	public void setComidaPizza() {
		
		dsl.clicarRadioFirefox("elementosForm:comidaFavorita:2");
		
	}
	
	public void setComidaVegetariano() {
		
		dsl.clicarRadioFirefox("elementosForm:comidaFavorita:3");
		
	}
	
	public void setEscolaridade(String valor){
		
		dsl.selecionarComboFirefox("elementosForm:escolaridade", valor);
	}
	
	public void setEsporte(String... valores) {
		//esse laço faz com que a quantidade de parametros que eu passar ele selecione de uma só vez
		for (String valor: valores) 
			dsl.selecionarComboFirefox("elementosForm:esportes", valor);
	}
	
	public void Cadastrar() {
		
		dsl.clicarBotaoFirefox("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		
		return dsl.obterTextoByFirefox(By.xpath("//*[@id='resultado']/span"));
		
	}
	
	public String obterNomeCadastro() {
		
		return dsl.obterTextoByFirefox(By.xpath("//*[@id='descNome']/span"));
		
	}
	
	public String obterSobrenomeCadastro() {
		
		return dsl.obterTextoByFirefox(By.xpath("//*[@id='descSobrenome']/span"));
	}
	
	public String obterSexoCadastro() {
		
		return dsl.obterTextoByFirefox(By.xpath("//*[@id='descSexo']/span"));
	}
	
	public String obterComidaCadastro() {
		
		return dsl.obterTextoByFirefox(By.xpath("//*[@id='descComida']/span"));
	}
	
	public String obterEscolaridadeCadastro() {
		
		return dsl.obterTextoByFirefox(By.xpath("//*[@id='descEscolaridade']/span"));
	}
	
	public String obterEsporteCadastro() {
		
		return dsl.obterTextoByFirefox(By.xpath("//*[@id='descEsportes']/span"));
	}
	
	public String obterSugestoesCadastro() {
		
		return dsl.obterTextoByFirefox(By.xpath("//*[@id='descSugestoes']/span"));
	}
	
	}
