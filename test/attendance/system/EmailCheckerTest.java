/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.system;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    TestCasesWriter testWriter;
    int TEST_WRITE=1;

    @Test
    public void verifyLengthShouldReturnTrueIfGreaterThan7() {

        //your test
        String testData1 = "asfnasif";
        String testData2 = "xdman";
        
        assertTrue(EmailChecker.verifyLength(testData1) == true);
        assertTrue(EmailChecker.verifyLength(testData2) == false);
        
        //END TEST
        if (TEST_WRITE == 1) {
            try {
                testWriter = new TestCasesWriter();
                testWriter.writeInitialTestDetails("Omar ", "1", "Testing that password's length should be more than 6 chars");
                testWriter.writeTestPrequisits("Generate password input that has length larger and smaller than 6");
                testWriter.writeTestData("1", "TEST DATA : " + testData1 + " && " + testData2);

            } catch (IOException ex) {
                ;
            }
        }
    }
    @Test
    public void testEndsWithHelwaneduReturnsTrueIfItDoes()
    {        
        //TESTS
        String testData1="omar@helwan.edu.eg";
        String testData2="oamrarom@helw";
        
        assertTrue(EmailChecker.endsWithHelwanedueg(testData1));
        assertFalse(EmailChecker.endsWithHelwanedueg(testData2));
        
        if(TEST_WRITE==1)
        {
             try {
                testWriter = new TestCasesWriter();
                testWriter.writeInitialTestDetails("Omar ", "2", "Testing that the email ends with @helwan.edu.eg");
                testWriter.writeTestPrequisits("Generate an email that ends with @helwan.edu.eg and otherwise.");
                testWriter.writeTestData("2", "TEST DATA  : " + testData1 + " && "+ testData2);
                

            } catch (IOException ex) {
                ;
            }
        }
        
    }
    
    @Test
    public void testThatPasswordContainsADigit()
    {
        
        //test DATE
        String testData1="aAomqwear1";
        String testData2="omarelsayed";
        
        char[] arr = testData1.toCharArray();
        char[] arr2 = testData2.toCharArray();
        EmailChecker checker= new EmailChecker();
        checker.verifyUpperLowerDigit(testData1, arr);
        assertTrue(checker.getIsDigitFlag());
        checker= new EmailChecker();
        checker.verifyUpperLowerDigit(testData2, arr2);     
        assertFalse(checker.getIsDigitFlag());
        
        if(TEST_WRITE==1)
        {
             try {
                testWriter = new TestCasesWriter();
                testWriter.writeInitialTestDetails("Omar ", "3", "Testing that the password has a DIGIT or no.");
                testWriter.writeTestPrequisits("Generate a password that has digit and one that has no digits.");
                testWriter.writeTestData("3", "TEST DATA  : " + testData1 + " && "+ testData2);                

            } catch (IOException ex) {
                ;
            }
        
        }
    }
    
    @Test
    public void testThatPasswordHasUpperCaseLetter()
    {
    //test DATE
        String testData1="aAomqwear1";
        String testData2="omaorna12";
        
        char[] arr = testData1.toCharArray();
        char[] arr2 = testData2.toCharArray();
        EmailChecker checker= new EmailChecker();
        checker.verifyUpperLowerDigit(testData1, arr);
        assertTrue(checker.getUpperCaseFlag());
        checker= new EmailChecker();
        checker.verifyUpperLowerDigit(testData2, arr2);     
        assertFalse(checker.getUpperCaseFlag());
        
        if(TEST_WRITE==1)
        {
             try {
                testWriter = new TestCasesWriter();
                testWriter.writeInitialTestDetails("Omar ", "4", "Testing that the password has a upper case letter or no.");
                testWriter.writeTestPrequisits("Generate a password that has an upper case letter and one that doesn't have.");
                testWriter.writeTestData("4", "TEST DATA : " + testData1 + " && "+ testData2);                

            } catch (IOException ex) {
                ;
            }
        
        }
    
    }
    @Test
    public void testThatPasswordHasLowerCaseLetter()
    {
    //test DATE
        String testData1="aAomqwear1";
        String testData2="ASDASHD12";
        
        char[] arr = testData1.toCharArray();
        char[] arr2 = testData2.toCharArray();
        EmailChecker checker= new EmailChecker();
        checker.verifyUpperLowerDigit(testData1, arr);
        assertTrue(checker.getLowerCaseFlag());
        checker= new EmailChecker();
        checker.verifyUpperLowerDigit(testData2, arr2);     
        assertFalse(checker.getLowerCaseFlag());
        
        if(TEST_WRITE==1)
        {
             try {
                testWriter = new TestCasesWriter();
                testWriter.writeInitialTestDetails("Omar ", "5", "Testing that the password has a Lower case letter or no.");
                testWriter.writeTestPrequisits("Generate a password that has an Lower case letter and one that doesn't have.");
                testWriter.writeTestData("5", "TEST DATA : : " + testData1 + " && "+ testData2);                

            } catch (IOException ex) {
                ;
            }
        
        }
    
    }
    @Test
    public void testThatTheFirstCharISaLetter()
    {
        
    String testData1="ahmed@helwan.edu.eg";
    String testData2="Ahmed@helwan.edu.eg";        
    assertTrue(EmailChecker.theFirstCharIsLetter(testData2)==true);
    assertFalse(EmailChecker.theFirstCharIsLetter(testData1)==false);
    
    if(TEST_WRITE==1)
        {
             try {
                testWriter = new TestCasesWriter();
                testWriter.writeInitialTestDetails("Omar ", "6", "Testing that the Email has A first char as a LETTER.");
                testWriter.writeTestPrequisits("Generate an email that does satisfy the conditions and other that doesn't.");
                testWriter.writeTestData("6", "TEST DATA :  " + testData1 + " && "+ testData2);                

            } catch (IOException ex) {
                ;
            }
        }
    }
    @Test
    public void testThatemailIsLessThan12()
    {
    String testData1="Ahmed@helwan.edu.eg";
    String testData2="Ahmeasfasfasfasfd@helwan.edu.eg";   
    
    StringTokenizer tokenizer = new StringTokenizer(testData1 , "@");
    StringTokenizer tokenizer2 = new StringTokenizer(testData2 , "@");

    
    assertTrue(EmailChecker.emailLengthIsLessThan12(tokenizer));
    assertFalse(EmailChecker.emailLengthIsLessThan12(tokenizer2));
    
      if(TEST_WRITE==1)
        {
             try {
                testWriter = new TestCasesWriter();
                testWriter.writeInitialTestDetails("Omar ", "7", "Testing that the Email's length is less than 12.");
                testWriter.writeTestPrequisits("Generate an email that does satisfy the conditions and other that doesn't.");
                testWriter.writeTestData("7", "TEST DATA :  " + testData1 + " && "+ testData2);                

            } catch (IOException ex) {
                ;
            }
        
        }
    
    }
    
    
        
}
