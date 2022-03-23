package com.mindtree.Assessment.FinalAssessment;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

	@Test
	public void loginVerification() {
		WebDriver driver =  Utility.getDriver();

        // Variables
        String loginStr = "Log In";
        String mobNum = "7894561230";
        String otpStr = "Enter OTP here";
      

        By byLogin = By.xpath("//div[@class='nb__19hcF']");
        List<WebElement> loginList = driver.findElements(byLogin);
        for (WebElement w : loginList) {
            if (w.getText().equalsIgnoreCase(loginStr)) {
                w.click();
            }
        }
        
        By byLoginMob = By.xpath("//input[@id='signUp-phoneNumber']");
        WebElement loginMobElement = driver.findElement(byLoginMob);
      
        loginMobElement.sendKeys(mobNum);

        By byOtpField = By.xpath("//div[@class='nb-otp__input-label']");
        WebElement otpFieldElement = driver.findElement(byOtpField);
        Assert.assertEquals(otpFieldElement.getText(), otpStr);
        
	}

}
