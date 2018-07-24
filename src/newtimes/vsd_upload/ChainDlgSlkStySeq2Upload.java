package newtimes.vsd_upload;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import exgui.chaindialog.*;
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

public class ChainDlgSlkStySeq2Upload extends JPanel
  implements exgui.chaindialog.Responsible{
   exgui.chaindialog.Responsible nextResonsibale;
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  Pnl2List2Chk pnl2list =null;
  java.util.HashMap hmChkSeq=null;

  public ChainDlgSlkStySeq2Upload() {
    try {
      hmChkSeq=new java.util.HashMap();
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    blueBkgWhiteCharLabel1.setText("Please Check PO-detail To upload");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(-2, 7, 716, 33));
    this.setLayout(null);
    util.InsertionOrderedHashMap iso=new util.InsertionOrderedHashMap();
    iso.put("X","CHK");
    iso.put("    S/C#    ","SC_NO");
    iso.put("   CPO   ","VSD_PROD_PO");
    iso.put("         STYLE        ","vsd_sty_style");
    iso.put("          PO#         ","vsd_sty_po");
    //iso.put("sty_seq","sty_seq");
    pnl2list=new Pnl2List2Chk(new DbListStyle(),15,iso,new java.util.Hashtable());
    pnl2list.setBounds(new Rectangle(15, 53, 670, 313));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(pnl2list, null);
    pnl2list.firstPage();
  }
  public JComponent getGUI(){
    return this;
  }
  public void setDefalutNext(Responsible dfltRsp){
    nextResonsibale=dfltRsp;
  }
  public Responsible next()throws NextResponsibleIsNotReady{
    //call server to upload...

    try{
      for(int i=0;i<pnl2list.getDisplayingRecords().size();i++){
        Record rec=(Record)pnl2list.getDisplayingRecords().get(i);
        Record recx=pnl2list.setObject2Record(rec,0,pnl2list.getJtable().getValueAt(i,0));
      }
      //pnl2list.doUpdate();
    }catch(Exception exp){
      exp.printStackTrace();
    }
    if(hmChkSeq.isEmpty()){
      exgui.verification.VerifyLib.showAlert("Please Check Row(s) To upload VSD Data",
                                             "Please Check Row(s) To upload");
      throw new NextResponsibleIsNotReady();
    }
    storedMap.put("SEQ_VSD",hmChkSeq);
    /*
    java.util.Iterator itr=hmChkSeq.keySet().iterator();
    while(itr.hasNext()){
      System.out.println("check sty seq is :"+(String)itr.next());
    }
    */
    try{
      util.MiscFunc.showProcessingMessage();
      NTD_Upload.VsdUploadHome ejbHome =
          (NTD_Upload.VsdUploadHome)
          info_ejb.WeblogicServiceLocator.locateServiceHome(util.PublicVariable.
          SERVER_URL, "NTD_Upload.VsdUpload");
      NTD_Upload.VsdUpload ejbUpload=ejbHome.create();
      ejbUpload.uploadVsdAfterCompare(hmChkSeq,(String)storedMap.get("PROCNO"),(String)util.PublicVariable.USER_RECORD.get(0));
      exgui.verification.VerifyLib.showPlanMsg("Upload OK","Upload OK");
      return null;
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Upload Failed!!\nPlease Contact System Manager",
                                             "Upload VSD Failed");
      throw new NextResponsibleIsNotReady();
    }
  }
  public boolean isAllowOkNow(){
    return true;
  }
  class Pnl2List2Chk extends  processhandler.template.PnlTableEditor{
    public Pnl2List2Chk(exgui.ultratable.PagedDataFactory pagedDataFxy,
                      int rowCounts,util.InsertionOrderedHashMap columnMapping,
                     java.util.Hashtable object2StringConvertor){
        super(pagedDataFxy, rowCounts, columnMapping, object2StringConvertor);
    }
    public void doPrint(){}
    public int getEachPageRowCount(){return _rowCounts;}
    public Hashtable getObject2StringConvertor() {return klmObjKvtHt;}
    public util.InsertionOrderedHashMap getHeadColumnMap(){return tblHeadColumn;}
    public exgui.ultratable.PagedDataFactory getPagedDataFactory(){return dbHandler;}
    //public Record setObject2Record(Record rec,int col,Object obj){return null;}
    public void makeTable(Vector vct){
      super.makeTable(vct);
      //adject column size;
      getJtable().getColumnModel().getColumn(0).setPreferredWidth(5);
    }

    public Record setObject2Record(Record rec,int col,Object obj){
      try{
        if (col == 0) {
          Boolean blValue = (Boolean)obj;
          String seq = rec.get("sty_seq").toString();
          if (blValue.booleanValue()) {
            hmChkSeq.put(seq, "1");
          } else {
            hmChkSeq.remove(seq);
          }
        }
        return null;
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
        return null;
      }
    }
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeAllEditableColumn();
      me.addCheckbox(0,"1");
    }

    /*
    public void refineEditors(exgui.ultratable.MultiEditorJTable me ){
      ((exgui.MultiClassTableModel)me.getJTable().getModel()).removeAllEditableColumn();
      getJtable().getColumnModel().getColumn(6).setCellRenderer(new CellRenderAmt());
    }*/
  }


  class DbListStyle extends exgui.ultratable.PagedDataFactoryAdapter{
    public Vector getRecords(int bgn,int rowCount)throws Exception{
      StringBuffer sb=new StringBuffer();
      sb.append("select * from \n");
      sb.append("(select \n");
      sb.append("a.VSDUPLD_TIME \n");
      sb.append(",A.STY_SEQ \n");
      sb.append(",(select style.sty_sc_no from style where style.sty_seq=a.sty_seq) as sc_no \n");
      sb.append(",A.VSD_PROD_PO \n");
      sb.append(",A.VSD_STY_STYLE \n");
      sb.append(",A.VSD_STY_PO  \n");
      sb.append("from \n");
      sb.append("vsd_upload a\n");
      sb.append("where A.VSDUPLD_TIME='");sb.append(util.MiscFunc.Replace((String)storedMap.get("PROCNO"),"'","''"));sb.append("' and a.record_delete_flag='1' \n");
      sb.append(" and (select count(*) from ship_style where ship_style.sty_seq=a.sty_seq)=0 )");
      //sb.append(" and a.record_delete_flag='1' \n");//if no difference,the delete flag were set to 0
      sb.append("group by VSDUPLD_TIME,sty_seq,sc_no,vsd_prod_po,vsd_sty_style,vsd_sty_po \n");

      Vector vct= exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,
      sb.toString(),bgn,rowCount);
      Vector vct2Rec=new Vector();
      for(int i=0;i<vct.size();i++){
        Record rec=(Record)vct.get(i);
        Object stySeq=rec.get("sty_seq").toString();
        rec.getFieldName().add("CHK");
        if(hmChkSeq.containsKey(stySeq)){
          rec.getValueFields().add("1");
        }else{
          rec.getValueFields().add("0");
        }
        vct2Rec.add(rec);
      }
      return vct2Rec;
    }
  }
}
