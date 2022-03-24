package com.mindtree.Assessment.FinalAssessment;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	static String randomPhoneNumberGenerator() {
		String ans = "";
		int maxLast = 9;
		int minLast = 0;
		int maxFirst = 9;
		int minFirst = 6;
		Random rand = new Random();
		for (int i = 0; i < 9; i++) {
			Integer randomNum = rand.nextInt((maxLast - minLast) + 1) + minLast;
			ans = ans + randomNum.toString();
		}
		Integer firstRandom = rand.nextInt((maxFirst - minFirst) + 1) + minFirst;
		return firstRandom + ans;
	}

	static String randomEmailGenerator() {
		String ans = "";
		String smallChar = "abcdefghijklmnopqrstuvwxyz";
		String bigChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String nums = "1234567890";
		String finalString = smallChar + bigChar + nums;
		int finalStringLen = finalString.length();
		Random rand = new Random();
		int maxLen = 15;
		int minLen = 5;
		int randomLen = rand.nextInt((maxLen - minLen) + 1) + minLen;
		for (int i = 0; i < randomLen; i++) {
			int randomAccess = rand.nextInt(((finalStringLen - 1) - 0) + 1) + 0;
			ans = ans + finalString.charAt(randomAccess);
		}

		return ans + "@gmail.com";
	}
	
	static WebDriver getDriver() {
		final String CHROME_DRIVER = "webdriver.chrome.driver";
        final String CHROME_DRIVER_PATH = "C:\\Program Files\\chromedriver_win32\\chromedriver.exe";
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        final String URL = "https://www.nobroker.in/";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
	}

}
