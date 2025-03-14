package com.example.demopersism;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.util.StopWatch;


public class ExecutionTimeTestExecutionListener extends AbstractTestExecutionListener {

    private StopWatch stopWatch;

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        super.beforeTestClass(testContext);
        stopWatch = new StopWatch(testContext.getTestClass().getSimpleName());
        System.out.println("Running test '" + testContext.getTestClass().getSimpleName() + "'...");
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        super.beforeTestMethod(testContext);
        stopWatch.start(testContext.getTestMethod().getName());
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        if (stopWatch.isRunning()) {
            stopWatch.stop();
        }
        super.afterTestMethod(testContext);
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        System.out.println(stopWatch.prettyPrint());
        System.out.println("Test '" + testContext.getTestClass().getSimpleName() + "' finished after " + stopWatch.getTotalTimeSeconds() + " seconds.");
        super.afterTestClass(testContext);
    }
}