
package project;


public class CheckingAccount extends Account
{
    CheckingAccount(int w,int x,int y,int z)
    {
        super(w,x,y,z);
    }
    int get_number()
    {
        return Account_Number;
    }
    int get_PIN()
    {
        return PIN_Number;
    }
    int get_balance()
    {
        return Balance;
    }
    void add_balance(int x)
    {
        Balance = Balance + x;
    }
    void withdraw_balance(int x)
    {
        Balance = Balance - x;
    }
    
}
