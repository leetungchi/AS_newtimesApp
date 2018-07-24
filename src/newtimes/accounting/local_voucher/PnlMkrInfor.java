package newtimes.accounting.local_voucher;

import java.awt.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.*;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlMkrInfor extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  SelectBuyerMaker slkMaker = new SelectBuyerMaker();
  JButton btnQry = new JButton();
  JLabel jLabel1 = new JLabel();
  Border border1;
  Panel2List pnl2list = null;
  String makrSeq=null;
  JButton btnExit=new JButton("EXIT");
  boolean isDummy=true;
  newtimesejb.debitNote.LocalVoucherFacade lvFacade=null;
  Record blankRecLVMKI=null;
  JButton btnAddNew = new JButton();
  JLabel jLabel4 = new JLabel();
  public PnlMkrInfor() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    slkMaker.init("mkr_seq",null,slkMaker.TYPE_MAKER,true);
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });

    border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    blueBkgWhiteCharLabel1.setText("MAKER INFOR FOR VOUCHER");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-1, 18, 801, 33));
    this.setLayout(null);
    whiteBkgBlueCharLabel1.setText("MAKER:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(141, 55, 71, 25));
    slkMaker.setBounds(new Rectangle(216, 55, 218, 25));
    btnQry.setBounds(new Rectangle(444, 55, 119, 25));
    btnQry.setFont(new java.awt.Font("Dialog", 1, 11));
    btnQry.setText("QUERY");
    btnQry.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnQry_actionPerformed(e);
      }
    });
    jLabel1.setBorder(border1);
    jLabel1.setBounds(new Rectangle(0, 88, 801, 10));
    initPanel();

    btnAddNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnAddNew_actionPerformed(e);
      }
    });
    btnAddNew.setText("NEW");
    btnAddNew.setFont(new java.awt.Font("Dialog", 1, 11));
    btnAddNew.setBounds(new Rectangle(607, 55, 119, 25));
    jLabel4.setText("CLICK ANY ROW TO MAKER INFOR");
    jLabel4.setBounds(new Rectangle(1, 98, 349, 22));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(slkMaker, null);
    this.add(btnQry, null);
    this.add(jLabel1, null);
    this.add(pnl2list, null);
    isDummy=false;
  }
 public void btnExit_actionPerformed(ActionEvent me){
   try{
     processhandler.template.Properties.getCenteralControler().goBack();
   }catch(Exception exp){
     exp.printStackTrace();
   }
 }
  protected void initPanel(){
        if(pnl2list!=null) this.remove(pnl2list);
        util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
        iso.put("MAKER BRIEF                  ","bymkr_brief");
        iso.put("INFOR                                                            ","LV_MKR_INFOR");
        pnl2list=new Panel2List(new TempDb(),23,iso,new java.util.Hashtable());
        JPanel pnl2setButton=pnl2list.getLowerRightPanel();
        pnl2setButton.removeAll();
        pnl2setButton.setLayout(null);
        btnExit.setBounds(new Rectangle(100, 0, 99, 27));
        btnExit.setPreferredSize(new java.awt.Dimension(99,27));
        pnl2setButton.add(btnExit,null);
        pnl2list.setBounds(new Rectangle(9, 118, 775, 440));

        this.add(pnl2list, null);
    this.add(btnQry, null);
    this.add(btnAddNew, null);
    this.add(jLabel4, null);
        pnl2list.firstPage();
        this.repaint();
        this.validate();

  }
  class MouseListen extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      Record rec=(Record)pnl2list.getDisplayingRecords().get(
             pnl2list.getJtable().getSelectedRow());

      DlgMkrInfor dlg= new DlgMkrInfor(util.PublicVariable.APP_FRAME,"EDIT MAKER INFOR",true,rec);
             dlg.setSize(400,360);
             exgui.UIHelper.setToScreenCenter(dlg);
             dlg.show();
             if(dlg.recEditing!=null){
               try{
                 util.MiscFunc.showProcessingMessage();
                 lvFacade.ProcessMkrInfor(dlg.recEditing);
                 initPanel();
               }catch(Exception exp){
                 exp.printStackTrace();
                 util.ExceptionLog.exp2File(exp,"");
                 exgui.verification.VerifyLib.showAlert("Update Fail\nPlease Contact System Manager","Update Fail");
                 return ;
               }finally{
                  util.MiscFunc.hideProcessingMessage();
               }
             }


    }
  }
  class Panel2List extends processhandler.template.PnlTableEditor{
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        getJtable().addMouseListener(new MouseListen());
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){return null;}
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){

    }
  }

  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter {
    TempDb(){
      try{
      if(lvFacade==null){
        newtimesejb.debitNote.LocalVoucherFacadeHome ejbHome=
            (newtimesejb.debitNote.LocalVoucherFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.SERVER_URL,
            "newtimesejb.debitNote.LocalVoucherFacade");
        lvFacade=ejbHome.create();
        blankRecord=lvFacade.getBlankRecordOfMkrInfor();
        blankRecord.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
        blankRecord.set("record_delete_flag",-1);
        blankRecLVMKI=(Record)util.MiscFunc.deepCopy(blankRecord);
       }
      }catch(Exception exp){
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert("ERROR WHILE ATTEMP TO CREATE SERVER-SIDE COMPONENT\nPleas Contact System Manager",
                                               "Connection Error");

      }
    }
    public Vector getRecords(int bgn,int rowcount)throws Exception{
      try{
        if(isDummy)return new Vector();
        StringBuffer sb=new StringBuffer();
        sb.append("select ");
        sb.append("a.*,  ");
        sb.append("(select BYMKR_BRIEF from buyer_maker where BYMKR_SEQ=a.LV_MKR_SEQ) as bymkr_brief ");
        sb.append("from local_voucher_mkr_infor a  ");
        sb.append("where a.record_delete_flag='1' ");
        if(slkMaker.getSelectedValue()!=null){
          sb.append("and a.LV_MKR_SEQ=");
          sb.append(slkMaker.getSelectedValue().toString());
        }
        sb.append(" order by   (select BYMKR_BRIEF from buyer_maker where BYMKR_SEQ=a.LV_MKR_SEQ) ");

        util.MiscFunc.showProcessingMessage();
        Vector vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD,
            sb.toString(),
            bgn, rowcount);
        return vct;
      }finally{
        util.MiscFunc.hideProcessingMessage();
      }
    }
  }

  void btnQry_actionPerformed(ActionEvent e) {
    initPanel();
  }
  void btnAddNew_actionPerformed(ActionEvent e) {
    DlgMkrInfor dlg=null;
    try{
       dlg = new DlgMkrInfor(util.PublicVariable.APP_FRAME,
                                        "ADD MAKER INFOR", true,
                                        (Record)util.MiscFunc.deepCopy(
          blankRecLVMKI));
      dlg.setSize(400, 360);
      exgui.UIHelper.setToScreenCenter(dlg);
      dlg.show();
    }catch(Exception exp){

    }
    if(dlg.recEditing!=null){
      try{
        util.MiscFunc.showProcessingMessage();
        lvFacade.ProcessMkrInfor(dlg.recEditing);
        initPanel();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("Insert Fail\nPlease Contact System Manager","Insert Fail");
        return ;
      }finally{
         util.MiscFunc.hideProcessingMessage();
      }
    }
  }
}
