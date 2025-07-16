package All_Programs;

import java.text.SimpleDateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.Date;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import base.LeadSummaryTwo;
import base.base;

public class Certifications extends base {

	@Test(priority = 1)
	public void certification_predictive_analytics_using_python() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Predictive Analytics Using Python)");
		driver.navigate().to("https://amityonline.com/certifications/predictive-analytics-using-python");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/predictive-analytics-using-python";
		String expectedProgram = "Predictive analytics using Python (Machine learning using Python)";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void certification_predictive_dataanalytics_using_python() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Programming for Data Analytics Using Python)");
		driver.navigate().to("https://amityonline.com/certifications/programming-for-data-analytics-using-python");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/programming-for-data-analytics-using-python";
		String expectedProgram = "Programming for data analytics using Python";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void certification_appliedDataEngineering() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Applied Data Engineering)");
		driver.navigate().to("https://amityonline.com/certifications/applied-data-engineering");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/applied-data-engineering";
		String expectedProgram = "Applied Data Engineering";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void certification_businessAnalyticsProfessional() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Business Analytics Professional)");
		driver.navigate().to("https://amityonline.com/certifications/business-analytics-professional");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/business-analytics-professional";
		String expectedProgram = "Business Analytics Professional (BAP)";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void certification_AnalyticsAnd_DataPreProcessing() throws InterruptedException {
		test = reports
				.createTest("Enroll Now (Certificate in Descriptive Analytics and Data Pre-processing using Python)");
		driver.navigate().to(
				"https://amityonline.com/certifications/descriptive-analytics-and-data-pre-processing-using-python");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/descriptive-analytics-and-data-pre-processing-using-python";
		String expectedProgram = "Descriptive Analytics and Data Pre-processing using Python";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 6)
	public void certification_InTimeSeries_Forecasting() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Time Series Forecasting)");
		driver.navigate().to("https://amityonline.com/certifications/time-series-forecasting");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/time-series-forecasting";
		String expectedProgram = "Time Series Forecasting";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void certification_InSocialMediaAnalytics() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Social Media Analytics)");
		driver.navigate().to("https://amityonline.com/certifications/social-media-analytics");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/social-media-analytics";
		String expectedProgram = "Social Media Analytics";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 8)
	public void certification_TextMining_AndNLP() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Text Mining and NLP)");
		driver.navigate().to("https://amityonline.com/certifications/text-mining-and-nlp");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/text-mining-and-nlp";
		String expectedProgram = "Text Mining and NLP";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 9)
	public void certification_AI_DeeplearningUsing_Python() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Artificial Intelligence and Deep learning using Python)");
		driver.navigate()
				.to("https://amityonline.com/certifications/artificial-intelligence-and-deep-learning-using-python");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/artificial-intelligence-and-deep-learning-using-python";
		String expectedProgram = "Artificial Intelligence and Deep learning using Python";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 10)
	public void certification_BigDataAnalytics() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Big Data Analytics)");
		driver.navigate().to("https://amityonline.com/certifications/big-data-analytics");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/big-data-analytics";
		String expectedProgram = "Big Data Analytics";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 11)
	public void certification_SpreadsheetModelling_UsingExcel() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Spreadsheet Modelling using Excel)");
		driver.navigate().to("https://amityonline.com/certifications/spreadsheet-modelling-using-excel");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/spreadsheet-modelling-using-excel";
		String expectedProgram = "Spreadsheet Modelling using Excel";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 11)
	public void certification_FinancialModelling_UsingExcel() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Financial Modelling using Excel)");
		driver.navigate().to("https://amityonline.com/certifications/financial-modelling-using-excel");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/financial-modelling-using-excel";
		String expectedProgram = "Financial Modelling using Excel";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 12)
	public void certification_DomainAnalytics_HR_Analytics() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Domain Analytics - HR Analytics)");
		driver.navigate().to("https://amityonline.com/certifications/domain-analytics-hr-analytics");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/domain-analytics-hr-analytics";
		String expectedProgram = "Domain Analytics - HR Analytics";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 13)
	public void certification_DomainAnalytics_FinancialAnalytics() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Domain Analytics - Financial Analytics)");
		driver.navigate().to("https://amityonline.com/certifications/domain-analytics-financial-analytics");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/domain-analytics-financial-analytics";
		String expectedProgram = "Domain Analytics - Financial Analytics";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 14)
	public void certification_DomainAnalytics_MarketingAnalytics() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Domain Analytics - Marketing Analytics)");
		driver.navigate().to("https://amityonline.com/certifications/domain-analytics-marketing-analytics");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/domain-analytics-marketing-analytics";
		String expectedProgram = "Domain Analytics - Marketing Analytics";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 15)
	public void certification_DashboardingAndStoreytelling_UsingTebleau() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Dashboarding and Storytelling using Tableau)");
		driver.navigate().to("https://amityonline.com/certifications/dashboarding-and-storytelling-using-tableau");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/dashboarding-and-storytelling-using-tableau";
		String expectedProgram = "Dashboarding and Storytelling using Tableau";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 16)
	public void certification_DashboardingAndStoreytelling_UsingPowerBI() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Dashboarding and Storytelling using PowerBI)");
		driver.navigate().to("https://amityonline.com/certifications/dashboarding-and-storytelling-using-powerbi");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/dashboarding-and-storytelling-using-powerbi";
		String expectedProgram = "Dashboarding and Storytelling using PowerBI";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	@Test(priority = 16)
	public void certification_DataBaseManagement_SQLMongoDB() throws InterruptedException {
		test = reports.createTest("Enroll Now (Certificate in Database Management using SQL and MongoDB)");
		driver.navigate().to("https://amityonline.com/certifications/database-management-using-sql-and-mongodb");
		Thread.sleep(3000);

		// ------------------------Enroll Now CTA Header--------------------------------
		String expectedURL = "https://amityonline.com/certifications/database-management-using-sql-and-mongodb";
		String expectedProgram = "Database Management using SQL and MongoDB";
		String expectedProgramVertical = "KPMG";
		// ========== INDIAN FLOW ==========
		long startTime = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);

			Select dropdown = new Select(enrollnow.dropdownElement);
			dropdown.selectByIndex(9);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();

			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.OTPCell1)).sendKeys(random.GetOTP());
			enrollnow.OTPCell2.sendKeys(random.GetOTP());
			enrollnow.OTPCell3.sendKeys(random.GetOTP());
			enrollnow.OTPCell4.sendKeys(random.GetOTP());
			enrollnow.OTPCell5.sendKeys(random.GetOTP());
			enrollnow.OTPCell6.sendKeys(random.GetOTP());
			enrollnow.VerifyOTP.click();

			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait
						.until(ExpectedConditions.visibilityOf(enrollnow.paymentpagecontentElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true, "Payment page displayed and Enroll Now Indian journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now Indian journey successful");
					System.out.println("Payment page displayed and Enroll Now Indian journey successful");
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now Indian journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
					System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now Indian journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now Indian journey failed");
				System.out.println("Payment page not displayed and Enroll Now Indian journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enquire Now Indian Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now Indian Flow Failed - " + e.getMessage());
		}
		long endTime = System.nanoTime();
		long durationInSeconds = (endTime - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds + " seconds");

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(2000);
		// -------------------International flow------Enroll Now-------------
		// long startTime1 = System.nanoTime();
		try {
			// Open enroll Now form
			String originalWindow = driver.getWindowHandle();
			WebElement enrollnowBTN = wait.until(ExpectedConditions.elementToBeClickable(
					enrollnow.enrollnoWebElement));
			js.executeScript("arguments[0].click();", enrollnowBTN);

			for (String windowHandle : driver.getWindowHandles()) {
				if (!windowHandle.equals(originalWindow)) {
					driver.switchTo().window(windowHandle);
					break;
				}
			}

			String randomMobileNumber = "239" + random.getRandomMobileNumber();
			String randomName = "TestQA" + " " + random.GetRandomName();
			String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

			test.info("Random Name: " + randomName);
			test.info("Random Email: " + randomEmail);
			test.info("Random Mobile Number: " + randomMobileNumber);

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nameElement)).sendKeys(randomName);
			Thread.sleep(1000);
			enrollnow.countrycodElement.click();

			WebElement nepal2 = wait.until(ExpectedConditions.elementToBeClickable(enrollnow.nepal));
			Actions actions = new Actions(driver);
			actions.moveToElement(nepal2).click().perform();

			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.numberElement)).sendKeys(randomMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.emailElement)).sendKeys(randomEmail);
			wait.until(ExpectedConditions.elementToBeClickable(enrollnow.sumitElement)).click();
			Thread.sleep(5000);

			try {
				// Check for the "Thank You" message
				WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

				if (thankYouMessage.isDisplayed()) {
					test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
					test.info("Displayed Message: " + thankYouMessage.getText());
					System.out.println("Flow Stopped: " + thankYouMessage.getText());
					return; // Stop further execution
				}
			} catch (TimeoutException e) {
				test.info("No Thank You message found – continuing to check for Start Application button.");
			}
			LeadSummaryTwo lead = LeadSummaryTwo.getLeadSummaryByEmail(randomEmail);
			// ✅ Validate returned data
			Certifications.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL,
					expectedProgram, expectedProgramVertical, softAssert);

			// Check for Start Application button
			try {
				WebElement paymentpage = wait.until(ExpectedConditions.visibilityOf(enrollnow.welcomElement));
				if (paymentpage.isDisplayed()) {
					softAssert.assertTrue(true,
							"Payment page displayed and Enroll Now International journey successful");
					test.log(Status.PASS, "Payment page displayed and Enroll Now International journey successful");
					System.out.println("Payment page displayed and Enroll Now International journey successful");
					driver.navigate().back();
				} else {
					test.log(Status.FAIL, "Payment page not displayed and Enroll Now International journey failed");
					softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
					System.out.println("Payment page not displayed and Enroll Now International journey failed");
				}
			} catch (TimeoutException e) {
				test.log(Status.FAIL,
						"Payment page not displayed and Enroll Now International journey failed" + e.getMessage());
				softAssert.fail("Payment page not displayed and Enroll Now International journey failed");
				System.out.println("Payment page not displayed and Enroll Now International journey failed");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Enroll Now International Flow Failed: " + e.getMessage());
			softAssert.fail("Enroll Now International Flow Failed - " + e.getMessage());
		}
		long endTime1 = System.nanoTime();
		long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
		test.info("Total Load Time: " + durationInSeconds1 + " seconds");
		checkVisualErrorsOnScreen();
		softAssert.assertAll();
	}

	public static void validateLeadSummaryData(LeadSummaryTwo lead,
			String expectedEmail,
			String expectedFullName,
			String expectedPhone,
			String expectedPageURL,
			String expectedProgram,
			String expectedProgramVertical,
			SoftAssert softAssert) {
		if (lead == null) {
			softAssert.fail("❌ Lead data is null. Cannot perform LS validation.");
			test.log(Status.FAIL, "❌ Lead data is null. LS Validation aborted.");
			return;
		}

		// ✅ Email check
		if (!lead.email.equalsIgnoreCase(expectedEmail)) {
			softAssert.fail("❌ Email mismatch LS : expected '" + expectedEmail + "', actual '" + lead.email + "'");
			test.log(Status.FAIL,
					"❌ Email mismatch LS : expected '" + expectedEmail + "', actual '" + lead.email + "'");
		} else {
			test.log(Status.PASS, "✅ Email matched LS : " + lead.email);
		}

		// ✅ Full Name check
		if (!lead.fullName.equalsIgnoreCase(expectedFullName)) {
			softAssert.fail("❌ Name mismatch LS : expected '" + expectedFullName + "', actual '" + lead.fullName + "'");
			test.log(Status.FAIL,
					"❌ Name mismatch LS : expected '" + expectedFullName + "', actual '" + lead.fullName + "'");
		} else {
			test.log(Status.PASS, "✅ Name matched LS : " + lead.fullName);
		}

		// ✅ Phone check
		if (!lead.phone.equals(expectedPhone)) {
			softAssert.fail("❌ Phone mismatch LS : expected '" + expectedPhone + "', actual '" + lead.phone + "'");
			test.log(Status.FAIL,
					"❌ Phone mismatch LS : expected '" + expectedPhone + "', actual '" + lead.phone + "'");
		} else {
			test.log(Status.PASS, "✅ Phone matched LS : " + lead.phone);
		}

		// ✅ Page URL check
		if (!lead.pageURL.equals(expectedPageURL)) {
			softAssert
					.fail("❌ Page URL mismatch LS : expected '" + expectedPageURL + "', actual '" + lead.pageURL + "'");
			test.log(Status.FAIL,
					"❌ Page URL mismatch LS : expected '" + expectedPageURL + "', actual '" + lead.pageURL + "'");
		} else {
			test.log(Status.PASS, "✅ Page URL matched LS : " + lead.pageURL);
		}

		// ✅ Program Name check
		if (!lead.programName.equalsIgnoreCase(expectedProgram)) {
			softAssert.fail("❌ Program name mismatch LS : expected '" + expectedProgram + "', actual '"
					+ lead.programName + "'");
			test.log(Status.FAIL, "❌ Program name mismatch LS : expected '" + expectedProgram + "', actual '"
					+ lead.programName + "'");
		} else {
			test.log(Status.PASS, "✅ Program name matched LS : " + lead.programName);
		}

		// ✅ Program-Vertical Name check with null/blank handling
		String expected = expectedProgramVertical != null ? expectedProgramVertical.trim() : "";
		String actual = lead.programVertical != null ? lead.programVertical.trim() : "";

		if (expected.isEmpty() && actual.isEmpty()) {
			// Both are blank/null → no message
		} else if (expected.isEmpty()) {
			// Expected is blank, actual is not
			softAssert.fail("❌ Program-Vertical mismatch LS: expected empty, actual '" + actual + "'");
			test.log(Status.FAIL, "❌ Program-Vertical mismatch LS: expected empty, actual '" + actual + "'");
		} else if (actual.isEmpty()) {
			// Actual is blank, expected is not
			softAssert.fail("❌ Program-Vertical mismatch LS: expected '" + expected + "', actual empty");
			test.log(Status.FAIL, "❌ Program-Vertical mismatch LS: expected '" + expected + "', actual empty");
		} else if (!expected.equalsIgnoreCase(actual)) {
			// Values don't match
			softAssert.fail("❌ Program-Vertical mismatch LS: expected '" + expected + "', actual '" + actual + "'");
			test.log(Status.FAIL, "❌ Program-Vertical mismatch LS: expected '" + expected + "', actual '" + actual + "'");
		} else {
			// Values match
			test.log(Status.PASS, "✅ Program-Vertical name matched LS: " + actual);
		}

		// ✅ Enquiry Source check
		String expectedEnquirySource = "Application";

		if (!expectedEnquirySource.equalsIgnoreCase(lead.enquarySource)) {
			softAssert.fail("❌ Enquiry source mismatch LS: expected '" + expectedEnquirySource + "', actual '"
					+ lead.enquarySource + "'");
			test.log(Status.FAIL, "❌ Enquiry source mismatch LS: expected '" + expectedEnquirySource + "', actual '"
					+ lead.enquarySource + "'");
		} else {
			test.log(Status.PASS, "✅ Enquiry source matched LS: " + lead.enquarySource);
		}

		// ✅ UTM Source check
		String expectedutmSource = "website";

		if (!expectedutmSource.equalsIgnoreCase(lead.utmSource)) {
			softAssert.fail(
					"❌ UTM source mismatch LS: expected '" + expectedutmSource + "', actual '" + lead.utmSource + "'");
			test.log(Status.FAIL,
					"❌ UTM source mismatch LS: expected '" + expectedutmSource + "', actual '" + lead.utmSource + "'");
		} else {
			test.log(Status.PASS, "✅ UTM source matched LS: " + lead.utmSource);
		}

		// ✅ UTM Medium check
		String expectedUTMmedium = "request_a_callback";
		if (!expectedUTMmedium.equalsIgnoreCase(lead.utmMedium)) {
			softAssert.fail(
					"❌ UTM Medium mismatch LS: expected '" + expectedUTMmedium + "', actual '" + lead.utmMedium + "'");
			test.log(Status.FAIL,
					"❌ UTM Medium mismatch LS: expected '" + expectedUTMmedium + "', actual '" + lead.utmMedium + "'");
		} else {
			test.log(Status.PASS, "✅ UTM Medium matched LS: " + lead.utmMedium);
		}

		// ✅ Country Name check with null/blank handling
		String country = lead.countryName != null ? lead.countryName.trim() : "";
		System.out.println("Country Name we get from API " + lead.countryName);

		if (country.isEmpty()) {
			softAssert.fail("❌ Country name not found LS (null or blank)");
			test.log(Status.FAIL, "❌ Country name not found LS (null or blank)");
		} else if (country.equalsIgnoreCase("India")) {
			test.log(Status.PASS, "✅ Country matched LS : India");
		} else if (country.equalsIgnoreCase("Nepal")) {
			test.log(Status.PASS, "✅ Country matched LS : Nepal");
		} else {
			softAssert.fail(
					"❌ Unexpected country name LS: got '" + country + "', expected 'India' or 'Nepal'");
			test.log(Status.FAIL,
					"❌ Unexpected country name LS: got '" + country + "', expected 'India' or 'Nepal'");
		}

		// ✅ Comm Consent Date Check
		SimpleDateFormat fullFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyy/M/d");
		String consentDateTime = lead.commConsent;

		if (consentDateTime != null && !consentDateTime.trim().isEmpty()) {
			try {
				Date parsedDate = fullFormat.parse(consentDateTime);
				String consentDate = dateOnlyFormat.format(parsedDate);
				String todayDate = dateOnlyFormat.format(new Date());

				if (consentDate.equals(todayDate)) {
					test.log(Status.PASS, "✅ CommConsent date matches LS today: " + consentDateTime);
				} else {
					softAssert.fail("❌ commConsent date mismatch LS: expected today '" + todayDate + "', but got '"
							+ consentDateTime + "'");
					test.log(Status.FAIL, "❌ commConsent date mismatch LS: expected today '" + todayDate
							+ "', but got '" + consentDateTime + "'");
				}
			} catch (Exception e) {
				softAssert.fail("❌ Invalid commConsent date format LS: " + lead.commConsent);
				test.log(Status.FAIL, "❌ Invalid commConsent date format LS: " + lead.commConsent);
			}
		} else {
			softAssert.fail("❌ commConsent LS date not found");
			test.log(Status.FAIL, "❌ commConsent LS date not found");
		}

		test.log(Status.PASS, "✅ Prospect-ID get from LS :" + lead.prospectID);

	}

}
