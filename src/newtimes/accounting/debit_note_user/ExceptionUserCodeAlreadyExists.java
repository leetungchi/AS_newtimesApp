package newtimes.accounting.debit_note_user;

public class ExceptionUserCodeAlreadyExists extends java.lang.Throwable {
  String usrCode;
  public ExceptionUserCodeAlreadyExists(String _usrCode) {
    usrCode=_usrCode;
  }
}
