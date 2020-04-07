/*
name|saad bakket alshereef
ID|1408300
Email|saad2016x@gmail.com
Section| Kb
 */
package kb_1408300_p5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class KAUdbms {

     public static void delete(KAUdbmsBST studentsss, PrintWriter output, String name) {
        
        KAUstudent studentss = studentsss.findNodeName(name);

        if (studentss == null) { 
            
            output.println("	Cannot Perform DELETE Command:\r\n"
                    + "		Student (" + name+ ") was not found in KAUdbms.");
           
            
        } else { 
            studentsss.delete(studentss.name); 
            output.println("	Student (" + name + ") has been removed from KAUdbms.");
            
        }
    }
    public static void insertCourse(KAUdbmsBST student, KAUcourses MastersCourses, PrintWriter outpuut, int studentid, String courseid, int grader) {
        
        KAUstudent sent = student.findNode(studentid); 
        KAUcourse Marse = MastersCourses.findNode(courseid); 

        if (sent != null) { 

            
            KAUcourse course = sent.getCourses().findNode(courseid);
            
            
            if (course == null) { 
                sent.getCourses().insert(courseid, grader); 
                sent.setLevel1(); 
                outpuut.println("	" + courseid + " (Grade: " + grader + ") has been added to the record of Student ID " + studentid + ".");
               
                
            } else {
                 course.setGrade(grader); 
                outpuut.println("	" + courseid + ": grade has been changed/updated, to a " + grader + ", for Student ID " + studentid + ".");
                
            }
            
            sent.setGPA(); 

            
            if (Marse == null) { 
                MastersCourses.insert(courseid, grader); 
            } else {
                Marse.updateingGrade(grader); 
            }

        } else { // if the student is not found, you can't do the adding process
            outpuut.println("	ERROR: cannot add course. Student ID # " + studentid + " was not found in KAUdbms.");
        }
    }
    
    public static void SearchName(KAUdbmsBST students, PrintWriter output, String name) {
        
        KAUstudent student = students.findNodeName(name); // searching for the student by name
        
        if (student != null) { // if the students is found
            output.println("	Found:  ID "+student.getID()+", "+student.name.toUpperCase());
        } else { // if he is null = not found
            output.println("	" + name+ " was not found in FCITbook.");
        }
    }
public static void Searchid(KAUdbmsBST students, PrintWriter output, int ID) {
        
        KAUstudent student = students.findNode(ID); // searching for the student by ID

        if (student == null) { // if the student is found
            output.println("	ID " + ID + " was not found in FCITbook.");
           
        } else { // if he is null = not found
             output.println("	Found:  ID "+student.getID()+", "+student.name.toUpperCase());
        }
    }

    public static void printallRecord(KAUdbmsBST students, PrintWriter output, String name ) {
        
        KAUstudent student = students.findNodeName(name); // searching for the student by a given name
        
        if (student != null) { // if the student is found
            
            student.printalldata(output); // print his data
            
        } else { // if he is not found
            output.println("	Cannot Perform PRINTRECORD Command:\r\n"
                    + "		Student (" + name + ") was not found in KAUdbms.");
        }
    }
   
    
   
    
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("KAUdbms.in"));
        PrintWriter output = new PrintWriter(new File("KAUdbms.out"));
            KAUdbmsBST student = new KAUdbmsBST();
             KAUcourses MCourses = new KAUcourses();

            

            

            int commandsNumber = input.nextInt();

            for (int y = 0; y < commandsNumber; y++) {

                String command = input.next();

                if (command.equals("NEWSTUDENT")) {
                    output.println("NEWSTUDENT Command");
                   
                    student.insert(output, input.nextInt(), input.next()+" "+input.next(), input.next(), input.nextInt(), input.nextInt());
                   
                } else if (command.equals("SEARCHNAME") == true) {
                        String name =input.next()+" "+input.next();
                        output.println("SEARCHNAME Command");
                    SearchName(student, output, name);
                    
                } else if (command.equals("SEARCHID")) {
                             output.println("SEARCHID Command");
                             Searchid(student, output, input.nextInt());
                    
                } else if (command.equals("ADDCOURSE")) {
                     output.println("ADDCOURSE Command");
                    insertCourse(student, MCourses, output, input.nextInt(), input.next(), input.nextInt());
                   

                } else if (command.equals("DELETE")) {
                           
                    String name =input.next()+" "+input.next();
                    output.println("DELETE Command");
                    delete(student, output, name);
                    
                } else if (command.equals("PRINTRECORD")) {
                     
                    String name =input.next()+" "+input.next();
                    output.println("PRINTRECORD Command");
                    printallRecord(student, output, name);
                    
                } else if (command.equals("PRINTALLRECORDS")) {
                            output.println("PRINTALLRECORDS Command");
                    if (student.isEmpty()) { // if the tree is not empty
            
            
             output.println("	Cannot Perform PRINTALLRECORDS Command:\r\n"
                    + "		There are currently no student records saved in KAUdbms.");
        } else { // if he is  found
           output.println("	All records saved in KAUdbms:");
            output.println("	STUDENT ID     NAME                     AGE     YEAR/LEVEL     GPA");
            student.printRecords(output); // print all students' records 
           
        }
    }
                
            else if (command.equals("PRINTALLCOURSES")) {
                    output.println("PRINTALLCOURSES Command");
                    if (MCourses.isEmpty()) { 
            
            output.println("	Cannot Perform PRINTALLCOURSES Command:\r\n"
                    + "		There are currently no course saved in KAUdbms.");
            
        } else {
            
            output.println("	All courses saved in KAUdbms:\r\n"
                    + "	COURSE NAME         AVERAGE GRADE");
            
            KAUcourse hPtr = MCourses.getHead(); 
            output.println("	Cannot Perform PRINTALLCOURSES Command:\r\n"
                    + "		There are currently no course saved in KAUdbms.");
            
            while(hPtr != null) { // printing all courses's data
                
                output.printf("	%-23s%d\r\n", hPtr.getID(), hPtr.getGrade()/hPtr.getNum());
                hPtr = hPtr.getNext(); 
                
            }
                    
                }

            }
            }
                input.close();
            output.close();
        
    }
}



