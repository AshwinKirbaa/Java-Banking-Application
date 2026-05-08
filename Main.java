import java.util.*;

class Account {
  String username;
  String pin;
  double balance;

  Account(String username, String pin) {
    this.username = username;
    this.pin = pin;
    this.balance = 0;
  }

  void deposit(double amount) {
    balance += amount;
    System.out.println("Balance: " + balance);
  }

  void withdraw(double amount) {
    if (balance < amount) {
      System.out.println("Insufficient Balance");
    } else {
      balance -= amount;
      System.out.println("Balance: " + balance);
    }
  }

  void checkBalance() {
    System.out.println("Balance: " + balance);
  }
}

class User {

  static void signup(Scanner sc, ArrayList<Account> accounts) {
    System.out.print("Enter Username: ");
    String user = sc.nextLine();

    System.out.print("Enter Pin: ");
    String pin = sc.nextLine();

    accounts.add(new Account(user, pin));
    System.out.println("Account Created Successfully!");
  }

  static void login(Scanner sc, ArrayList<Account> accounts) {
    System.out.print("Enter Username: ");
    String user = sc.nextLine();

    System.out.print("Enter Pin: ");
    String pin = sc.nextLine();

    for (Account acc : accounts) {
      if (acc.username.equals(user) && acc.pin.equals(pin)) {
        System.out.println("Login Successful!");
        bankingMenu(sc, acc);
        return;
      }
    }

    System.out.println("Invalid Credentials");
  }

  static void bankingMenu(Scanner sc, Account acc) {
    while (true) {
      System.out.println("\n1. Balance");
      System.out.println("2. Deposit");
      System.out.println("3. Withdraw");
      System.out.println("4. Logout");

      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          acc.checkBalance();
          break;

        case 2:
          System.out.print("Amount: ");
          acc.deposit(sc.nextDouble());
          break;

        case 3:
          System.out.print("Amount: ");
          acc.withdraw(sc.nextDouble());
          break;

        case 4:
          sc.nextLine();
          return;

        default:
          System.out.println("Invalid Choice");
      }
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Account> accounts = new ArrayList<>();

    while (true) {
      System.out.println("\n1. Signup");
      System.out.println("2. Login");
      System.out.println("3. Exit");

      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          User.signup(sc, accounts);
          break;

        case 2:
          User.login(sc, accounts);
          break;

        case 3:
          System.out.println("Exiting...");
          return;

        default:
          System.out.println("Invalid Choice");
      }
    }
  }
}