package TestSuites;

import HW_5_AutomationPracticeStore.LoginTest;
import HW_5_AutomationPracticeStore.SearchTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTest.class, SearchTest.class})

public class HW_5_TestSuite {}
