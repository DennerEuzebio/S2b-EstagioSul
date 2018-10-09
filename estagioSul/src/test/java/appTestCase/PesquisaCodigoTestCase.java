package appTestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appTasks.PesquisaCodigoTasks;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import verificationPoints.PesquisaCodigoVerificationPoints;

@RunWith(JUnitParamsRunner.class)
public class PesquisaCodigoTestCase {

	private WebDriver driver;
	private PesquisaCodigoTasks tasks;
	private PesquisaCodigoVerificationPoints verifica;

	//@Test
	public void GivenAreaPesquisaVagasWhenTestTheURLThenTrue() {
		verifica = new PesquisaCodigoVerificationPoints(driver);
		verifica.testURL("https://www.estagiosul.com.br/vagas/estagio", "pagina blablabla");
	}

	@FileParameters("Roteiros de testes - CSV estagio sul.csv")
	@Test
	public void GivenAreaPesquisaVagasWhenSearchDadoThenResultado(String dado, String resultado) {
		verifica = new PesquisaCodigoVerificationPoints(driver);
		tasks = new PesquisaCodigoTasks(driver);
		tasks.digitaCodigo(dado);
		verifica.testCodigoVaga(resultado);
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();
		String InitialPage = "https://www.estagiosul.com.br/vagas/estagio";
		driver.get(InitialPage);
	}

	@After
	public void teardown() {
		if (driver != null)
			driver.quit();
	}

	@BeforeClass
	static public void setupClass() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
	}

}