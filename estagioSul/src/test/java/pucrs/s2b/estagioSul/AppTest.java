package pucrs.s2b.estagioSul;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class AppTest {

	private WebDriver driver;
	AppTestPage page;

	@Test
	public void GivenAreaPesquisaVagasWhenTestTheURLThenTrue() {
		assertEquals("https://www.estagiosul.com.br/vagas/estagio", driver.getCurrentUrl());
	}

	@FileParameters("Roteiros de testes - CSV estagio sul.csv")
	@Test
	public void GivenAreaPesquisaVagasWhenSearchDadoThenResultado(String dado, String resultado) {
		page.pesquisa(dado);
		String codigoPagina = driver.getPageSource();
		assertThat(codigoPagina, Matchers.containsString(resultado));
	}

	/*
	 * @Test public void GivenAreaPesquisaVagasWhenSearchRThenWork() { String word =
	 * "3"; page.pesquisa(word); String codigoPagina = driver.getPageSource();
	 * assertThat(codigoPagina, Matchers.containsString("vaga(s) encontrada(s)")); }
	 */

	public void testURL(String url, String mensagem) {
		String expected = url;
		String actual = driver.getCurrentUrl();
		assertEquals(mensagem + actual, expected, actual);
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();
		String InitialPage = "https://www.estagiosul.com.br/vagas/estagio";
		driver.get(InitialPage);
		page = PageFactory.initElements(driver, AppTestPage.class);
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