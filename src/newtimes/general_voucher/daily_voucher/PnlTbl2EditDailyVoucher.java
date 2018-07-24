package newtimes.general_voucher.daily_voucher;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.awt.*;
import javax.swing.JPanel;
import exgui.*;
import java.util.*;
import database.datatype.Record;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.event.ItemListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSeparatorUI;
import java.math.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlTbl2EditDailyVoucher
//extends exgui.ultratable.FuncAbstractUltraTablePanel{
extends processhandler.template.PnlTableEditor  {
    //javax.swing.JPopupMenu popMenu4AccCode=new javax.swing.JPopupMenu();
    public static String VH_NO;
    public static String COMP_CODE;
    HashMap hmAccCodeName;
    static int ACC_CODE_COLUMN_AT=-1;
    static int ACC_TW_NAME_COLUMN_AT=-1;
    static int DEBIT_AMT_COLUMN_AT=-1;
    static int CREDIT_AMT_COLUMN_AT=-1;
    static int INVOICE_NO_COLUMN_AT=-1;
    static int DESCRIPTION_COLUMN_AT=-1;
    static Hashtable htSubSystemTriger=null;
    Hashtable htSubSystemRecords=null;
    CellMonitor cellMonitor=new CellMonitor();
    Db4SubSystem db4SubSystem=new Db4SubSystem(null);
    static String TABLE_NAME_TRAFIC_FEE="VH_DTL_TVL";
    static String TABLE_NAME_TICKET_FEE="VH_DTL_TKT";
    static String TABLE_NAME_TELECOME_FEE="VH_DTL_TELECOM";
    static String TABLE_NAME_1112_2108="VH_1112_2108";
    static String TABLE_NAME_5123="VH_5123";

    static String TABLE_NAME_1102x0I3="VH_1102X0I3";
    static String TABLE_NAME_5105xHCX="VH_5105HCX";

    PnlTbl2EditDailyVoucher p2This;
    MousClickAdpt mouseClickApt=null;
    ScrollMenu4AccCode popmuAccCode;
    Vector vctBackup;
    Db4List dbOfVhListing;
    int blankRowSeq=1;
    String myPcIp=null;
    int selectedRow,selectedCol;
    boolean ifHaveEditiorNow;
    boolean isContextModified=false;
    exgui.ultratable.MultiEditorJTable superTable=null;
    //PopMenuObj popCommonTermMenu=null;
    JohnScrollMenu popCommonTermMenu=null;
    //XJPopupMenu popCommonTermMenu=null;
    static boolean isUpdatting=false;
    DescTextMouseListener descColumKeyListener=new DescTextMouseListener();
    PnlTbl2EditDailyVoucher(){
      super();
      isUpdatting=false;
      p2This=this;
      Constants.Pnl_Tbl2EditDailyVoucher=p2This;
      if(PnlTbl2EditDailyVoucher.htSubSystemTriger==null){
        PnlTbl2EditDailyVoucher.htSubSystemTriger=new Hashtable();
        PnlTbl2EditDailyVoucher.htSubSystemTriger.put(PnlTbl2EditDailyVoucher.TABLE_NAME_TRAFIC_FEE,new ToShowTraficFeeEditor());
        PnlTbl2EditDailyVoucher.htSubSystemTriger.put(PnlTbl2EditDailyVoucher.TABLE_NAME_TICKET_FEE,new ToShowTicketFeeEditor());
        PnlTbl2EditDailyVoucher.htSubSystemTriger.put(PnlTbl2EditDailyVoucher.TABLE_NAME_TELECOME_FEE,new ToShowTeleComFeeEditor());
        PnlTbl2EditDailyVoucher.htSubSystemTriger.put(PnlTbl2EditDailyVoucher.TABLE_NAME_1112_2108,new ToShow1112Form());
        PnlTbl2EditDailyVoucher.htSubSystemTriger.put(PnlTbl2EditDailyVoucher.TABLE_NAME_5123,new ToShow5123Form());

        PnlTbl2EditDailyVoucher.htSubSystemTriger.put(PnlTbl2EditDailyVoucher.TABLE_NAME_1102x0I3,new ToShow1102x0I3Form());
        PnlTbl2EditDailyVoucher.htSubSystemTriger.put(PnlTbl2EditDailyVoucher.TABLE_NAME_5105xHCX,new ToShow5105xHCX());

      }

      try{
        if (Constants.COMMON_TERMS == null) {
          Constants.COMMON_TERMS = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
              util.PublicVariable.USER_RECORD,
              "select * from VH_CMN_TERM order by term", 1, 99999);
        }
      }catch(Exception exp){
        exp.printStackTrace();
      }
       popCommonTermMenu=new  JohnScrollMenu(Constants.COMMON_TERMS);
        getPanelContainsButtons().removeAll();
        firstPage();
    }




public class JohnScrollMenu extends JPopupMenu  {
  JScrollPane jScrollPane2Contain = new JScrollPane();
  JPanel pnl2List = new JPanel();
  Vector vct2append;
  public JohnScrollMenu(Vector vct2App) {
    try {
      vct2append=vct2App;
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    //this.getContentPane().setLayout(null);
    this.setVisible(false);
    this.setLayout(null);
    pnl2List.setLayout(new GridLayout(vct2append.size(),1));
    jScrollPane2Contain.setBounds(new Rectangle(6, 7, 479, 370));
    //this.getContentPane().add(jScrollPane2Contain, null);
    this.add(jScrollPane2Contain, null);
    jScrollPane2Contain.getViewport().add(pnl2List, null);
    javax.swing.border.EtchedBorder aborder=new javax.swing.border.EtchedBorder();
    for(int i=0;i<vct2append.size();i++){
      JLabel btnTest=new JLabel((String)((Record)vct2append.get(i)).get(0));
      btnTest.setBorder(aborder);
      btnTest.addMouseListener(
       new java.awt.event.MouseAdapter(){
          public void mouseClicked(java.awt.event.MouseEvent me){
            //System.out.println("Clicked==>"+((JButton)me.getSource()).getText());
            //JMenuItem itemselected=(JMenuItem)ae.getSource();
            final String text=((JLabel)me.getSource()).getText();
            //System.out.println("Clicked At:"+text);
            //if(!ifHaveEditiorNow){
              getJtable().changeSelection(selectedRow, selectedCol, false, false);
            //}
            popCommonTermMenu.setVisible(false);
            getJtable().setValueAt(text, selectedRow, DESCRIPTION_COLUMN_AT);
            superTable.mt.m_Text=text;

            final javax.swing.text.JTextComponent txtEdit =
                (javax.swing.text.JTextComponent)getJtable().getEditorComponent();
            javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                   public void run() {
                    txtEdit.setText(text);
                    txtEdit.select(0, 0);
                    txtEdit.setCaretPosition(0);
                  }
                }
            );

          }
       }
      );
      pnl2List.add(btnTest);

    }
    this.setPreferredSize(new Dimension(250, 380));
  }
}



    class MousClickAdpt extends java.awt.event.MouseAdapter{
      public void mouseClicked(java.awt.event.MouseEvent me){
         //boolean isMouseLeft=true;
          selectedRow = getJtable().rowAtPoint(me.getPoint());
          selectedCol  = getJtable().columnAtPoint(me.getPoint());
           String accCode=(String)getJtable().getValueAt(selectedRow,ACC_CODE_COLUMN_AT);
           //if is 5105xHCX  and column at 2 ,show the dialog ,allow user to use or not use subsystem of
           //delivery fee detail (運費明細).

           if(selectedCol==2 && accCode!=null && accCode.length()>5 && accCode.startsWith("5105") ){
               DlgI5101HCXHaveDialog dlg= new DlgI5101HCXHaveDialog(util.PublicVariable.APP_FRAME,"Have Sub System?",true,p2This);
               dlg.setSize(250,100);
               exgui.UIHelper.setToScreenCenter(dlg);
               dlg.show();
              return;
           }

          if(selectedCol==2 && accCode!=null && accCode.startsWith("4101") &&
             util.PublicVariable.USER_RECORD.getInt(2) ==
             newtimesejb.preproduction.PreProductionHead.
             USER_TYPE_SUPERVIOSER_MIS
             ){
            Record rec=(Record)getDisplayingRecords().get(selectedRow);
            Object costStr=rec.get(11);
            String costValue= JOptionPane.showInputDialog(null, "Stock Cost",(costStr==null)?"":costStr.toString());
            if(costValue==null){
              //System.out.print("Cost Value Calnceld");
              return;
            }else{
               try{
                 double cost = Double.parseDouble(costValue);
                 isContextModified=true;
                 ((Record)getDisplayingRecords().get(selectedRow)).set(11,cost);
                 return;
               }catch(Exception exp){
                 exgui.verification.VerifyLib.showAlert("Cost value should be numeric","Cost value should be numeric");
                 return;
               }


            }

          }
         if(selectedCol!=DESCRIPTION_COLUMN_AT)return;

        if ((me.getModifiers() & java.awt.event.InputEvent.BUTTON3_MASK) == java.awt.event.InputEvent.BUTTON3_MASK){
          if(!getJtable().isCellEditable(selectedRow,selectedCol))return;
          ifHaveEditiorNow=false;
          popCommonTermMenu.show(getJtable(),me.getX(),me.getY());
          return;
        }
        if( (!getJtable().isCellEditable(selectedRow,selectedCol))){
          if(accCode!=null && accCode.trim().length()>0){
            String tableName=getTableName4SubSystem(accCode,selectedRow);
            if(null!=tableName){
               IntfSubSystem showSubSystemGui=(IntfSubSystem)htSubSystemTriger.get(tableName);
               if(null!=showSubSystemGui){
                 db4SubSystem.setSrcTableName(tableName);
                 String glbSeq=((Record)getDisplayingRecords().get(selectedRow)).get(0).toString();
                 try{
                   Record rec2Edit = db4SubSystem.getRecordByGlbSeq(glbSeq);
                   if(rec2Edit==null ||rec2Edit.getInt("record_delete_flag")==0){
                     rec2Edit = db4SubSystem.getBlankRecord();
                     rec2Edit.set(0, glbSeq);
                   }

                   Constants.recSubSystem=rec2Edit;

                   //the description & amont is from current vh detail row,have to set to the column for editor of
                   //sub system GUI.
                   String dbAmt=null;
                   Object objAmt=getJtable().getValueAt(selectedRow,DEBIT_AMT_COLUMN_AT);
                   if(objAmt==null||objAmt.toString().trim().length()==0){
                      objAmt=getJtable().getValueAt(selectedRow,CREDIT_AMT_COLUMN_AT);
                      if(!(objAmt==null||objAmt.toString().trim().length()==0)){
                        dbAmt="-"+objAmt.toString();
                      }
                   }else{
                     dbAmt=(objAmt==null)?"":objAmt.toString();
                   }
                   rec2Edit.set("DB_AMT",dbAmt);
                   rec2Edit.set("VH_DESC",getJtable().getValueAt(selectedRow,DESCRIPTION_COLUMN_AT));
                   showSubSystemGui.doShowEditorDlg();
                 }catch(Exception exp){
                           exp.printStackTrace();
                 }
               }
            }
          }
        }
      }
    }
    public void companyChanged(String newCmpCode){
      COMP_CODE=newCmpCode;

    }
    boolean isReload4Insert=false;
    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(20); //seq
      getJtable().getColumnModel().getColumn(ACC_CODE_COLUMN_AT).setPreferredWidth(73); //ACC CODE
      getJtable().getColumnModel().getColumn(ACC_TW_NAME_COLUMN_AT).setPreferredWidth(140); //ACC TW NAME
      getJtable().getColumnModel().getColumn(DEBIT_AMT_COLUMN_AT).setPreferredWidth(75); //Debit amt
      getJtable().getColumnModel().getColumn(CREDIT_AMT_COLUMN_AT).setPreferredWidth(85); //Credit amt
      getJtable().getColumnModel().getColumn(INVOICE_NO_COLUMN_AT).setPreferredWidth(80); //inv no
      getJtable().getColumnModel().getColumn(DESCRIPTION_COLUMN_AT).setPreferredWidth(254); //EXPLAIN
      getJtable().setRowHeight(20);
      getJtable().setFont(new java.awt.Font("Dialog",java.awt.Font.PLAIN, 14));

       if(mouseClickApt==null){
         mouseClickApt=new MousClickAdpt();
         getJtable().addMouseListener(mouseClickApt);
       }
    }

    protected  void refineEditors(exgui.ultratable.MultiEditorJTable multiEditorJTableInSuper){
      multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());
      DescColumnRenderer descColumnRdr=new DescColumnRenderer();
      this.getJtable().getColumnModel().getColumn(DESCRIPTION_COLUMN_AT).setCellRenderer(descColumnRdr);
      ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).setCellEditablePolicy(
         new CellEditablePolicyCls()
      );
      superTable=multiEditorJTableInSuper;
    }
    public void doUpdate(String companyCode,java.util.Date vhDate){
      try{
        util.MiscFunc.showProcessingMessage();
        isUpdatting=true;
        {
           //check date range.
          StringBuffer sbChk=new StringBuffer("select * from TPE_DATE_RANGE where FIELD_NAME='GV_COMP_");
          sbChk.append(companyCode);sbChk.append("'");
          Vector vctChk=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,sbChk.toString(),1,999999);
          if(vctChk.size()==0){
            exgui.verification.VerifyLib.showAlert("無此公司的傳票日期區間,請洽電腦室",
                                                   "無此公司的傳票日期區間");
            return;
          }
          Record rec2Chk=(Record)vctChk.get(0);

          java.util.Date vhDate2Chk=(java.util.Date)Constants.Pnl_EditDaily_Voucher.dbTxtInitDate.getSelectedValue();
          int date2Num=Integer.parseInt(Constants.Pnl_EditDaily_Voucher.DATE_FORAMT.format(vhDate2Chk));
          Record recTpeDateRange=rec2Chk;
          int dateRangeBgn=Integer.parseInt(recTpeDateRange.get(1).toString());
          int dateRangeEnd=Integer.parseInt(recTpeDateRange.get(2).toString());
          if(!(date2Num>=dateRangeBgn &&  date2Num<=dateRangeEnd)){
            String dateFromStr=String.valueOf(dateRangeBgn).substring(0,4)+"年"+String.valueOf(dateRangeBgn).substring(4,6)+"月";
            String dateEndStr=String.valueOf(dateRangeEnd).substring(0,4)+"年"+String.valueOf(dateRangeEnd).substring(4,6)+"月";
            exgui.verification.VerifyLib.showAlert("傳票日期需在"+dateFromStr+"~"+dateEndStr+" 之內\n請洽電腦室","日期區間不符");
            return;
          }
        }

        Vector vct2Update = new java.util.Vector();
        int vh_seq = 1;
        boolean isNewRecord=false;
        double totalDebitAmt=0;
        double totalCreditAmt=0;
        getJtable().editingStopped(null);
        for (int i = 0; i < getDisplayingRecords().size(); i++) {
          Record rec = (Record)getDisplayingRecords().get(i);
          String accCode=(String)getJtable().getValueAt(i, ACC_CODE_COLUMN_AT);

          String accCodeRecord=(String)rec.get("VH_ACCOUNT");
          if(null==accCode)accCode="";
          String glbSeq=rec.get(0).toString();
          if(glbSeq.indexOf(".")!=-1)isNewRecord=true;
          /*
          if(i==11||i==12){
            //set to deleted.
             System.out.println(" row to delte "+rec.toString());
          }
          */
          if("".equals(accCode.trim())){
            if(isNewRecord){
              continue;//this is new record,but is not used,continue it.
            }else{
                rec.set("record_delete_flag", "0");
                vct2Update.add(rec);
                continue;
            }
          }
          /*
          if(isNewRecord){
            rec.set("VH_NO", rec.get("VH_NO"));
            rec.set("VH_DATE",rec.get("VH_DATE"));
          }*/

          rec.set("VH_ACCOUNT", accCode);
          rec.set("VH_SEQ", vh_seq);
          rec.set("ACC_TW_NAME", getJtable().getValueAt(i, ACC_TW_NAME_COLUMN_AT));
          Object objDbAmt=getJtable().getValueAt(i, DEBIT_AMT_COLUMN_AT);
          Object objCdAmt=getJtable().getValueAt(i, CREDIT_AMT_COLUMN_AT);
          rec.set("DEBIT_AMT",objDbAmt );
          rec.set("CREDIT_AMT",objCdAmt);
          // 2011 02 10,incase,user clear and re-input ,still have to setup  this flag.
          //for isntance.user clear the item,but system alert db/cd not match  <--at this moment,the row's delete flag is set to "zero"
          //so she comes back to input .but nice the delete flag remains zero,this rocord will be deleted in ejb
          rec.set("record_delete_flag","1");
          String db_type="";
          String strAmt=null;
          if(!(objDbAmt==null || objDbAmt.toString().trim().length()==0 || Double.parseDouble(objDbAmt.toString().trim())==0)){
            db_type+="D";
            strAmt=objDbAmt.toString();
          }

          if(!(objCdAmt==null || objCdAmt.toString().trim().length()==0|| Double.parseDouble(objCdAmt.toString().trim())==0)){
            db_type+="C";
            strAmt=objCdAmt.toString();
          }

          if(db_type.trim().length()==0){
            exgui.verification.VerifyLib.showAlert("Please Assigne Amout For Debit/Credit\nSEQ:"+(i+1),
                                                   "Amount Not Assigned");
            return;
          }
          if(db_type.trim().length()==2){
            exgui.verification.VerifyLib.showAlert("Amount Error At SEQ:"+(i+1),
                                                   "Amount Error");
            return;

          }
          if(db_type.trim().equals("D")){
            totalDebitAmt +=Double.parseDouble(strAmt);
          }else{
            totalCreditAmt+=Double.parseDouble(strAmt) ;
          }

          rec.set("VH_DC",db_type);
          rec.set("VH_AMT",strAmt);
          rec.set("VH_INVOICE", getJtable().getValueAt(i, INVOICE_NO_COLUMN_AT));
          String descOfVh=(String)getJtable().getValueAt(i, DESCRIPTION_COLUMN_AT);
          //allow temprary null ,usre will complete them latter.
          /*
          if(descOfVh==null||descOfVh.trim().length()==0){
            exgui.verification.VerifyLib.showAlert("Please Assigne Voucher Detail Description At SEQ:"+(i+1),
                                                   "Please Assigne Voucher Detail Description");
            return;
          }
          */
          rec.set("VH_DESCRIPTION",descOfVh);
          rec.set("record_modify_user", util.PublicVariable.USER_RECORD.get(0));
          vct2Update.add(rec);
          vh_seq++;
        }
        Vector vctSubSystem=new Vector();
        if(!htSubSystemRecords.isEmpty()){
          java.util.Enumeration emu =htSubSystemRecords.keys();
          while(emu.hasMoreElements()){
            String glbSeq=(String)emu.nextElement();
            Record recSubSystem=(Record)htSubSystemRecords.get(glbSeq);
            if(recSubSystem.getModifiedFields().size()==0)continue;//no modification.
            if(glbSeq.indexOf(".")!=-1 && recSubSystem.getInt("record_delete_flag")==0){
              continue;
            }else{
              vctSubSystem.add(recSubSystem);
            }
          }
        }
        totalDebitAmt=new BigDecimal(totalDebitAmt).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        totalCreditAmt=new BigDecimal(totalCreditAmt).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

        if(totalDebitAmt!=totalCreditAmt){
          exgui.verification.VerifyLib.showAlert("Total Debit Amount Not Equal To Total Credit Amount",
                                                 "Total Debit <> Total Credit");
          return;
        }

        newtimesejb.dailyVoucher.DailyVoucherFacadeHome ejbHome=
            (newtimesejb.dailyVoucher.DailyVoucherFacadeHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.dailyVoucher.DailyVoucherFacade");
          newtimesejb.dailyVoucher.DailyVoucherFacade ejb=ejbHome.create();
          java.util.HashMap hm=new java.util.HashMap();
          hm.put("SUB_SYSTEM",vctSubSystem);
          //WATCH OUT!!,if have vhDate param sent to server,means to call server insert all data.
          boolean isAddNewMode=(VH_NO==null);
          int cmpCodeSelectInde=Constants.Pnl_EditDaily_Voucher.cbxCompany.getSelectedIndex();
          String strVhNo=ejb.handleVhDtlRecs(vct2Update,hm,companyCode,(VH_NO==null)?vhDate:null);

          if(strVhNo!=null){
            //reload current page...
            System.out.println(" reload current vh detail page ");
            TgrEditDailyVoucher.INIT_VH_NO=strVhNo;
            TgrEditDailyVoucher.INIT_DATE=vhDate;
            this.VH_NO=strVhNo;
          }
          if(!isAddNewMode){
            util.MiscFunc.showProcessingMessage();
            javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
            jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            PnlEditDailyVoucher pnl=new PnlEditDailyVoucher(TgrEditDailyVoucher.INIT_VH_NO,TgrEditDailyVoucher.INIT_DATE);
            jframe.getContentPane().removeAll();
             pnl.setSize(800, 600);
             jframe.getContentPane().add(pnl);
             jframe.repaint();
             jframe.show();
             jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
             util.MiscFunc.hideProcessingMessage();
          }else{
            //shows the VH_NO to user,
            //clear current panel,keep current company.
            //exgui.verification.VerifyLib.showPlanMsg("Insert Ok,Voucher No is:"+strVhNo,"Insert Ok");
            //2010,01,06,also,provide print function of vouhcer no geneated
            if(exgui.verification.VerifyLib.showConfirm("Insert Ok,Voucher No is:"+strVhNo+"\nDo You Want To Print Out ?",
                                                        "Insert Ok",true)){
                    Object[] options = {" A5 "," A4 "};
                    int n = JOptionPane.showOptionDialog(null,
                            "Ready Print Out !",
                            "Select Paper Form",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                   if (n==0) { PnlListDailyVoucher.ShowVhReport(strVhNo,false,"A5"); }
                        else { PnlListDailyVoucher.ShowVhReport(strVhNo,false,"A4"); };
            }

  /*          Object[] options = {" A5 "," A4 ","Skip"};
            int n = JOptionPane.showOptionDialog(null,
                    "Insert Ok,Voucher No is:"+strVhNo+"\nDo You Want To Print Out ?",
                    "Insert Ok",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);

           if (n==0) { PnlListDailyVoucher.ShowVhReport(strVhNo,false,"A5");};
           if (n==1) { PnlListDailyVoucher.ShowVhReport(strVhNo,false,"A4");}; */

            TgrEditDailyVoucher.INIT_VH_NO=null;
            TgrEditDailyVoucher.INIT_DATE=null;
             util.MiscFunc.showProcessingMessage();
             javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
             jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
             PnlEditDailyVoucher pnl=new PnlEditDailyVoucher(TgrEditDailyVoucher.INIT_VH_NO,TgrEditDailyVoucher.INIT_DATE);
             jframe.getContentPane().removeAll();
              pnl.setSize(800, 600);
              jframe.getContentPane().add(pnl);
              jframe.repaint();
              jframe.show();
              jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
              util.MiscFunc.hideProcessingMessage();
              Constants.Pnl_EditDaily_Voucher.cbxCompany.setSelectedIndex(cmpCodeSelectInde);

          }

         util.MiscFunc.hideProcessingMessage();
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("UPDATE FAILED!!\nPLEASE COONTACT SYSTEM MANAGER",
                                               "UPDATE FAILED!!");
      }finally{
        isUpdatting=false;
      }

    }
    boolean isAllAccCodeReady(){
        for(int i=0;i<getJtable().getRowCount();i++){
          String accZhTwName=(String)getJtable().getValueAt(i,ACC_TW_NAME_COLUMN_AT);
          if(accZhTwName!=null){
            if(Constants.NO_SUCH_ACCOUNT_CODE.equals(accZhTwName)||
               "此公司尚無設定會計科目".equals(accZhTwName)||
               "ACC Code Not Found".equals(accZhTwName)
               ){
               exgui.verification.VerifyLib.showAlert("會計科目未設定正確\n請修正之再進行","會計科目未設定正確");
               return false;
            }
          }
        }
        return true;
    }

    public void doPrint(){

    }
    protected Record setObject2Record(Record rec,int columnAt,Object value2update){
        try{
          if(columnAt==3){
            if(value2update!=null && value2update.toString().trim().length()>0){
              rec.set(5,"D");
              rec.set(6,value2update);
            }
          }else if(columnAt==4){
            if(value2update!=null && value2update.toString().trim().length()>0){
              rec.set(5,"C");
              rec.set(6,value2update);
            }
          }else{
            String columName=storedRecordColumn[columnAt];
            rec.set(columName,value2update);
          }
          return rec;
        }catch(Exception exp){
          exp.printStackTrace();
          return null;
        }
    }
    protected exgui.ultratable.PagedDataFactory getPagedDataFactory(){
      dbOfVhListing=new Db4List();
      return  dbOfVhListing;
    }
    protected util.InsertionOrderedHashMap getHeadColumnMap(){
       util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
       iso.put(" ","VH_SEQ");
       iso.put("A/C-CODE","VH_ACCOUNT");
       ACC_CODE_COLUMN_AT=iso.entrySet().size()-1;
       iso.put("科目名稱","ACC_TW_NAME");
       ACC_TW_NAME_COLUMN_AT=iso.entrySet().size()-1;
       iso.put("DEBIT-AMT","DEBIT_AMT");
       DEBIT_AMT_COLUMN_AT=iso.entrySet().size()-1;
       iso.put("CREDIT-AMT","CREDIT_AMT");
       CREDIT_AMT_COLUMN_AT=iso.entrySet().size()-1;
       iso.put("INV#","VH_INVOICE");
       INVOICE_NO_COLUMN_AT=iso.entrySet().size()-1;
       iso.put("EXPLAIN","VH_DESCRIPTION");
       DESCRIPTION_COLUMN_AT=iso.entrySet().size()-1;
       return iso;
    }
    protected java.util.Hashtable getObject2StringConvertor(){
        Hashtable ht=new Hashtable();
        ht.put("A/C-CODE",new AccCodeVfy());
        Object amtVfy =new DbCrAmtVfy(10,2);  //=exgui.verification.CellFormat.getDoubleFormatAllowNull(10,2);
        ht.put("DEBIT-AMT",amtVfy);
        ht.put("CREDIT-AMT",amtVfy);
        ht.put("INV#",exgui.verification.CellFormat.getOrdinaryField(8));
        Object objVfhDesc=new OrdinaryField4Menu(60,exgui.verification.CellFormat.getOrdinaryField(60));
        ht.put("EXPLAIN",objVfhDesc);//exgui.verification.CellFormat.getOrdinaryField(60));
        return ht;
    }
    /*
    class InvnoVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
      Object OrgInvNovfy=exgui.verification.CellFormat.getOrdinaryField(8);
      public int getMaxLength(){return ((exgui.ultratable.CellTxtEditorFormat)OrgInvNovfy).getMaxLength();}
      public KeyProcess getKeyListener(){
        return ((exgui.ultratable.CellTxtEditorFormat)OrgInvNovfy).getKeyListener();
      }
      public String formatPromptMsg(){
        return ((exgui.ultratable.CellTxtEditorFormat)OrgInvNovfy).formatPromptMsg();
      }
      public boolean isFormatValid(String inStr,int row,int column){
        boolean result=((exgui.ultratable.CellTxtEditorFormat)OrgInvNovfy).isFormatValid(inStr,row,column);
        if(!result)return false;
        //Constants.Pnl_EditDaily_Voucher.update2TotalLabel();
        return true;
      }
      public String Obj2String(Object obj2kvt){
        return ((exgui.Object2String)OrgInvNovfy).Obj2String(obj2kvt);
      }
       public Object cellStringToObject(String String2kvt){
          return ((exgui.ultratable.CellTxtEditorFormat)OrgInvNovfy).cellStringToObject(String2kvt);
       }

    }
    */
    class DbCrAmtVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
      java.text.DecimalFormat formatter = null;//new java.text.DecimalFormat("######.###");
      Object amtVfy=null;
      public DbCrAmtVfy(int intDigitLength,int floatDigitLength){
        amtVfy=exgui.verification.CellFormat.getDoubleFormatAllowNull(intDigitLength,floatDigitLength);
      }

      public int getMaxLength(){return ((exgui.ultratable.CellTxtEditorFormat)amtVfy).getMaxLength();}
      public KeyProcess getKeyListener(){
        return ((exgui.ultratable.CellTxtEditorFormat)amtVfy).getKeyListener();
      }
      public String formatPromptMsg(){
        return ((exgui.ultratable.CellTxtEditorFormat)amtVfy).formatPromptMsg();
      }
      public boolean isFormatValid(String inStr,int row,int column){
        boolean result=((exgui.ultratable.CellTxtEditorFormat)amtVfy).isFormatValid(inStr,row,column);
        if(!result)return false;
        Constants.Pnl_EditDaily_Voucher.update2TotalLabel();
        return true;
      }
      public String Obj2String(Object obj2kvt){
        return ((exgui.Object2String)amtVfy).Obj2String(obj2kvt);
      }
       public Object cellStringToObject(String String2kvt){
          return ((exgui.ultratable.CellTxtEditorFormat)amtVfy).cellStringToObject(String2kvt);
       }
    }


  //---------begin of CLASS GROUP FOR DESCRIPTION POPOUT RIGHT MENUE OF COMMON WORDS-----------------
  class DescColumKeyListener extends KeyAdapter
   implements exgui.ultratable.KeyProcess{
  protected javax.swing.text.JTextComponent myTextComponent=null;
  public void keyPressed(java.awt.event.KeyEvent e){
  }
  protected void updateToMonitor(){
      java.awt.Container parentCon=myTextComponent.getParent();
      while(parentCon!=null){
        if(parentCon instanceof exgui.ultratable.MultiEditorJTable){
          myTextComponent.validate();
           ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text=
               myTextComponent.getText();
           ///System.out.println(" update to ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text :"+myTextComponent.getText());
           break;
        }
        //System.out.println("keep lookup parent ,current parent is "+parentCon.getClass().getName());
        parentCon=parentCon.getParent();
      }
  }
  public void keyReleased(java.awt.event.KeyEvent e){
    //System.out.println("get Key Code:"+e.getKeyCode());
    updateToMonitor();
  }
  public void keyTyped(java.awt.event.KeyEvent e){
  }
  public void bind2TextComponent(javax.swing.text.JTextComponent txtcmp){
    myTextComponent=txtcmp;
    myTextComponent.addKeyListener(this);
    myTextComponent.addMouseListener(descColumKeyListener);
  }
 }

 class DescTextMouseListener extends java.awt.event.MouseAdapter{
  public void mouseClicked(java.awt.event.MouseEvent me){
    if ((me.getModifiers() & java.awt.event.InputEvent.BUTTON3_MASK) == java.awt.event.InputEvent.BUTTON3_MASK){
       selectedRow = getJtable().getSelectedRow();
       selectedCol  = getJtable().getSelectedColumn();
       if(selectedRow<0)return;
       if(selectedCol<0)return;
      if(selectedCol!=DESCRIPTION_COLUMN_AT)return;
      ifHaveEditiorNow=true;
      popCommonTermMenu.show(getJtable().getEditorComponent(),me.getX(),me.getY());

    }

  }
}


    class OrdinaryField4Menu implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
       int _maxLength;
       String promptMsg=null;
       exgui.ultratable.CellTxtEditorFormat parent;
       DescColumKeyListener keyListen2=new DescColumKeyListener();
       OrdinaryField4Menu(int limitSize,exgui.ultratable.CellTxtEditorFormat _parent){
         _maxLength=limitSize;
         parent=_parent;
         promptMsg="String can not exceed "+_maxLength+" bytes ";
       }

       public KeyProcess getKeyListener(){
         return keyListen2;
       }
      public int getMaxLength(){return _maxLength;}
      public String formatPromptMsg(){
        return promptMsg;
      }
      public boolean isFormatValid(String inStr,int row,int column){
        return parent.isFormatValid(inStr,row,column);
      };
       public Object cellStringToObject(String String2kvt){
          return parent.cellStringToObject(String2kvt);
       }
      public String Obj2String(Object obj){
        if(obj==null) return "";
        return obj.toString().toUpperCase();
      }
    }
  //---------end of CLASS GROUP FOR DESCRIPTION POPOUT RIGHT MENUE OF COMMON WORDS-----------------

    protected int getEachPageRowCount(){return 99;}
    static boolean isCompanyHaveSubSystem(String cmpCode){
       if(",E,F,G,L,S,".indexOf(","+cmpCode+",")==-1)return false;
       return true;
     }
    static  boolean isTicketFee(String accCode){
       if(null==accCode || accCode.trim().length()<5)return false;
       String cmpCode=accCode.substring(4,5);
       if(!isCompanyHaveSubSystem(cmpCode))return false;
       if(accCode.length()<7)return false;
       if(accCode.startsWith("1107") && accCode.substring(6,7).equals("T")) return true;
       return false;
     }
     void insertBlankRow(int row2Insert)throws Exception{
      vctBackup=new Vector();
      int vh_seq=1;
      for(int i=0;i<99;i++){
        if(vh_seq-1==row2Insert){
          Record blankRec=dbOfVhListing.getBlankRecord();
          blankRec.set("VH_SEQ",vh_seq);
          blankRec.set("VH_NO",VH_NO);
          blankRec.set("VH_DATE",TgrEditDailyVoucher.INIT_DATE);
          vctBackup.add(blankRec);
          ++vh_seq;
        }
        //set all   cell to record columns
          Record rec=(Record)util.MiscFunc.deepCopy(getDisplayingRecords().get(i));
          rec.set("VH_ACCOUNT", getJtable().getValueAt(i, ACC_CODE_COLUMN_AT));
          rec.set("VH_SEQ",vh_seq);
          rec.set("ACC_TW_NAME",getJtable().getValueAt(i,ACC_TW_NAME_COLUMN_AT));
          rec.set("DEBIT_AMT",getJtable().getValueAt(i,DEBIT_AMT_COLUMN_AT));
          rec.set("CREDIT_AMT",getJtable().getValueAt(i,CREDIT_AMT_COLUMN_AT));
          rec.set("VH_INVOICE",getJtable().getValueAt(i,INVOICE_NO_COLUMN_AT));
          rec.set("VH_DESCRIPTION",getJtable().getValueAt(i,DESCRIPTION_COLUMN_AT));
          rec.set("record_modify_user",util.PublicVariable.USER_RECORD.get(0));
          vctBackup.add(rec);
          ++vh_seq;

      }
      isContextModified=true;
      //remove the last element,incase out of 99
      //vctBackup.removeElementAt(99);
    }
   public boolean isContextModified(){
     return super.isContextModified()||isContextModified;
   }

     boolean is1102xI03(String accCode){
     if(null==accCode || accCode.trim().length()<5)return false;
     String cmpCode=accCode.substring(4,5);
     if(!(cmpCode.equalsIgnoreCase("G")||cmpCode.equalsIgnoreCase("L")||
        cmpCode.equalsIgnoreCase("F")||cmpCode.equalsIgnoreCase("S"))){
       return false;
     }
     if(accCode.startsWith("1102") && accCode.endsWith("0I3") )return true;
     return false;

   }


     boolean is5105xHCX(String accCode,int row){
      if(!(accCode!=null && accCode.length()>5 &&  accCode.startsWith("5105") ))return false;
     //if have record in hmSubSystem
     Record recVh=(Record)getDisplayingRecords().get(row);
     Record recSubSystem=(Record) htSubSystemRecords.get(recVh.get(0).toString());
     try{
       if(recSubSystem!=null && recSubSystem.getInt("record_delete_flag")>0){
         return true;
       }
     }catch(Exception exp){
         exp.printStackTrace();
     }
     return false;
   }

     boolean is5128(String accCode){
     if(null==accCode || accCode.trim().length()<5)return false;
     if(accCode.startsWith("5123"))return true;
     return false;
   }

     boolean is1112_2108(String accCode){
     if(null==accCode || accCode.trim().length()<5)return false;
     if(accCode.startsWith("1112"))return true;
     if(accCode.startsWith("2108"))return true;
     return false;
   }
     boolean isTraficFee(String accCode){
       if(null==accCode || accCode.trim().length()<5)return false;
       String cmpCode=accCode.substring(4,5);
       if(!isCompanyHaveSubSystem(cmpCode))return false;
       if(accCode.startsWith("5103"))return true;
       return false;
     }
     boolean isTeleComFee(String accCode){
       if(null==accCode || accCode.trim().length()<5)return false;
       String cmpCode=accCode.substring(4,5);
       if(!isCompanyHaveSubSystem(cmpCode))return false;
       if(accCode.startsWith("5113"))return true;
       return false;
     }
     boolean isNormalAccCode(String accCode,int row){
        if(isTicketFee(accCode))return false;
        if(isTraficFee(accCode))return false;
        if(isTeleComFee(accCode))return false;
        if(is5128(accCode))return false;
        if(is1112_2108(accCode))return false;
        if(is1102xI03(accCode))return false;
        if(is5105xHCX(accCode,row))return false;
        return true;
     }
      String getTableName4SubSystem(String accCode,int row){
       if(isTraficFee(accCode)) return TABLE_NAME_TRAFIC_FEE;
       if(isTicketFee(accCode))return TABLE_NAME_TICKET_FEE;
       if(isTeleComFee(accCode))return TABLE_NAME_TELECOME_FEE;
       if(is1112_2108(accCode))return TABLE_NAME_1112_2108;
       if(is5128(accCode))return TABLE_NAME_5123;
       if(is5105xHCX(accCode,row))return TABLE_NAME_5105xHCX;
       if(is1102xI03(accCode))return TABLE_NAME_1102x0I3;
       return null;
     }
   void accCodeChanged(int row,String orgAccCode,String newAccCode){
     //after sub system record is marked as "deleted",clear the rest columns.
     if((isNormalAccCode(orgAccCode,row) && isNormalAccCode(newAccCode,row))||
        (isTraficFee(orgAccCode)&& isTraficFee(newAccCode))||
        (isTicketFee(orgAccCode)&& isTicketFee(newAccCode))||
        (isTeleComFee(orgAccCode)&& isTeleComFee(newAccCode))||
        (is1112_2108(orgAccCode)&& is1112_2108(newAccCode))||
        (is5128(orgAccCode)&& is5128(newAccCode))

         ||(is5105xHCX(orgAccCode,row) && is5105xHCX(newAccCode,row))
         ||(is1102xI03(orgAccCode)&& is1102xI03(newAccCode))

        ){

              //if acc type is same,do not have to clear the rest columns
     }else{
       //if have subsystem in that row,also have to remove the subsystem
       String srcTbl4SubSystem = getTableName4SubSystem(orgAccCode,row);
       if (srcTbl4SubSystem != null) {
         Record rec = (Record)getDisplayingRecords().get(row);
         String glbSeq = rec.get(0).toString();
         try {
           Record rec2SubSystem = db4SubSystem.getRecordByGlbSeq(glbSeq);
           if (null != rec2SubSystem) {
             db4SubSystem.setSrcTableName(srcTbl4SubSystem);
             db4SubSystem.deleteRecord(rec2SubSystem);
           }
         } catch (Exception exp) {
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp, "");
         }
       }

       getJtable().setValueAt("", row, 3);
       getJtable().setValueAt("", row, 4);
       getJtable().setValueAt("", row, 5);
       getJtable().setValueAt("", row, 6);
     }
   }


   public class ScrollMenu4AccCode extends JPopupMenu  {
     JScrollPane jScrollPane2Contain = new JScrollPane();
     //JPanel pnl2List = new JPanel();
     Vector menu_item;
     TblMousClick clickTbl=null;
     JTable tbl=null;
     public ScrollMenu4AccCode(Vector item) {
       try {
         menu_item=item;
         jbInit();
       }
       catch(Exception ex) {
         ex.printStackTrace();
       }
     }
     class TblMousClick extends java.awt.event.MouseAdapter{
       public void mouseClicked(java.awt.event.MouseEvent me){
         if(tbl!=null && tbl.getSelectedRow()!=-1){
           popmuAccCode.setVisible(false);
           String str = (String)tbl.getValueAt(tbl.getSelectedRow(), 0);

           String item[]=util.MiscFunc.split(str,"--");
           getJtable().setValueAt(item[0], selectedRow, ACC_CODE_COLUMN_AT);
           String accTwName=item[1];
           for(int i=2;i<item.length;i++){
              accTwName+=("--"+item[i]);
           }
           getJtable().setValueAt(accTwName, selectedRow, ACC_TW_NAME_COLUMN_AT);
           superTable.mt.m_Text=item[0];
           final String text2Set=item[0];
           final javax.swing.text.JTextComponent txtEdit =
               (javax.swing.text.JTextComponent)getJtable().getEditorComponent();
           if(txtEdit==null)return;

           javax.swing.SwingUtilities.invokeLater(
               new Runnable() {
                  public void run() {
                   txtEdit.setText(text2Set);
                   txtEdit.setCaretPosition(text2Set.length());
                 }
               }
           );

           //getJtable().changeSelection(selectedRow,ACC_CODE_COLUMN_AT,false,false);

         }
       }
     }

     void jbInit() throws Exception {
       //this.getContentPane().setLayout(null);
       this.setVisible(false);
       this.setLayout(null);
       //pnl2List.setLayout(new BorderLayout());
       jScrollPane2Contain.setBounds(new Rectangle(6, 7, 479, 370));
       //this.getContentPane().add(jScrollPane2Contain, null);
       this.add(jScrollPane2Contain, null);
       Vector vctHead=new Vector();
       vctHead.add("ACC CODE & Name");
       tbl=new JTable(menu_item.size(),1);
       tbl.setTableHeader(null);
       for(int i=0;i<menu_item.size();i++){
         tbl.setValueAt((String)menu_item.get(i),i,0);
       }
       jScrollPane2Contain.getViewport().add(tbl, null);
       // (menu_item.size()+2)*20)
       int tblHeight=menu_item.size()+2*20;
       if(tblHeight<100)tblHeight=100;
       this.setPreferredSize(new Dimension(220,tblHeight));
       if(clickTbl==null)clickTbl=new TblMousClick();
       tbl.addMouseListener(clickTbl);

     }

   }


   class AccCodeKeyListener extends KeyAdapter
       implements exgui.ultratable.KeyProcess{
      protected javax.swing.text.JTextComponent myTextComponent=null;
      public void keyPressed(java.awt.event.KeyEvent e){
      }
      protected void updateToMonitor(){
          java.awt.Container parentCon=myTextComponent.getParent();
          while(parentCon!=null){
            if(parentCon instanceof exgui.ultratable.MultiEditorJTable){
              myTextComponent.validate();
               ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text=
                   myTextComponent.getText();
               ///System.out.println(" update to ((exgui.ultratable.MultiEditorJTable)parentCon).mt.m_Text :"+myTextComponent.getText());
               break;
            }
            //System.out.println("keep lookup parent ,current parent is "+parentCon.getClass().getName());
            parentCon=parentCon.getParent();
          }
      }
      public void keyReleased(java.awt.event.KeyEvent e){
        //System.out.println("get Key Code:"+e.getKeyCode());
        updateToMonitor();
        selectedRow=getJtable().getEditingRow();
        selectedCol=getJtable().getEditingColumn();
        /*
        if(e.getKeyCode()==e.VK_TAB||e.getKeyCode()==e.VK_ENTER){
          if(popMenu4AccCode.isShowing())popMenu4AccCode.setVisible(false);
        }
        */
        //System.out.println(" key release from AccCodeKeyListener");
        if(popmuAccCode!=null && popmuAccCode.isShowing()){
          if(e.isActionKey()||
             e.getKeyCode()==e.VK_TAB||
             e.getKeyCode()==e.VK_ENTER||
             e.getKeyCode()==e.VK_RIGHT){
             popmuAccCode.setVisible(false);
             e.consume();
             getJtable().repaint();
             getJtable().validate();
             return;
          }
        }
        String strBgn=myTextComponent.getText().trim();
        HashMap hmAccCodeMp=
            (HashMap)newtimes.general_voucher.daily_voucher.Constants.hmCompanyAndAccCodeTwName.get(COMP_CODE);
        /*
        if(null!=hmAccCodeMp && hmAccCodeMp.get(strBgn)!=null && popMenu4AccCode.isShowing()){
          popMenu4AccCode.setVisible(false);
          return;
        }
        */
        if(null!=hmAccCodeMp && strBgn.length()>0){
          //if(popMenu4AccCode.isShowing())popMenu4AccCode.setVisible(false);
          //popMenu4AccCode.removeAll();
          ScrollMenu4AccCode popMenu4AccCode=null;
          java.util.Iterator itrKey=hmAccCodeMp.keySet().iterator();
          boolean haveItem=false;
          Vector vctItem=new Vector();
          while(itrKey.hasNext()){
            String key=(String)itrKey.next();

            if (key.length() >=7 ) {
                String vhdept_code = key.substring(5, 7);
                if ( vhdept_code.equals("JP"))
                {
                   continue;
                 }
            }

             if(key.startsWith(strBgn)){
                haveItem=true;
                String accTwName=(String)hmAccCodeMp.get(key);
                vctItem.add(key+"--"+accTwName);
                /*
                JMenuItem item=new JMenuItem(key+"--"+accTwName);
                item.setSize(200,20);
                popMenu4AccCode.add(item);
                */
             }
          }
          if(haveItem){
              java.util.Collections.sort(vctItem);
              vctItem.remove("1102M0A3--銀行存款-澳盛美乙");

              popMenu4AccCode=new ScrollMenu4AccCode(vctItem);


            popMenu4AccCode.show(getJtable(),myTextComponent.getX()+myTextComponent.getWidth(),myTextComponent.getY());
            myTextComponent.grabFocus();
            myTextComponent.setCaretPosition(myTextComponent.getText().length());
            popmuAccCode=popMenu4AccCode;
          }
        }

      }
      public void keyTyped(java.awt.event.KeyEvent e){
      }
      public void bind2TextComponent(javax.swing.text.JTextComponent txtcmp){
        myTextComponent=txtcmp;
        myTextComponent.addKeyListener(this);
      }
   }



    public class AccCodeVfy implements exgui.ultratable.CellTxtEditorFormat,exgui.Object2String{
      Object orgFvyObj=null;
      AccCodeKeyListener accCodeKeyListener =new AccCodeKeyListener();
      public AccCodeVfy(){
        orgFvyObj=exgui.verification.CellFormat.getOrdinaryField(20);
      }
      public int getMaxLength(){
        return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getMaxLength();
      }

      public exgui.ultratable.KeyProcess getKeyListener(){
        //return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).getKeyListener();

        return accCodeKeyListener;
      }

      public String formatPromptMsg(){
         //return  (exgui.ultratable.CellTxtEditorFormat)orgFvyObj).formatPromptMsg();
         return  "ACC Code Not Found";
      }
      public boolean isFormatValid(String inStr,int row,int column){
        System.out.println("row=="+row+",col=="+column+" str=="+inStr);
        if(popmuAccCode!=null && popmuAccCode.isShowing())popmuAccCode.setVisible(false);
        if(column==ACC_CODE_COLUMN_AT){
          String newAccCoder=inStr;
          if(newAccCoder==null)newAccCoder="";
          if(column==cellMonitor.col && row==cellMonitor.row &&
             (!newAccCoder.equals(cellMonitor.lastAccCode))){
            accCodeChanged(row,cellMonitor.lastAccCode,newAccCoder);
          }
        }
        if(null==inStr||"".equals(inStr.trim())){
          getJtable().setValueAt("",row,2);
          getJtable().setValueAt("",row,3);
          getJtable().setValueAt("",row,4);
          getJtable().setValueAt("",row,5);
          getJtable().setValueAt("",row,6);

          return true;
        }
        HashMap hmAccCodeMp=
            (HashMap)newtimes.general_voucher.daily_voucher.Constants.hmCompanyAndAccCodeTwName.get(COMP_CODE);
        if(null==hmAccCodeMp){
          getJtable().setValueAt("此公司尚無設定會計科目",row,2);
          return false;
        }
        if(selectedCol==ACC_CODE_COLUMN_AT && row!=-1){
          String _inStr=(String)getJtable().getValueAt(selectedRow,ACC_CODE_COLUMN_AT);
          String accZhTwName = (String)hmAccCodeMp.get(_inStr);
          if (accZhTwName == null) {
            getJtable().setValueAt(newtimes.general_voucher.daily_voucher.
                                   Constants.NO_SUCH_ACCOUNT_CODE,
                                   row, 2);
            return false;
          } else {
            getJtable().setValueAt(inStr, row, 1);
            getJtable().setValueAt(accZhTwName, row, 2);
            getJtable().repaint();
            getJtable().validate();
            return true;
          }
        }
        return true;
      }
      public String Obj2String(Object obj2kvt){
        return ((exgui.Object2String)orgFvyObj).Obj2String(obj2kvt);
      }
       public Object cellStringToObject(String String2kvt){
         return ((exgui.ultratable.CellTxtEditorFormat)orgFvyObj).cellStringToObject(String2kvt);
       }

     }
     class CellEditablePolicyCls implements exgui.CellEditablePolicy{
         public boolean isCellEditable(int row,int col){
           cellMonitor.clickedRow=row;
           cellMonitor.clickedCol=col;

           if(col==ACC_CODE_COLUMN_AT){
             cellMonitor.row=row;
             cellMonitor.col=col;
             cellMonitor.lastAccCode=(String)getJtable().getValueAt(row,ACC_CODE_COLUMN_AT);
             return true;
           }
          //for 1107~T code,have to defined special rule
          String accCode=(String)getJtable().getValueAt(row,ACC_CODE_COLUMN_AT);
          if(accCode.startsWith("1107")&& accCode.endsWith("T")){
            if(col==0||col==ACC_TW_NAME_COLUMN_AT)return false;
            if(col==DEBIT_AMT_COLUMN_AT)return false;
            if(col==CREDIT_AMT_COLUMN_AT){
                Object obj=getJtable().getValueAt(row,DEBIT_AMT_COLUMN_AT);
                if(obj!=null && obj.toString().trim().length()>0)return false;
                return true;//have no debite,can input credit avlaue.
            }
            if(col==INVOICE_NO_COLUMN_AT){
                return false;
            }
            if(col==DESCRIPTION_COLUMN_AT){
              //if already have credit value for 1107xxT,allow to input descripton direclty
              Object obj=getJtable().getValueAt(row,CREDIT_AMT_COLUMN_AT);
              if(obj!=null && obj.toString().trim().length()>0)return true;
              return false;//have no debite,can input credit avlaue.
            }
          }
          if(col==0||col==ACC_TW_NAME_COLUMN_AT)return false;
          if(accCode!=null && accCode.length()>0
             && accCode.startsWith("6101") && col==CREDIT_AMT_COLUMN_AT){
            return false;
          }
          if(accCode!=null && accCode.length()>0
             && accCode.startsWith("4101") && col==DEBIT_AMT_COLUMN_AT){
            return false;
          }

          if(col==DEBIT_AMT_COLUMN_AT||col==CREDIT_AMT_COLUMN_AT
             ||col==INVOICE_NO_COLUMN_AT||col==DEBIT_AMT_COLUMN_AT
             ||col==DESCRIPTION_COLUMN_AT){
            if (accCode == null || accCode.trim().length() == 0)return false;
          }
          if((accCode!=null && accCode.length()>4) && !isNormalAccCode(accCode,row)){
            //if (col == CREDIT_AMT_COLUMN_AT)return true;
            return false ;//debit & description is not editable if is not normal account type
          }

          if(col== INVOICE_NO_COLUMN_AT){
            java.text.NumberFormat nf=new java.text.DecimalFormat("000000");
            if(row<1)return true;
            String orgInv=(String)getJtable().getValueAt(row,col);
            String lastInv=(String)getJtable().getValueAt(row-1,col);
            if(!isUpdatting && (orgInv==null||orgInv.trim().length()==0 &&
               (lastInv!=null && lastInv.trim().length()>0))){
              try{
                int lastNo=Integer.parseInt(lastInv.substring( 2,lastInv.length()));
                lastNo++;
                String nextInvNo=lastInv.substring(0,2)+nf.format(lastNo);
                getJtable().setValueAt(nextInvNo,row,col);
              }catch(Exception exp){
                exp.printStackTrace();
              }
            }
          }


          return true;
        }
     }
     public class DescColumnRenderer extends JLabel
         implements javax.swing.table.TableCellRenderer{
         public DescColumnRenderer(){
         super();
         setFont(new java.awt.Font("Dialog",java.awt.Font.PLAIN, 14));
        setOpaque(true); /* it\u00B4s essential */
     }
      public Component getTableCellRendererComponent(
            javax.swing.JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column){
            String text = (value==null)?"":value.toString();
            if(isSelected){
              setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
            }else{
             setBackground(new java.awt.Color(0xFF,0xFF,0xFF)); // Decides the color.
            }
            if(table.getModel().isCellEditable(row,column)){
              //if(isSelected) setBackground(new java.awt.Color(0xFF,0xFF,0xFF)); // Decides the color
              setText(text);
              return this;
            }else{
              String accCode=(String)table.getValueAt(row,ACC_CODE_COLUMN_AT);
              if(accCode!=null && accCode.trim().length()>4){
                setBackground(new java.awt.Color(0x90, 0xFF, 0x90)); // Decides the color
                setText(text); /* Put the current text in the JLabel */
                return this;
              }
            }
            setText(text);
            return this;
       }
     }

    class Db4SubSystem extends exgui.ultratable.PagedDataFactoryAdapter{
       String srcTableName=null;
        Db4SubSystem(String _srcTblName){
         srcTableName=_srcTblName;
       }
       public void setSrcTableName(String _tblName){srcTableName=_tblName;}
       public Record getBlankRecord() throws Exception{
          Record rec2Return=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord(
             srcTableName.toUpperCase()+"_tbl");
          rec2Return.set("record_delete_flag","1");
          rec2Return.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
          rec2Return.getFieldName().add("SOURCE_TABLE");
          rec2Return.getValueFields().add(srcTableName);
          //these 2 column are needed in editor dialog GUI
          rec2Return.getFieldName().add("DB_AMT");
          rec2Return.getValueFields().add(null);
          rec2Return.getFieldName().add("VH_DESC");
          rec2Return.getValueFields().add(null);
          rec2Return.getModifiedFields().clear();
          return rec2Return;
       }
       public void deleteRecord(Record rec)throws Exception{
         if(rec.get(0).toString().indexOf(".")!=-1){
           htSubSystemRecords.remove(rec.get(0).toString());
         }else{
           rec.set("record_delete_flag","0");
           htSubSystemRecords.put(rec.get(0).toString(),rec);
         }
       }
       public void updateRecords(Vector vct)throws Exception{
         for(int i=0;i<vct.size();i++){
           Record rec=(Record)vct.get(i);
           if(rec.getInt("record_delete_flag")==0){
             deleteRecord(rec);
           }else{
             htSubSystemRecords.put(rec.get(0).toString(),rec);
           }
         }
       }
       /*
       Record getRecFromDB(String glbSeq)throws Exception{
          Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
              util.PublicVariable.USER_RECORD,
              "select * from VH_DTL_SUBSYS_TBL where glb_seq="+glbSeq,1,999);
           if(vct.size()==0)return null;
           Record recSubTbl=(Record)vct.get(0);
           String tblName=recSubTbl.get(0).toString();//TBL_NAME
           Vector vctDst=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
               util.PublicVariable.USER_RECORD,
               "select * from "+tblName+" where glb_seq="+glbSeq,1,999);
           Record rec2Return=(Record)vctDst.get(0);
           rec2Return.getFieldName().add("SOURCE_TABLE");
           rec2Return.getValueFields().add(tblName);
           return rec2Return;
       }
       */
       public Record getRecordByGlbSeq(String glbSeq)throws Exception{
          if(htSubSystemRecords.containsKey(glbSeq)){
            Record rec=(Record)htSubSystemRecords.get(glbSeq);
            if(rec.getInt("record_delete_flag")==0){
              //this is meant to delete,find it out again.
              /*
              Record recRtn= getRecFromDB(glbSeq);
              htSubSystem.put(glbSeq,recRtn);
              return recRtn;
              */
              return rec;
            }else{
              return rec;
            }
          }else{
            /*
            Record rec=getBlankRecord();
            rec.set(0,glbSeq);
            rec.set("record_delete_flag","1");
            rec.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
            htSubSystemRecords.put(glbSeq,rec);
            return rec;
            */
           return null;
          }
       }
    }

    class CellMonitor{
        int row;
        int col;
        String lastAccCode;
        int clickedRow;
        int clickedCol;
    }

    class Db4List extends exgui.ultratable.PagedDataFactoryAdapter{
      Record recBlank2Go=null;
      public Record getBlankRecord()throws Exception{
        if(recBlank2Go==null){
          Record recBlank=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("VH_DETAIL_tbl");
          recBlank.getFieldName().add("DEBIT_AMT");
          recBlank.getValueFields().add(null);
          recBlank.getFieldName().add("CREDIT_AMT");
          recBlank.getValueFields().add(null);
          recBlank.getFieldName().add("ACC_TW_NAME");
          recBlank.getValueFields().add(null);
          recBlank.set("record_create_user",util.PublicVariable.USER_RECORD.get(0));
          recBlank2Go=(Record)util.MiscFunc.deepCopy(recBlank);
        }
        Record rec=(Record)util.MiscFunc.deepCopy(recBlank2Go);
        if(myPcIp==null)myPcIp=java.net.InetAddress.getLocalHost().getHostAddress();
        rec.set(0,myPcIp+" "+blankRowSeq);
        blankRowSeq++;
        return rec;
      }
      public Vector getRecords(int bgn,int rowcount)throws Exception{
        if(isReload4Insert){
          //the "insert blank row may call the reload process.just directly send back the displaying record.
          return vctBackup;
        }
        Object ahDateValue=null;
        HashMap hmAccCodeMp=
            (HashMap)newtimes.general_voucher.daily_voucher.Constants.hmCompanyAndAccCodeTwName.get(COMP_CODE);
        Vector vctRtn=new Vector();


          if(null==VH_NO){
            for(int i=0;i<99;i++){
             Record rec=getBlankRecord();
             //rec.set(0,ip+" "+String.valueOf(i));
             //System.out.println(" seq is "+ip+" "+String.valueOf(i));
             rec.set(2,i+1);//vh_seq
             //rec.getModifiedFields().clear();
             vctRtn.add(rec);
            }
            htSubSystemRecords=new Hashtable();
          }else{
            StringBuffer sbsql=new StringBuffer();
            sbsql.append("select a.*, ");
            sbsql.append("'' as DEBIT_AMT,");
            sbsql.append("'' as CREDIT_AMT,");
            sbsql.append("(select REC_DESC from gv_acc_data where ACC_CODE=A.VH_ACCOUNT and rownum=1) ");
            sbsql.append("as ACC_TW_NAME  ");
            sbsql.append(" from VH_DETAIL a where  ");
            sbsql.append("a.vh_no='");sbsql.append(VH_NO);sbsql.append("' order by VH_SEQ ");

            Vector vctOrg=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                util.PublicVariable.USER_RECORD,
                sbsql.toString(),1,9999);
            for(int i=0;i<99;i++){
              if(i<vctOrg.size()){
                Record rec = (Record)vctOrg.get(i);
                rec.set(2,i+1);
                //rec.getFieldName().add("DEBIT_AMT");
                //rec.getFieldName().add("CREDIT_AMT");
                Object amtObj=rec.get(6);
                if(null==ahDateValue)ahDateValue=rec.get(3);//VH_DATE
                //if AH_CD is 'D',set to debit total amnt or set to credit amnt
                if("D".equals(rec.get(5))){
                  //rec.getValueFields().add(amtObj);
                  //rec.getValueFields().add(null);
                  rec.set("DEBIT_AMT",amtObj);
                  rec.set("CREDIT_AMT",null);
                }else{
                  rec.set("DEBIT_AMT",null);
                  rec.set("CREDIT_AMT",amtObj);
                  //rec.getValueFields().add(null);
                  //rec.getValueFields().add(amtObj);
                }
                String orgAccZhTwName=(String)rec.get("ACC_TW_NAME");
                if(orgAccZhTwName==null){
                  rec.set("ACC_TW_NAME",newtimes.general_voucher.daily_voucher.Constants.NO_SUCH_ACCOUNT_CODE);
                }
                /*
                rec.getFieldName().add("ACC_TW_NAME");
                String zhTwAccName=(String)hmAccCodeMp.get((String)rec.get(4));//VH_ACCOUNT

                if(null==zhTwAccName){
                    rec.getValueFields().add(newtimes.general_voucher.daily_voucher.Constants.NO_SUCH_ACCOUNT_CODE);
                }else{
                    rec.getValueFields().add(zhTwAccName);
                }
                */
                rec.getModifiedFields().clear();
                vctRtn.add(rec);
              }else{
                Record rec=getBlankRecord();
                rec.set(2,i+1);
                rec.set(3,ahDateValue);
                rec.set(1,VH_NO);
                //rec.getModifiedFields().clear();
                vctRtn.add(rec);
              }
            }

          }
          newtimesejb.dailyVoucher.DailyVoucherFacadeHome ejbHome=
              (newtimesejb.dailyVoucher.DailyVoucherFacadeHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(
              util.PublicVariable.SERVER_URL,
              "newtimesejb.dailyVoucher.DailyVoucherFacade");
            newtimesejb.dailyVoucher.DailyVoucherFacade ejb=ejbHome.create();
            htSubSystemRecords=ejb.getSubsystemRecords(VH_NO);
            return vctRtn;
      }

    }


}
