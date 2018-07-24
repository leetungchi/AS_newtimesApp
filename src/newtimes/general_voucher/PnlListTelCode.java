package newtimes.general_voucher;
import java.awt.*;
import exgui.*;
import javax.swing.*;
import java.awt.event.*;
import database.datatype.Record;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListTelCode extends exgui.ultratable.FuncAbstractUltraTablePanel {
  static String CODE_COLUMN="CODE";
  static String COMPANY_COLUMN="      公司    ";
  static String GROUP_COLUMN="GROUP";
  static String NUMBER_COLUMN=" 號碼 ";
  static String DESCRIPTION_COLUMN="     說明       ";
  public PnlListTelCode(){
    /*
    public PnlListTelCode(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
     */
        super();
        getLowerRightPanel().removeAll();

        JButton btnUpdate=new JButton("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent e) {
             try{
               doUpdate();
             }catch(Exception exp){
               exp.printStackTrace();
              }
          }
        });


        JButton btnExit=new JButton("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent e) {
             try{
                processhandler.template.Properties.getCenteralControler().goBack();
             }catch(Exception exp){
               exp.printStackTrace();
              }
          }
        });
        getLowerRightPanel().add(btnUpdate);
        getLowerRightPanel().add(btnExit);
        getJtable().addMouseListener(
           new DelBtnClick()
        );
    }
    public void makeTable(Vector vct){
      super.makeTable(vct);
       getJtable().setRowHeight(20);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(50);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(200);
      getJtable().getColumnModel().getColumn(2).setPreferredWidth(80);
      getJtable().getColumnModel().getColumn(3).setPreferredWidth(109);
      getJtable().getColumnModel().getColumn(4).setPreferredWidth(258);
    }
    class DelBtnClick extends java.awt.event.MouseAdapter{
      public void mouseClicked(java.awt.event.MouseEvent me){
        if(getJtable().getSelectedColumn()!=5)return;
        Record rec=(Record)getDisplayingRecords().get(
          getJtable().getSelectedRow());
         try{
           //new record
           if (rec.getInt(7) == -1)return;
           if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete This Row ?","Are You Sure To delet ?",false))return;
           rec.set(7,"0");
           getDisplayingRecords().set(getJtable().getSelectedRow(),rec);
           doUpdate();
         }catch(Exception exp){
           exp.printStackTrace();
         }
      }
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return 999999;}
    public Hashtable getObject2StringConvertor() {
      Hashtable ht=new Hashtable();
      ht.put(CODE_COLUMN,exgui.verification.CellFormat.getOrdinaryField(3));
      ht.put(GROUP_COLUMN,exgui.verification.CellFormat.getOrdinaryField(15));
      ht.put(NUMBER_COLUMN,exgui.verification.CellFormat.getOrdinaryField(20));
      ht.put(DESCRIPTION_COLUMN,exgui.verification.CellFormat.getOrdinaryField(100));
      return ht;
    }
    public util.InsertionOrderedHashMap getHeadColumnMap(){
      util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
      iso.put(CODE_COLUMN,"CODE");
      iso.put(COMPANY_COLUMN,"COMPANY");
      iso.put(GROUP_COLUMN,"GRP");
      iso.put(NUMBER_COLUMN,"SyS_CODE");
      iso.put(DESCRIPTION_COLUMN,"remark");
      iso.put("DELETE","DLT");
      return iso;
    }
    boolean ifAllRowReady(){
      Hashtable htTestCode=new Hashtable();
      for(int i=0;i<getJtable().getRowCount();i++){
        String code=(String)getJtable().getValueAt(i,0);
        if(code==null||code.trim().length()==0)  continue;
        if (htTestCode.containsKey(code)) {
          exgui.verification.VerifyLib.showAlert("CODE:" + code + " Duplicated!!",
                                                 "Code Duplicate");
          return false;
        }
        exgui.ultratable.Wraper4tblCbx cbxCmp=(exgui.ultratable.Wraper4tblCbx)getJtable().getValueAt(i,1);
        if(cbxCmp.getValue()==null){
          exgui.verification.VerifyLib.showAlert("Please Select Company For :" + code + " ",
                                                 "Please Select Company");

          return false;
        }
        String grpCode=(String)getJtable().getValueAt(i,2);
        if(grpCode==null||grpCode.trim().length()==0){
          exgui.verification.VerifyLib.showAlert("Please Assigne GROUP For :" + code + " ",
                                                 "Please Assigne GROUP");

          return false;
        }

        String number=(String)getJtable().getValueAt(i,3);
        if(number==null||number.trim().length()==0){
          exgui.verification.VerifyLib.showAlert("Please Assigne 號碼 For :" + code + " ",
                                                 "Please Assigne 號碼");

          return false;
        }
        String desc=(String)getJtable().getValueAt(i,4);
        if(number==null||number.trim().length()==0){
          exgui.verification.VerifyLib.showAlert("Please Assigne Description For :" + code + " ",
                                                 "Please Assigne Description");

          return false;
        }
      }
      return true;
    }
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return new Db4List();}
    public Record setObject2Record(Record rec,int col,Object obj){
       try{
         if(col==2){
           if(!(obj==null || obj.toString().trim().length()==0)){
             String grpCode=obj.toString().trim();
             grpCode=util.MiscFunc.Replace(grpCode," ",",");
             grpCode=","+grpCode+",";
             //System.out.println("finally GRP is "+grpCode);
             rec.set(storedRecordColumn[col],grpCode);
           }else{
             rec.set(storedRecordColumn[col], obj);
           }
           return rec;
         }
          rec.set(storedRecordColumn[col], obj);
          rec.set(11,util.PublicVariable.USER_RECORD.get(0));//record modify user.
         return rec;
       }catch(Exception exp){
         exp.printStackTrace();
         return null;
       }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(getObject2StringConvertor());
      CellRender rnd=new CellRender();
      getJtable().getColumnModel().getColumn(getJtable().getColumnCount()-1).setCellRenderer(rnd);
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).setCellEditablePolicy(
        new CellEditablePolicyCls()
      );
      StringBuffer sb=new StringBuffer();
      sb.append("select  ");
      sb.append("substr(field_name,length(field_name),1) as cmp_code, ");
      sb.append("substr(field_name,length(field_name),1)||'--'||field_desc as cmp_name ");
      sb.append("from TPE_DATE_RANGE  ");
      sb.append("where field_name like 'GV_COMP_%' ");
      sb.append("order by cmp_code ");
      try{
        Vector vctCmp = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
            util.PublicVariable.USER_RECORD, sb.toString(), 1, 9999
            );
        Record recAll=(Record)util.MiscFunc.deepCopy(vctCmp.get(0));
        recAll.set(0,"X");
        recAll.set(1,"ALL");
        vctCmp.add(recAll);
        Record recNone=(Record)util.MiscFunc.deepCopy(vctCmp.get(0));
        recNone.set(0,null);
        recNone.set(1,"");
        vctCmp.add(recNone);
       me.addJComboBox(1, vctCmp,"CMP_NAME", "CMP_CODE");
      }catch(Exception exp){
        exp.printStackTrace();
      }

    }

    public void doUpdate()throws Exception{
        if(!ifAllRowReady())return;
        super.updateModifiedRecord();
    }
    class CellRender extends JLabel
        implements javax.swing.table.TableCellRenderer{
        public CellRender(){
        super();
       setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
       setOpaque(true); /* it\u00B4s essential */
       setHorizontalAlignment(JLabel.CENTER);
    }
     public Component getTableCellRendererComponent(
           javax.swing.JTable table, Object value,
           boolean isSelected, boolean hasFocus,
           int row, int column){
          String text = (value==null)?"":value.toString();
          if(text.trim().equals("")){
            setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
          }else{
              setBackground(new java.awt.Color(0xE0, 0xE0, 0xE0)); // Decides the color
          }
          setText(text);
       return this;
      }
    }
    class CellEditablePolicyCls implements exgui.CellEditablePolicy{
    public boolean isCellEditable(int row,int col){
      Record rec=(Record)getDisplayingRecords().get(row);
      if(col==0){
        if (rec.getInt(7)==1){
          return false;
        }
      }
     return true;
   }
}


    class Db4List extends exgui.ultratable.PagedDataFactoryAdapter{
      public void updateRecords(Vector vct2update){
        try {
          //in init phase
          if(null==getDisplayingRecords())return;
          //find out if any record need to delete
          for(int i=0;i<getDisplayingRecords().size();i++){
            Record rec=(Record)getDisplayingRecords().get(i);
            if(rec.getInt(7)==0){
              vct2update.add(rec);
            }
          }
          for(int i=0;i<vct2update.size();i++){
            System.out.println(" recod 2 update is ==>"+vct2update.get(i).toString());
          }
          newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
              (newtimesejb.TPE_MIS.TpeMisFuncHome)
              info_ejb.WeblogicServiceLocator.locateServiceHome(
              util.PublicVariable.SERVER_URL,
              "newtimesejb.TPE_MIS.TpeMisFunc");

          newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
          java.util.HashMap hmParam=new java.util.HashMap();
          hmParam.put("TPEMISCFUNC_ACTION_CODE","PROCESS_UPDATE_TEL_CODE");
          hmParam.put("VCT_UPDATE_TEL_CODE",vct2update);
          ejb2update.tpeMisFunc(hmParam);
          reload();
        }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"");
          exgui.verification.VerifyLib.showAlert("Error While Update Reocrd",
                                                 "Update Failed!!");
        }

      }
      public Vector getRecords(int bgn,int rowcount )throws Exception{
      StringBuffer sb=new StringBuffer();
      sb.append("select ");
      sb.append("a.*, ");
      /*
      sb.append("(select B.FIELD_DESC from tpe_date_range b  where substr(b.field_name,length(b.field_name),1)=A.COMPANY )as cmp_name, ");
      */
      sb.append("'...' as DLT ");
      sb.append("from vh_tel_code a ");
      sb.append("order by a.code ");

       Vector vct2return=new Vector();
        Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        sb.toString(),1,99999);
        for(int i=0;i<vct.size();i++){
          Record rec=(Record)vct.get(i);
          String grpCode=(String)rec.get(2);
          if(null!=grpCode){
            String reGrpCode=util.MiscFunc.Replace(grpCode,","," ").trim();
            rec.set(2,reGrpCode);
          }
          rec.getModifiedFields().clear();
          vct2return.add(rec);
        }
        Record blank=(Record)util.MiscFunc.deepCopy(vct.get(0));
        for(int i=0;i<blank.getFieldName().size();i++){
          blank.set(i,null);
        }
        blank.getModifiedFields().clear();
        blank.set(5,util.PublicVariable.USER_RECORD.get(0));
        blank.set(7,-1);
        //add 10 blank row.
        //set to delete flag = -1;
        for(int i=0;i<10;i++){
          Record blank2Ins=(Record)util.MiscFunc.deepCopy(blank);
          vct2return.add(blank2Ins);
        }
       return vct2return;
      }
    }

  }
