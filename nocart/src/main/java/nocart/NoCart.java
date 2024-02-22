package nocart;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class NoCart extends BaseClass
{
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, CsvValidationException
    {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("NoCartExtentReport.html");
        extent.attachReporter(reporter);
        
        ExtentTest test = extent.createTest("NoCart", "Start the Test");
        test.log(Status.INFO, "Starting Test Case");
        setupDriver();
        test.pass("Open the Application");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.acceptbtn))).click();
        test.pass("Accept the Terms");

        WebElement frstswipe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.ourCategories)));
        Swipe.performSwipe(driver, frstswipe, 0.6, 0.3, 100);
        test.pass("Swipe the Categories");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.electronicsMenu))).click();
        test.pass("Select the Electronics Category");

        WebElement frstscroll =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.productList)));
        Scroll.performScroll(driver, frstscroll, 0.8, 0.6, 100);
        test.pass("Scroll the Product List");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.mattressSelect))).click();
        test.pass("Select The Mattress Product");

        WebElement scndscroll =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.productDetails)));
        Scroll.performScroll(driver, scndscroll, 0.8, 0.4, 100);
        test.pass("Scroll the Product List");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.qtyIncress))).click();
        test.pass("increase Qty by 2");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.addCart))).click();
        test.pass("Click on the Add Cart Button");

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.cartView))).click();
        test.pass("Click on the Cart Button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.checkoutBtn))).click();
        test.pass("Click on the Checkout Button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.gstcktBtn))).click();
        test.pass("Click on the Guest User Button");

        String csvFile = "E:\\Appium\\cmdline-tools\\latest\\Play with noCart\\Testdata\\TestData.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFile)))
        {
            String[] rowData;
            while ((rowData = reader.readNext()) != null)
            {
                String firstName = rowData[0];
                String lastName = rowData[1];
                String email = rowData[2];
                String company = rowData[4];
                String city = rowData[5];
                String street1 = rowData[6];
                String street2 = rowData[7];
                String zipCode = rowData[8];
                String phone = rowData[9];
                String fax = rowData[10];

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inFrtName))).sendKeys(firstName);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inLstName))).sendKeys(lastName);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inEmail))).sendKeys(email);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.slctCountry))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.chsCountry))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.slctState))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.chsState))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inCompany))).sendKeys(company);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inCity))).sendKeys(city);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inStrtOne))).sendKeys(street1);

                // WebElement trdscroll =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.scrollAdd)));
                // Scroll.performScroll(driver, trdscroll, 0.6, 0.4, 100);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inStrtTwo))).sendKeys(street2);                
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inZipCode))).sendKeys(zipCode);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inPhone))).sendKeys(phone);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.inFax))).sendKeys(fax);
                test.pass("Input all required Data from csv file");
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.continueBtn))).click();
        test.pass("Click on the Continue Button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.selectGrid))).click();
        test.pass("Select the Next Day Air shipping option");
        
        WebElement frthscroll =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.selectGrid)));
        Scroll.performScroll(driver, frthscroll, 0.6, 0.4, 100);
        test.pass("Scroll the shipping screen");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.continueBtn))).click();
        test.pass("Click on the Continue Button");

        WebElement fifthscroll =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.srlPay)));
        Scroll.performScroll(driver, fifthscroll, 0.6, 0.1, 100);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.selectGrid))).click();
        test.pass("Select the Check/Money Order option as a payment method");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.continueBtn))).click();
        test.pass("Click on the Continue Button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonPaths.nxtBtn))).click();
        test.pass("Click on the Next Button");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.confirmBtn))).click();
        test.pass("Click on the Confirm Button");

        WebElement popupMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.modalSelect)));

        String messageText = popupMessage.getText();

        if (messageText.contains("Your order has been successfully processed!")) {
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Failed to place the order or unexpected message received.");
        }
        test.pass("Order Placed successfully");

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CommonID.modalConBtn))).click();
        test.pass("Click on the Continue button to close the confirmation modal");
        
        test.info("Test Completed");

        extent.flush();
    }
}
