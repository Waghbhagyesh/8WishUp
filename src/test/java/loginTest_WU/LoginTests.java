package loginTest_WU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import loginPage_WU.LoginPage;

public class LoginTests {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/LoginPageFunctionalityReportFor_WU.html");
	WebDriver driver;


	@BeforeTest
	public void reportSetup() {
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Wishup Login Page Functionality Test Report");
		extent.attachReporter(spark);
	}

	@BeforeMethod
	public void browserLaunchSetup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app-dev.wishup.co/");
	}

	@Test(dataProvider = "loginTestData")
	public void login_WishupApp(String username, String password, String scenario) {
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Functionality Validation");
		test.info("Assignment-Wishup Login Credentials Verification");

		LoginPage log = new LoginPage(driver);
		log.enterUserName(username);
		log.enterPassword(password);
		log.clickLoginButton();

		if(scenario.equals("invalid log cred")) {
			test.info("username : "+username);
			test.info("password : "+password);
			test.info("Error massage: reset your password");
			test.pass("Wishup Login Credentials invalid");
			Assert.assertTrue(log.isResetyourPassowordEnable());
			Reporter.log("Wishup Login Credentials invalid");
		}
		else 
		{
			Assert.assertEquals(log.getUserProfileText(), "Test");
			test.info("username : "+username);
			test.info("password : "+password);
			test.pass("Wishup Login Credentials are valid");
			Reporter.log("Wishup Login Credentials Valid");
		}
	}

	@DataProvider
	public Object[][] loginTestData() {

		Object data[][] = {
				{ "wishup_testuser1@gmail.com", "testpw1","valid log cred" }, 
				{ "wishup_testuser2@gmail.com", "testpw2" ,"invalid log cred"},
				{ "wishup_testuser3@gmail.com", "testpw3","valid log cred" }, 
				{ "wishup_testuser4@gmail.com", "testpw4","valid log cred" }
		};
		return data;
	}

	@Test(priority=1)
	public void WishUp_login_without_Cred(){

		ExtentTest test = extent.createTest("Assignment-WishUp Login Page Login without Credential Verification");
		LoginPage log = new LoginPage(driver);
		test.info("username :No inpute ");
		test.info("password :No inpute ");
		log.clickLoginButton();
		Assert.assertTrue(log.isCorrectFormErrorDisplayed());

		test.info("Error massage: Please correct error in form");
		test.pass("WishUp_login_without_Cred : Pass");
		Reporter.log("WishUp_login_without_Cred : Pass");
	}

	@Test(priority=2)
	public void test_PageUrl_Validation()  {
		String expected_Url="https://app-dev.wishup.co/login?redirect=%2F";
		Assert.assertEquals(driver.getCurrentUrl(),expected_Url);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page URL Verification");
		test.info("test_PageUrl_Validation(");
		test.pass("test_PageUrl_Validation( : Pass");
		Reporter.log("test_PageUrl_Validation( : Pass");
	}

	@Test(priority=3)
	public void test_pageTitle_Validation() {

		String actualogageTitle=driver.getTitle();
		String expectedPageTitle="Wishup App";
		Assert.assertEquals(actualogageTitle,expectedPageTitle);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Title Verification");
		test.info("test_pageTitle_Validation");
		test.pass("test_pageTitle_Validation : Pass");
		Reporter.log("pageTitle_Validation : Pass");
	}

	@Test(priority=4)
	public void test_SignupBtn_validation()	{

		LoginPage log = new LoginPage(driver);
		log.clickOnSignup();
		String expectrdUrl="https://app-dev.wishup.co/signup?redirect=/";
		Assert.assertEquals(driver.getCurrentUrl(), expectrdUrl);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Signup-Button Verification");
		test.info("test_Signup_Button");
		test.pass("test_SignupBtn_validation : Pass");
		Reporter.log("test_SignupBtn_validation: Pass");
	}

	@Test(priority=5)
	public void test_isUserNameFieldDisplayed() {

		LoginPage log = new LoginPage(driver);
		boolean userNameField=log.isUserNameFieldDisplayed();
		Assert.assertTrue(userNameField);
		ExtentTest test = extent.createTest("Assignment-WishUp Login Page UserName Field Verification");
		test.info("test_isUserNameFieldDisplayed");
		test.pass("test_isUserNameFieldDisplayed : Pass");
		Reporter.log("test_isUserNameFieldDisplayed : Pass");
	}

	@Test(priority=6)
	public void test_isPasswordFieldDisplayed() {

		LoginPage log = new LoginPage(driver);
		boolean passwordField=log.isPasswordFieldDisplayed();
		Assert.assertTrue(passwordField);
		ExtentTest test = extent.createTest("Assignment-WishUp Login Page Password Field Verification");
		test.info("test_ispasswordFielDisplayed");
		test.pass("test_ispasswordFielDisplayed : Pass");
		Reporter.log("test_ispasswordFielDisplayed : Pass");
	}

	@Test(priority=7)
	public void test_isLoginBtnEnabled() {

		LoginPage log = new LoginPage(driver);
		boolean loginButton=log.isLoginBtnEnabled();
		Assert.assertTrue(loginButton);
		ExtentTest test = extent.createTest("Assignment-WishUp Login Page Login-Button Verification");
		test.info("test_isLoginBtnEnabled");
		test.pass("test_isLoginBtnEnabled : Pass");
		Reporter.log("test_isLoginBtnEnabled : Pass");
	}

	@Test(priority=8)
	public void test_isForgotPwdLinkEnable() {

		LoginPage log = new LoginPage(driver);		
		boolean forgotPasswordLink=log.isForgotPwdLinkEnable();
		Assert.assertTrue(forgotPasswordLink);
		ExtentTest test = extent.createTest("Assignment-WishUp Login Page Forget_Your Password Link Verification");
		test.info("test_isForgotPwdLinkEnable");
		test.pass("test_isForgotPwdLinkEnable : Pass");
		Reporter.log("test_isForgotPwdLinkEnable : Pass");
	}

	@Test(priority=9)
	public void test_isSingnupBtnDisplayed() {

		LoginPage log = new LoginPage(driver);		
		boolean signupButton=log.isSignupBtnDisplayed();
		Assert.assertTrue(signupButton);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Signup-Button isDisplayed Verification");
		test.info("test_isSingnupBtnDisplayed");
		test.pass("test_isSingnupBtnDisplayed : Pass");
		Reporter.log("test_isSingnupBtnDisplayed : Pass");
	}

	@Test(priority=10)   
	public void test_isSingnupLinkDisplayed() {

		LoginPage log = new LoginPage(driver);
		boolean signupLink=log.isSignupLinkDisplayed();
		Assert.assertTrue(signupLink);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Signup isDisplayed Verification");
		test.info("test_isSingnupLinkDisplayed");
		test.pass("test_isSingnupLinkDisplayed : Pass");
		Reporter.log("test_isSingnupLinkDisplayed : Pass");
	}

	@Test(priority=11)
	public void test_isWishupLogoDisplayed() {

		LoginPage log=new LoginPage(driver);
		boolean wishupImage=log.isWishupLogoDisplayed();
		Assert.assertTrue(wishupImage);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page WISHUP-Logo isDisplayed Verification");
		test.info("test_isWishupLogoDisplayed");
		test.pass("test_isWishupLogoDisplayed : Pass");
		Reporter.log("test_isWishupLogoDisplayed : Pass");
	}

	@Test(priority=12)
	public void test_isLoginLinkDisplayed()	{

		LoginPage log = new LoginPage(driver);		
		boolean loginLink=log.isLoginLinkDisplayed();
		Assert.assertTrue(loginLink);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Login_Link_isDisplayed Verification");
		test.info("test_isLoginLinkDisplayed");
		test.pass("test_isLoginLinkDisplayed : Pass");
		Reporter.log("test_isLoginLinkDisplayed : Pass");
	}

	@Test(priority=13)
	public void test_isSignInWithGoogleEnabled() {

		LoginPage log = new LoginPage(driver);		
		boolean signInGoogleLink=log.isSignInwithGoogleEnabled();
		Assert.assertTrue(signInGoogleLink);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Sign_In_With_Google_Enabled Verification");
		test.info("test_isSignInWithGoogleEnabled");
		test.pass("test_isSignInWithGoogleEnabled : Pass");
		Reporter.log("test_isSignInWithGoogleEnabled : Pass");
	}

	@Test(priority=14)
	public void test_isEmailLabelDisplayed() {

		LoginPage log = new LoginPage(driver);		
		boolean emailLabel=log.isEmailLabelDisplayed();
		Assert.assertTrue(emailLabel);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Email Label Verification");
		test.info("test_isEmailLabelDisplayed");
		test.pass("test_isEmailLabelDisplayed : Pass");
		Reporter.log("test_isEmailLabelDisplayed : Pass");
	}

	@Test(priority=15)
	public void test_isPasswordLabelDisplayed()	{

		LoginPage log = new LoginPage(driver);		
		boolean passwordLabel=log.isPasswordLabelDisplayed();
		Assert.assertTrue(passwordLabel);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Password Label Verification");
		test.info("test_isPasswordLabelDisplayed");
		test.pass("test_isPasswordLabelDisplayed : Pass");
		Reporter.log("test_isPasswordLabelDisplayed : Pass");
	}

	@Test(priority=16)
	public void test_isLoginLabelDisplayed() {

		LoginPage log = new LoginPage(driver);		
		boolean LoginLabel=log.isLoginLabelisplayed();
		Assert.assertTrue(LoginLabel);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Login Label Verification");
		test.info("test_isLoginLabelDisplayed");
		test.pass("test_isLoginLabelDisplayed : Pass");
		Reporter.log("test_isLoginLabelDisplayed : Pass");
	}

	@Test(priority=17)
	public void test_SignInWithGoogleLink() {

		LoginPage log = new LoginPage(driver);	
		log.clickOnSignInUsingGoogle();
		String expUrl="https://accounts.google.com/o/oauth2/v2/auth/identifier?response_type=code&redirect_uri=https%3A%2F%2Fapp-dev.wishup.co%2Fauth%2Fgoogle%2Fcallback&scope=email%20profile&client_id=584359031459-ev6395v28rja7rg9s501jmi9ln70c1o9.apps.googleusercontent.com&flowName=GeneralOAuthFlow";
		Assert.assertEquals(driver.getCurrentUrl(),expUrl);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Redirect to Sign_In_With_Google Verification");
		test.info("test_SignInWithGoogleLink");
		test.pass("test_SignInWithGoogleLink : Pass");
		Reporter.log("test_SignInWithGoogleLink : Pass");
	}

	@Test(priority=18)
	public void test_ForgotPasswordLink() {

		LoginPage log = new LoginPage(driver);		
		log.forgotPwdLink();
		String forgotPasswordUrl="https://app-dev.wishup.co/forgot";
		Assert.assertEquals(driver.getCurrentUrl(),forgotPasswordUrl);
		ExtentTest test = extent.createTest("Assignment-Wishup Login Page Redirect to Forget Password Verification");
		test.info("test_ForgotPasswordLink");
		test.pass("test_ForgotPasswordLink : Pass");
		Reporter.log("test_ForgotPasswordLink : Pass");
	}


	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@AfterTest
	public void teardown() {
		extent.flush();
	}
}


