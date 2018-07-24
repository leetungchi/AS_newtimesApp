package newtimes.basic.destination;

import processhandler.template.PnlListQryRslt;
import javax.swing.JLabel;
import java.awt.BorderLayout;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListDestsWithButton extends PnlListQryRslt {
  public PnlListDestsWithButton(DB_Destinations pagedDataFxy,
        int rowCount,util.InsertionOrderedHashMap columnMapping,
        java.util.Hashtable object2StringConvertor,
        String titleStr1,
        String btnStr1
    ){
     super(pagedDataFxy,
           rowCount,
           columnMapping,
           object2StringConvertor,
           titleStr1,
           btnStr1);
     //myHander=pagedDataFxy;
     this.removeAll();
     this.add(new JLabel("Please click the rows"),BorderLayout.NORTH);
     this.add(this.pgTblList,BorderLayout.CENTER);
     //this.pgTblList.reload();
  }

}
