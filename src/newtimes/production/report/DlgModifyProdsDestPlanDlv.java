package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.util.*;
import database.datatype.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgModifyProdsDestPlanDlv extends JDialog {
  JPanel basePanel = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JButton btnUpdate = new JButton();
  JButton btnExit = new JButton();
  String prodHeadPkList;
  //主要功能--
  //update production's PROD_TGT_DEST & PROD_BYR_PLAN_DLAN_DEL
  Panel2List pnl2List=null;
  public DlgModifyProdsDestPlanDlv(Frame frame, String title,String _prodHeadPkList, boolean modal) {
    super(frame, title, modal);
    try {
      prodHeadPkList=_prodHeadPkList;
      jbInit();
      pack();
      btnUpdate.setEnabled(false);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgModifyProdsDestPlanDlv() {
    this(null, "", null,false);
  }
  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
     public void updateRecords(Vector vct2update){
       //BATCH_UPDATE_PROD_DEST_PLAN_DELV
       try{
         newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
             (newtimesejb.TPE_MIS.TpeMisFuncHome)
             info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
                                                    "newtimesejb.TPE_MIS.TpeMisFunc");
           newtimesejb.TPE_MIS.TpeMisFunc ejb=ejbHome.create();
           java.util.HashMap hmparam=new java.util.HashMap();
           hmparam.put("TPEMISCFUNC_ACTION_CODE","BATCH_UPDATE_PROD_DEST_PLAN_DELV");
           hmparam.put("user_code",util.PublicVariable.USER_RECORD.get(0));
           hmparam.put("vct2update",vct2update);
           util.MiscFunc.showProcessingMessage();
           ejb.tpeMisFunc(hmparam);
          util.MiscFunc.hideProcessingMessage();
       }catch(Exception exp){
         exp.printStackTrace();
       }
     }
     public Vector getRecords(int rowpos,int rowcount){
         try{
           StringBuffer sql=new StringBuffer();
           sql.append("select ");
           sql.append("a.prod_head_pk, ");
           sql.append("(select bymkr_name from buyer_maker where bymkr_seq=a.prod_buyer) as buyer_name, ");
           sql.append("(select bymkr_name from buyer_maker where bymkr_seq=a.prod_buyer) as maker_name, ");
           sql.append("(select DIV_NAME from division where div_code=A.PROD_BUYER_DIVISION) as dvsn_name, ");
           sql.append("B.PROD_TGT_DEST , ");
           sql.append("B.PROD_BYR_PLAN_DEL, ");
           sql.append("a.record_Modify_user  ");
           sql.append("from prod_head a,production b ");
           sql.append("where a.prod_head_pk=b.prod_head_pk ");
           sql.append("and a.prod_head_pk in (");sql.append(prodHeadPkList);sql.append(") ");
           sql.append(" order by prod_head_pk ");
           Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,sql.toString(),1,999999);
              return vct;
         }catch(Exception exp){
           exp.printStackTrace();
           exgui.verification.VerifyLib.showAlert("Error while listing Records to modify\nPleaes Contact System Manager",
                                                  "Error while listing Records to modify");
           return null;
         }
     }
  }
  class Panel2List extends processhandler.template.PnlTableEditor{
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        super.jbtn1st.setVisible(false);
        super.jbtnLast.setVisible(false);
        super.jbtnNext.setVisible(false);
        super.jbtnPrev.setVisible(false);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(75); //pred ref pk
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(180); //buyer
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(75); //div
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(180); //maker
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(180); //dest
      getJtable().getColumnModel().getColumn(5).setPreferredWidth(85); //plan delv
    }
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
      try{
        rec.set(storedRecordColumn[col],obj);
        return rec;
      }catch(Exception ex){
        ex.printStackTrace();
        return null;
      }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      //me.addCheckbox(0,"1");
      try{
        Vector vctDest = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            "select * from destination where record_delete_flag=1 order by dest_name",
            1, 9999);

        me.addJComboBox(4, vctDest,"DEST_NAME", "DEST_NAME");
        me.setTextEditorVerifiers(this.getObject2StringConvertor());
      }catch(Exception exp){
      }
    }
  }

  public void setPanel2List(){
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("REF     #","PROD_HEAD_PK");
    iso.put("      BUYER          ","buyer_name");
    iso.put(" DIV  ","dvsn_name");
    iso.put("       MAKER            ","MAKER_NAME");
    iso.put("DESTINATION","PROD_TGT_DEST");
    iso.put("PLAN DLV","PROD_BYR_PLAN_DEL");
    java.util.Hashtable ht=new java.util.Hashtable();
    Object dt=exgui.verification.CellFormat.getDateStringFormaterAllowNull();
    ht.put("PLAN DLV",dt);
    pnl2List=new Panel2List(new TempDb(),999999,iso,ht);
    pnl2List.setBounds(new Rectangle(1, 32, 789, 410));
    basePanel.add(pnl2List, null);
    btnUpdate.setEnabled(true);
    pnl2List.firstPage();
  }
  private void jbInit() throws Exception {
    basePanel.setLayout(null);
    blueBkgWhiteCharLabel1.setText("Batch Mod Dest (Destination & PLan Dlv)");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(1, 6, 800, 24));
    btnUpdate.setBounds(new Rectangle(193, 456, 162, 35));
    btnUpdate.setFont(new java.awt.Font("Dialog", 1, 12));
    btnUpdate.setText("UPDATE");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnUpdate_actionPerformed(e);
      }
    });
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(521, 456, 138, 35));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 12));
    btnExit.setForeground(Color.red);
    getContentPane().add(basePanel);
    basePanel.add(btnExit, null);
    basePanel.add(btnUpdate, null);
    basePanel.add(blueBkgWhiteCharLabel1, null);
  }

  void btnUpdate_actionPerformed(ActionEvent e) {
    try{
      pnl2List.doUpdate();
      pnl2List.reload();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While Updating Data\nPlease Contact System Manager",
                                             "Error While Updating Data");
    }
  }

  void btnExit_actionPerformed(ActionEvent e) {
   if(pnl2List.isContextModified()){
     if(!exgui.verification.VerifyLib.showConfirm("Context Modified without Confirmation,\nAre You Soure To Exit?",
                                                  "Context Modified without Confirmation",false)){
       return;
     }
     this.dispose();
   }else{
     this.dispose();
   }
  }
}
