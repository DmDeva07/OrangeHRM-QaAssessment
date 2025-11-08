package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * ExtentManager - follows Singleton Pattern (only one Extent Report object is created and reused throughout your test execution)
 * extent - static variable & it belongs to the class, not to any specific object
 * static - share one single ExtentReports object across all the test classes. so the whole project logs to the same report file.
 * ExtentReports getInstance - ExtentReports is method type & getInstance is method name.
 * ExtentSparkReporter - for creating the HTML file and applying the theme, title and name.
 * Theme: visual appearance of the report.(STANDARD = light theme, DARK = dark mode)
 * Document Title: The browser tab title.
 * Report Name: The main header title displayed inside the report.
 * 
 * extent = new ExtentReports() -  create a new ExtentReports object.
 * extent.attachReporter(reporter) - Then attach the ExtentSparkReporter to it.
 */
public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
            reporter.config().setTheme(Theme.STANDARD);
            reporter.config().setDocumentTitle("Automation Execution Report");
            reporter.config().setReportName("Student Onboarding - Selenium Java");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}