package com.tpg.quality.web.utility;


import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTestManager {
	static Map<Integer,ExtentTest> extentTestMap = new HashMap<Integer,ExtentTest>();
	static ExtentReports extent = ExtentManager.getReporter();
	static ExtentTest classlogger;

	public static synchronized ExtentTest getTest() {
		return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
	}

	public static synchronized ExtentTest startClass(String classname, String desc) {
		classlogger = extent.startTest(classname, desc);

		extentTestMap.put((int) (long) (Thread.currentThread().getId()), classlogger);
		return classlogger;
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.startTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

		return test;
	}
}

