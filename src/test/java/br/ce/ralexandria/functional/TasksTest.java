package br.ce.ralexandria.functional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TasksTest {
	
	
	public WebDriver acessarAplicacao() throws MalformedURLException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\regis\\dev\\java\\seleniumDrivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), cap);
		driver.navigate().to("http://192.168.0.105:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	@Test
	public void deveSalvarTarefaComSucesso() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
			
			//clicar em add todo
			WebElement btnAdd = driver.findElement(By.id("addTodo"));
			btnAdd.click();
			
			//escrever a descricao
			driver.findElement(By.id("task")).sendKeys("Teste via selenium");		
			
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2022");
			
			//clicar em salvar
			WebElement btnSave = driver.findElement(By.id("saveButton"));
			btnSave.click();
			
			//validar mensagem de sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", mensagem);
		
			
		}finally {
			//fechar o browser
			driver.quit();
		}
				
	}
	
	@Test
	public void naodeveSalvarTarefaSemDescricao() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
			
			//clicar em add todo
			WebElement btnAdd = driver.findElement(By.id("addTodo"));
			btnAdd.click();						
			
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2022");
			
			//clicar em salvar
			WebElement btnSave = driver.findElement(By.id("saveButton"));
			btnSave.click();
			
			//validar mensagem de sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", mensagem);
		
			
		}finally {
			//fechar o browser
			driver.quit();
		}
				
	}
	
	@Test
	public void deveSalvarTarefaSemData() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
			
			//clicar em add todo
			WebElement btnAdd = driver.findElement(By.id("addTodo"));
			btnAdd.click();
			
			//escrever a descricao
			driver.findElement(By.id("task")).sendKeys("Teste via selenium");		
			
			//clicar em salvar
			WebElement btnSave = driver.findElement(By.id("saveButton"));
			btnSave.click();
			
			//validar mensagem de sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", mensagem);
		
			
		}finally {
			//fechar o browser
			driver.quit();
		}
				
	}
	
	@Test
	public void deveSalvarTarefaComDataPassada() throws MalformedURLException {
		WebDriver driver = acessarAplicacao();
		
		try {
			
			//clicar em add todo
			WebElement btnAdd = driver.findElement(By.id("addTodo"));
			btnAdd.click();
			
			//escrever a descricao
			driver.findElement(By.id("task")).sendKeys("Teste via selenium");		
			
			//escrever a data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/1990");
			
			//clicar em salvar
			WebElement btnSave = driver.findElement(By.id("saveButton"));
			btnSave.click();
			
			//validar mensagem de sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", mensagem);
		
			
		}finally {
			//fechar o browser
			driver.quit();
		}
				
	}
	

}
