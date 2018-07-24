package newtimes.production.report;
import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import newtimes.preproduction.guis.*;
import java.util.HashMap;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlShipDeptWorkLoad
    //extends JPanel {
    extends AbsQryPanel {
     JTextField txtDateEnd = new JTextField();
     JLabel jLabel2 = new JLabel();
     JPanel pnlDuriation = new JPanel();
     JLabel blueBkgWhiteCharLabel3 = new JLabel();
     BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
     JLabel jLabel3 = new JLabel();
     JComboBox cbxCntr = new JComboBox();
     JButton btnQry = new JButton();
     JTextField txtDateBgn = new JTextField();
     Border border1;
     TitledBorder titledBorder1;
     ButtonGroup buttonGroup1 = new ButtonGroup();
     JRadioButton rdoTypeClotihng = new JRadioButton();
     JRadioButton rdoTypeSundry = new JRadioButton();
     //BorderLayout borderLayout1 = new BorderLayout();
     exgui.DataBindJCombobox DbJcbxcbxCntr;
     protected   DataBindTextWithChecker dbTxtDateBgn,dbTxtDateEnd;

     public PnlShipDeptWorkLoad() {
       try {
         //jbInit();
       } catch (Exception ex) {
         ex.printStackTrace();
       }
     }

     protected void jbInit() throws Exception {
       border1 = new EtchedBorder(EtchedBorder.RAISED, Color.white,
                                  new Color(141, 141, 156));
       titledBorder1 = new TitledBorder(border1, "ON BOARD DATE");
       pnlDuriation.setBackground(new Color(202, 202, 224));
       pnlDuriation.setBorder(titledBorder1);
       pnlDuriation.setBounds(new Rectangle(342, 45, 286, 53));
       pnlDuriation.setLayout(null);
       jLabel2.setText("FROM:");
       jLabel2.setBounds(new Rectangle(8, 19, 56, 21));
       txtDateEnd.setText("");
       txtDateEnd.setBounds(new Rectangle(187, 19, 87, 22));
       this.setLayout(null);
       blueBkgWhiteCharLabel3.setBounds(new Rectangle(10, 44, 60, 19));
       blueBkgWhiteCharLabel3.setText("Center");
       blueBkgWhiteCharLabel1.setText("SHIPPING DEPT. WORK LOAD");
       blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 11, 803, 28));
       jLabel3.setText("TO:");
       jLabel3.setBounds(new Rectangle(154, 19, 36, 24));
       cbxCntr.setBounds(new Rectangle(54, 46, 130, 22));
       btnQry.setBounds(new Rectangle(693, 57, 80, 27));
       btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
       btnQry.setText("REPORT");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
       txtDateBgn.setText("");
       txtDateBgn.setBounds(new Rectangle(52, 19, 87, 20));
       this.setBackground(new Color(202, 202, 224));
       rdoTypeClotihng.setBackground(new Color(202, 202, 224));
       rdoTypeClotihng.setFont(new java.awt.Font("Dialog", 1, 11));
       rdoTypeClotihng.setSelected(true);
       rdoTypeClotihng.setText("CLOTHING");
       rdoTypeClotihng.setBounds(new Rectangle(16, 87, 112, 25));
       rdoTypeSundry.setBounds(new Rectangle(131, 87, 112, 25));
       rdoTypeSundry.setText("SUNDRY");
       rdoTypeSundry.setFont(new java.awt.Font("Dialog", 1, 11));

       rdoTypeSundry.setBackground(new Color(202, 202, 224));
       pnlDuriation.add(jLabel2, null);
       pnlDuriation.add(txtDateBgn, null);
       pnlDuriation.add(txtDateEnd, null);
       pnlDuriation.add(jLabel3, null);
       this.add(rdoTypeSundry, null);
       this.add(rdoTypeClotihng, null);
       this.add(blueBkgWhiteCharLabel3, null);
       this.add(blueBkgWhiteCharLabel1, null);
       this.add(cbxCntr, null);
       this.add(btnQry, null);
       this.add(pnlDuriation, null);
       buttonGroup1.add(rdoTypeClotihng);
       buttonGroup1.add(rdoTypeSundry);
       genDataBindObj();
       reportName = "SHIP_BUY_MONTH.RPT";
     }

     public void genDataBindObj() {
       dataBindComps.clear();
       try {
         if (tempProperties.tmpCenters.size() > 1) {
           DbJcbxcbxCntr =
               new exgui.DataBindJCombobox(
               cbxCntr, "CENTER_CODE",
               tempProperties.tmpCenters,
               "CEN_NAME", "CEN_CODE",
               (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"),
               "'ALL'", null);
           dataBindComps.add(DbJcbxcbxCntr);
         } else {
           DbJcbxcbxCntr =
               new exgui.DataBindJCombobox(
               cbxCntr, "CENTER_CODE",
               tempProperties.tmpCenters,
               "CEN_NAME", "CEN_CODE",
               (String)util.PublicVariable.USER_RECORD.get("usr_cen_code"));
           dataBindComps.add(DbJcbxcbxCntr);
         }

         //default begin datae is first day of current mount
         java.util.Calendar cld = java.util.Calendar.getInstance();
         cld.set(cld.MONTH,cld.JANUARY );
         cld.set(cld.DATE, 1);
         java.util.Date dFrom = cld.getTime();
         cld.set(cld.MONTH,cld.DECEMBER);
         cld.set(cld.DATE, 31);
         java.util.Date dEnd = cld.getTime();
         //default end date is end day of currecnt mount

         Object dateVfy = exgui.verification.CellFormat.
             getDateStringFormaterAllowNull();
         dbTxtDateBgn =
             new exgui.DataBindTextWithChecker(txtDateBgn, "OBD_FM", dFrom,
                                               10, (exgui.Object2String)dateVfy,
                                               (exgui.ultratable.
                                                CellTxtEditorFormat)dateVfy);
         dataBindComps.add(dbTxtDateBgn);

         dbTxtDateEnd =
             new exgui.DataBindTextWithChecker(txtDateEnd, "OBD_TO", dEnd,
                                               10, (exgui.Object2String)dateVfy,
                                               (exgui.ultratable.
                                                CellTxtEditorFormat)dateVfy);
         dataBindComps.add(dbTxtDateEnd);

       } catch (Exception exp) {
         exp.printStackTrace();
       }
     }
     public HashMap composeParameters() {
       HashMap hm = super.composeParameters();
       if(rdoTypeClotihng.isSelected()){
         hm.put("P_TYPE","C");
       }else{
         hm.put("P_TYPE","L");
       }
       Object dateBgn = dbTxtDateBgn.getSelectedValue();
       Object dateEnd = dbTxtDateEnd.getSelectedValue();
       if (dateBgn == null) {
         hm.put("OBD_FM", "DATE(2000,01,01)");
       }
       if (dateEnd == null) {
         hm.put("OBD_TO", "DATE(2099,12,31)");
       }
       return hm;
     }

  void btnQry_actionPerformed(ActionEvent e) {
      super.JButtonQueryButtonAction(null);
  }

}

