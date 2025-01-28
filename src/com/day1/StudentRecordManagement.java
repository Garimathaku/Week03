package com.day1;

//class node StudentNOde
class StudentNode{
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;
    //constructor
    StudentNode(int rollNumber,String name,int age,char grade){
        this.rollNumber=rollNumber;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.next=null;
    }

}
//class StudentList
class StudentList{
    private StudentNode head;
    //method to insert at the beginning
    public void insertAtBeginning(int rollNumber,String name,int age,char grade){
        StudentNode student1= new StudentNode(rollNumber,name,age,grade);
        student1.next=head;
        head=student1;
    }
    //method to insert at the end
    public void insertAtEnd(int rollNumber,String name,int age,char grade){

        StudentNode student1= new StudentNode(rollNumber,name,age,grade);
        StudentNode temp= head;
        while(temp.next!=null){
            temp=temp.next;

        }
        temp.next=student1;
        student1.next=null;
    }
    //method to insert at the position
    public void insertAtPosition(int position,int rollNumber,String name,int age,char grade){
        if(position<=0){
            System.out.println("Invalid Position");
        }
        if(position==0){
            insertAtBeginning(rollNumber,name,age,grade);
        }
        StudentNode student1= new StudentNode(rollNumber,name,age,grade);
        StudentNode temp= head;

        for(int i=1;i<position-1&& temp!=null;i++){
            temp=temp.next;

        }
        if(temp==null){
            System.out.println("Enter valid position");
        }
        student1.next=temp.next;
        temp.next=student1;


    }
    //method to delete the student record by roll number
    public void deleteStudentRecord(int rollNumber){
        if(head.rollNumber==rollNumber){
            head=head.next;
            System.out.println("record deleted");
            return;
        }
        StudentNode temp=head;
        while(temp.next!=null&&temp.next.rollNumber!=rollNumber){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Student not found");
        }else{
            temp.next=temp.next.next;
            System.out.println("Record Deleted");
        }
    }
    //method to search student record by roll number
    public StudentNode searchStudentRecord(int rollNumber) {
        if (head.rollNumber == rollNumber) {

            return head;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found");
        } return temp.next;
    }
    // method to display All details
    public void displayAll(){
        if(head==null){
            System.out.println("There are no records of students");
            return;
        }
        StudentNode temp=head;
        while(temp.next!=null){
            System.out.println("Roll Number: "+ temp.rollNumber+ " Name: "+ temp.name+ "Age: "+ temp.age + "Grade:  "+ temp.grade);
            temp=temp.next;
        }
    }
    //method to upadate student grade by the roll number and grade
    public void updateStudentGrade(int rollNumber,char grade){
        if(head.rollNumber==rollNumber){
            head.grade=grade;
        }
        StudentNode temp= head;
        while(temp.next!=null&&temp.next.rollNumber!=rollNumber){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("No records");
        }
        else{
            temp.next.grade=grade;}
    }
}
//class studentRecordManagement
public class StudentRecordManagement {
    public static void main(String[]args){
        StudentList list= new StudentList();
        list.insertAtBeginning(11,"Alice",12,'A');
        list.insertAtBeginning(12,"Alice2",22,'B');

        list.insertAtEnd(13,"Bob",23,'D');
        list.insertAtEnd(14,"Bob2",24,'C');

        list.insertAtPosition(3,15,"John",33,'E');
        list.insertAtPosition(2,16,"John2",34,'F');

        list.displayAll();

        list.deleteStudentRecord(13);
        list.displayAll();
        list.searchStudentRecord(14);
        list.displayAll();
        list.updateStudentGrade(13,'D');
        list.displayAll();
    }
}
