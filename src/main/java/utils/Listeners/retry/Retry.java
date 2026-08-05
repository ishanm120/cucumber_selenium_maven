package utils.Listeners.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.ConfigReader;

public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private final int maxTry = Integer.parseInt(ConfigReader.getConfigReader().getProperty("retryCount"));
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                return true;
            }
        }
        return false;
    }
}
