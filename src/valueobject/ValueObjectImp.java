package valueobject;
import database.datatype.Record;
import java.util.Vector;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ValueObjectImp implements ValueObjectInterface,java.io.Serializable {
  protected Record _rec;
  protected Vector attributes;
  protected ValueObjectImp(Record rec) {
    _rec=rec;
    attributes=new Vector();
  }
  public  Record getRecord(){return _rec;}
  public  Vector getComponents(){return attributes;}
}