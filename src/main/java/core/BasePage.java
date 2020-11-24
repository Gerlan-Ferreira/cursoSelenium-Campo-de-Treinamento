package core;


/*Classe criada para servir como Herança para as classes Page que forem usar
 * e herdam tudo aqui criado.*/
public class BasePage {
	
	protected DSL dsl;

	public BasePage() {
		dsl = new DSL();
	}
	
}
