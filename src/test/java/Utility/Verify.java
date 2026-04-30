package Utility;

import org.testng.asserts.SoftAssert;

public class Verify {

	public static SoftAssert softAssert;

	public static void restAssertion() {

		softAssert = new SoftAssert();
	}

	public static void assertAll() {

		softAssert.assertAll();
	}

	// Method to verify equality
	public static void verifyEquals(String actual, String expected) {
		if (actual.equals(expected)) {
			System.out.println(" Passed");
		} else {
			System.out.println(" Failed");
			System.out.println("Actual: " + actual);
			System.out.println("Expected: " + expected);
		}

		softAssert.assertEquals(actual, expected);
	}

	// Method to verify true condition

	public static void verifyTrue(boolean condition) {
		if (condition) {
			System.out.println("Condition is True - Passed");
		} else {
			System.out.println("Condition is False - Failed");
		}

		softAssert.assertTrue(condition);
	}

}// Verify