public class TestBankAccount{
    public static void main(String[] args){
        System.out.println("---Account 1---");
        BankAccount ba1 = new BankAccount();
        System.out.println(String.format("checking: %s, savings: %s", ba1.getChecking(), ba1.getSavings()));
        ba1.showInfo().deposit("checking", 100).deposit("savings", 93.58).showInfo();

        System.out.println("---Account 2---");
        BankAccount ba2 = new BankAccount();
        System.out.println(String.format("checking: $%s, savings: $%s", ba2.getChecking(), ba2.getSavings()));
        ba2.showInfo().deposit("checking", 378.72).deposit("savings", 21.28).showInfo().withdraw("checking", 200).deposit("savings",200).showInfo();

        System.out.println("---Bank Data---");
        BankAccount.totAccounts();
        BankAccount.inVault();
    }
}