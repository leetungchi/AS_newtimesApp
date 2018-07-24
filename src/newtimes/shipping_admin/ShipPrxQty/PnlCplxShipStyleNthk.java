package newtimes.shipping_admin.ShipPrxQty;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import processhandler.template.PnlTableEditor;
import exgui.ultratable.*;
import database.datatype.*;
import util.InsertionOrderedHashMap;
import processhandler.*;
import java.util.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlCplxShipStyleNthk  extends
  //JPanel{
  processhandler.template.PnlFieldsEditor
   implements Intf_get_Po_Ship_Qty_Pnl
 {
  JLabel jLabel1112 = new JLabel();
  JLabel jLabel21 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JTextField txtDiv = new JTextField();
  JTextField txtUnit = new JTextField();
  JLabel jLabel7 = new JLabel();
  JTextField txtFTY = new JTextField();
  JTextField txtCatData = new JTextField();
  JTextField txtPO = new JTextField();
  JTextField txtStyle = new JTextField();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel120 = new JLabel();
  JTextField txtSea = new JTextField();
  JLabel lblCat = new JLabel();
  JTextField txtScNo = new JTextField();
  JTextField txtRange = new JTextField();
  JPanel jPanel2 = new JPanel();
  JTextField txtYear = new JTextField();
  JLabel jLabel23 = new JLabel();
  JLabel jLabel15 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel10 = new JLabel();
  JLabel lblMkrDiscPer = new JLabel();
  JTextField txtBuyComm = new JTextField();
  JTextField txtMkrDsctPer = new JTextField();
  JLabel lblMkrDiscPc = new JLabel();
  JTextField txtBuyDsctPc = new JTextField();
  JTextField txtMkrDsctPc = new JTextField();
  JTextField txtBuyDsctDz = new JTextField();
  JLabel lblBuyerDiscLumpSum = new JLabel();
  JLabel lblMkrDiscDz = new JLabel();
  JLabel lblBuyerDiscDz = new JLabel();
  JLabel lblBuyerDiscPc = new JLabel();
  JLabel lblMkrDiscLumpSum = new JLabel();
  JLabel lblBuyerComm = new JLabel();
  JTextField txtMkrDsctDz = new JTextField();
  JTextField txtBuyDsctLumpSum = new JTextField();
  JTextField txtMkrDsctLumpSum = new JTextField();
  BlueBkgWhiteCharLabel lblShipStyleRemark = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPaneShipStyleRemark = new JScrollPane();
  JTextArea txtShipStyleRemark = new JTextArea();
  BlueBkgWhiteCharLabel lblTitleBar = new BlueBkgWhiteCharLabel();
  exgui.DataBindTextWithChecker dbBuyerComm;
  String sqlHead2checkShipComm=null;
  boolean isProcessingDelete=false;
  JPanel pnl2PlaceShipQty = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  public PnlLIstShipPrxQty pnlShipPrxQty=null;
  public PnlListQtyForPO pnlPoQty=null;
  JPanel pnl2PlacePOQty = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  Border border2;
  TitledBorder titledBorder3;
  Border border3;
  TitledBorder titledBorder4;
  JButton btnCopyPoQty=new JButton("Copy From Order Qty");
  BlueBkgWhiteCharLabel lblHangTagDesc = new BlueBkgWhiteCharLabel();
  JScrollPane jScrollPaneShipStyleHangTagScroll = new JScrollPane();
  JTextArea txtHangTagDesc = new JTextArea();
  JLabel lblHangTagQty = new JLabel();
  JLabel lblHangTagPrx = new JLabel();
  JTextField txtHangTagQty = new JTextField();
  JTextField txtHangTagPrx = new JTextField();
  JLabel lblHangTagUnit = new JLabel();
  JComboBox cbxHangTagUnit = new JComboBox();
  JLabel lblHangTagType = new JLabel();
  JTextField txtHgtType = new JTextField();

  public PnlCplxShipStyleNthk() {
    try {
      if(sqlHead2checkShipComm==null){
        StringBuffer tmpSb=new StringBuffer();
       tmpSb.append(" select a.SHIP_BUY_COMM from buyer_maker a where ");
       tmpSb.append(" a.BYMKR_SEQ in (select b.PROD_BUYER from prod_head b where b.prod_head_pk ");
       tmpSb.append(" in (select c.PROD_HEAD_PK from style c where c.sty_seq=");
       sqlHead2checkShipComm=tmpSb.toString();
      }

      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public PnlListQtyForPO getPoQtyPnl(){
     return pnlPoQty;
  }
  public PnlLIstShipPrxQty getShipQtyPnl(){
    return pnlShipPrxQty;
  }
  protected boolean isOverShip()throws Exception{
    pnlShipPrxQty.doUpdate();
    pnlShipPrxQty.getJtable().editCellAt(0,0);
   StringBuffer sb=new StringBuffer();
   sb.append("select b.SHIP_NO,a.SHIP_STY_TOTAL_QTY,c.STY_TOTAL_QTY from ship_style a,ship_sc b,style c ");
   sb.append("where a.SHIP_SC_PK=b.ship_sc_pk ");
   sb.append("and a.record_delete_flag='1' and b.record_delete_flag='1' ");
   sb.append("and a.sty_seq=c.sty_seq ");
   sb.append("and a.sty_seq=");
   sb.append(newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD.getInt("STY_SEQ"));
   if(newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD.get("SHIP_STYLE_PK")!=null){
    sb.append(" and a.ship_style_pk <> ");
    sb.append(newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD.getInt("SHIP_STYLE_PK"));
   }
   Vector vct=
       exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
       sb.toString(),1,99999
      );
   //if(vct.size()==0)return false;
   Object objStyleTotalQty=
       newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD.get("_$SUMMED_ORDER_QTY");

   float styQty=Float.parseFloat((objStyleTotalQty==null)?"0":objStyleTotalQty.toString());
   float shipQty=0;

   StringBuffer shipQtyString=new StringBuffer();

     for (int i = 0; i < vct.size(); i++) {
       Record recShipQtyData = (Record)vct.get(i);
       float xShipQty = Float.parseFloat((recShipQtyData.get(1) == null) ? "0" :
                                         recShipQtyData.get(1).toString());
       if(xShipQty==0)continue;
       shipQtyString.append("\n");
       shipQtyString.append("SRN:");
       shipQtyString.append((String)recShipQtyData.get(0));
       shipQtyString.append(" SHIP QTY:");
       shipQtyString.append(xShipQty);
       shipQty += xShipQty;
     }

   //sumEveryColumn();
   //Object totalOfCurrentQty=null;
   for(int ki=0;ki<pnlShipPrxQty.getJtable().getRowCount();ki++){
     Object objTital = pnlShipPrxQty.getJtable().getValueAt(
         ki,pnlShipPrxQty.getJtable().getColumnCount() - 1);

     shipQty+=Float.parseFloat(
         (objTital==null||objTital.toString().trim().length()==0)?
         "0":objTital.toString());

   }
  /*
   shipQty+=Float.parseFloat((totalOfCurrentQty==null||totalOfCurrentQty.toString().trim().length()==0)?
                             "0":totalOfCurrentQty.toString());*/
   if(shipQty>styQty*1.05){
     String msg="Order Qty:"+styQty;
       msg+=shipQtyString.toString();
     boolean result=
         exgui.verification.VerifyLib.showConfirm("Warnning,OVERSHIP\n"+msg+"\nContinue Or Not ?",
                                                  "Over Ship",false);
     return (!result);

   }
   return false;
 }

public  void initNTFEShipQty(){
  try{
    Vector vctBlc = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select prod_color_pk,balance_qty,pri_seq from V_STY_COL_BAL where sty_seq=" +
        newtimes.shipping_admin.ShippingAdmin_Const.
        EDIT_SHIP_STYLE_STYLE_INT_SEQ
        , 1, 99999);
    java.util.HashMap hmBlc=new java.util.HashMap();
    for(int i=0;i<vctBlc.size();i++){
      Record recTmp=(Record)vctBlc.get(i);
      String key=recTmp.get(0).toString();
      //String key=recTmp.get(2).toString();//key by price
      hmBlc.put(key,(recTmp.get(1)==null)?"0":recTmp.get(1).toString() );
    }
    for(int i=0;i<pnlShipPrxQty.getDisplayingRecords().size();i++){
      Record recTgt=(Record)pnlShipPrxQty.getDisplayingRecords().get(i);
      String key=recTgt.get("prod_color_pk").toString();
      //String key=recTgt.get("prod_color_pk").toString();
      String value=(String)hmBlc.get(key);
      if(value!=null){
        pnlShipPrxQty.getJtable().setValueAt(value,i,pnlShipPrxQty.getJtable().getColumnCount()-1);
      }
    }

  }catch(Exception exp){
    exp.printStackTrace();

  }
   /*
      javax.swing.JTable tblPoQty=pnlPoQty.getJtable();
      javax.swing.JTable tblShipQty=pnlShipPrxQty.getJtable();
      for(int i=0;i<tblPoQty.getRowCount();i++){
        tblShipQty.setValueAt(
         tblPoQty.getValueAt(i,tblPoQty.getColumnCount()-1),
         i,tblShipQty.getColumnCount()-1);
      }*/

}
protected  void jbInit() throws Exception {
    border3 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(border3,"ORDER PRICE & QTY");
    setPreferredSize(new java.awt.Dimension(750,600) );
    border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(border1,"SHIP STYLE QTY & PRICE");
    border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"SHIP PRICE & QTY");
    lblTitleBar.setText("Add Style To Shipping Data");
    lblTitleBar.setBounds(new Rectangle(0, 3, 789, 26));
    this.setLayout(null);
    jLabel21.setBounds(new Rectangle(461, 52, 76, 20));
    jLabel21.setText(" Range :");
    jLabel21.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel21.setOpaque(true);
    jLabel21.setForeground(Color.white);
    jLabel21.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel21.setBackground(new Color(143, 143, 188));
    jLabel1112.setBounds(new Rectangle(183, 21, 40, 20));
    jLabel1112.setText(" PO :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(new Color(10,36,106));
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    lblBuyerDiscPc.setBackground(new Color(143, 143, 188));
    lblBuyerDiscPc.setFont(new java.awt.Font("Dialog", 1, 12));
    lblBuyerDiscPc.setForeground(Color.white);
    lblBuyerDiscPc.setOpaque(true);
    lblBuyerDiscPc.setHorizontalAlignment(SwingConstants.LEFT);
    lblBuyerDiscPc.setText(" BUYER DSCT PC :");
    lblBuyerDiscPc.setBounds(new Rectangle(224, 51, 118, 20));
    txtDiv.setEnabled(false);
    txtDiv.setFont(new java.awt.Font("Dialog", 1, 11));
    txtDiv.setEditable(false);
    txtDiv.setBounds(new Rectangle(542, 24, 132, 21));
    lblMkrDiscPer.setBackground(new Color(143, 143, 188));
    lblMkrDiscPer.setFont(new java.awt.Font("Dialog", 1, 12));
    lblMkrDiscPer.setForeground(new Color(10,36,106));
    lblMkrDiscPer.setOpaque(true);
    lblMkrDiscPer.setHorizontalAlignment(SwingConstants.LEFT);
    lblMkrDiscPer.setText(" MKR DSCT Per :");
    lblMkrDiscPer.setBounds(new Rectangle(7, 100, 102, 20));
    lblBuyerDiscLumpSum.setBounds(new Rectangle(330, 74, 187, 20));
    lblBuyerDiscLumpSum.setText(" BUYER DSCT Lump SUM :");
    lblBuyerDiscLumpSum.setHorizontalAlignment(SwingConstants.LEFT);
    lblBuyerDiscLumpSum.setOpaque(true);
    lblBuyerDiscLumpSum.setForeground(new Color(10,36,106));
    lblBuyerDiscLumpSum.setFont(new java.awt.Font("Dialog", 1, 12));
    lblBuyerDiscLumpSum.setBackground(new Color(143, 143, 188));
    lblBuyerComm.setBackground(new Color(143, 143, 188));
    lblBuyerComm.setFont(new java.awt.Font("Dialog", 1, 12));
    lblBuyerComm.setForeground(new Color(10,36,106));
    lblBuyerComm.setOpaque(true);
    lblBuyerComm.setHorizontalAlignment(SwingConstants.LEFT);
    lblBuyerComm.setText(" Buy COMM :");
    lblBuyerComm.setBounds(new Rectangle(6, 48, 77, 20));
    txtFTY.setEnabled(false);
    txtFTY.setFont(new java.awt.Font("Dialog", 1, 11));
    txtFTY.setEditable(false);
    txtFTY.setBounds(new Rectangle(76, 24, 106, 21));
    jPanel3.setBounds(new Rectangle(2, 115, 744, 156));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setBorder(BorderFactory.createTitledBorder(" Ship Style Data "));
    txtPO.setBounds(new Rectangle(583, 10, 180, 20));
    txtPO.setEnabled(false);
    txtPO.setFont(new java.awt.Font("Dialog", 1, 11));
    txtPO.setEditable(false);
    txtPO.setBounds(new Rectangle(223, 21, 136, 20));
    jLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel2.setForeground(new Color(143, 143, 188));
    jLabel2.setText("( Year )");
    jLabel2.setBounds(new Rectangle(681, 109, 77, 20));
    jLabel2.setBounds(new Rectangle(191, 52, 52, 20));
    txtSea.setEnabled(false);
    txtSea.setFont(new java.awt.Font("Dialog", 1, 11));
    txtSea.setEditable(false);
    txtSea.setBounds(new Rectangle(316, 52, 128, 21));
    jPanel2.setBounds(new Rectangle(1, 30, 744, 83));
    jPanel2.setLayout(null);
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(BorderFactory.createTitledBorder(" Production Data "));
    txtYear.setEnabled(false);
    txtYear.setFont(new java.awt.Font("Dialog", 1, 11));
    txtYear.setEditable(false);
    txtYear.setBounds(new Rectangle(80, 52, 98, 20));
    jLabel23.setBounds(new Rectangle(561, 21, 37, 20));
    jLabel23.setText(" Unit :");
    jLabel23.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel23.setOpaque(true);
    jLabel23.setForeground(new Color(10,36,106));
    jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel23.setBackground(new Color(143, 143, 188));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setForeground(new Color(10,36,106));
    jLabel9.setOpaque(true);
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setText(" S / C No. :");
    jLabel9.setBounds(new Rectangle(233, 22, 62, 20));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setForeground(new Color(10,36,106));
    jLabel19.setOpaque(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" Division :");
    jLabel19.setBounds(new Rectangle(463, 24, 79, 20));
    lblBuyerDiscDz.setBounds(new Rectangle(7, 73, 141, 23));
    lblBuyerDiscDz.setText(" BUYER DSCT DZ :");
    lblBuyerDiscDz.setHorizontalAlignment(SwingConstants.LEFT);
    lblBuyerDiscDz.setOpaque(true);
    lblBuyerDiscDz.setForeground(Color.white);
    lblBuyerDiscDz.setFont(new java.awt.Font("Dialog", 1, 12));
    lblBuyerDiscDz.setBackground(new Color(143, 143, 188));
    txtUnit.setEnabled(false);
    txtUnit.setFont(new java.awt.Font("Dialog", 1, 11));
    txtUnit.setEditable(false);
    txtUnit.setBounds(new Rectangle(597, 21, 88, 20));
    jLabel7.setBounds(new Rectangle(243, 52, 74, 20));
    jLabel7.setText(" Season :");
    jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel7.setOpaque(true);
    jLabel7.setForeground(Color.white);
    jLabel7.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel7.setBackground(new Color(143, 143, 188));
    txtStyle.setBounds(new Rectangle(583, 102, 180, 20));
    txtStyle.setEnabled(false);
    txtStyle.setFont(new java.awt.Font("Dialog", 1, 11));
    txtStyle.setEditable(false);
    txtStyle.setBounds(new Rectangle(55, 21, 120, 20));
    jLabel120.setBounds(new Rectangle(6, 21, 49, 20));
    jLabel120.setText(" Style :");
    jLabel120.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel120.setOpaque(true);
    jLabel120.setForeground(new Color(10,36,106));
    jLabel120.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel120.setBackground(new Color(143, 143, 188));
    txtScNo.setBounds(new Rectangle(583, 148, 180, 20));
    txtScNo.setEnabled(false);
    txtScNo.setFont(new java.awt.Font("Dialog", 1, 11));
    txtScNo.setEditable(false);
    txtScNo.setBounds(new Rectangle(295, 22, 150, 20));
    txtRange.setBounds(new Rectangle(583, 79, 180, 20));
    txtRange.setEnabled(false);
    txtRange.setFont(new java.awt.Font("Dialog", 1, 11));
    txtRange.setEditable(false);
    txtRange.setBounds(new Rectangle(537, 52, 134, 20));
    jLabel15.setBounds(new Rectangle(15, 24, 61, 20));
    jLabel15.setText(" FTY :");
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setOpaque(true);
    jLabel15.setForeground(new Color(10,36,106));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setBackground(new Color(143, 143, 188));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" Year :");
    jLabel10.setBounds(new Rectangle(15, 52, 66, 20));
    txtBuyComm.setText("");
    txtBuyComm.setBounds(new Rectangle(83, 49, 93, 20));
    txtBuyDsctPc.setText("");
    txtBuyDsctPc.setBounds(new Rectangle(340, 51, 73, 22));
    txtBuyDsctLumpSum.setText("");
    txtBuyDsctLumpSum.setBounds(new Rectangle(517, 74, 125, 20));
    txtMkrDsctPer.setText("");
    txtMkrDsctPer.setBounds(new Rectangle(109, 100, 105, 20));
    txtBuyDsctDz.setText("");
    txtBuyDsctDz.setBounds(new Rectangle(147, 73, 170, 23));
    this.setBackground(new Color(204, 204, 225));
    lblMkrDiscPc.setBounds(new Rectangle(230, 99, 97, 20));
    lblMkrDiscPc.setText(" MKR DSCT PC :");
    lblMkrDiscPc.setHorizontalAlignment(SwingConstants.LEFT);
    lblMkrDiscPc.setOpaque(true);
    lblMkrDiscPc.setForeground(Color.white);
    lblMkrDiscPc.setFont(new java.awt.Font("Dialog", 1, 12));
    lblMkrDiscPc.setBackground(new Color(143, 143, 188));
    lblMkrDiscDz.setBackground(new Color(143, 143, 188));
    lblMkrDiscDz.setFont(new java.awt.Font("Dialog", 1, 12));
    lblMkrDiscDz.setForeground(Color.white);
    lblMkrDiscDz.setOpaque(true);
    lblMkrDiscDz.setHorizontalAlignment(SwingConstants.LEFT);
    lblMkrDiscDz.setText(" MKR DSCT DZ :");
    lblMkrDiscDz.setBounds(new Rectangle(7, 125, 141, 23));
    lblMkrDiscLumpSum.setBackground(new Color(143, 143, 188));
    lblMkrDiscLumpSum.setFont(new java.awt.Font("Dialog", 1, 12));
    lblMkrDiscLumpSum.setForeground(new Color(10,36,106));
    lblMkrDiscLumpSum.setOpaque(true);
    lblMkrDiscLumpSum.setHorizontalAlignment(SwingConstants.LEFT);
    lblMkrDiscLumpSum.setText(" MKR DSCT Lump SUM :");
    lblMkrDiscLumpSum.setBounds(new Rectangle(331, 130, 187, 20));
    txtMkrDsctPc.setBounds(new Rectangle(326, 99, 73, 22));
    txtMkrDsctPc.setText("");
    txtMkrDsctDz.setBounds(new Rectangle(147, 125, 170, 23));
    txtMkrDsctDz.setText("");
    txtMkrDsctLumpSum.setBounds(new Rectangle(518, 130, 125, 20));
    txtMkrDsctLumpSum.setText("");
    lblCat.setBackground(new Color(143, 143, 188));
    lblCat.setFont(new java.awt.Font("Dialog", 1, 12));
    lblCat.setForeground(new Color(10,36,106));
    lblCat.setOpaque(true);
    lblCat.setHorizontalAlignment(SwingConstants.LEFT);
    lblCat.setText("QTA:");
    lblCat.setBounds(new Rectangle(375, 21, 40, 20));
    txtCatData.setBounds(new Rectangle(223, 21, 136, 20));
    txtCatData.setEditable(false);
    txtCatData.setFont(new java.awt.Font("Dialog", 1, 11));
    txtCatData.setEnabled(false);
    txtCatData.setBounds(new Rectangle(415, 21, 136, 20));


    lblHangTagDesc.setBounds(new Rectangle(375, 99, 133, 47));
    lblHangTagDesc.setForeground(new Color(10, 36, 106));
    lblHangTagDesc.setText("<html><body>HANGER<br>DESCRIPTION</body></html>");
    jScrollPaneShipStyleHangTagScroll.setBounds(new Rectangle(508, 99, 223, 47));
    lblHangTagQty.setBounds(new Rectangle(5, 99, 88, 22));
    lblHangTagQty.setText(" Hanger Qty:");
    lblHangTagQty.setHorizontalAlignment(SwingConstants.LEFT);
    lblHangTagQty.setOpaque(true);
    lblHangTagQty.setForeground(new Color(10,36,106));
    lblHangTagQty.setFont(new java.awt.Font("Dialog", 1, 12));
    lblHangTagQty.setBackground(new Color(143, 143, 188));
    lblHangTagPrx.setBackground(new Color(143, 143, 188));
    lblHangTagPrx.setFont(new java.awt.Font("Dialog", 1, 12));
    lblHangTagPrx.setForeground(new Color(10,36,106));
    lblHangTagPrx.setOpaque(true);
    lblHangTagPrx.setHorizontalAlignment(SwingConstants.LEFT);
    lblHangTagPrx.setText(" Hanger Prx.:");
    lblHangTagPrx.setBounds(new Rectangle(5, 126, 88, 20));
    txtHangTagQty.setText("");
    txtHangTagQty.setBounds(new Rectangle(93, 99, 97, 22));
    txtHangTagPrx.setBounds(new Rectangle(93, 126, 97, 22));
    txtHangTagPrx.setText("jTextField1");
    txtHangTagPrx.setText("");
    lblHangTagUnit.setBackground(new Color(143, 143, 188));
    lblHangTagUnit.setFont(new java.awt.Font("Dialog", 1, 12));
    lblHangTagUnit.setForeground(Color.white);
    lblHangTagUnit.setOpaque(true);
    lblHangTagUnit.setHorizontalAlignment(SwingConstants.LEFT);
    lblHangTagUnit.setText("Hanger UNIT:");
    lblHangTagUnit.setBounds(new Rectangle(194, 99, 82, 22));
    cbxHangTagUnit.setBounds(new Rectangle(276, 99, 91, 22));
    lblHangTagType.setBounds(new Rectangle(193, 126, 82, 22));
    lblHangTagType.setText("HangerType:");
    lblHangTagType.setHorizontalAlignment(SwingConstants.LEFT);
    lblHangTagType.setOpaque(true);
    lblHangTagType.setForeground(Color.white);
    lblHangTagType.setFont(new java.awt.Font("Dialog", 1, 12));
    lblHangTagType.setBackground(new Color(143, 143, 188));
    txtHgtType.setBounds(new Rectangle(275, 126, 96, 22));
    jPanel2.add(jLabel15, null);
    jPanel2.add(jLabel19, null);
    jPanel2.add(txtDiv, null);
    jPanel2.add(jLabel10, null);
    jPanel2.add(txtYear, null);
    jPanel2.add(jLabel2, null);
    jPanel2.add(jLabel7, null);
    jPanel2.add(txtSea, null);
    jPanel2.add(jLabel21, null);
    jPanel2.add(txtRange, null);
    jPanel2.add(jLabel9, null);
    jPanel2.add(txtScNo, null);
    jPanel2.add(txtFTY, null);
    this.add(jPanel3, null);
    jPanel3.add(jLabel120, null);
    jPanel3.add(txtStyle, null);

    //if(util.PublicVariable.OPERATTING_CENTER.equals("001")){

     jPanel3.add(lblBuyerComm, null);
     jPanel3.add(txtBuyComm, null);
     jPanel3.add(lblMkrDiscPer, null);
     jPanel3.add(txtMkrDsctPer, null);
     jPanel3.add(lblBuyerDiscDz, null);
     jPanel3.add(txtBuyDsctDz, null);
     jPanel3.add(lblBuyerDiscLumpSum, null);
     jPanel3.add(txtBuyDsctLumpSum, null);
     jPanel3.add(lblBuyerDiscPc, null);
     jPanel3.add(txtBuyDsctPc, null);
     jPanel3.add(lblMkrDiscDz, null);
     jPanel3.add(txtMkrDsctDz, null);
     jPanel3.add(lblMkrDiscLumpSum, null);
     jPanel3.add(txtMkrDsctLumpSum, null);
     jPanel3.add(lblMkrDiscPc, null);
     jPanel3.add(txtMkrDsctPc, null);

    //}
    jPanel3.add(jLabel1112, null);
    jPanel3.add(txtPO, null);
    this.add(lblTitleBar, null);
    this.add(jPanel2, null);

    jPanel3.add(lblCat, null);
    jPanel3.add(txtCatData, null);
    jPanel3.add(jLabel23, null);
    jPanel3.add(txtUnit, null);
    //test to add============================
    //test to add=============================
    pnl2PlaceShipQty.setBorder(titledBorder2);
    pnl2PlaceShipQty.setBounds(new Rectangle(4, 266, 745, 201));
    pnl2PlaceShipQty.setLayout(borderLayout1);
    pnl2PlacePOQty.setLayout(borderLayout2);
    pnl2PlacePOQty.setBounds(new Rectangle(6, 472, 745, 200));
    pnl2PlacePOQty.setBorder(titledBorder4);
    this.add(pnl2PlaceShipQty, null);
    this.add(pnl2PlacePOQty, null);

  }
  protected void initShipQtyGui(){
    pnlPoQty= new PnlListQtyForPO();
    pnlPoQty.setPreferredSize(new Dimension(745,200));
    pnl2PlacePOQty.removeAll();
    pnl2PlacePOQty.add(pnlPoQty,borderLayout1.CENTER);
    pnlPoQty.firstPage();
    //---------------------------------
    pnlShipPrxQty=
        new newtimes.shipping_admin.ShipPrxQty.PnlLIstShipPrxQty();
    pnlShipPrxQty.setPreferredSize(new Dimension(745,200));
    pnl2PlaceShipQty.removeAll();
    pnl2PlaceShipQty.add(pnlShipPrxQty,borderLayout1.CENTER);
    pnlShipPrxQty.firstPage();

    pnlShipPrxQty.btnDel.setVisible(false);
    pnlShipPrxQty.btnAdd.setVisible(false);

    ((exgui.MultiClassTableModel)pnlShipPrxQty.getJtable().getModel()).removeEditableColumn(pnlShipPrxQty.COLUMN_COLOR_CODE);
    ((exgui.MultiClassTableModel)pnlShipPrxQty.getJtable().getModel()).removeEditableColumn(pnlShipPrxQty.COLUMN_COLOR_DESC);

    if(!newtimes.shipping_admin.ShippingAdmin_Const.isUserEric()){
      //ordinary user only allow to edit buyer doc price.
      pnlShipPrxQty.getMultiEditorJTable().setColumnUnEditable(pnlShipPrxQty.getJtable().getColumnName(2));
      pnlShipPrxQty.getMultiEditorJTable().setColumnUnEditable(pnlShipPrxQty.getJtable().getColumnName(3));
      pnlShipPrxQty.getMultiEditorJTable().setColumnUnEditable(pnlShipPrxQty.getJtable().getColumnName(4));
    }


    /*
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      btnCopyPoQty.addMouseListener(new CopyPoQtyAction());
      pnlShipPrxQty.getLowerRightPanel().add(btnCopyPoQty);
    } */

    //FOR NTHK MODE,have to check if user type Pakcing data.
    try{
      String pkgOrShipStyleMode =
          (String)newtimes.shipping_admin.ShippingAdmin_Const.
          EDITING_SHIPPING_STYLE_RECORD.get("_$SHIP_PACKING_AND_STYLE_MODE");
      if (pkgOrShipStyleMode != null && pkgOrShipStyleMode.equals("P")) {
       //if packing mode,do not allow to modify color fields !!
       ((exgui.MultiClassTableModel)pnlShipPrxQty.getJtable().getModel()).removeEditableColumn(pnlShipPrxQty.COLUMN_COLOR_CODE);
       ((exgui.MultiClassTableModel)pnlShipPrxQty.getJtable().getModel()).removeEditableColumn(pnlShipPrxQty.COLUMN_COLOR_DESC);
       //color name,4 prx filed,than is the size and to totoal qty column
       for(int i=5;i<pnlShipPrxQty.getJtable().getColumnCount();i++){
         ((exgui.MultiClassTableModel)pnlShipPrxQty.getJtable().getModel()).removeEditableColumn(
          pnlShipPrxQty.getJtable().getColumnName(i));
       }
       pnlShipPrxQty.btnDel.setVisible(false);
       pnlShipPrxQty.btnAdd.setVisible(false);
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  class CopyPoQtyAction extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
      for(int i=0;i<pnlShipPrxQty.getJtable().getRowCount();i++){
        for(int j=5;j<pnlShipPrxQty.getJtable().getColumnCount();j++){
          pnlShipPrxQty.getJtable().setValueAt(
           pnlPoQty.getJtable().getValueAt(i,j),
           i,j);
        }
      }
    }
  }
  public void record2Gui(){
    //filled all the columns,take easy,just buyer maker discount and percentage and lumpsun....
    try{
      if(recToMapping.getInt(0)>0){
        lblTitleBar.setText("EDIT Shipping Style ");
      }else{
        lblTitleBar.setText("ADD Style to Shipping");
      }
      txtFTY.setText((String)recToMapping.get("_$MAKER_NAME")); txtFTY.setEditable(false);//maker name
      txtScNo.setText((String)recToMapping.get("_$PROD_SC_NO"));txtScNo.setEditable(false);
      txtDiv.setText((String)recToMapping.get("_$DIV_NAME"));txtDiv.setEditable(false);
      txtYear.setText((String)recToMapping.get("_$PROD_YEAR"));txtYear.setEditable(false);
      txtSea.setText((String)recToMapping.get("_$PROD_SEASON"));txtSea.setEditable(false);
      txtRange.setText((String)recToMapping.get("_$PROD_RANGE"));txtRange.setEditable(false);
      txtStyle.setText((String)recToMapping.get("_$ORG_STYLE_NAME"));txtStyle.setEditable(false);
      txtPO.setText((String)recToMapping.get("_$ORG_STYLE_PO"));txtPO.setEditable(false);
      txtUnit.setText((String)recToMapping.get("_$ORG_STYLE_UNIT"));txtUnit.setEditable(false);
      Object objSummedOdrQty=recToMapping.get("_$SUMMED_ORDER_QTY");
      //lblOrgTtlQty.setText((objSummedOdrQty==null)?"":objSummedOdrQty.toString());

      Object catData=recToMapping.get("_$STY_QTA");
      txtCatData.setText((catData==null)?"":catData.toString());

      Object objSummedshippedQty=recToMapping.get("_$SUMMED_SHIPPED_QTY");
      //lblShippedQty.setText((objSummedshippedQty==null)?"":objSummedshippedQty.toString());
      Object objOrgOrderQty=recToMapping.get("_$ORG_QTY_DESC");
      //txtAreaOdrQty.setText((objOrgOrderQty==null)?"":objOrgOrderQty.toString());txtAreaOdrQty.setEditable(false);
      Object objShipQtyDesc=recToMapping.get("SHIP_QTY_DESC");
      //txtShipQtyDesc.setText((objShipQtyDesc==null)?"":objShipQtyDesc.toString());
      //txtShipQtyDesc.setEditable(false);
      dataBoundGUIs.clear();
      Object vftxtBuyComm=exgui.verification.CellFormat.getDoubleFormatAllowNull(3,2);
      dbBuyerComm= new exgui.DataBindTextWithChecker(
         txtBuyComm,"BUY_COMM",recToMapping.get("BUY_COMM"),6,(
        exgui.Object2String)vftxtBuyComm,(exgui.ultratable.CellTxtEditorFormat)vftxtBuyComm);
       dataBoundGUIs.add( dbBuyerComm );
     Object vftxtMkrDsctPer = vftxtBuyComm;//exgui.verification.CellFormat.getDoubleFormatAllowNull(3, 2);
     dataBoundGUIs.add(
           new exgui.DataBindTextWithChecker(
           txtMkrDsctPer,
           "MKR_DSCT_PER",
           recToMapping.get("MKR_DSCT_PER"), 6,
           (exgui.Object2String)vftxtMkrDsctPer,
           (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctPer)
      );

      Object vftxtMkrDsctPc=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,3);
       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
           txtMkrDsctPc,"MKR_DSCT_PC",recToMapping.get("MKR_DSCT_PC"),8,
          (exgui.Object2String)vftxtMkrDsctPc,(exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctPc
          )
      );

     dataBoundGUIs.add(
        new exgui.DataBindTextWithChecker(
       txtBuyDsctPc,"BUY_DSCT_PC",recToMapping.get("BUY_DSCT_PC"),8,
        (exgui.Object2String)vftxtMkrDsctPc,(exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctPc
        )
      );


      Object vftxtMkrDsctLumpSum=exgui.verification.CellFormat.getDoubleFormatAllowNull(8,3);
       dataBoundGUIs.add(
                        new exgui.DataBindTextWithChecker(
                        txtMkrDsctLumpSum,"MKR_DSCT_LUMP_SUM",
                        recToMapping.get("MKR_DSCT_LUMP_SUM"),12,
                        (exgui.Object2String)vftxtMkrDsctLumpSum,
                        (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctLumpSum)
      );
      dataBoundGUIs.add(
                    new exgui.DataBindTextWithChecker(
                    txtBuyDsctLumpSum,"BUY_DSCT_LUMP_SUM",
                    recToMapping.get("BUY_DSCT_LUMP_SUM"),12,
                    (exgui.Object2String)vftxtMkrDsctLumpSum,
                    (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctLumpSum)
      );

      Object vftxtMkrDsctDz=exgui.verification.CellFormat.getDoubleFormatAllowNull(4,4);
       dataBoundGUIs.add(
           new exgui.DataBindTextWithChecker(
              txtMkrDsctDz,"MKR_DSCT_DZ",recToMapping.get("MKR_DSCT_DZ"),9,
                 (exgui.Object2String)vftxtMkrDsctDz,
               (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctDz)
      );
      dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
             txtBuyDsctDz,"BUY_DSCT_DZ",recToMapping.get("BUY_DSCT_DZ"),9,
                (exgui.Object2String)vftxtMkrDsctDz,
              (exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctDz)
      );

     if(!util.PublicVariable.OPERATTING_CENTER.equals("001")){
       Object vftxtShipStyleRemark=exgui.verification.CellFormat.getOrdinaryField(500);
        dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
            txtShipStyleRemark,"SHIP_STYLE_PACKING_RMRK",
            recToMapping.get("SHIP_STYLE_PACKING_RMRK"),500,
           (exgui.Object2String)vftxtShipStyleRemark,
           (exgui.ultratable.CellTxtEditorFormat)vftxtShipStyleRemark
           )
       );
       //20060717,PW center,have to add hangtag to ship-inv data
      /*
         SHIP_STY_HTG_DESC         VARCHAR2(255),
         SHIP_STY_HTG_QTY          NUMBER(11,3),
         SHIP_STY_HTG_PRX          NUMBER(11,3),
         SHIP_STY_HTG_UNIT         VARCHAR2(10)
         SHIP_STY_HTG_TYPE         VARCHAR2(30)
      */
        dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
           txtHangTagDesc,"SHIP_STY_HTG_DESC",
           recToMapping.get("SHIP_STY_HTG_DESC"),255,
           (exgui.Object2String)vftxtShipStyleRemark,
           (exgui.ultratable.CellTxtEditorFormat)vftxtShipStyleRemark
           )
         );
        dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
          txtHangTagPrx,"SHIP_STY_HTG_PRX",recToMapping.get("SHIP_STY_HTG_PRX"),8,
          (exgui.Object2String)vftxtMkrDsctPc,(exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctPc
          )
        );
        dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
          txtHangTagQty,"SHIP_STY_HTG_QTY",recToMapping.get("SHIP_STY_HTG_QTY"),8,
          (exgui.Object2String)vftxtMkrDsctPc,(exgui.ultratable.CellTxtEditorFormat)vftxtMkrDsctPc
          )
        );

        exgui.DataBindJCombobox  DbJcbxcbxHangTagUnit =
         new exgui.DataBindJCombobox(
         cbxHangTagUnit,"SHIP_STY_HTG_UNIT",
         newtimes.preproduction.guis.tempProperties.tmpUnits,
         "UNIT",
         "UNIT",
         recToMapping.get("SHIP_STY_HTG_UNIT"),
         "",null);
        dataBoundGUIs.add(DbJcbxcbxHangTagUnit);
        Object vfy30=exgui.verification.CellFormat.getOrdinaryField(30);
        dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(
           txtHgtType,"SHIP_STY_HTG_TYPE",
           recToMapping.get("SHIP_STY_HTG_TYPE"),30,
           (exgui.Object2String)vfy30,
           (exgui.ultratable.CellTxtEditorFormat)vfy30
           )
         );

      }
    initShipQtyGui();
    recToMapping.getModifiedFields().clear();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  public boolean isContextModified(){
    if(isProcessingDelete)return false;
    boolean result=pnlShipPrxQty.isContextModified();
    if(result)return true;
    /*
  //test if ship style column is match.

  try{
   Object newObj=recToMapping.get("ship_sty_size_column");
   Object oldObj=recClonedForCheck.get("ship_sty_size_column");
   if (!util.MiscFunc.isEqual(newObj,oldObj)){
     recClonedForCheck.set("ship_sty_size_column",newObj);
   }
   }catch(Exception exp){
     exp.printStackTrace();
   }*/
    return super.isContextModified();
  }
  public void doDelete(){
    if(!exgui.verification.VerifyLib.showConfirm("Are You Sure To Delete This Shipping Style Data ?","Are You Sure?"))return;
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      String orgPoStySeq=recToMapping.get(2).toString();

      dbprc.deleteRecord(recToMapping);
      isProcessingDelete=true;
      if(newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle!=null)
      {
        newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle.remove(orgPoStySeq);

      }

      doExit();//after delete ,go to listing page.
    }catch(Exception exp){
      exp.printStackTrace();
      util.MiscFunc.hideProcessingMessage();
      util.ExceptionLog.exp2File(exp,"error while delete record:"+recToMapping.toString());
      exgui.verification.VerifyLib.showAlert("Server Side Error While Deleting Shipping Style","Error while Deleting");
    }finally{
      util.MiscFunc.hideProcessingMessage();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
  public void doPrint(){}
  protected boolean checkShipCommision()throws Exception{
    //newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ
    StringBuffer sb=new StringBuffer(sqlHead2checkShipComm);
    sb.append(newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_STYLE_INT_SEQ);
    sb.append("))");
    java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),1,1);
    if(vct==null)throw new Exception("Error While To Compare Ship Buyer Commission");
    Record rec=(Record)vct.get(0);
    Object shipBuyCommObj=rec.get(0);
    if(shipBuyCommObj==null)return true;//no user assigned
    float shipBuyerComm=Float.parseFloat(shipBuyCommObj.toString());
    Object styleBuyerCommObj=dbBuyerComm.getSelectedValue();
    float styleBuyerComm=Float.parseFloat((styleBuyerCommObj==null)?"0":styleBuyerCommObj.toString());
    if(styleBuyerComm!=shipBuyerComm){
        exgui.verification.VerifyLib.showAlert(
        "Buyer Commission is "+styleBuyerComm+",Not Equal to Buyer's Ship Commission:"+shipBuyerComm,
        "Buyer Commssion Error");
        return false;
    }
    return true;
  }
  public void doAddNew()throws Exception{
    doUpdate(true);
  }
  public void doUpdate()throws Exception{
    doUpdate(false);
  }
  protected void updatePnlListStyles2AddHashMap(Record rec){
    if(newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle==null){
      newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle=new HashMap();
    }
    newtimes.shipping_admin.ShippingAdmin_Const.hmPoStyleMap2ShipStyle.put(rec.get(2).toString(),
                                                                                               rec.get(0).toString());
  }

  public boolean ifShipQtyGreaterThanZero(){
    double qty=0;
    for(int i=0;i<pnlShipPrxQty.getJtable().getRowCount();i++){
     Object obj=pnlShipPrxQty.getJtable().getValueAt(i,pnlShipPrxQty.getJtable().getColumnCount()-1);
     if(obj!=null && obj.toString().trim().length()>0)qty+=Double.parseDouble(obj.toString());
    }
    if(qty==0){
      exgui.verification.VerifyLib.showAlert(
      "Ship Qty Should Be Greater Than Zero",
      "Ship Qty IS ZERO");
      return false;
    }
    return true;
  }

  public void doUpdate(boolean isAddNew)throws Exception{
    isGui2RecordOk=gui2Record();
    int orgPK=recToMapping.getInt(0);
    Cursor ksr=null;
    if(!isGui2RecordOk) return;
    if(!checkShipCommision())return;
    if(!ifShipQtyGreaterThanZero())return;
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      try{

        //test if to update...
        if(orgPK>0){
          recToMapping.set("record_modify_user",util.PublicVariable.USER_RECORD.get("usr_code"));
          //recToMapping.set("SHIP_QTY_DESC",txtShipQtyDesc.getText());
        }
        //recToMapping=((newtimes.shipping_admin.process.shiippingmaintain.DB_ShipStyle)dbprc).updateRecord(recToMapping);
        //record2Gui();
        if(isOverShip()){
          return;
        }
        //pnlShipPrxQty.doUpdate();
        pnlShipPrxQty.getJtable().changeSelection(0,0,false,false);
        recToMapping=((PrxQtyHandler)pnlShipPrxQty.getPagedDataFactory()).finalUpdate();
        pnlShipPrxQty.ismodified=false;
        recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
        newtimes.shipping_admin.ShippingAdmin_Const.EDIT_SHIP_STYLE_SEQ_INT=recToMapping.getInt(0);
        newtimes.shipping_admin.ShippingAdmin_Const.EDITING_SHIPPING_STYLE_RECORD=recToMapping;

        if(isAddNew){
          updatePnlListStyles2AddHashMap(recToMapping);

          javax.swing.JFrame jframe = processhandler.template.Properties.
              getMainFrame();
          newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStyleNthk   pnl=this;
          jframe.getContentPane().removeAll();
          pnl.setBounds(0,0,775,850);
          newtimes.shipping_admin.PnlBaseContainer pnlFunc =
              new newtimes.shipping_admin.PnlBaseContainer();
          newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;
          pnlFunc.setButtons(false,true, false, false, true);
          pnlFunc.removalAddExtralButtons();
          jframe.getContentPane().add(pnlFunc,null);
          pnl.record2Gui();
          pnl.recToMapping.getModifiedFields().clear();
          pnl.recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
          pnlFunc.setEditPanel(pnl);
          pnl.setPreferredSize(new java.awt.Dimension(750, 850));
          pnl.repaint();
          pnl.validate();
          pnlFunc.setBounds(0, 0, 790, 580);
          pnlFunc.repaint();
          pnlFunc.validate();
          jframe.repaint();
          jframe.validate();
        }else{
          javax.swing.JFrame jframe = processhandler.template.Properties.
              getMainFrame();
          newtimes.shipping_admin.ShipPrxQty.PnlCplxShipStyleNthk   pnl=this;
          jframe.getContentPane().removeAll();
          pnl.setBounds(0,0,775,850);
          newtimes.shipping_admin.PnlBaseContainer pnlFunc =
              new newtimes.shipping_admin.PnlBaseContainer();
          newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL=pnlFunc;
          pnlFunc.setButtons(false,true, false, false, true);
          pnlFunc.removalAddExtralButtons();
          jframe.getContentPane().add(pnlFunc,null);
          pnl.record2Gui();
          pnl.recToMapping.getModifiedFields().clear();
          pnl.recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
          pnlFunc.setEditPanel(pnl);
          pnl.setPreferredSize(new java.awt.Dimension(750, 850));
          pnl.repaint();
          pnl.validate();
          pnlFunc.setBounds(0, 0, 790, 580);
          pnlFunc.repaint();
          pnlFunc.validate();
          jframe.repaint();
          jframe.validate();
        }
        //recToMapping.getModifiedFields().clear();
        doExit();
        /*
        if(isAddNew){
           processhandler.template.Properties.getCenteralControler().doCommandExecute(
                 new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditAddedStyle());

        }*/
      }catch(Exception e){
        //e.printStackTrace();
        throw e;
      }finally{
        util.MiscFunc.hideProcessingMessage();
         newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }
      util.MiscFunc.hideProcessingMessage();
  }
  public void doExit()throws Exception{
         super.doExit();
  }
}
