package org.mytests.tests.example;

import org.mytests.tests.TestsInit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

class RetryTests implements TestsInit {
    int count = 0;
    @Test
    public void failedTest1() {
        System.out.println("Retry1: " + count);
        if (count++ % 2 == 0)
            assertTrue(false);
    }
    @Test
    public void failedTest2() {
        System.out.println("Retry2: " + count);
        assertTrue(false);
    }
}
