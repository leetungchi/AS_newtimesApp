package processhandler.template;
import database.datatype.Record;
/**
 * <p>Title: The GUI to Show detail data of selected data</p>
 * <p>Description:The GUI to Show detail data of selected data</p>
 * It's parent class of GUI of ADD/Edit master or detail data.
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

abstract public class DetailDataGUI extends javax.swing.JPanel implements processhandler.DataProcesser{
  protected Record recToMapping;
  //protected boolean readyToUpdate; directly return from child class
  public DetailDataGUI(){super();}
  public void exitCurrentGui(){}
  public DetailDataGUI(Record rec) {
     super();
     recToMapping=rec;
  }
}
