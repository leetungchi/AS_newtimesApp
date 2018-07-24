package newtimes.production.gui.prodmaintain;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlStyleDlvDateModify extends PnlStyDlvDateList{
  boolean isAshWorthBuyer=false;
  public PnlStyleDlvDateModify() {
    super();
    try{
      String buyerId = newtimes.preproduction.Constants.
          CURRENT_PREPROD_HEAD_RECORD.get("PROD_BUYER").toString();
      isAshWorthBuyer = buyerId.equals("82");
    }catch(Exception exp){
      exp.printStackTrace();
    }
   }
  public void refineEditors(exgui.ultratable.MultiEditorJTable tbmMET){
    super.refineEditors(tbmMET);
    if(!newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
      ((exgui.MultiClassTableModel)getJtable().getModel()).setCellEditablePolicy(new EditPolicy());
    }
  }
  protected boolean updateModifiedRecord()throws Exception {
        if(!isAshWorthBuyer){
          return super.updateModifiedRecord();
        }
        if(!super.getMultiEditorJTable().isTableOk()) return false;
          if(_records2Update==null) return true;
          //if(_records2Update.size()==0){
            _records2Update=kvtModifiedField2Records(
                super.getMultiEditorJTable().getModifiedRowAndColumn()
            );
          //}
          /*
           remarked at 20030508,trigger the PagedDataFactory while update comand is invoked.
          //if(_records2Update.size()==0) return true;
          */
         //String strArr[]=new String[]{"STY_ORIG_WAY","STY_MKR_DEL"};
         String strArr[]=new String[]{"STY_MKR_DEL"};
          ((newtimes.production.process.prodmaintain.DB_StyleMisc)dbHandler).updateRecordsForLog(_records2Update,strArr);
        _records2Update.removeAllElements();
       //exgui.verification.VerifyLib.showPlanMsg("Update OK","Update Ok");
       return true;
  }
  class EditPolicy implements  exgui.CellEditablePolicy{
     public boolean isCellEditable(int row,int col){
       return (col==6);
     }
  }
}
