package verificationPoints;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

public class PesquisaCodigoVerificationPoints {
	
	private WebDriver driver;
	
	public PesquisaCodigoVerificationPoints(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public void testURL(String url, String mensagem) {
		String expected = url;
		String actual = driver.getCurrentUrl();
		assertEquals(mensagem + actual, expected, actual);
	}
	
	public void testCodigoVaga(String resultado) {
		String codigoPagina = driver.getPageSource();
		assertThat(codigoPagina, Matchers.containsString(resultado));
	}

}
