package suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import test.TesteCadastroComSucesso;
import test.TesteRegrasCadastro;

@RunWith(Suite.class) /*Para rodar uma suite de testes precisamos usar esse tipo de Runner.*/
@SuiteClasses({ //Usado para informar que classes eu quero que sejam executadas
	TesteCadastroComSucesso.class,
	TesteRegrasCadastro.class
}) 

public class SuiteTeste {
	
	/*O AfterClass é um recurso do JUnit assim como o After. A diferença é que ele só executa
	 ao final de tudo que acontecer na classe.
	 Portanto, nesse caso após rodar os testes ele usa o método KillDriver() da classe DriverFactory.*/
	@AfterClass
	public static void FinalizaTudo() {
		DriverFactory.killDriver();
	}

}
