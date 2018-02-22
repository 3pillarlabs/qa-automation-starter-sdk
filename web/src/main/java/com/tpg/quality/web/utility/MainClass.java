package com.tpg.quality.web.utility;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import com.codepine.api.testrail.TestRail;
//import com.codepine.api.testrail.model.Result;
//import com.codepine.api.testrail.model.ResultField;
//import com.codepine.api.testrail.model.Run;

public class MainClass extends InitDriver {

//	protected static TestRail testrail;
//	Logger log = Logger.getLogger(MainClass.class);
//	protected static Run run;

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface TestData {
		public int[]testId() default { 0 };
	}

//	@BeforeSuite(alwaysRun = true)
//	public void testRailInit() throws IOException {
//		testrail = TestRail.builder("https://nischay.testrail.io/", "nischay.suri@3pillarglobal.com", "tpg@123").build();
//		log.info("Created object for TestRail");
//		run = addTestRun(1, 1, testRunName("Internal Project"));
//		log.info("Created TestRun");
//	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void testMethodStart(@Optional("chrome") String browser) throws InterruptedException, IOException {
		setupDriver(browser);
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() throws InterruptedException, IOException {
		quitDriver();
	}

//	// TestRail Method for adding test run
//	public Run addTestRun(int projectId, int suiteId, String testName) {
//		return testrail.runs().add(projectId, new Run().setSuiteId(suiteId).setName(testName)).execute();
//	}
//
//	// TestRail Method for adding test result
//	public void addTestResults(int id, int statusId) {
//		java.util.List<ResultField> customResultFields = testrail.resultFields().list().execute();
//		testrail.results().addForCase(run.getId(), id, new Result().setStatusId(statusId), customResultFields).execute();
//	}
//
//	// TestRail Method for closing run
//	public void closeRun(int runId) {
//		testrail.runs().close(runId).execute();
//	}
//	
	@Bean
	public String testRunName(String project_name){
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return project_name+" "+format.format(date);
	}
}
