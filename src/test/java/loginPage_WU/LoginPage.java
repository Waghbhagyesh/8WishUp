package loginPage_WU;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	// UserName Field
	@FindBy(id = "email")
	private WebElement userNameTxtField;

	// Password Field
	@FindBy(name = "password")
	private WebElement passwordTxtField;

	// LoginButton Field
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginBtn;

	// Error massage - Reset your password
	@FindBy(linkText = "reset your password")
	private WebElement resetyourPassoword;

	// Error massage - Please correct error in form
	@FindBy(xpath = "//div[text()='Please correct error in form']")
	private WebElement CorrectFormError;

	// Forgot your password Link
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	private WebElement forgotPassowordLink;

	// SignUpButton
	@FindBy(linkText = "Click here to signup")
	private WebElement signUpBtn;

	// SignUp Link
	@FindBy(linkText = "Signup")
	private WebElement signUpLink;

	// WishUp Logo
	@FindBy(xpath = "//img[@src='/images/logo_wishup.png']")
	private WebElement wishupLogo;

	// Login Link
	@FindBy(linkText = "Login")
	private WebElement loginlink;

	// SignIn With Google
	@FindBy(xpath = "//a[@id='google-btn']")
	private WebElement singnInWithGoogle;

	// Email Label
	@FindBy(xpath = "//label[text()='Email address']")
	private WebElement emailLabel;

	// Password Label
	@FindBy(xpath = "//label[text()='Password']")
	private WebElement passwordlabel;

	// login Label
	@FindBy(xpath = "//h1[text()='Login']")
	private WebElement loginlabel;

	// Click Here To SignUp
	@FindBy(css = ".ui.circular.basic.fluid.button")
	private WebElement newUserSignupText;

	//
	@FindBy(css = "div[class='right menu'] div[class='ui simple dropdown item']")
	private WebElement userProfileText;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Enter UserName
	public void enterUserName(String uName) {
		userNameTxtField.sendKeys(uName);
	}

	// Enter Password
	public void enterPassword(String pwd) {
		passwordTxtField.sendKeys(pwd);
	}

	// Click On Login Button
	public void clickLoginButton() {
		loginBtn.click();
	}

	// Click on Forgot Password Link
	public void forgotPwdLink() {
		forgotPassowordLink.click();
	}

	// Click On SignUp
	public void clickOnSignup() {
		signUpBtn.click();
	}

	// Validate valid login Creds with Username(Test)
	public String getUserProfileText() {
		String text = userProfileText.getText();
		return text;
	}

	// verify Username is displayed
	public boolean isUserNameFieldDisplayed() {
		return userNameTxtField.isDisplayed();
	}

	// verify Password is displayed
	public boolean isPasswordFieldDisplayed() {
		return passwordTxtField.isDisplayed();
	}

	// verify Login Button is Enable
	public boolean isLoginBtnEnabled() {
		return loginBtn.isEnabled();
	}

	// Validate invalid login Creds with error massage (reset your Password)
	public boolean isResetyourPassowordEnable() {
		return resetyourPassoword.isEnabled();
	}

	// Validate invalid login Creds with error massage (Correct In Form Error)
	public boolean isCorrectFormErrorDisplayed() {
		return CorrectFormError.isDisplayed();
	}

	// verify Forgot password Link is Enable
	public boolean isForgotPwdLinkEnable() {
		return forgotPassowordLink.isEnabled();
	}

	// verify SignUp Button is displayed
	public boolean isSignupBtnDisplayed() {
		return signUpBtn.isDisplayed();
	}

	// verify SignUp Link is displayed
	public boolean isSignupLinkDisplayed() {
		return signUpLink.isDisplayed();
	}

	// verify Wishup Logo is displayed
	public boolean isWishupLogoDisplayed() {
		return wishupLogo.isDisplayed();
	}

	// verify login link is displayed
	public boolean isLoginLinkDisplayed() {
		return loginlink.isDisplayed();
	}

	// SignIn With Google Enabled
	public boolean isSignInwithGoogleEnabled() {
		return singnInWithGoogle.isEnabled();
	}

	// verify Email label is displayed
	public boolean isEmailLabelDisplayed() {
		return emailLabel.isDisplayed();
	}

	// verify password label is displayed
	public boolean isPasswordLabelDisplayed() {
		return passwordlabel.isDisplayed();
	}

	// verify Login Label is displayed
	public boolean isLoginLabelisplayed() {
		return loginlabel.isDisplayed();
	}

	// verify New User Signup label is displayed
	public boolean isNewUserSignupLabelisDisplay() {
		return newUserSignupText.isDisplayed();
	}

	// Click on SignIn with Google
	public void clickOnSignInUsingGoogle() {
		singnInWithGoogle.click();
	}

	// Click on Signup Button
	public void clickOnSignUpBtn() {
		signUpBtn.click();
	}

	// Click on sign up link
	public void clickOnSignUpLink() {
		signUpLink.click();
	}
}
