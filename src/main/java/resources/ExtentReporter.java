package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

		static ExtentReports extent;
		
		public static ExtentReports getReportObject()
		{
			String path=System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter= new ExtentSparkReporter(path);
			reporter.config().setDocumentTitle("Report Results");
			reporter.config().setReportName("Web test results");
			
			extent=new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Arati");
			return extent;
		}


}
