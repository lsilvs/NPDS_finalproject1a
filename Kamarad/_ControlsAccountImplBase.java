package Kamarad;


/**
* Kamarad/_ControlsAccountImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from kamarad.idl
* Saturday, December 7, 2013 1:32:06 AM GMT
*/

public abstract class _ControlsAccountImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements Kamarad.ControlsAccount, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _ControlsAccountImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("returnAccount", new java.lang.Integer (0));
    _methods.put ("topUp", new java.lang.Integer (1));
    _methods.put ("transfer", new java.lang.Integer (2));
    _methods.put ("buyExtraOprion", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Kamarad/ControlsAccount/returnAccount
       {
         int number = in.read_long ();
         Kamarad.Account $result = null;
         $result = this.returnAccount (number);
         out = $rh.createReply();
         Kamarad.AccountHelper.write (out, $result);
         break;
       }

       case 1:  // Kamarad/ControlsAccount/topUp
       {
         int number = in.read_long ();
         float amount = in.read_float ();
         Kamarad.Account $result = null;
         $result = this.topUp (number, amount);
         out = $rh.createReply();
         Kamarad.AccountHelper.write (out, $result);
         break;
       }

       case 2:  // Kamarad/ControlsAccount/transfer
       {
         int numberOrig = in.read_long ();
         float amount = in.read_float ();
         int numberDest = in.read_long ();
         Kamarad.Account $result = null;
         $result = this.transfer (numberOrig, amount, numberDest);
         out = $rh.createReply();
         Kamarad.AccountHelper.write (out, $result);
         break;
       }

       case 3:  // Kamarad/ControlsAccount/buyExtraOprion
       {
         int number = in.read_long ();
         int option = in.read_long ();
         Kamarad.Account $result = null;
         $result = this.buyExtraOprion (number, option);
         out = $rh.createReply();
         Kamarad.AccountHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Kamarad/ControlsAccount:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _ControlsAccountImplBase
