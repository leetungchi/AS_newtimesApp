package newtimes.production.process.prodmaintain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToCheckB4StyleProc {
  public ToCheckB4StyleProc() {
  }
  public static void setFunctionButtonStatus(
      boolean nblBtnAddNew,
      boolean nblBtnCnfEdit,
      boolean nblBtnCopy,
      boolean nblBtnPast,
      boolean nblBtnDelete,
      boolean nblBtnPrint ,boolean needBtnToProdQryMenue){
    processhandler.template.Properties.getSplitFrame().pnl4ExtraButton.removeAll();
    processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(nblBtnCopy);
    processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(nblBtnAddNew);
    processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(nblBtnPast);
    processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(nblBtnDelete);
    processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(nblBtnCnfEdit);
    processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(nblBtnPrint);
    String frameTitle=   processhandler.template.Properties.getMainFrame().getTitle();
    if(needBtnToProdQryMenue){
      if (frameTitle.toUpperCase().indexOf("RESTORE") != -1) {
        processhandler.template.Properties.getSplitFrame().
            addExtraTriggerButton("To Main Menu",
                                  new newtimes.preproduction.process.
                                  TgrToGenQryGui4Restore());
      } else {
        processhandler.template.Properties.getSplitFrame().
            addExtraTriggerButton("To Main Menu",
                                  new newtimes.preproduction.process.
                                  TgrToGenQryPreProdGUI());
      }
    }
   //jframe.setTitle("PRODUCTION MAINTAIN");


    try{
      int user_type=util.PublicVariable.USER_RECORD.getInt(2);//"USR_TYPE");
      switch(user_type){
        case newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS:
        case newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS:
        case newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS:
          processhandler.template.Properties.getSplitFrame().butnCopy.setEnabled(false);
          processhandler.template.Properties.getSplitFrame().butnNew.setEnabled(false);
          processhandler.template.Properties.getSplitFrame().butnPaste.setEnabled(false);
          processhandler.template.Properties.getSplitFrame().butnDelete.setEnabled(false);
          processhandler.template.Properties.getSplitFrame().butnEdit.setEnabled(false);
          processhandler.template.Properties.getSplitFrame().butnPrint.setEnabled(false);
      }
    }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
    }
    processhandler.template.Properties.getSplitFrame().pnl4ExtraButton.validate();
    processhandler.template.Properties.getSplitFrame().pnl4ExtraButton.repaint();
  }
  public static void setFunctionButtonStatus(
      boolean nblBtnAddNew,
      boolean nblBtnCnfEdit,
      boolean nblBtnCopy,
      boolean nblBtnPast,
      boolean nblBtnDelete,
      boolean nblBtnPrint){
    //adjust the function for some special users
    //if user type is accounting,shipping,others,only allow to query and dispy,not able to edit/add new
    setFunctionButtonStatus(nblBtnAddNew,nblBtnCnfEdit,nblBtnCopy,
                            nblBtnPast,nblBtnDelete,nblBtnPrint,true);

  }
  public static void addLowerPanel(String title,javax.swing.JPanel pnl){
    String myTitle=title;
      if (title.indexOf("<br>") != -1) {
        myTitle = "<html><body>" + title + "</body></html>";
      }
    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().removeAll();
    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().add(
        new javax.swing.JLabel(myTitle),java.awt.BorderLayout.NORTH);
    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.panelToPlaceEditors().add(
         pnl,java.awt.BorderLayout.CENTER);
    newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL.setPreferredSize(new java.awt.Dimension(750,300));
    processhandler.template.Properties.getSplitFrame().setLowerPanel(
               newtimes.production.ProdMaintain_Properties.STYLE_TGR_PANEL
             );

  }
  public static boolean isStyleRecordSelected(){
    if(newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_STYLE_SEQ_IN_STYLE_LIST==-1){
      exgui.verification.VerifyLib.showPlanMsg("Please Select A Style Record to Edit",
                                               "Please Select A Record");
      return false;
    }else{
      return true;
    }
  }

}
