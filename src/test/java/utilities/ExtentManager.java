package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			String reportFilePath = System.getProperty("user.dir") + "/test-output/html/extent.html";

			// Create an instance of ExtentSparkReporter
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);

			// Load configuration settings from XML file
			// loadSparkReporterConfig(sparkReporter,"src/test/resources/extentConfig/ReportConfig.xml"
			// Optional: Configure SparkReporter settings
			sparkReporter.config().setDocumentTitle("ExtentReports - Test Automation Report");
			sparkReporter.config().setReportName("Test Execution Report");
			sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);

			extent = new ExtentReports();

			// Attach the SparkReporter to the ExtentReports instance

			extent.attachReporter(new ExtentSparkReporter(reportFilePath));
		}
		return extent;
	}

}
