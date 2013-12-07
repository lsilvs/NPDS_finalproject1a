// Required imports
import Kamarad.*;
import org.omg.CORBA.*;
import java.io.*;

public class ServicesClient {
	public static void main(String args[]) {
		try {

			//Initialize the ORB
			ORB orb = ORB.init(args, null);
			//Read the object Reference for the ControlsAccountServant
			BufferedReader br = new BufferedReader(new FileReader("KamaradIOR"));
			String ior = br.readLine();
			//Convert the string object reference to an object
			org.omg.CORBA.Object obj = orb.string_to_object(ior);
			//Convert the object to the correct type i.e. ControlsAccount
			ControlsAccount servicesRef = ControlsAccountHelper.narrow(obj);


			Console console = System.console(); // Initialize console to get user option
			int mobileNumber = 0; // Initialize var
			String password = ""; // Initialize var
			int input = 0; // Initialize var
			String inputStr; // Initialize var

			if(args[0] == null) {
				System.out.println("Param missing");
			}
			mobileNumber = Integer.parseInt(args[0]);
			float amount;

			// inputStr = console.readLine("Password:");
			// password = inputStr.trim();

			Kamarad.Account account = servicesRef.returnAccount(mobileNumber);

			//Shows options to user
			System.out.println("Choose one of the following options:");
			System.out.println("1 for Top Up Credit");
			System.out.println("2 for Transfer Credit to Other Mobile Numbers");
			System.out.println("3 for Buy Extra Options");
			System.out.println("4 for View Credit Balance");
			System.out.println("9 for Exit");
			System.out.println("===============================================");
			System.out.println("");

			// Iterate while user do not select exit option (9)
			while	(input != 9) {
				// Ask user for option
				inputStr = console.readLine("Enter input:");
				input = Integer.parseInt(inputStr.trim());

				switch (input){
	        case 1: // Option for top up
	        	amount = Float.parseFloat(console.readLine("Amount:"));
	        	account = servicesRef.topUp(account.getNumber(), amount);
	        	if(account == null) System.out.println("action failled!");
	        	break;
	        case 2: // Option for transfer credit
	        	amount = Float.parseFloat(console.readLine("Amount:"));
	        	mobileNumber = Integer.parseInt(console.readLine("Destination number:"));
	        	account = servicesRef.transfer(account.getNumber(), amount, mobileNumber);
	        	break;
	        case 3:  // Option for buy extra options
	        	System.out.println("===============================================");
	        	System.out.println("Which option do you want to buy?");
						System.out.println("1 for Kamarad Talk Kamarad 100 for €2");
						System.out.println("2 for Kamarad Talk Kamarad 500 for €8");
						System.out.println("3 for Kamarad Talk Everyone 100 for €5");
						System.out.println("4 for Kamarad Talk Everyone 500 for €20");
						System.out.println("5 for Kamarad Internet 1GB for €10");
						System.out.println("6 for Kamarad Text 300 for €1");
						System.out.println("7 for Kamarad International 100 for €10");
						System.out.println("===============================================");
	        	int option = Integer.parseInt(console.readLine("Option:"));
	        	account = servicesRef.buyExtraOprion(account.getNumber(), option);
	        	break;
	        case 4:  // Option for view credit
	        	System.out.println("Total Credit: " + account.getBalance());
	        	break;
	        case 9:  // Option to exit
	        	break;
	        default: 
	        	System.out.println("your input is invalid!");
	        	break;
	    	}
			}

		// exit message
		System.out.println("bye!");
		}
		catch(Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}
}