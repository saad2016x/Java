package kb_1408300_p5;

public class KAUcourses {

    private KAUcourse head;

    public KAUcourses(KAUcourses head) {
        head = null;
    }

    KAUcourses() {
        
    }

    public KAUcourse getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean search(String courseid) {
        // invoking the private method for search process and returns true or false
        return search(head, courseid);
    }

    private boolean search(KAUcourse p, String courseid) {

        KAUcourse hPtr = p; // for traversing

        while (hPtr != null) { // as long as the node is not null
            if (hPtr.getID().equalsIgnoreCase(courseid)) { // if the course is found
                return true;
            }
            hPtr = hPtr.getNext(); //traverse
        }
        return false; // the course was not found
    }

    public KAUcourse findNode(String courseID) {
        return findNode(head, courseID); // returns the object or null if not found
    }

    private KAUcourse findNode(KAUcourse p, String courseID) {

        KAUcourse hPtr = p; // for traversing

        while (hPtr != null) { // as long as the node is not null
            if (hPtr.getID().equalsIgnoreCase(courseID)) { // if the course was found
                return hPtr; // return the course
            }
            hPtr = hPtr.getNext(); //traverse 
        }
        return null; // the course was not found
    }

    // method to count number of courses in linked list 
    public int couNodes() {
        return sumNodes(head);
    }

    private int sumNodes(KAUcourse head) {

        KAUcourse hPtr = head; // for traversing
        int counter = 0; // counter

        while (hPtr != null) {

            counter++; // one course is counted
            hPtr = hPtr.getNext(); // traverse
        }
        return counter; // return total number of courses in linked list
    }

    // method for adding a new course
    public void insert(String courseID, int grade) {
        head = insert(head, courseID, grade); // invoking the private method
    }

    private KAUcourse insert(KAUcourse head, String courseid, int grader) {

        //if the list is empry or if the course's right position is found (I want it sorted)
        if (head == null || head.getID().compareToIgnoreCase(courseid) > 0) {

            // declare a new object and make it a new head
            head = new KAUcourse(courseid, grader, head);
            return head; //return the updated head

        } else {

            KAUcourse helpPtr = head; // for traversing

            while (helpPtr.getNext() != null) { // as long as the next of the node is not null
                // if the right position is found (found the predecessor and successor)
                if (helpPtr.getNext().getID().compareToIgnoreCase(courseid) > 0) {
                    break; // break the loop
                }
                helpPtr = helpPtr.getNext(); // traverse
            }

            //inserting the new course to the linked list before successor
            KAUcourse newNode = new KAUcourse(courseid, grader, helpPtr.getNext());
            helpPtr.setNext(newNode); // predecessor now points to the new course
        }

        return head; // return the updated head
    }

}
