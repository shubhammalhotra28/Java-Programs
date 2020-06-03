import java.util.regex.*;
/**
   Regular Expression starter code for the 
*/
public class RegExpStarter{

   public static void main(String [] args){
      
      String starterLine = "Brandy Banker $45,000";   
      Pattern patrn = Pattern.compile("([a-zA-Z ]*)([$,0-9]*)");
      Matcher m=patrn.matcher(starterLine);
   
      while ( m.find() ){
         String data = m.group(1);
         // Non numbers return as an empty match, only print ones with data, numbers only
         if( data.length() > 0 )   
            System.out.println("Name: " + m.group(1) + "\n  Salary: " + m.group(2) );
      }
   
      // Use the JGrasp, Regular Expression Tester located in the Tools menu ([A-Z\.\w-]+)
      Pattern patrn2 = Pattern.compile("([A-Za-z\\D()0-9]*)");
      String phoneNumbers[] = { "L. Jenks: (585) 475-7031",
                                "O. Acers: 518.438.7908",
                                "V. Vance: 716-223-7382",
                                "E. Adams: (212)324-4221"};
      
      for(String line: phoneNumbers){
         Matcher m2=patrn2.matcher(line);
         while ( m2.find() ){
            String data2 = m2.group();
            if( data2.length() > 0 ) {   
               for( int i=1; i<=m2.groupCount(); i++){
                  System.out.print( m2.group(i) +" ");
               }
               System.out.println();
            }
         }
      }      
         
   } // end main

} // end class