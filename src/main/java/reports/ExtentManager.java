package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReports.html");

            reporter.config().setReportName("Automation Report");
            reporter.config().setDocumentTitle("Automation Title");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

        }
        return extent;
    }

}