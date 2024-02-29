package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.Status;


import base.TestBase;
import utilities.TestUtil;

import java.io.IOException;

import org.testng.ITestContext;

public class CustomListeners extends TestBase implements ITestListener {
	public void onFinish(ITestContext result) {
		System.out.println("The test finished");
	}

	public void onStart(ITestContext result) {
		System.out.println("The test Started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed But Within Success Percentage");
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false"); // to convert plain text of link to real
																				// link in reportng
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {

			e.printStackTrace();
		}

		
		  test.log(Status.FAIL, result.getName().toUpperCase() + "Failed with exception:" + result.getThrowable());
		  test.log(Status.FAIL, "Screenshot below:").addScreenCaptureFromPath(TestUtil.screenshotName);
		
		
		Reporter.log("click to see screenshot");
		Reporter.log("<a target=\"blank\" href=" + TestUtil.screenshotName + ">Screenshot</a>");
//target=\"blank\" this open screenshot image in another page

		Reporter.log("<br>");
		Reporter.log("<br>");
		// to print the image just below the link
		Reporter.log("<a target=\"blank\" href=\"+TestUtil.screenshotName+\"><img height=200 width=200 src=\"+TestUtil.screenshotName+\"  ></img></a>");

		 
		report.flush();

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The test is skipped");
	}

	public void onTestStart(ITestResult result) {
		 test = report.createTest(result.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName().toUpperCase() + "pass");
		

		report.flush();
	}

}
