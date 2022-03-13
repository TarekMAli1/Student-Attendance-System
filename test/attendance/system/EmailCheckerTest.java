/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.system;

import java.io.IOException;
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

    @Test
    public void testverifyLength() {
        int TEST_WRITE = 0;

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
                testWriter.writeTestData("1", "Password : " + testData1);

            } catch (IOException ex) {
                ;
            }
        }
    }

}
