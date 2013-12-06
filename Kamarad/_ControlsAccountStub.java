package Kamarad;


/**
* Kamarad/_ControlsAccountStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from kamarad.idl
* Friday, December 6, 2013 5:40:56 PM GMT
*/

public class _ControlsAccountStub extends org.omg.CORBA.portable.ObjectImpl implements Kamarad.ControlsAccount
{

  public Kamarad.Account returnAccount (int number)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("returnAccount", true);
                $out.write_long (number);
                $in = _invoke ($out);
                Kamarad.Account $result = Kamarad.AccountHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return returnAccount (number        );
            } finally {
                _releaseReply ($in);
            }
  } // returnAccount

  public Kamarad.Account topUp (int number, float amount)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("topUp", true);
                $out.write_long (number);
                $out.write_float (amount);
                $in = _invoke ($out);
                Kamarad.Account $result = Kamarad.AccountHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return topUp (number, amount        );
            } finally {
                _releaseReply ($in);
            }
  } // topUp

  public Kamarad.Account transfer (int numberOrig, float amount, int numberDest)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("transfer", true);
                $out.write_long (numberOrig);
                $out.write_float (amount);
                $out.write_long (numberDest);
                $in = _invoke ($out);
                Kamarad.Account $result = Kamarad.AccountHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return transfer (numberOrig, amount, numberDest        );
            } finally {
                _releaseReply ($in);
            }
  } // transfer

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Kamarad/ControlsAccount:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ControlsAccountStub
