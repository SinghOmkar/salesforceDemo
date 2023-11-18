package com.qa.util;

public class Constants {
	public static String configFilePath = "/config.properties";
	public static String reportPath = "/reports/";
	public static String screenshotsPath = "/reports/screenshots/";
	public static String customReportTemplatePath = "HTMLtemplate.html";
//	public static String customReportTemplatePath = "htmlTemplatePDF.html";
	public static String reportTemplateTestList = "tbody[id=testResults]";
	public static String reportTemplatePassedTest = "td[id=passedTest]";
	public static String reportTemplateFailedTest = "td[id=failedTest]";
	public static String reportTemplateSkippedTest = "";
	public static String reportTemplateExecutionTime = "th[id=exeDuration]";
}
