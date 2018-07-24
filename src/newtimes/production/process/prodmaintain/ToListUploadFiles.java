package newtimes.production.process.prodmaintain;
import newtimes.production.gui.prodmaintain.*;
public class ToListUploadFiles
    extends ToCheckB4StyleProc
    implements AbleToListUploadFiles{
  static util.InsertionOrderedHashMap headColumns;
  static java.util.Hashtable columCnv;
  public ToListUploadFiles() {
    if(columCnv==null){
      columCnv=new java.util.Hashtable();
      columCnv.put("Last\nUpdate",exgui.verification.CellFormat.getDateStringFormater());
    }
  }
  public void toListUploadFiles()throws Exception{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      DB_StyUpload handler = new DB_StyUpload();
      if (!isStyleRecordSelected()) {
        throw new processhandler.commands.CommandIncompleteException();
      }
      if (!handler.isInitOK()) {
        throw new processhandler.commands.CommandIncompleteException();
      }

      headColumns=
          new util.InsertionOrderedHashMap();
      headColumns.put("File","sty_file_name");
      headColumns.put("            File Memo                ","sty_file_RMK");
      headColumns.put("Last\nUpdate","record_create_date");
      PnlListStyleFiles pnl =
          new PnlListStyleFiles(handler,
                                9999,
                                headColumns,
                                columCnv,
                                "Click To Edit File", "  .  .  .");

      StringBuffer sb = new StringBuffer();
      sb.append("STYLE:");
      Object styObj =
          newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(
          2);
      sb.append((styObj == null) ? "" : styObj.toString());
      Object poObj =
          newtimes.production.ProdMaintain_Properties.EDITING_STYLE_RECORD.get(
          3);
      sb.append("  P.O:");
      sb.append((poObj == null) ? "" : poObj.toString());
      addLowerPanel(sb.toString(), pnl);
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        setFunctionButtonStatus(true,false,false,false,true,false);
      }else{
        setFunctionButtonStatus(false,false,false,false,false,false);
      }
      /*
      if(newtimes.production.ProdMaintain_Properties.
         isProductionAuditConfirmedOrPrinted()){
         if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")!=
            newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS
            && util.PublicVariable.OPERATTING_CENTER.equals("001")){
            setFunctionButtonStatus(false,false,false,false,false,false);
         }else{
            setFunctionButtonStatus(true,false,false,false,true,false);//allow mis user to modify record
         }
      }else{
          setFunctionButtonStatus(true,false,false,false,true,false);
      }*/

      //setFunctionButtonStatus(true, false, false, false, true, false);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      pnl.doActivate();
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }
  }
}
