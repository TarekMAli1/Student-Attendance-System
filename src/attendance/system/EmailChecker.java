/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance.system;

import java.util.StringTokenizer;

public class EmailChecker {

    private String EMAIL;
    private String PASSWORD;

    boolean upperCaseFlag = false;
    boolean lowerCaseFlag = false;
    boolean isDigitFlag = false;

    public boolean getUpperCaseFlag() {
        return upperCaseFlag;
    }

    public boolean getLowerCaseFlag() {
        return lowerCaseFlag;
    }

    public boolean getIsDigitFlag() {
        return isDigitFlag;
    }

    public boolean verify_email(String EMAIL) {
        this.EMAIL = EMAIL;
        StringTokenizer tokenizer=null;
        if (endsWithHelwanedueg(EMAIL)) {
            if (theFirstCharIsLetter(EMAIL)) {
                tokenizer = new StringTokenizer(EMAIL , "@");
            }
            {
                if (emailLengthIsLessThan12(tokenizer)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean emailLengthIsLessThan12(StringTokenizer tokenizer) {
        return tokenizer.nextToken().length() < 12;
    }

    public static boolean theFirstCharIsLetter(String EMAIL1) {
        return Character.isLetter(EMAIL1.charAt(0));
    }

    public static boolean endsWithHelwanedueg(String EMAIL1) {
        return EMAIL1.endsWith("@helwan.edu.eg");
    }

    public boolean verify_pass(String pass) {
        this.PASSWORD = pass;
        char[] arr = new char[pass.length()];
        arr = pass.toCharArray();

        if (verifyLength(pass)) {
            verifyUpperLowerDigit(pass, arr);
        }
        if (isVerified()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean verifyLength(String pass) {
        return pass.length() > 6;
    }

    public void verifyUpperLowerDigit(String pass, char[] arr) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isUpperCase(arr[i])) {
                upperCaseFlag = true;
            } else if (Character.isLowerCase(arr[i])) {
                lowerCaseFlag = true;
            } else if (Character.isDigit(arr[i])) {
                isDigitFlag = true;
            }
        }
    }

    public boolean isVerified() {
        return upperCaseFlag & lowerCaseFlag & isDigitFlag;
    }

}
