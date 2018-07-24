package newtimes.preproduction.guis;
import newtimes.preproduction.process.*;
import java.awt.*;
import javax.swing.JPanel;
import exgui.*;
import java.awt.event.*;
import exgui.ultratable.*;
import database.datatype.Record;
import javax.swing.JLabel;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListOrgClib extends JPanel {
  JLabel lblClickToSelect = new JLabel();
  PagedTablePanel orgColorLIbList = null;

  public PnlListOrgClib(
      PagedDataFactory db,int rowcount,util.InsertionOrderedHashMap iso
      ) {
    try {
      orgColorLIbList=new PagedTablePanel(db,rowcount,iso,new java.util.Hashtable());
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  void jbInit() throws Exception {
    lblClickToSelect.setText("Click To Select Defined Color Lib ,And to add to Preprod Clib list");
    lblClickToSelect.setBounds(new Rectangle(8, 7, 606, 29));
    this.setLayout(null);
    orgColorLIbList.setBackground(Color.lightGray);
    orgColorLIbList.setBounds(new Rectangle(8, 56, 575, 250));
    orgColorLIbList.getJtable().addMouseListener(new PnlListOrgClib_orgColorLIbList_mouseAdapter(this));
    this.add(lblClickToSelect, null);
    this.add(orgColorLIbList, null);
    setBackground(new Color(204, 204, 225));
  }

  void orgColorLIbList_mouseClicked(MouseEvent e) {
    int rowAt=orgColorLIbList.getJtable().getSelectedRow();
    if(rowAt<0)return;
    Record rec=(Record)orgColorLIbList.getDisplayingRecords().get(rowAt);
    try{
      newtimes.preproduction.Constants.SELECTED_ORG_COLOR_LIB_RECORD=
          DB_ColorLib.getInstance().getRecordByPk(rec.getInt(0));
      Object millNo=rec.get("J_MILL_NO");
      newtimes.preproduction.Constants.TEMP_MILL_MTRL_NO="";
      if(millNo!=null)newtimes.preproduction.Constants.TEMP_MILL_MTRL_NO=millNo.toString();
      /*
      newtimes.preproduction.Constants.SELECTED_ORG_COLOR_LIB_RECORD
      is a flag for furthur PreprodColorLib editing.
      if it's null,means edit.
      if it's not null,copy its' content into blank PreprodColorLib record
      and goto insert mode for proprod color lib editing panel
      */
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
         new newtimes.preproduction.process.TgrEditPrePrdColorLib()
      );
    }catch(Exception ee ){
      ee.printStackTrace();
    }

  }

}

class PnlListOrgClib_orgColorLIbList_mouseAdapter extends java.awt.event.MouseAdapter {
  PnlListOrgClib adaptee;

  PnlListOrgClib_orgColorLIbList_mouseAdapter(PnlListOrgClib adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.orgColorLIbList_mouseClicked(e);
  }
}