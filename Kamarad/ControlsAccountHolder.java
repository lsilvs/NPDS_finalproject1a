package Kamarad;

/**
* Kamarad/ControlsAccountHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from kamarad.idl
* Saturday, December 7, 2013 1:32:06 AM GMT
*/

public final class ControlsAccountHolder implements org.omg.CORBA.portable.Streamable
{
  public Kamarad.ControlsAccount value = null;

  public ControlsAccountHolder ()
  {
  }

  public ControlsAccountHolder (Kamarad.ControlsAccount initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Kamarad.ControlsAccountHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Kamarad.ControlsAccountHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Kamarad.ControlsAccountHelper.type ();
  }

}
