package package123;
import java.util.Scanner;

public class Task2 {
	public static void main(String args[])
	{
		int a=3; // number of subjects
		int b=0;
		int per;
		int z;
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<a;i++) {
			System.out.println("Enter the marks : ");
			z=sc.nextInt();
			b=b+z;
			per=b/a;
			System.out.println("Sum of all subjects "+b);
			System.out.println("Percentage: "+per);
			if(per<55) {
				System.out.println("Failed");
			} else if(per>=55 && per<65) {
				System.out.println("C Grade");
			} else if(per>=65 && per<85) {
				System.out.println("B Grade");
			} else if(per>85 && per<100) {
				System.out.println("A++ Grade");
				
			} else {
				System.out.println("INVALID");
			}
		}
		sc.close();
	}
	

}


