
package kb_1408300_p5;


public class KAUcourse {
    private String ID;
private int grade;
private int num;
private KAUcourse next; 

public KAUcourse(String ID, int grade, KAUcourse next) {
        this.ID = ID;
        this.grade = grade;
        this.next = next;
        num = 1;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public KAUcourse getNext() {
        return next;
    }

    public void setNext(KAUcourse next) {
        this.next = next;
    }
public void updateingGrade(int grade){
        this.grade += grade;
        num++;
    }

}
