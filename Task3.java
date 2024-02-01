package package123;
import java.util.Scanner;

public class Task3 {
	public static void main(String args[]) {
		int balance=5000;
		int withdraw;
		int deposit;
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Welcome to the ATM");
			System.out.println("Following are the options:");
			System.out.println("1.Check balance");
			System.out.println("2.Deposit money");
			System.out.println("3.Withdrawal of money");
			System.out.println("4.Exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1: System.out.println("Balance amount is "+balance);
			break;
			case 2:System.out.println("Amount to be deposited ");
			    deposit=sc.nextInt();
			    balance+=deposit;
			    System.out.println("Total balance after depositing is "+balance);
			    break;
			case 3:System.out.println("Amount you want to withdraw ");
			      withdraw=sc.nextInt();
			      if(withdraw>balance) {
			    	  System.out.println("Insufficient balance");
			      }
			      else {
			    	 
			      
			      balance-=withdraw;
			      }
			      
			      System.out.println("Total balance after withdrawal is "+balance);
			      break;
			case 4:System.out.println("Thank you!!!");
			System.exit(0);
			default:
				System.out.println("Invalid choice.Select again");
			     }
		
		}
		
	}
	

}

