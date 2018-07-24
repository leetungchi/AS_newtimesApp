package newtimes.production.gui.prodmaintain;
import java.util.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlNthkStyles_SC_DESC extends PnlStyles_SC_DESC {
  public PnlNthkStyles_SC_DESC(Record _prodRec,Vector styles,
                           newtimesejb.production.Styles_SC_CT_Facade _ejb) {
    super(_prodRec,styles,_ejb);
  }
  public PnlNthkStyles_SC_DESC() {
    super();
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

      prodRec.set(ejb.KEY_PROD_SC_HEAD_REMARK,replaceTAB(prodHeadScRemark.txtProdHeadRMK.getText()));
      prodRec.set(ejb.KEY_PROD_SC_END_REMARK,replaceTAB(prodEndScRemark.txtProdHeadRMK.getText()));
      prodRec.set("PROD_SC_TOTAL_END_PAGE_REMARK",replaceTAB(prodTotalEndPageRemark.txtProdHeadRMK.getText()));
      storedTextesToCheckMdf.add(replaceTAB(prodHeadScRemark.txtProdHeadRMK.getText()));
      storedTextesToCheckMdf.add(replaceTAB(prodEndScRemark.txtProdHeadRMK.getText()));
      //Component obj[]=this.getComponents();
      Vector styles2update=new Vector();
      for(int i=0;i<styleUpAndDownRemarkGUIS.length;i++){
       styles2update.add(styleUpAndDownRemarkGUIS[i].getRecord());
       storedTextesToCheckMdf.add(replaceTAB(styleUpAndDownRemarkGUIS[i].txtStyUpRMK.getText()));
       storedTextesToCheckMdf.add(replaceTAB(styleUpAndDownRemarkGUIS[i].txtStyDownRMK.getText()));
      }
      java.util.HashMap hm=new java.util.HashMap();
      hm.put(ejb.KEY_ACTION2UPDATE_ALL_SC,(String)prodRec.get("prod_sc_no"));
      hm.put(ejb.KEY_RECORD_PROD_RECORD,prodRec);
      hm.put(ejb.KEY_VECTOR_STYLES,styles2update);
      ejb.doUpdate(hm,(String)util.PublicVariable.USER_RECORD.get("usr_code"));
      storedTextesToCheckMdf.add(replaceTAB(prodTotalEndPageRemark.txtProdHeadRMK.getText()));
      //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update OK");
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
