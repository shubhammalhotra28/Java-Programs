import java.util.*;
public class Student {
   int studId;
   Person p;
   ArrayList<Course> course = new ArrayList<>();
   public Student(int studId, Person p, ArrayList course) {
      this.studId = studId;
      this.p = p;
      this.course = course;
   }

   public String toString() {
      String s = "ID: " + studId + " " + p.getName();
      String str = "";
      for (Course c : course) {
         String name = c.toString();
         str = str + "\n   " + name;
      }
      return s + str;
   }
}