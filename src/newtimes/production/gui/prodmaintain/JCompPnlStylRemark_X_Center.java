package newtimes.production.gui.prodmaintain;
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

public class JCompPnlStylRemark_X_Center extends JCompPnlStylRemark {
  Record prodHeadRec;
  protected  static String stringQryPrices=null;
  java.text.DecimalFormat df=new java.text.DecimalFormat("##########.00");
  public JCompPnlStylRemark_X_Center(Record styRec,
                            boolean _isSC,Record _prodHeadRec) {
     super(styRec,_isSC);
     prodHeadRec=_prodHeadRec;
     System.out.println("");
     if(stringQryPrices==null){
       StringBuffer sb=new StringBuffer();
       sb.append("select pri_seq,PRI_BYR_DOC_PRX,PRI_BYR_ACT_PRX,PRI_MKR_DOC_PRX,PRI_MKR_ACT_PRX,");
       sb.append("b.prod_color_name,b.prod_color_code,b.prod_color_pk,");
       sb.append("(select BYMKR_BRIEF from buyer_maker where bymkr_seq=a.PRI_LICENSEE_NAME) as licensee ");
       sb.append(" from price a,prod_color b ");
       sb.append("where 1=1 and a.PROD_COLOR_PK=b.PROD_COLOR_PK(+) and pri_seq in (");
       sb.append("select distinct pri_seq from qty where qty_sty_seq=#####) and a.record_delete_flag='1'order by pri_Seq");
       stringQryPrices=sb.toString();
     }
  }
  public void doCopyFormSc()throws Exception{
    //System.out.println("X_CENTER,doCOMPY FROM SC");
    if(!isSC){
      //copy sc default value to ct.
      Object data=styleRec.get(ejb.KEY_STY_SC_UP_REMARK);
      txtStyUpRMK.setText((data==null)?"":data.toString());
      /*
      data=generateSC_DOWN_RMK(styleRec);
      txtStyDownRMK.setText((data==null)?"":data.toString());
      */
      //20061219,PW/FE...center usr defalt copy action.
      data=styleRec.get(ejb.KEY_STY_SC_DOWN_REMARK);
      txtStyDownRMK.setText((data==null)?"":data.toString());

      txtStyUpRMK.setCaretPosition(0);
      txtStyDownRMK.setCaretPosition(0);
    }
   };
   protected String generateSC_DOWN_RMK(database.datatype.Record styRec)throws Exception{

     if(newtimes.preproduction.Constants.isNthkModeNow()){
       //for NTHK mode,PO of NONE-NTHK center,style down remark--qty amt text matrix is generated in order print unit
       return "";
     }
     //System.out.println("prodHeadRec is:"+prodHeadRec.toString());
     //System.out.println("styeRec is:"+styRec.toString());
     StringBuffer sb=new StringBuffer();
     String barcode=(String)styRec.get(118);//sty_barcode
     if(barcode!=null){
       sb.append("BARCODE:");
       sb.append(barcode);
       sb.append("\n");
     }
     String buyerLabel=(String)styRec.get(119);//sty_buyerlabel
     if(buyerLabel!=null){
       sb.append("BUYER LABEL:");
       sb.append(buyerLabel);
       sb.append("\n");
     }
     String strQty=(String)styRec.get(108);//sty_qty_desc
     int _colorSizeQtyType=styRec.getInt(105);//sty_qty_type

     if(strQty!=null){
       Vector recPriceAndColor = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
           util.PublicVariable.USER_RECORD,
           util.MiscFunc.Replace(stringQryPrices, "#####",
                                 String.valueOf(styRec.getInt(0)))
           , 1, 99999);
       String[] lines = util.MiscFunc.split(strQty, "\n");
       int linescount = lines.length;
       if (lines[linescount - 1].trim().length() == 0)linescount--; //be aware of the last blank line.
       String[] HEADING_STRING = new String[linescount];
       String[] PRICE_ROWS = new String[linescount];
       String[] COLOR_CODES = new String[linescount];
       String[] QTY_SIZE_DESCS = new String[linescount];
       String[] PRICE_TERMS = new String[linescount];
       String[] QC_COUNTRIES = new String[linescount];
       String[] DESTINATIONS = new String[linescount];
       String[] UNITS = new String[linescount];
       String[] CURRENCY = new String[linescount];
       String[] AMOUNTS = new String[linescount];
       String TotalQty[]= new String[linescount];
       String[] QUOTA=new String[linescount];
       String[] COLOR_NAME=new String[linescount];
       String[] LICENSEE=new String[linescount];

       int szBegin = lines[linescount - 1].indexOf("TOTAL") + 8;

       for (int i = 0; i < linescount; i++) {
         QTY_SIZE_DESCS[i] = lines[i].substring(szBegin, lines[i].length());
         if(i!=0 && i!=1 && i!=linescount-2){
           //System.out.println("qty list :"+QTY_SIZE_DESCS[i].trim());
           String tmpString=QTY_SIZE_DESCS[i].trim();
           TotalQty[i] = tmpString.substring(tmpString.lastIndexOf(' ')+1,tmpString.length());
         }
         if(i==0){
           HEADING_STRING[i] = " "+lines[i].substring(0, szBegin);
         }else{
           HEADING_STRING[i] = lines[i].substring(0, szBegin);
         }
         if (HEADING_STRING[i].trim().equalsIgnoreCase("TOTAL") ||
             HEADING_STRING[i].trim().equalsIgnoreCase("TOTAL:")) {
            HEADING_STRING[i] = util.MiscFunc.complementString(' ', " ", szBegin+1);
         }
       }

       //columns of records of price and color...'
       //select pri_seq,PRI_BYR_DOC_PRX,PRI_BYR_ACT_PRX,PRI_MKR_DOC_PRX,PRI_MKR_ACT_PRX,
       //b.prod_color_name,b.prod_color_code,b.prod_color_pk


       COLOR_CODES[0] = util.MiscFunc.complementString(' ', " CODE", 7);
       COLOR_CODES[1] = util.MiscFunc.complementString('-', "----", 7);
       COLOR_CODES[linescount - 2] = util.MiscFunc.complementString('-', "----", 7);
       COLOR_CODES[linescount - 1] = util.MiscFunc.complementString(' ', " ", 7);
        //production's PROD_SC_PRC_TRM or styles STY_CT_PRC_TRM
       String priceterm_str = ((String)((isSC) ? prodHeadRec.get(5) : styRec.get(70))).trim();
       int prx_trm_length = (priceterm_str.length() > "Terms".length()) ?   priceterm_str.length() : "Terms".length();
       PRICE_TERMS[0] = util.MiscFunc.complementString(' ', "Terms",prx_trm_length+1);
       PRICE_TERMS[1] = util.MiscFunc.complementString('-', "----", prx_trm_length+1);
       PRICE_TERMS[linescount -1] = util.MiscFunc.complementString(' ', " ", prx_trm_length+1);
       PRICE_TERMS[linescount -2] = util.MiscFunc.complementString('-', "----", prx_trm_length+1);
       priceterm_str = util.MiscFunc.complementString(' ', priceterm_str,prx_trm_length+1);
       if(styRec.get(114)==null){
         String strStyle=(String)styRec.get(2);
         String strPo=(String)styRec.get(3);
         exgui.verification.VerifyLib.showAlert(
        "Please Assigne C/T Destination For"+((strStyle==null)?"":(" STYLE:"+strStyle))+
                                              ((strPo==null)?"":(" PO:"+strPo))
       ,"Please Assigne C/T Destination");
        return "";
       }
       //productions  PROD_SC_DEST or //styles STY_CT_DEST
       String destination = ((String)((isSC) ? prodHeadRec.get(6) : styRec.get(114))).trim(); //sc-dest of production or ct dest of style
       int lengthOfDestStr = (destination.length() > "Destination".length()) ?  destination.length() : "Destination".length();
       DESTINATIONS[0] = util.MiscFunc.complementString(' ', "Destination",lengthOfDestStr+1);
       DESTINATIONS[1] = util.MiscFunc.complementString('-', "----", lengthOfDestStr+1);
       DESTINATIONS[linescount -1] = util.MiscFunc.complementString(' ', " ", lengthOfDestStr+1);
       DESTINATIONS[linescount -2] = util.MiscFunc.complementString('-', "----", lengthOfDestStr+1);
       destination = util.MiscFunc.complementString(' ', destination,lengthOfDestStr+1);

       String qcCountry = ((String)prodHeadRec.get(36)).trim(); //QC country --production's  PROD_QC_CNTY
       int lengthOfqcCoutnry = (qcCountry.length() > "COUNTRY OF ORIGIN".length()) ? qcCountry.length() : "COUNTRY OF ORIGIN".length();
       QC_COUNTRIES[0] = util.MiscFunc.complementString(' ', "COUNTRY OF ORIGIN",lengthOfqcCoutnry+1);
       QC_COUNTRIES[1] = util.MiscFunc.complementString('-', "----",lengthOfqcCoutnry+1);
       QC_COUNTRIES[linescount -2] = util.MiscFunc.complementString('-', "----", lengthOfqcCoutnry+1);
       QC_COUNTRIES[linescount -1] = util.MiscFunc.complementString(' ', "TOTAL", lengthOfqcCoutnry+1);
       qcCountry = util.MiscFunc.complementString(' ', qcCountry,lengthOfqcCoutnry+1);

       String currecyStr=(String)((isSC)?prodHeadRec.get(8):styRec.get(45));//sc currency,or sty-ct-currency
       CURRENCY[0] = util.MiscFunc.complementString(' ', "CUR", 4);
       CURRENCY[1] = util.MiscFunc.complementString('-', "----", 4);
       CURRENCY[linescount - 2] = util.MiscFunc.complementString('-', "----", 4);
       //CURRENCY[linescount - 1] = util.MiscFunc.complementString(' ', " ", 9);
       currecyStr= util.MiscFunc.complementString(' ', currecyStr, 4);
       CURRENCY[linescount - 1] = currecyStr;//util.MiscFunc.complementString(' ',currecyStr, 9);

       String unitStr=styRec.get(106).toString();
       /*
       if((unitStr.length()+1)<" UNIT".length()){
         unitStr = util.MiscFunc.complementString(' ', unitStr, 5);
       }else{
         unitStr =" "+unitStr;
       }*/
       UNITS[0] = util.MiscFunc.complementString(' ', " ", unitStr.length());
       UNITS[1] = util.MiscFunc.complementString('-', "----", unitStr.length());
       UNITS[linescount - 2] = util.MiscFunc.complementString('-', "----", unitStr.length());
       UNITS[linescount - 1] =unitStr; //util.MiscFunc.complementString(' ', " ", unitStr.length());

       int maxQtaLength="TOTAL".length();
       String qtaStringCAT=(String)styRec.get(43);//
       //String qtaStringArea=(String)styRec.get(44);//sc currency,or sty-ct-currency
       String qtaString="      ";
       if(qtaStringCAT!=null && (!qtaStringCAT.equals("null")))qtaString=qtaStringCAT.trim();
       if(maxQtaLength<qtaString.length())maxQtaLength=qtaString.length();
       QUOTA[0] = util.MiscFunc.complementString(' ', "QTA", maxQtaLength+1);
       QUOTA[1] = util.MiscFunc.complementString('-', "----", maxQtaLength+1);
       QUOTA[linescount - 2] = util.MiscFunc.complementString('-', "----", maxQtaLength+1);
       QUOTA[linescount - 1] = util.MiscFunc.complementString(' ', "TOTAL", maxQtaLength+1);
       qtaString=" "+util.MiscFunc.complementString(' ', qtaString, maxQtaLength);


       int maxLengthOfAmount="AMOUNT".length();
       int maxPriceLength=" PRICE".length();
       float totalAmount=0;
       int maxColorNameLen=" COLOR".length();
       int maxLicenseeLen=" LICENSEE".length();
       boolean isStyleWithColor=((_colorSizeQtyType&0x04)!=0);
       boolean isStyleWithLicensee=((_colorSizeQtyType&0x01)!=0);
       for (int i = 2; i < (linescount - 2); i++) {
         Object objPrice = ((Record)recPriceAndColor.get(i - 2)).get(
                                     (isDocPrice)?(isSC ? 1 :3):(isSC ? 2 :4));
         String prx = (objPrice == null) ? "0" : objPrice.toString();

         PRICE_ROWS[i] = df.format(Float.parseFloat(prx));
         if(prx.length()>maxPriceLength)maxPriceLength=prx.length();

         if(isStyleWithColor){
           String colorNameStr = (String)((Record)recPriceAndColor.get(i - 2)).
               get(5);
           if (colorNameStr == null)colorNameStr = " ";
           if (maxColorNameLen < colorNameStr.trim().length())maxColorNameLen =
               colorNameStr.trim().length();
           COLOR_NAME[i] = colorNameStr;
         }else{
           COLOR_NAME[i]="";
         }
         if(isStyleWithLicensee){
           String licenseeName = (String)((Record)recPriceAndColor.get(i - 2)).
               get(8);
           if (licenseeName == null)licenseeName = " ";
           if (maxLicenseeLen < licenseeName.trim().length())maxLicenseeLen =
               licenseeName.trim().length();
           LICENSEE[i] = licenseeName;
         }else{
           LICENSEE[i] = "";
         }

         String codeStr = (String)((Record)recPriceAndColor.get(i - 2)).get(6);
         if (codeStr == null)codeStr = "       ";
         COLOR_CODES[i] = util.MiscFunc.complementString(' ', codeStr, 7);
         PRICE_TERMS[i] = priceterm_str;
         //DESTINATIONS[i] = destination;
         //QC_COUNTRIES[i] = qcCountry;
         CURRENCY[i] = currecyStr;
         QUOTA[i]=qtaString;
         UNITS[i]=unitStr;
         totalAmount+=Float.parseFloat(df.format((Float.parseFloat(prx) * Float.parseFloat(TotalQty[i]))));
         AMOUNTS[i]=df.format(Float.parseFloat(prx) * Float.parseFloat(TotalQty[i]));
         if(AMOUNTS[i].length()>maxLengthOfAmount)maxLengthOfAmount=AMOUNTS[i].length();
       }
       AMOUNTS[linescount-1]=df.format(totalAmount);
       if(AMOUNTS[linescount-1].length()>maxLengthOfAmount)maxLengthOfAmount=AMOUNTS[linescount-1].length();
       AMOUNTS[0] = util.MiscFunc.complementString(' ', "AMOUNT", maxLengthOfAmount+1);
       AMOUNTS[1] = util.MiscFunc.complementString('-', "---", maxLengthOfAmount+1);
       AMOUNTS[linescount - 2] = util.MiscFunc.complementString('-', "---", maxLengthOfAmount+1);

       PRICE_ROWS[0] = util.MiscFunc.complementString(' ', " PRICE", maxPriceLength+1);
       PRICE_ROWS[1] = util.MiscFunc.complementString('-', "---", maxPriceLength+1);
       PRICE_ROWS[linescount - 2] = util.MiscFunc.complementString('-', "---", maxPriceLength+1);
       PRICE_ROWS[linescount - 1] = util.MiscFunc.complementString(' ', " ", maxPriceLength+1);

       COLOR_NAME[0] = util.MiscFunc.complementString(' ', " COLOR", maxColorNameLen+1);
       COLOR_NAME[1] = util.MiscFunc.complementString('-', "-----", maxColorNameLen+1);
       COLOR_NAME[linescount - 2] = util.MiscFunc.complementString('-', "---", maxColorNameLen+1);
       COLOR_NAME[linescount - 1] = util.MiscFunc.complementString(' ', " ", maxColorNameLen+1);

       LICENSEE[0] = util.MiscFunc.complementString(' ', " LICENSEE", maxLicenseeLen+1);
       LICENSEE[1] = util.MiscFunc.complementString('-', "-----", maxLicenseeLen+1);
       LICENSEE[linescount - 2] = util.MiscFunc.complementString('-', "---", maxLicenseeLen+1);
       LICENSEE[linescount - 1] = util.MiscFunc.complementString(' ', " ", maxLicenseeLen+1);



       //append to text area.

       for (int i = 0; i < linescount; i++) {
          //sb.append(HEADING_STRING[i]);
          if(isStyleWithLicensee){
            if(i!=0 && i!=1 && i!=(linescount - 2)&&  i!=(linescount - 1)){
              LICENSEE[i]=util.MiscFunc.complementString(' ',LICENSEE[i],maxLicenseeLen+1);
            }
            sb.append(LICENSEE[i]);
          }
          sb.append(COLOR_CODES[i]);
          if(i!=0 && i!=1 && i!=(linescount - 2)&&  i!=(linescount - 1)){
            COLOR_NAME[i]=util.MiscFunc.complementString(' ',COLOR_NAME[i],maxColorNameLen+1);
          }
          sb.append(COLOR_NAME[i]);
          //sb.append(PRICE_TERMS[i]);
          sb.append(QUOTA[i]);
          /*
          sb.append(DESTINATIONS[i]);
          sb.append(QC_COUNTRIES[i]);
          */
          sb.append(QTY_SIZE_DESCS[i]);
          sb.append(UNITS[i]);
          sb.append(CURRENCY[i]);
          //System.out.println("Currency  object"+CURRENCY[i]);
          if(i!=0 && i!=1 && i!=(linescount - 2)&&  i!=(linescount - 1)){
            PRICE_ROWS[i]=util.MiscFunc.complementString(' ',PRICE_ROWS[i],maxPriceLength+1);
          }
          //System.out.println("price  object"+PRICE_ROWS[i]);
          sb.append(PRICE_ROWS[i]);
          if(i!=0 && i!=1 && i!=(linescount - 2) ){
            AMOUNTS[i]=util.MiscFunc.complementString(' ',AMOUNTS[i],maxLengthOfAmount+1);
          }
          sb.append(AMOUNTS[i]);
          sb.append("\n");
       }
     }
     return sb.toString();
   }

}
