package newtimes.production.gui.prodmaintain;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class JCompPnlStylRemark extends JPanel implements Intf_SC_CT_Edit{
  public JTextArea txtStyDownRMK = new JTextArea();
  JScrollPane jScrollPane3 = new JScrollPane();
  JScrollPane jScrollPane2 = new JScrollPane();
  public JTextArea txtStyUpRMK = new JTextArea();
  JLabel lblStyUpRMK = new JLabel();
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  Record styleRec;
  Border border2;
  Border border3;
  boolean isSC=false;
  protected newtimesejb.production.Styles_SC_CT_Facade  ejb=null;
  String orgScUpRemarkString=null;
  JLabel lblStyDnRMK = new JLabel();
  java.text.DateFormat dt=new java.text.SimpleDateFormat("yyyy/MM/dd");
  static    String nubers="0123456789";
  JLabel lblFixTitleUp = new JLabel();
  JLabel lblFixTitleDown = new JLabel();
  String maker_del_date="";//STY_MKR_DEL
  static java.util.HashMap shippingWayHm;
  protected boolean isDocPrice=false;
  public JCompPnlStylRemark(Record styRec,
                            boolean _isSC) {
       if(shippingWayHm==null){
         shippingWayHm=new java.util.HashMap();
         for(int i=0;i<newtimes.preproduction.guis.tempProperties.tempShipModes.size();i++){
           Record rec=(Record)newtimes.preproduction.guis.tempProperties.tempShipModes.get(i);
           shippingWayHm.put(rec.get(0),rec.get(1));
         }
         /*

         shippingWayHm.put("A","AIR");
         shippingWayHm.put("B","BOAT");
         shippingWayHm.put("S","BOAT");
         shippingWayHm.put("T","TRUCK");
         shippingWayHm.put("C","COURIER");
         shippingWayHm.put("W","WEST COAST");
         shippingWayHm.put("F","FEDEX COLLECT");
         shippingWayHm.put("O","OCEAN");
         shippingWayHm.put("V","Vessel");*/
       }
      styleRec=styRec;
      //orgScUpRemarkString=defaultScUpRemark;
      //System.out.println("orgScUpRemarkString="+orgScUpRemarkString);
      try{
        if (styRec.get("STY_MKR_DEL") != null) {
            maker_del_date=dt.format((java.util.Date)styRec.get("STY_MKR_DEL"));
        }
      }catch(Exception exp){

      }
      isSC=_isSC;
      dt.setLenient(false);
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void doSetClear(){
    txtStyUpRMK.setText("");
    txtStyDownRMK.setText("");
  }
  public void setIsDocPrice(boolean isdocPrx){
    isDocPrice=isdocPrx;
  }
  protected static String getShipWayName(String brf){
    if(brf==null)return "";
    String shipWayName=(String)shippingWayHm.get(brf.trim().toUpperCase());
    if(shipWayName==null)return "???";
    return shipWayName;
  }
  public void doCopyFormSc()throws Exception{
    if(!isSC){
      //copy sc default value to ct.
      Object data=styleRec.get(ejb.KEY_STY_SC_UP_REMARK);
      txtStyUpRMK.setText((data==null)?"":data.toString());
      data=styleRec.get(ejb.KEY_STY_SC_DOWN_REMARK);
      txtStyDownRMK.setText((data==null)?"":data.toString());
      StringBuffer sb=new StringBuffer();
      //find out the row to replace the delivery date to maker date
      String strs[]=util.MiscFunc.split(txtStyDownRMK.getText(),"\n");
      boolean foundDelDate=false;
      for(int i=0;i<strs.length;i++){
        if(strs[i].startsWith("DEL-DD:") && (!foundDelDate)){
          String shipMode=strs[i].substring(strs[i].lastIndexOf(" "),strs[i].length());
          strs[i]="DEL-DD:"+maker_del_date+shipMode;///have to add maker ship mode
          foundDelDate=true;
        }
        sb.append(strs[i]);
        sb.append("\n");
      }
      txtStyDownRMK.setText(sb.toString());
      txtStyUpRMK.setCaretPosition(0);
      txtStyDownRMK.setCaretPosition(0);
    }
  }
 protected void jbInit() throws Exception {
    Object styleObj=styleRec.get("sty_style");
    Object stylePoObj=styleRec.get("sty_po");
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),
                                     "STY:"+((styleObj==null)?"":styleObj.toString()) +"  PO:"+((stylePoObj==null)?"":stylePoObj.toString()));
    jScrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    jScrollPane3.setAutoscrolls(false);
    jScrollPane3.setBounds(new Rectangle(14, 147, 623, 145));
    txtStyDownRMK.setFont(new java.awt.Font("DialogInput", 0, 12));
    this.setLayout(null);
    if(isSC)
      lblFixTitleDown.setText("S/C DOWN REMARK");//lblStyDnRMK.setText("S/C DOWN REMARK");
    else
      lblFixTitleDown.setText("C/T DOWN REMARK");//lblStyDnRMK.setText("C/T DOWN REMARK");

    jScrollPane2.setBounds(new Rectangle(15, 37, 623, 79));
    txtStyUpRMK.setFont(new java.awt.Font("DialogInput", 0, 12));
    if(isSC)
      lblFixTitleUp.setText("S/C UP REMARK");   //lblStyUpRMK.setText("S/C UP REMARK");
    else
      lblFixTitleUp.setText("C/T UP REMARK");

    lblStyUpRMK.setFont(new java.awt.Font("DialogInput", 0, 12));
    lblStyUpRMK.setForeground(Color.red);
    lblStyUpRMK.setText("                                   V");
    lblStyUpRMK.setBounds(new Rectangle(15, 16, 480, 23));
    //init for source value...
    if(isSC){
      String upRemarkString="";

       if(styleRec.get(ejb.KEY_STY_SC_UP_REMARK)==null){
         if(orgScUpRemarkString==null){
         }else{
           //upRemarkString=orgScUpRemarkString;
           upRemarkString="";
         }
       }else{
         upRemarkString = styleRec.get(ejb.KEY_STY_SC_UP_REMARK).toString();
       }
      txtStyUpRMK.setText(upRemarkString);
      txtStyDownRMK.setText(
         (styleRec.get(ejb.KEY_STY_SC_DOWN_REMARK)==null)?
         "":styleRec.get(ejb.KEY_STY_SC_DOWN_REMARK).toString()
      );
    }else{
      txtStyDownRMK.setText(
       (styleRec.get(ejb.KEY_STY_TC_DOWN_REMARK)==null)?
       "":styleRec.get(ejb.KEY_STY_TC_DOWN_REMARK).toString()
      );
      txtStyUpRMK.setText(
         (styleRec.get(ejb.KEY_STY_CT_UP_REMARK)==null)?
         "":styleRec.get(ejb.KEY_STY_CT_UP_REMARK).toString()
      );
    }

    this.setBorder(titledBorder2);
    //this.setDebugGraphicsOptions(0);
    lblStyDnRMK.setFont(new java.awt.Font("DialogInput", 0, 12));
    lblStyDnRMK.setForeground(Color.red);
    lblStyDnRMK.setText("                                   V");
    lblStyDnRMK.setBounds(new Rectangle(14, 124, 622, 23));
    //lblFixTitleUp.setText("jLabel1");
    lblFixTitleUp.setBounds(new Rectangle(15, 18, 145, 18));
    lblFixTitleDown.setBounds(new Rectangle(14, 124, 115, 24));
    //lblFixTitleDown.setText("jLabel1");
    jScrollPane2.getViewport().add(txtStyUpRMK, null);
    this.add(jScrollPane2, null);
    this.add(jScrollPane3, null);
    this.add(lblStyUpRMK, null);
    this.add(lblStyDnRMK, null);
    this.add(lblFixTitleDown, null);
    this.add(lblFixTitleUp, null);
    jScrollPane3.getViewport().add(txtStyDownRMK, null);
  }
  public Record getRecord()throws Exception{
    if(isSC){
       styleRec.set(ejb.KEY_STY_SC_UP_REMARK,txtStyUpRMK.getText());
       styleRec.set(ejb.KEY_STY_SC_DOWN_REMARK,txtStyDownRMK.getText());
    }else{
      styleRec.set(ejb.KEY_STY_CT_UP_REMARK,txtStyUpRMK.getText());
      styleRec.set(ejb.KEY_STY_TC_DOWN_REMARK,txtStyDownRMK.getText());
    }
    return styleRec;
  }
  protected String testData(Object obj){
    return (obj==null)?"":obj.toString();
  }
  public void doSet2Default()throws Exception{
    if(isSC){
      String upRemarkString="";
       if(styleRec.get(ejb.KEY_STY_SC_UP_REMARK)==null){
         if(orgScUpRemarkString==null){
         }else{
           //upRemarkString=orgScUpRemarkString;
           upRemarkString="";
         }
       }else{
         upRemarkString = styleRec.get(ejb.KEY_STY_SC_UP_REMARK).toString();
         //have to append 2 columns: store and original style
       }
       String store=(String)styleRec.get("sty_item");
       String orgStyle=(String)styleRec.get("sty_item_name");
       if(upRemarkString==null)upRemarkString="";
       if(store!=null && store.trim().length()>0){
         if(upRemarkString.length()>0){
           if(upRemarkString.indexOf("STORE:")!=-1){
             String remarkLines[]=util.MiscFunc.split(upRemarkString,"\n");
             StringBuffer sbRemark=new StringBuffer();
             for(int i=0;i<remarkLines.length;i++){
               String line=remarkLines[i];
               if(line.indexOf("STORE:")!=-1){
                 line="STORE:"+store;
               }
               if(sbRemark.length()>0)sbRemark.append("\n");
               sbRemark.append(line);
             }
             upRemarkString=sbRemark.toString();
           }else{
            if(!upRemarkString.endsWith("\n"))upRemarkString +="\n";
            upRemarkString +=("STORE:"+store);
          }
         }else{
           if(!upRemarkString.endsWith("\n"))upRemarkString +="\n";
           upRemarkString +=("STORE:"+store);
         }

       }
       if(orgStyle!=null && orgStyle.trim().length()>0){
         if(upRemarkString.length()>0){
           upRemarkString +="\n";
         }
         upRemarkString +=("ORIGINAL STYLE:"+orgStyle);
       }

/*
        StringBuffer sql_str = new StringBuffer();
        sql_str.append("SELECT P.PROD_BUYER, T.CUST_PO, T.CUST_STYLE ");
        sql_str.append("FROM PROD_HEAD P, STYLE S, PRICE PE, TPE_CUSTOMER_PO T " );
        sql_str.append("WHERE S.PROD_HEAD_PK = P.PROD_HEAD_PK ");
        sql_str.append(" AND PE.PRI_STY_SEQ = S.STY_SEQ ");
        sql_str.append(" AND T.PRX_SEQ(+) = PE.PRI_SEQ ");
        sql_str.append(" AND PE.RECORD_DELETE_FLAG='1' ");
        sql_str.append("AND ROWNUM = 1 ");
        sql_str.append(" AND S.STY_SEQ=");
        sql_str.append(styleRec.get("STY_SEQ"));

       java.util.Vector vctCustSty=exgui2.CONST.BASIC_MAIN_EJB.getDatas( util.PublicVariable.USER_RECORD,sql_str.toString(),1,9999);
       System.out.println("=> "+ vctCustSty);
       if (vctCustSty.size() > 0 ) {
           Record rec_cust = (Record)vctCustSty.get(0);
           if (rec_cust.get("PROD_BUYER").toString().equals("12358")) {
               upRemarkString="ALDO STYLE : "+rec_cust.get("CUST_STYLE").toString()+"\n"+ "ALDO PO : "+rec_cust.get("CUST_PO").toString()+"\n"+ upRemarkString;
           }
       }
*/

      txtStyUpRMK.setText(upRemarkString);
      /*

      StringBuffer downRemark=new StringBuffer("");
      Object POobj=styleRec.get("sty_po");
      downRemark.append("PO:");
      if(POobj!=null)downRemark.append(POobj.toString());
      downRemark.append("\n");
      Object weeklyUpdate=styleRec.get("sty_updt");
      Object reconfirmDate=styleRec.get("sty_recfm_del");
      Object originalDate=styleRec.get("sty_orig_del");
      downRemark.append("DEL-DD:");

      if(weeklyUpdate!=null){

      }else if(reconfirmDate!=null){

      }else if(originalDate!=null){

      }
      */
      txtStyDownRMK.setText(generateSC_DOWN_RMK(styleRec));


    }else{
      txtStyDownRMK.setText(
       (styleRec.get(ejb.KEY_STY_TC_DOWN_REMARK)==null)?
       "":styleRec.get(ejb.KEY_STY_TC_DOWN_REMARK).toString()
      );
      txtStyUpRMK.setText(
         (styleRec.get(ejb.KEY_STY_CT_UP_REMARK)==null)?
         "":styleRec.get(ejb.KEY_STY_CT_UP_REMARK).toString()
      );
    }
    txtStyUpRMK.setCaretPosition(0);
    txtStyDownRMK.setCaretPosition(0);
  }

  protected String generateSC_DOWN_RMK(database.datatype.Record styRec)throws Exception{
    StringBuffer sb=new StringBuffer();
    /*
    String poString=testData(styRec.get(3));
    if(poString.trim().length()>0){
      sb.append("PO:");
      sb.append(poString);
      sb.append("\n");
    }*/
    String qtaString=
        testData(styRec.get("STY_QTA_CAT"));// +testData(styRec.get("STY_QTA_AREA"));
    if(qtaString.trim().length()>0){
      sb.append("QTA:");
      sb.append(qtaString);
      sb.append("\n");
    }
    //determ the price.
    String prodType=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_TYPE");
    if(prodType!=null){
      if(prodType.toLowerCase().trim().equals("k")||
         prodType.toLowerCase().trim().equals("s")){
        String wtString=testData(styRec.get("STY_WEIGHT"));
        if(wtString.trim().length()>0){
          sb.append("WT:");
          sb.append(wtString);
          sb.append("\n");
        }
      }else if(prodType.toLowerCase().trim().equals("w")){
        String cmtPrx=testData(styRec.get("STY_CMT_PRICE"));
        if(cmtPrx.trim().length()>0){
          sb.append("CMT PRICE:");
          sb.append(cmtPrx);
          sb.append("\n");
        }
        //for woven type ,only use Weight.
      }
    }
      if(styRec.get("STY_UPDT")!=null){
        sb.append("DEL-DD:");
        sb.append(dt.format((java.util.Date)styRec.get("STY_UPDT")));
        sb.append(" ");
        sb.append(getShipWayName((String)styRec.get("STY_UPDT_SHIP")));
        sb.append("\n");
      }else if(styRec.get("STY_RECFM_DEL")!=null){
        sb.append("DEL-DD:");
        sb.append(dt.format((java.util.Date)styRec.get("STY_RECFM_DEL")));
        sb.append(" ");
        sb.append(getShipWayName((String)styRec.get("STY_RECFM_SHIP")));
        sb.append("\n");
      }else if(styRec.get("STY_ORIG_DEL")!=null){
        sb.append("DEL-DD:");
        sb.append(dt.format((java.util.Date)styRec.get("STY_ORIG_DEL")));
        sb.append(" ");
        sb.append(getShipWayName((String)styRec.get("STY_ORIG_WAY")));
        sb.append("\n");
      }

    String strQty=(String)styRec.get("STY_QTY_DESC");

    if(strQty!=null){
      String UNIT_String=(String)styRec.get("STY_UNIT");
      if(util.PublicVariable.OPERATTING_CENTER.equals("001") && UNIT_String.startsWith("T.")){
        UNIT_String=UNIT_String.substring(2,UNIT_String.length());
      }
      /*
      String firstQtyDesc=util.MiscFunc.Replace(strQty,"||||||||  "," ",false);
      System.out.println("firt trim \"||||||||  \" result is:");
      System.out.println(firstQtyDesc);System.out.print("\n");
      String []lines=util.MiscFunc.split(util.MiscFunc.Replace(firstQtyDesc,"||"," ",false),"\n");
      */
      String []lines=util.MiscFunc.split(strQty,"\n");
      int didCount=0;
      //for tpe,have to test if have "CIX" column in the responding row)"
      StringBuffer sbTestCustPo=new StringBuffer();
      sbTestCustPo.append("select ");
      sbTestCustPo.append("A.PRI_SEQ, ");
      sbTestCustPo.append("B.PROD_COLOR_PK, ");
      sbTestCustPo.append("A.PRI_BYR_ACT_PRX, ");
      sbTestCustPo.append("A.PRI_BYR_doc_PRX, ");
      sbTestCustPo.append("A.PRI_mkr_ACT_PRX, ");
      sbTestCustPo.append("A.PRI_mkr_doc_PRX, ");
      sbTestCustPo.append("b.prod_color_code,b.prod_color_name, ");
      sbTestCustPo.append("(select cust_po from TPE_CUSTOMER_PO where prx_seq=a.pri_seq)  as PCIX   ");
      sbTestCustPo.append("from price a,prod_color b ");
      sbTestCustPo.append("where a.prod_color_pk=b.prod_color_pk ");
      sbTestCustPo.append("and a.pri_sty_seq=");
      sbTestCustPo.append(styleRec.getLong(0));
      sbTestCustPo.append("and not (select prod_buyer from prod_head x ,style y where x.prod_head_pk=y.prod_head_pk and y.sty_seq=a.pri_sty_seq)=12358 ");
      sbTestCustPo.append(" order by  A.PRI_SEQ ");
      java.util.Vector vctTestCustPo=exgui2.CONST.BASIC_MAIN_EJB.getDatas( util.PublicVariable.USER_RECORD,sbTestCustPo.toString(),1,9999);
      int actLineCount=0;
      for(int i=0;i<lines.length;i++){
             if(didCount>0)sb.append("\n");
             String orgString=lines[i].trim();
             if(orgString.length()==0)continue;
             String lastChar=orgString.substring(orgString.length()-1,
                                                      orgString.length());
             if(nubers.indexOf(lastChar)==-1){
               //this is not numeric data row.
               sb.append(lines[i]);
             }else{
               if(actLineCount<vctTestCustPo.size()){
                Record rectestCustPo=(Record)vctTestCustPo.get(actLineCount);
                Object objCustPoObj=rectestCustPo.get("PCIX");
                if(objCustPoObj!=null && objCustPoObj.toString().trim().length()>0){
                  sb.append("CUSTOMER-PO :");
                  sb.append(objCustPoObj);
                  sb.append("\n");
                }
               }
               actLineCount++;
               sb.append(lines[i]);
               System.out.println(" total qty is:"+lines[i].substring(lines[i].lastIndexOf(" ")+1,
                  lines[i].length()));
               sb.append("  ");
               sb.append(UNIT_String);
             }
             didCount++;
      }
      //sb.append(strQty); //the exported QTY data to ascii-graphic matrix\
      //add unit string to each

    }
    return sb.toString();
  }

}
