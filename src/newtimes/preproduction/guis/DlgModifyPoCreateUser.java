package newtimes.preproduction.guis;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import javax.swing.border.*;
import database.datatype.Record;
import java.util.*;
import java.awt.event.*;
import newtimes.preproduction.buyermakerselect.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgModifyPoCreateUser extends JDialog {
  JPanel panel1 = new JPanel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JComboBox cbxUserCode=null;
  JButton btnQry = new JButton();
  JPanel jPanel1 = new JPanel();
  Border border1;
  TitledBorder titledBorder1;
  JButton btnExit = new JButton();
  JButton btnUPDATE = new JButton();
  PnlListPO pnllistPO=null;
  exgui.ultratable.Wraper4tblCbx[] userNameList=null;
  JButton btnChageRows = new JButton();
  JComboBox cbxUserCodeTo = null;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  SelectBuyerMaker slkBuyer = new SelectBuyerMaker();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel2 = new WhiteBkgBlueCharLabel();
  public DlgModifyPoCreateUser(Frame frame, String title, boolean modal,
                               exgui.ultratable.Wraper4tblCbx[] _usrNameList) {
    super(frame, title, modal);
    userNameList=_usrNameList;
    cbxUserCode = new JComboBox(userNameList);
    cbxUserCodeTo= new JComboBox(userNameList);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgModifyPoCreateUser() {
    this(null, "", false,null);
  }

  private void jbInit() throws Exception {
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(border1,"PO LIST");
    panel1.setLayout(null);
    whiteBkgBlueCharLabel1.setText("CREATE USER");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(220, 16, 87, 26));
    cbxUserCode.setBounds(new Rectangle(309, 16, 176, 26));
    btnQry.setBounds(new Rectangle(489, 16, 49, 27));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setMargin(new Insets(0, 0, 0, 0));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jPanel1.setBorder(titledBorder1);
    jPanel1.setBounds(new Rectangle(19, 55, 515, 343));
    btnExit.setBounds(new Rectangle(96, 452, 79, 30));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setForeground(Color.red);
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnUPDATE.setText("Confirm Update");
    btnUPDATE.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUPDATE_actionPerformed(e);
      }
    });
    btnUPDATE.setFont(new java.awt.Font("Dialog", 1, 11));
    btnUPDATE.setBounds(new Rectangle(330, 452, 148, 30));
    btnChageRows.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnChageRows_actionPerformed(e);
      }
    });
    btnChageRows.setText("CHANGE");
    btnChageRows.setFont(new java.awt.Font("Dialog", 1, 11));
    btnChageRows.setBounds(new Rectangle(453, 406, 78, 27));
    cbxUserCodeTo.setBounds(new Rectangle(276, 406, 172, 26));
    blueBkgWhiteCharLabel1.setText("CHANGE CREATE USER OF SELECTE ROWS TO");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(5, 406, 274, 26));
    slkBuyer.setBounds(new Rectangle(55, 16, 162, 25));
    whiteBkgBlueCharLabel2.setBounds(new Rectangle(3, 16, 52, 26));
    whiteBkgBlueCharLabel2.setToolTipText("");
    whiteBkgBlueCharLabel2.setText("BUYER");
    getContentPane().add(panel1);
    panel1.add(jPanel1, null);
    panel1.add(btnUPDATE, null);
    panel1.add(btnExit, null);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(btnChageRows, null);
    panel1.add(cbxUserCodeTo, null);
    panel1.add(btnQry, null);
    panel1.add(whiteBkgBlueCharLabel1, null);
    panel1.add(cbxUserCode, null);
    panel1.add(slkBuyer, null);
    panel1.add(whiteBkgBlueCharLabel2, null);
    btnUPDATE.setVisible(false);
    blueBkgWhiteCharLabel1.setVisible(false);
    cbxUserCodeTo.setVisible(false);
    btnChageRows.setVisible(false);
    exgui.ultratable.Wraper4tblCbx itemselect=new exgui.ultratable.Wraper4tblCbx();
    itemselect.setValue(util.PublicVariable.USER_RECORD.get(0));
    itemselect.setString((String)util.PublicVariable.USER_RECORD.get(0));
    cbxUserCode.setSelectedItem(itemselect) ;
    slkBuyer.init("",null,slkBuyer.TYPE_BUYER,true);

  }
  class PnlListPO extends processhandler.template.PnlTableEditor{
   public PnlListPO(exgui.ultratable.PagedDataFactory pagedDataFxy,
                     int rowCounts,util.InsertionOrderedHashMap columnMapping,
                    java.util.Hashtable object2StringConvertor){
       super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
   }
   public void doPrint(){}
   public int getEachPageRowCount(){return _rowCounts;}
   public void refineEditors(exgui.ultratable.MultiEditorJTable mt){
      String strNames[]=new String[userNameList.length];
      for(int i=0;i<userNameList.length;i++)strNames[i]=userNameList[i].toString();
      mt.addJComboBox(2,strNames,false);
   }
   public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
   public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
   public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
   public void doUpdate(){
     try{
      super.doUpdate();
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       exgui.verification.VerifyLib.showAlert("Error While Updatting Style Data\nPlease Contatct System Manager",
                                              "Update Fail!!!");
     }

   }
   public Record setObject2Record(Record rec,int col,Object obj){
     try{
       rec.set(storedRecordColumn[col], obj);
       return rec;
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       return null;
     }
   }
 }
 class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
   TempDb(){
   }
   public void updateRecords(Vector vct2update)throws Exception{

      try{
        newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
            (newtimesejb.TPE_MIS.TpeMisFuncHome)
            info_ejb.WeblogicServiceLocator .locateServiceHome(util.PublicVariable.SERVER_URL,
             "newtimesejb.TPE_MIS.TpeMisFunc");
        newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
        HashMap hmParam=new HashMap();
        hmParam.put("PROD_HEAD_PK_LIST",vct2update);
        hmParam.put("user_code",util.PublicVariable.USER_RECORD.get(0));
        hmParam.put("TPEMISCFUNC_ACTION_CODE","MODIFY_PRODHEAD_CREATE_USER_CODE");
        ejb.tpeMisFunc(hmParam);
      }catch(Exception exp){
        util.ExceptionLog.exp2File(exp,"");
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert("Update Fail!!\nPlease Contact System Manager",
                                               "Update Fail");
        throw exp;
      }
   }

   public Vector getRecords(int bgn,int rowcount)throws Exception{
     StringBuffer sb=new StringBuffer();
     sb.append("select a.prod_head_pk,a.prod_sc_no,a.record_create_user ");
     sb.append("from production a,prod_head b ");
     sb.append("where a.record_delete_flag='1' ");
     sb.append(" and a.prod_head_pk=b.prod_head_pk ");
     if(slkBuyer.getSelectedValue()!=null){
       sb.append(" and b.prod_buyer=");sb.append(slkBuyer.getSelectedValue().toString());
     }
     sb.append(" and a.record_create_user='");
     exgui.ultratable.Wraper4tblCbx usrItem=(exgui.ultratable.Wraper4tblCbx)cbxUserCode.getSelectedItem();
     sb.append(util.MiscFunc.Replace((String)usrItem.getValue(),"'","''"));
     sb.append("' order by prod_head_pk desc");
      util.MiscFunc.showProcessingMessage();
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),bgn,rowcount
      );
      util.MiscFunc.hideProcessingMessage();
       return vct;
   }
 }

  void btnQry_actionPerformed(ActionEvent e) {
    if(pnllistPO==null){
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put("REF .NO","prod_head_pk");
      iso.put("  SC#          ","prod_sc_no");
      iso.put("CREATE USER           ","record_create_user");

      pnllistPO=new PnlListPO(new TempDb(),
                              99999,iso,new Hashtable());
      pnllistPO.setBounds(jPanel1.getBounds());
      pnllistPO.setBorder(jPanel1.getBorder());
      panel1.remove(jPanel1);
      panel1.add(pnllistPO,null);
      pnllistPO.firstPage();
      panel1.repaint();
      panel1.validate();

    }else{
      pnllistPO.firstPage();
    }
    btnUPDATE.setVisible(true);
    blueBkgWhiteCharLabel1.setVisible(true);
    cbxUserCodeTo.setVisible(true);
    btnChageRows.setVisible(true);
  }

  void btnExit_actionPerformed(ActionEvent e) {
    if(pnllistPO==null){
      this.hide();
      return;
    }
    if(pnllistPO.isContextModified()){
      if(!exgui.verification.VerifyLib.showConfirm("Context Modified\nDo You Sure To Exit ?",
                                                   "Context Modified",false) ){
        return;
      }
    }
    this.hide();

  }

  void btnUPDATE_actionPerformed(ActionEvent e) {
        if(!pnllistPO.isContextModified()){

       }else{

         pnllistPO.doUpdate();
         exgui.verification.VerifyLib.showPlanMsg("UPDATE OK","UPDATE OK");

       }
       //this.hide();



  }
  void btnChageRows_actionPerformed(ActionEvent e) {
     if(pnllistPO.getJtable().getSelectedRows().length==0){
       exgui.verification.VerifyLib.showPlanMsg("Please Select Row(s)",
                                                "Please Select Row(s)");
       return;
     }

     exgui.ultratable.Wraper4tblCbx usrItem=(exgui.ultratable.Wraper4tblCbx)cbxUserCodeTo.getSelectedItem();
     for(int i=0;i<pnllistPO.getJtable().getSelectedRows().length;i++){
       pnllistPO.getJtable().setValueAt(usrItem.getValue(),
                                        pnllistPO.getJtable().getSelectedRows()[i],
                                        2);
     }

  }

}
