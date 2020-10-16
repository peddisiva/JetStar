package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jetstar.qa.base.TestBase;

public class SelectFlight extends TestBase {
	
	@FindBy(xpath="//div[@id='02ED05A2-6B2A-43C0-9E88-B7AE62295328']//div[1]")
	WebElement tripDropDown;
	
	@FindBy(xpath="//button[contains(text(),'One way')]")
	WebElement tripType;
	
//	@FindBy(xpath="//div[contains(@class,'mps__row sector')]/div[1]")
//	WebElement fromField;
	
//	@FindBy(xpath="//div[contains(@class,'mps__row sector')]/div[2]")
//	WebElement toField;
	
//	@FindBy(xpath="//div[@class='bwj_bwk']/div[2]/ul/li/button/span[@class='buh_bui']/span[contains(text(),'Sydney')]")
//	WebElement fromCity;
	
//	@FindBy(xpath="//div[@class='bwj_bwk']/div[2]/ul/li/button/span[@class='buh_bui']/span[contains(text(),'Brisbane')]")
//	WebElement toCity;
	
	@FindBy(xpath="//b[contains(text(),'From')]")
	WebElement from;
	
	@FindBy(xpath="//span[contains(@class,'to_tp tq_tr ts_tt tw_tx tu_tv ty_tz')]/input")
	WebElement enterFromCountry;
	
	@FindBy(xpath="//ul[contains(@class,'bt4_bt5 bt6_bt7 bua_bub buc_bue')]//li/button/span/span[1]")
	List<WebElement> fromCountries;
	
	String fromCountry = "Sydney";
	
	@FindBy(xpath="//div[@class='sector__field sector__field--date']")
	WebElement dateField;
	
	@FindBy(xpath="//button[@class='uj_uk ul_um up_uq uv_uw u1_u2 vb_vc vi_vj aa3_aa4 aa7_aa8 aa9_aba abb_abc abk_abl abo_abp abs_abt aiu_aiv ai0_ai1 ai2_ai3 ai4_ai5']")
	WebElement selectFlightButton;
	
	@FindBy(xpath="//div[@class='mainmenu__actions']/span/span/div/button")
	WebElement signInDropDownButton;
	
	@FindBy(xpath="//form[@id='gigya-guest-form']//button[@class='j-button j-button--primary'][contains(text(),'Sign in')]")
	WebElement signInButton;
	
	@FindBy(xpath="//input[@id='input-7456722']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@id='input-52575562']")
	WebElement password;
	
	@FindBy(xpath="//form[@id='gigya-login-form']//input[@class='j-button j-button--primary']")
	WebElement loginButton;
	
	public SelectFlight() {
		PageFactory.initElements(driver, this);
	}
	
//	Actions
	
	public void selectTripType() {
		tripDropDown.click();
		tripType.click();
	}
	
	public void selectFrom() {
//		from.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", from);
		enterFromCountry.sendKeys("sy");
		for(WebElement country: fromCountries) {
			if(country.getText().equals(fromCountry)) {
				country.click();
			}
		}
	}
	
//	public void selectTo() {
//		toField.click();
//		toCity.click();
//	}
	
	public void selectDate() {
		dateField.click();
		driver.findElement(By.xpath("//div[@class='c1c_c1e c1f_c1g']//div[2]//button//div[@class='c9a_c9b']//div[contains(text(),'18')]")).click();
	}
	
	public void selectFlight() {
		selectFlightButton.click();
	}
	
	public void signUpCheck() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
//		Boolean staleElement = true;
//		while(staleElement) {
//			try {
		wait.until(ExpectedConditions.elementToBeClickable(signInDropDownButton));
				signInDropDownButton.click();
//			} catch (StaleElementReferenceException e) {
//				staleElement=true;
//			}
//		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(signInButton));
//		Actions action = new Actions(driver);
//		action.moveToElement(signInButton).click().build().perform();
		signInButton.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", signInButton);
		Thread.sleep(3000);
		emailId.sendKeys("peddisiva1@gmail.com");
		password.sendKeys("Siva7482");
		loginButton.click();
	}

}
