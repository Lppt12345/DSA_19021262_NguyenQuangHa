package Week7;

import java.util.*;

import static java.util.Collections.*;

/* JAVA SORT */
public class JavaSort {

    static class Student  {
        private int id;
        private String fname;
        private double cgpa;
        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }

    }

    public static class StudentComparator implements Comparator <Student>
    {
        @Override
        public int compare(Student s1, Student s2) {
            if (s1.getCgpa() !=  s2.getCgpa()) {
                // Sap xep cgpa tu lon den be neu muon nguoc lai thi doi 1:-1
                return s1.getCgpa() > s2.getCgpa() ? -1 : 1;
            }
            if (s1.getFname() != s2.getFname()){
                return s1.getFname().compareTo(s2.getFname());
            }
            // xet ID theo gia tri tang dan
            return s1.getId() - s2.getId();
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        Collections.sort(studentList, new StudentComparator());
        for(Student st: studentList){
            System.out.println(st.getFname());
        }
    }
}
