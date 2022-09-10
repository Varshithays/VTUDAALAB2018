/* 1a. Create a Java class called Student with the following details as variables within it.
(i)  USN
(ii)  Name
(iii) Branch
(iv) Phone
Write a Java program to create nStudent objects and print the USN, Name, Branch, and Phone of these objects with suitable headings.
*/

import java.util.Scanner;

class Student {

    String USN, Name, Branch, Phone;
    Student(String U,String N,String B,String P){
        USN=U;
        Name=N;
        Branch=B;
        Phone=P;
    }
    void display() {
        System.out.println( USN+"\t"+Name+"\t"+Branch+"\t"+Phone+"\t");
        System.out.println("----------");
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of student details to be created");
        int n = in.nextInt();

        Student[] s = new Student[n];

        // Read student details into array of student objects

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of student ");
            System.out.println("Enter the usn: ");
            String usn = in.next();
            System.out.println("Enter the name: ");
            String name = in.next();
            System.out.println("Enter the branch: ");
            String branch = in.next();
            System.out.println("Enter the phoneno: ");
            String phone = in.next();
            s[i] = new Student(usn, name, branch, phone);

        }System.out.println("USN\tName\tBranch\tPhoneno");
        for (int i = 0; i < n; i++) {
            s[i].display();
        }
    }
 }

