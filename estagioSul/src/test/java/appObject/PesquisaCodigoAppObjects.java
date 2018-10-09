package appObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PesquisaCodigoAppObjects {

	private WebDriver driver;

	public PesquisaCodigoAppObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getCampoPesquisa() {
		return driver.findElement(By.id("pesquisacodigo"));
	}
		
}
