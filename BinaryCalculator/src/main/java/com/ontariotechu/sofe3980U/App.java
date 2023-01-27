package com.ontariotechu.sofe3980U;
import org.joda.time.LocalTime;
import java.util.Scanner;

public class App 
{
	/**
	* Main program:  The entry point of the program. The local time will be printed first,
	*      Then it will create two binary variables, add them and print the result.
	*
	* @param args: not used
	*/
    public static void main( String[] args )
    {
		Scanner scanner = new Scanner(System.in);
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Bitwise AND");
            System.out.println("4. Bitwise OR");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            if (choice == 5) {
                break;
            }

            System.out.print("Enter the first binary number: ");
            String binary1 = scanner.next();
            if (!isValidBinary(binary1)) {
                System.out.println("Invalid binary number. Please try again.");
                continue;
            }

            System.out.print("Enter the second binary number: ");
            String binary2 = scanner.next();
            if (!isValidBinary(binary2)) {
                System.out.println("Invalid binary number. Please try again.");
                continue;
            }

            Binary b1 = new Binary(binary1);
            Binary b2 = new Binary(binary2);
            switch (choice) {
                case 1:
                    Binary sum = Binary.add(b1, b2);
                    System.out.println("The sum is: " + sum.getValue());
                    break;
                case 2:
                    Binary product = Binary.multiply(b1, b2);
                    System.out.println("The product is: " + product.getValue());
                    break;
                case 3:
                    Binary and = Binary.and(b1, b2);
                    System.out.println("The result of bitwise AND is: " + and.getValue());
                    break;
                case 4:
                    Binary or = Binary.or(b1, b2);
                    System.out.println("The result of bitwise OR is: " + or.getValue());
					break;
					default:
					System.out.println("Invalid choice. Please try again.");
					
			}
		}
		System.out.println("Goodbye.");
		scanner.close();
	}
	private static boolean isValidBinary(String binary) {
    	for (char c : binary.toCharArray()) {
        	if (c != '0' && c != '1') {
            	return false;
        	}
    	}
    	return true;
	}
}