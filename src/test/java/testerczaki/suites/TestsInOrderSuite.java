package testerczaki.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        // Path to Class is optional. 'PodstawyTest.class' works too
        testerczaki.tests.PodstawyTest.class,
        testerczaki.tests.WiecejElementowTest.class,
        testerczaki.tests.AsercjaTest.class,
        testerczaki.tests.LokalizatoryTest.class,
        testerczaki.tests.UkryteElementyTest.class,
        testerczaki.tests.OpcjonalnyFormularzTest.class,
        testerczaki.tests.RamkaTest.class,
        testerczaki.tests.WiecejRamekTest.class,
        testerczaki.tests.OknaZakladkiTest.class,
        testerczaki.tests.KomunikatyTest.class,
        testerczaki.tests.MenuTest.class,
        testerczaki.tests.PrzeciagnijUpuscTest.class,
        testerczaki.tests.KliknijPrzytrzymajTest.class,
        testerczaki.tests.NiestandardoweListyTest.class,
        testerczaki.tests.TabeleTest.class,
})
public class TestsInOrderSuite {
}
