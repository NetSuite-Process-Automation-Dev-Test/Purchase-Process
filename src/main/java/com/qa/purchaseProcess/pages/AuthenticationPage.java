package com.qa.purchaseProcess.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.purchaseProcess.util.TestBase;

public class AuthenticationPage extends TestBase{
	
	@FindBy(xpath = "//td[@class='smalltextnolink']//following-sibling::td")
	WebElement secQuestion;
	
	@FindBy(name = "submitter")
	WebElement authSubmitBtn;
	
	@FindBy(xpath = "//table[@class='listTable']//tr")
	List<WebElement> rolesList;
	
	@FindBy(xpath = "//table[@cellpadding='3']//tr[not(@class)]")
	List<WebElement> rolesList2;
	
	public AuthenticationPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage Authentication() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		// Handling the Security Question Page
		if(!driver.getTitle().contains("The system was not able to select a login role for you based on your usual NetSuite usage. Choose an item from the list below.")) {
			String actQuestion = secQuestion.getText();
			
			// For my login
			if (actQuestion.trim().equals(prop.getProperty("question1"))) {
				driver.findElement(By.id("null")).sendKeys("nickname");
			} 
			else if (actQuestion.trim().equals(prop.getProperty("question2"))) {
				driver.findElement(By.id("null")).sendKeys("name");
			} 
			else if (actQuestion.trim().equals(prop.getProperty("question3"))) {
				driver.findElement(By.id("null")).sendKeys("job");
			} 
			else if (actQuestion.trim().equals(prop.getProperty("question4"))) {
				driver.findElement(By.id("null")).sendKeys("child");
			} 
			else if (actQuestion.trim().equals(prop.getProperty("question5"))) {
				driver.findElement(By.id("null")).sendKeys("grade");
			}


			authSubmitBtn.click();
		}else {
			try {
				eleAvailability(driver, rolesList.get(1), 5);
				for(int i=0;i<rolesList.size();i++) {
					WebElement currentRole = rolesList.get(i);
					String roleText = currentRole.getText();
					if(roleText.contains("Tvarana Dev Test") && roleText.contains("PRODUCTION") && roleText.contains("Administrator")) {
						WebElement lastChildTd = (WebElement)executor.executeScript("return arguments[0].lastElementChild;", currentRole);
						WebElement chooseRoleLink = (WebElement)executor.executeScript("return arguments[0].lastElementChild;", lastChildTd);
						chooseRoleLink.click();
						break;
					}
				}
			} catch (Exception e) {
				eleAvailability(driver, rolesList2.get(1), 5);
				for(int i=0;i<rolesList2.size();i++) {
					WebElement currentRole = rolesList2.get(i);
					String roleText = currentRole.getText();
					if(roleText.contains("Tvarana Dev Test") && roleText.contains("PRODUCTION") && roleText.contains("Administrator")) {
						WebElement lastChildTd = (WebElement)executor.executeScript("return arguments[0].lastElementChild;", currentRole);
						WebElement chooseRoleLink = (WebElement)executor.executeScript("return arguments[0].lastElementChild;", lastChildTd);
						chooseRoleLink.click();
						break;
					}
				}
			}
			String actQuestion = secQuestion.getText();
			// For my login
			if (actQuestion.trim().equals(prop.getProperty("question1"))) {
				driver.findElement(By.id("null")).sendKeys("nickname");
			} 
			else if (actQuestion.trim().equals(prop.getProperty("question2"))) {
				driver.findElement(By.id("null")).sendKeys("name");
			} 
			else if (actQuestion.trim().equals(prop.getProperty("question3"))) {
				driver.findElement(By.id("null")).sendKeys("job");
			} 
			else if (actQuestion.trim().equals(prop.getProperty("question4"))) {
				driver.findElement(By.id("null")).sendKeys("child");
			} 
			else if (actQuestion.trim().equals(prop.getProperty("question5"))) {
				driver.findElement(By.id("null")).sendKeys("grade");
			}

			authSubmitBtn.click();
		}
		
		return new HomePage();
	}

}
