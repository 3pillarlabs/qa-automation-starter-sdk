package com.tpg.quality.web.utility;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;
import org.testng.xml.XmlSuite;
//import com.codepine.api.testrail.TestRailException;
/**
 * 
 * @author satnam.malhotra
 *
 */
public class TestReports  implements IResultListener, IReporter {

	//	static Logger log = Logger.getLogger(TestReports.class);
	Boolean update_result = false;

	@Override
	public void onTestStart(ITestResult result) {
		//		log.info("Started execution of the test " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//		log.info("Successfully executed " + result.getMethod().getMethodName());
		//		log.info("=======================================================\n");
		//		if (update_result) {
		//			int[] Id = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestData.class).testId();
		//			for (int id : Id) {
		//				try {
		//					addTestResults(id, 1);
		//
		//				} catch (TestRailException ex) {
		//					log.info("Could not update the test result " + ex);
		//				}
		//			}
		//		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//		log.info(result.getMethod().getMethodName() + " test failed");
		//		log.info("=======================================================\n");
		//		if (update_result) {
		//			int[] Id = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestData.class).testId();
		//			for (int id : Id) {
		//				try {
		//					addTestResults(id, 5);
		//
		//				} catch (TestRailException ex) {
		//					log.info("Could not update the test result " + ex);
		//				}
		//			}
		//		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//		log.info("Skipped " + result.getMethod().getMethodName());
		//		log.info("=======================================================\n");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method will fetch the results from ITestContext and will print
	 * results in the console at the end of execution
	 * 
	 * @param xmlSuites
	 * @param suites
	 * @param outputDirectory
	 */
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			Set<String> keys = result.keySet();
			for (String key : keys) {
				ITestContext context = result.get(key).getTestContext();
				IResultMap resultMap = context.getPassedTests();
				Collection<ITestNGMethod> passedMethods = resultMap.getAllMethods();
				for (ITestNGMethod method : passedMethods) {
					System.out.println("<<<< PASSED TEST CASE >>>>");
					System.out.println("Suite Name -> " + context.getSuite().getName() + "\nDescription->"
							+ method.getDescription() + "\nPriority->" + method.getPriority() + "\nTestCase Name -> "
							+ method.getMethodName() + "\nStart Date Time -> " + context.getStartDate()
							+ "\nEnd Date Time -> " + context.getEndDate() + "\n");
				}

				IResultMap fresultMap = context.getFailedTests();
				Collection<ITestNGMethod> failedMethods = fresultMap.getAllMethods();
				for (ITestNGMethod method : failedMethods) {
					System.out.println("<<<< FAILEDs TEST CASE >>>>");
					System.out.println("Suite Name -> " + context.getSuite().getName() + "\nDescription->"
							+ method.getDescription() + "\nPriority->" + method.getPriority() + "\nTestCase Name -> "
							+ method.getMethodName() + "\nStart Date Time -> " + context.getStartDate()
							+ "\nEnd Date Time -> " + context.getEndDate() + "\n");
				}
			}
		}
	}
}
