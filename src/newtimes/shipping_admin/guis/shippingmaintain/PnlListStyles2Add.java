package newtimes.shipping_admin.guis.shippingmaintain;

import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.Hashtable;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlListStyles2Add extends PnlTableEditor  {
  static final String BUYER="  Buyer  ";
  static final String FTY = "  Maker  ";
  //static final String DIV = "Division";
  //static final String SEA = "Season";
  //static final String YEAR = "Year";
  //static final String RANGE = "Range";
  static final String SC_NO = "    S/C NO.    ";
  static final String STYLE = "  Style  ";
  static final String PO = "  PO  ";
  static final String UNIT = "Unit";
  static final String O_QTY = "ORDER\nQTY";
  static final String S_QTY = "SHIP\nQTY";
  static final String B_QTY = "BALANCE\nQTY";
  static final String CLOSE="CLOSE";
  static InsertionOrderedHashMap iso = null;
  static public int rowPosition=-1;
  JButton btnAddSlkSc2ShipStyle=new JButton("ADD SELECTED");
  JTextField txtSize=new JTextField();
  JTextField txtQty=new JTextField();
  JButton btnAddSlkSc2ShipStyleWithSizeQty=new JButton("ADD SELECTED");
  JPanel  pnlBatchAddWithSizeQty=new JPanel();
  public PnlListStyles2Add() {
    getJtable().setRowHeight(20);
    getJtable().addMouseListener(new myMouseListener());
    newtimes.shipping_admin.process.shiippingmaintain.ToListAddedStyles.PAGE_BEGIN=0;
    if("001".equals(util.PublicVariable.USER_RECORD.get(4))
      && util.PublicVariable.USER_RECORD.getInt(2)==
      newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
      super.getLowerRightPanel().removeAll();
      pnlBatchAddWithSizeQty.setPreferredSize(new java.awt.Dimension(320,40));
      pnlBatchAddWithSizeQty.setBorder(new javax.swing.border.LineBorder(java.awt.Color.BLACK));
      pnlBatchAddWithSizeQty.setLayout(new java.awt.FlowLayout());
      pnlBatchAddWithSizeQty.add(new JLabel("SIZE:"));
      txtSize.setPreferredSize(new java.awt.Dimension(50,20));
      pnlBatchAddWithSizeQty.add(txtSize);
      txtQty.setPreferredSize(new java.awt.Dimension(50,20));
      pnlBatchAddWithSizeQty.add(new JLabel("QTY:"));
      pnlBatchAddWithSizeQty.add(txtQty);
      pnlBatchAddWithSizeQty.add(btnAddSlkSc2ShipStyleWithSizeQty);

      btnAddSlkSc2ShipStyle.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(ActionEvent e) {
             addAll2ShipStyle(false);
         }
       });
       btnAddSlkSc2ShipStyleWithSizeQty.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(ActionEvent e) {
              addAll2ShipStyle(true);
          }
        });


      super.getLowerRightPanel().add(btnAddSlkSc2ShipStyle);
      super.getLowerRightPanel().add(pnlBatchAddWithSizeQty);
     }
  }
  void addAll2ShipStyle(boolean isHaveSizeQty){
    if(getJtable().getSelectedColumnCount()==0){
      exgui.verification.VerifyLib.showAlert("Please Select Row(s) To Add ",
                                             "Please Select Row(s) To Add ");
      return;
    }
    if(isHaveSizeQty){
      if(txtSize.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Size String",
                                               "Please Input Size String");
        return;

      }
      if(txtQty.getText().trim().length()==0){
        exgui.verification.VerifyLib.showAlert("Please Input Qty",
                                               "Please Input Qty");
        return;

      }
      try{
        float qty = Float.parseFloat(txtQty.getText().trim());
      }catch(Exception exp){
        exgui.verification.VerifyLib.showAlert("Error while Parsing Qty  to float",
                                               "Error while Parsing Qty  to float");
        return;
      }
    }
    //findout the sty_seq to add
    int rows[]=getJtable().getSelectedRows();
    java.util.Vector vctStySeq=new java.util.Vector();
    try{
      util.MiscFunc.showProcessingMessage();
      for (int i = 0; i < rows.length; i++) {
        Record rec = (Record)getDisplayingRecords().get(rows[i]);
        String stySeq = rec.get("sty_seq").toString();
        vctStySeq.add(stySeq);
      }

      ShippingAdmin.SRN_Style.ShipStyleFacadeHome ejbHome =
          (ShippingAdmin.SRN_Style.ShipStyleFacadeHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL,"ShippingAdmin.SRN_Style.ShipStyleFacade");
      ShippingAdmin.SRN_Style.ShipStyleFacade ejb = ejbHome.create();
      if(isHaveSizeQty){
        if(vctStySeq.size()>3){
          java.util.Vector vct2Work=new java.util.Vector();
          for(int i=0;i<vctStySeq.size();i++){
            vct2Work.add(vctStySeq.get(i));
            if(vct2Work.size()%3==0){
                 ejb.batchInsertScStyle2Shipping(vct2Work,
                                              newtimes.shipping_admin.
                                              ShippingAdmin_Const.
                                              CURRENT_EDITING_SHIP_SRN,
                                              util.PublicVariable.USER_RECORD.get(0).toString(),
                                              txtSize.getText().trim(),
                                              Float.parseFloat(txtQty.getText().trim())
                                              );
                vct2Work=new java.util.Vector();
              }
           }
            if(vct2Work.size()>0){
               ejb.batchInsertScStyle2Shipping(vct2Work,
                                            newtimes.shipping_admin.
                                            ShippingAdmin_Const.
                                            CURRENT_EDITING_SHIP_SRN,
                                            util.PublicVariable.USER_RECORD.get(0).toString(),
                                            txtSize.getText().trim(),
                                            Float.parseFloat(txtQty.getText().trim())
                                            );
            }

        }else{
             ejb.batchInsertScStyle2Shipping(vctStySeq,
                                          newtimes.shipping_admin.
                                          ShippingAdmin_Const.
                                          CURRENT_EDITING_SHIP_SRN,
                                          util.PublicVariable.USER_RECORD.get(0).toString(),
                                          txtSize.getText().trim(),
                                          Float.parseFloat(txtQty.getText().trim())
                                          );
        }

      }else{
        if(vctStySeq.size()<=3){
          ejb.batchInsertScStyle2Shipping(vctStySeq,
                                          newtimes.shipping_admin.
                                          ShippingAdmin_Const.
                                          CURRENT_EDITING_SHIP_SRN,
                                          util.PublicVariable.USER_RECORD.get(0).
                                          toString());
        }else{
          java.util.Vector vct2Work=new java.util.Vector();
          for(int i=0;i<vctStySeq.size();i++){
             vct2Work.add(vctStySeq.get(i));
             if(vct2Work.size() %3 ==0){
               ejb.batchInsertScStyle2Shipping(vct2Work,
                                               newtimes.shipping_admin.
                                               ShippingAdmin_Const.
                                               CURRENT_EDITING_SHIP_SRN,
                                               util.PublicVariable.USER_RECORD.get(0).
                                               toString());
                 vct2Work=new java.util.Vector();
             }
          }
              if(vct2Work.size()>0){
                ejb.batchInsertScStyle2Shipping(vct2Work,
                                                newtimes.shipping_admin.
                                                ShippingAdmin_Const.
                                                CURRENT_EDITING_SHIP_SRN,
                                                util.PublicVariable.USER_RECORD.get(0).
                                                toString());
              }

        }
      }
      exgui.verification.VerifyLib.showPlanMsg("Add OK!!","Add OK!!");
      this.reload();
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Add Failed!!\nPlease Contact System Manager",
                                             "Add Failed!!");

    }finally{
      util.MiscFunc.hideProcessingMessage();
    }


  }
  protected Record setObject2Record(Record rec, int columnAt, Object value2update) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    throw new java.lang.UnsupportedOperationException("Method setObject2Record() not yet implemented.");
  }
  public void firstPage(){
    if(rowPosition>0){
      goPage(rowPosition,_rowCounts);
    }else{
      super.firstPage();
    }
  }
  protected InsertionOrderedHashMap getHeadColumnMap() {
    if(iso == null){
      iso = new InsertionOrderedHashMap();
      iso.put(BUYER,"BUYER");
      iso.put(FTY, "FTY");
      //iso.put(DIV, "DIV");
      //iso.put(SEA, "SEA");
      //iso.put(YEAR, "YEAR");
      //iso.put(RANGE, "RANGE");
      iso.put(SC_NO, "SC_NO");
      iso.put(STYLE, "STYLE");
      iso.put(PO, "PO");
      iso.put(UNIT, "UNIT");
      iso.put(O_QTY, "O_QTY");
      iso.put(S_QTY, "S_QTY");
      iso.put(B_QTY, "B_QTY");
      iso.put(CLOSE,"CLOSED");
    }
    return iso;
  }
  public void doPrint() throws java.lang.Exception {
    /**@todo Implement this processhandler.DataProcesser abstract method*/
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
  }
  public void makeTable(java.util.Vector vct){
    super.makeTable(vct);
    //set width of eacht column
    getJtable().getColumnModel().getColumn(0).setPreferredWidth(60); //BUYER
    getJtable().getColumnModel().getColumn(1).setPreferredWidth(60); //MAKER
    getJtable().getColumnModel().getColumn(3).setPreferredWidth(160); //STYLE
    getJtable().getColumnModel().getColumn(4).setPreferredWidth(100); //PO
    getJtable().getColumnModel().getColumn(5).setPreferredWidth(40); //UNIT
    getJtable().getColumnModel().getColumn(6).setPreferredWidth(60); //Order Qty
    getJtable().getColumnModel().getColumn(7).setPreferredWidth(40); //Ship Qty
    getJtable().getColumnModel().getColumn(8).setPreferredWidth(60); //Balance Qty
    getJtable().getColumnModel().getColumn(9).setPreferredWidth(60); //CLOSE
    try{
      for (int i = 0; i < vct.size(); i++) {
        Record recTmp = (Record)vct.get(i);
        if (recTmp.getInt("sty_seq") ==
            newtimes.shipping_admin.ShippingAdmin_Const.
            EDIT_SHIP_STYLE_STYLE_INT_SEQ) {
          //System.out.print("row selected at:"+i);
          getJtable().changeSelection(i, 0, false, false);
          break;
        }
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }

  protected int getEachPageRowCount() {
    return 20;
  }
  protected Hashtable getObject2StringConvertor() {
    return null;
  }
  class myMouseListener extends java.awt.event.MouseAdapter{
    protected boolean isToAddAsShipStyle(){
     if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
       return true;
     }
     CustomMessage ShipPackingType= new CustomMessage();
      JOptionPane.showOptionDialog(
          util.PublicVariable.APP_FRAME,
          ShipPackingType,
          "Add For Shipping / Packing ",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.INFORMATION_MESSAGE,
          null,
          new String[] {"OK"},"OK");

       if(ShipPackingType.btnPacking.isSelected())return false;
       return true;
    }

    public void mouseClicked(java.awt.event.MouseEvent e){
      //find out the click row,and activate the edit new ship style record command.
     if(getJtable().getSelectedRow()==-1)return;

     if(getJtable().getSelectedColumn()==0
        && "001".equals(util.PublicVariable.USER_RECORD.get(4))
        && util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
        )return;
     /*
      if((e.getModifiers() & java.awt.event.InputEvent.BUTTON3_MASK) == java.awt.event.InputEvent.BUTTON3_MASK){
        return;
      }
     */
     Record rec=(Record)getDisplayingRecords().get(getJtable().getSelectedRow());
     if("NTHK".equals(util.PublicVariable.OPERATTING_CENTER)){
       //test if maker/buuer price are zero for nthk center
       try{
         Object objByrDocPrice = rec.get("STY_BYR_DOC_PRX_AMT");
         Object objByrActPrice = rec.get("STY_BYR_ACT_PRX_AMT");
         Object objMkrDocPrice = rec.get("STY_MKR_DOC_PRX_AMT");
         Object objMkrActPrice = rec.get("STY_MKR_ACT_PRX_AMT");
         double byrDocPrx=(objByrDocPrice==null||"".equals(objByrDocPrice.toString().trim()))?0:Double.parseDouble(objByrDocPrice.toString());
         double byrActPrx=(objByrActPrice==null||"".equals(objByrActPrice.toString().trim()))?0:Double.parseDouble(objByrActPrice.toString());
         double mkrDocPrx=(objMkrDocPrice==null||"".equals(objMkrDocPrice.toString().trim()))?0:Double.parseDouble(objMkrDocPrice.toString());
         double mkrActPrx=(objMkrActPrice==null||"".equals(objMkrActPrice.toString().trim()))?0:Double.parseDouble(objMkrActPrice.toString());
         if(byrDocPrx==0||byrActPrx==0||mkrDocPrx==0||mkrActPrx==0){
           exgui.verification.VerifyLib.showAlert("Please Check Prices fields of this Style Before Add It To Ship Detail",
                                                  "Price(s) Zero");
           return;
         }
       }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"");
          exgui.verification.VerifyLib.showAlert("Error While Checking Price,Please Contact System Manager",
                                                 "Error While Checking Price");
          return;
       }

     }
     try{
       if (rec.get("FTY") == null) {
         exgui.verification.VerifyLib.showAlert("Maker Not Assigned Yet\nPlease Assigne Maker Of Po Before Shipping",
                                                "Maker Not Assigned");
         return;
       }
     }catch(Exception exp){
       exp.printStackTrace();
     }

     System.out.println("record to add of org style is :"+rec.toString());
     rowPosition=_rowPosition;
     /*
     Variables in ShipAdmin_Const class
     public static int  EDIT_SHIP_STYLE_STYLE_INT_SEQ=0;
     public static int  EDIT_SHIP_STYLE_SC_INT_SEQ=0;
     public static int  EDIT_SHIP_STYLE_SEQ_INT=0;*/
      try {
       newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = - 1; //new record
         newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ =rec.getInt("sty_seq");
         Record recSRN=
             newtimes.shipping_admin.ShippingAdmin_Const.DB_SHIP_SRN_HEAD_HANDLER.getRecordByPk(
             newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
        String ship_packing_mode=(String)recSRN.get(55);//ship_packing_mode,'S' means Shipping,'P' means Packing
         if(ship_packing_mode==null){
           if(!isToAddAsShipStyle()){
             GoToAddPacking(rec);
           }else{
             PnlEditShipStyle.isEditingShipQty=true;
             processhandler.template.Properties.getCenteralControler().doCommandExecute(
                   new newtimes.shipping_admin.process.shiippingmaintain.TgrToAddSty2Shipping());
           }
         }else if (ship_packing_mode.equalsIgnoreCase("S")){
           //----------------------------------------------------------------
           //20060729,for those stupid user,always confuse current phase is to select to add,not to edit,
           //have to enter the "edit" mode if click row are the added row
           if(newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle!=null &&
              newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle.get(String.valueOf(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ))!=null){
             String destShipStyleSeq=(String)
                 newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle.get(String.valueOf(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ));

             newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT = Integer.parseInt(destShipStyleSeq);
               newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ =
                       newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ;

                   processhandler.template.Properties.getCenteralControler().doCommandExecute(
                         new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditAddedStyle(rec));
             return;
           }
           //------------------------------------------------------------------------
           PnlEditShipStyle.isEditingShipQty=true;
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
                 new newtimes.shipping_admin.process.shiippingmaintain.TgrToAddSty2Shipping());
         }else{
            GoToAddPacking(rec);
         }
      } catch (Exception exp) {
          exp.printStackTrace();
      }

    }
  }
  protected void GoToAddPacking(Record recStyel)throws Exception{
    util.MiscFunc.showProcessingMessage();
    Record recStyle =
        (new newtimes.production.process.prodmaintain.DB_StyleMisc()).
        getRecordByPk(recStyel.getInt("sty_seq"));
      recStyle.set("sty_size_column",
              newtimes.shipping_admin.ShippingAdmin_Const.recnvDblCamaString((
          String)recStyle.get("sty_size_column")));


      //create the psudo ship style to add.
      database.datatype.Record recShipStyle = exgui2.CONST.BASIC_MAIN_EJB.
          getBlankRecord("ship_style_tbl");
      recShipStyle.getFieldName().add("ship_no");
      recShipStyle.getValueFields().add(newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
      recShipStyle.getFieldName().add("prod_head_pk");
      recShipStyle.getValueFields().add(recStyle.get(1).toString());
      recShipStyle.getModifiedFields().clear(); //force to clear the modified fields
      recShipStyle.set(0, -1);
      recShipStyle.set("record_create_user",util.PublicVariable.USER_RECORD.get("usr_code"));
      recShipStyle.set(2, recStyle.getInt(0)); //org sty seq
      String sizecolumn=(String)recStyle.get("sty_size_column");

      if(sizecolumn==null||sizecolumn.trim().length()==0){
        StringBuffer sb=new StringBuffer();
        sb.append("select a.ship_style_pk,a.ship_sc_pk,a.ship_sty_size_column  ");
        sb.append("from ship_style a,ship_sc b ");
        sb.append("where a.ship_sc_pk=b.ship_sc_pk ");
        sb.append(" and  a.record_delete_flag=b.record_delete_flag" );
        sb.append(" and  a.record_delete_flag='1' ");
        sb.append(" and b.ship_no='");
        sb.append(newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
        sb.append("' order by a.ship_style_pk desc");
        /*
        sb.append("select ship_style_pk,ship_sc_pk,ship_sty_size_column from ship_style ");
        sb.append("where ship_sc_pk in ");
        sb.append("(select ship_sc_pk from ship_sc ");
        sb.append("where ship_no='");sb.append(newtimes.shipping_admin.ShippingAdmin_Const.CURRENT_EDITING_SHIP_SRN);
        sb.append("') and record_delete_flag='1' ");
        sb.append("order by ship_style_pk desc");*/

        //get last  ship style object's size columnas
         java.util.Vector vcttmpShipStyle=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sb.toString(),1,1);
         if(vcttmpShipStyle.size()!=0){
           Record recTmpShipStyle=(Record)vcttmpShipStyle.get(0);
           sizecolumn=(String)recTmpShipStyle.get(2);
         }
        //sizecolumn = "ONESZ";
      }
      recShipStyle.set("ship_sty_size_column", sizecolumn);
      newtimes.shipping_admin.process.packing.TgrToEditPackingStyle tgr=
          new newtimes.shipping_admin.process.packing.TgrToEditPackingStyle(null);
      tgr.setPackingRecord(recShipStyle);
      processhandler.template.Properties.getCenteralControler().doCommandExecute(tgr);
      util.MiscFunc.hideProcessingMessage();
  }
  class CustomMessage extends JPanel {
  JRadioButton btnShipping=new JRadioButton("SHIPPING STYLE",true);
  JRadioButton btnPacking=new JRadioButton("PACKING STYLE");
   public CustomMessage() {
       super( new BorderLayout(0, 5) );
       add( new JLabel("Add As Shipping or Packing"), BorderLayout.NORTH );
       JPanel subPanel = new JPanel();
       ButtonGroup group = new ButtonGroup();
       //subPanel.add( new JLabel("Your icon goes here") );
       group.add(btnShipping);
       subPanel.add( btnShipping );
       group.add(btnPacking);
       subPanel.add( btnPacking );
       add( subPanel, BorderLayout.CENTER );
   }

}
  protected PagedDataFactory getPagedDataFactory() {
    /**@todo Implement this exgui.ultratable.AbstractUltraTablePanel abstract method*/
    newtimes.shipping_admin.process.shiippingmaintain.DB_StyleList4Add handler=
        newtimes.shipping_admin.process.shiippingmaintain.DB_StyleList4Add.getInstance();
    dbHandler=handler;
    return handler;
  }

}
