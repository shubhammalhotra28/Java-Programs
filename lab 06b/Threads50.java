/**
  * This class creates and count threads
  * @author Shubham Malhotra
  *
  */
public class Threads50 extends Thread
{
   public static int finishCount= 0;
   private final int ONE_SECOND = 1000;
   // constructor for class Thread50 
   public Threads50( String name )
   {
      super( name );
   }
   /**
     * prints out the name and count of threads
     */
   public void run () {
      int temp = Integer.parseInt(Thread.currentThread().getName());
      try
      {
         sleep( (long) (Math.random() * ONE_SECOND + 1) );         
         System.out.println( "Hello I am thread " +
                          (temp<10?" ":"") + temp +
                          " finished "+ ++finishCount );
      }
      catch ( InterruptedException e )
      {
         System.err.println( e.getMessage() );
      } 
   } 
   /**
     * main method creating threads
     */
   public static void main ( String[] args ) 
   {
      Threads50 thread; 
      int numThreads;   
      if ( args.length != 1 ) 
      { 
         System.err.println( "Usage:  java MyThreads number-of-threads" );
         System.exit( 1 );
      }
      numThreads = Integer.parseInt( args[ 0 ] );
      if ( numThreads < 0 ) 
      {
         System.err.println( "Invalid number!" );
      }
      else
      {
         for ( int i = 0; i < numThreads; i++ ) 
         {
            if(i%2==0)
            {
               (new Threads50( "" + (50+i ))).start();
            }
            else
            {
               (new Threads50( "" + i )).start();
            }   
         }
      }
   }  
}