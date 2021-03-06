
package project;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Customer
{
    ArrayList<CheckingAccount> Checkinglist = new ArrayList<>();
    ArrayList<SavingsAccount> Savingslist = new ArrayList<>();
    CheckingAccount test = new CheckingAccount(0,0,0,0);
    SavingsAccount test2 = new SavingsAccount(0,0,0,0);
    CheckingAccount transfer = new CheckingAccount(0,0,0,0);
    SavingsAccount transfer2 = new SavingsAccount(0,0,0,0);
    Scanner scan = new Scanner(System.in);
    int Account_Number;
    int PIN_Number;
    boolean check = false;
    boolean save = false;
    int last = 0;
    
    boolean validate_pin()
    {
        
        int counter = 0;
        while(counter < 3)
        {
            while(true)
            {
                try
                {
                    System.out.println("Please enter in your account number ");
                    Account_Number = scan.nextInt();
                    System.out.println("Now please enter in your PIN number ");
                    PIN_Number = scan.nextInt();
                    break;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Your input was not recognized, make sure it is a number only");
                    scan.next();
                }
            }
            if(get_CheckingAccount_numbers(Account_Number,PIN_Number) == true)
            {
                return true;
            }
            if(get_SavingsAccount_numbers(Account_Number,PIN_Number) == true)
            {
                return true;
            }
            System.out.println("The PIN and Account number do not match");
            counter = counter + 1;
        }
        System.out.println("You have reached the maximum number of attempts, goodbye.");
        return false;
    }
    void CheckingAccount_numbers(CheckingAccount x)
    {
        Checkinglist.add(x);
    }
    
    void SavingsAccount_numbers(SavingsAccount x)
    {
        Savingslist.add(x);
    }
    
    boolean get_CheckingAccount_numbers(int x, int a)
    {
        int y;
        int w; 
        int counter = 0;
        while(counter < Checkinglist.size())
        {
            test = Checkinglist.get(counter);
            y = test.get_number();
            if(x == y)
            {
                w = test.get_PIN();
                if(w == a)
                {
                    check = true;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            counter = counter + 1;
        }
        return false;
    }
    
    boolean get_SavingsAccount_numbers(int x, int a)
    {
        int y;
        int w; 
        int counter = 0;
        while(counter < Savingslist.size())
        {
            test2 = Savingslist.get(counter);
            y = test2.get_number();
            if(x == y)
            {
                w = test2.get_PIN();
                if(w == a)
                {
                    save = true;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            counter = counter + 1;
        }
        return false;
    }
    void Deposit()
    {
        int x;
        while(true)
        {
            try
            {
                System.out.println("How much would you like to deposit?");
                x = scan.nextInt();
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Your input was not recognized, make sure it is only a number");
                scan.next();
            }
        }
        if(check)
        {
            test.add_balance(x);
            last = x;
            System.out.println("Money deposited");
            System.out.println("Your account now has a balance of $"+test.get_balance());
        }
        else
        {
            test2.add_balance(x);
            last = x;
            System.out.println("Money deposited");
            System.out.println("Your account now has a balance of $"+test2.get_balance());
        }
        
        
    }

    void Withdraw()
    {
        
        int x;
        while(true)
        {
            try
            {
               System.out.println("Please enter in the amount you wish to withdraw");
               x = scan.nextInt();
               break;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Your input was not recognized, make sure it is only a number");
                scan.next();
            }
        }
        if(check)
        {
            if(test.get_balance() < x)
            {
                System.out.println("Sorry, there is not enough money in the account");
                System.out.println("Current balance = $"+test.get_balance());
            }
            else
            {
                test.withdraw_balance(x);
                System.out.println("Money Withdrawn");
                System.out.println("Your account now has a balance of $"+test.get_balance());
            }
        }
        else
        {
            if(test2.get_balance() < x)
            {
                System.out.println("Sorry, there is not enough money in the account");
                System.out.println("Current balance = $"+test2.get_balance());
            }
            else
            {
                test2.withdraw_balance(x);
                System.out.println("Money Withdrawn");
                System.out.println("Your account now has a balance of $"+test2.get_balance());
            }
        }
        
    }
    
    void Last_Deposit()
    {
        System.out.println("Your last deposit was $"+last);
    }
    
    void Check_Balance()
    {
        if(check)
        {
            System.out.println("Your account has a balance of $"+test.get_balance());
        }
        else
        {
            System.out.println("Your account has a balance of $"+test2.get_balance());
        }
    }
    
    void Transfer_funds()
    {
        boolean checkin = false;
        boolean savin = false;
        int Account_Number2;
        int amount;
        int counter = 0;
        int y;
        
            while(true)
            {
                try
                {
                    System.out.println("Please enter in the account number for the account you are transfering to, or 0 to cancel");
                    Account_Number2 = scan.nextInt();
                    break;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Your input was not recognized, make sure it is a number only");
                    scan.next();
                }
            }
            
            if(Account_Number2 == 0)
            {
                System.out.println("Transfer cancelled");
                return;
            }
            while(counter < Checkinglist.size())
            {
                transfer = Checkinglist.get(counter);
                y = transfer.get_number();
                if(y == Account_Number2)
                {
                    checkin = true;
                    break;
                }
                counter = counter+1;
            }
            counter = 0;
            while(counter < Savingslist.size())
            {
                transfer2 = Savingslist.get(counter);
                y = transfer2.get_number();
                if(y == Account_Number2)
                {
                    savin = true;
                    break;
                }
                counter = counter+1;
            }
            while(true)
            {
                try
                {
                    System.out.println("Please enter in the amount you wish to transfer, or 0 to cancel");
                    amount = scan.nextInt();
                    break;
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Your input was not recognized, make sure it is a number only");
                    scan.next();
                }
            }
            if(amount == 0)
            {
                System.out.println("Transfer cancelled");
                return;
            }
            
            if(check)
            {
                if(checkin)
                {
                    if(test.get_balance() < amount)
                    {
                        System.out.println("Sorry, there is not enough money in the account to transfer");
                        return;
                    }
                    test.withdraw_balance(amount);
                    transfer.add_balance(amount);
                    System.out.println("The first accounts new balance is $"+test.get_balance());
                    System.out.println("The second accounts new balance is $"+transfer.get_balance());
                    return;
                }
                if(savin)
                {
                    if(test.get_balance() < amount)
                    {
                        System.out.println("Sorry, there is not enough money in the account to transfer");
                        return;
                    }
                    test.withdraw_balance(amount);
                    transfer2.add_balance(amount);
                    System.out.println("The first accounts new balance is $"+test.get_balance());
                    System.out.println("The second accounts new balance is $"+transfer2.get_balance());
                }
                else
                {
                    System.out.println("Error: The account you are transfering to does not exist");
                }
            }
            
            else
            {
                if(checkin)
                {
                    if(test.get_balance() < amount)
                    {
                        System.out.println("Sorry, there is not enough money in the account to transfer");
                        return;
                    }
                    test2.withdraw_balance(amount);
                    transfer.add_balance(amount);
                    System.out.println("The first accounts new balance is $"+test2.get_balance());
                    System.out.println("The second accounts new balance is $"+transfer.get_balance());
                    return;
                }
                if(savin)
                {
                    if(test2.get_balance()<amount)
                    {
                        System.out.println("Sorry, there is not enough money in the account to transfer");
                        return;
                    }
                    test2.withdraw_balance(amount);
                    transfer2.add_balance(amount);
                    System.out.println("The first accounts new balance is $"+test2.get_balance());
                    System.out.println("The second accounts new balance is $"+transfer2.get_balance());
                }
                else
                {
                    System.out.println("Error: The account you are transfering to does not exist");
                }
            }
        
    }
}
