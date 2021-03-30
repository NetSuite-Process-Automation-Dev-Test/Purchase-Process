package com.qa.purchaseProcess.stepDefinition;

import java.util.Map;

import com.aventstack.extentreports.ExtentTest;
import com.qa.purchaseProcess.pages.AuthenticationPage;
import com.qa.purchaseProcess.pages.HomePage;
import com.qa.purchaseProcess.pages.LoginPage;
import com.qa.purchaseProcess.util.ExcelDataToDataTable;
import com.qa.purchaseProcess.util.TestBase;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;

public class purchaseProcessStepDef extends TestBase{
	
	LoginPage loginPage;
	AuthenticationPage authPage;
	HomePage homePage;
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	@Then("^Verification of Make Copy functionality in Purchase order using excel data at \"([^\"]*)\"$")
	public void verification_of_Make_Copy_functionality_in_Purchase_order(@Transform(ExcelDataToDataTable.class) DataTable poData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Make Copy functionality in Purchase order");
			loginfo = test.createNode("Login Test");
			// User login to Netsuite with Tvarana Dev Test role
			TestBase.init();
			loginPage = new LoginPage();
			authPage = loginPage.login();
			homePage = authPage.Authentication();
			homePage.changeRole(prop.getProperty("roleText"), prop.getProperty("roleType"));
			loginfo.pass("Login Successful in Netsuite");
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Login Test");
		}

		ExtentTest loginfo2 = null;
		try {
			for(Map<String,String> data: poData.asMaps(String.class, String.class)) {
				String item = data.get("Item");
				String quantity = data.get("Quantity");
				String amount = data.get("Amount");
				loginfo2 = test.createNode("Verify copying an item: '"+item+"' in Purchase order using Make Copy");
				homePage.clickOnNewPOLink();
				homePage.verifyMakeCopyFunctionality(item, quantity, amount, loginfo2);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo2, e, "Verification of Make Copy functionality in Purchase order");
		}
	}

	@Then("^Verification of Copy Previous functionality in Purchase order using excel data at \"([^\"]*)\"$")
	public void verification_of_Copy_Previous_functionality_in_Purchase_order(@Transform(ExcelDataToDataTable.class) DataTable poData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Copy Previous functionality in Purchase order");
			for(Map<String,String> data: poData.asMaps(String.class, String.class)) {
				String item = data.get("Item");
				String quantity = data.get("Quantity");
				String amount = data.get("Amount");
				loginfo = test.createNode("Verify copying an item: '"+item+"' in Purchase order using Copy Previous");
				homePage.clickOnNewPOLink();
				homePage.verifyCopyPreviousFunctionality(item, quantity, amount, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Copy Previous functionality in Purchase order");
		}
	}

	@Then("^Verification of Insert functionality in Purchase order using excel data at \"([^\"]*)\"$")
	public void verification_of_Insert_functionality_in_Purchase_order(@Transform(ExcelDataToDataTable.class) DataTable poData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Insert functionality in Purchase order");
			for(Map<String,String> data: poData.asMaps(String.class, String.class)) {
				String item = data.get("Item");
				String quantity = data.get("Quantity");
				String amount = data.get("Amount");
				loginfo = test.createNode("Verify inserting an item: '"+item+"' in Purchase order using Insert");
				homePage.clickOnNewPOLink();
				homePage.verifyInsertFunctionality(item, quantity, amount, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Insert functionality in Purchase order");
		}
	}

	@Then("^Verification of Remove functionality in Purchase order using excel data at \"([^\"]*)\"$")
	public void verification_of_Remove_functionality_in_Purchase_order(@Transform(ExcelDataToDataTable.class) DataTable poData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Remove functionality in Purchase order");
			for(Map<String,String> data: poData.asMaps(String.class, String.class)) {
				String item = data.get("Item");
				String quantity = data.get("Quantity");
				String amount = data.get("Amount");
				loginfo = test.createNode("Verify removing an item: '"+item+"' in Purchase order using Remove");
				homePage.clickOnNewPOLink();
				homePage.verifyRemoveFunctionality(item, quantity, amount, loginfo);
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Remove functionality in Purchase order");
		}
	}
	
	@Then("^Verification of Custom form changes in the Purchase order using excel data at \"([^\"]*)\"$")
	public void verification_of_Custom_form_changes_in_Purchase_order(@Transform(ExcelDataToDataTable.class) DataTable poData) 
			throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Custom form changes in Purchase order");
			loginfo = test.createNode("Test Data >> Class: Mandatory, Department: Don't display, Doc: Disable");
			homePage.verifyCustomFormChanges("Custom Purchase Order", poData, loginfo);
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Custom form changes in Purchase order");
		}
	}
	
	@Then("^Automate the Purchase process using excel data at \"([^\"]*)\"$")
	public void automate_the_PO_process_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable poData) throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			test = extent.createTest("Verification of Purchase Process in NetSuite");
			for(Map<String,String> data: poData.asMaps(String.class, String.class)) {
				String vendor = data.get("Vendor");
				String location = data.get("Location");
				String expenseCategory = data.get("Expense Category");
				String expenseAmount = data.get("Expense Amount");
				String item = data.get("Item");
				String quantity = data.get("Quantity");
				String amount = data.get("Amount");
				String terms = data.get("Terms");
				loginfo = test.createNode("Automating purchase process for the following data set: Vendor = "+vendor+", Location = "+location+", Item Name = "+item+" & Terms = "+terms);
				
				try {
					boolean poCreationFlag;
					// Purchase Order Creation
					homePage.clickOnNewPOLink();
					poCreationFlag = homePage.createNewPO(vendor, location, expenseCategory, expenseAmount, item, quantity, amount, terms, loginfo);
					
					if (poCreationFlag) {
						// Item Receipt generation
						homePage.generateIR(loginfo);
						
						// Vendor Bill generation
						homePage.generateVendorBill(loginfo);
						
						// Bill Payment generation
						homePage.generateBillPayment(loginfo);
						
						// Vendor Return Authorization generation
						homePage.generateVendorReturnAuth(loginfo);
						
						// Item Fulfillment creation
						homePage.generateItemFulfillment(vendor, loginfo);
						
						// Bill credit generation
						homePage.generateBillCredit(loginfo);
					}
					
				} catch (Exception e) {
					System.out.println("Purchase Process failed");
					loginfo.fail("Purchase Process failed");
					loginfo.fail(e.getMessage());
				}
				
			}
		} catch (Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, "Verification of Purchase Process in NetSuite");
		}
	}
}
