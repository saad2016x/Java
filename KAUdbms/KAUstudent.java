

package kb_1408300_p5;

import java.io.PrintWriter;

public class KAUstudent {
 
   private int ID;
private String firstName;
private String lastName;
private String email;
private int age;
private int phone;
private int level;
private KAUcourses courses;
private double gpa;
private KAUstudent left;
private KAUstudent right; 
  public String name;

    public KAUstudent(int ID,String name, String email, int age, int phone, int level, KAUcourses courses, double gpa, KAUstudent left, KAUstudent right) {
        this.ID = ID;
        this.name = firstName+" "+lastName;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.level = level;
        this.courses = courses;
        this.gpa = gpa;
        this.left = left;
        this.right = right;
    }

    KAUstudent(int id, String name, String Email, int AGE, int phone) {
       this.ID = ID;
        this.name = firstName+" "+lastName;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

   

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public KAUcourses getCourses() {
        return courses;
    }

    public void setCourses(KAUcourses courses) {
        this.courses = courses;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public KAUstudent getLeft() {
        return left;
    }

    public void setLeft(KAUstudent left) {
        this.left = left;
    }

    public KAUstudent getRight() {
        return right;
    }

    public void setRight(KAUstudent right) {
        this.right = right;
    }

    public void setalldata(KAUstudent newStudent) {

        ID = newStudent.getID();
        firstName = newStudent.getFirstName();
        lastName = newStudent.getLastName();
        email = newStudent.getEmail();
        age = newStudent.getAge();
        phone = newStudent.getPhone();
        level = newStudent.getLevel();
        courses = newStudent.getCourses();
        gpa = newStudent.getGpa();

    }
     public void setGPA() {
        
        double sum = 0; // to sum the total grade of the student
        
        KAUcourse hlpPtr = courses.getHead(); //for traversing
        
        while (hlpPtr != null) {
            int grade = hlpPtr.getGrade();
            
            switch(grade){ 
                case  90: // 90 or above means A = grade would be 5
                sum += 5;
                break;
                case  80:  // 80 to 89 means B = grade would be 4
                 sum += 4;
                break;
                 case  70:  // 70 to 79 means C = grade would be 3
                sum += 3;
                     break;
                case  60:  // 60 to 69 means D = grade would be 2
                sum += 2;
                    break;
            }
            hlpPtr = hlpPtr.getNext(); // traverse
        }
        gpa = sum / courses.couNodes(); // divide the total grade by number of courses you will GPA
    }
    public void setLevel1() {
        
        double number = courses.couNodes(); // counting number of courses the student added so far
        
        if (number < 10) {
            level = 1;
        } else if (number < 20) {
            level = 2;
        } else if (number < 30) {
            level = 3;
        } else if (number < 40){
            level = 4;
        } else {
            level = 5;
        }

    }
     public void printalldata(PrintWriter output) {
   
        output.print("	Student Record for ID " + ID
                + "\r\n	First Name:  " + firstName
                + "\r\n	Last Name:   " + lastName
                + "\r\n	Email:       " + email);
        output.print( "                Phone:  " + phone);
        output.print("\r\n	Age:         " + age
                + "                                 Level:  " + this.level
                + "\r\n	GPA:         ");
        if (gpa > 0) {
            output.printf("%.2f\r\n", gpa);
        } else {
            output.println("N/A");
        }

        /*             Course Records                */
        output.println("	Course Record:");
        if (courses.isEmpty()) {
            output.println("		Student has not taken any courses");
        } else {
            KAUcourse hlpPtr = courses.getHead();
            while (hlpPtr != null) {
                output.printf("		Course ID:  %7s   Grade:  %3d\r\n", hlpPtr.getID(), hlpPtr.getGrade());
                hlpPtr = hlpPtr.getNext();
            }

        }
     }
}