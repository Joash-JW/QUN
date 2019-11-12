package backend.applogic;

import java.util.HashMap;
import java.util.Scanner;

public class TransactionProcessor {
    
    private static void executeAppropriateTransaction(ArrayList<String[]> transList) {
        
        for (String[] t : transList) {
            int toAccNum = Integer.parseInt(tranMsg[1]);
            int fromAccNum = Integer.parseInt(tranMsg[2]);
            int amount = Integer.parseInt(tranMsg[3]);
            
            switch (tranMsg[0]) {
                case "DEP":
                    deposit(toAccNum, amount);
                    break;
                case "WDR":
                    withdraw(fromAccNum, amount);
                    break;
                case "XFR":
                    transfer(toAccNum, fromAccNum, amount);
                    break;
                case "NEW":
                    create(toAccNum, tranMsg[4]);
                    break;
                case "DEL":
                    delete(toAccNum, tranMsg[4]);
                    break;
                case "EOS":
                    break;
                default:
                    crash("Transaction summary code is incorrect.");
            }
        }
    }
    
    private static void create(int accNum, String accName) {
        if (findAccount(accNum) == null) {
            localMasterAccList.add(new Account(accNum, accName));
        } else {
            System.out.println("Transaction ignored. Account already exists.");
        }
    }
    
    private static void delete(int accNum, String accName) {
        Account a = findAccount(accNum);
        if (a != null) {
            if (a.getBalance() == 0 && a.getName().equals(accName)) {
                localMasterAccList.remove(a);
            } else {
                System.out.println("Transaction ignored. Delete conditions not met");
            }
        } else {
            System.out.println("Transaction ignored. Account does not exist.");
        }
    }
    
    private static void withdraw(int accNum, int amount) {
        Account a = findAccount(accNum);
        if (a != null) {
            int newBalance = a.getBalance() - amount;
            if (newBalance >= 0) {
                a.setBalance(newBalance);
            } else {
                System.out.println("Transaction ignored. " + accNum + " would have a negative balance.");
            }
        } else {
            System.out.println("Transaction ignored. Account does not exist.");
        }
    }
    
    private static void deposit(int accNum, int amount) {
        Account a = findAccount(accNum);
        if (a != null) {
            int newBalance = a.getBalance() + amount;
            if (newBalance <= 99999999) {
                a.setBalance(newBalance);
            } else {
                System.out.println("Transaction ignored. " + accNum + " would exceed max amount.");
            }
        } else {
            System.out.println("Transaction ignored. Account does not exist.");
        }
    }
    
    private static void transfer(int toAccNum, int fromAccNum, int amount) {
        Account fromAcc = findAccount(fromAccNum);
        if (fromAcc == null){
            System.out.println("Transaction ignored. Account does not exist.");
            return;
        } else if (fromAcc.getBalance() - amount < 0){
            System.out.println("Transaction ignored. " + fromAccNum + " would have a negative balance.");
            return;
        }
        
        Account toAcc = findAccount(toAccNum);
        if (toAcc == null) {
            System.out.println("Transaction ignored. Account does not exist.");
            return;
        } else if (toAcc.getBalance() + amount > 99999999) {
            System.out.println("Transaction ignored. " + toAccNum + " would exceed max amount.");
            return;
        }
        
        withdraw(fromAccNum, amount);
        deposit(toAccNum, amount);
    }
    
    
    private static Account findAccount(int accNum) {
        for (Account a : localMasterAccList) {
            if (accNum == a.getAccNum())
                return a;
        }
        return null;
    }
    
    private static void crash(String msg) {
        System.out.println(msg);
        System.exit(1);
    }
    
}
