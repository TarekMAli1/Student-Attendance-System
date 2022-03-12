/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.system;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


public class FileReader {
    
    
    
    
    private File file=new File("C:\\Users\\antoz\\Desktop\\students.txt");
    StringTokenizer tokenizer;
    String filecontent="";
    
    
      String url, username, password;
    public static Connection MyConnection;
    public Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    //should be changed to singleton
    public void connectToDB() {
        this.url = "jdbc:mysql://localhost:3306/attendance system?zeroDateTimeBehavior=convertToNull";
        this.username = "root";
        this.password = "";
        this.connect();
    }

    public Connection connect() {
        try {
            MyConnection = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("connected");
        } catch (SQLException x) {
            System.out.println("can't connect" + x);
        }
        return MyConnection;
    }

    FileReader()
    {
        JFileChooser j = new JFileChooser();
        int r = j.showSaveDialog(null);
        String file_name=j.getSelectedFile().getAbsolutePath();
        File file=new File(file_name);
        DB_Update();
    }
    private void DB_Update()
    {
        
        String name = null;
        String email=null;
        String password=null;
        int i=1;
    try
    {
        Scanner scan=new Scanner(file);
        while(scan.hasNextLine())
        {
        filecontent=filecontent.concat(scan.nextLine() + "\n");
        }
        tokenizer= new StringTokenizer(filecontent , "///");
        while(tokenizer.hasMoreTokens())
        {
             if(i==1 && tokenizer.hasMoreTokens())
             {
             name=tokenizer.nextToken().trim();
             i++;
             }
             if(i==2 && tokenizer.hasMoreTokens())
             {
             email=tokenizer.nextToken().trim();
             i++;
             }
             if(i==3 && tokenizer.hasMoreTokens())
             {
                password=tokenizer.nextToken().trim();
                i=1;
             }
             System.out.println(name+email+password);
             Insert(email, password,"student");
        }
        System.out.println("Done Insertion!");
 
    }
    catch(FileNotFoundException e)
    {
    System.out.println("FileNotFound!");
    }
    
    }
    
    
    
    
    
    
    public void Insert(String email, String pw, String table) {
        connectToDB();
        this.MyConnection=connect();
        String insertQuery = "INSERT INTO " + table + " ( email , pw) VALUES ('" + email + "','" + pw + "')";
        try {
            this.pst = this.MyConnection.prepareStatement(insertQuery);
            int updated_rows = this.pst.executeUpdate();
            System.out.println("Insertion Done Succefully!  Update Rows : " + updated_rows);
        } catch (SQLException ex) {
            Logger.getLogger(DATABASE.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
