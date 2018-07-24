package newtimes.production.gui.order_change;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.border.*;
import newtimes.production.process.order_change.*;
public class PnlFieldsModify
  //extends JPanel
   extends processhandler.template.PnlFieldsEditor
   {
  JLabel blueBkgWhiteCharLabel1 = new JLabel();
  JLabel lblSCNO = new JLabel();
  JLabel lblStyle = new JLabel();
  JPanel jPanel1 = new JPanel();
  TitledBorder titledBorder1;
  JLabel jLabel4 = new JLabel();
  JLabel blueBkgWhiteCharLabel5 = new JLabel();
  JLabel lblOldQTA = new JLabel();
  JLabel blueBkgWhiteCharLabel9 = new JLabel();
  JLabel lblOLD_DELDD = new JLabel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel blueBkgWhiteCharLabel7 = new JLabel();
  JLabel blueBkgWhiteCharLabel4 = new JLabel();
  JLabel blueBkgWhiteCharLabel8 = new JLabel();
  JLabel lblOldDiscDz = new JLabel();
  JLabel blueBkgWhiteCharLabel6 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel blueBkgWhiteCharLabel3 = new JLabel();
  JLabel lblOldBuyComm = new JLabel();
  JLabel jLabel6 = new JLabel();
  JLabel lblOldDiscPer = new JLabel();
  JLabel lblOldDiscPC = new JLabel();
  JLabel blueBkgWhiteCharLabel2 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JButton jButton1 = new JButton();
  JTextField txtDD_DEL = new JTextField();
  JTextField txtBuyComm = new JTextField();
  JTextField txtDiscPer = new JTextField();
  JTextField txtDiscPC = new JTextField();
  JTextField txtDiscDZ = new JTextField();
  JComboBox cbxQTA = new JComboBox();
  public static String tgt_Dlv_date_column;
  public PnlFieldsModify() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
 protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"");
    blueBkgWhiteCharLabel1.setText("========Order Change Edit========");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(22, 25, 496, 31));
    this.setLayout(null);
    lblSCNO.setAlignmentX((float) 10.0);
    lblSCNO.setHorizontalAlignment(SwingConstants.LEFT);
    lblSCNO.setText("  S/C No:");
    lblSCNO.setBounds(new Rectangle(86, 98, 165, 19));
    lblStyle.setHorizontalAlignment(SwingConstants.LEFT);
    lblStyle.setText("  STYLE:");
    lblStyle.setBounds(new Rectangle(85, 130, 256, 19));
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(88, 153, 331, 180));
    jPanel1.setLayout(null);
    jLabel4.setBounds(new Rectangle(4, 95, 317, 5));
    jLabel4.setText("");
    jLabel4.setPreferredSize(new Dimension(0, 0));
    jLabel4.setMinimumSize(new Dimension(0, 0));
    jLabel4.setMaximumSize(new Dimension(4, 4));
    jLabel4.setBorder(BorderFactory.createRaisedBevelBorder());
    jLabel4.setAlignmentY((float) 0.0);
    blueBkgWhiteCharLabel5.setBounds(new Rectangle(4, 53, 77, 19));
    blueBkgWhiteCharLabel5.setRequestFocusEnabled(true);
    blueBkgWhiteCharLabel5.setText("BUY COMM");
    blueBkgWhiteCharLabel5.setVerticalAlignment(SwingConstants.CENTER);
    lblOldQTA.setText("");
    lblOldQTA.setBounds(new Rectangle(80, 149, 117, 18));
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(4, 125, 77, 19));
    blueBkgWhiteCharLabel9.setText("DISC / DZ");
    lblOLD_DELDD.setText("");
    lblOLD_DELDD.setBounds(new Rectangle(80, 29, 117, 18));
    jLabel1.setAlignmentY((float) 0.0);
    jLabel1.setBorder(BorderFactory.createRaisedBevelBorder());
    jLabel1.setMaximumSize(new Dimension(4, 4));
    jLabel1.setMinimumSize(new Dimension(0, 0));
    jLabel1.setPreferredSize(new Dimension(0, 0));
    jLabel1.setText("");
    jLabel1.setBounds(new Rectangle(4, 47, 317, 5));
    jLabel3.setAlignmentY((float) 0.0);
    jLabel3.setBorder(BorderFactory.createRaisedBevelBorder());
    jLabel3.setMaximumSize(new Dimension(4, 4));
    jLabel3.setMinimumSize(new Dimension(0, 0));
    jLabel3.setPreferredSize(new Dimension(0, 0));
    jLabel3.setText("");
    jLabel3.setBounds(new Rectangle(4, 119, 317, 5));
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(4, 77, 77, 19));
    blueBkgWhiteCharLabel7.setText("DISC / PER");
    blueBkgWhiteCharLabel4.setText("DEL DD");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(4, 29, 77, 19));
    blueBkgWhiteCharLabel8.setText("QTA");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(4, 149, 77, 19));
    lblOldDiscDz.setBounds(new Rectangle(80, 125, 117, 18));
    lblOldDiscDz.setText("");
    blueBkgWhiteCharLabel6.setText("DISC / PC");
    blueBkgWhiteCharLabel6.setBounds(new Rectangle(4, 101, 77, 19));
    jLabel2.setBounds(new Rectangle(4, 71, 317, 5));
    jLabel2.setText("");
    jLabel2.setPreferredSize(new Dimension(0, 0));
    jLabel2.setMinimumSize(new Dimension(0, 0));
    jLabel2.setMaximumSize(new Dimension(4, 4));
    jLabel2.setBorder(BorderFactory.createRaisedBevelBorder());
    jLabel2.setAlignmentY((float) 0.0);
    blueBkgWhiteCharLabel3.setText("CHANGE");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(199, 5, 118, 23));
    lblOldBuyComm.setBounds(new Rectangle(80, 53, 117, 18));
    lblOldBuyComm.setText("");
    jLabel6.setBounds(new Rectangle(4, 143, 317, 5));
    jLabel6.setText("");
    jLabel6.setPreferredSize(new Dimension(0, 0));
    jLabel6.setMinimumSize(new Dimension(0, 0));
    jLabel6.setMaximumSize(new Dimension(4, 4));
    jLabel6.setBorder(BorderFactory.createRaisedBevelBorder());
    jLabel6.setAlignmentY((float) 0.0);
    lblOldDiscPer.setBounds(new Rectangle(80, 77, 117, 18));
    lblOldDiscPer.setText("");
    lblOldDiscPC.setText("");
    lblOldDiscPC.setBounds(new Rectangle(80, 101, 117, 18));
    blueBkgWhiteCharLabel2.setText("OLD");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(80, 5, 117, 23));
    jLabel5.setAlignmentY((float) 0.0);
    jLabel5.setBorder(BorderFactory.createRaisedBevelBorder());
    jLabel5.setMaximumSize(new Dimension(4, 4));
    jLabel5.setMinimumSize(new Dimension(0, 0));
    jLabel5.setPreferredSize(new Dimension(0, 0));
    jLabel5.setText("");
    jLabel5.setBounds(new Rectangle(4, 167, 317, 5));
    jButton1.setBounds(new Rectangle(126, 355, 256, 32));
    jButton1.setFont(new java.awt.Font("Dialog", 1, 11));
    jButton1.setText("Next-->Modify Price");
    jButton1.addActionListener(new PnlFieldsModify_jButton1_actionAdapter(this));
    txtDD_DEL.setText("");
    txtDD_DEL.setBounds(new Rectangle(198, 28, 120, 21));
    txtBuyComm.setBounds(new Rectangle(198, 52, 120, 21));
    txtBuyComm.setText("jTextField1");
    txtBuyComm.setText("");
    txtDiscPer.setBounds(new Rectangle(198, 76, 120, 21));
    txtDiscPer.setText("jTextField1");
    txtDiscPer.setText("");
    txtDiscPC.setBounds(new Rectangle(198, 100, 120, 21));
    txtDiscPC.setText("jTextField1");
    txtDiscPC.setText("");
    txtDiscDZ.setBounds(new Rectangle(198, 124, 120, 21));
    txtDiscDZ.setText("jTextField1");
    txtDiscDZ.setText("");
    cbxQTA.setBounds(new Rectangle(198, 149, 121, 19));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(jPanel1, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(blueBkgWhiteCharLabel5, null);
    jPanel1.add(lblOldQTA, null);
    jPanel1.add(blueBkgWhiteCharLabel9, null);
    jPanel1.add(lblOLD_DELDD, null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(blueBkgWhiteCharLabel7, null);
    jPanel1.add(blueBkgWhiteCharLabel4, null);
    jPanel1.add(blueBkgWhiteCharLabel8, null);
    jPanel1.add(lblOldDiscDz, null);
    jPanel1.add(blueBkgWhiteCharLabel6, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(blueBkgWhiteCharLabel3, null);
    jPanel1.add(lblOldBuyComm, null);
    jPanel1.add(jLabel6, null);
    jPanel1.add(lblOldDiscPer, null);
    jPanel1.add(lblOldDiscPC, null);
    jPanel1.add(blueBkgWhiteCharLabel2, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(txtDD_DEL, null);
    this.add(lblStyle, null);
    this.add(lblSCNO, null);
    this.add(jButton1, null);
    jPanel1.add(txtBuyComm, null);
    jPanel1.add(txtDiscPer, null);
    jPanel1.add(txtDiscPC, null);
    jPanel1.add(txtDiscDZ, null);
    jPanel1.add(cbxQTA, null);
  }


  void jButton1_actionPerformed(ActionEvent e) {
    try{
     this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      if(!gui2Record())return;
        recToMapping.set("sty_qta",cbxQTA.getSelectedItem());
        String concatCAT_AREA=(String)cbxQTA.getSelectedItem();
        String qta_catValue="",qta_areaValue ="";
        if(concatCAT_AREA==null || concatCAT_AREA.trim().length()==0){

        }else{
           qta_catValue =
              concatCAT_AREA.substring(0, concatCAT_AREA.length() - 1);
           qta_areaValue =
              concatCAT_AREA.substring(
              concatCAT_AREA.length() - 1, concatCAT_AREA.length());
        }
      recToMapping.set("STY_QTA_CAT",qta_catValue);
      recToMapping.set("STY_QTA_AREA",qta_areaValue);

      newtimes.production.process.order_change.tempDataCenter.tempStoredChangeStyleData =
          recToMapping;
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.production.process.order_change.TgrToChangePrice());
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }
  }
  public void record2Gui(){
    try{
      lblSCNO.setText(
          "  S/C NO."+(String)
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get(
           "prod_sc_no")
          );
      lblStyle.setText(
          "  STYLE:"+
          (String)recToMapping.get("STY_STYLE"));
      dataBoundGUIs.clear();
      //find out which column is to retreive for delivery data.
      Object dlvDate=null;
      if(recToMapping.get("STY_UPDT")!=null){
        dlvDate=recToMapping.get("STY_UPDT");
        tgt_Dlv_date_column="STY_UPDT";
      }else if(recToMapping.get("STY_RECFM_DEL")!=null){
        dlvDate=recToMapping.get("STY_RECFM_DEL");
        tgt_Dlv_date_column="STY_RECFM_DEL";
      }else if(recToMapping.get("STY_ORIG_DEL")!=null){
        dlvDate=recToMapping.get("STY_ORIG_DEL");
        tgt_Dlv_date_column="STY_ORIG_DEL";
      }else if(recToMapping.get("STY_MKR_DEL")!=null){
        dlvDate=recToMapping.get("STY_MKR_DEL");
        tgt_Dlv_date_column="STY_MKR_DEL";
      }

      Object vftxtDD_DEL=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
          txtDD_DEL,tgt_Dlv_date_column,
          dlvDate,10,
          (exgui.Object2String)vftxtDD_DEL,
          (exgui.ultratable.CellTxtEditorFormat)vftxtDD_DEL)
      );
      lblOLD_DELDD.setText(((exgui.Object2String)vftxtDD_DEL).Obj2String(dlvDate));
      Object orgBuyComm=recToMapping.get("STY_BUY_COMM");
      Object vftxtBuyComm=exgui.verification.CellFormat.getDoubleFormatAllowNull(3,2);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
          txtBuyComm,"STY_BUY_COMM",
          orgBuyComm,6,
          (exgui.Object2String)vftxtBuyComm,
          (exgui.ultratable.CellTxtEditorFormat)vftxtBuyComm)
      );
      lblOldBuyComm.setText(
          ((exgui.Object2String)vftxtBuyComm).Obj2String(orgBuyComm));

      Object orgMkrDsctPer=recToMapping.get("STY_MKR_DSCT_PER");
      Object vftxtDiscPer=exgui.verification.CellFormat.getDoubleFormatAllowNull(3,2);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
          txtDiscPer,"STY_MKR_DSCT_PER",
          orgMkrDsctPer,6,
          (exgui.Object2String)vftxtDiscPer,
          (exgui.ultratable.CellTxtEditorFormat)vftxtDiscPer)
      );
      lblOldDiscPer.setText(
          ((exgui.Object2String)vftxtDiscPer).Obj2String(orgMkrDsctPer));

      Object orgMkrDsctPc=recToMapping.get("STY_MKR_DSCT_PC");
      Object vftxtDiscPC=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,3);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
          txtDiscPC,"STY_MKR_DSCT_PC",
          orgMkrDsctPc,8,
          (exgui.Object2String)vftxtDiscPC,
          (exgui.ultratable.CellTxtEditorFormat)vftxtDiscPC)
      );
      lblOldDiscPC.setText(
          ((exgui.Object2String)vftxtDiscPC).Obj2String(orgMkrDsctPc));

      Object orgMkrDsctDz=recToMapping.get("STY_MKR_DSCT_DZ");
      Object vftxtDiscDZ=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,3);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
          txtDiscDZ,"STY_MKR_DSCT_DZ",
          orgMkrDsctDz,9,
          (exgui.Object2String)vftxtDiscDZ,
          (exgui.ultratable.CellTxtEditorFormat)vftxtDiscDZ)
      );
      lblOldDiscDz.setText(
          ((exgui.Object2String)vftxtDiscDZ).Obj2String(orgMkrDsctDz));


      exgui.DataBindJCombobox  DbJcbxjcbxQTA = new exgui.DataBindJCombobox(
          cbxQTA, "STY_QTA",
          newtimes.production.process.order_change.DB_StyList.qtaVct,
          "cat_data", "cat_data",
          recToMapping.get("STY_QTA"),"",null);
      dataBoundGUIs.add(DbJcbxjcbxQTA);
      lblOldQTA.setText((String)recToMapping.get("sty_qta"));

    }catch(Exception e){
      e.printStackTrace();
    }
  }
 public void doPaste(){

 }
 public void doCopy(){

 }
 public void doPrint(){

 }

}

class PnlFieldsModify_jButton1_actionAdapter implements java.awt.event.ActionListener {
  PnlFieldsModify adaptee;

  PnlFieldsModify_jButton1_actionAdapter(PnlFieldsModify adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}
