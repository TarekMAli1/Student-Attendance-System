/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author antoz
 */
public class EmailCheckerTest {
    
    public EmailCheckerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of verify_email method, of class EmailChecker.
     */
    @Test
    public void testVerify_email() {
        System.out.println("verify_email");
        String EMAIL = "";
        EmailChecker instance = new EmailChecker();
        boolean expResult = false;
        boolean result = instance.verify_email(EMAIL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verify_pass method, of class EmailChecker.
     */
    @Test
    public void testVerify_pass() {
        System.out.println("verify_pass");
        String pass = "";
        EmailChecker instance = new EmailChecker();
        boolean expResult = false;
        boolean result = instance.verify_pass(pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyLength method, of class EmailChecker.
     */
    @Test
    public void testVerifyLength() {
        System.out.println("verifyLength");
        String pass = "";
        boolean expResult = false;
        boolean result = EmailChecker.verifyLength(pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyUpperLowerDigit method, of class EmailChecker.
     */
    @Test
    public void testVerifyUpperLowerDigit() {
        System.out.println("verifyUpperLowerDigit");
        String pass = "";
        char[] arr = null;
        EmailChecker instance = new EmailChecker();
        instance.verifyUpperLowerDigit(pass, arr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVerified method, of class EmailChecker.
     */
    @Test
    public void testIsVerified() {
        System.out.println("isVerified");
        EmailChecker instance = new EmailChecker();
        boolean expResult = false;
        boolean result = instance.isVerified();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
