//author:Rahul Goswami
//author:Shubham Malhotra
import java.util.Scanner;

public class Bank{

  public interface account{
    public void get_details();
    public void set_pin();
    public void change_phone();
    public void link_aadhar();
    public void Freeze();
    public void is_active();
    public void check_bal();

  }

  public interface transaction{
    public void withdraw();
    public void deposit();
    public void get_interest();
    public void trans_limit();
    //public void fund_transfer();

  }

  static class SavingsAccount implements account, transaction{
    String name;
    String ID;
    String IFSC;
    double Bal;
    String Aadhar;
    String phone;
    String Address;
    String DOB;
    int pin;
    int attempts=1;
    Boolean alive = true;
    Boolean cred_freeze = false;
    Boolean deb_freeze =false;
    Boolean interest_paid = false;
    protected double rate_of_interest = 4.0;
    long limit = 100000;



     SavingsAccount(){
      Scanner in = new Scanner(System.in);
      System.out.println("Please Enter your Name");
      this.name = in.nextLine();
      System.out.println("Please Enter your DOB(DDMMYYYY)");
      this.DOB = in.nextLine();
      System.out.println("Please Enter your Address");
      this.Address = in.nextLine();
      System.out.println("Please Enter your phone number");
      this.phone = in.nextLine();
      System.out.println("Please Enter your Starting Deposit");
      this.Bal = in.nextDouble();
      System.out.println("Enter Authentication PIN");
      this.pin = in.nextInt();
      System.out.println();

    }

    private Boolean validate_pin(){
      Scanner in = new Scanner(System.in);
      System.out.println("Enter current  Authentication PIN");
      int auth =in.nextInt();
      if(auth==this.pin){
        this.attempts=1;
        return true;
      }
      else{
        System.out.println("Error! Incorrect PIN");

        if(this.attempts<=3){
        int rem = 3-this.attempts;
        System.out.println("You have " + rem + "attempts remaining");
        this.attempts+=1;
        return this.validate_pin();
      }
      else{
        return false;
      }
      }

    }

    public void check_bal(){
      System.out.println("Your current Balance is " + this.Bal);
    }


    public void link_aadhar(){
      Scanner in = new Scanner(System.in);
      System.out.println("Enter aadhar number");
      String auth =in.nextLine();
      Boolean z = validate_pin();
      if(z==true){
        this.Aadhar = auth;
      }
      else{
        System.out.println("You have entered incorrect PIN many times. Try again later");
      }
    }



    public void set_pin(){
      Scanner in = new Scanner(System.in);
      Boolean z = validate_pin();
      if(z==true){
        System.out.println("Enter new Authentication PIN");
        this.pin = in.nextInt();
        System.out.println("Your PIN was sucessfully changed!Don't share this PIN without confirming the source");
      }

    }

      public void is_active(){
        if(this.alive==true){
          System.out.println("This Account is active");
        }
        else{
          System.out.println("This account isn't active");
        }
      }




    public void change_phone(){
      System.out.println("Your current Phone Number is " +this.phone);
      Scanner in = new Scanner(System.in);
      System.out.println("Enter new Phone Number");
      String ph = in.nextLine();
      Boolean z = validate_pin();
      if(z==true){
        this.phone = ph;
        System.out.println("Phone number changed!!");
      }
      else{
        System.out.println("You have entered incorrect PIN many times. Try again later");
      }

    }

    public void Freeze(){
      Boolean z = validate_pin();
      if(z==true){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 to credit free, 2 for debit freeze and 3 for deactivating account");
        int ch = in.nextInt();
        if(ch==1){
          this.cred_freeze=true;
        }
        else if(ch==2){
          this.deb_freeze=true;
        }
        else if(ch==3){
          this.alive = false;

        }
      }
      else{
        System.out.println("You have entered incorrect PIN many times. Try again later");
      }
    }



    public  void get_details(){
      System.out.println("Account Holder " + this.name);
      System.out.println("Address " + this.Address);
      System.out.println("phone " + this.phone);
      System.out.println("Balance " + this.Bal);
      System.out.println("DOB(DDMMYYYY) " + this.DOB);

    }

    public void withdraw(){

      if(deb_freeze==false){
        Scanner in  = new Scanner(System.in);
        double amt = in.nextDouble();
        if((amt<=this.Bal)&&(amt>0)&&(amt<=this.limit)){
          Boolean z = validate_pin();
          if(z==true){
            this.Bal-=amt;
            System.out.println("Account debited succesfully!! Remaining Balance "+this.Bal);
          }
          else{
            System.out.println("You have entered incorrect PIN many times. Try again later");
          }

        }
        else{
          System.out.println("Amount can't be debited! Try again and check all values and Transaction limit");
        }

      }
      else{
        System.out.println("Sorry! The account Seems to be in debit freeze mode.");
      }

    }

    public void deposit(){
      if(cred_freeze==false){
        Scanner in  = new Scanner(System.in);
        double amt = in.nextDouble();
        if(amt>0){
          Boolean z = validate_pin();
          if(z==true){
            this.Bal+=amt;
            System.out.println("Account deposited succesfully!! Remaining Balance "+this.Bal);
          }
          else{
            System.out.println("You have entered incorrect PIN many times. Try again later");
          }

        }

      }
      else{
        System.out.println("Sorry! The account Seems to be in credit freeze mode");
      }


    }

    public void get_interest(){
      if(this.interest_paid==false){
        this.Bal+=(this.Bal*rate_of_interest)/100;
        this.interest_paid=true;
        System.out.println("Interest credited succesfully");
      }
      else{
        System.out.println("Interest already credited");
      }

    }

    public void trans_limit(){
      Scanner in  = new Scanner(System.in);
      System.out.println("Your current trans_limit is "+ this.limit);
      System.out.println("Enter 1 to raise or 2 to lower");
      int choice= in.nextInt();
      if(choice==1){
        System.out.println("Enter new limit up to 1000000");
        long amt = in.nextLong();
        if(amt>0 && amt<=1000000){
          Boolean z = validate_pin();
          if(z==true){
            this.limit=amt;
            System.out.println("Transaction limit raised!! Your new limit is "+this.Bal);
          }
          else{
            System.out.println("You have entered incorrect PIN many times. Try again later");
          }

        }
        else{
          System.out.println("Unacceptable limit");
        }

      }
      else if(choice==2){
        System.out.println("Enter new limit, ");
        long amt = in.nextLong();
        if(amt>0 && amt<=1000000){
          Boolean z = validate_pin();
          if(z==true){
            this.limit=amt;
            System.out.println("Transaction limit lowered!! Your new limit is "+this.Bal);
          }
          else{
            System.out.println("You have entered incorrect PIN many times. Try again later");
          }

        }
        else{
          System.out.println("Unacceptable limit");
        }

      }
    }



    }

    static class loan{

      public void personal_loan(){
        System.out.println("enter the required loan amount");
        Scanner test = new Scanner(System.in);
        int amount = test.nextInt();
        if (amount>0)
        {
          System.out.println("loan amount will be processes after further verifications are over");

        }
        else
        {
          System.out.println("loan amount asked is incorrect");

        }
      }

      public void vehicle(){
        System.out.println("checking the eligibility for vehicle loan");
        Scanner hello = new Scanner(System.in);
        System.out.println("enter the amount of vehicle loan");
        int car_loan = hello.nextInt();
        System.out.println("enter the age");
        int age = hello.nextInt();
        System.out.println("enter the min net annual salary drawn");
        int salary = hello.nextInt();
        System.out.println("enter 1 for atleast 1 year of continuous employment");
        int condition = hello.nextInt();


        if(age>=21 && salary>=240000){
          if(condition == 1){
            System.out.println(" following loan can be approved for the vehicle"+car_loan);
          }
          else{
            System.out.println("the loan cannot be processed");
            System.out.println("due to not having min 1 year of continuous employment");

          }
        }
          else{
            System.out.println("loan cannot be processed terms and onditions are failed");
          }


      }

    public void gold_loan(){
      Scanner yes = new Scanner(System.in);
      System.out.println("press 1 if passport is valid or else 0 if not having or expired");
      int pass = yes.nextInt();
      System.out.println("press 1 if driving license is not expired else 0");
      int dl = yes.nextInt();
      System.out.println("press 1 if having voter id card");
      int v_id = yes.nextInt();
      System.out.println("press 1 if having pan card and form 60 filled");
      int pan = yes.nextInt();
      if (pass==1 &&  dl==1){
        if(v_id==1 && pan==1){
          System.out.println("loan will be processed shortly ater verifying the gold taken and amount will be told shortly");

        }
        else{
          System.out.println("error with voter id or pan card or both");

        }

      }else
      {
        System.out.println("error with passport or driving license or both");

      }

    }
    public void lap(){
      Scanner hie = new Scanner(System.in);
      System.out.println("enter the age of the borrower");
      int age = hie.nextInt();
      if (age>=24 && age<=65){
        System.out.println("enter the amount of loan");
        int amount = hie.nextInt();
        if(amount>=500000 || amount<=50000000){
          System.out.println("proof of identity needs to be processed");
          System.out.println("enter 1 if u have any of the following that is voter id card or driving license or pan card or employee card or govt department id card else 0");
          int identity = hie.nextInt();
          System.out.println("proof of income needs to be checked");
          System.out.println("press 1 if submitted last 6 months bank statement else 0");
          int income = hie.nextInt();
          System.out.println("press 1 if submitted any proof of residence else 0 ");
          int proof = hie.nextInt();
          System.out.println("press 1 if itr for last 2 years submitted else 0 ");
          int itr = hie.nextInt();
          if(identity==1 && income==1){
            if(proof==1 && itr==1){
              System.out.println("loan will be processed shortly");

            }
            else {
              System.out.println("loan cannot be processed due to no itr or not having proof of residence ");

            }
          }else{
            System.out.println("loan cannot be processed");
            System.out.println("due to lack of identity proof or income proof or both");

          }

        }else{
          System.out.println("amount asked is too small or too large than the limits set");
        }
      }else{
        System.out.println("sorry your age is not eligible for the loan");
      }
    }


  }



  public static void main(String args[]){

    Boolean login = true;
    SavingsAccount acc = new SavingsAccount();

    while(login==true){
    System.out.printf("%n%nWelcome to XYZ Bank portal. Enter your choice%n1.Get account info%n2.Link Aadhar%n3.Withdraw money%n4.Deposit Money%n5.Check Transaction Limit%n6.Check Balance%n7.Change PIN%n8.Loans");
    System.out.printf("%n9.Freeze Account%n10.Check Account Status%n11.Quit Portal");
    Scanner in = new Scanner(System.in);
    int choice = in.nextInt();
    switch(choice){
      case 1:
        acc.get_details();

        break;
      case 2:
        acc.link_aadhar();
        break;
      case 3:
        acc.withdraw();
        break;
      case 4:
        acc.deposit();
        break;
      case 5:
        acc.trans_limit();
        break;
      case 6:
        acc.check_bal();
        break;
      case 7:
        acc.set_pin();
        break;
      case 8:
        loan l1 = new loan();
        System.out.println("%nWelcome to Loan Central. Enter your choice");
        System.out.printf("1.Personal Loan%n2.Vehicle Loan%n3.gold_loan%n4.Lap%n");
        int lchoice = in.nextInt();
        switch(lchoice){
          case 1:
          l1.personal_loan();
          break;
          case 2:
          l1.vehicle();
          break;
          case 3:
          l1.gold_loan();
          break;
          case 4:
          l1.lap();
          break;
          default:
          break;

        }
        break;
      case 9:
        acc.Freeze();
        break;
      case 10:
        acc.is_active();
        break;
      case 11:
        login=false;
        break;

      default:
        break;

    }

  }

  }

}
