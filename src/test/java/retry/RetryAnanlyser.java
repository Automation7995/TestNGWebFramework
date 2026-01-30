package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnanlyser implements IRetryAnalyzer {

    private static int retryCount = 0;
    private static final int maxcount = 2;

    public boolean retry(ITestResult result) {
        if (retryCount < maxcount) {
            retryCount++;
            return true;
        }
        return false;
    }
}