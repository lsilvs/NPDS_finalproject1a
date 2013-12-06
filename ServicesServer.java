
// The package containing our stubs.
import Kamarad.*;
import org.omg.CORBA.*;
import java.io.*;


public class ServicesServer {
	public static void main(String args[]) {

		try {
			//Initialize the ORB
			ORB orb = ORB.init(args, null);
			//Instantiate the ControlsAccountImpl on the server
			ControlsAccountImpl charityRef = new ControlsAccountImpl();
			//Connect the ControlsAccountImpl to the orb
			orb.connect(charityRef);
			//Store an object Reference to the ControlsAccountImpl in a String format
			String ior = orb.object_to_string(charityRef);
			//Write the object reference to the ControlsAccountImpl to a file called CharityIOR
			FileOutputStream fos = new FileOutputStream("KamaradIOR");
			PrintStream ps = new PrintStream(fos);
			ps.print(ior);
			ps.close();

			//Run the orb so that it waits for requests from the client
			orb.run();

		}
		catch(Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}
}
