package newtimes.preproduction.buyermakerselect;

import exgui.DataBindTextWithChecker;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class SelectBuyerMaker extends DataBindTextWithChecker {
  protected JTextField txt2Show = new JTextField();
  protected JButton btnDots = new JButton();
  public static final int TYPE_BUYER=1;
  public static final int TYPE_MAKER=2;
  public static final int TYPE_FABRIC_MILL=3;
  public static final int TYPE_WASH_MILL=4;
  public static final int TYPE_SEWING_SHOP=5;
  public static final int TYPE_LICENSEE=6;
  public static final int TYPE_SHIPPING=7;
  public static final int TYPE_OTHERS=8;
  //MESSERS, SUPPLIER, MANUFACTURER & CONSIGNEE
  public static final int TYPE_MESSERS=9;
  public static final int TYPE_SUPPLIER=10;
  public static final int TYPE_MANUFACTURER=11;
  public static final int TYPE_CONSIGNEE=12;
  public static final int TYPE_VENDOR=13;


  protected  Object orgValue=null;
  protected Object objClone4MdfCheck=null;
  public  String orgShowenString;
  boolean isAllowNull;
  String orgRecColumn;
  //for checking ,we need the ejb to run remote check..
  static newtimesejb.preproduction.BuyerMaker byerMakerEjb=null;
  static java.util.HashMap typeMappingTitles=null;
  int targetType=0;
  BorderLayout borderLayout1 = new BorderLayout();
  BuyerMakerChanged notifyTo=null;
  protected String center_code;
  String toolTipString="";
  static java.util.HashMap hmFoundBuyerMaker=new java.util.HashMap();
  public static boolean isAtShippingUnit=true;
  public SelectBuyerMaker(){
    try {
      jbInit();
      txt2Show.setEditable(false);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  /**
   * constructor of this class,
   * @param columnNameFromRecord the source column of input record,required for gui2Record method.
   * @param _orgValue the also as selected Value fo return in method "qui2Record"
   * @param orgDisplayString displaied string,can be found by joined sql recourds,or refer to other records of buyer maker handler
   * @param _BuyerMakerType the constatns as  TYPE_BUYER,or TYPE_MAKER....these are constants of this class
   * @param allowNull  to determ this databound gui allow to return null value or not.
   */
  public SelectBuyerMaker(String columnNameFromRecord,
                          Object _orgValue,
                          int _BuyerMakerType,boolean allowNull ) {
     mappingTitle();
     try {
       center_code=(String)util.PublicVariable.OPERATTING_CENTER;
      jbInit();
      txt2Show.setEditable(false);
      init(columnNameFromRecord,_orgValue,_BuyerMakerType,allowNull);
    }
    catch(Exception e) {
      e.printStackTrace();
      exgui.verification.VerifyLib.showAlert(
          "Server Side Connection Fail!!","Server Side Connection Fail!!\nPlease Notify the System Manager"
      );
    }
  }
  /**
   * if necessary,switch center code
   * @param cenCode String
   */
  public void setSelectingCenter(String cenCode){
    center_code=cenCode;
  }
  /**
   * switch select type for buyer maker selection interface.
   * @param type int
   */
  public  void setSelectingType(int type){
    targetType=type;
  }
  public static void clearFoundBuyerMaker(){
    hmFoundBuyerMaker.clear();
  }
  protected void iniOrgValue4ToolTips()throws Exception{
    /*
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
       this.setToolTipText("");
       txt2Show.setToolTipText("");
       return;
    }
   */
    if(byerMakerEjb==null){
      initEJB();
    }
    if(orgValue!=null) {
      //database.datatype.Record rec = this.byerMakerEjb.getByrMkrBySeq(Integer.parseInt(orgValue.toString()));
      database.datatype.Record rec = null;
      if((rec=(database.datatype.Record)hmFoundBuyerMaker.get(orgValue.toString()))==null){
        rec=byerMakerEjb.getByrMkrBySeq(Integer.parseInt(orgValue.toString()));
        hmFoundBuyerMaker.put(orgValue.toString(),rec);
      }else{

      }

      setTextFieldText(rec);
      if(rec==null){
        toolTipString="";
        ((javax.swing.JTextField)getGUIcomponent()).setToolTipText("");
        return;
      }
      StringBuffer sb=new StringBuffer();
      String fullName=(String) rec.get(3);
      String hkCode=(String) rec.get(56);
      sb.append("<html><body>");
      sb.append(fullName);
      if(hkCode!=null && (!hkCode.toUpperCase().trim().equals("NULL"))){
        sb.append("<br>");
        sb.append("HK CODE:");sb.append(hkCode);
      }
      sb.append("<br>");//conbine with 4 address.
      for (int i = 5; i < 9; i++) {
        String tmpstr = (String)rec.get(i);
        if (tmpstr != null && (!tmpstr.toUpperCase().trim().equals("NULL"))){
           sb.append(tmpstr);
           if(i!=8)sb.append("<br>");
        }
      }
      sb.append("</body></html>");
      toolTipString=sb.toString();
      ((javax.swing.JTextField)getGUIcomponent()).setToolTipText(toolTipString);
      this.setToolTipText(toolTipString);
    }else{
      toolTipString="";
      ((javax.swing.JTextField)getGUIcomponent()).setToolTipText(toolTipString);
      this.setToolTipText(toolTipString);
    }
  }
  public void init(String columnNameFromRecord,
                          Object _orgValue,String _orgDisplayText,
                          int _BuyerMakerType,boolean allowNull){
           newtimes.production.ProdMaintain_Properties.setWaitCursor();
                try{
                  //myCtnr.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                  if(center_code==null)center_code=(String)util.PublicVariable.OPERATTING_CENTER;
                 mappingTitle();
                 orgRecColumn=columnNameFromRecord;
                 orgValue=_orgValue;
                 targetType=_BuyerMakerType;
                 isAllowNull=allowNull;
                 if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK") && _BuyerMakerType==TYPE_BUYER && !isAtShippingUnit){
                   btnDots.setVisible(false);
                   if(orgValue!=null) {
                     if(byerMakerEjb==null){
                       initEJB();
                     }
                     //database.datatype.Record rec = this.byerMakerEjb.getByrMkrBySeq(Integer.parseInt(orgValue.toString()));
                     database.datatype.Record rec = (database.datatype.Record)hmFoundBuyerMaker.get(orgValue.toString());
                     if (rec == null) {
                       rec = byerMakerEjb.getByrMkrBySeq(Integer.parseInt(orgValue.
                           toString()));
                       hmFoundBuyerMaker.put(orgValue.toString(), rec);
                     }
                     String hkCode=(String)rec.get("BYMKR_HK_CODE");
                     txt2Show.setText(hkCode);
                     this.setToolTipText(hkCode);
                     orgShowenString=hkCode;
                     txt2Show.setEditable(true);
                   }else{
                     orgShowenString="";
                     txt2Show.setEditable(true);
                   }

                 }else{
                   txt2Show.setText(_orgDisplayText);
                   orgShowenString = _orgDisplayText;
                   iniOrgValue4ToolTips();
                 }
                 objClone4MdfCheck=((orgValue==null)?null:util.MiscFunc.deepCopy(orgValue));
               }
               catch(Exception e) {
                 e.printStackTrace();
                 exgui.verification.VerifyLib.showAlert(
                     "Server Side Connection Fail!!","Server Side Connection Fail!!\nPlease Notify the System Manager"
                 );
              }finally{
                newtimes.production.ProdMaintain_Properties.setNormalCursor();
              }

  }
  //allow client class re-initialize this object.
  /**
   * allow client class re-initialize this object.
   * @param columnNameFromRecord the source column of input record,required for gui2Record method.
   * @param _orgValue the also as selected Value fo return in method "qui2Record"
   * @param orgDisplayString displaied string,can be found by joined sql recourds,or refer to other records of buyer maker handler
   * @param _BuyerMakerType the constatns as  TYPE_BUYER,or TYPE_MAKER....these are constants of this class
   * @param allowNull  to determ this databound gui allow to return null value or not.
   */

  public void init(String columnNameFromRecord,
                          Object _orgValue,
                          int _BuyerMakerType,boolean allowNull){
   //javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
   //Container myCtnr=getParent();
   //java.awt.Cursor ksr=myCtnr.getCursor();
   newtimes.production.ProdMaintain_Properties.setWaitCursor();
        try{
          //myCtnr.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        if(center_code==null)center_code=(String)util.PublicVariable.OPERATTING_CENTER;
         mappingTitle();
         orgRecColumn=columnNameFromRecord;
         orgValue=_orgValue;
         targetType=_BuyerMakerType;
         isAllowNull=allowNull;
         if(byerMakerEjb==null){
           initEJB();
         }
          //use ejb to findout data to display
          if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK") && _BuyerMakerType==TYPE_BUYER && !isAtShippingUnit){
            btnDots.setVisible(false);
            if(orgValue!=null) {
              //database.datatype.Record rec = this.byerMakerEjb.getByrMkrBySeq(Integer.parseInt(orgValue.toString()));
              database.datatype.Record rec = (database.datatype.Record)hmFoundBuyerMaker.get(orgValue.toString());
              if (rec== null) {
                rec = byerMakerEjb.getByrMkrBySeq(Integer.parseInt(orgValue.
                    toString()));
                hmFoundBuyerMaker.put(orgValue.toString(), rec);
              }
              String hkCode=(String)rec.get("BYMKR_HK_CODE");
              txt2Show.setText(hkCode);
              this.setToolTipText(hkCode);
              orgShowenString=hkCode;
              txt2Show.setEditable(true);
            }else{
              orgShowenString="";
              txt2Show.setEditable(true);
            }
          }else{
            if(orgValue!=null){
              initBySeqNo();
            }else{
              txt2Show.setText("");
            }
          }






          iniOrgValue4ToolTips();
          objClone4MdfCheck=((orgValue==null)?null:util.MiscFunc.deepCopy(orgValue));
       }
       catch(Exception e) {
         e.printStackTrace();
         exgui.verification.VerifyLib.showAlert(
             "Server Side Connection Fail!!","Server Side Connection Fail!!\nPlease Notify the System Manager"
         );
      }finally{
        newtimes.production.ProdMaintain_Properties.setNormalCursor();
      }
  }
  protected static void initEJB()throws Exception{
    newtimesejb.preproduction.BuyerMakerHome bmHome = (newtimesejb.
        preproduction.BuyerMakerHome) info_ejb.WeblogicServiceLocator.
        locateServiceHome(
        util.PublicVariable.SERVER_URL,
        "newtimesejb.preproduction.BuyerMaker"
        );
    byerMakerEjb = bmHome.create();

  }

  public String getToolTipText(){
    /*
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      return "";
    }
    */
    return toolTipString;
  }
  public String getToolTipText(java.awt.event.MouseEvent me){
    /*
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      return "";
    }
    */
    return toolTipString;
  }
  //only allow loader to run this process.
  private static void mappingTitle(){
    if(typeMappingTitles ==null){
      typeMappingTitles=new java.util.HashMap();
       typeMappingTitles.put(new Integer(TYPE_BUYER),"buyer");
       typeMappingTitles.put(new Integer(TYPE_FABRIC_MILL),"fabric mill");
       typeMappingTitles.put(new Integer(TYPE_LICENSEE),"licensee");
       typeMappingTitles.put(new Integer(TYPE_MAKER),"maker");
       typeMappingTitles.put(new Integer(TYPE_SEWING_SHOP),"sewing shop");
       typeMappingTitles.put(new Integer(TYPE_SHIPPING),"shipping");
       typeMappingTitles.put(new Integer(TYPE_WASH_MILL),"wash mill");
       typeMappingTitles.put(new Integer(TYPE_OTHERS),"Other");
       typeMappingTitles.put(new Integer(TYPE_SUPPLIER),"Supplier");
       typeMappingTitles.put(new Integer(TYPE_MESSERS),"MESSERS");
       typeMappingTitles.put(new Integer(TYPE_MANUFACTURER),"MANUFACTURER");
       typeMappingTitles.put(new Integer(TYPE_CONSIGNEE),"CONSIGNEE");
       typeMappingTitles.put(new Integer(TYPE_VENDOR),"VENDOR");
    }
  }
  protected void jbInit() throws Exception {
    this.setLayout(borderLayout1);
    btnDots.setFont(new java.awt.Font("SansSerif", 1, 11));
    btnDots.setHorizontalAlignment(SwingConstants.CENTER);
    btnDots.setHorizontalTextPosition(SwingConstants.TRAILING);
    btnDots.setMargin(new Insets(2, 5, 2, 5));
    btnDots.setText("...");
    btnDots.setVerticalAlignment(SwingConstants.CENTER);
    btnDots.setVerticalTextPosition(SwingConstants.TOP);
    btnDots.addActionListener(new SelectBuyer_btnDots_actionAdapter(this));
    txt2Show.setText("");
    txt2Show.addMouseListener(new SelectBuyerMaker_txt2Show_mouseAdapter(this));
    txt2Show.addFocusListener(new SelectBuyerMaker_txt2Show_focusAdapter(this));
    this.setFont(new java.awt.Font("Dialog", 0, 11));
    this.add(txt2Show,  BorderLayout.CENTER);
    this.add(btnDots,  BorderLayout.EAST);
  }
 public void setModifyNotifyTo(BuyerMakerChanged msgTarget){
   notifyTo=msgTarget;
 }
 public JComponent getGUIcomponent(){
   return txt2Show;
 }
 public boolean isChanged(){
   if(txt2Show.isEditable()){
     if(txt2Show.getText().trim().equalsIgnoreCase(orgShowenString)) return false;
   }
   return true;
   /*
   boolean result=false;
   if(!util.MiscFunc.isEqual(orgValue,objClone4MdfCheck)){
     result=true;
     try{
       objClone4MdfCheck = ((orgValue == null) ? null :
                            util.MiscFunc.deepCopy(orgValue));
     }catch(Exception exp){
       exp.printStackTrace();
     }
   }
   return result;*/
 }
 public Object getSelectedValue(){
   return orgValue;
 }
 public void setEnabled(boolean isEnable){
   super.setEnabled(isEnable);
   //txt2Show.setEditable(isEnable);
   txt2Show.setEnabled(isEnable);
   txt2Show.setFocusable(isEnable);
   btnDots.setFocusable(isEnable);
   btnDots.setEnabled(isEnable);
   //btnDots.removeNotify();
 }
 public boolean isValidx(){
   if(!txt2Show.isEditable())return true;
   if(!isAllowNull){
     if(txt2Show.getText().trim().length()==0){
       exgui.verification.VerifyLib.showAlert(
            "Please assing the "+typeMappingTitles.get(new Integer(targetType)),
            "Please assign data"
       );
       txt2Show.grabFocus();
       return false;
     }
   }else{
     if(txt2Show.getText().trim().length()==0){
       orgValue=null;
       orgShowenString=null;
       return true;
     }
   }

   if(isChanged()){
     //1st is to test if allow null;
     if(byerMakerEjb==null){
       exgui.verification.VerifyLib.showAlert(
            "Server side connection fail\nSystem can not process further procedure",
            "server side connection fail"
       );
       txt2Show.grabFocus();
       return false;
     }else{
       //we realy have to call ejb for test...
       boolean result=false;
       try{
         result=checkModifedTextField();
         return result;
       }catch(java.rmi.RemoteException jre){
         jre.printStackTrace();
         util.ExceptionLog.exp2File(jre,"exception while running verifing buyer maker brief name");
         exgui.verification.VerifyLib.showAlert(
                       "Network Connection Fail\nPlease Notify the System manager",
                       "Network Connection Fail"
        );
         txt2Show.grabFocus();
         result =false;
       }catch(Exception e){
         exgui.verification.VerifyLib.showAlert(
              "No such data",
              "Record Not Found!!"
         );
         txt2Show.grabFocus();
         result= false;
       }finally{
         return result;
       }
     }
   }else{
     return true;
   }
 }
 public String getOrgRecField(){
   return orgRecColumn;
 }
protected void setTextFieldText(database.datatype.Record rec){
  try{
    if (rec != null) {
      if (util.PublicVariable.OPERATTING_CENTER.equals("NTHK") ) {
        orgShowenString = (String)rec.get("bymkr_HK_CODE");
        if (orgShowenString == null)orgShowenString = (String)rec.get(
            "bymkr_brief");
        txt2Show.setText(orgShowenString);
      } else {
        orgShowenString = rec.get("bymkr_brief").toString();
        txt2Show.setText(orgShowenString);
      }
    }else{
      orgShowenString="";
      txt2Show.setText(orgShowenString);
    }

  }catch(Exception exp){
    exp.printStackTrace();
    util.ExceptionLog.exp2File(exp,"");
  }
}
protected   void btnDots_actionPerformed(ActionEvent e) {
    //chaing the dialog content ...
    if(byerMakerEjb==null){
      try{
        initEJB();
      }catch(Exception exp){
        util.ExceptionLog.exp2File(exp,"");
        exp.printStackTrace();
        exgui.verification.VerifyLib.showAlert("Server Side Error,Please Contact System Manager",
                                               "Error While Creating BuyerMaker EJB");
        return;
      }
    }
    PnlAtoZ pnlInit=new PnlAtoZ();
    pnlInit.storedMap.clear();
    pnlInit.storedMap.put(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE,String.valueOf(targetType));//select buyer maker type is 2---maker.
    pnlInit.storedMap.put(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE_NAME,typeMappingTitles.get(new Integer(targetType)));
    pnlInit.storedMap.put(Kies.KESY_HM_SELECTING_CENTER_CODE,center_code);
    try{
      pnlInit.jbInit();
    }catch(Exception exp){
      exp.printStackTrace();
    }
    exgui.chaindialog.Responsible  pnlList=null;
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      pnlList=new PnlListBuyerMaker(byerMakerEjb);
    }else{
      pnlList=new PnlListBuyerMakerByTable(byerMakerEjb);
    }

    pnlInit.setDefalutNext(pnlList);
    DlgSelectBuyerMaker dlg=new DlgSelectBuyerMaker(util.PublicVariable.APP_FRAME ,
        "select A "+typeMappingTitles.get(new Integer(targetType)),
        true,
        pnlInit);
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      dlg.setSize(400, 300);
    }else{
      dlg.setSize(700, 400);//for hk user,need wider size.
    }
    exgui.UIHelper.setToScreenCenter(dlg);
    dlg.show();
    if(dlg.getDialogStatus()==dlg.DIALOG_OK){
      //System.out.println("reslut is:"+dlg.getDialogResult());
      Object rsl=((java.util.HashMap)dlg.getDialogResult()).get(Kies.KEY_SELECTED_BUYER_MAKER_RECORD);
      if(rsl!=null){
        database.datatype.Record buyermakerRec=(database.datatype.Record)rsl;
        orgValue=buyermakerRec.get(0);
        try{
          //force to update record and to store
          hmFoundBuyerMaker.put(orgValue.toString(),
           byerMakerEjb.getByrMkrBySeq(Integer.parseInt(orgValue.toString())));
        }catch(Exception exp){
          exp.printStackTrace();
          util.ExceptionLog.exp2File(exp,"");
        }
        //txt2Show.setText((String)buyermakerRec.get(2));
        setTextFieldText(buyermakerRec);
        genToolTip(buyermakerRec);
        if(notifyTo!=null) notifyTo.changeBuyerMaker(buyermakerRec);
      }else{
        orgValue=null;
        txt2Show.setText("");
        genToolTip(null);
        if(notifyTo!=null){
          //notifyTo.changeBuyerMaker(orgValue);
          notifyTo.changeBuyerMaker(null);
        }
      }
    }else{
      //System.out.println("conversation is over");
      return;
    }
  }
  protected void genToolTip(database.datatype.Record rec){
    /*
    if(util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
       this.setToolTipText("");
       txt2Show.setToolTipText("");
       return;
    }
    */
    setTextFieldText(rec);
    if(rec==null){
      toolTipString = "";
      this.setToolTipText(toolTipString);
      ((javax.swing.JTextField)getGUIcomponent()).setToolTipText(toolTipString);
      return;
    }

    StringBuffer sb=new StringBuffer();
    String fullName=(String) rec.get(1);
    String hkCode=(String) rec.get(14);
    sb.append("<html><body>");
    sb.append(fullName);
    if(hkCode!=null && (!hkCode.toUpperCase().trim().equals("NULL"))){
      sb.append("<br>");
      sb.append("HK CODE:");sb.append(hkCode);
    }
    sb.append("<br>");
    for (int i = 15; i < 19; i++) {
      String tmpstr = (String)rec.get(i);
      if (tmpstr != null && (!tmpstr.toUpperCase().trim().equals("NULL"))){
         sb.append(tmpstr);
         if(i!=18)sb.append("<br>");
      }
    }
    sb.append("</body></html>");
    toolTipString=sb.toString();
    ((javax.swing.JTextField)getGUIcomponent()).setToolTipText(toolTipString);
    this.setToolTipText(toolTipString);
  }
  //the function should be overwrite.
  public database.datatype.Record currentRecord(){
    if(orgValue!=null){
      database.datatype.Record rec = null;
      try{
        if ((rec = (database.datatype.Record)hmFoundBuyerMaker.get(orgValue.
            toString())) == null) {
          rec = byerMakerEjb.getByrMkrBySeq(Integer.parseInt(orgValue.toString()));
          hmFoundBuyerMaker.put(orgValue.toString(), rec);
        }
      }catch(Exception exp){
        exp.printStackTrace();
        util.ExceptionLog.exp2File(exp,"");
      }
      return rec;
    }
    return null;
  }
  protected void initBySeqNo()throws Exception{
    int seq=Integer.parseInt(orgValue.toString());
    database.datatype.Record rec=null;
    if((rec=(database.datatype.Record)hmFoundBuyerMaker.get(String.valueOf(seq)))==null){
      rec=byerMakerEjb.getByrMkrBySeq(seq);
      hmFoundBuyerMaker.put(String.valueOf(seq),rec);
    }else{

    }
    if(rec!=null){
      setTextFieldText(rec);
    }
  }
  //this function should be overwrite.
  protected boolean checkModifedTextField()throws Exception{
    java.awt.Cursor ksr=getParent().getCursor();
    try{
      //util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
      getParent().setCursor(new Cursor(Cursor.WAIT_CURSOR));
      /*
      String briefName = txt2Show.getText().trim();
      database.datatype.Record rec = byerMakerEjb.getRecord(briefName,
          String.valueOf(targetType));
      */
       String hkCode=txt2Show.getText().trim().toUpperCase();
       if(hkCode.trim().length()==0){
         if (notifyTo != null)notifyTo.changeBuyerMaker(null);
         return true;
       }
      database.datatype.Record rec=null;
      String centerWithComma="NTHK";
      StringBuffer sb=new StringBuffer();
       sb.append("select bymkr_seq,BYMKR_NAME,bymkr_brief,BYMKR_CNTY_CODE, BYMKR_CITY_NAME,BYMKR_CHECK_DIV,BYMKR_CHINESE_BRIEF,");
       sb.append("BUY_COMM,BUY_COMM_PC, BUY_COMM_DZ,");
       sb.append("BUY_COMM_LUMP_SUM,MKR_DSCT_PER,MKR_DSCT_PC,MKR_DSCT_DZ,MKR_DSCT_LUMP_SUM,");
       sb.append("BYMKR_HK_CODE,");
       sb.append("BYMKR_ADDR1, BYMKR_ADDR2, BYMKR_ADDR3, BYMKR_ADDR4,BYMKR_NAME2 ");
       sb.append(" from buyer_maker where record_delete_flag='1' and BYMKR_MULTI_TYPE like '%,");
       //sb.append(String.valueOf(newtimes.preproduction.buyermakerselect.SelectBuyerMaker.TYPE_BUYER));
       sb.append(String.valueOf(targetType));
       sb.append(",%' and BYMKR_HK_CODE like '");
       sb.append(util.MiscFunc.Replace(hkCode, "'", "''"));
       sb.append("'");

       if(centerWithComma!=null){
         sb.append(" and SELECTABLE_CENTER like '%,");
         sb.append(centerWithComma);
         sb.append(",%'");
       }

       if(centerWithComma.equals("001")){
         sb.append(" order by bymkr_brief");
       }else{
         sb.append(" order by BYMKR_HK_CODE,BYMKR_CHINESE_BRIEF,BYMKR_NAME");
       }
         java.util.Vector rec2Return = exgui2.CONST.BASIC_MAIN_EJB.getDatas(
             util.PublicVariable.USER_RECORD,
             sb.toString(), 1, 99999);
         if(rec2Return.size()==0){
 //          exgui.verification.VerifyLib.showAlert("No Such "+typeMappingTitles.get(String.valueOf(targetType))+" HK CODE:"+hkCode,
 //                                                 "No Such "+typeMappingTitles.get(String.valueOf(targetType))+" HK CODE:"+hkCode);
           txt2Show.setText(orgShowenString);
           return false;
         }
        rec=(database.datatype.Record)rec2Return.get(0);
        orgValue = rec.get(0);
        hmFoundBuyerMaker.put(orgValue,rec);
        orgShowenString=(String)rec.get("BYMKR_HK_CODE");
        txt2Show.setText(orgShowenString.trim());
        this.setToolTipText(hkCode);
      //notify the related object..
      if (notifyTo != null) {
        //notifyTo.changeBuyerMakerSeqNo(orgValue);
         notifyTo.changeBuyerMaker(rec);
        return true;
      }
      else {
        return true;
      }
    }catch(Exception e){
      //e.printStackTrace();
      throw e;
    }finally{
      //util.PublicVariable.APP_FRAME.getContentPane().setCursor(ksr);
      getParent().setCursor(ksr);
    }
  }
  void txt2Show_focusLost(FocusEvent e) {
    try{
      if(isChanged()){
        checkModifedTextField();
      }
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
    }
  }
  void txt2Show_mouseExited(MouseEvent e) {

  }


}

class SelectBuyer_btnDots_actionAdapter implements java.awt.event.ActionListener {
  SelectBuyerMaker adaptee;
  SelectBuyer_btnDots_actionAdapter(SelectBuyerMaker adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnDots_actionPerformed(e);
  }
}

class SelectBuyerMaker_txt2Show_focusAdapter extends java.awt.event.FocusAdapter {
  SelectBuyerMaker adaptee;

  SelectBuyerMaker_txt2Show_focusAdapter(SelectBuyerMaker adaptee) {
    this.adaptee = adaptee;
  }
  public void focusLost(FocusEvent e) {
    adaptee.txt2Show_focusLost(e);
  }
}

class SelectBuyerMaker_txt2Show_mouseAdapter extends java.awt.event.MouseAdapter {
  SelectBuyerMaker adaptee;

  SelectBuyerMaker_txt2Show_mouseAdapter(SelectBuyerMaker adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseExited(MouseEvent e) {
    adaptee.txt2Show_mouseExited(e);
  }
}
