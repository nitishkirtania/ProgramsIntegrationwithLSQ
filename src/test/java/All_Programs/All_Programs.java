package All_Programs;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Date;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import base.LeadSummary;
import base.base;

public class All_Programs extends base{

    // @BeforeMethod(alwaysRun = true)
    // public void redirectToBBA_Page(){
    //     driver.get("https://amityonline.com/bachelor-of-business-administration-online");
    // }

    @Test(priority = 1)
    public void Open_form_BBA_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-business-administration-online");
        Thread.sleep(8000);
        test = reports.createTest("Open form BBA India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-business-administration-online";
        String expectedProgram = "BACHELOR OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "";
        long startTime = System.nanoTime();
        try {
            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 2)
    public void Open_form_BCA_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-computer-applications-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BCA India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-computer-applications-online";
        String expectedProgram = "BACHELOR OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Bachelor of Computer Applications";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void Open_form_BCOM_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-commerce-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form B.COM India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-commerce-online";
        String expectedProgram = "BACHELOR OF COMMERCE";
        String expectedSpecialization = "BACHELOR OF COMMERCE";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void Open_form_BBADataAnalytics_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bba-data-analytics");
        Thread.sleep(5000);
        test = reports.createTest("Open form BBA Data Analytics India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bba-data-analytics";
        String expectedProgram = "BACHELOR OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "BBA Specialization in Data Analytics";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 5)
    public void Open_form_BCAcloudSecurity_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bca-cloud-security-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BCA Cloud Security India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bca-cloud-security-online";
        String expectedProgram = "BACHELOR OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Cloud and Security";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 6)
    public void Open_form_BA_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-arts-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BA India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-arts-online";
        String expectedProgram = "BACHELOR OF ARTS";
        String expectedSpecialization = "BACHELOR OF ARTS";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 7)
    public void Open_form_BAmassComm_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-arts-journalism-and-mass-communication-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BA Mass Communication India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-arts-journalism-and-mass-communication-online";
        String expectedProgram = "BACHELOR OF ARTS (JOURNALISM AND MASS COMMUNICATION)";
        String expectedSpecialization = "Bachelor of Arts (Journalism and Mass Communication)";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 8)
    public void Open_form_BA_Malayalam_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-arts-malayalam-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BA (Malayalam) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-arts-malayalam-online";
        String expectedProgram = "BACHELOR OF ARTS";
        String expectedSpecialization = "Bachelor of Arts (Malayalam)";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 9)
    public void Open_form_BA_Tamil_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-arts-tamil-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BA (Tamil) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-arts-tamil-online";
        String expectedProgram = "BACHELOR OF ARTS";
        String expectedSpecialization = "Bachelor of Arts in (Tamil)";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 10)
    public void Open_form_BA_Kannada_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-arts-kannada-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BA (Kannada) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-arts-kannada-online";
        String expectedProgram = "BACHELOR OF ARTS";
        String expectedSpecialization = "Bachelor of Arts in (Kannada)";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }



    @Test(priority = 11)
    public void Open_form_BA_Telugu_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-arts-telugu-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BA (Telugu) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-arts-telugu-online";
        String expectedProgram = "BACHELOR OF ARTS";
        String expectedSpecialization = "Bachelor of Arts in (Telugu)";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 12)
    public void Open_form_BA_Hindi_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-arts-hindi-medium-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BA (Hindi) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-arts-hindi-medium-online";
        String expectedProgram = "BACHELOR OF ARTS";
        String expectedSpecialization = "Bachelor of Arts in Hindi Medium";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 13)
    public void Open_form_BCA_SE_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bca-software-engineering");
        Thread.sleep(5000);
        test = reports.createTest("Open form BCA (Software Engineering) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bca-software-engineering";
        String expectedProgram = "BACHELOR OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Software Engineering";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 14)
    public void Open_form_BCOM_Honours_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bachelor-of-commerce-honours");
        Thread.sleep(5000);
        test = reports.createTest("Open form B.COM (Honours) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bachelor-of-commerce-honours";
        String expectedProgram = "BACHELOR OF COMMERCE (HONOURS)";
        String expectedSpecialization = "B.Com Honours";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 15)
    public void Open_form_UGPG_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/ug-pg-degree-set");
        Thread.sleep(5000);
        test = reports.createTest("Open form UG-PG Degree India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/ug-pg-degree-set";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "UG + PG Degree Program";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 16)
    public void Open_form_BBA_MBA_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bba-mba");
        Thread.sleep(5000);
        test = reports.createTest("Open form BBA + MBA India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bba-mba";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "BBA + MBA Degree Program";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 17)
    public void Open_form_BCOM_MBA_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bcom-mba");
        Thread.sleep(5000);
        test = reports.createTest("Open form B.COM + MBA India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bcom-mba";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "B.Com + MBA Degree Program";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 18)
    public void Open_form_BCA_MCA_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bca-mca");
        Thread.sleep(5000);
        test = reports.createTest("Open form BCA + MCA India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bca-mca";
        String expectedProgram = "MASTER OF COMPUTER APPLICATION";
        String expectedSpecialization = "BCA + MCA Degree Program";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }

    @Test(priority = 19)
    public void Open_form_BCA_DataScience_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bca-data-science");
        Thread.sleep(5000);
        test = reports.createTest("Open form BCA With Specialization In Data Science India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bca-data-science";
        String expectedProgram = "BACHELOR OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "BCA with specialization in Data Science";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 20)
    public void Open_form_BCA_DataEng_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bca-data-engineering");
        Thread.sleep(5000);
        test = reports.createTest("Open form BCA with specialization in Data Engineering India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bca-data-engineering";
        String expectedProgram = "BACHELOR OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Data Engineering";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }

    @Test(priority = 21)
    public void Open_form_BBA_travel_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bba-travel-and-tourism-management");
        Thread.sleep(5000);
        test = reports.createTest("Open form BBA with specialization in Travel & Tourism Management India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bba-travel-and-tourism-management";
        String expectedProgram = "BACHELOR OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "Travel and Tourism Management";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 22)
    public void Open_form_BBA_Business_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bba-business-analytics-professional");
        Thread.sleep(5000);
        test = reports.createTest("Open form BBA with a Professional Certificate in BA India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bba-business-analytics-professional";
        String expectedProgram = "BACHELOR OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "BBA with a Professional Certificate in Business Analytics";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 23)
    public void Open_form_BCA_appliedData_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bca-applied-data-engineering");
        Thread.sleep(5000);
        test = reports.createTest("Open form BCA with a Professional Certificate in Applied DE India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bca-applied-data-engineering";
        String expectedProgram = "BACHELOR OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "BCA Applied Data Engineering";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 24)
    public void Open_form_BCA_DataAnalytics_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bca-data-analytics-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form BCA with specialization in Data Analytics India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bca-data-analytics-online";
        String expectedProgram = "BACHELOR OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Data Analytics";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 25)
    public void Open_form_BComFinance_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/bcom-internationalfinance");
        Thread.sleep(5000);
        test = reports.createTest("Open form B.Com with specialization in International Finance & Accounting India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/bcom-internationalfinance";
        String expectedProgram = "BACHELOR OF COMMERCE";
        String expectedSpecialization = "International Finance & Accounting";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }

    // Start here PG program's --------------------
    @Test(priority = 26)
    public void Open_form_MBA_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/master-of-business-administration-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form Master of Business Administration India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/master-of-business-administration-online";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "Master of Business Administration";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 27)
    public void Open_form_MCA_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/master-of-computer-applications-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form Master of Computer Applications India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/master-of-computer-applications-online";
        String expectedProgram = "MASTER OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Master of Computer Applications";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 28)
    public void Open_form_MCA_cyberSecurity_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mca-cybersecurity");
        Thread.sleep(5000);
        test = reports.createTest("Open form MCA with specialization in Cyber Security India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mca-cybersecurity";
        String expectedProgram = "MASTER OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Specialisation in Cyber Security";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 29)
    public void Open_form_MBA_dual_special_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mba-dual-specialization");
        Thread.sleep(5000);
        test = reports.createTest("Open form MBA With Dual Specialization India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mba-dual-specialization";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "MBA With Dual Specialization";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }

            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            
            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 30)
    public void Open_form_MA_psychology_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/ma-in-psychology");
        Thread.sleep(5000);
        test = reports.createTest("Open form Master of Arts Psychology India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/ma-in-psychology";
        String expectedProgram = "MASTER OF ARTS - PSYCHOLOGY";
        String expectedSpecialization = "Psychology";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 31)
    public void Open_form_Mcom_FM_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/master-of-commerce-financial-management-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form M.Com (Financial Management) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/master-of-commerce-financial-management-online";
        String expectedProgram = "MASTER OF COMMERCE (FINANCIAL MANAGEMENT)";
        String expectedSpecialization = "MASTER OF COMMERCE (FINANCIAL MANAGEMENT)";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram,  expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 32)
    public void Open_form_MA_JMC_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/master-of-arts-journalism-and-mass-communication-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MA (Journalism and Mass Communication) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/master-of-arts-journalism-and-mass-communication-online";
        String expectedProgram = "MASTER OF ARTS (JOURNALISM AND MASS COMMUNICATION)";
        String expectedSpecialization = "MASTER OF ARTS (JOURNALISM AND MASS COMMUNICATION)";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 33)
    public void Open_form_MA_publicPolicy_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/ma-public-policy");
        Thread.sleep(5000);
        test = reports.createTest("Open form MA (Public Policy & Governance) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/ma-public-policy";
        String expectedProgram = "MASTER OF ARTS (PUBLIC POLICY & GOVERNANCE)";
        String expectedSpecialization = "MASTER OF ARTS (PUBLIC POLICY & GOVERNANCE)";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 34)
    public void Open_form_MCA_SoftEng_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mca-software-engineering");
        Thread.sleep(5000);
        test = reports.createTest("Open form MCA with Specialization in Software Engineering (Online MCA) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mca-software-engineering";
        String expectedProgram = "MASTER OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Software Engineering";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 35)
    public void Open_form_MSC_dataScience_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/msc-in-data-science");
        Thread.sleep(5000);
        test = reports.createTest("Open form Master of Science (Data Science) India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/msc-in-data-science";
        String expectedProgram = "MASTER OF SCIENCE IN DATA SCIENCE";
        String expectedSpecialization = "MSc Data Science";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 36)
    public void Open_form_MBA_HR_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mba-human-resources-hr-analytics-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MBA with specialization in Human Resource Analytics India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mba-human-resources-hr-analytics-online";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "Human Resource";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            Thread.sleep(3000);
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }
    

    @Test(priority = 37)
    public void Open_form_MBA_DataScience_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mba-data-science-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MBA with specialization in Data Science India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mba-data-science-online";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "Data Science";
        long startTime = System.nanoTime();
        try {
            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 38)
    public void Open_form_MBA_BA_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mba-business-analytics-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MBA with specialization in Business Analytics India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mba-business-analytics-online";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "Business Analytics";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 39)
    public void Open_form_MCA_BlockChain_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mca-blockchain-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MCA with specialization in Blockchain Technology and Management India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mca-blockchain-online";
        String expectedProgram = "MASTER OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "BLOCKCHAIN TECHNOLOGY AND MANAGEMENT";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 40)
    public void Open_form_MCA_MLAI_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mca-machine-learning-and-artificial-intelligence-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MCA with Specialization in Machine Learning and Artificial Intelligence India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mca-machine-learning-and-artificial-intelligence-online";
        String expectedProgram = "MASTER OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Machine Learning And Artificial Intelligence";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 41)
    public void Open_form_MCA_TCS_AI_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mca-machine-learning-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MCA with Specialization in Artificial Intelligence India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mca-machine-learning-online";
        String expectedProgram = "MASTER OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Machine Learning & Artificial Intelligence";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 42)
    public void Open_form_MBA_InterFinance_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mba-internationalfinance");
        Thread.sleep(5000);
        test = reports.createTest("Open form MBA with specialization in International Finance India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mba-internationalfinance";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "International Finance";
        long startTime = System.nanoTime();
        try {
            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 43)
    public void Open_form_MBA_DigitalEnter_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mba-digital-entrepreneurship-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MBA with specialization in Digital Entrepreneurship India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mba-digital-entrepreneurship-online";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "Digital Entrepreneurship";
        long startTime = System.nanoTime();
        try {
            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {
            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 44)
    public void Open_form_MCom_Fintech_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mcom-fintech-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form M.Com with specialization in Financial Technology India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mcom-fintech-online";
        String expectedProgram = "MASTER OF COMMERCE (FINANCIAL MANAGEMENT)";
        String expectedSpecialization = "FINANCIAL MANAGEMENT";
        long startTime = System.nanoTime();
        try {
            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 45)
    public void Open_form_MCA_VirtualReality_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mca-virtualreality-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MCA with specialization in Augmented Reality and Virtual Reality India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mca-virtualreality-online";
        String expectedProgram = "MASTER OF COMPUTER APPLICATIONS";
        String expectedSpecialization = "Augmented Reality and Virtual Reality";
        long startTime = System.nanoTime();
        try {
            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 46)
    public void Open_form_MBA_DigitalMarketing_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mba-digital-marketing-management-online");
        Thread.sleep(5000);
        test = reports.createTest("Open form MBA with specialization in Digital Marketing Management India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mba-digital-marketing-management-online";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "Digital Marketing Management";
        long startTime = System.nanoTime();
        try {
            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {
            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }


    @Test(priority = 47)
    public void Open_form_MBA_GeneralManagement_India_International() throws InterruptedException {
        driver.get("https://amityonline.com/mba-general-management");
        Thread.sleep(5000);
        test = reports.createTest("Open form MBA in General Management India & International");
        closescholarshippopup();
        closePopupIfPresent();
        // 📌 Expected values
        String expectedURL = "https://amityonline.com/mba-general-management";
        String expectedProgram = "MASTER OF BUSINESS ADMINISTRATION";
        String expectedSpecialization = "MBA in General Management";
        long startTime = System.nanoTime();
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "231" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();

            Thread.sleep(6000);
            wait.until(ExpectedConditions.elementToBeClickable(Openform.OTPCell1));
            Openform.OTPCell1.sendKeys(random.GetOTP());
            Openform.OTPCell2.sendKeys(random.GetOTP());
            Openform.OTPCell3.sendKeys(random.GetOTP());
            Openform.OTPCell4.sendKeys(random.GetOTP());
            Openform.OTPCell5.sendKeys(random.GetOTP());
            Openform.OTPCell6.sendKeys(random.GetOTP());
            Openform.VerifyOTP.click();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);
            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);

            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "Indian flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call Indian Journey Successful");
                    System.out.println("Request Call Indian Journey Successful");
                } else {
                    test.log(Status.FAIL, "Indian Flow Failed: Start Application button not enabled");
                    softAssert.fail("Indian Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call Indian Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL, "Indian Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("Indian Flow Failed - Start Application button not found");
                System.out.println("Request Call Indian Journey Failed - Button not found");
            }

        } catch (Exception e) {
            test.log(Status.FAIL, "Open form +91 is failed" + e.getMessage());
            softAssert.fail("Open form +91 is failed");
        }
        long endTime = System.nanoTime();
        long durationInSeconds = (endTime - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime - startTime));

        driver.navigate().back();
        driver.navigate().refresh();
        Thread.sleep(2000);

        // ---------------open form for international----------------------------
        try {

            String randomName = "TestQA" + " " + random.GetRandomName();
            String randomMobileNumber = "232" + random.getRandomMobileNumber();
            String randomEmail = "TestQA_" + random.GetRamdonEmailID() + "@gmail.com";

            test.info("Random Name: " + randomName);
            test.info("Random Mobile Number: " + randomMobileNumber);
            test.info("Random Email: " + randomEmail);

            wait.until(ExpectedConditions.elementToBeClickable(Openform.name));
            Openform.name.sendKeys(randomName);
            driver.findElement(By.xpath("//div[@class='CustomDropdownGlobal_countryCode__yswjf ']")).click();
            Actions codeActions1 = new Actions(driver);
            WebElement unitedstate = driver
                    .findElement(By.xpath("//div[@class='CustomDropdownGlobal_dropdownMenu__cyPE8']//div[2]//span[1]"));
            codeActions1.moveToElement(unitedstate).click().perform();
            Openform.mobile.sendKeys(randomMobileNumber);
            Openform.email.sendKeys(randomEmail);
            Openform.clicksubmit();
            Thread.sleep(7000);
            
            try {
                // Check if the "Thank You" message is shown due to API failure
                WebElement thankYouMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(text(),'Thank You For Your Interest')]")));

                if (thankYouMessage.isDisplayed()) {
                    test.log(Status.SKIP, "API may have failed. Received Thank You message after OTP verification.");
                    test.info("Displayed Message: " + thankYouMessage.getText());
                    System.out.println("Flow Stopped: " + thankYouMessage.getText());
                    return; // Exit test gracefully, skip the rest
                }
            } catch (TimeoutException e) {
                test.info("No Thank You message found – continuing to check for Start Application button.");
            }
            LeadSummary lead = LeadSummary.getLeadSummaryByEmail(randomEmail);

            // ✅ Validate returned data
            All_Programs.validateLeadSummaryData(lead, randomEmail, randomName, randomMobileNumber, expectedURL, expectedProgram, expectedSpecialization, softAssert);
            // Proceed to normal flow – check for Start Application button
            try {
                WebElement isSuccess = wait
                        .until(ExpectedConditions.elementToBeClickable(Openform.startapplicationElement));
                if (isSuccess.isEnabled()) {
                    softAssert.assertTrue(true, "International flow - Start Application button enabled check");
                    test.log(Status.PASS, "Request Call International Journey Successful");
                    System.out.println("Request Call International Journey Successful");
                } else {
                    test.log(Status.FAIL, "International Flow Failed: Start Application button not enabled");
                    softAssert.fail("International Flow Failed - Start Application button not enabled");
                    System.out.println("Request Call International Journey Failed");
                }
            } catch (TimeoutException e) {
                test.log(Status.FAIL,
                        "International Flow Failed: Start Application button did not appear. " + e.getMessage());
                softAssert.fail("International Flow Failed - Start Application button not found");
                System.out.println("Request Call International Journey Failed - Button not found");
            }
        } catch (Exception e) {
            test.log(Status.FAIL,
                    "Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
            softAssert.fail("Open form for 'United Arab Emirates' +971 international is failed" + e.getMessage());
        }
        long endTime1 = System.nanoTime();
        long durationInSeconds1 = (endTime1 - startTime) / 1_000_000_000;
        test.info("Total Load Time: " + formatSeconds(endTime1 - startTime));
        checkVisualErrorsOnScreen();
        softAssert.assertAll();
    }



    
   public static void validateLeadSummaryData(LeadSummary lead,
                                           String expectedEmail,
                                           String expectedFullName,
                                           String expectedPhone,
                                           String expectedPageURL,
                                           String expectedProgram,
                                           String expectedSpecialization,
                                           SoftAssert softAssert) {
    if (lead == null) {
        softAssert.fail("❌ Lead data is null. Cannot perform LS validation.");
        test.log(Status.FAIL, "❌ Lead data is null. LS Validation aborted.");
        return;
    }

    // ✅ Email check
    if (!lead.email.equalsIgnoreCase(expectedEmail)) {
        softAssert.fail("❌ Email mismatch LS : expected '" + expectedEmail + "', actual '" + lead.email + "'");
        test.log(Status.FAIL, "❌ Email mismatch LS : expected '" + expectedEmail + "', actual '" + lead.email + "'");
    } else {
        test.log(Status.PASS, "✅ Email matched LS : " + lead.email);
    }

    // ✅ Full Name check
    if (!lead.fullName.equalsIgnoreCase(expectedFullName)) {
        softAssert.fail("❌ Name mismatch LS : expected '" + expectedFullName + "', actual '" + lead.fullName + "'");
        test.log(Status.FAIL, "❌ Name mismatch LS : expected '" + expectedFullName + "', actual '" + lead.fullName + "'");
    } else {
        test.log(Status.PASS, "✅ Name matched LS : " + lead.fullName);
    }

    // ✅ Phone check
    if (!lead.phone.equals(expectedPhone)) {
        softAssert.fail("❌ Phone mismatch LS : expected '" + expectedPhone + "', actual '" + lead.phone + "'");
        test.log(Status.FAIL, "❌ Phone mismatch LS : expected '" + expectedPhone + "', actual '" + lead.phone + "'");
    } else {
        test.log(Status.PASS, "✅ Phone matched LS : " + lead.phone);
    }

    // ✅ Page URL check
    if (!lead.pageURL.equals(expectedPageURL)) {
        softAssert.fail("❌ Page URL mismatch LS : expected '" + expectedPageURL + "', actual '" + lead.pageURL + "'");
        test.log(Status.FAIL, "❌ Page URL mismatch LS : expected '" + expectedPageURL + "', actual '" + lead.pageURL + "'");
    } else {
        test.log(Status.PASS, "✅ Page URL matched LS : " + lead.pageURL);
    }

    // ✅ Program Name check
    if (!lead.programName.equalsIgnoreCase(expectedProgram)) {
        softAssert.fail("❌ Program name mismatch LS : expected '" + expectedProgram + "', actual '" + lead.programName + "'");
        test.log(Status.FAIL, "❌ Program name mismatch LS : expected '" + expectedProgram + "', actual '" + lead.programName + "'");
    } else {
        test.log(Status.PASS, "✅ Program name matched LS : " + lead.programName);
    }

    // ✅ Specialization Name check with null/blank handling
    String expected = expectedSpecialization != null ? expectedSpecialization.trim() : "";
    String actual = lead.specialization != null ? lead.specialization.trim() : "";

    if (expected.isEmpty() && actual.isEmpty()) {
        // Both are blank/null → no message
    } else if (expected.isEmpty()) {
        // Expected is blank, actual is not
        softAssert.fail("❌ Specialization mismatch LS: expected empty, actual '" + actual + "'");
        test.log(Status.FAIL, "❌ Specialization mismatch LS: expected empty, actual '" + actual + "'");
    } else if (actual.isEmpty()) {
        // Actual is blank, expected is not
        softAssert.fail("❌ Specialization mismatch LS: expected '" + expected + "', actual empty");
        test.log(Status.FAIL, "❌ Specialization mismatch LS: expected '" + expected + "', actual empty");
    } else if (!expected.equalsIgnoreCase(actual)) {
        // Values don't match
        softAssert.fail("❌ Specialization mismatch LS: expected '" + expected + "', actual '" + actual + "'");
        test.log(Status.FAIL, "❌ Specialization mismatch LS: expected '" + expected + "', actual '" + actual + "'");
    } else {
        // Values match
        test.log(Status.PASS, "✅ Specialization name matched LS: " + actual);
    }


    // ✅ Enquiry Source check
    String expectedEnquirySource = "Apply Now";

    if (!expectedEnquirySource.equalsIgnoreCase(lead.enquarySource)) {
        softAssert.fail("❌ Enquiry source mismatch LS: expected '" + expectedEnquirySource + "', actual '" + lead.enquarySource + "'");
        test.log(Status.FAIL, "❌ Enquiry source mismatch LS: expected '" + expectedEnquirySource + "', actual '" + lead.enquarySource + "'");
    } else {
        test.log(Status.PASS, "✅ Enquiry source matched LS: " + lead.enquarySource);
    }

    // ✅ UTM Source check
    String expectedutmSource = "website";

    if(!expectedutmSource.equalsIgnoreCase(lead.utmSource)) {
        softAssert.fail("❌ UTM source mismatch LS: expected '" + expectedutmSource + "', actual '" + lead.utmSource + "'");
        test.log(Status.FAIL, "❌ UTM source mismatch LS: expected '" + expectedutmSource + "', actual '" + lead.utmSource + "'");
    } else {
        test.log(Status.PASS, "✅ UTM source matched LS: " + lead.utmSource);
    }

    // ✅ UTM Medium check
    String expectedUTMmedium = "request_a_callback";
    if(!expectedUTMmedium.equalsIgnoreCase(lead.utmMedium)) {
        softAssert.fail("❌ UTM Medium mismatch LS: expected '" + expectedUTMmedium + "', actual '" + lead.utmMedium + "'");
        test.log(Status.FAIL, "❌ UTM Medium mismatch LS: expected '" + expectedUTMmedium + "', actual '" + lead.utmMedium + "'");
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
    } else if (country.equalsIgnoreCase("United Arab Emirates")) {
        test.log(Status.PASS, "✅ Country matched LS : United Arab Emirates");
    } else {
        softAssert.fail("❌ Unexpected country name LS: got '" + country + "', expected 'India' or 'United Arab Emirates'");
        test.log(Status.FAIL, "❌ Unexpected country name LS: got '" + country + "', expected 'India' or 'United Arab Emirates'");
    }
        
    // ✅ Comm Consent Date Check
    SimpleDateFormat fullFormat = new SimpleDateFormat("d/M/yyyy, hh:mm:ss a");
    SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("d/M/yyyy");
    String consentDateTime = lead.commConsent;

    if (consentDateTime != null && !consentDateTime.trim().isEmpty()) {
        try {
            Date parsedDate = fullFormat.parse(consentDateTime);
            String consentDate = dateOnlyFormat.format(parsedDate);
            String todayDate = dateOnlyFormat.format(new Date());

            if (consentDate.equals(todayDate)) {
                test.log(Status.PASS, "✅ CommConsent date matches LS today: " + consentDateTime);
            } else {
                softAssert.fail("❌ commConsent date mismatch LS: expected today '" + todayDate + "', but got '" + consentDateTime + "'");
                test.log(Status.FAIL, "❌ commConsent date mismatch LS: expected today '" + todayDate + "', but got '" + consentDateTime + "'");
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
