/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.system;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author antoz
 */
public class TestCasesWriter {
    public static FileWriter csvWriter;
    TestCasesWriter() throws IOException
    {
    csvWriter=new FileWriter("C:\\Users\\antoz\\Desktop\\test_case.csv" , true);
    csvWriter.append("\n");
    }
    public void writeInitialTestDetails(String createdBy , String testID , String testDescription) throws IOException
    {
    csvWriter=new FileWriter("C:\\Users\\antoz\\Desktop\\test_case.csv" , true);
    this.csvWriter.append("Test Case ID : ");
    this.csvWriter.append(testID);
    this.csvWriter.append(",");
    this.csvWriter.append("\n");
    this.csvWriter.append("Created By : ");
    this.csvWriter.append(createdBy);
    this.csvWriter.append(",");
    this.csvWriter.append("\n");
    this.csvWriter.append("Test Case Description : ");
    this.csvWriter.append(testDescription);
    this.csvWriter.append(",");
    this.csvWriter.append("\n");
    this.csvWriter.append("Tester's Name : ");
    this.csvWriter.append(createdBy);
    this.csvWriter.append(",");
    this.csvWriter.append("\n");
    this.csvWriter.append("Date Tested : ");
    String timeStamp = new SimpleDateFormat("yyyy MM dd").format(Calendar.getInstance().getTime());
    this.csvWriter.append(timeStamp);
    this.csvWriter.append(",");
    this.csvWriter.append("\n");
    this.csvWriter.append("Test Case (Pass/Fail/Not Executed) : ");
    this.csvWriter.append("PASSED ,");
    this.csvWriter.append("\n");
    this.csvWriter.close();
    }
    
    public void writeTestPrequisits(String preqs) throws IOException
    {
     csvWriter=new FileWriter("C:\\Users\\antoz\\Desktop\\test_case.csv" , true);
     csvWriter.append("Test Prequisits : ");
     csvWriter.append(preqs);
     csvWriter.append(" ,");
     csvWriter.append("\n");
     csvWriter.close();
    }
    public void writeTestData(String id , String testData) throws IOException
    {
     csvWriter=new FileWriter("C:\\Users\\antoz\\Desktop\\test_case.csv" , true);
     csvWriter.append("Test Data : ,");
     csvWriter.append("\n");
     csvWriter.append("ID : " + id);
     csvWriter.append(" ,");
     csvWriter.append(testData);
     csvWriter.append(" ,");
     csvWriter.append("\n");
     csvWriter.close();
    }
    
}
