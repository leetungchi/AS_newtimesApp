package newtimes.production.gui.prodmaintain;
import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
import java.util.*;
import newtimesejb.production.Styles_SC_CT_Facade;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStyles_CT_DESC extends PnlStyles_SC_DESC {
  protected newtimesejb.production.Styles_SC_CT_Facade ejb;
 public PnlStyles_CT_DESC(Record _prodRec,Vector styles,
                          newtimesejb.production.Styles_SC_CT_Facade _ejb) {
      try {
        prodRec=_prodRec;
        styRecs=styles;
        ejb=_ejb;
        lblTitle.setText("C/T Description");
        jbInit();
        addListeners();
      }
      catch(Exception ex) {
        ex.printStackTrace();
      }
    }

  public PnlStyles_CT_DESC() {
    super();
  }
  protected void btnCopyProdEndRmkFromOtherProd_actionPerformed(java.awt.event.ActionEvent e) {
    String result=JOptionPane.showInputDialog(
     util.PublicVariable.APP_FRAME,
      "Please Input S/C:","Copy End Remark From Other Po",
      JOptionPane.QUESTION_MESSAGE);
    if(result==null)return;
    if(result.trim().length()==0){
      return;
    }
    //check if s/c exists
    String centerPrefix=null;
    try{
      Vector centers=newtimes.preproduction.guis.tempProperties.tmpCenters;
      String centerCode=util.PublicVariable.OPERATTING_CENTER.toString();
      for(int i=0;i<centers.size();i++){
        Record recCenter=(Record)centers.get(i);
        if(recCenter.get(0).equals(centerCode)){
          centerPrefix=(String)recCenter.get(18);
        }
      }

      util.MiscFunc.showProcessingMessage();
      util.MiscFunc.showProcessingMessage();
      Vector vct=null;
      if(!(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||util.PublicVariable.OPERATTING_CENTER.equals("001"))
          && result.toUpperCase().trim().length()==7){
         vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             "select PROD_CT_END_RMRK from production where prod_sc_no='" +
             centerPrefix +
             util.MiscFunc.Replace(result.toUpperCase().trim(), "'", "''") +
             "'" +
             " and record_delete_flag='1'",
             1, 1
             );

      }else{
        vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select PROD_CT_END_RMRK from production where prod_sc_no='"+
         util.MiscFunc.Replace(result.toUpperCase().trim(),"'","''")+"' "+
         " and record_delete_flag='1'",
         1,1
        );
      }

      /*
      Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      "select PROD_CT_END_RMRK from production where prod_sc_no='"+
        util.MiscFunc.Replace(result.toUpperCase().trim(),"'","''")+"' or prod_sc_no='"+
        centerPrefix+util.MiscFunc.Replace(result.toUpperCase().trim(),"'","''")+"'"+
        " and record_delete_flag='1'",
       1,1
      );*/
      util.MiscFunc.hideProcessingMessage();
      if(vct.size()==0){
        exgui.verification.VerifyLib.showPlanMsg("Sorry,No Such PO","S/C#"+result+" Not Found");
        return;
      }
      Record recProdx=(Record)vct.get(0);
      prodEndScRemark.txtProdHeadRMK.append((recProdx.get(0)==null)?"":recProdx.get(0).toString());
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Connection Error\nPlease Notify System Manager",
                                             "Connection Error");
    }
  }

 protected void btnCopyFromSC_actionPerformed(java.awt.event.ActionEvent e){
     super.btnCopyFromSC_actionPerformed(e);
     /*
     if(util.PublicVariable.OPERATTING_CENTER.equals("001")||util.PublicVariable.OPERATTING_CENTER.equals("NTHK"))return;
     try{
       String upRemarkDataOrg = (String)prodRec.get(ejb.KEY_STR_GET_METRIAL_DESC);
       if (upRemarkDataOrg == null ||
           upRemarkDataOrg.trim().equalsIgnoreCase("null"))upRemarkDataOrg = "";
       String prodLabelData = (String)prodRec.get("prod_label");
       Object szn = newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.
           get("prod_season");
       Object yearObj = newtimes.preproduction.Constants.
           CURRENT_PREPROD_HEAD_RECORD.get("prod_year");
       String seazonData = "SEASON : " +
           ((szn == null) ? "" : szn.toString()) + " " +
           ((yearObj == null) ? "" : yearObj.toString()) + "\n";
       StringBuffer sb = new StringBuffer();
       if (prodLabelData != null) {
         //"LABEL:"+prodLabelData+"\n";
         sb.append("LABEL:");
         sb.append(prodLabelData);
         sb.append("\n");
       }
       sb.append(seazonData);
       sb.append(upRemarkDataOrg);
       //upRemarkDataOrg = sb.toString();
       prodHeadScRemark.txtProdHeadRMK.setText(sb.toString());//upRemarkDataOrg);
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");

     }*/

  }
  public void data2Gui()throws Exception{
    storedTextesToCheckMdf.clear();
    prodHeadScRemark=
        new JCompPnlProdHeadRemark("PRODUCTOIN HEAD REMARK",
                                   prodRec,ejb.KEY_PROD_CT_HEAD_REMARK,
                                           ejb.KEY_PROD_SC_HEAD_REMARK,null);
    prodHeadScRemark.setPreferredSize(new Dimension(640,200));
    prodHeadScRemark.setBounds(new Rectangle(10,last_Y_Position,640,200));

    storedTextesToCheckMdf.add(
      replaceTAB(prodHeadScRemark.txtProdHeadRMK.getText())
      );


    prodEndScRemark=
        new JCompPnlProdHeadRemark("PRODUCTOIN END REMARK",
                                   prodRec,ejb.KEY_PROD_CT_END_REMARK,
                                           ejb.KEY_PROD_SC_END_REMARK,null);
    prodEndScRemark.setPreferredSize(new Dimension(640,200));

    prodTotalEndPageRemark =
        new JCompPnlProdTotalEndPageRemark("FINAL PAGE REMARK",
                                   prodRec,"PROD_CT_TOTAL_END_PAGE_REMARK",
                                   "PROD_SC_TOTAL_END_PAGE_REMARK",
                                   (String)prodRec.get("PROD_SC_TOTAL_END_PAGE_REMARK"));


    storedTextesToCheckMdf.add(
      replaceTAB(prodEndScRemark.txtProdHeadRMK.getText())
      );


    this.add(prodHeadScRemark);
    last_Y_Position+=210;
    styleUpAndDownRemarkGUIS=new JCompPnlStylRemark[styRecs.size()];
    for(int i=0;i<styRecs.size();i++){
      JCompPnlStylRemark styleData=super.getSystemJComp_Pnl_SC_Desc((Record)styRecs.get(i),false);
          //new JCompPnlStylRemark((Record)styRecs.get(i),false);
      styleData.setPreferredSize(new Dimension(640,300));
      styleData.setBounds(new Rectangle(10,last_Y_Position,640,300));
      this.add(styleData);
      last_Y_Position+=310;
      storedTextesToCheckMdf.add(replaceTAB(styleData.txtStyUpRMK.getText()));
      storedTextesToCheckMdf.add(replaceTAB(styleData.txtStyDownRMK.getText()));
      styleUpAndDownRemarkGUIS[i]=styleData;
    }
    prodEndScRemark.setBounds(new Rectangle(10,last_Y_Position,640,200));
    this.add(prodEndScRemark);
    btnCopyFromSC.setVisible(true);
    btnGetDefalutValue.setVisible(false);
    //last_Y_Position+=210;
    //btnChzShipMark.setBounds(new Rectangle(50,last_Y_Position+205,150,24));
    //btnChzPackMark.setBounds(new Rectangle(270,last_Y_Position+205,150,24));

    btnChzShipMark.setBounds(new Rectangle(50,last_Y_Position+205,150,24));
    btnChzPackMark.setBounds(new Rectangle(270,last_Y_Position+205,150,24));
    btnCopyProdEndRmkFromOtherProd.setBounds(new Rectangle(450,last_Y_Position+205,200,24));


    this.add(btnChzShipMark);
    this.add(btnChzPackMark);
    this.add(btnCopyProdEndRmkFromOtherProd);
    btnChzShipMark.addMouseListener(new ClickChzShipPackMark());
    btnChzPackMark.addMouseListener(new ClickChzShipPackMark());
    last_Y_Position+=250;
    prodTotalEndPageRemark.setBounds(new Rectangle(10,last_Y_Position,640,150));
    this.add(prodTotalEndPageRemark);
    storedTextesToCheckMdf.add(replaceTAB(prodTotalEndPageRemark.txtProdHeadRMK.getText()));
    last_Y_Position+=200;

  }
  public void doUpdate() throws Exception{
    if(replaceTAB(prodHeadScRemark.txtProdHeadRMK.getText()).getBytes().length>4000){
      exgui.verification.VerifyLib.showAlert("Head Remark Too Long\nCan Not Over Than 4000 Characters\nPlease Trim Blank Lines",
                                             "Data Too Long");
      prodHeadScRemark.txtProdHeadRMK.selectAll();
      return;
    }
    if(replaceTAB(prodEndScRemark.txtProdHeadRMK.getText()).getBytes().length>4000){
      exgui.verification.VerifyLib.showAlert("End Remark Too Long\nCan Not Over Than 4000 Characters\nPlease Trim Blank Lines",
                                             "Data Too Long");
      prodEndScRemark.txtProdHeadRMK.selectAll();
      return;
    }


    if(replaceTAB(prodTotalEndPageRemark.txtProdHeadRMK.getText()).getBytes().length>3000){
      exgui.verification.VerifyLib.showAlert("Total End Remark Too Long\nCan Not Over Than 3000 Characters",
                                             "Data Too Long");
      prodTotalEndPageRemark.txtProdHeadRMK.selectAll();
      return;
    }
    storedTextesToCheckMdf.clear();
    newtimes.production.ProdMaintain_Properties.setWaitCursor();
    util.MiscFunc.showProcessingMessage();
    try{
      prodRec.set(ejb.KEY_PROD_CT_HEAD_REMARK,replaceTAB(prodHeadScRemark.txtProdHeadRMK.getText()));
      prodRec.set(ejb.KEY_PROD_CT_END_REMARK,replaceTAB(prodEndScRemark.txtProdHeadRMK.getText()));
      prodRec.set("PROD_CT_TOTAL_END_PAGE_REMARK",replaceTAB(prodTotalEndPageRemark.txtProdHeadRMK.getText()));

      storedTextesToCheckMdf.add(replaceTAB(prodHeadScRemark.txtProdHeadRMK.getText()));
      storedTextesToCheckMdf.add(replaceTAB(prodEndScRemark.txtProdHeadRMK.getText()));
     Vector styles2update = new Vector();
     for (int i = 0; i < styleUpAndDownRemarkGUIS.length; i++) {
       styles2update.add(styleUpAndDownRemarkGUIS[i].getRecord());
       storedTextesToCheckMdf.add(replaceTAB(styleUpAndDownRemarkGUIS[i].txtStyUpRMK.getText()));
       storedTextesToCheckMdf.add(replaceTAB(styleUpAndDownRemarkGUIS[i].txtStyDownRMK.getText()));
     }

      java.util.HashMap hm=new java.util.HashMap();
      hm.put(ejb.KEY_RECORD_PROD_RECORD,prodRec);
      hm.put(ejb.KEY_VECTOR_STYLES,styles2update);
      ejb.doUpdate(hm,(String)util.PublicVariable.USER_RECORD.get("usr_code"));
      //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
      storedTextesToCheckMdf.add(replaceTAB(prodTotalEndPageRemark.txtProdHeadRMK.getText()));
    }catch(Exception exp){
      util.MiscFunc.hideProcessingMessage();
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"exp while update S/C Description");
      exgui.verification.VerifyLib.showAlert("Update Fail!\nPlease Contact System Manager","Update Fail");
    }finally{
           util.MiscFunc.hideProcessingMessage();
           newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }

}
