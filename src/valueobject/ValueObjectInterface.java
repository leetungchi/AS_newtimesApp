package valueobject;
import java.util.Vector;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public interface ValueObjectInterface {
  public  Record getRecord();
  public  Vector getComponents();
}