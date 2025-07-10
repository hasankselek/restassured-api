package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        log.info("=== START TEST: {} ===", testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        log.info("=== PASS TEST: {} ===", testName);
        log.info("");  // <-- Burada boş satır
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        log.info("=== FAIL TEST: {} ===", testName);
        log.info("");  // <-- Burada boş satır
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        log.info("=== SKIP TEST: {} ===", testName);
        log.info("");  // <-- Burada boş satır
    }

    // Diğer metodlar boş bırakılabilir
    @Override public void onStart(ITestContext context) { }
    @Override public void onFinish(ITestContext context) { }
}