package appTasks;

import org.openqa.selenium.WebDriver;

import appObject.PesquisaCodigoAppObjects;

public class PesquisaCodigoTasks {
	
	private PesquisaCodigoAppObjects pesquisaCodigo;

	public PesquisaCodigoTasks(WebDriver driver) {
		this.pesquisaCodigo = new PesquisaCodigoAppObjects(driver);
	}
	
	public void digitaCodigo(String dado) {
		this.pesquisaCodigo.getCampoPesquisa().sendKeys(dado);
	}

}
