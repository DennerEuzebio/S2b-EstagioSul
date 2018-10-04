package pucrs.s2b.estagioSul;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AppTestPage {

	@FindBy( id="pesquisacodigo")
	@CacheLookup
	WebElement pesquisacod;
	
	public void pesquisa(String word) {
		pesquisacod.sendKeys(word);
	}
		
}
