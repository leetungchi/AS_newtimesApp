package newtimes.production.gui.order_change;
import exgui.ultratable.*;
import newtimes.production.gui.prodmaintain.PnlStyleColorQtyList;
import newtimes.production.process.order_change.ProxyQtyHdl;
import java.util.Vector;
import java.awt.Cursor;
public class PnlQtyList extends PnlStyleColorQtyList {
    public  javax.swing.JButton btnConfirmModify=
      new javax.swing.JButton("Next-->Edit S/C Up/Down Remark");
    boolean _abl2Edit;
  public PnlQtyList(boolean enabl2edit) {
    super();
    _abl2Edit=enabl2edit;
    super.btnRedefineSize.setVisible(false);
    super.getLowerRightPanel().remove(btnRedefineSize);
    super.getLowerRightPanel().add(btnConfirmModify,null);
    btnConfirmModify.addMouseListener(
        new ModifyMouseListener());
  }
 protected void goPage(int bgn,int rowcount,boolean bool){
  ((ProxyQtyHdl)dbHandler).isUsingProxy=_abl2Edit;
   super.goPage(bgn,rowcount,bool);
 }
 protected class ModifyMouseListener extends java.awt.event.MouseAdapter {
    public void mouseClicked(java.awt.event.MouseEvent e){
      //modify OK.
      try{
         doUpdate();
         /*
          udpate depends on
         1. newtimes.production.process.order_change.tempDataCenter.STORED_CHG_PRX_RECORDS
         2.newtimes.production.process.order_change.tempDataCenter.STORED_CHG_PRX_RECORDS
         3 .newtimes.production.ProdMaintain_Properties.table2Text(OrgTable) and
           newtimes.production.ProdMaintain_Properties.table2Text(newTable)
         */

      }catch(Exception exp){
        exp.printStackTrace();
      }
    }
  }
  protected void refineEditors(MultiEditorJTable multiEditorJTableInSuper) {
    ((ProxyQtyHdl)dbHandler).isUsingProxy=_abl2Edit;
    //priceVct=((ProxyQtyHdl)dbHandler).getPriceRecords();
    super.refineEditors(multiEditorJTableInSuper);
    if(!_abl2Edit){
      ((exgui.MultiClassTableModel)multiEditorJTableInSuper.getJTable().getModel()).removeAllEditableColumn();
    }
  }

  protected PagedDataFactory getPagedDataFactory() {
    dbHandler=new ProxyQtyHdl();
    return dbHandler;
  }
  public void doUpdate() throws Exception{
    try{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     util.MiscFunc.showProcessingMessage();
     this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
       Vector vct = getData2Update();
       if (vct.size() == 0)
         return; //no data to update,mabe cell is wrong..

       String orgQtyTblText=
           newtimes.production.process.order_change.tempDataCenter.orgQtyTable2Text;
       String newQtyTblText=null;
       if(priceColumnAt==0){
          newQtyTblText=newtimes.production.ProdMaintain_Properties.table2Text(
          getJtable());
        /*
         defaultStyleDownDescription=
             newtimes.production.ProdMaintain_Properties.table2Text(getJtable());
         */
       }else{
          newQtyTblText=
            newtimes.production.ProdMaintain_Properties.stylQtyTable2Text(
            getJtable(),priceColumnAt);
        /*
         defaultStyleDownDescription=
             newtimes.production.ProdMaintain_Properties.stylQtyTable2Text(getJtable(),priceColumnAt);
         */
        }
       if(orgQtyTblText.equals(newQtyTblText)){
         ((ProxyQtyHdl)dbHandler).updateRecords(new Vector(),newQtyTblText);
       }else{
         ((ProxyQtyHdl)dbHandler).updateRecords(vct,newQtyTblText);
       }
        //exgui.verification.VerifyLib.showPlanMsg("Update OK", "Update OK");
        processhandler.template.Properties.getCenteralControler().doCommandExecute(
        new newtimes.production.process.order_change.TgrToEditScRemark());
    }catch(Exception e){
      e.printStackTrace();
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showAlert(
          "Update Fail,Please Contact System Manager",
          "Update Fail");
      throw e;
    }finally{
      this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      util.MiscFunc.hideProcessingMessage();
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
