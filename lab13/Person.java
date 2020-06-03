
public class Person {
   String fn;
   String ln;
   public Person(String _fn, String _ln) {
      setFn(fn);
      setLn(ln);
   }   
   public void setFn(String _fn) {
      this.fn = fn;
   }
   public void setLn(String _ln) {
      this.ln = ln;
   }
   public String getFn() {
      return fn;
   }
   public String getLn() {
      return ln;
   }
   public String getName() {
      return fn + " " + ln;
   }
}