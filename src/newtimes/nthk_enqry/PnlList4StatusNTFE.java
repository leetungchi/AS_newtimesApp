package newtimes.nthk_enqry;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import java.util.Hashtable;
import java.util.*;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlList4StatusNTFE extends AbstractUltraTablePanel {
  HashMap hmScStatusMap=new HashMap();
  HashMap hmCancelScReasonMap=new HashMap();
  javax.swing.JButton btnExit=new javax.swing.JButton("EXIT");
  javax.swing.JButton btnUpdate=new javax.swing.JButton("update status");

  MyMouseActionListener axnListener=new MyMouseActionListener();
  static Vector vctStatus=null;
  javax.swing.JComboBox cbxStatus;
  static HashMap hmSelectWraper4tblCbx=null;
  static boolean isMakingTable=true;
  HashMap hmIsCellEditable=null;
  boolean isHandlingComboboxChange=false;
  ItemStateChangeAdpt statChangeAdpt=new ItemStateChangeAdpt();
  int isEditingRow=-1,isEditingColumn=-1;
  TblAdpater mouseClickApt=new TblAdpater();
  static exgui.ultratable.Wraper4tblCbx statusSelec[]=new exgui.ultratable.Wraper4tblCbx[]{
               new exgui.ultratable.Wraper4tblCbx("1","PENDING"),
               new exgui.ultratable.Wraper4tblCbx("2","Send2Comfirm"),
               //send confirm is same as confirmed,we may need toconver status code,after system launch
               new exgui.ultratable.Wraper4tblCbx("3","APPROVAL"),
               new exgui.ultratable.Wraper4tblCbx("4","CANCEL")};

  /*
             Production status 1:起始編輯(Initial),
                             2:送主管確認(Send),
                             3:主管已確認(Confirm),
                             4:主管退回(Return),
                             5:已印製(Print)
                             6:S/T combine.
                             7:shipping
         only 1 ediing(panding)/3 confirm(approval)/4 rejected(cancel) are required.
   */
  class MyMouseActionListener implements java.awt.event.ActionListener {
    public void actionPerformed(java.awt.event.ActionEvent e) {
      try{
        if(e.getSource()==btnUpdate){
          if(hmScStatusMap.isEmpty()){
            processhandler.template.Properties.getCenteralControler().goBack();
            return;
          }
          confirmUpdate();
          util.MiscFunc.showProcessingMessage();
          ((newtimes.nthk_enqry.EnqDataEngin4Status)dbHandler).updatePoStatus(
            hmScStatusMap,hmCancelScReasonMap);
          util.MiscFunc.hideProcessingMessage();
          processhandler.template.Properties.getCenteralControler().goBack();
          return;
        }
        if(e.getSource()==btnExit){
          confirmUpdate();
          if(!hmScStatusMap.isEmpty()){
            if(!exgui.verification.VerifyLib.showConfirm(
              "Production Status Modified But Not Confirmed Yet\nDo You Want to Exit without Confirmation ?",
              "Status Code Modified",false)){
              return;
            }
          }
          processhandler.template.Properties.getCenteralControler().goBack();
        }
      }catch(Exception ie){
        ie.printStackTrace();
      }
    }
  }
  class EditablePolicy implements exgui.CellEditablePolicy{
    public boolean isCellEditable(int row,int column){
      isEditingColumn=column;
      isEditingRow=row;
      if(column==6)return true;
      if(column!=7)return false;

      Record rec=(Record)(Record)getDisplayingRecords().get(row);
      try{
        String sc_no=(String)rec.get(1);
        if(sc_no==null)return false;
        String status=(String)rec.get(28);
        if (status.equalsIgnoreCase("7")) {
         return false;
        }
        return true;
      }catch(Exception exx){
       exx.printStackTrace();
       return false;
      }
    }
  }
  class TblAdpater extends java.awt.event.MouseAdapter{
     public void mouseClicked(java.awt.event.MouseEvent me){
          if(getJtable().columnAtPoint(me.getPoint())!=6)return;
          isEditingRow=getJtable().rowAtPoint(me.getPoint());
          Record recPo=(Record)getDisplayingRecords().get(isEditingRow);
          PnlItemDtl pnl=new PnlItemDtl();
          pnl.setSize(800,600);
          try{
            javax.swing.JDialog dlg=new javax.swing.JDialog(util.PublicVariable.APP_FRAME,
                                                            "Detail Of PO",
                                                            true);
            dlg.setSize(810,600);
            pnl.initByRecord(recPo,dlg);
            dlg.getContentPane().setLayout(new java.awt.BorderLayout());
            dlg.getContentPane().add(pnl,java.awt.BorderLayout.CENTER);
            dlg.show();
          }catch(Exception epx){
            epx.printStackTrace();
            util.ExceptionLog.exp2File(epx,"");
            exgui.verification.VerifyLib.showAlert("Error While Init-Style Detail GUI\nPlease Contact System Manager",
                                                   "Error While Init-Style Detail GUI");
          }

     }
  }
  class ItemStateChangeAdpt implements java.awt.event.ItemListener{
    public void itemStateChanged(java.awt.event.ItemEvent ie){

      if(isMakingTable)return;
      if(isHandlingComboboxChange)return;
      if(ie.getSource()!=cbxStatus)return;
      if(ie.getStateChange()==ie.DESELECTED)return;
      isHandlingComboboxChange=true;
      int editingRow=isEditingRow;//getJtable().getSelectedRow();
      //if(editingRow==-1)editingRow=getJtable().getEditingRow();
      Record recEditing=(Record)getDisplayingRecords().get(editingRow);
      try{
        String OrgStatus=(String)recEditing.get(28);
        exgui.ultratable.Wraper4tblCbx obj=(exgui.ultratable.Wraper4tblCbx)cbxStatus.getSelectedItem();
        if(OrgStatus.equals(obj.getValue())){
          isHandlingComboboxChange=false;
          return;
        }
        if(obj.getValue().equals("4")){
          //cancellation,need reason
          DlgCancelReason dlg=new DlgCancelReason(util.PublicVariable.APP_FRAME,
                                                  "Cancellation",true);
          dlg.setSize(520,400);
          exgui.UIHelper.setToScreenCenter(dlg);
          dlg.show();
          if(dlg.txtReason.getText().trim().length()==0){
            //reset to org status,if no reason
            exgui.ultratable.Wraper4tblCbx orgCbx=
                (exgui.ultratable.Wraper4tblCbx)hmSelectWraper4tblCbx.get(OrgStatus);
            cbxStatus.setSelectedItem(orgCbx);
            //getJtable().setValueAt(orgCbx,editingRow,7);
            isHandlingComboboxChange=false;
            return;
          }else{
            hmCancelScReasonMap.put((String)recEditing.get(1),
                                    dlg.txtReason.getText().trim());
          }
        }
        String sc_no=(String)recEditing.get(1);
        hmScStatusMap.put(sc_no,obj.getValue());
        recEditing.set(28,obj.getValue());
        //System.out.println(" selected item is "+obj.getValue());
        isHandlingComboboxChange=false;

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }
  public PnlList4StatusNTFE(EnqDataEngin pagedDataFxy,
         int rowCount,util.InsertionOrderedHashMap columnMapping,
         java.util.Hashtable object2StringConvertor
     ){
      super(pagedDataFxy,
            rowCount,
            columnMapping,
            object2StringConvertor
            );
      try{
        if(hmScStatusMap==null)hmScStatusMap=new HashMap();
        if(vctStatus==null){
          vctStatus=new Vector();
          Record recBlankState=exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("unit_tbl");
          recBlankState.getFieldName().clear();
          recBlankState.getValueFields().clear();
          recBlankState.getFieldName().add("CODE");
          recBlankState.getValueFields().add(null);
          recBlankState.getFieldName().add("NAME");
          recBlankState.getValueFields().add(null);

          Record rec1=(Record)util.MiscFunc.deepCopy(recBlankState);
          rec1.set(0,"1");
          rec1.set(1,"PENDING");
          //vctStatus.add(rec1);
          statusSelec[0].setValue(rec1.get(0));
          statusSelec[0].setString((String)rec1.get(1));

          Record rec2=(Record)util.MiscFunc.deepCopy(recBlankState);
          rec2.set(0,"2");
          rec2.set(1,"Send2Confirm");
          //vctStatus.add(rec2);
          statusSelec[1].setValue(rec2.get(0));
          statusSelec[1].setString((String)rec2.get(1));


          Record rec3=(Record)util.MiscFunc.deepCopy(recBlankState);
          rec3.set(0,"3");
          rec3.set(1,"APPROVAL");vctStatus.add(rec3);
          statusSelec[2].setValue(rec3.get(0));
          statusSelec[2].setString((String)rec3.get(1));

          Record rec4=(Record)util.MiscFunc.deepCopy(recBlankState);
          rec4.set(0,"4");
          rec4.set(1,"CANCEL");vctStatus.add(rec4);
          statusSelec[3].setValue(rec4.get(0));
          statusSelec[3].setString((String)rec4.get(1));
          hmSelectWraper4tblCbx=new HashMap();
          hmSelectWraper4tblCbx.put("1",statusSelec[0]);
          hmSelectWraper4tblCbx.put("2",statusSelec[1]);
          hmSelectWraper4tblCbx.put("3",statusSelec[2]);
          hmSelectWraper4tblCbx.put("4",statusSelec[3]);

        }
         super.doInit();
         getLowerRightPanel().add(btnExit);
         getLowerRightPanel().add(btnUpdate);
         btnExit.addActionListener(axnListener);
         btnUpdate.addActionListener(axnListener);
         this.firstPage();
         this.getJtable().addMouseListener(mouseClickApt);
      }catch(Exception exp){
        exp.printStackTrace();

      }
  }
  public class CellRender extends JLabel
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
        setBackground(new java.awt.Color(0xF0,0xF0,0xF0)); // Decides the color
        setText(text);
     return this;
    }
  }
  public void makeTable(Vector vctRecords){
    try{
      isMakingTable=true;
      for (int i = 0; i < vctRecords.size(); i++) {
        Record rec = (Record)vctRecords.get(i);
        String sc = (String)rec.get(1);
        if(sc!=null){
          Object status=hmScStatusMap.get(sc);
          if(status!=null){
            //getJtable().setValueAt(isCheck,i,7);
            rec.set(28,status);
          }else{
            //getJtable().setValueAt(isUnCheck,i,7);
            //rec.set("testCheck","");
          }
        }
      }
      super.makeTable(vctRecords);
      for (int i = 0; i < vctRecords.size(); i++) {
        Record rec = (Record)vctRecords.get(i);
        String statusCode=(String)rec.get(28);
        if(statusCode.equals("7")){
          exgui.ultratable.Wraper4tblCbx objShipStatus=new
              exgui.ultratable.Wraper4tblCbx("7","SHIPPED");
          getJtable().setValueAt(objShipStatus,i,7);
        }
      }
      EditablePolicy edtPolicy=new EditablePolicy();
      ((exgui.MultiClassTableModel)getJtable().getModel()).setCellEditablePolicy(edtPolicy);

    }catch(Exception exp){
      exp.printStackTrace();
    }
    isMakingTable=false;
  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");

    try{
      if("7".equals(value2update))return null;
      String sc_no =(String) rec.get(1);
      hmScStatusMap.put(sc_no, value2update);
    }catch(Exception exp){
      exp.printStackTrace();
    }
    return null;
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getHeadColumnMap() not yet implemented.");
    return tblHeadColumn;
  }
  protected int getEachPageRowCount() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    return _rowCounts;
  }

  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    this.getJtable().getColumnModel().getColumn(6).setCellRenderer(new CellRender());
    multiEditorJTableInSuper.addJComboBox(7,vctStatus,"name","code");
    isMakingTable=true;
    cbxStatus=
        (JComboBox)((DefaultCellEditor)getJtable().getColumnModel().getColumn(7).getCellEditor()).getComponent();

    java.awt.event.ItemListener items2listen[]=
        cbxStatus.getItemListeners();
    for(int i=0;i<items2listen.length;i++){
      cbxStatus.removeItemListener(items2listen[i]);
    }
    cbxStatus.addItemListener(statChangeAdpt);
    isMakingTable=false;
    multiEditorJTableInSuper.setTextEditorVerifiers(getObject2StringConvertor());

  }
  protected Hashtable getObject2StringConvertor() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getObject2StringConvertor() not yet implemented.");
    return klmObjKvtHt;
  }
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    //throw new java.lang.UnsupportedOperationException("Method getPagedDataFactory() not yet implemented.");
    return dbHandler;
  }

}
