package org.mytests.tests.testng;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.jdiai.tools.Safe;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.LinqUtils.last;
import static java.lang.System.currentTimeMillis;

public class TestNGListener implements IInvokedMethodListener {    private Safe<Long> start = new Safe<>(0L);

    @Override
    public void beforeInvocation(IInvokedMethod m, ITestResult tr) {
        if (m.isTestMethod()) {
            ITestNGMethod testMethod = m.getTestMethod();
            if (testMethod.getConstructorOrMethod().getMethod().isAnnotationPresent(Test.class)) {
                TEST_NAME.set( last(testMethod.getTestClass().getName().split("\\.")) +
                        "." + testMethod.getMethodName());
                start.set(currentTimeMillis());
                logger.step("== Test '%s' START ==", TEST_NAME.get());
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            logger.step("=== Test '%s' %s [%s] ===", TEST_NAME.get(), testResult.getName(),
                    new SimpleDateFormat("mm:ss.SS")
                            .format(new Date(currentTimeMillis() - start.get())));
            if (!testResult.isSuccess()) {
                try {
                    takeScreen();
                } catch (RuntimeException ignored) { }
                if (testResult.getThrowable() != null) {
                    logger.step("ERROR: " + testResult.getThrowable().getMessage());
                } else {
                    logger.step("UNKNOWN ERROR");
                }
            }
        }
    }
}