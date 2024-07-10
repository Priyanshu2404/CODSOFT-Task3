import java.util.Scanner;
import java.util.*;

class Bank{                                     //BANK CLASS INCLUDING ALL OPTIONS LIKE CHECKING BALANCE,DEPOSITING AND WITHDRAWING MONEY
    private double balance;

    public Bank(double initial){
        if(initial>=0){
            this.balance = initial;
        }
        else{
            this.balance = 0;
        }
    }

    public double availablebalance(){
        return balance;
    }

    public boolean deposit(double amount){
        if(amount >0){
            balance = balance+amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance = balance-amount;
            return true;
        }
        return false;
    }
}

class ATM{                                           //ATM CLASS JOINING WITH BANNK CLASS TO PERFROM OPERATIONS FOR USER
    private final Bank youraccount;
    public ATM(Bank youraccount){
        this.youraccount = youraccount;
    }

    public void MAINMENU() {
        System.out.println("WELCOME TO THE ATM: ");
        System.out.println(" CHOOSE ANY ONE OPTION: ");
        System.out.println("1. CHECK YOUR BALANCE: ");
        System.out.println("2. DEPOSIT MONEY: ");
        System.out.println("3. WITHDRAW CASH: ");
        System.out.println("4. EXIT: ");
    }
     public void showbalance(){
         System.out.printf("Your account balance is: $%.2f%n", youraccount.availablebalance());
     }

     public void depositamount(double amount){
        if(youraccount.deposit(amount)){
            System.out.printf("Congratulations!! Money deposited . Your new balance is $ " +youraccount.availablebalance());
        }
        else{
            System.out.println("Invalid amount, please try again!!");
        }
     }

    public void withdrawamount(double amount){
        if(youraccount.withdraw(amount)){
            System.out.printf("Congratulations!! Money withdrawn. Your new balance is  $ " +youraccount.availablebalance());
        }
        else{
            System.out.println("Invalid amount/Insufficient balance, please try again!!");
        }
    }


    public void OPTIONS() {                                     //VARIOUS OPTIONS FOR USER TO CHOOSE
        Scanner sc = new Scanner(System.in);
        while (true) {
            MAINMENU();
            System.out.println("Enter your choice out of (1-4): ");
            int ch = sc.nextInt();
            if (ch == 1) {
                showbalance();
                break;
            } else if (ch == 2) {
                System.out.println("Enter the amount to be deposited: ");
                double amount = sc.nextDouble();
                depositamount(amount);
                break;
            } else if (ch == 3) {
                System.out.println("Enter the amount to be withdrawn: ");
                double amount = sc.nextDouble();
                withdrawamount(amount);
                break;
            } else if (ch == 4) {
                System.out.println("THANKS FOR VISITING: ");
                System.out.println("PLEASE VISIT AGAIN: ");
                System.out.println("HAVE A GREAT DAY: ");
                break;
            } else {
                System.out.println("INVALID CHOICE, CHOOSE AGAIN: ");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bank account = new Bank(50000.00);                     //INITIAL AMOUNT IN ACCOUNT
        ATM atm = new ATM(account);
        atm.OPTIONS();
    }
}
