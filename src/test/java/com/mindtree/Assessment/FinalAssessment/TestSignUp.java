package com.mindtree.Assessment.FinalAssessment;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestSignUp {

	@Test
	public void singupVerification()  {
		WebDriver driver =  Utility.getDriver();
        
        // Variables
        String signupStr = "Sign Up";
        String mobNum = Utility.randomPhoneNumberGenerator();
        String signupName = "John Doe";
        String signupEmail = Utility.randomEmailGenerator();


        By bySignup = By.xpath("//div[@class='nb__19hcF']");
        List<WebElement> signUpList = driver.findElements(bySignup);
        for (WebElement w : signUpList) {
            if (w.getText().equalsIgnoreCase(signupStr)) {
                w.click();
            }
        }
        
        By bySignupMob = By.xpath("//input[@id='signUp-phoneNumber']");
        WebElement signupMobElement = driver.findElement(bySignupMob);
        
        By bySignupName = By.xpath("//input[@id='login-signup-form__name-input']");
        WebElement signupNameElement = driver.findElement(bySignupName);

        By bySignupEmail = By.xpath("//input[@id='login-signup-form__email-input']");
        WebElement signupEmailElement = driver.findElement(bySignupEmail);
    
        By byContBtn = By.xpath("//button[@id='signUpSubmit']");
        WebElement contBtn = driver.findElement(byContBtn);
        
        signupMobElement.sendKeys(mobNum);
        signupNameElement.sendKeys(signupName);
        signupEmailElement.sendKeys(signupEmail);
        
        contBtn.click();
        
        WebElement usernameCheck = driver.findElement(By.xpath("//span[@class='nb__3-MNF']"));
        String signupUsername = usernameCheck.getText();
        Assert.assertEquals(signupName, signupUsername);
	}
	
	

}
