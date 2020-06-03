import java.util.*;
import java.util.concurrent.TimeUnit;


public class Lab4 {
    int counter = 0;

    public static void main(String args[]) {
        new Lab4();
    }

    public Lab4() {

        Lab4Inner t1 = new Lab4Inner("1");
        Lab4Inner t2 = new Lab4Inner("2");
        t1.start();

        t2.start();
        try
        {
            t1.join();
            t2.join();

        }
        catch(InterruptedException ie)
        {
            System.out.println("InterruptedException");
        }
        System.out.println("Program finished,count = " + counter);
    }

    class Lab4Inner extends Thread {
        private String name;

        public Lab4Inner(String _name) {
            name = _name;
        }

        public void run() {

            yield();
            counter++;
            System.out.println("This ran thread" + name);

        }
    }
}

