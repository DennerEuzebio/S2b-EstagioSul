package appTasks;

import org.openqa.selenium.WebDriver;

import appObject.PesquisaCodigoAppObjects;

public class PesquisaCodigoTasks {
	
	private WebDriver driver;
	private PesquisaCodigoAppObjects pesquisaCodigo;

	public PesquisaCodigoTasks(WebDriver driver) {
		this.driver=driver;
		this.pesquisaCodigo = new PesquisaCodigoAppObjects(driver);
	}
	
	public void digitaCodigo(String dado) {
		this.pesquisaCodigo.getCampoPesquisa().sendKeys(dado);
	}

}
