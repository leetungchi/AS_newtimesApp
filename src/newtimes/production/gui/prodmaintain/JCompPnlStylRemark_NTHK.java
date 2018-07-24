package newtimes.production.gui.prodmaintain;
import database.datatype.Record;
import java.awt.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class JCompPnlStylRemark_NTHK extends JCompPnlStylRemark {
  public JCompPnlStylRemark_NTHK(Record styRec,
                            boolean _isSC) {
    super(styRec,_isSC);
    lblStyUpRMK.setText("                                                  V");
    lblStyDnRMK.setText("                                                                                V");
  }
  public void doSet2Default()throws Exception{
     super.doSet2Default();
     StringBuffer sb=new StringBuffer();
     String barcode=(String)styleRec.get(118);//sty_barcode
     String buyerLabel=(String)styleRec.get(119);//sty_buyerlabel
     if(buyerLabel!=null){
       sb.append("BUYER LABEL:");
       sb.append(buyerLabel);
       sb.append("\n");
     }
     /*
     if(barcode!=null){
       sb.append("BARCODE:");
       sb.append(barcode);
       sb.append("\n");
     }*/
     //if(txtStyUpRMK.getText().trim().length()>0)txtStyUpRMK.append("\n");
       txtStyUpRMK.setText(txtStyUpRMK.getText().trim()+"\n"+sb.toString());

  }
  protected String generateSC_DOWN_RMK(database.datatype.Record styRec)throws Exception{
    StringBuffer sb=new StringBuffer();
    /*
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
    }*/
    String strQty=(String)styRec.get(108);//sty_qty_desc
    int _colorSizeQtyType=styRec.getInt(105);//sty_qty_type

    if(strQty!=null){
      String UNIT_String=(String)styRec.get(106);//sty_unit
      String []lines=util.MiscFunc.split(strQty,"\n");
      int linescount=lines.length;
      if(lines[linescount-1].trim().length()==0)linescount--;
      //one qty record,and none-license,none-size,no need to show qty text matrix.
      if((_colorSizeQtyType==12 || _colorSizeQtyType==8) && linescount<6){
        //test if color is NONE,of NONE,means no color.
        if(strQty.toUpperCase().indexOf("NONE ")!=-1)  return sb.toString();
      }
      int didCount=0;
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
               sb.append(lines[i]);
               /*
               System.out.println(" total qty is:"+lines[i].substring(lines[i].lastIndexOf(" ")+1,
                  lines[i].length()));
               */
               sb.append("  ");
               sb.append(UNIT_String);
             }
             didCount++;
      }
    }

    return sb.toString();
  }

}
