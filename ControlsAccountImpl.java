
import Kamarad.*;
import java.util.*;
import java.io.*;

public class ControlsAccountImpl extends Kamarad._ControlsAccountImplBase {

  private Dictionary _accountsTable = new Hashtable ();
  private Random _random = new Random ();

  public ControlsAccountImpl () {
    super ();
    System.out.println ("Created ControlsAccount Server");
  }

  public synchronized Kamarad.Account returnAccount(int number) {
    this.load();
    // Lookup the account in the account dictionary.
    Kamarad.Account account = (Kamarad.Account) _accountsTable.get (number);
    // If the account is not in the dictionary, create an account.
    if (account == null) {
     // Create the account implementation, given the balance.
     account = new AccountImpl(number);
     // Make the object available to the ORB. 
     // Export the newly created object 
     _orb ().connect (account);
     System.out.println ("Created new register for " + number);
     // Save the account in the account dictionary.
     _accountsTable.put (number, account); 
    }
    // Return the account.
    this.save();
    return account; 
  }

  public synchronized Kamarad.Account topUp(int number, float amount) {
    this.load();
    // Lookup the account in the account dictionary.
    Kamarad.Account account = (Kamarad.Account) _accountsTable.get (number);
    if(account == null) {
      System.out.println ("Account does not exist.");
      return null;
    } else if(amount < 0) {
      System.out.println ("The amount must be a positive value");
      return null;
    } else {
      account.setBalance(account.getBalance() + amount);
    }
    // Return the account.
    this.save();
    return account;
  }

  public synchronized Kamarad.Account transfer(int numberOrig, float amount, int numberDest) {
    this.load();
    // Lookup the account in the account dictionary.
    Kamarad.Account accountOrig = (Kamarad.Account) _accountsTable.get (numberOrig);
    Kamarad.Account accountDest = (Kamarad.Account) _accountsTable.get (numberDest);
    if(accountOrig == null) {
      System.out.println ("Source account does not exist.");
      return null;
    } else if(accountOrig.getBalance() < amount) {
      System.out.println ("Source account does not have enough credit.");
      return null;
    } else if(accountDest == null) {
      System.out.println ("Destination account does not exist.");
      return null;
    } else {
      accountOrig.setBalance(accountOrig.getBalance() - amount);
      accountDest.setBalance(accountDest.getBalance() + amount);
    }
    this.save();
    // Return the account. 
    return accountOrig; 
  }

  public synchronized Kamarad.Account buyExtraOprion(int number, int option) {
    this.load();
    // Lookup the account in the account dictionary.
    Kamarad.Account account = (Kamarad.Account) _accountsTable.get (number);

    switch (option){
      case 1: // Option for top up
        account.setBalance(account.getBalance() - 2);
        account.setKamaradTalkKamarad100(account.getKamaradTalkKamarad100() + 100);
        break;
      case 2: // Option for transfer credit
        account.setBalance(account.getBalance() - 8);
        account.setKamaradTalkKamarad500(account.getKamaradTalkKamarad500() + 500);
        break;
      case 3:  // Option for buy extra options
        account.setBalance(account.getBalance() - 5);
        account.setKamaradTalkEveryone100(account.getKamaradTalkEveryone100() + 100);
        break;
      case 4:  // Option for view credit
        account.setBalance(account.getBalance() - 20);
        account.setKamaradTalkEveryone500(account.getKamaradTalkEveryone500() + 500);
        break;
      case 5:  // Option for view credit
        account.setBalance(account.getBalance() - 10);
        account.setKamaradInternet1GB(account.getKamaradInternet1GB() + 1000);
        break;
      case 6:  // Option for view credit
        account.setBalance(account.getBalance() - 1);
        account.setKamardText300(account.getKamardText300() + 300);
        break;
      case 7:  // Option for view credit
        account.setBalance(account.getBalance() - 10);
        account.setKamaradInternational100(account.getKamaradInternational100() + 100);
        break;
      default: 
        System.out.println("Invalid option!");
        break;
    }

    // Return the account.
    this.save();
    return account;
  }

  private void save() {
    try{
      FileOutputStream fos = new FileOutputStream("accounts.db");
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(_accountsTable);
      oos.close();  
    }catch(Exception ex){
      ex.printStackTrace();
   }
  }

  private void load() {
    try{
      FileInputStream fin = new FileInputStream("accounts.db");
      ObjectInputStream ois = new ObjectInputStream(fin);
      _accountsTable = (Hashtable) ois.readObject();
    }catch(Exception ex){
      ex.printStackTrace();
   }
  }

  
}