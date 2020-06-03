import java.util.*;

public class Internationalization {


  static public void main(String[] args) {
    Locale loc = new Locale("en");
    Locale frloc = new Locale("fr", "FR");
    Locale deloc = new Locale("de", "DE");
    Locale enloc = new Locale("en", "US");
    System.out.println("The Default locale is en_US");
    
    try{
    ResourceBundle message = ResourceBundle.getBundle("LabelsBundle", loc);
    ResourceBundle frmessage = ResourceBundle.getBundle("LabelsBundle", frloc);
    ResourceBundle demessage = ResourceBundle.getBundle("LabelsBundle", deloc);
    
    System.out.println("<key4> "+ "fr: "+frmessage.getString("s4")+ "de "+demessage.getString("s4")+ "en "+ message.getString("s4"));
    System.out.println("<key3> "+ "fr: "+frmessage.getString("s3")+ "de "+demessage.getString("s3")+ "en "+ message.getString("s3"));
    System.out.println("<key2> "+ "fr: "+frmessage.getString("s2")+ "de "+demessage.getString("s2")+ "en "+ message.getString("s2"));
    System.out.println("<key1> "+ "fr: "+frmessage.getString("s1")+ "de "+demessage.getString("s1")+ "en "+ message.getString("s1"));
    }
    catch(MissingResourceException mre){
      System.out.println(mre);
    }
    
  }
}
