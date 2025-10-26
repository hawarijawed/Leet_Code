/*
You have been tasked with writing a program for a popular bank that will automate all its incoming transactions (transfer, deposit, and withdraw). The bank has n accounts numbered from 1 to n. The initial balance of each account is stored in a 0-indexed integer array balance, with the (i + 1)th account having an initial balance of balance[i].

Execute all the valid transactions. A transaction is valid if:

The given account number(s) are between 1 and n, and
The amount of money withdrawn or transferred from is less than or equal to the balance of the account.
Implement the Bank class:

Bank(long[] balance) Initializes the object with the 0-indexed integer array balance.
boolean transfer(int account1, int account2, long money) Transfers money dollars from the account numbered account1 to the account numbered account2. Return true if the transaction was successful, false otherwise.
boolean deposit(int account, long money) Deposit money dollars into the account numbered account. Return true if the transaction was successful, false otherwise.
boolean withdraw(int account, long money) Withdraw money dollars from the account numbered account. Return true if the transaction was successful, false otherwise.
*/
class Bank {
    HashMap<Integer, Long> map = new HashMap<>();
    public Bank(long[] balance) {
        for(int i=0; i<balance.length; i++){
            map.put(i+1, balance[i]);
        }
        //System.out.println(map);
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(!map.containsKey(account1) || !map.containsKey(account2)){
            return false;
        }
        
        //System.out.println("** "+map.get(account1));
        //System.out.println("** "+map.get(account2));
        if(map.get(account1)< money){
            return false;
        }

        map.put(account1, map.get(account1)-money);
        map.put(account2, map.get(account2)+money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(!map.containsKey(account)){
            return false;
        }
        map.put(account, map.get(account)+money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(!map.containsKey(account)){
            return false;
        }

        if(map.get(account) < money){
            return false;
        }

        map.put(account, map.get(account)-money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
