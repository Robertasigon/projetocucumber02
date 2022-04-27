package tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AcessarContaTest {

	WebDriver driver; 
	
	@Dado("^Acessar a página de autenticação de usuário$")
	public void acessar_a_página_de_autenticação_de_usuário() {
	    
		//acessando o driver do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		
		//abrindo o navegador na página de autenticação de usuário
		driver = new ChromeDriver();
		driver.get("http://exercqa-001-site1.btempurl.com/Jmeter/Exercicio05");
		
		//maximizar o navegador
		driver.manage().window().maximize();
		
	}

	@Dado("^Informar o email do usuário \"([^\"]*)\"$")
	public void informar_o_email_do_usuário(String arg1) {
	    
		//preencher o campo de email do usuário
		driver.findElement(By.cssSelector("#Email")).sendKeys(arg1);
	}

	@Dado("^Informar a senha do usuário \"([^\"]*)\"$")
	public void informar_a_senha_do_usuário(String arg1) {
	   
		//preencher o campo de senha do usuário
		driver.findElement(By.cssSelector("#Senha")).sendKeys(arg1);
	}

	@Quando("^Solicitar a realização do acesso$")
	public void solicitar_a_realização_do_acesso() {
	    
		//clicar no botão de confirmação
		driver.findElement(By.cssSelector("#btn_acesso")).click();
	}

	@Então("^Sistema autentica o usuário com sucesso$")
	public void sistema_autentica_o_usuário_com_sucesso() {
		
	    //ler a mensagem obtida do sistema
		String mensagem = driver.findElement(By.cssSelector("#page-content-wrapper > div > div > div > div > p")).getText();
		
		//comparando resultado esperado x resultado obtido
		assertEquals(mensagem,"Usuário autenticado com sucesso.");
		
		//fechando o navegador
		driver.close();
		driver.quit();
	}

	@Então("^Sistema imforma que o acesso é negado$")
	public void sistema_imforma_que_o_acesso_é_negado() {
	    
		//ler a mensagem obtida do sistema
		String mensagem = driver.findElement(By.cssSelector("#mensagem")).getText();
		
		//comparando resultaso esperado x resultado obtido
		assertEquals(mensagem, "Acesso Negado" );
		
		//fechando navegador
		driver.close();
		driver.quit();
	}


	
}
