
package project;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Project 
{

    
    public static void main(String[] args) 
    {
        Customer customer = new Customer();
        CheckingAccount A1 = new CheckingAccount(00001,5678,123456789,300);
        CheckingAccount A2 = new CheckingAccount(00002,4567,234567890,4000);
        CheckingAccount A3 = new CheckingAccount(00003,3456,345678901,70);
        CheckingAccount A4 = new CheckingAccount(00004,2345,456789012,5000);
        
        SavingsAccount S1 = new SavingsAccount(10001,1234,567890123,700);
        SavingsAccount S2 = new SavingsAccount(10002,0123,234567890,2000);
        SavingsAccount S3 = new SavingsAccount(10003,6789,789012345,9000);
        SavingsAccount S4 = new SavingsAccount(10004,7890,890123456,1000 );
        
        customer.CheckingAccount_numbers(A1);
        customer.CheckingAccount_numbers(A2);
        customer.CheckingAccount_numbers(A3);
        customer.CheckingAccount_numbers(A4);
        
        customer.SavingsAccount_numbers(S1);
        customer.SavingsAccount_numbers(S2);
        customer.SavingsAccount_numbers(S3);
        customer.SavingsAccount_numbers(S4);
        
        int choice = 0;
        boolean test = true;
        Scanner scan = new Scanner(System.in);
        
        if(customer.validate_pin())
        {
            while(test)
            {
                while(true)
                {
                    choice = 0;
                    System.out.println("");
                    System.out.println("Welcome!");
                    System.out.println("What would you like to do? Enter the corresponding number for the action you want");
                    System.out.println("");
                    System.out.println("1 - Deposit to account");
                    System.out.println("2 - Withdraw from account");
                    System.out.println("3 - Check the balance of your account");
                    System.out.println("4 - Transfer funds between accounts");
                    System.out.println("5 - View last deposit amount");
                    System.out.println("6 - Cancel transaction");
                    try
                    {
                    choice = scan.nextInt();
                    break;
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("");
                        System.out.println("Your input was not recognized, make sure it is only a number from the choices");
                        scan.next();
                    }
                }
                switch(choice)
                {
                    case 1: customer.Deposit();
                    break;
                    case 2: customer.Withdraw();
                    break;
                    case 3: customer.Check_Balance();
                    break;
                    case 4: customer.Transfer_funds();
                    break;
                    case 5: customer.Last_Deposit();
                    break;
                    case 6: System.out.println("Goodbye");
                    test = false;
                    break;
                    
                }
            }
        }
        
        
        
        
        
        
        
        
    }
    
}
