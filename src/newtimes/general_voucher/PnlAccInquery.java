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

public class PnlAccInquery extends JPanel {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  /*
  JButton btnDel = new JButton();
  JButton btnExit = new JButton();
  */
  //JPanel pnl2list = new JPanel();
  Panel2List pnl2list=null;
  java.text.NumberFormat nf=new java.text.DecimalFormat("###,###,###,##0.00");
  public PnlAccInquery() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("VOUCHER ACCOUNT LIST");
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("年月","YYYYMM");//0
    iso.put(" ACC CODE  ","ACC_CODE");//1
    iso.put(" C/D ","D_C");//2
    iso.put("      期初金額      ","INIT_AMT");//3
    iso.put("     本期借方金額     ","D_AMT");//4
    iso.put("     本期貸方金額     ","C_AMT");//5
    iso.put("      期末餘額      ","BLNC_AMT");//6
    pnl2list=new Panel2List(new TempDb(),99999,iso,new Hashtable());
    pnl2list.firstPage();

    blueBkgWhiteCharLabel1.setFont(new java.awt.Font("新細明體", 0, 16));
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-3, 22, 802, 31));
    this.setLayout(null);
    /*
    btnDel.setBounds(new Rectangle(105, 559, 134, 28));
    btnDel.setFont(new java.awt.Font("Dialog", 1, 11));
    btnDel.setText("DELETE");
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(543, 559, 134, 28));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    */
    pnl2list.setBounds(new Rectangle(16, 70, 761, 486));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnl2list, null);
    blueBkgWhiteCharLabel1.setText(getTitile());
    /*
    this.add(btnExit, null);
    this.add(btnDel, null);
    */
  }
  class CellRenderRowHead extends JLabel
    implements javax.swing.table.TableCellRenderer{
    public CellRenderRowHead(){
    super();
   //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
   setOpaque(true); /* it\u00B4s essential */
   setHorizontalAlignment(super.LEFT);
 }
 public Component getTableCellRendererComponent(
       javax.swing.JTable table, Object value,
       boolean isSelected, boolean hasFocus,
       int row, int column){
      String text = (value==null)?"":value.toString();
      boolean isTotalRow;
      boolean isGrandTotal;
      Object firstCell=pnl2list.getJtable().getValueAt(row,0);
      firstCell=(firstCell==null)?"":firstCell.toString();
      isTotalRow=(firstCell.toString()).equalsIgnoreCase("TOTAL");
      isGrandTotal=(firstCell.toString()).equalsIgnoreCase("G-TTL");
      if(isGrandTotal){
        //FFCCCC
        setBackground(new java.awt.Color(0x90,0xFF,0x90)); // Decides the color
        if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
        setText(text);
        return this;
      }


      if(isTotalRow){
        setBackground(new java.awt.Color(0xFF, 0xCC, 0xCC)); // Decides the color
      }else{
        setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
      }
      if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
      setText(text);
   return this;
  }
 }

  class CellRenderAmt extends JLabel
     implements javax.swing.table.TableCellRenderer{
     public CellRenderAmt(){
     super();
    //setBorder(javax.swing.BorderFactory.createRaisedBevelBorder());
    setOpaque(true); /* it\u00B4s essential */
    setHorizontalAlignment(super.RIGHT);
 }
  public Component getTableCellRendererComponent(
        javax.swing.JTable table, Object value,
        boolean isSelected, boolean hasFocus,
        int row, int column){
        String text = (value==null)?"":value.toString();
        boolean isTotalRow;
        boolean isGrandTotal;
        Object firstCell=pnl2list.getJtable().getValueAt(row,0);
        firstCell=(firstCell==null)?"":firstCell.toString();
        isTotalRow=(firstCell.toString()).equalsIgnoreCase("TOTAL");
        isGrandTotal=(firstCell.toString()).equalsIgnoreCase("G-TTL");
        if(isGrandTotal){
          //FFCCCC
          setBackground(new java.awt.Color(0x90,0xFF,0x90)); // Decides the color
          if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
          if(!text.equals("") && column!=0){
            text=nf.format(Double.parseDouble(text));
          }
          setText(text);
          return this;
        }

        if(isTotalRow){
          //FFCCCC
          setBackground(new java.awt.Color(0xFF, 0xCC, 0xCC)); // Decides the color
          if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));
          if(!text.equals("") && column!=0){
            text=nf.format(Double.parseDouble(text));
          }
          setText(text);
          return this;
        }

       setBackground(new java.awt.Color(0xFF, 0xFF, 0xFF)); // Decides the color
       if(isSelected)setBackground(new java.awt.Color(0xFF, 0xE3, 0x8C));

       if(!text.equals("") && column!=0){
         text=nf.format(Double.parseDouble(text));
       }
       setText(text);
    return this;
   }
 }


  class TempDb extends exgui.ultratable.PagedDataFactoryAdapter{
     DbAccData db2handle=new DbAccData();
     TempDb(){
     }
     public void updateRecords(Vector vct)throws Exception{
       db2handle.updateRecords(vct);
     }
     public Vector getRecords(int bgn,int rowcount)throws Exception{
        //PnlAccDataMaintainQry.QUERY_STRING="select * from GV_ACC_DATA where record_delete_flag='1' order by yyyymm,acc_code";
        Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          PnlAccDataMaintainQry.QUERY_STRING,bgn,rowcount
        );

        String lastYYYYMM="";
        Record recDummy=null;
        if(vct.size()>0){
          Vector vctMakeUp=new Vector();
          double ttl_Init_Amt=0,ttl_D_Amt=0,ttl_C_Amt=0,ttl_Blnc_Amt=0;
          double gd_ttl_Init_Amt=0,gd_ttl_D_Amt=0,gd_ttl_C_Amt=0,gd_ttl_Blnc_Amt=0;
          for(int i=0;i<vct.size();i++){
            Record rec=(Record)vct.get(i);
            String currentYYYYMM=null;
            Object objyyyymm=rec.get("YYYYMM");
            if(objyyyymm==null)currentYYYYMM="";else currentYYYYMM=objyyyymm.toString();
            if(i==0)lastYYYYMM=currentYYYYMM;
            if(!currentYYYYMM.equals(lastYYYYMM)){
              recDummy= exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("GV_ACC_DATA_tbl");
              recDummy.set(3,"TOTAL");
              recDummy.set(7,ttl_Init_Amt);
              recDummy.set(8,ttl_D_Amt);
              recDummy.set(9,ttl_C_Amt);
              recDummy.set(10,ttl_Blnc_Amt);
              vctMakeUp.add(recDummy);
              ttl_Init_Amt=0;ttl_D_Amt=0;ttl_C_Amt=0;ttl_Blnc_Amt=0;
              lastYYYYMM=currentYYYYMM;
            }
            if(rec.get(7)!=null) {
              ttl_Init_Amt+=Double.parseDouble(rec.get(7).toString());
              gd_ttl_Init_Amt+=Double.parseDouble(rec.get(7).toString());
            }
            if(rec.get(8)!=null) {
              ttl_D_Amt += Double.parseDouble(rec.get(8).toString());
              gd_ttl_D_Amt += Double.parseDouble(rec.get(8).toString());
            }
            if(rec.get(9)!=null) {
              ttl_C_Amt+=Double.parseDouble(rec.get(9).toString());
              gd_ttl_C_Amt+=Double.parseDouble(rec.get(9).toString());
            }
            if(rec.get(10)!=null){
              ttl_Blnc_Amt+=Double.parseDouble(rec.get(10).toString());
              gd_ttl_Blnc_Amt+=Double.parseDouble(rec.get(10).toString());
            }
            rec.set(4,"    "+rec.get(4).toString());
            double balance=(rec.get(10)==null)?0:rec.getDouble(10);
            rec.set(10,(balance==0)?"":String.valueOf(balance));
            vctMakeUp.add(rec);
          }
          //add last total;
          recDummy= exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("GV_ACC_DATA_tbl");
          recDummy.set(3,"TOTAL");
          recDummy.set(7,ttl_Init_Amt);
          recDummy.set(8,ttl_D_Amt);
          recDummy.set(9,ttl_C_Amt);
          recDummy.set(10,ttl_Blnc_Amt);
          vctMakeUp.add(recDummy);

          recDummy= exgui2.CONST.BASIC_MAIN_EJB.getBlankRecord("GV_ACC_DATA_tbl");
          recDummy.set(3,"G-TTL");
          recDummy.set(7,gd_ttl_Init_Amt);
          recDummy.set(8,gd_ttl_D_Amt);
          recDummy.set(9,gd_ttl_C_Amt);
          recDummy.set(10,gd_ttl_Blnc_Amt);
          vctMakeUp.add(recDummy);

          return vctMakeUp;
        }
        return vct;
     }
  }
  String getTitile(){
    StringBuffer sb=new StringBuffer();
    String accCode=((javax.swing.text.JTextComponent)Constants.PNL_ACC_MAINTAIN_QRY.dbCbxTblAccItem.getGUIcomponent()).getText();
    sb.append("   ");
    sb.append(accCode);
    sb.append("   ");
    Record recAccItem=(Record)Constants.HT_ACC_ITEM.get(accCode.substring(0,4));
    String d_c=(String)recAccItem.get(2);
    sb.append(d_c);
    sb.append("   ");
    if(accCode.trim().length()==4){
      sb.append(recAccItem.get(3));
    }else{
      if (pnl2list.getDisplayingRecords().size() == 0) {
        sb.append("N/A");
      } else {
        Record rec = (Record)pnl2list.getDisplayingRecords().get(0);
        String strDesc = (String)rec.get(6);
        sb.append((strDesc == null) ? "" : strDesc);
      }
    }


    return sb.toString();
  }

  class Panel2List extends exgui.ultratable.FuncAbstractUltraTablePanel {
    public Panel2List(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
        getLowerRightPanel().removeAll();
        JButton btnExit=new JButton("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent e) {
           btnExit_actionPerformed(e);
          }
        });
        getLowerRightPanel().add(btnExit);
    }
    public void makeTable(Vector vct){
      super.makeTable(vct);
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(45);
      getJtable().getColumnModel().getColumn(1).setPreferredWidth(69);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    public Record setObject2Record(Record rec,int col,Object obj){
       try{
         rec.set(storedRecordColumn[col],obj);
         return rec;
       }catch(Exception exp){
         exp.printStackTrace();
         return null;
       }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      me.setTextEditorVerifiers(getObject2StringConvertor());
      CellRenderAmt rnd=new CellRenderAmt();
      getJtable().getColumnModel().getColumn(0).setCellRenderer(rnd);

      CellRenderRowHead rndAccCode=new CellRenderRowHead();
      getJtable().getColumnModel().getColumn(1).setCellRenderer(rndAccCode);

      getJtable().getColumnModel().getColumn(2).setCellRenderer(rndAccCode);


      for(int i=3;i<getJtable().getColumnCount();i++) getJtable().getColumnModel().getColumn(i).setCellRenderer(rnd);
    }
    public void doUpdate()throws Exception{
        super.updateModifiedRecord();
    }
  }
  void btnExit_actionPerformed(ActionEvent e) {
    try{
       processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
     }

  }
}
