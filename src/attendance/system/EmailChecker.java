/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.system;
import java.util.StringTokenizer;


public class EmailChecker 
{
    private String EMAIL;
    private String PASSWORD;
    
   public StringTokenizer tokenizer=new StringTokenizer("@");
        boolean flag = false;
        boolean flag2 = false;
        boolean flag3 = false;
    public boolean verify_email(String EMAIL)
    {
    this.EMAIL=EMAIL;
    if(EMAIL.endsWith("@helwan.edu.eg"))
    {
    if(Character.isLetter((EMAIL.charAt(0))))
           tokenizer=new StringTokenizer("@");
            {
             if(tokenizer.nextToken().length() < 12 )
             {
                 
              return true;   
             }
            }
    }
    return false;
    }
        public boolean verify_pass(String pass ){
        this.PASSWORD=pass;
        char[]arr=new char[pass.length()];
        arr=pass.toCharArray();
        
        if (verifyLength(pass))
        {
            verifyUpperLowerDigit(pass, arr);
        }
        if (isVerified()){
            return true;
        }
        else
       return false;
    }

    public static boolean verifyLength(String pass) {
        return pass.length()>6;
    }

    public void verifyUpperLowerDigit(String pass, char[] arr) {
        for (int i=0;i<pass.length();i++){
            if (Character.isUpperCase(arr[i])){
                flag=true ;
            }
            else if (Character.isLowerCase(arr[i])){
                flag2=true ;
            }
            else if (Character.isDigit(arr[i])){
                flag3=true ;
            }
        }
    }

    public boolean isVerified() {
        return flag&flag2&flag3;
    }
    
}