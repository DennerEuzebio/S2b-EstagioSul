package appTestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utilidades.PesquisaCodigoUtils;
import appTasks.PesquisaCodigoTasks;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import verificationPoints.PesquisaCodigoVerificationPoints;

@RunWith(JUnitParamsRunner.class)
public class PesquisaCodigoTestCase {

	private WebDriver driver;
	private PesquisaCodigoUtils utils;
	private PesquisaCodigoTasks tasks;
	private PesquisaCodigoVerificationPoints verifica;
	
	static ExtentTest test;
	static ExtentReports report;

	//@Test
	public void GivenAreaPesquisaVagasWhenTestTheURLThenTrue() {
		verifica = new PesquisaCodigoVerificationPoints(driver);
		utils = new PesquisaCodigoUtils(driver,test);
		String url = "https://www.estagiosul.com.br/vagas/estagio";
		
		utils.geraRelatorioTesteURK(url);

		verifica.testURL(url, "pagina errada");

	}

	@FileParameters("Roteiros de testes - CSV estagio sul.csv")
	@Test
	public void GivenAreaPesquisaVagasWhenSearchDadoThenResultado(String dado, String resultado) throws Exception {
		verifica = new PesquisaCodigoVerificationPoints(driver);
		tasks = new PesquisaCodigoTasks(driver);
		utils = new PesquisaCodigoUtils(driver,test);
		
		tasks.digitaCodigo(dado);

		utils.geraRelatorioPesquisaCodigo(dado, resultado);

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
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = report.startTest("TestePesquisaCodigo");
	}
	
	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

}