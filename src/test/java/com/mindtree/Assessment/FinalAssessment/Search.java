package com.mindtree.Assessment.FinalAssessment;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {
	@Test
	public  void searchBarResults() {
		String location = "Bangalore";
		String locality = "Whitefield";
		WebDriver driver = Utility.getDriver();

		WebElement locationSelect = driver.findElement(By.xpath(
				"//div[@class='prop-search-city-selector nb-select form-group nb-select__lg'] //div[@id='searchCity']"));
		locationSelect.click();

		List<WebElement> locationDropdown = driver
				.findElements(By.xpath("//div[@class='css-mdf5j6-option nb-select__option']"));
		for (int i = 0; i < locationDropdown.size(); i++) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.elementToBeClickable(locationDropdown.get(i)));
			WebElement w = locationDropdown.get(i);
			if (w.getText().equalsIgnoreCase(location)) {
				locationDropdown.get(i).click();
				break;
			}
		}

		WebElement searchBar = driver.findElement(By.xpath("//input[@id='listPageSearchLocality']"));
		searchBar.sendKeys(locality);
		
		
		List <WebElement> searchSuggestion = driver.findElements(By.xpath("//div[@class='suggestion-item']"));
		Random rand = new Random();
		int maxLen = searchSuggestion.size() - 1;
		int minLen = 0;
		int randomLen = rand.nextInt((maxLen - minLen) + 1) + minLen;
		searchSuggestion.get(randomLen).click();
		
		WebElement selectedLocality = driver.findElement(By.xpath("//span[@class='selected-locality-item']"));
		String selectedLocalityStr = selectedLocality.getText().trim().toLowerCase();
		
		WebElement searchBtn = driver.findElement(By.xpath("//button[@class='prop-search-button btn btn-primary btn-lg']"));
		searchBtn.click();
		
		List<WebElement> breadcrumb = driver.findElements(By.xpath("//ul[@class='nb__1pg5l'] //li //span //span"));
		int lastElement = breadcrumb.size() - 1;
		String breadcrumbStr = breadcrumb.get(lastElement).getText().trim().toLowerCase();
			
		Assert.assertEquals(selectedLocalityStr, breadcrumbStr);

	}
}
