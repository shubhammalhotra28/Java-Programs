import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.util.*;

/**

 *  ISTE-121 Lab XML ([A-Za-z0-9-.()]*) ()
 *	An XML parser for student data
 *	Original LBE by: Jai Kang
 * Converted to lab by: Maxwell Sweikert, Jonathan Theismann, Michael Floeser
 */
 
public class StudentParser {
   private DocumentBuilder builder;
   private XPath path;
   ArrayList<Student> studentList = new ArrayList<>();

   /**
    * Constructs a parser that can parse student lists.
    */
   public StudentParser()
         throws ParserConfigurationException {
      DocumentBuilderFactory dbfactory
            = DocumentBuilderFactory.newInstance();
      builder = dbfactory.newDocumentBuilder();
      XPathFactory xpfactory = XPathFactory.newInstance();
      path = xpfactory.newXPath();
   }

   /**
    * Parses an XML file containing student data.
    * @param fileName the name of the file
    */
   public void parse(String fileName)
      throws SAXException, IOException, XPathExpressionException {
      File f = new File(fileName);
      Document doc = builder.parse(f);

      int studentCount = Integer.parseInt(path.evaluate(
            "count(/students/student)", doc));

      System.out.println("*** Students Listing ***");
      for (int i = 1; i <= studentCount; i++)
      {
         int id = Integer.parseInt(path.evaluate(
                "/students/student[" + i + "]/id", doc));
         String ln = path.evaluate(
               "/students/student[" + i + "]/person/lastperson", doc);
         String fn = path.evaluate(
               "/students/student[" + i + "]/person/firstperson", doc);
         Person person = new Person(fn, ln);
         ArrayList<Course> courseList = new ArrayList<>();
         
         int courseCount = Integer.parseInt(path.evaluate(
            "count(/students/student[" + i + "]/courses/course)", doc));
         for (int j = 1; j <= courseCount; j++) {
            String courseNumber = path.evaluate(
               "/students/student[" + i + "]/courses/course[" + j + "]/@coursenumber", doc);
            String name = path.evaluate(
               "/students/student[" + i + "]/courses/course[" + j + "]/@name", doc);
               Course c = new Course(name, courseNumber);
               courseList.add(c);
         }
       
          Student stu = new Student(id, person, courseList);
          studentList.add(stu);
         
          
//          System.out.printf("LN: %-10s FN: %-10s%n",ln,fn);
      }
      printReport();
   }
   
   public void printReport() {
   String report = "";
      for (int i=0; i < studentList.size(); i++) {
         Student student = studentList.get(i);
         System.out.println(student.toString());
//          report += student.toString();
          
      }
//       return report;
   }

   /**
      Specify the filename and parse the data. 
   */
   public static void main(String [] args) throws Exception{
      new StudentParser(args);
   }
   
   public StudentParser(String [] args) throws Exception {
      // define a default file to parse
	   String parseThis = "studentCourses.xml";

	   StudentParser studentParser = new StudentParser();
      
      // if we have one item specified on the command line, use it
      if( args.length == 1 ){
         parseThis = args[0];
      }
      else if( args.length > 1 ){
         System.out.println("Specify only one file on the command line.\n"+
                "If you have only one filename, it may contain spaces.\n"+
                "Place double quotes around the filename, and rerun. \n"+
                "For example: \"C:/Program files\"");
         return;
      }
      // else use the default parse file
      
      studentParser.parse( parseThis );


   }
            
      
      

} // end class StudentParser





