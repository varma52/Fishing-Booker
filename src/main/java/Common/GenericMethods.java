package Common;

import static org.testng.Assert.assertTrue;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BrowserInvoke;

public class GenericMethods extends BrowserInvoke {

	public boolean isDisplayed(By locator)  {

		try {
			driver.findElement(locator).isDisplayed();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isEnabled(By locator) {

		try {
			driver.findElement(locator).isEnabled();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	public boolean explicitWaitClick(By locator) {

		if (isDisplayed(locator) && isEnabled(locator)) {

			try {
				WebElement ele = driver.findElement(locator);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				ele.click();
				return true;

			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}

		} else
			return false;
	}

	public void implicitWait(int seconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public boolean DropDownVisText(By locator, String visibleText) {

		if (isDisplayed(locator) && isEnabled(locator)) {

			try {

				WebElement ele = driver.findElement(locator);
				Select select = new Select(ele);
				select.selectByVisibleText(visibleText);
				return true;

			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

	public boolean DropDownIndex(By locator, int index) {

		if (isDisplayed(locator) && isEnabled(locator)) {

			try {

				Select select = new Select(driver.findElement(locator));
				select.selectByIndex(index);
				return true;

			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}

		} else
			return false;

	}

	public boolean sendkeys(By locator, String text) {

		if (isDisplayed(locator) && isEnabled(locator)) {

			try {

				driver.findElement(locator).sendKeys(text);
				return true;

			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}

		} else
			return false;

	}

	public void sendkeysEnter(By locator, String text) {

		WebElement ele = driver.findElement(locator);
		ele.sendKeys(text);
		delay(2);
		ele.sendKeys(Keys.ENTER);

	}

	public boolean clickElement(By locator) {

		if (isDisplayed(locator) && isEnabled(locator)) {

			try {

				driver.findElement(locator).click();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else
			return false;

	}

	public void alertAccept(By locator) {

		try {

			driver.switchTo().alert().accept();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void alertDismiss() {

		try {

			driver.switchTo().alert().dismiss();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String alertText() {

		try {

			Alert at = driver.switchTo().alert();
			String str = at.getText();
			at.accept();
			return str;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public void alertSendkeys(String text) {

		try {

			driver.switchTo().alert().sendKeys(text);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public boolean MoveToElementClick(By locator) {

		if (isDisplayed(locator) && isEnabled(locator)) {

			try {

				WebElement ele = driver.findElement(locator);
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				ele.click();
				return true;

			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

	public String getText(By locator) {

		if (isDisplayed(locator) && isEnabled(locator)) {

			try {

				return driver.findElement(locator).getText();

			} catch (Exception e) {

				e.printStackTrace();
				return null;
			}

		} else
			return null;

	}

	public boolean checkBox(By locator) {

		if (isDisplayed(locator) && isEnabled(locator)) {

			try {

				WebElement ele = driver.findElement(locator);
				if (!ele.isSelected()) {
					ele.click();
				}
				return true;

			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}
		}

		else
			return false;

	}

	public boolean clearText(By locator) {

		if (isDisplayed(locator) && isEnabled(locator)) {

			try {

				driver.findElement(locator).clear();
				return true;

			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}
		} else
			return false;

	}

	public String getTitle() {

		String str = driver.getTitle();
		return str;
	}

	public String excelRead(String path, int sheetNo, int row, int cell) {

		try {
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(sheetNo);
			String str = sheet.getRow(row).getCell(cell).toString();
			return str;

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}

	}

	// Assert for verifying an element is present in current page.

	public static void DisplayElementAssert(By locator) {
		WebElement ele = driver.findElement(locator);
		assertTrue(ele.isDisplayed());
	}

	public void screenshot(String picName) {
		try {

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/" + picName+".png");
			FileUtils.copyFile(sourceFile, destFile);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// switching to child window

	public void ChildWindow() {

		Set<String> ids = driver.getWindowHandles();
		List<String> windowID = new ArrayList<String>(ids);
		//String parentwindowID = windowID.get(0);
		String childWindowID = windowID.get(1);
		driver.switchTo().window(childWindowID);

	}

	// switching to parent window

	public void parentWindow() {

		Set<String> ids = driver.getWindowHandles();		
		Iterator<String> it=ids.iterator();
		String parentId=it.next();
		//String childId=it.next();
		driver.switchTo().window(parentId);
	}

	
	// Select date upto september 2024 only. next dates are not available in
	// website.

	public void datePicker(String monthndYear, String date, By Dateicon, By MonthAndYear, By NextButton, By DayPath)

	{
		WebElement ele = driver.findElement(Dateicon);
		ele.click();
		while (true) {
			String data = driver.findElement(MonthAndYear).getText();
			if (data.equalsIgnoreCase(monthndYear))
				break;
			else
				driver.findElement(NextButton).click();
		}

		List<WebElement> day = driver.findElements(DayPath);
		for (WebElement element : day) {
			if (element.isEnabled()) {
				String dt = element.getText();
				if (dt.equals(date)) {
					element.click();
					break;
				}
			}
		}
	}

	public void refresh() {

		driver.navigate().refresh();
	}

	public void pageBackward() {

		driver.navigate().back();
	}

	public void quitBrowser() {

		driver.quit();
	}
	
	public void delay(int timesec) {

		long start = System.currentTimeMillis();

		long end = start + timesec * 1000;

		while (System.currentTimeMillis() < end)

		{

		    // Some expensive operation on the item.

		}



	}

}
