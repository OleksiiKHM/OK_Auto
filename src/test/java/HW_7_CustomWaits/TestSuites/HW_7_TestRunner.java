package HW_7_CustomWaits.TestSuites;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class HW_7_TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(HW_7_TestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
