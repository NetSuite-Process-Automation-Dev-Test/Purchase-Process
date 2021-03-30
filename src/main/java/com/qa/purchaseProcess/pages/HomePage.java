package com.qa.purchaseProcess.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qa.purchaseProcess.util.TestBase;

import cucumber.api.DataTable;

public class HomePage extends TestBase{
	
	String purchaseOrderNo;
	
	@FindBy(xpath = "//li[contains(@id,'ns-header-menu-userrole-item')]/a/span[@class='ns-role-menuitem-text']")
	List<WebElement> rolesList;
	
	@FindBy(xpath = "//div[@class='ns-role']/span[2]")
	WebElement role;
	
	@FindBy(xpath = "//span[text()='Transactions']")
	WebElement transactionsLink;
	
	@FindBy(xpath = "//span[text()='Purchases']")
	WebElement PurchasesLink;
	
	@FindBy(xpath = "//span[text()='Enter Purchase Orders']")
	WebElement enterPurchaseOrderLink;
	
	@FindBy(xpath = "//li[@data-title='Enter Purchase Orders']//span[text()='List']")
	WebElement enterPurchaseOrderListLink;
	
	@FindBy(xpath = "//input[@name='inpt_customform']")
	WebElement POform;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> dropdownList;
	
	@FindBy(xpath = "//input[@name='inpt_entity']")
	WebElement vendorDropdown;
	
	@FindBy(xpath = "//input[@name='inpt_approvalstatus']")
	WebElement approvalStatusDropdown;
	
	@FindBy(xpath = "//span[@id='location_fs']//input[@name='inpt_location']")
	WebElement locationDropdown;
	
	@FindBy(xpath = "//input[@name='inpt_category']")
	WebElement expenseCategoryDropdown;
	
	@FindBy(xpath = "//table[@id='expense_splits']//tr[contains(@class,'uir-machine-row-focused')]//td[count(//tr[@id='expense_headerrow']//div[text()='Amount']//parent::td//preceding-sibling::td)+1]")
	WebElement expenseAmountDiv;
	
	@FindBy(xpath = "//table[@id='expense_splits']//tr[contains(@class,'uir-machine-row-focused')]//td[count(//tr[@id='expense_headerrow']//div[text()='Account']//parent::td//preceding-sibling::td)+1]//div")
	WebElement expenseAccountDiv;
	
	@FindBy(xpath = "//table[@id='expense_splits']//input[@id='amount_formattedValue']")
	WebElement expenseAmountBox;
	
	@FindBy(xpath = "//input[@id='expense_addedit']")
	WebElement expenseAddBtn;
		
	@FindBy(xpath = "//a[@id='itemtxt']")
	WebElement itemSubtab;
	
	@FindBy(xpath = "//span[@id='parent_actionbuttons_item_item_fs']//a[2]")
	WebElement itemArrowBtn;
	
	@FindBy(xpath = "//div[@id='item_item_fs_tooltipMenu']//a[@id='item_popup_list']")
	WebElement itemListBtn;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//input[@id='st']")
	WebElement itemSearchBox;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//input[@id='Search']")
	WebElement itemSearchBtn;
	
	@FindBy(xpath = "//div[@id='popup_outerdiv']//div[@id='inner_popup_div']//table//tr//td//following-sibling::td//a")
	List<WebElement> itemList;
	
	@FindBy(xpath = "//input[@id='quantity_formattedValue']")
	WebElement itemQuantityBox;
	
	@FindBy(xpath = "//table[@id='item_splits']//tr[contains(@class,'uir-machine-row-focused')]//td[count(//tr[@id='item_headerrow']//div[text()='Amount']//parent::td//preceding-sibling::td)+1]")
	WebElement amountDiv;
	
	@FindBy(xpath = "//table[@id='item_splits']//input[@id='amount_formattedValue']")
	WebElement amountBox;
		
	@FindBy(xpath = "//input[@id='item_addedit']")
	WebElement itemAddBtn;
	
	@FindBy(xpath = "//a[text()='illing']")
	WebElement billingSubtab;
	
	@FindBy(xpath = "//input[@name='inpt_terms']")
	WebElement termsDropdown;
	
	@FindBy(xpath = "//input[@id='btn_multibutton_submitter']")
	WebElement primarySaveBtn;
		
	@FindBy(xpath = "//input[@id='btn_secondarymultibutton_submitter']")
	WebElement secondarySaveBtn;
	
	@FindBy(xpath = "//div[@class='descr']")
	WebElement confirmationMsg;
	
	@FindBy(xpath = "//div[@class='uir-record-id']")
	WebElement poNumber;
	
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement poVendor;
	
	@FindBy(xpath = "//input[@id='receive']")
	WebElement receiveBtn;
	
	@FindBy(xpath = "//input[contains(@id,'itemreceive')]//following-sibling::img")
	List<WebElement> receiveCheckboxList;
	
	@FindBy(xpath = "//div[@class='uir-record-id']")
	WebElement irNumber;
	
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement irVendorName;
	
	@FindBy(xpath = "//input[@id='bill']")
	WebElement billBtn;

	@FindBy(xpath = "//span[@id='transactionnumber_fs_lbl_uir_label']//following-sibling::span")
	WebElement billNumberField;
	
	@FindBy(xpath = "//input[@id='payment']")
	WebElement paymentBtn;
	
	@FindBy(xpath = "//div[@class='uir-record-id']")
	WebElement paymentNumber;
	
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement paymentVendor;
	
	@FindBy(xpath = "//a[@id='apply_displayval']")
	WebElement billLinkOnPayment;
	
	@FindBy(xpath = "//a[@id='rlrcdstabtxt']")
	WebElement relatedRecordsTab;
	
	@FindBy(xpath = "//a[@id='linkstxt']")
	WebElement billsTab;
	
	@FindBy(xpath = "//a[@id='purchaseorderstxt']")
	WebElement poSubTab;
	
	@FindBy(xpath = "//a[@id='purchaseorders_displayval']")
	WebElement poLink;
	
	@FindBy(xpath = "//input[@id='return']")
	WebElement authorizeReturnBtn;
	
	@FindBy(xpath = "//input[@name='inpt_orderstatus']")
	WebElement returnAuthApprovalStatusDropdown;
	
	@FindBy(xpath = "//div[@class='uir-record-id']")
	WebElement returnAuthNumber;
	
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement returnAuthVendor;
	
	@FindBy(xpath = "//div[@class='uir-record-status']")
	WebElement returnAuthStatus;
	
	@FindBy(xpath = "//input[@id='return']")
	WebElement fulfillBtn;
	
	@FindBy(xpath = "//a[@id='linkstxt']")
	WebElement fulfillSubTab;
	
	@FindBy(xpath = "//input[@id='secondaryrefund']")
	WebElement refundBtn;
	
	@FindBy(xpath = "//tr[contains(@id,'row')]//td[count(//table[@id='div__labtab']//div[contains(text(),'Document Number')]//parent::td//preceding-sibling::td)+1]")
	List<WebElement> poDocNoList;
	
	@FindBy(xpath = "//input[@id='item_copy']")
	WebElement makeCopyBtn;
	
	@FindBy(xpath = "//input[@id='item_insert']")
	WebElement insertBtn;
	
	@FindBy(xpath = "//input[@id='item_remove']")
	WebElement removeBtn;
	
	@FindBy(xpath = "//span[text()='Customization']")
	WebElement customizationLink;
	
	@FindBy(xpath = "//span[text()='Forms']")
	WebElement formsLink;
	
	@FindBy(xpath = "//span[text()='Transaction Forms']")
	WebElement transactionFormsLink;
	
	@FindBy(xpath = "//form//tr[contains(@id,'row')]//td[count(//form//table[@id='div__labtab']//div[contains(text(),'Name')]//parent::td//preceding-sibling::td)+1]")
	List<WebElement> customFormsList;
	
	@FindBy(xpath = "//span[@class='uir-pagination-label']")
	WebElement paginationLabel;
	
	@FindBy(xpath = "//span[@class='uir-pagination-label']//following-sibling::ul//li")
	List<WebElement> paginationList;
	
	@FindBy(xpath = "//a[@id='SCREENtxt']")
	WebElement screenFieldsTab;
	
	@FindBy(xpath = "//span[contains(@id,'mainflds_mainfldslabel')]//input[@value='Department']")
	WebElement mainLineDepartmentBox;
	
	@FindBy(xpath = "//span[contains(@id,'mainflds_mainfldslabel')]//input[@value='Class']")
	WebElement mainLineClassBox;
	
	@FindBy(xpath = "//span[contains(@id,'mainflds_mainfldslabel')]//input[@value='Doc']")
	WebElement mainLineDocBox;
	
	@FindBy(xpath = "//span[@id='class_fs']//input[@name='inpt_class']")
	WebElement classDropdown;
	
	@FindBy(xpath = "//span[@id='class_fs_lbl']//label[text()='*']")
	WebElement classRequiredLabel;
	
	@FindBy(xpath = "//span[@id='department_fs']//input[@name='inpt_department']")
	WebElement departmentDropdown;
	
	@FindBy(xpath = "//input[@name='inpt_custbody_cseg1']")
	WebElement docDropdown;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	public void verifyCustomFormChanges(String formName, DataTable formData, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		
		// Edit Custom Form & configure changes
		clickOnCustomTransactionFormsLink();
		editCustomForm(formName);
		screenFieldsTab.click();
		Thread.sleep(1500);
		
		// Configure Custom form
		for(Map<String,String> data: formData.asMaps(String.class, String.class)) {
			String fieldName = data.get("Field Name");
			String showFlag = data.get("Show Flag");
			String mandatoryFlag = data.get("Mandatory Flag");
			String displayType = data.get("Display Type");
			configureCustomFormForField(fieldName, showFlag, mandatoryFlag, displayType);
		}
		
		// Save the Custom form
		je.executeScript("window.scrollTo(0,0)");
		primarySaveBtn.click();
		if(isAlertPresent())
			driver.switchTo().alert().accept();
		
		// Open Custom form in Purchase order page & verify the fields
		clickOnNewPOLink();
		eleFocussed(vendorDropdown);
		eleClickable(driver, POform, 10);
		if (!POform.getAttribute("value").trim().equals(formName)) {
			POform.click();
			for (int i = 0; i < dropdownList.size(); i++) {
				String formValue = dropdownList.get(i).getText().trim();
				if (formValue.equals(formName)) {
					dropdownList.get(i).click();
					break;
				}
			}
		}
		eleFocussed(vendorDropdown);
		
		try {
			if(classDropdown.isDisplayed() && classRequiredLabel.isDisplayed()) {
				System.out.println("Custom form changes applied correctly. Class dropdown is displayed as mandatory field in the Form: '"+formName+"'");
				logInfo.pass("Custom form changes applied correctly. Class dropdown is displayed as mandatory field in the Form: '"+formName+"'");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Custom form changes not applied correctly. Class dropdown is not displayed in the Form: '"+formName+"'");
			logInfo.fail("Custom form changes not applied correctly. Class dropdown is not displayed in the Form: '"+formName+"'");
		}
		
		try {
			if(departmentDropdown.isDisplayed()) {
				System.out.println("Custom form changes not applied correctly. Department dropdown is displayed in the Form: '"+formName+"'");
				logInfo.fail("Custom form changes not applied correctly. Department dropdown is displayed in the Form: '"+formName+"'");
			}
		} catch (Exception e) {
			System.out.println("Custom form changes applied correctly. Department dropdown is not displayed in the Form: '"+formName+"'");
			logInfo.pass("Custom form changes applied correctly. Department dropdown is not displayed in the Form: '"+formName+"'");
		}
		
		if(docDropdown.isEnabled()) {
			System.out.println("Custom form changes not applied correctly. Doc dropdown is not disabled even if the field is disabled in the Form: '"+formName+"'");
			logInfo.fail("Custom form changes not applied correctly. Doc dropdown is not disabled even if the field is disabled in the Form: '"+formName+"'");
		}else {
			System.out.println("Custom form changes applied correctly. Doc dropdown is disabled when field is disabled for the Form: '"+formName+"'");
			logInfo.pass("Custom form changes applied correctly. Doc dropdown is disabled when field is disabled for the Form: '"+formName+"'");
		}
		
		// Enable all the fields again the custom form
		clickOnCustomTransactionFormsLink();
		editCustomForm(formName);
		screenFieldsTab.click();
		Thread.sleep(1500);
		for(Map<String,String> data: formData.asMaps(String.class, String.class)) {
			String fieldName = data.get("Field Name");
			WebElement fieldEle = driver.findElement(By.xpath("//span[contains(@id,'mainflds_mainfldslabel')]//input[@value='"+fieldName+"']"));
			enableOrDisableShowCheckbox(fieldEle, true);
			enableOrDisableMandatoryCheckbox(fieldEle, false);
			updateDisplayType(fieldEle, "Normal");
		}
		je.executeScript("window.scrollTo(0,0)");
		primarySaveBtn.click();
	}

	public void configureCustomFormForField(String fieldName, String showFlag, String mandatoryFlag,
			String displayType) {
		WebElement fieldEle = driver.findElement(By.xpath("//span[contains(@id,'mainflds_mainfldslabel')]//input[@value='"+fieldName+"']"));
		if(showFlag.equals("Yes"))
			enableOrDisableShowCheckbox(fieldEle, true);
		else
			enableOrDisableShowCheckbox(fieldEle, false);
		
		if(mandatoryFlag.equals("Yes"))
			enableOrDisableMandatoryCheckbox(fieldEle, true);
		else
			enableOrDisableMandatoryCheckbox(fieldEle, false);
		
		// Change Display type
		updateDisplayType(fieldEle, displayType);
	}

	public void updateDisplayType(WebElement fieldEle, String displayType) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action.moveToElement(fieldEle).build().perform();
		WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode.parentNode.parentNode;", fieldEle);
		String rowId = parentTr.getAttribute("id");
		WebElement displayDropdown = driver.findElement(By.xpath("//tr[@id='"+rowId+"']//td[count(//table[@id='mainflds_splits']//div[text()='Display Type']//parent::td//preceding-sibling::td)+1]//input[@type='text']"));
		if(!displayDropdown.getAttribute("value").equals(displayType))
			displayDropdown.sendKeys(displayType);
	}

	public void enableOrDisableMandatoryCheckbox(WebElement element, boolean checkboxFlag) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action.moveToElement(element).build().perform();
		WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode.parentNode.parentNode;", element);
		String rowId = parentTr.getAttribute("id");
		WebElement elementCheckbox = driver.findElement(By.xpath("//tr[@id='"+rowId+"']//td[count(//table[@id='mainflds_splits']//div[text()='Mandatory']//parent::td//preceding-sibling::td)+1]//img"));
		if(checkboxFlag)
			enableCheckbox(elementCheckbox);
		else
			disableCheckbox(elementCheckbox);
	}

	public void enableOrDisableShowCheckbox(WebElement element, boolean checkboxFlag) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action.moveToElement(element).build().perform();
		WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode.parentNode.parentNode;", element);
		String rowId = parentTr.getAttribute("id");
		WebElement elementCheckbox = driver.findElement(By.xpath("//tr[@id='"+rowId+"']//td[count(//table[@id='mainflds_splits']//div[text()='Show']//parent::td//preceding-sibling::td)+1]//img"));
		if(checkboxFlag)
			enableCheckbox(elementCheckbox);
		else
			disableCheckbox(elementCheckbox);
	}
	
	public void enableCheckbox(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action.moveToElement(element).build().perform();
		WebElement parentSpan = (WebElement)je.executeScript("return arguments[0].parentNode;", element);
		if(parentSpan.getAttribute("class").equals("checkbox_unck"))
			element.click();
	}
	
	public void disableCheckbox(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action.moveToElement(element).build().perform();
		WebElement parentSpan = (WebElement)je.executeScript("return arguments[0].parentNode;", element);
		if(!parentSpan.getAttribute("class").equals("checkbox_unck"))
			element.click();
	}
	
	public void editCustomForm(String formName) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		boolean formFlag = false;
		for(int i=0;i<customFormsList.size();i++) {
			WebElement currentForm = customFormsList.get(i);
			String text = currentForm.getText().trim();
			if(text.equals(formName)) {
				formFlag = true;
				action.moveToElement(currentForm).build().perform();
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", currentForm);
				String rowId = parentTr.getAttribute("id");
				driver.findElement(By.xpath("//form//table[@id='div__bodytab']//tr[@id='"+rowId+"']//a[text()='Edit']")).click();
				break;
			}
		}
		if(!formFlag) {
			for (int i = 1; i < paginationList.size(); i++) {
				boolean formFlag2 = false;
				action.moveToElement(paginationLabel).build().perform();
				eleAvailability(driver, paginationList.get(i), 10);
				paginationList.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < customFormsList.size(); j++) {
					WebElement currentForm = customFormsList.get(j);
					String text = currentForm.getText().trim();
					if(text.equals(formName)) {
						formFlag2 = true;
						action.moveToElement(currentForm).build().perform();
						WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", currentForm);
						String rowId = parentTr.getAttribute("id");
						driver.findElement(By.xpath("//form//table[@id='div__bodytab']//tr[@id='"+rowId+"']//a[text()='Edit']")).click();
						break;
					}
				}
				if(formFlag2)
					break;
			}
		}
	}
	
	public void verifyRemoveFunctionality(String item, String quantity, String amount, ExtentTest logInfo)
			throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		eleFocussed(vendorDropdown);
		eleClickable(driver, POform, 10);
		POform.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Standard Purchase Order")) {
				dropdownList.get(i).click();
				break;
			}
		}
		eleFocussed(vendorDropdown);
		
		// Select Vendor
		boolean vendorFlag = false;
		eleClickable(driver, vendorDropdown, 10);
		vendorDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Tax Agency CA")) {
				dropdownList.get(i).click();
				vendorFlag = true;
				break;
			}
		}
		if (vendorFlag) {
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(1500);
			eleClickable(driver, itemSubtab, 10);
			action.click(itemSubtab).build().perform();
			boolean itemFlag;
			itemFlag = addItems(item, quantity, amount, logInfo);
			if (itemFlag) {
				WebElement lineItem = driver.findElement(By.xpath("//table[@id='item_splits']//td[contains(text(),'"+item+"')]"));
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", lineItem);
				String rowId = parentTr.getAttribute("id");
				parentTr.click();
				Thread.sleep(2500);
				eleClickable(driver, removeBtn, 10);
				removeBtn.click();
				Thread.sleep(2500);
				try {
					WebElement lineItem2 = driver.findElement(By.xpath("//tr[@id='"+rowId+"']"));
					if(lineItem2.getText().contains(item)) {
						System.out.println("Item: '"+item+"' unable to remove");
						logInfo.fail("Item: '"+item+"' unable to remove");
					}else {
						System.out.println("Item: '"+item+"' removed from the Items tab using Remove feature");
						logInfo.fail("Item: '"+item+"' removed from the Items tab using Remove feature");
					}
				} catch (Exception e) {
					System.out.println("Item: '"+item+"' removed from the Items tab using Remove feature");
					logInfo.pass("Item: '"+item+"' removed from the Items tab using Remove feature");
				}
			}
		}
	}
	
	public void verifyInsertFunctionality(String item, String quantity, String amount, ExtentTest logInfo)
			throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		eleFocussed(vendorDropdown);
		eleClickable(driver, POform, 10);
		POform.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Standard Purchase Order")) {
				dropdownList.get(i).click();
				break;
			}
		}
		eleFocussed(vendorDropdown);
		
		// Select Vendor
		boolean vendorFlag = false;
		eleClickable(driver, vendorDropdown, 10);
		vendorDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Tax Agency CA")) {
				dropdownList.get(i).click();
				vendorFlag = true;
				break;
			}
		}
		if (vendorFlag) {
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(1500);
			eleClickable(driver, itemSubtab, 10);
			action.click(itemSubtab).build().perform();
			boolean itemFlag;
			itemFlag = addItems("Inventory Item", "2", "100", logInfo);
			if (itemFlag) {
				WebElement lineItem = driver.findElement(By.xpath("//table[@id='item_splits']//td[contains(text(),'Inventory Item')]"));
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", lineItem);
				parentTr.click();
				Thread.sleep(2500);
				eleClickable(driver, insertBtn, 10);
				insertBtn.click();
				Thread.sleep(2500);
				boolean itemFlag2;
				itemFlag2 = addItems(item, quantity, amount, logInfo);
				if (itemFlag2) {
					WebElement lineItem2 = driver.findElement(By.xpath("//table[@id='item_splits']//td[contains(text(),'Inventory Item')]"));
					WebElement parentTr2 = (WebElement)je.executeScript("return arguments[0].parentNode;", lineItem2);
					String rowId = parentTr2.getAttribute("id");
					try {
						WebElement previousLineItem = driver.findElement(
								By.xpath("//tr[@id='" + rowId + "']//preceding-sibling::tr[contains(@id,'item_row')]"));
						String lineItemText = previousLineItem.getText().trim();
						if(lineItemText.contains(item) && lineItemText.contains(quantity) && lineItemText.contains(amount)) {
							System.out.println("Item: '" + item + "' inserted using Insert feature");
							logInfo.pass("Item: '" + item + "' inserted using Insert feature");
						} else {
							System.out.println("Item: '" + item + "' unable to insert");
							logInfo.fail("Item: '" + item + "' unable to insert");
						}
					} catch (Exception e) {
						System.out.println("Item: '" + item + "' unable to insert");
						logInfo.fail("Item: '" + item + "' unable to insert");
					}
				}
			}
		}
	}
	
	public void verifyCopyPreviousFunctionality(String item, String quantity, String amount, ExtentTest logInfo) 
			throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		eleFocussed(vendorDropdown);
		eleClickable(driver, POform, 10);
		POform.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Standard Purchase Order")) {
				dropdownList.get(i).click();
				break;
			}
		}
		eleFocussed(vendorDropdown);
		
		// Select Vendor
		boolean vendorFlag = false;
		eleClickable(driver, vendorDropdown, 10);
		vendorDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Tax Agency CA")) {
				dropdownList.get(i).click();
				vendorFlag = true;
				break;
			}
		}
		if (vendorFlag) {
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(1500);
			eleClickable(driver, itemSubtab, 10);
			action.click(itemSubtab).build().perform();
			boolean itemFlag;
			itemFlag = addItems(item, quantity, amount, logInfo);
			if (itemFlag) {
				WebElement lineItem = driver.findElement(By.xpath("//table[@id='item_splits']//td[contains(text(),'"+item+"')]"));
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", lineItem);
				String rowId = parentTr.getAttribute("id");
				eleClickable(driver, makeCopyBtn, 10);
				Thread.sleep(2500);
				makeCopyBtn.click();
				Thread.sleep(5000);
				makeCopyBtn.click();
				Thread.sleep(2500);
				itemAddBtn.click();
				try {
					WebElement nextLineItem = driver.findElement(By.xpath("//tr[@id='"+rowId+"']//following-sibling::tr[contains(@id,'item_row')]"));
					String lineItemText = nextLineItem.getText().trim();
					if(lineItemText.contains(item) && lineItemText.contains(quantity) && lineItemText.contains(amount)) {
						System.out.println("Item: '"+item+"' copied using Copy Previous feature");
						logInfo.pass("Item: '"+item+"' copied using Copy Previous feature");
					}else {
						System.out.println("Item: '"+item+"' unable to copy");
						logInfo.fail("Item: '"+item+"' unable to copy");
					}
				} catch (Exception e) {
					System.out.println("Item: '"+item+"' unable to copy");
					logInfo.fail("Item: '"+item+"' unable to copy");
				}
			}
		}
	}
	
	public void verifyMakeCopyFunctionality(String item, String quantity, String amount, ExtentTest logInfo) 
			throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		eleFocussed(vendorDropdown);
		eleClickable(driver, POform, 10);
		POform.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Standard Purchase Order")) {
				dropdownList.get(i).click();
				break;
			}
		}
		eleFocussed(vendorDropdown);
		
		// Select Vendor
		boolean vendorFlag = false;
		eleClickable(driver, vendorDropdown, 10);
		vendorDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Tax Agency CA")) {
				dropdownList.get(i).click();
				vendorFlag = true;
				break;
			}
		}
		if (vendorFlag) {
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			Thread.sleep(1500);
			eleClickable(driver, itemSubtab, 10);
			action.click(itemSubtab).build().perform();
			boolean itemFlag;
			itemFlag = addItems(item, quantity, amount, logInfo);
			if (itemFlag) {
				WebElement lineItem = driver.findElement(By.xpath("//table[@id='item_splits']//td[contains(text(),'"+item+"')]"));
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", lineItem);
				String rowId = parentTr.getAttribute("id");
				parentTr.click();
				Thread.sleep(2500);
				eleClickable(driver, makeCopyBtn, 10);
				makeCopyBtn.click();
				Thread.sleep(2500);
				eleClickable(driver, itemAddBtn, 10);
				itemAddBtn.click();
				action.moveToElement(driver.findElement(By.xpath("//tr[@id='item_headerrow']"))).build().perform();
				je.executeScript("window.scrollBy(-1000,0)");
				je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				try {
					WebElement nextLineItem = driver.findElement(By.xpath("//tr[@id='"+rowId+"']//following-sibling::tr[contains(@id,'item_row')]"));
					String lineItemText = nextLineItem.getText().trim();
					if(lineItemText.contains(item) && lineItemText.contains(quantity) && lineItemText.contains(amount)) {
						System.out.println("Item: '"+item+"' copied using Make Copy feature");
						logInfo.pass("Item: '"+item+"' copied using Make Copy feature");
					}else {
						System.out.println("Item: '"+item+"' unable to copy");
						logInfo.fail("Item: '"+item+"' unable to copy");
					}
				} catch (Exception e) {
					System.out.println("Item: '"+item+"' unable to copy");
					logInfo.fail("Item: '"+item+"' unable to copy");
				}
			}
		}
	}
	
	public void generateBillCredit(ExtentTest logInfo) throws InterruptedException {
		Thread.sleep(1500);
		eleClickable(driver, refundBtn, 10);
		refundBtn.click();
		Thread.sleep(1500);
		primarySaveBtn.click();
		
		eleAvailability(driver, confirmationMsg, 20);
	    String confirmationMessage = confirmationMsg.getText().trim();
	    String tranNo = returnAuthNumber.getText().trim();
	    String tranVendor = returnAuthVendor.getText().trim();
	    if(confirmationMessage.equals("Transaction successfully Saved")) {
	    	System.out.println("Bill Credit '"+tranNo+" "+tranVendor+"' created successfully");
	    	logInfo.pass("Bill Credit '"+tranNo+" "+tranVendor+"' created successfully");
	    }else {
	    	System.out.println("Bill credit unable to create");
	    	logInfo.fail("Bill credit unable to create");
	    }
	}
	
	public void generateItemFulfillment(String vendor, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		eleClickable(driver, fulfillBtn, 10);
		fulfillBtn.click();
		Thread.sleep(1500);
		
		for (int i = 0; i < receiveCheckboxList.size(); i++) {
			action.moveToElement(receiveCheckboxList.get(i)).click(receiveCheckboxList.get(i)).build().perform();
		}
		action.moveToElement(secondarySaveBtn).click(secondarySaveBtn).build().perform();
		eleAvailability(driver, confirmationMsg, 20);
		String confirmationMessage = confirmationMsg.getText().trim();
		if(confirmationMessage.equals("Transaction successfully Saved")) {
			eleClickable(driver, relatedRecordsTab, 10);
			je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		    action.moveToElement(relatedRecordsTab).click(relatedRecordsTab).build().perform();
		    WebElement loadingEle = driver.findElement(By.xpath("//table[@id='recmachcustrecordzab_revlink_transaction_splits']//td[contains(text(),'Loading')]"));
		    eleToBeInvisible(driver, loadingEle, 10);
		    action.moveToElement(fulfillSubTab).click(fulfillSubTab).build().perform();
	    	String ifNumberText = driver.findElement(By.xpath("//td[text()='Item Fulfillment']//following-sibling::td[1]")).getText().trim();
			System.out.println("Item Fulfillment '"+ifNumberText+" "+vendor+"' created successfully");
	    	logInfo.pass("Item Fulfillment '"+ifNumberText+" "+vendor+"' created successfully");
	    }else {
	    	System.out.println("Item Fulfillment unable to create");
	    	logInfo.fail("Item Fulfillment unable to create");
	    }
	}
	
	public void generateVendorReturnAuth(ExtentTest logInfo) throws InterruptedException {
		eleClickable(driver, authorizeReturnBtn, 10);
		authorizeReturnBtn.click();
		Thread.sleep(2000);
		
		// Change Approval status
		eleClickable(driver, returnAuthApprovalStatusDropdown, 10);
		returnAuthApprovalStatusDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Pending Return")) {
				dropdownList.get(i).click();
				break;
			}
		}
		primarySaveBtn.click();
		
		eleAvailability(driver, confirmationMsg, 20);
	    String confirmationMessage = confirmationMsg.getText().trim();
	    String returnAuthNumberText = returnAuthNumber.getText().trim();
	    String returnAuthVendorText = returnAuthVendor.getText().trim();
	    String returnAuthStatusText = returnAuthStatus.getText().trim();
	    if(confirmationMessage.equals("Transaction successfully Saved")) {
	    	System.out.println("Return Authorization '"+returnAuthNumberText+" "+returnAuthVendorText+"' created successfully with '"+returnAuthStatusText+"' status");
	    	logInfo.pass("Return Authorization '"+returnAuthNumberText+" "+returnAuthVendorText+"' created successfully with '"+returnAuthStatusText+"' status");
	    }else {
	    	System.out.println("Return Authorization unable to create");
	    	logInfo.fail("Return Authorization unable to create");
	    }
		
	}
	
	public void generateBillPayment(ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		eleClickable(driver, paymentBtn, 10);
		paymentBtn.click();
		
		WebElement element = driver.findElement(By.xpath("//input[@id='tranid']"));
		eleAttributeToBeNotEmpty(driver, element, 20, "value");
		primarySaveBtn.click();
		
		eleAvailability(driver, confirmationMsg, 20);
	    String confirmationMessage = confirmationMsg.getText().trim();
	    String paymentNumberText = paymentNumber.getText().trim();
	    String paymentVendorText = paymentVendor.getText().trim();
	    if(confirmationMessage.equals("Transaction successfully Saved")) {
	    	System.out.println("Payment '"+paymentNumberText+" "+paymentVendorText+"' created successfully");
	    	logInfo.pass("Payment '"+paymentNumberText+" "+paymentVendorText+"' created successfully");
	    }else {
	    	System.out.println("Payment unable to create");
	    	logInfo.fail("Payment unable to create");
	    }
	    
	    // Go to Purchase order record
	    action.moveToElement(billLinkOnPayment).click(billLinkOnPayment).build().perform();
	    eleClickable(driver, relatedRecordsTab, 10);
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	    action.moveToElement(relatedRecordsTab).click(relatedRecordsTab).build().perform();
	    WebElement loadingEle = driver.findElement(By.xpath("//table[@id='recmachcustrecordzab_revlink_transaction_splits']//td[contains(text(),'Loading')]"));
	    eleToBeInvisible(driver, loadingEle, 10);
	    action.moveToElement(poSubTab).click(poSubTab).build().perform();
		eleClickable(driver, poLink, 5);
	    action.moveToElement(poLink).click(poLink).build().perform();
	}
	
	public void generateVendorBill(ExtentTest logInfo) throws InterruptedException {
		eleClickable(driver, billBtn, 10);
		billBtn.click();
		Thread.sleep(1500);
		
		// Change Approval status
		eleClickable(driver, approvalStatusDropdown, 10);
		approvalStatusDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Approved")) {
				dropdownList.get(i).click();
				break;
			}
		}
		
		primarySaveBtn.click();
		
		try {
			eleAvailability(driver, confirmationMsg, 30);
			String confirmationMessage = confirmationMsg.getText().trim();
			if(confirmationMessage.equals("Transaction successfully Saved")) {
				String billNo = billNumberField.getText().trim();
				System.out.println("Vendor Bill '"+billNo+"' created successfully");
				logInfo.pass("Vendor Bill '"+billNo+"' created successfully");
			}else {
				System.out.println("Vendor Bill unable to create");
				logInfo.fail("Vendor Bill unable to create");
			}
		} catch (Exception e) {
			if(driver.getTitle().contains("Notice")) {
				Thread.sleep(1500);
				driver.findElement(By.xpath("//input[@id='goback']")).click();
				Thread.sleep(1500);
				openPurchaseOrder(purchaseOrderNo);
				Thread.sleep(1500);
				relatedRecordsTab.click();
				Thread.sleep(1500);
				billsTab.click();
				WebElement billLink = driver.findElement(By.xpath("//td[text()='Bill']//preceding-sibling::td//a"));
				eleClickable(driver, billLink, 10);
				billLink.click();
				String billNo = billNumberField.getText().trim();
				System.out.println("Vendor Bill '"+billNo+"' created successfully");
				logInfo.pass("Vendor Bill '"+billNo+"' created successfully");
			}
		}
	}
	
	public void openPurchaseOrder(String purchaseOrderNo2) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		eleAvailability(driver, transactionsLink, 5);
		action.moveToElement(transactionsLink).build().perform();
		eleAvailability(driver, PurchasesLink, 5);
		action.moveToElement(PurchasesLink).build().perform();
		eleAvailability(driver, enterPurchaseOrderLink, 5);
		action.moveToElement(enterPurchaseOrderLink).build().perform();
		eleAvailability(driver, enterPurchaseOrderListLink, 5);
		enterPurchaseOrderListLink.click();
		
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
		
		for(int i=0;i<poDocNoList.size();i++) {
			WebElement currentPO = poDocNoList.get(i);
			String text = currentPO.getText();
			if(text.equals(purchaseOrderNo2)) {
				action.moveToElement(currentPO).build().perform();
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", currentPO);
				String rowId = parentTr.getAttribute("id");
				if(rowId.isBlank()) {
					WebElement poRow = (WebElement)je.executeScript("return arguments[0].parentNode;", parentTr);
					rowId = poRow.getAttribute("id");
				}
				driver.findElement(By.xpath("//table[@id='div__bodytab']//tr[@id='"+rowId+"']//a[text()='View']")).click();
				break;
			}
		}
	}

	public void generateIR(ExtentTest logInfo) throws InterruptedException {
		eleClickable(driver, receiveBtn, 10);
		receiveBtn.click();
		Thread.sleep(1500);
		for (int i = 0; i < receiveCheckboxList.size(); i++) {
			action.moveToElement(receiveCheckboxList.get(i)).click(receiveCheckboxList.get(i)).build().perform();
		}
		action.moveToElement(secondarySaveBtn).click(secondarySaveBtn).build().perform();
		eleAvailability(driver, confirmationMsg, 20);
		String confirmationMessage = confirmationMsg.getText().trim();
		String irNumberText = irNumber.getText().trim();
	    String irVendorText = irVendorName.getText().trim();
	    if(confirmationMessage.equals("Transaction successfully Saved")) {
	    	System.out.println("Item Receipt '"+irNumberText+" "+irVendorText+"' created successfully");
	    	logInfo.pass("Item Receipt '"+irNumberText+" "+irVendorText+"' created successfully");
	    }else {
	    	System.out.println("Item Receipt unable to create");
	    	logInfo.fail("Item Receipt unable to create");
	    }
	    
	    WebElement poLinkOnIR = driver.findElement(By.xpath("//span[@id='createdfrom_lbl_uir_label']//following-sibling::span//a"));
	    poLinkOnIR.click();
	    
	}
	
	public boolean createNewPO(String vendorData, String locationData, String expenseCategory, String expenseAmount, String itemData, String quantity, String amount, String terms, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		boolean poCreationFlag = false;
		// Change the Form to "Standard Purchase Order"
		eleFocussed(vendorDropdown);
		eleClickable(driver, POform, 10);
		POform.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals("Standard Purchase Order")) {
				dropdownList.get(i).click();
				break;
			}
		}
		eleFocussed(vendorDropdown);
		
		// Select Vendor
		boolean vendorFlag = false;
		eleClickable(driver, vendorDropdown, 10);
		vendorDropdown.click();
		for(int i=0;i<dropdownList.size();i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if(formValue.equals(vendorData)) {
				dropdownList.get(i).click();
				vendorFlag = true;
				break;
			}
		}
		
		if (vendorFlag) {
			// Select Approval status
			eleClickable(driver, approvalStatusDropdown, 10);
			approvalStatusDropdown.click();
			for (int i = 0; i < dropdownList.size(); i++) {
				String formValue = dropdownList.get(i).getText().trim();
				if (formValue.equals("Approved")) {
					dropdownList.get(i).click();
					break;
				}
			}
			// Select the location
			boolean locationFlag = false;
			eleClickable(driver, locationDropdown, 10);
			locationDropdown.click();
			for (int i = 0; i < dropdownList.size(); i++) {
				String formValue = dropdownList.get(i).getText().trim();
				if (formValue.equals(locationData)) {
					dropdownList.get(i).click();
					locationFlag = true;
					break;
				}
			}
			if (locationFlag) {
				// Add expenses
				boolean expenseFlag;
				expenseFlag = addExpense(expenseCategory, expenseAmount, logInfo);
				
				if (expenseFlag) {
					// Select line item, quantity & rate
					je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
					Thread.sleep(1500);
					eleClickable(driver, itemSubtab, 10);
					action.click(itemSubtab).build().perform();
					boolean itemFlag = false;
					if (itemData.contains(",")) {
						int count = 0;
						String[] itemsList = itemData.split(",");
						String[] quantityList = quantity.split(",");
						String[] amountList = amount.split(",");
						for (int i = 0; i < itemsList.length; i++) {
							boolean itemFlag2 = false;
							itemFlag2 = addItems(itemsList[i], quantityList[i], amountList[i], logInfo);
							if (itemFlag2)
								count++;
						}
						if (count == itemsList.length)
							itemFlag = true;
					} else {
						itemFlag = addItems(itemData, quantity, amount, logInfo);
					}
					if (itemFlag) {
						// Select terms
						billingSubtab.click();
						boolean termsFlag = false;
						eleClickable(driver, termsDropdown, 10);
						termsDropdown.click();
						for (int i = 0; i < dropdownList.size(); i++) {
							String formValue = dropdownList.get(i).getText().trim();
							if (formValue.equals(terms)) {
								dropdownList.get(i).click();
								termsFlag = true;
								break;
							}
						}
						if (!termsFlag) {
							System.out.println("PO unable to create. Terms: " + terms
									+ " not available in the Terms list & unable to select");
							logInfo.fail("PO unable to create. Terms: " + terms
									+ " not available in the Terms list & unable to select");
						}
						// Save the PO
						if (vendorFlag && locationFlag && itemFlag && termsFlag) {
							action.moveToElement(secondarySaveBtn).click(secondarySaveBtn).build().perform();
							eleAvailability(driver, By.xpath("//div[@class='descr']"), 20);
							String confirmationMessage = confirmationMsg.getText().trim();
							String poNumberText = poNumber.getText().trim();
							purchaseOrderNo = poNumberText;
							String poVendorText = poVendor.getText().trim();
							if (confirmationMessage.equals("Transaction successfully Saved")) {
								poCreationFlag = true;
								System.out.println("Purchase Order '" + poNumberText + " " + poVendorText
										+ "' created successfully");
								logInfo.pass("Purchase Order '" + poNumberText + " " + poVendorText
										+ "' created successfully");
							} else {
								System.out.println("PO not created");
								logInfo.fail("Purchase Order not created");
							}
						}
					} 
				}
			}else {
				System.out.println("PO unable to create. Location: " + locationData
						+ " not available in the Location list & unable to select");
				logInfo.fail("PO unable to create. Location: " + locationData
						+ " not available in the Location list & unable to select");
			}
		}else {
			System.out.println("PO unable to create. Vendor: "+vendorData+" not available in the Vendor list & unable to select");
			logInfo.fail("PO unable to create. Vendor: "+vendorData+" not available in the Vendor list & unable to select");
		}
		
		return poCreationFlag;
		
	}
	
	private boolean addExpense(String expenseCategory, String expenseAmount, ExtentTest logInfo) throws InterruptedException {
		boolean expenseFlag = true;
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		boolean categoryFlag = false;
		eleClickable(driver, expenseCategoryDropdown, 10);
		expenseCategoryDropdown.click();
		for (int i = 0; i < dropdownList.size(); i++) {
			String formValue = dropdownList.get(i).getText().trim();
			if (formValue.equals(expenseCategory.trim())) {
				dropdownList.get(i).click();
				categoryFlag = true;
				break;
			}
		}
		if(categoryFlag) {
			Thread.sleep(1500);
			eleClickable(driver, expenseAmountDiv, 10);
			je.executeScript("arguments[0].click();", expenseAmountDiv);
			action.click(expenseAmountBox).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
			.sendKeys(Keys.BACK_SPACE).sendKeys(expenseAmountBox, expenseAmount).build().perform();
			expenseAddBtn.click();
			if(isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				if(alertMsg.contains("Invalid currency value")) {
					expenseFlag = false;
					System.out.println("PO unable to create. Expense Amount: '"+expenseAmount+"' is invalid");
					logInfo.fail("PO unable to create. Expense Amount: '"+expenseAmount+"' is invalid");
				}
				alert.accept();
			}
		}else {
			expenseFlag = false;
			expenseCategoryDropdown.click();
			System.out.println("PO unable to create. Expense Category: "+expenseCategory+" not available in the list & unable to select");
			logInfo.fail("PO unable to create. Expense Category: "+expenseCategory+" not available in the list & unable to select");
		}
		
		if(!expenseFlag) {
			driver.findElement(By.xpath("//input[@id='expense_clear']")).click();
		}
		
		return expenseFlag;
	}

	public boolean addItems(String itemData, String quantity, String amount, ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		boolean itemFlag = false;
		itemArrowBtn.click();
		itemListBtn.click();
		eleClickable(driver, itemSearchBox, 10);
		itemSearchBox.sendKeys(itemData);
		itemSearchBtn.click();
		Thread.sleep(3000);
		for(int j=0;j<itemList.size();j++) {
			String parentCustomer = itemList.get(j).getText().trim();
			if(parentCustomer.equals(itemData)) {
				itemFlag = true;
				itemList.get(j).click();
				break;
			}
		}
		if (itemFlag) {
			Thread.sleep(2000);
			boolean quantityFlag = true;
			action.click(itemQuantityBox).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(itemQuantityBox, quantity).build().perform();
			eleClickable(driver, amountDiv, 10);
			je.executeScript("arguments[0].click();", amountDiv);
			if(isAlertPresent()) {
				Thread.sleep(1000);
				Alert alert = driver.switchTo().alert();
				String alertMsg = alert.getText();
				if (alertMsg.contains("Inventory items must have a positive quantity.") || alertMsg.contains("Invalid number")) {
					itemFlag = false;
					quantityFlag = false;
					System.out.println("Quantity is invalid for the Item: '"+itemData+"' & unable to create PO. Alert occured: " + alertMsg);
					logInfo.fail("Quantity is invalid for the Item: '"+itemData+"' & unable to create PO. Alert occured: " + alertMsg);
				}
				alert.accept();
			}
			if (quantityFlag) {
				action.click(amountBox).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
						.sendKeys(Keys.BACK_SPACE).sendKeys(amountBox, amount).build().perform();
				itemAddBtn.click();
				int count = 0;
				while(isAlertPresent()) {
					Thread.sleep(1000);
					Alert alert = driver.switchTo().alert();
					String alertMsg = alert.getText();
					if (alertMsg.contains(
							"The line total amount is not equal to the item price times the quantity.  Is this correct?")) {
						System.out.println("Alert occured: " + alertMsg);
					} else if (alertMsg.contains("Inventory items must have a positive amount.")
							|| alertMsg.contains("Invalid currency value")) {
						count++;
						itemFlag = false;
						if (count == 1) {
							System.out.println("Amount is invalid for the Item: '"+itemData+"' & PO unable to create. Alert occured: " + alertMsg);
							logInfo.fail("Amount is invalid for the Item: '"+itemData+"' & PO unable to create. Alert occured: " + alertMsg);
						}
					}
					alert.accept();
				}
			}
		}else {
			System.out.println("PO unable to create. Item: "+itemData+" not available in the Item list & unable to select");
			logInfo.fail("PO unable to create. Item: "+itemData+" not available in the Item list & unable to select");
		}
		if(!itemFlag) {
			driver.findElement(By.xpath("//input[@id='item_clear']")).click();
		}
		return itemFlag;
	}
	
	public void clickOnCustomTransactionFormsLink() throws InterruptedException {
		Thread.sleep(2000);
		eleAvailability(driver, customizationLink, 10);
		action.moveToElement(customizationLink).build().perform();
		eleAvailability(driver, formsLink, 10);
		action.moveToElement(formsLink).build().perform();
		eleAvailability(driver, transactionFormsLink, 10);
		transactionFormsLink.click();
		
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}
	
	public void clickOnNewPOLink() throws InterruptedException {
		Thread.sleep(2000);
		eleAvailability(driver, transactionsLink, 10);
		action.moveToElement(transactionsLink).build().perform();
		eleAvailability(driver, PurchasesLink, 10);
		action.moveToElement(PurchasesLink).build().perform();
		eleAvailability(driver, enterPurchaseOrderLink, 10);
		enterPurchaseOrderLink.click();
		
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
		}
	}
	
	public void changeRole(String roleTextData, String roleTypeData) throws InterruptedException {
		String currentRole = role.getText().trim();
		if(currentRole.equals(roleTextData)) {
			System.out.println("Role already selected");
		} else {
			Thread.sleep(1000);
			action.moveToElement(driver.findElement(By.xpath("//div[@id='spn_cRR_d1']/a"))).build().perform();
			
			for(int i=0;i<rolesList.size();i++) {
				WebElement roleElement = rolesList.get(i);
				String roleValue = roleElement.getText().trim();
				if(roleValue.equals(roleTextData)) {
					if(roleTypeData.equals("Production")) {
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						WebElement liTagElement = (WebElement)executor.executeScript("return arguments[0].parentNode.parentNode;", roleElement);
						String id = liTagElement.getAttribute("id");
						try {
							WebElement roleType = driver.findElement(By.xpath("//li[@id='"+id+"']/a/span[@class='ns-role-accounttype']"));
							if(roleType.isDisplayed())
								continue;
						}
						catch(NoSuchElementException e) {
							driver.findElement(By.xpath("//li[@id='"+id+"']/a/span[@class='ns-role-menuitem-text']")).click();
							break;
						}
					}
				}
			}
		}
	}
}
