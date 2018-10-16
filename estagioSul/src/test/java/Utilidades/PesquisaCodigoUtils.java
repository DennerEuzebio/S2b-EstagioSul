package Utilidades;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PesquisaCodigoUtils {

	private WebDriver driver;
	private ExtentTest test;
	TakesScreenshot screen;

	public PesquisaCodigoUtils(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void geraRelatorioPesquisaCodigo(String dado, String resultado) throws Exception {
		if (driver.getPageSource().contains(resultado)) {
			test.log(LogStatus.PASS, "Resultado esperado, a pagina contem o texto \"" + resultado + "\" ao digitar \""+ dado + "\" na area pesquisa");
		} else {
			test.log(LogStatus.FAIL, "Resultado nao esperado, a pagina nao  contem o texto \"" + resultado+ "\" ao digitar \"" + dado + "\" na area pesquisa");
			driver.manage().window().maximize();
			
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("C:/Users/Denner/S2b-EstagioSul/estagioSul/ScreenShots/Dado_"+dado+"_ResultadoEsperado_"+resultado+".jpg"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void geraRelatorioTesteURK(String url) {
		if (driver.getCurrentUrl().equals(url)) {
			test.log(LogStatus.PASS, "Pagina correta");
		} else
			test.log(LogStatus.FAIL, "Pagira incorreta, pagina atual: " + driver.getCurrentUrl());
	}

}
