import java.util.Scanner;

class BankAccount{
    double balance;
    BankAccount(double startingBalance){
        balance=startingBalance;
    }
    double getBalance(){
        return balance;
    }
    void deposit(double amount){
        balance = balance + amount;
        System.out.println("Amount deposited successfully.");
    }
    boolean withdraw(double amount){
        if(amount>balance){
            return false;
        }
        else{
            balance=balance-amount;
            return true;
        }
    }
}

class ATM{
    BankAccount account;
    Scanner sc;
    ATM(BankAccount acc){
        account=acc;
        sc=new Scanner(System.in);
    }
    
    void showMenu(){
        int choice=0;
        while(choice!=4){
            System.out.println("");
            System.out.println("----ATM MENU----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            
            if(choice==1){
                System.out.println("Your balance is "+account.getBalance());
            }
            else if(choice==2){
                System.out.println("Enter amount to deposit:");
                double amt=sc.nextDouble();
                account.deposit(amt);
                System.out.println("New balance is "+account.getBalance());
            }
            else if(choice==3){
                System.out.println("Enter amount to withdraw:");
                double amt=sc.nextDouble();
                boolean flag=account.withdraw(amt);
                if(flag==true){
                    System.out.println("Withdrawal successful.");
                    System.out.println("New balance is "+account.getBalance());
                }
                else{
                    System.out.println("Insufficient balance!");
                }
            }
            else if(choice==4){
                System.out.println("Thank you for using the ATM. Goodbye!");
            }
            else{
                System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

public class ATMinterface{
    public static void main(String[] args){
        BankAccount myacc=new BankAccount(1000.0);
        ATM atm=new ATM(myacc);
        atm.showMenu();
    }
}
