package processhandler.template;
import java.awt.*;
import javax.swing.JPanel;
import database.datatype.Record;
import exgui.ultratable.PagedDataFactory;
/**
 * <p>Title:Panel To Edit/Add Master Data/or Without Aultratable list datail data </p>
 * <p>Description: Panel To Edit/Add Master Data/or Without Aultratable list datail data</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: metak.com.tw</p>
 * @author crazy john.
 * @version 1.0
 */

public abstract class PnlFieldsEditor extends DetailDataGUI {
  BorderLayout borderLayout1 = new BorderLayout();
  protected PagedDataFactory dbprc=null;
  protected String id4ApplicationProperties=null;
  protected boolean isGui2RecordOk=false;
  protected java.util.List dataBoundGUIs=new java.util.ArrayList();
  //the "recordColumnsToCopy" is for paste.
  //if paste invalid data from copied record to current record  and update,will cause  database chaos.
  protected String recordColumnsToCopy[]=null;
  /**
   * orgColorArr is for storing original bg color of compoments
   * because for "after add new master data" command,we need to grey the bg color of each component
   * so we have to store it for "entering add/edit master data" to paint with org color
   * orgColorArr is stored while calling "greyMe()" function.
   * and color to restore to component by "setToOrgColor()"
   */
  protected Color orgColorArr[]=null;
  protected Record recClonedForCheck;
  public PnlFieldsEditor() {
    super();
  }
  public void exitCurrentGui(){}

 protected String conv2String(Object obj){
    if(obj==null)return "";
    if(obj instanceof java.util.Date ){
      java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy/MM/dd");
      return df.format((java.util.Date)obj);
    }
    if(obj instanceof String)return (String)obj;
    if(obj.toString().trim().length()==0) return "";
    try{
     return  String.valueOf(Double.parseDouble(obj.toString()));
    }catch(Exception exp){
      return obj.toString();
    }
  }
  public boolean isContextModified(){
    if(!gui2Record())return true;
    //return(!recToMapping.toString().equals(recClonedForCheck.toString()));
    //list all modified column and test values
    java.util.List modColumns=recToMapping.getModifiedFields();
    try{
      for (int i = 0; i < modColumns.size(); i++) {

        int colIndex =((Integer)modColumns.get(i)).intValue();
        Object newObj=recToMapping.get(colIndex);
        Object oldObj=recClonedForCheck.get(colIndex);

        //if(newObj!=null && newObj instanceof java.lang.Double) newObj=new java.math.BigDecimal(newObj.toString());
        //if(oldObj!=null && oldObj instanceof java.lang.Double) oldObj=new java.math.BigDecimal(oldObj.toString());
        newObj=conv2String(newObj);oldObj=conv2String(oldObj);
        if (!util.MiscFunc.isEqual(newObj,oldObj)){
          System.out.println("column modified:"+(String)recToMapping.getFieldName().get(colIndex));
          System.out.println(" newObj:"+newObj+","+" orgObj:"+oldObj);
          return true;
        }
      }
      return false;

    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while compare for modification check");
      return false;
    }
  }

  /*
  public boolean isContextModified(){
    if(!gui2Record())return true;
    //return(!recToMapping.toString().equals(recClonedForCheck.toString()));
    //list all modified column and test values
    java.util.List modColumns=recToMapping.getModifiedFields();
    try{
      for (int i = 0; i < modColumns.size(); i++) {
        int colIndex =((Integer)modColumns.get(i)).intValue();
        Object newObj=recToMapping.get(colIndex);
        Object oldObj=recClonedForCheck.get(colIndex);
        if (!util.MiscFunc.isEqual(newObj,oldObj)){
          System.out.println("column modified:"+(String)recToMapping.getFieldName().get(colIndex));
          System.out.println(" newObj:"+newObj+","+" orgObj:"+oldObj);
          return true;
        }
      }
      return false;

    }catch(Exception e){
      e.printStackTrace();
      util.ExceptionLog.exp2File(e,"exp while compare for modification check");
      return false;
    }
  }*/
  /**
   * construactor of this class.
   * @param rec record to mapping,can be the main record of current table,or the master record of a detail table
   * @param toDb PagedDataFactory instance.in charge of update/addnew/delete functions
   */
  public PnlFieldsEditor(Record rec,PagedDataFactory toDb) {
    super(rec);
    try{
      recClonedForCheck = (Record)util.MiscFunc.deepCopy(recToMapping);
    }catch(Exception e){
      e.printStackTrace();
    }
    dbprc=toDb;
    id4ApplicationProperties=this.getClass().getName();
    /*
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
    */
  }
  abstract protected void jbInit()throws Exception;
  /**
   * sometime ,you are allow to assign record to mapping latter,
   * such as toAddMaster/toEditMaster function in class "CommandSets"
   * @param rec the record object to mapping to gui.
   */
  public void setRecord(Record rec){
     recToMapping=rec;
     try{
       recClonedForCheck = (Record)util.MiscFunc.deepCopy(rec);
     }catch(Exception e){
       e.printStackTrace();
     }
  }
  /**
   * sometime ,you are allow to assign record to mapping latter,
   * such as toAddMaster/toEditMaster function in class "CommandSets"
   * @param pgdb the pageddatafactory to execute database processing
   */
  public void setPagedDataFactory(PagedDataFactory pgdb){
    dbprc =pgdb;
  }

  /**
   * incharge of pagging record data fields to gui fields<br>
   * this function also be called by "past command"
   */
  abstract public void record2Gui();
  /**
   * incharge of mapping gui fields to record fields<br>
   * this function also be called by "copy command"
   * gui2Record should modify the flag "isGui2RecordOk",for update/addnew to identify
   */

  public boolean gui2Record(){
    //dataBoundGUIs is composed at the function "record2GUI"
    try{
      boolean isGuiUnitChanged=false;
      for (int i = 0; i < dataBoundGUIs.size(); i++) {
        exgui.DataBindGUIObject dbGUIOBJ=(exgui.DataBindGUIObject)dataBoundGUIs.get(i);
        //we just concern the single selection
        if (dbGUIOBJ instanceof exgui.SwingSingleSelection) {
          //if that's a text field with checker,we have to test for validation.
          if ((dbGUIOBJ instanceof exgui.DataBindTextWithChecker) && dbGUIOBJ.isChanged()) {
            exgui.DataBindTextWithChecker chkr = (exgui.DataBindTextWithChecker)dbGUIOBJ;
            if (!chkr.isValidx()){
              //System.out.println("invalid at :"+dbGUIOBJ.getOrgRecField());
              exgui.verification.VerifyLib.showAlert(
                  "Format error,Pleae check the column","Format invalid"
              );
              dbGUIOBJ.getGUIcomponent().grabFocus();
              return false;
            }
          }
          //only the changed fields have to be update.
          if(dbGUIOBJ instanceof exgui.DataBindJCombobox ){
            exgui.SwingSingleSelection sglSlt = (exgui.SwingSingleSelection)
                dbGUIOBJ;
            recToMapping.set(dbGUIOBJ.getOrgRecField(),
                             sglSlt.getSelectedValue());
          }
          if (dbGUIOBJ.isChanged()) {
            exgui.SwingSingleSelection sglSlt = (exgui.SwingSingleSelection)
                dbGUIOBJ;
            recToMapping.set(dbGUIOBJ.getOrgRecField(),
                             sglSlt.getSelectedValue());
          }
        }
      }
      return true;
    }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"exp while gui2record");
       return false;
    }

  }
  /**
   * update及addnew功能是一樣的.差別只是在ejb對了傳入的record的record_create_date的判別<br>
   * 如果record_create_date是null,那就是insert record,反之,則是update record.<br>
   * 執行了update之後,如果有問題,建議則保持原狀.以便觀查.
   * 要不要回上一頁?視當時的子類別的行為而定了.
   */
  public void doUpdate() throws Exception{
    isGui2RecordOk=gui2Record();
    Cursor ksr=null;
    if(!isGui2RecordOk) return;
      if(util.PublicVariable.APP_FRAME!=null){
       ksr=util.PublicVariable.APP_FRAME.getCursor();
       util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      }
      try{
        java.util.Vector vec = new java.util.Vector();
        vec.add(recToMapping);
        dbprc.updateRecords(vec);
        recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
      }catch(Exception e){
        //e.printStackTrace();
        throw e;
      }finally{
        if(ksr!=null){
         //setCursor(ksr);
          util.PublicVariable.APP_FRAME.setCursor(ksr);
        }
      }
  }
  /**
   * add new 之後,下半部要進入列出detail畫面,不過,一旦本型態也是某資料的detail時,就不須要了
   * @throws any exception to update a record.
   */
  public void doAddNew() throws Exception{
      isGui2RecordOk=gui2Record();
      Cursor ksr=null;
      if(!isGui2RecordOk) return;
      if(util.PublicVariable.APP_FRAME!=null){
       ksr=util.PublicVariable.APP_FRAME.getCursor();
       util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
      }
      try{
        java.util.Vector vec = new java.util.Vector();
        recToMapping.set("record_create_date", null);
        vec.add(recToMapping);
        dbprc.updateRecords(vec);
        recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
      }catch(Exception e){
         throw e;
      }finally{
        if(ksr!=null){
         //setCursor(ksr);
          util.PublicVariable.APP_FRAME.setCursor(ksr);
        }
      }
    //if this is a "master data,we can call "AbleToShowDetial" of current command object.
  }

  public void doDelete() {
    Cursor ksr=null;
    if(util.PublicVariable.APP_FRAME!=null){
     ksr=util.PublicVariable.APP_FRAME.getCursor();
     util.PublicVariable.APP_FRAME.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }
    try{
      dbprc.deleteRecord(recToMapping);
      //Properties.getCenteralControler().goBack(); <-porces should be called in sub class
    }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"exp while addNew records");
       exgui.verification.VerifyLib.showAlert("Insert Fail!!","Insert Fail!!");
    }finally{
      if(ksr!=null){
       //setCursor(ksr);
        util.PublicVariable.APP_FRAME.setCursor(ksr);
      }
    }
  }
  public void doExit()throws Exception{
    processhandler.template.Properties.getCenteralControler().goBack();
  }
  public void doCopy() {
     //call gui2Record,mapping data fields to record column.
     try{
       gui2Record();
       Record tmprec = (Record) util.MiscFunc.deepCopy(recToMapping);
       util.ApplicationProperites.setProperties(
           id4ApplicationProperties,
           tmprec
           );

     }catch(Exception e){
        e.printStackTrace();
     }
  }
  public void doPaste() {
    try{
      Record tmprec = (Record) util.ApplicationProperites.getProperties(
        id4ApplicationProperties);
      if(tmprec==null){
        exgui.verification.VerifyLib.showAlert("No Copied Data!!",
        "No Copied Data!!");
        return;
      }
      for(int i=0;i<recordColumnsToCopy.length;i++){
        recToMapping.set(
           recordColumnsToCopy[i],
           tmprec.get(recordColumnsToCopy[i])
        );
      }
      record2Gui();
    }catch(Exception e){
       e.printStackTrace();
    }
  }
  protected void setToOrgColor(){
    if(orgColorArr==null) return;
    for(int i=0;i<dataBoundGUIs.size();i++){
       exgui.DataBindGUIObject guiObj= (exgui.DataBindGUIObject)dataBoundGUIs.get(i);
       guiObj.getGUIcomponent().setBackground(orgColorArr[i]);
    }
  }
  public void grayMe(){
    //Component cmpx[]=getComponents();
    orgColorArr=new Color[dataBoundGUIs.size() ];
    for(int i=0;i<dataBoundGUIs.size();i++){
       exgui.DataBindGUIObject guiObj= (exgui.DataBindGUIObject)dataBoundGUIs.get(i);
       Color orgColor=guiObj.getGUIcomponent().getBackground();
       orgColorArr[i]=orgColor;
       guiObj.getGUIcomponent().setBackground(orgColor.darker());
    }
  }
  //do print function !? no way, left it to inheritors.
}
