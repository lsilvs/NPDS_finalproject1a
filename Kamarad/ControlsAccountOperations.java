package Kamarad;


/**
* Kamarad/ControlsAccountOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from kamarad.idl
* Saturday, December 7, 2013 1:32:06 AM GMT
*/

public interface ControlsAccountOperations 
{
  Kamarad.Account returnAccount (int number);
  Kamarad.Account topUp (int number, float amount);
  Kamarad.Account transfer (int numberOrig, float amount, int numberDest);
  Kamarad.Account buyExtraOprion (int number, int option);
} // interface ControlsAccountOperations
