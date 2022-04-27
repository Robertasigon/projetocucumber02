package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class AcessarContaTest {

	WebDriver driver; 
	
	@Dado("^Acessar a p�gina de autentica��o de usu�rio$")
	public void acessar_a_p�gina_de_autentica��o_de_usu�rio() {
	    
		//acessando o driver do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		
		//abrindo o navegador na p�gina de autentica��o de usu�rio
		driver = new ChromeDriver();
		driver.get("http://exercqa-001-site1.btempurl.com/Jmeter/Exercicio05");
		
		//maximizar o navegador
		driver.manage().window().maximize();
		
	}

	@Dado("^Informar o email do usu�rio \"([^\"]*)\"$")
	public void informar_o_email_do_usu�rio(String arg1) {
	    
		//preencher o campo de email do usu�rio
		driver.findElement(By.cssSelector("#Email")).sendKeys(arg1);
	}

	@Dado("^Informar a senha do usu�rio \"([^\"]*)\"$")
	public void informar_a_senha_do_usu�rio(String arg1) {
	   
		//preencher o campo de senha do usu�rio
		driver.findElement(By.cssSelector("#Senha")).sendKeys(arg1);
	}

	@Quando("^Solicitar a realiza��o do acesso$")
	public void solicitar_a_realiza��o_do_acesso() {
	    
		//clicar no bot�o de confirma��o
		driver.findElement(By.cssSelector("#btn_acesso")).click();
	}

	@Ent�o("^Sistema autentica o usu�rio com sucesso$")
	public void sistema_autentica_o_usu�rio_com_sucesso() {
		
	    //ler a mensagem obtida do sistema
		String mensagem = driver.findElement(By.cssSelector("#page-content-wrapper > div > div > div > div > p")).getText();
		
		//comparando resultado esperado x resultado obtido
		assertEquals(mensagem,"Usu�rio autenticado com sucesso.");
		
		//fechando o navegador
		driver.close();
		driver.quit();
	}

	@Ent�o("^Sistema imforma que o acesso � negado$")
	public void sistema_imforma_que_o_acesso_�_negado() {
	    
		//ler a mensagem obtida do sistema
		String mensagem = driver.findElement(By.cssSelector("#mensagem")).getText();
		
		//comparando resultaso esperado x resultado obtido
		assertEquals(mensagem, "Acesso Negado" );
		
		//fechando navegador
		driver.close();
		driver.quit();
	}


	
}
