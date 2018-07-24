package newtimes.production.process.prodmaintain;

public class ToCheck4FabricProc extends ToCheckB4StyleProc {
  public ToCheck4FabricProc() {
  }
  public  static void addLowerPanel(String title,javax.swing.JPanel pnl){
    String myTitle=title;
      if (title.indexOf("<br>") != -1) {
        myTitle = "<html><body>" + title + "</body></html>";
      }
    newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL.panelToPlaceEditors().removeAll();
    newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL.panelToPlaceEditors().add(
        new javax.swing.JLabel(myTitle),java.awt.BorderLayout.NORTH);
    newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL.panelToPlaceEditors().add(
         pnl,java.awt.BorderLayout.CENTER);
    newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL.setPreferredSize(new java.awt.Dimension(750,300));
    processhandler.template.Properties.getSplitFrame().setLowerPanel(
               newtimes.production.ProdMaintain_Properties.FABRIC_TGR_PANEL
             );

  }
  public boolean isFabricRecordSelected(){
    if(newtimes.production.ProdMaintain_Properties.CURRENT_SELECTED_FABRIC_PO_SEQ_IN_FABRIC_PO_LIST ==-1){
      exgui.verification.VerifyLib.showPlanMsg("Please Select A Record to Edit",
                                               "Please Select A Record");
      return false;
    }else{
      return true;
    }
  }

}
