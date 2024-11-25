package tools_qa.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({
        "tools_qa.elements_tests",
        "tools_qa.forms_tests",
        "tools_qa.alerts_frame_windows_tests",
        "tools_qa.widgets_tests",
        "tools_qa.interactions_tests"
})
@SelectClasses({
        tools_qa.book_store_application_tests.RegisterTest.class,
        tools_qa.book_store_application_tests.LoginTest.class
})
public class TestsInOrderSuite {
}

/*
NOTE:

I know that I could arrange all the tests in the order in which the menu is on the page,
but firstly I wanted to learn how to arrange both package and classes,
secondly if the tests are in a random order there is a greater chance of detecting some errors,
thirdly JUnit considers that using ordering of tests should be done as a last resort,
and it is not a recommended practice because each test should run independently.
*/
