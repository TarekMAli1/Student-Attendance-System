package attendance.system;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.util.*;
import java.text.Format;
import java.text.SimpleDateFormat;

public class DATABASE {

    

    DATABASE() {
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
    boolean attend(String STemail, String subject) {
        try {
            Statement myStatement = MyConnection.createStatement();
            myStatement.executeUpdate("INSERT INTO takes(students_email,course_section_name,status) VALUES('" + STemail + "','" + subject + "','" + 1 + "');");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    String attendanceProcessing(String STEmail) {
        int groupSec = 0;
        String str = "";
        Calendar cal = Calendar.getInstance();
        Format f = new SimpleDateFormat("EEEE");
        String todayDate = f.format(new Date());
        System.out.println("todaaaay " + todayDate);
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        int currentTime = Integer.valueOf(sdf.format(date));
        System.out.println("time " + currentTime);
        try {
            Statement myStatement = MyConnection.createStatement();
            try {
                ResultSet myresult = myStatement.executeQuery("SELECT group_no_ID FROM students WHERE email='" + STEmail + "'");
                while (myresult.next()) {
                    groupSec = myresult.getInt("group_no_ID");
                    System.out.println(groupSec);
                }
            } catch (SQLException x) {
                System.out.println("can't create result as " + x);
            }
        } catch (SQLException x) {
            System.out.println("can't create statement as " + x);
        }
        try {
            Statement myStatement = MyConnection.createStatement();
            try {
                ResultSet myresult = myStatement.executeQuery("SELECT * FROM group_has_course_section WHERE group_no_ID='" + groupSec + "' AND day = '" + todayDate + "'");
                if (myresult.next()) {
                    if (myresult.getInt("hour") <= currentTime && myresult.getInt("hour") + 2 > currentTime && myresult.getString("day").compareTo(todayDate) == 0) {
                        str = myresult.getString("course_section_name");

                    }
                }
            } catch (SQLException x) {
                System.out.println("can't create result as " + x);
            }
        } catch (SQLException x) {
            System.out.println("can't create statement as " + x);
        }
        return str;
    }
    public boolean search_student(String email, String password) {
        try {
            Statement myStatement = MyConnection.createStatement();
            ResultSet myresult = myStatement.executeQuery("SELECT * FROM students WHERE email='" + email + "' AND password='" + password + "'");
            while (myresult.next()) {
                System.out.println("found : " + myresult.getString("email"));
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    public boolean search_instructor(String email, String password) {
        try {
            Statement myStatement = MyConnection.createStatement();
            ResultSet myresult = myStatement.executeQuery("SELECT * FROM instructor WHERE email='" + email + "' AND password='" + password + "'");
            while (myresult.next()) {

                System.out.println("found : " + myresult.getString("email"));
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    public ArrayList<Integer> search_instructorgroups(String email) {
        ArrayList<Integer> Grouparr = new ArrayList<>();
        try {
            Statement myStatement = MyConnection.createStatement();

                ResultSet myresult = myStatement.executeQuery("SELECT group_no_ID FROM instructor_has_group_no WHERE instructor_email='" + email + "'");
                while (myresult.next()) {
                    Grouparr.add(myresult.getInt("group_no_ID"));
                }
                return Grouparr;
            } catch (SQLException x) {
                System.out.println("can't create result as " + x);
                return null;
            }

    }
    public ArrayList<String> getCourses() {
        ArrayList<String> coursearr = new ArrayList<>();
        try {
            return _getCourses(coursearr);
        } catch (SQLException x) {
            System.out.println("can't create statement as " + x);
            return coursearr;
        }
    }
    public ArrayList<String> _getCourses(ArrayList<String> coursearr) throws SQLException {
        Statement myStatement = MyConnection.createStatement();
        try {

            _getResults(myStatement, coursearr);
            return coursearr;
        } catch (SQLException x) {
            System.out.println("can't create result as " + x);
            return coursearr;
        }
    }
    public void _getResults(Statement myStatement, ArrayList<String> coursearr) throws SQLException {
        ResultSet myresult = myStatement.executeQuery("SELECT * FROM course_section  ");
        while (myresult.next()) {
            coursearr.add(myresult.getString("name"));
        }
    }
    public boolean insertST_data(String email, String password, int Group) {
        try {
            Statement myStatement = MyConnection.createStatement();
            try {
                myStatement.executeUpdate("INSERT INTO students(email,password,group_no_ID) VALUES('" + email + "','" + password + "','" + Group + "');");
                return true;
            } catch (SQLException x) {
                System.out.println("can't INSERT as " + x);
                return false;
            }
        } catch (SQLException x) {
            System.out.println("can't create statement as " + x);
            return false;
        }
    }
    public int getAttendanceCounterForOneCourse(String email, String course) {
        int counter = 0;
        try {
            Statement myStatement = MyConnection.createStatement();
                ResultSet myresult = myStatement.executeQuery("SELECT status FROM takes WHERE students_email='" + email + "' AND course_section_name='" + course + "'");
                while (myresult.next()) {
                    if (myresult.getInt("status") == 1) {
                        counter++;
                    }
                }
                return counter;
            } catch (SQLException x) {
                System.out.println("can't create result as " + x);
                return -1;
            }
       
    }
    public boolean publishCourseByDayAndHour(int group, String course, String day, int hour) {
        try {
            return assignCoursesToGroup(course, group, day, hour);
        } catch (SQLException x) {
            System.out.println("can't create statement as " + x);
            return false;
        }

    }
    public boolean assignCoursesToGroup(String course, int group, String day, int hour) throws SQLException {
        Statement myStatement = MyConnection.createStatement();
        try {
            myStatement.executeUpdate("INSERT INTO  group_has_course_section(course_section_name,group_no_ID,day,hour) VALUES('" + course + "','" + group + "','" + day + "','" + hour + "');");
            return true;
        } catch (SQLException x) {
            System.out.println("can't INSERT as " + x);
            return false;
        }
    }
    public boolean searchForStudentEmail(String email) {
        /*
        returns true if the email is found ,else false
        used in ReportGUI , to check if the email is found to get it's report
         */
        try {
            Statement myStatement = MyConnection.createStatement();
            try {
                ResultSet myresult = myStatement.executeQuery("SELECT * FROM students WHERE email='" + email + "'");
                while (myresult.next()) {

                    System.out.println("found : " + myresult.getString("email"));
                    return true;
                }
            } catch (SQLException x) {
                System.out.println("can't create result as " + x);
                return false;
            }
        } catch (SQLException x) {
            System.out.println("can't create statement as " + x);
            return false;
        }
        return false;
    }

    String url, username, password;
    public static Connection MyConnection;
    public Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
}
