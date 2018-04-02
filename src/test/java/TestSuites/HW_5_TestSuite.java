package TestSuites;

import AutomationPracticeStore.LoginTest;
import AutomationPracticeStore.SearchTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTest.class, SearchTest.class})

public class BasicTestSuite {}
