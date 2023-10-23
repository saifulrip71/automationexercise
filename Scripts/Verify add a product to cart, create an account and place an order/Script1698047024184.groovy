import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//String firstpartofemail = 'test'
//String lastpartofemail = '@test.com'
int emailnumber = 20

String email = ('test' + emailnumber.toString() + '@saiful.com')

WebUI.openBrowser('')

'Navigate to https://automationexercise.com/'
WebUI.navigateToUrl('https://automationexercise.com/')

WebUI.maximizeWindow()

'Verify that home page is visible successfull'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Automation Exercise/Home_button'), 'Home')

'hover over the product to see the overlay'
WebUI.mouseOver(findTestObject('Object Repository/Page_Automation Exercise/product rs500'), FailureHandling.STOP_ON_FAILURE)

'Keepin the product name in a variable for checkout page verification'
String product = WebUI.getText(findTestObject('Object Repository/Page_Automation Exercise/product_item_Blue Top'))

'Click Add to cart button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/Add to cart_button'))

'Click continue shopping button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/Continue Shopping_button'))

'Click cart button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/Cart_button'))

'Verify that cart page is displayed'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Automation Exercise - Checkout/Shopping Cart_header_text'), 
    'Shopping Cart')

'Click Proceed To Checkout'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Checkout/Proceed To Checkout_button'))

'Click Register / Login button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Checkout/Register_Login_button'))

'Enter Name'
WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/New User Signup_name_textfield'), 
    'Saiful test')

'Enter email'
WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/New User Signup_email_textbox'), 
    email)

'Click Signup button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/Signup_button'))

'Getting email already exist warning text to use in account exists logic bypassing'
String registeredwarning = WebUI.getText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/p_Email Address already exist'), 
    FailureHandling.OPTIONAL)

'This loop will change the email address if the account already exists in the system'
while (registeredwarning == 'Email Address already exist!') {
    emailnumber = (emailnumber + 1)

    email = (('test' + emailnumber.toString()) + '@saiful.com')

    WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/New User Signup_email_textbox'), 
        email)

    WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/Signup_button'))

    registeredwarning = WebUI.getText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/p_Email Address already exist'), 
        FailureHandling.OPTIONAL)
}

'Fill all details in Sign u'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup/gender_radio_box'))

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/address_textbox'), 'test address, qa 14211')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/password_textbox'), 'Test12345')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Automation Exercise - Signup/birth_day_dropdown'), '1', 
    true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Automation Exercise - Signup/birth_month_dropdown'), '1', 
    true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Automation Exercise - Signup/birthyear_dropdown'), '1940', 
    true)

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/first_name_textbox'), 'qa')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/last_name_textbox'), 'test')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Automation Exercise - Signup/country_dropdown'), 'United States', 
    true)

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/state_textbox'), 'test')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/city_textbox'), 'qa')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/zipcode_textbox'), '12111')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/mobile_number_textbox'), '1111111111111')

WebUI.scrollToElement(findTestObject('Object Repository/Page_Automation Exercise - Signup/button_Create Account'), 10)

'Click create account button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup/button_Create Account'))

'Verify ACCOUNT CREATED!'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Automation Exercise - Account Created/Account Created_textarea'), 
    'ACCOUNT CREATED!')

'Click Continue button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Account Created/Account created page Continue button'))

'Verify Logged in as username at top'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Automation Exercise/Logged in as text area'), 'Logged in as Saiful test')

'Click Cart button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/Cart_button'))

'Click Proceed To Checkout button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Checkout/Proceed To Checkout_button'))

'Verify address details'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Automation Exercise - Checkout/address_at_checkout'), 'test address, qa 14211')

'Review order item'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Automation Exercise - Checkout/Product at checkout_Blue Top'), 
    product)

WebUI.scrollToElement(findTestObject('Object Repository/Page_Automation Exercise - Checkout/textarea_comment'), 0)

'Enter description in comment text are'
WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Checkout/textarea_comment'), 'test')

'Click Place Order'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Checkout/Place Order_button'))

'Enter payment details: Name on Card, Card Number, CVC, Expiration date'
WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Payment/Name on Card_name_on_card_textbox'), 
    'qa test')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Payment/Card Number_card_number_textbox'), '5555555555554444')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Payment/CVC_textbox'), '456')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Payment/expiry_month_textbox'), '02')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Payment/Expiration_year_textbox'), '2029')

' Click Pay and Confirm Order button'
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Payment/button_Pay and Confirm Order'))

'Clicking browser back button for verifying the order placed message, since the page loads to the confirm order page'
WebUI.back()

' Verify the success message Your order has been placed successfully!'
WebUI.verifyTextPresent('Your order has been placed successfully!', false)

WebUI.closeBrowser()
