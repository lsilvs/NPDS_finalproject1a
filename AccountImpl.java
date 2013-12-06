import Kamarad.*;
import java.util.*;

class AccountImpl extends Kamarad._AccountImplBase {
	private int _number;
	private float _balance;

	public AccountImpl (int number) {
		super ();
		_number = number;
		_balance = 0;
		System.out.println ("Created Account Server");
	}

	public float getBalance () { return _balance; }

	public void setBalance (float amount) { 
		_balance = amount; 
	}

	public int getNumber () { return _number; }

	public void setNumber (int number) { 
		_number = number; 
	}
}