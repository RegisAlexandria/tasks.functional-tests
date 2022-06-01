package br.ce.ralexandria.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	@Test
	public void deveSalvarTarefaComSucesso() {
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
	public void naodeveSalvarTarefaSemDescricao() {
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
	public void deveSalvarTarefaSemData() {
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
	public void deveSalvarTarefaComDataPassada() {
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
