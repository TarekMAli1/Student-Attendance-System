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
           
        //your test
        String testData = "asfnasif";
        assertTrue(EmailChecker.verifyLength(testData) == true);
        try {
            testWriter = new TestCasesWriter();
            testWriter.writeInitialTestDetails("Omar ","1", "Testing that password's length should be more than 6 chars");
            testWriter.writeTestPrequisits("Generate password input that has length larger and smaller than 6");
            testWriter.writeTestData("1","Password : " + testData);

        } catch (IOException ex) {
           ;
        }

    }

}
