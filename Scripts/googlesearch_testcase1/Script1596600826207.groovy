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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

n = findTestData('search').getRowNumbers()

HashMap<String, String> dict = new HashMap<String, String>();


for (def i : (1..n)) {
		
		HashMap<String, String> value = new HashMap<String, String>();	
		
		value.put('search_case',findTestData('search').getValue('search_case', i))
		
		value.put('lucky',findTestData('search').getValue('lucky', i))
		
		key   = findTestData('search').getValue('tc_num', i)
				
		dict.put(key,value)
					
}


    WebUI.openBrowser('https://www.google.com/')

    WebUI.setText(findTestObject('Page_Google/input_ng nhp_q'), dict.get('tc1').get('search_case'))

    lucky =  dict.get('tc1').get('lucky')

    System.out.println(lucky)

    if (lucky == 0) {
        WebUI.click(findTestObject('Page_Google/search_button'))
    } else {
        WebUI.click(findTestObject('Page_Google/lucky_button'))
    }
    
    WebUI.delay(5)

    WebUI.closeBrowser()
