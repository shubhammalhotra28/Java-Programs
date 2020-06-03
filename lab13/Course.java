
public class Course {
   String course;
   String courseNum;
   public Course(String course, String courseNum) {
      this.course = course;
      this.courseNum = courseNum;
   }
   public String toString() {
      return courseNum + ": " + course;
      
   }
}