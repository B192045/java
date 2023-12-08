import java.util.*;

interface Week7_2 {
    void credentialsCheck(String username, String password) throws InvalidCredentialsException;
    void credit(int amount);
    void debit(int amount) throws InsufficientException;
    void displayBalance();
}

class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}

class InsufficientException extends Exception {
    public InsufficientException(String message) {
        super(message);
    }
}

class Bankaccount implements Week7_2 {
    private String username;
    private String password;
    private int balance;

    Bankaccount(String username, String password, int balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public void credentialsCheck(String username, String password) throws InvalidCredentialsException {
        if (!this.username.equals(username) || !this.password.equals(password)) {
            throw new InvalidCredentialsException("Invalid username or password");
        } else {
            System.out.println("Correct details");
        }
    }

    public void credit(int amount) {
        balance = balance + amount;
        System.out.println(balance);
    }

    public void debit(int amount) throws InsufficientException {
        if (balance < amount) {
            throw new InsufficientException("Insufficient balance");
        } else {
            balance = balance - amount;
        }
    }

    public void displayBalance() {
        System.out.println(balance);
    }
}

public class Week {
    public static void main(String args[]) {
        Bankaccount b = new Bankaccount("aish", "a12", 1000);
        try {
            b.credentialsCheck("aish", "a12");
            b.credit(2000);
            b.debit(10000);
            b.displayBalance();
        } catch (InvalidCredentialsException | InsufficientException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
