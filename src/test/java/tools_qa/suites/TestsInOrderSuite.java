package tools_qa.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import tools_qa.tests.book_store_application_tests.BookStoreTest;
import tools_qa.tests.book_store_application_tests.LoginTest;
import tools_qa.tests.book_store_application_tests.ProfileTest;
import tools_qa.tests.book_store_application_tests.RegisterTest;

@Suite
@SelectPackages({
        "tools_qa.tests.elements_tests",
        "tools_qa.tests.forms_tests",
        "tools_qa.tests.alerts_frame_windows_tests",
        "tools_qa.tests.widgets_tests",
        "tools_qa.tests.interactions_tests"
})
@SelectClasses({
        // Path to Class is optional. 'RegisterTest.class' works too
        tools_qa.tests.book_store_application_tests.RegisterTest.class,
        tools_qa.tests.book_store_application_tests.LoginTest.class,
        tools_qa.tests.book_store_application_tests.ProfileTest.class,
        tools_qa.tests.book_store_application_tests.BookStoreTest.class
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
