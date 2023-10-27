package utils;

import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Label;
import tests.TestBase;

import java.time.LocalDate;
import java.time.LocalTime;

import static io.qameta.allure.Allure.*;

public class AllureRename {

    public static AllureLifecycle lifecycle;

    public static void renameTestCase(String epicName, String featureName, String suiteName, String testCaseName) {

        // Get the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);
        // Get the current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        // Get the current AllureLifecycle in order to be able to change the TestCase Epic & Feature names
        lifecycle = getLifecycle();

        /*Modify the TestCase Name* to include (concatenate) the Platform (Android or iOS) & the current time*/
        lifecycle.updateTestCase(testResult -> testResult.setName(testCaseName + " on " + TestBase.platform + "_" + currentTime));
        System.out.println("Changing test case name");

      /*The Epic & Feature label are used to put some categorization to the executed test cases which appears
      in teh Allure lower part of the main screen ()*/
        //Modify the Epic Name
        final Label epicLabel = new Label().setName("epic").setValue(epicName);
        lifecycle.updateTestCase(testResult -> testResult.getLabels().add(epicLabel));
        System.out.println("Changing Epic name");

        //Modify the Feature Name
        final Label featureLabel = new Label().setName("feature").setValue(featureName);
        lifecycle.updateTestCase(testResult -> testResult.getLabels().add(featureLabel));
        System.out.println("Changing Feature name");

        /*Add a Suite Name, This one adds a new suite(rather than the default one) but doesn't replace the default one (doesn't rename)
         * Taking into consideration that , the default "Suite Name" is the one retrieved from the TestNG.xml file
         * Which means that the xml file may have only one suite but in the same time we can add as many as we want suits
         * (of course with a number of suites can be by max equal to the number of @Test "methods")*/
        final Label suiteLabel = new Label().setName("suite").setValue(suiteName);
        lifecycle.updateTestCase(testResult -> testResult.getLabels().add(suiteLabel));
        System.out.println("Changing Suite name");

        //This line will add the provided text in the "Test body" section inside the TC entry in allure report
        step("Add new Task for Platform: " + TestBase.platform);
        //This line will add the provided text in the "Test Description" section inside the TC entry in allure reportAllure.suite("Test Suite");
        description("Add new Task for Platform: " + TestBase.platform);

    }
}
