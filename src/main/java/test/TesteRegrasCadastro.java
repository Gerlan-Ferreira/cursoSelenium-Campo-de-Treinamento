package test;

import static core.DriverFactory.getDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import core.BaseTest;
import core.DSL;
import page.CampoTreinamentoPage;

/*Para executar esse tipo de teste parametrizável temos que altera a forma de Rodar o teste
usando o @RunWith(Parametrized.class) para que o JUnit saiba que esse é um tipo de teste
parametrizável que irá ser executado.
 */
@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest{
	
	private DSL dsl;
	private CampoTreinamentoPage pageCadastro;
	
	/* O @Parameter indica que essa variável será passada como parâmetro,
	 * e serão usadas na Collection. O value indica qual será a sequencia de cada
	 * uma dentro da coleção e devem seguir a sequencia correta.
	*/
	@Parameter //essa nao tem o value preenchido pois começa com 0 e não precisa
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List <String> comidas; //Lista para as comidas
	@Parameter(value=4)
	public String[] esportes; //array para os esportes
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicializar() {
		
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		pageCadastro = new CampoTreinamentoPage();
	}
	
	/*Criando uma Collection de Objetos para serem inseridos no caso de teste automaticamente.
	 * Ele irá retornar uma coleção de array de objetos.
	 * O @Parameters é usado pelo JUnit para indicar uma coleção de parametros a serem inseridos
	 */
	@Parameters
	public static Collection<Object[]> getCollection(){
		
		//Criado uma matriz de objetos dentro de uma lista.
		return Arrays.asList(new Object[][] {
			
			/*Cada linha criada será um conjunto de dados que irá passar pela estrutura de testes.*/
			/* Cada dado separado por vírgula se refere ao mapeamento com as variáveis. */
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			
			{"Gerlan", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			
			{"Gerlan", "Ferreira", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			
			{"Gerlan", "Ferreira", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, 
				"Tem certeza que voce eh vegetariano?"},
			
			{"Gerlan", "Ferreira", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, 
					"Voce faz esporte ou nao?"}
			
		});
	}
	
	@Test
	public void deveValidarRegras(){
		
	
		pageCadastro.setNome(nome);
		
		pageCadastro.setSobrenome(sobrenome);
		
		//Sexo
		if (sexo.equals("Masculino")) {
			pageCadastro.setSexoMasculino();
		}
		
		if (sexo.equals("Feminino")){
			pageCadastro.setSexoFeminino();
		}
		
		//Comida favorita
		if (comidas.contains("Carne")) {
			
			pageCadastro.setComidaCarne();
			
		}
		
		if(comidas.contains("Pizza")) {
			
			pageCadastro.setComidaPizza();
			
		}
		
		if (comidas.contains("Vegetariano")) {
			
			pageCadastro.setComidaVegetariano();
			
		}
		
		if(comidas.contains("Frango")) {
			
			pageCadastro.setComidaFrango();
		}
		
		pageCadastro.setEsporte(esportes);//passando o array de esportes como parametro
		
		pageCadastro.Cadastrar();
		
		System.out.println(msg);
	
		Assert.assertEquals(msg, dsl.ObterTextoAlertFirefox());
		
		dsl.aceitaAlertFirefox();
	}
	

}
