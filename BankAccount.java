import java.util.ArrayList;
import java.lang.Math;

public class BankAccount{
    private static int totAccounts;
    private static double inVault;
    private double checking;
    private double savings;
    private long accountNumber;

    private long generateAccNumber(){
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        return number;
    }
    public BankAccount showInfo(){
        System.out.println(String.format("account: %s\n checking: $%s\n savings: $%s\n", this.accountNumber, this.checking, this.savings));
        return this;
    }
    public static void totAccounts(){
        System.out.println(String.format("Total Bank Accounts: %s", totAccounts));
    }
    public static void inVault(){
        System.out.println(String.format("In the vault there is $%s.", Math.round(inVault*100.0)/100.0));
    }

    public BankAccount(){
        this.checking = 0;
        this.savings = 0;
        this.accountNumber = this.generateAccNumber();
        totAccounts++;
    }
    public double getChecking(){
        return Math.round(this.checking*100.0)/100.0;
    }
    public double getSavings(){
        return Math.round(this.savings*100.0)/100.0;
    }
    public double getAccountTotal(){
        return Math.round((this.checking + this.savings)*100.0)/100.0;
    }

    public BankAccount deposit(String account, double sum){
        switch(account){
            case "checking":
                this.checking += sum;
                break;
            case "savings":
                this.savings += sum;
                break;
        }
        inVault += sum;
        return this;
    }
    public BankAccount withdraw(String account, double sum){
        switch(account){
            case "checking":
                if(this.checking > sum){
                    this.checking -= sum;
                    inVault -= sum;
                }
                break;
            case "savings":
                if(this.savings > sum){
                    this.savings -= sum;
                    inVault -= sum;
                }
                break;
        }
        return this;
    }

}