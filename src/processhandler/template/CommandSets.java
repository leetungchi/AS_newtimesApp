package processhandler.template;
import processhandler.*;
import processhandler.commands.*;
import database.*;
import database.datatype.*;
import database.encoders.*;
import java.util.Vector;
import exgui.ultratable.*;
import javax.swing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CommandSets implements
  AbleToAddMaster,AbleToEditDetail,
  AbleToEditMaster ,AbleToGenQryGUI,AbleToListQryResult,
  Able2ShowDtl4QryRecord
  {
  PagedListTable4Qry pgQryList=null;
  protected PagedDataFactory  pgdbMst=null;
  protected PnlFieldsEditor pnlMasterEditer=null;
  public String keywordFromQryGUI="";
  //this array is generated according to master/detail relationship of editing record.
  //because we need to casting it to  "processhandler.DataProcesser ",deculare them to Object
  protected JPanel detailTabPanels[]=null;
  protected Vector  vctTabNames=null;
  /**
   * this function should be always overwrite,because the instance of
   * pnlMasterEditer and detail panes are not alwayst the same.
   */
  public CommandSets() {
    pgdbMst=generatePagedDataFactory4MasterData();//for listing bill master by query conditions.
    pnlMasterEditer=generateMasterEditor();
    vctTabNames=generateTabbVector();
  }
  protected PagedDataFactory generatePagedDataFactory4MasterData(){
    return new DB_BillMaster();
  }
  protected Vector generateTabbVector(){
    Vector vctTabNames=new Vector();
    vctTabNames.add("BILL DETAIL : ITEM");
    vctTabNames.add("BILL DETAIL : MEMO");
    return vctTabNames;
  }
  protected PnlFieldsEditor generateMasterEditor(){
    return new PnlEditBillMaster(null,null);
  }
  protected  void generateDetailGUIS(){
    java.util.ArrayList arlist=new java.util.ArrayList();
    arlist.add(
     new pnlEditBillItems()
    );
    arlist.add(
      new PnlEditBillMemo(new DB_BillMEMO())
    );
    detailTabPanels= (JPanel[])arlist.toArray(new JPanel[0]);
  }
  /**
   * seems you don't need to overwrite this function.
   * unless your panel for editing master data are quite different.
   * but please make sure your pnlMasterEditer is prepared (ex:PagedDataFactory Object had set into)
   * @throws CommandException
   */
  public void toAddMaster() throws CommandException{
    try{
      exgui2.SplitFrame spf = Properties.getSplitFrame();
      Properties.getMainFrame().getContentPane().removeAll();
      if(spf==null){
        spf=new exgui2.SplitFrame();
        Properties.spFrame=spf;
      }
      Properties.getMainFrame().getContentPane().add(spf);
      spf.butnCopy.setEnabled(true);
      spf.butnPaste.setEnabled(true);
      spf.butnDelete.setEnabled(false);
      spf.butnNew.setEnabled(true);
      spf.butnEdit.setEnabled(false);
      spf.butnPrint.setEnabled(true);

      spf.enableStateChangeFlag=false;
      spf.jTabbedPane1.removeAll();
      spf.tabUnderPanel.removeAll();
      spf.enableStateChangeFlag = true;

      pnlMasterEditer.recToMapping =pgdbMst.getBlankRecord();
      if(pnlMasterEditer.dbprc==null){
        pnlMasterEditer.setPagedDataFactory(pgdbMst);
      }
      pnlMasterEditer.jbInit() ;//restore the color
      pnlMasterEditer.setToOrgColor();
      pnlMasterEditer.record2Gui();
      pnlMasterEditer.setSize(pnlMasterEditer.getPreferredSize());
      spf.setUpperPanel(pnlMasterEditer);
      Properties.getCenteralControler().setDataProcesser(pnlMasterEditer);
      Properties.getMainFrame().show();
      Properties.getMainFrame().repaint();
      pnlMasterEditer.repaint();
    }catch(Exception e){
      e.printStackTrace();
      throw new CommandException("exp while entering GUI of edition master data.");
    }
  }
  /**
   * this method should not have to overwrite.seems just operation of array.
   * @throws CommandException
   */
  public void toEditDetail()throws CommandException{
     JPanel tabBgCpx=(JPanel)Properties.getCenteralControler().getSelectedTabComponent();
     JPanel pnl=detailTabPanels[Properties.getCenteralControler().getSelectedTabIndex()];
     //if this tabbed pane is blank(with out drawing),we need to set content pan of detail to it.
     pnl.setSize(pnl.getPreferredSize());
     Properties.getSplitFrame().jTabbedPane1.setComponentAt(
      Properties.getCenteralControler().getSelectedTabIndex(),
      pnl
     );
     Properties.getSplitFrame().jTabbedPane1.repaint();
     Properties.getCenteralControler().setDataProcesser((DataProcesser)pnl);
  }
  /**
   * this function should not have to be orwriten,<br>
   * unless you have  different process of generating GUI of edit master data
   * @throws CommandException
   */
  public void toEditMaster()throws CommandException{
    try{
      exgui2.SplitFrame spf = Properties.getSplitFrame();
      spf.butnCopy.setEnabled(true);
      spf.butnPaste.setEnabled(true);
      spf.butnDelete.setEnabled(true);
      spf.butnNew.setEnabled(false);
      spf.butnEdit.setEnabled(true);
      spf.butnPrint.setEnabled(true);
      //clear all the tabbed panel in the lower split frame
      spf.enableStateChangeFlag=false;
      spf.tabUnderPanel.removeAll();
      spf.enableStateChangeFlag=true;

      pnlMasterEditer.setRecord(
        Properties.getCenteralControler().getCurrentEditingMasterRecord()
      );
      if(pnlMasterEditer.dbprc==null){
        pnlMasterEditer.setPagedDataFactory(pgdbMst);
      }
      pnlMasterEditer.jbInit();
      pnlMasterEditer.setToOrgColor();
      pnlMasterEditer.setSize(pnlMasterEditer.getPreferredSize());
      spf.setUpperPanel(pnlMasterEditer);
      Properties.getMainFrame().show();
      Properties.getMainFrame().repaint();
      pnlMasterEditer.record2Gui();
      Properties.getCenteralControler().setDataProcesser(pnlMasterEditer);
    }catch(Exception e){
      e.printStackTrace();
      throw new CommandException("exp while entering GUI of edition master data.");
    }
  }
  /**
   * this function should be over write,because each unit has own qurey interface.
   * @throws CommandException
   */
  public void toGenQryGUI()throws CommandException{
    javax.swing.JFrame jframe=Properties.getMainFrame();
    jframe.getContentPane().removeAll();
    PnlQry pnl=new PnlQry();
    pnl.setSize(800,599);
    jframe.getContentPane().add(pnl);
    jframe.repaint();
  }
  /**
   * this function should be overwrite ,because the qurey conditions of master data are not aways the same
   * @throws CommandException
   */
  public void toListQryResult() throws CommandException{
     //prepare the required data for jtable..
     ((DB_BillMaster)pgdbMst).setKeyWord(keywordFromQryGUI);//keywordFromQryGUI is setten by Qurey interface GUI click submit event.
     exgui2.SplitFrame spframe=Properties.spFrame;
     if(Properties.spFrame==null){
       spframe=new exgui2.SplitFrame();
       Properties.spFrame=spframe;
     }
     util.InsertionOrderedHashMap isoh=new util.InsertionOrderedHashMap();
     //mapping field and columname to reocrd field name--
     isoh.put("buyer name","TXN_USER");
     isoh.put("transaction time","TXN_DATE");
     isoh.put("paid or not","paid");
     java.util.Hashtable ht=new java.util.Hashtable();
     ht.put("paid or not",new ob2str());
     PnlListQryRslt pnl=new PnlListQryRslt(pgdbMst,2,isoh,ht);
     //pnl.setSize(300,200);
     pnl.setSize(pnl.getPreferredSize());
     spframe.setUpperPanel(pnl);
     Properties.getMainFrame().getContentPane().removeAll();
     Properties.getMainFrame().getContentPane().add(spframe);
     pnl.repaint();
     Properties.getMainFrame().show();
     Properties.getMainFrame().repaint();
  }
  /**
   * this function is not have to be overwrite.
   * @throws Exception may cause while generating the target panel of detail data
   */
  public void toShowDtl4QryRecord()throws Exception{
     //turn on all the function buttons.
     Properties.getSplitFrame().butnCopy.setEnabled(true);
     Properties.getSplitFrame().butnDelete.setEnabled(true);
     Properties.getSplitFrame().butnEdit.setEnabled(true);
     Properties.getSplitFrame().butnExit.setEnabled(true);
     Properties.getSplitFrame().butnNew.setEnabled(true);
     Properties.getSplitFrame().butnPaste.setEnabled(true);
     Properties.getSplitFrame().butnPrint.setEnabled(true);
     //remove all the panels of tabbed pane of current split frame
     //switch to 1st tab panel.

     if(Properties.getSplitFrame().jTabbedPane1.getTabCount()>1){
       Properties.getSplitFrame().jTabbedPane1.setSelectedIndex(0);
     }

     Properties.getSplitFrame().enableStateChangeFlag=false;
     //Properties.getSplitFrame().tabUnderPanel.removeAll();
     //JTabbedPane jtb1=new JTabbedPane();
     //Properties.getSplitFrame().tabUnderPanel.add(jtb1);
     Properties.getSplitFrame().jTabbedPane1.removeAll();
     JPanel tmpJPanel=new JPanel();
     tmpJPanel.setSize(700,200);
     Properties.getSplitFrame().setTab(
       this.vctTabNames
      ,tmpJPanel
     );
     Properties.getSplitFrame().jTabbedPane1.setSelectedIndex(0);
     Properties.getSplitFrame().jTabbedPane1.setSize(800,599);
     Properties.getSplitFrame().jTabbedPane1.setVisible(true);
     generateDetailGUIS();//re-genterate the panels of each tab according to current master record
     toEditDetail();
     Properties.getSplitFrame().enableStateChangeFlag=true;
  }

  class ob2str implements exgui.Object2String {
    public String Obj2String(Object obj){
      if(((java.math.BigDecimal)obj).intValue()==0){
        return "not paid";
      }else return "paid";
    }
  }

}
