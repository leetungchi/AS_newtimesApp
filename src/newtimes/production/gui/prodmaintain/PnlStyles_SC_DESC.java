package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import database.datatype.Record;
import java.util.*;
import newtimesejb.production.Styles_SC_CT_Facade;
import java.awt.event.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStyles_SC_DESC extends JPanel
 implements processhandler.DataProcesser{
  protected JScrollPane jScrollPane1 = new JScrollPane();
  protected JButton btnCopyFromSC = new JButton();
  protected JButton btnClearAll=new JButton();
  protected JButton btnGetDefalutValue=new JButton();

  protected Record prodRec=null;
  protected Vector styRecs=null;
  public JCompPnlProdHeadRemark prodHeadScRemark=null;
  protected JCompPnlProdHeadRemark prodEndScRemark=null;
  protected JCompPnlProdTotalEndPageRemark prodTotalEndPageRemark=null;
  protected newtimesejb.production.Styles_SC_CT_Facade ejb;
  protected JLabel title_label=new JLabel("S/C Description");
  protected int last_Y_Position=50;
  protected JLabel lblTitle = new JLabel();
  protected Vector storedTextesToCheckMdf=new Vector();
  protected JCompPnlStylRemark styleUpAndDownRemarkGUIS[]=null;
  protected JButton btnChzShipMark=new JButton("Get Shipping Mark");
  protected JButton btnChzPackMark=new JButton("Get Packing ");
  protected JButton btnCopyProdEndRmkFromOtherProd=new JButton("Copy From Other Po");
  protected JButton btnRetrieveBackupText=new JButton("RETRIEVE BACK-UP DESC");
  protected database.datatype.Record   rec_div_store;
  public PnlStyles_SC_DESC(Record _prodRec,Vector styles,
                           newtimesejb.production.Styles_SC_CT_Facade _ejb) {
    try {
      prodRec=_prodRec;
      styRecs=styles;
      ejb=_ejb;
      lblTitle.setText("S/C Description");
      jbInit();
      addListeners();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public PnlStyles_SC_DESC() {
    try {
      jbInit();
      //addListeners();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
public int getLastYPos(){
  return last_Y_Position;
}
protected JCompPnlStylRemark getSystemJComp_Pnl_SC_Desc(Record style,boolean is4Sc){
  String userCenterCode=(String)util.PublicVariable.OPERATTING_CENTER;
  if(userCenterCode.equals("001"))return new JCompPnlStylRemark(style,is4Sc);
  if(userCenterCode.equals("NTHK"))return new JCompPnlStylRemark_NTHK(style,is4Sc);
  //return new JCompPnlStylRemark_NTHK(style,is4Sc);
  return new JCompPnlStylRemark_X_Center(style,is4Sc,prodRec);
}
public void exitCurrentGui(){}
public boolean isContextModified(){
  //list all strings compare if modified.
  int count=0;
  if(!replaceTAB(((String)storedTextesToCheckMdf.get(0))).equals(
     replaceTAB(prodHeadScRemark.txtProdHeadRMK.getText())))return true;
  if(!replaceTAB(((String)storedTextesToCheckMdf.get(1))).equals(
       replaceTAB(prodEndScRemark.txtProdHeadRMK.getText())))return true;
   for(int i=0;i<styleUpAndDownRemarkGUIS.length;i++){
     if(!replaceTAB(styleUpAndDownRemarkGUIS[i].txtStyUpRMK.getText()).equals(
        replaceTAB(((String)storedTextesToCheckMdf.get(i*2+2))))){
       return true;
     }
     if(!replaceTAB(styleUpAndDownRemarkGUIS[i].txtStyDownRMK.getText()).equals(
        replaceTAB(((String)storedTextesToCheckMdf.get(i*2+3))))){
       return true;
     }
     count=i*2+3;
   }
   count++;
   if(!replaceTAB(((String)storedTextesToCheckMdf.get(count))).equals(
      replaceTAB(prodTotalEndPageRemark.txtProdHeadRMK.getText())))return true;

  return false;
}
protected  void jbInit() throws Exception {
    this.setLayout(null);
    setBackground(new Color(204, 204, 225));
    //pnlContainer.setLayout(gridLayout1);
    //this.add(jScrollPane1, null);
    btnCopyFromSC.setBounds(new Rectangle(500, 25, 186, 24));
    btnCopyFromSC.setFont(new java.awt.Font("Dialog", 1, 11));
    String userCenterCode=(String)util.PublicVariable.OPERATTING_CENTER;
    if(userCenterCode.equals("001")||userCenterCode.equals("NTHK")){
      btnCopyFromSC.setText("COPY FROM SC");
    }else{
      btnCopyFromSC.setText("GET C/T DESC.");
    }

    btnClearAll.setBounds(new Rectangle(50, 25,186, 24));
    btnClearAll.setFont(new java.awt.Font("Dialog", 1, 11));
    btnClearAll.setText("Clear All");

    btnGetDefalutValue.setBounds(new Rectangle(250, 25, 186, 24));
    btnGetDefalutValue.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGetDefalutValue.setText(">> Get Default Value <<");
    if(styRecs!=null){
      data2Gui();
    }
    last_Y_Position+=30;
    //jScrollPane1.getViewport().add(pnlContainer, null);

    lblTitle.setFont(new java.awt.Font("Dialog", 1, 11));
    lblTitle.setBounds(new Rectangle(7, 2, 162, 21));
    this.add(btnCopyFromSC, null);
    this.add(btnClearAll, null);
    this.add(btnGetDefalutValue, null);
    this.add(lblTitle, null);
  }
  protected void addListeners(){
    btnCopyFromSC.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(ActionEvent e) {
        btnCopyFromSC_actionPerformed(e);
      }
     });
     btnClearAll.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(ActionEvent e) {
         btnClearAll_actionPerformed(e);
       }
     });
     btnGetDefalutValue.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(ActionEvent e) {
         btnGetDefalutValue_actionPerformed(e);
       }
     });
     //btnCopyProdEndRmkFromOtherProd_actionPerformed
     btnCopyProdEndRmkFromOtherProd.addActionListener(new java.awt.event.ActionListener() {
       public void actionPerformed(ActionEvent e) {
         btnCopyProdEndRmkFromOtherProd_actionPerformed(e);
       }
     });

  }
  void backupRemarkDesc(java.util.HashMap hmReadyToBackup)throws Exception{
    if(hmReadyToBackup!=null){
      util.MiscFunc.showProcessingMessage();
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
      java.util.HashMap hmParam=new java.util.HashMap();
      hmParam.put("TPEMISCFUNC_ACTION_CODE","BACKUP_SC_DESC_REMARK");
      hmParam.put("PROD_HEAD_PK",prodRec.get(0).toString());
      hmParam.put("Data2BackUp",hmReadyToBackup);
      ejbHome.create().tpeMisFunc(hmParam);
      util.MiscFunc.hideProcessingMessage();
      return;
    }
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      /*
       store gui fields into file in server,wait for restore of need in future.
       */
      HashMap hmBackup=new HashMap();
      hmBackup.put("PROD_UP_REMARK",(String)storedTextesToCheckMdf.get(0));
      hmBackup.put("PROD_END_REMARK",(String)storedTextesToCheckMdf.get(1));
      java.util.Vector vctStyleUpRemark=new Vector();
      Vector vctStyleDownRemark=new Vector();
      int count=0;
      for(int i=0;i<styleUpAndDownRemarkGUIS.length;i++){
        vctStyleUpRemark.add((String)storedTextesToCheckMdf.get(i*2+2));
        vctStyleDownRemark.add((String)storedTextesToCheckMdf.get(i*2+3));
        count=i*2+3;
      }
      count++;
      hmBackup.put("PROD_FINAL_REMARK",(String)storedTextesToCheckMdf.get(count));
      hmBackup.put("VCT_STYLE_UP_REMARK",vctStyleUpRemark);
      hmBackup.put("VCT_STYLE_DOWN_REMARK",vctStyleDownRemark);
      util.MiscFunc.showProcessingMessage();
      newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
          (newtimesejb.TPE_MIS.TpeMisFuncHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,
          "newtimesejb.TPE_MIS.TpeMisFunc");
      newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
      java.util.HashMap hmParam=new java.util.HashMap();
      hmParam.put("TPEMISCFUNC_ACTION_CODE","BACKUP_SC_DESC_REMARK");
      hmParam.put("PROD_HEAD_PK",prodRec.get(0).toString());
      hmParam.put("Data2BackUp",hmBackup);
      ejbHome.create().tpeMisFunc(hmParam);
      util.MiscFunc.hideProcessingMessage();
    }

  }

  public void data2Gui()throws Exception{

    String upRemarkDataOrg=(String)prodRec.get(ejb.KEY_STR_GET_METRIAL_DESC);
    if(upRemarkDataOrg==null || upRemarkDataOrg.trim().equalsIgnoreCase("null"))upRemarkDataOrg="";
    String prodLabelData=(String)prodRec.get("prod_label");
    String groupData=null;

    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
        Object grpCode = newtimes.preproduction.Constants.
            CURRENT_PREPROD_HEAD_RECORD.get("prod_group");
        Object grpName = newtimes.preproduction.Constants.
            CURRENT_PREPROD_HEAD_RECORD.get("prod_group_name");
        groupData = "GROUP : " +
            ((grpCode == null) ? "" : grpCode.toString()) + " " +
            ((grpName == null) ? "" : grpName.toString()) + "\n";
    }
    String buyerSc=null;
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      Object buyer=newtimes.preproduction.Constants.
            CURRENT_PREPROD_HEAD_RECORD.get("prod_buyer");
      if((buyer.toString().equals("11227")||buyer.toString().equals("11226"))){
         buyerSc=(String)newtimes.preproduction.Constants.
            CURRENT_PREPROD_HEAD_RECORD.get("PRODUCTION_BYR_SC_NO");
      }
    }




    Object szn=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_season");
    Object yearObj=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_year");
    String divcode="";
    if(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_buyer_division") != null) {
        divcode=newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_buyer_division").toString();
      }
    String seazonData="SEASON : "+
        ((szn==null)?"":szn.toString())+" "+
        ((yearObj==null)?"":yearObj.toString())+"\n";

    storedTextesToCheckMdf.clear();
    StringBuffer sb=new StringBuffer();

    if(prodLabelData!=null){
      //"LABEL:"+prodLabelData+"\n";
      sb.append("LABEL:");
      sb.append(prodLabelData);
      sb.append("\n");
    }
    if(groupData!=null){sb.append(groupData);}
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      if( sb.length()>0 && (!sb.toString().endsWith("\n")))sb.append("\n");
      sb.append(seazonData);
    }
    if (divcode.equals("KOMWM")) {
         StringBuffer sql_div = new StringBuffer();
         sql_div.append("SELECT D.DIV_NAME, NVL(S.STY_ITEM,' ') STY_ITEM FROM PROD_HEAD P, DIVISION D, STYLE S ");
         sql_div.append("WHERE D.DIV_CODE (+) = P.PROD_BUYER_DIVISION ");
         sql_div.append("AND S.PROD_HEAD_PK = P.PROD_HEAD_PK ");
         sql_div.append("AND S.RECORD_DELETE_FLAG='1' AND ROWNUM=1 AND P.PROD_HEAD_PK=");
         sql_div.append(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_head_pk").toString());
         Vector div_vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.USER_RECORD,sql_div.toString(),1,1);
         Record div_rec = (Record)div_vct.get(0);
         sb.append("STORE : "+div_rec.get("DIV_NAME")+" "+div_rec.get("STY_ITEM")+"\n");

    }


    if( sb.length()>0 && (!sb.toString().endsWith("\n")))sb.append("\n");
    sb.append(upRemarkDataOrg);
    if(buyerSc!=null && buyerSc.trim().length()>0){
      if( sb.length()>0 && (!sb.toString().endsWith("\n")))sb.append("\n");
      sb.append(buyerSc);
    }


    upRemarkDataOrg=sb.toString();

    prodHeadScRemark=
        new JCompPnlProdHeadRemark("PRODUCTION HEAD REMARK",
                                   prodRec,ejb.KEY_PROD_SC_HEAD_REMARK,null,
                                   upRemarkDataOrg);
   prodTotalEndPageRemark =
       new JCompPnlProdTotalEndPageRemark("FINAL PAGE REMARK",
                                  prodRec,"PROD_SC_TOTAL_END_PAGE_REMARK",null,
                                  (String)prodRec.get("PROD_SC_TOTAL_END_PAGE_REMARK"));
    storedTextesToCheckMdf.add(
      replaceTAB(prodHeadScRemark.txtProdHeadRMK.getText())
      );


    prodHeadScRemark.setPreferredSize(new Dimension(640,200));
    prodHeadScRemark.setBounds(new Rectangle(10,last_Y_Position,640,200));

    String orgProdEndRemark=(String)prodRec.get(ejb.KEY_PROD_SC_END_REMARK);

    prodEndScRemark=
        new JCompPnlProdHeadRemark("PRODUCTION END REMARK",
                                   prodRec,ejb.KEY_PROD_SC_END_REMARK,null,orgProdEndRemark);
    storedTextesToCheckMdf.add(
      replaceTAB(prodEndScRemark.txtProdHeadRMK.getText())
      );
    prodEndScRemark.setPreferredSize(new Dimension(640,200));
    this.add(prodHeadScRemark);
    last_Y_Position+=210;
    styleUpAndDownRemarkGUIS=new JCompPnlStylRemark[styRecs.size()];
    for(int i=0;i<styRecs.size();i++){
      JCompPnlStylRemark styleData=getSystemJComp_Pnl_SC_Desc((Record)styRecs.get(i),true);
          //new JCompPnlStylRemark((Record)styRecs.get(i),true);

      styleData.setPreferredSize(new Dimension(640,300));
      styleData.setBounds(new Rectangle(10,last_Y_Position,640,300));
      storedTextesToCheckMdf.add(replaceTAB(styleData.txtStyUpRMK.getText()));
      storedTextesToCheckMdf.add(replaceTAB(styleData.txtStyDownRMK.getText()));
      styleUpAndDownRemarkGUIS[i]=styleData;
      //pnlContainer.add(styleData);
      this.add(styleData);
      last_Y_Position+=310;
    }
    prodEndScRemark.setBounds(new Rectangle(10,last_Y_Position,640,200));

    this.add(prodEndScRemark);
    btnCopyFromSC.setVisible(false);
    //add button to generate Shipping Mark & Packing Mark.
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
    btnRetrieveBackupText.setBounds(new Rectangle(200,last_Y_Position-30,200,24));
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      this.add(btnRetrieveBackupText);
      btnRetrieveBackupText.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(ActionEvent e) {
               btnRetrieveBackRemarkDesc_actionPerformed();
             }
           });

    }

  }
  class ChaiedProcChzShipPackingMark extends exgui.chaindialog.ChainedDialogBox{
    ChaiedProcChzShipPackingMark(javax.swing.JFrame frame,String title,boolean model,
                          exgui.chaindialog.Responsible rsp){
      super(frame,title,model,rsp);
    }
    public Object getDialogResult(){
      return super.resultHashMap;
    }
  }

  class ClickChzShipPackMark extends java.awt.event.MouseAdapter{
    public void mouseClicked(java.awt.event.MouseEvent me){
       exgui.chaindialog.ChainedDialogBox chgDlg=null;
      if(me.getSource()==btnChzShipMark){
        PnlRspInit4ShipPackMark pnl=new PnlRspInit4ShipPackMark("Shipping Mark",
                                     PnlRspInit4ShipPackMark.SEARCH_SHIPPIMG_MARK);
         // if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
         try {
           int buyerSeq = newtimes.preproduction.Constants.
               CURRENT_PREPROD_HEAD_RECORD.getInt("prod_buyer");
           Vector vctShipMark = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
               util.PublicVariable.USER_RECORD,
               "select * from SHIPMARK where record_delete_flag='1' and SHIPMARK_BYMKR_SEQ=" +
               buyerSeq, 1, 99999);

           if(vctShipMark.size()==1){
             Record rec = (Record)vctShipMark.get(0);
             PnlRspShowMark nextRsp = new PnlRspShowMark((String)rec.get(2),
                 (String)rec.get(3));
             chgDlg = new ChaiedProcChzShipPackingMark(util.PublicVariable.
                 APP_FRAME,"Select Shipping Mark", true, nextRsp);
           }else if(vctShipMark.size()>1){
             PnlRspNthkShowShipMaks nextRsp = new PnlRspNthkShowShipMaks(vctShipMark);
             chgDlg = new ChaiedProcChzShipPackingMark(util.PublicVariable.
                 APP_FRAME,"Select Shipping Mark", true, nextRsp);

           }else{
             chgDlg = new ChaiedProcChzShipPackingMark(util.PublicVariable.
                 APP_FRAME, "Select Shipping Mark", true, pnl);
           }

         } catch (Exception exp) {
           exp.printStackTrace();
           util.ExceptionLog.exp2File(exp,"");
           chgDlg = new ChaiedProcChzShipPackingMark(util.PublicVariable.
               APP_FRAME, "Select Shipping Mark", true, pnl);
         }
       /*
       }else{
         chgDlg = new ChaiedProcChzShipPackingMark(util.PublicVariable.
             APP_FRAME, "Select Shipping Mark", true, pnl);
       }*/

      }else{
        PnlRspInit4ShipPackMark pnl=new PnlRspInit4ShipPackMark("Packing ",
                                     PnlRspInit4ShipPackMark.SEARCH_PACKING_MARK);
        chgDlg = new  ChaiedProcChzShipPackingMark(util.PublicVariable.APP_FRAME,
                                         "Select Packing",true,pnl);
      }
      chgDlg.setSize(new Dimension(500,400));
      exgui.UIHelper.setToScreenCenter(chgDlg);
      chgDlg.show();
      if(chgDlg.getDialogResult()!=null){
        String remarkString=(String)((java.util.HashMap)chgDlg.getDialogResult()).get(PnlRspShowMark.KEY_TEXT_AREA_DATA);
        if(remarkString!=null){
          String orgText= replaceTAB(prodEndScRemark.txtProdHeadRMK.getText());
          if(orgText.trim().length()>0){
            prodEndScRemark.txtProdHeadRMK.setText(orgText+"\n"+remarkString);
          }else{
            prodEndScRemark.txtProdHeadRMK.setText(remarkString);
          }
        }
      }
    }
  }
  protected String replaceTAB(String str){
    if(str==null)return "";
    return util.MiscFunc.Replace(str,"\t","       ",false);
  }
  void btnRetrieveBackRemarkDesc_actionPerformed(){
       try{
         util.MiscFunc.showProcessingMessage();
         newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
             (newtimesejb.TPE_MIS.TpeMisFuncHome)
             info_ejb.WeblogicServiceLocator.locateServiceHome(
             util.PublicVariable.SERVER_URL,
             "newtimesejb.TPE_MIS.TpeMisFunc");
         newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
         java.util.HashMap hmParam=new java.util.HashMap();
         hmParam.put("TPEMISCFUNC_ACTION_CODE","RETRIEVE_BACKUP_SC_DESC_REMARK");
         hmParam.put("PROD_HEAD_PK",prodRec.get(0).toString());
         HashMap hm= ejbHome.create().tpeMisFunc(hmParam);
         Vector vctBackup=(Vector)hm.get("HASH_MAP_VCT");
         util.MiscFunc.hideProcessingMessage();
         if(vctBackup==null||vctBackup.size()==0){
           exgui.verification.VerifyLib.showPlanMsg("No Backup Data","No Back UP Data");
         }else{
           DlgBackupRemarkDescList dlg=new DlgBackupRemarkDescList(util.PublicVariable.APP_FRAME,
               "BACKUP HISTORY",true,vctBackup,this);
           dlg.setSize(300,265);
           exgui.UIHelper.setToScreenCenter(dlg);
           dlg.show();
         }
       }catch(Exception exp){
         exp.printStackTrace();
         util.ExceptionLog.exp2File(exp,"");
         exgui.verification.VerifyLib.showAlert("Error While Retrieving Backup Data\nPlease Contact System Manager",
                                                "Error While Retrieving Backup Data");
       }

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
    //backup to database,if user regreted.
    backupRemarkDesc(null);
    //after backup,process update process.....
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
  public void doAddNew() throws Exception{
  }
  public void doDelete() throws Exception{
  }
  public void doCopy(){
  }
  public void doPaste(){
  }
  public void doPrint()throws Exception{
  }
  public void doExit()throws Exception{
    processhandler.template.Properties.getCenteralControler().goBack();
  }
  protected void btnGetDefalutValue_actionPerformed(ActionEvent e) {
    /*backup before updated GUI*/
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      HashMap hmBackup=new HashMap();
      hmBackup.put("PROD_UP_REMARK",prodHeadScRemark.txtProdHeadRMK.getText());
      hmBackup.put("PROD_END_REMARK",prodEndScRemark.txtProdHeadRMK.getText());
      hmBackup.put("PROD_FINAL_REMARK",prodTotalEndPageRemark.txtProdHeadRMK.getText());
      java.util.Vector vctStyleUpRemark=new Vector();
      Vector vctStyleDownRemark=new Vector();
      for(int i=0;i<styleUpAndDownRemarkGUIS.length;i++){
        vctStyleUpRemark.add(styleUpAndDownRemarkGUIS[i].txtStyUpRMK.getText());
        vctStyleDownRemark.add(styleUpAndDownRemarkGUIS[i].txtStyDownRMK.getText());
      }
      hmBackup.put("VCT_STYLE_UP_REMARK",vctStyleUpRemark);
      hmBackup.put("VCT_STYLE_DOWN_REMARK",vctStyleDownRemark);
      try{
        backupRemarkDesc(hmBackup);
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("BACKUP FAILED!!\nPlease Contact System Manager","Backup Failed");
        return;
      }
    }

    Component obj[]=this.getComponents();
    boolean isDocPrice=false;
    if(!(util.PublicVariable.OPERATTING_CENTER.equals("001")||
         util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||
         newtimes.preproduction.Constants.isNthkModeNow())){
      isDocPrice = getDocActPrxType();
    }
    try{
      util.MiscFunc.showProcessingMessage();
      for (int i = 0; i < obj.length; i++) {
        if (obj[i] instanceof Intf_SC_CT_Edit) {
          if(obj[i] instanceof JCompPnlStylRemark_X_Center){
            ((JCompPnlStylRemark_X_Center)obj[i]).setIsDocPrice(isDocPrice);
          }
          ((Intf_SC_CT_Edit)obj[i]).doSet2Default();
        }
      }
      util.MiscFunc.hideProcessingMessage();
    }catch(Exception exp){
      util.ExceptionLog.exp2File(exp,"");
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While Generating S/C Desction",
                                             "Error While Generating S/C Desction");
    }
  }


       class CustomMessage extends JPanel {
         JRadioButton btnDocPrx=new JRadioButton("DOC  PRICE",true);
         JRadioButton btnActPrx=new JRadioButton("ACT  PRICE");
          public CustomMessage() {
              super( new BorderLayout(0, 5) );
              add( new JLabel("Please Select Price Type"), BorderLayout.NORTH );
              JPanel subPanel = new JPanel();
              ButtonGroup group = new ButtonGroup();
              //subPanel.add( new JLabel("Your icon goes here") );
              group.add(btnDocPrx);
              subPanel.add( btnDocPrx );
              group.add(btnActPrx);
              subPanel.add( btnActPrx );
              add( subPanel, BorderLayout.CENTER );
          }

      }


  protected boolean getDocActPrxType(){
   CustomMessage myPrxDlg= new CustomMessage();
    JOptionPane.showOptionDialog(
        util.PublicVariable.APP_FRAME,
        myPrxDlg,
        "Please Select Price Type",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        new String[] {"OK"},"OK");

     if(myPrxDlg.btnActPrx.isSelected())return false;
     return true;
  }

  protected void btnClearAll_actionPerformed(ActionEvent e) {
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      HashMap hmBackup=new HashMap();
      hmBackup.put("PROD_UP_REMARK",prodHeadScRemark.txtProdHeadRMK.getText());
      hmBackup.put("PROD_END_REMARK",prodEndScRemark.txtProdHeadRMK.getText());
      hmBackup.put("PROD_FINAL_REMARK",prodTotalEndPageRemark.txtProdHeadRMK.getText());
      java.util.Vector vctStyleUpRemark=new Vector();
      Vector vctStyleDownRemark=new Vector();
      for(int i=0;i<styleUpAndDownRemarkGUIS.length;i++){
        vctStyleUpRemark.add(styleUpAndDownRemarkGUIS[i].txtStyUpRMK.getText());
        vctStyleDownRemark.add(styleUpAndDownRemarkGUIS[i].txtStyDownRMK.getText());
      }
      hmBackup.put("VCT_STYLE_UP_REMARK",vctStyleUpRemark);
      hmBackup.put("VCT_STYLE_DOWN_REMARK",vctStyleDownRemark);
      try{
        backupRemarkDesc(hmBackup);
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        exgui.verification.VerifyLib.showAlert("BACKUP FAILED!!\nPlease Contact System Manager","Backup Failed");
        return;
      }
    }

    Component obj[]=this.getComponents();
    try{
      for (int i = 0; i < obj.length; i++) {
        if (obj[i] instanceof Intf_SC_CT_Edit) {
          ((Intf_SC_CT_Edit)obj[i]).doSetClear();
        }
      }
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  protected void btnCopyProdEndRmkFromOtherProd_actionPerformed(ActionEvent e) {
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
      Vector vct=null;
      if(!(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||util.PublicVariable.OPERATTING_CENTER.equals("001"))
          && result.toUpperCase().trim().length()==7){
         vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             "select PROD_SC_END_RMRK from production where prod_sc_no='" +
             centerPrefix +
             util.MiscFunc.Replace(result.toUpperCase().trim(), "'", "''") +
             "'" +
             " and record_delete_flag='1'",
             1, 1
             );

      }else{
        vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select PROD_SC_END_RMRK from production where prod_sc_no='"+
         util.MiscFunc.Replace(result.toUpperCase().trim(),"'","''")+"' "+
         " and record_delete_flag='1'",
         1,1
        );
      }
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
  protected void btnCopyFromSC_actionPerformed(ActionEvent e) {
    Component obj[]=this.getComponents();
    boolean isDocPrice=false;
    if(!(util.PublicVariable.OPERATTING_CENTER.equals("001")||
         util.PublicVariable.OPERATTING_CENTER.equals("NTHK")||
         newtimes.preproduction.Constants.isNthkModeNow()
         )){
      isDocPrice = getDocActPrxType();
    }

    try{
      util.MiscFunc.showProcessingMessage();
      for (int i = 0; i < obj.length; i++) {
        if (obj[i] instanceof Intf_SC_CT_Edit) {
          if(obj[i] instanceof JCompPnlStylRemark_X_Center) ((JCompPnlStylRemark_X_Center)obj[i]).setIsDocPrice(isDocPrice);
          ((Intf_SC_CT_Edit)obj[i]).doCopyFormSc();
        }
      }
      util.MiscFunc.hideProcessingMessage();

    }catch(Exception exp){
      util.ExceptionLog.exp2File(exp,"");
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While Generating C/T Desction",
                                             "Error While Generating C/T Desction");
    }
  }
}
