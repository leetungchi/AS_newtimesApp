package newtimes.preproduction.guis;

import java.awt.*;
import exgui.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlQryPprd4Restore extends PnlQryPPrd {
  BorderLayout borderLayout1 = new BorderLayout();
  JLabel whiteBkgBlueCharLabelX1 = new JLabel();
  JTextField txtRange = new JTextField();
  JLabel blueBkgWhiteCharLabelX1 = new JLabel();
  newtimesejb.preproduction.Preprod4Restore pprd4Restore=null;
  JTextField txtProtoNo = new JTextField();

  public PnlQryPprd4Restore() {
    super();
    try {
      myjbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
 protected void myjbInit() throws Exception {
    super.jbInit();
    super.cbxQcCountry.setVisible(false);
    super.cbxProdType.setVisible(false);
    super.jbtnAddNew.setVisible(false);
    super.lblQcCountry.setVisible(false);
    super.lblType.setVisible(false);
    /*
    super.txtStyPo.setVisible(false);
    super.txtStyStyle.setVisible(false);
    super.lblPoNo.setVisible(false);
    super.lblSytleNo.setVisible(false);
    super.lblAdtStats.setVisible(false);
    super.cbxAuditStatus.setVisible(false);
    */
  }
  protected void goCommand(){
    try{
      this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
          new newtimes.preproduction.process.TgrToListPreprod4Restore());
    }catch(Exception ie){
      ie.printStackTrace();
    }finally{
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
  }
}
