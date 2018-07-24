package newtimes.shipping_admin.guis.shippingmaintain;

import processhandler.*;
import processhandler.template.*;
import javax.swing.*;
import java.awt.*;
import exgui.*;
import java.awt.event.*;
import javax.swing.border.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import database.datatype.Record;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>BUYER
 * @author not attributable
 * @version 1.0f
 */

public class PnlShipMaster
    extends PnlFieldsEditor{
//    extends JPanel{
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JLabel jLabel23 = new JLabel();
  JPanel jPanel3 = new JPanel();
  JLabel jLabel25 = new JLabel();
  JLabel jLabel121 = new JLabel();
  JLabel jLabel110 = new JLabel();
  JPanel jPanel1 = new JPanel();
  Border border1;
  JLabel jLabel26 = new JLabel();
  JLabel jLabel19 = new JLabel();
  JLabel jLabel27 = new JLabel();
  JLabel jLabel125 = new JLabel();
  //JTextField txtShipDest = new JTextField();
  JComboBox cbxShipPrcTerm = new JComboBox();
  public JTextField txtShipDate = new JTextField();
  JPanel jPanel2 = new JPanel();
  JLabel jLabel126 = new JLabel();
  JLabel jLabel117 = new JLabel();
  JLabel jLabel9 = new JLabel();
  JLabel jLabel127 = new JLabel();
  JTextField txtMAWB = new JTextField();
  JLabel jLabel20 = new JLabel();
  JLabel jLabel115 = new JLabel();
  JTextField txtFLT = new JTextField();
  JLabel jLabel10 = new JLabel();
  JTextField txtHAWB = new JTextField();
  JLabel jLabel1110 = new JLabel();
  JLabel jLabel1111 = new JLabel();
  JLabel jLabel112 = new JLabel();
  JTextField txtShipLC = new JTextField();
  JComboBox cbxShipOcieanAir = new JComboBox();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JPanel jPanel4 = new JPanel();
  JComboBox cbxShipEtaTo = new JComboBox();
  JComboBox cbxShipEtdEx = new JComboBox();
  JLabel jLabel113 = new JLabel();
  JLabel jLabel11 = new JLabel();
  public JTextField txtShipETDdate = new JTextField();
  JLabel jLabel17 = new JLabel();
  JLabel jLabel15 = new JLabel();
  public JTextField txtShipETAdate = new JTextField();
  public JComboBox cbxShipOrgCnty = new JComboBox();
  JLabel jLabel119 = new JLabel();
  JLabel jLabel12 = new JLabel();
  JLabel jLabel14 = new JLabel();
  JLabel jLabel1116 = new JLabel();
  JTextField txtCuft = new JTextField();
  JTextField txtDimnetWT = new JTextField();
  JTextField txtDimentCTN = new JTextField();
  JTextField txtDimUnit = new JTextField();
  JLabel jLabel1113 = new JLabel();
  JLabel jLabel128 = new JLabel();
  JTextField txtNetNet = new JTextField();
  JLabel jLabel118 = new JLabel();
  JLabel jLabel1117 = new JLabel();
  JTextField txtGrossWT = new JTextField();
  JLabel jLabel114 = new JLabel();
  JTextField txtNetWT = new JTextField();
  JLabel jLabel129 = new JLabel();
  JTextField txtNetNetUnit = new JTextField();
  JLabel jLabel1210 = new JLabel();
  JLabel jLabel1114 = new JLabel();
  JTextField txtNetUnit = new JTextField();
  JTextField txtGrossUnit = new JTextField();
  JLabel jLabel1211 = new JLabel();
  JLabel jLabel1118 = new JLabel();
  JLabel jLabel1115 = new JLabel();
  Border border2;
  TitledBorder titledBorder1;
  JComboBox cbx_IC_Szn = new JComboBox();
  JTextField txt_FTY_Inv = new JTextField();
  JComboBox cbx_IC_Div = new JComboBox();
  public JTextField txtShip_IC_date = new JTextField();
  public JPanel PnlShipExtra = new JPanel();
  JButton btnEditShipExtra = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea txtAreaShipExtra = new JTextArea();
  Border border3;
  TitledBorder titledBorder2;
  SelectBuyerMaker slkByrMkrXprFwd = new SelectBuyerMaker();
  SelectBuyerMaker slkByrMkr_Bill2 = new SelectBuyerMaker();
  SelectBuyerMaker slkByrMkrShip2 = new SelectBuyerMaker();
  JScrollPane jScrollPane2 = new JScrollPane();
  JTextArea txtAreaVessel = new JTextArea();
  SelectBuyerMaker slkByrMkrXprAgnt = new SelectBuyerMaker();
  public boolean isProcessingExit=false;
  public  BlueBkgWhiteCharLabel lblTItleBar = new BlueBkgWhiteCharLabel();
  JComboBox cbxPort = new JComboBox();
  JComboBox cbxShipAgent = new JComboBox();
  String CenterCode=null;
  public static java.util.Vector branches;
  static java.text.DateFormat dateformat=new java.text.SimpleDateFormat("yyyy/MM/dd");
  public JLabel lblShipStaff = new JLabel();
  public JTextField txtShipStaffCode = new JTextField();
  JPanel jPanel5 = new JPanel();
  TitledBorder titledBorder3;
  Border border4;
  TitledBorder titledBorder4;
  Border border5;
  TitledBorder titledBorder5;
  JLabel jLabel1119 = new JLabel();
  public JTextField txtShip_Ic_Year = new JTextField();
  JLabel jLabel210 = new JLabel();
  JTextField txtShipVia = new JTextField();
  JPanel jPanel7 = new JPanel();
  JPanel PnlSpecInstruc = new JPanel();
  TitledBorder titledBorder6;
  Border border6;
  TitledBorder titledBorder7;
  BorderLayout borderLayout3 = new BorderLayout();
  JScrollPane jScrollPane5 = new JScrollPane();
  JTextArea txtSpecInstruc = new JTextArea();
  Border border7;
  TitledBorder titledBorder8;
  JLabel jLabel111 = new JLabel();
  JComboBox cbxPriceTermDest = new JComboBox();
  JLabel jLabel1112 = new JLabel();
  JComboBox cbxShipDest = new JComboBox();
  JLabel jLabel116 = new JLabel();
  JComboBox cbxPaymentTerm = new JComboBox();
  public final static String JBUTTON_CAPTION_INI_BY_LATTER_PRODUCTION="Get Default Value";
  public final static int COLUMN_INDEX_ship_agent=7;
  public final static int COLUMN_INDEX_ship_prc_trm=39;
  public final static int COLUMN_INDEX_ship_prx_term_dest=61;
  public final static int COLUMN_INDEX_SHIP_PAYMENT_TERM=62;
  public final static int COLUMN_INDEX_ship_dest=40;
  public final static int COLUMN_INDEX_ship_USA_port=15;
  public final static int COLUMN_INDEX_ship_ic_div=28;
  public final static int COLUMN_INDEX_ship_ic_sea=27;
  public final static int COLUMN_INDEX_ship_bill_to=37;
  public final static int COLUMN_INDEX_ship_ship_to=38;
  JPanel PnlRiskOf = new JPanel();
  JTextArea txtRiskOf = new JTextArea();
  JScrollPane jScrollPane6 = new JScrollPane();
  JPanel Pnl_manufacture = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  TitledBorder titledBorder9;
  Border border8;
  TitledBorder titledBorder10;
  JScrollPane jScrollPane7 = new JScrollPane();
  JTextArea txtShipManufacture = new JTextArea();
  static int index_of_division;
  static int index_of_bill2;
  static int index_of_ship2;
  JPanel pnl2PlaceShipRmk = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JTextArea txtareaShippingMark = new JTextArea();
  JScrollPane jScrollPane3 = new JScrollPane();
  JButton btnCpyShipRmkFromOtherSRN = new JButton();
  JButton btnCpySpecialInstructionFromOtherSRN = new JButton();
  JPanel jPanel8 = new JPanel();
  JPanel jPanel6 = new JPanel();
  JScrollPane jScrollPane4 = new JScrollPane();
  BorderLayout borderLayout2 = new BorderLayout();
  JTextArea txtShipSRNremark = new JTextArea();
  JButton btnCopySRNDescFromOtherSRN = new JButton();
  exgui.DataBindJCombobox dbCbxShipOrg=null;
  JButton btnGenDefaultSrnDesc = new JButton();
  boolean isProcessingDelete=false;
  JTextField txtShipExtraFtyCashApply = new JTextField();
  JLabel lblShipExtraFtyCashApply = new JLabel();
  WhiteBkgBlueCharLabel lblShipDep = new WhiteBkgBlueCharLabel();
  JComboBox cbxShipDep = new JComboBox();
  JLabel lblProfitCenter = new JLabel();
  JComboBox cbxProfitCenter = new JComboBox();
  JButton btnCopyRiskOfFromOtherSRN = new JButton();
  JPanel jPanel9 = new JPanel();

  BorderLayout borderLayout4 = new BorderLayout();
  JScrollPane jScrollPane8 = new JScrollPane();
  JTextArea jtaconsignee = new JTextArea();
  //JComboBox cbxMfxBy = new JComboBox();
  public PnlShipMaster() {
    try{
    jbInit();
    CenterCode=util.MiscFunc.Replace((String)util.PublicVariable.USER_RECORD.get("usr_cen_code"),"'","''");
    recordColumnsToCopy=null;
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void doPrint() throws java.lang.Exception {

  }
  public void doUpdate(){
    try{
      if(!gui2Record())return;
      //for tpe,need to check if fty-inv re-input,if so,have to confirm.
      if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
        String ftyInv=util.MiscFunc.Replace(txt_FTY_Inv.getText().trim(),"'","''");
        if(ftyInv!=null && ftyInv.length()>0){
          StringBuffer sql=new StringBuffer();
          sql.append("select  ");
          sql.append("a.ship_no  ");
          /*
          sql.append(",A.SHIP_FTY_INV,  ");
          sql.append("c.prod_maker  ");
          */
          sql.append("from shipping a,ship_sc b,prod_head c  ");
          sql.append("where A.SHIP_NO=b.ship_no  ");
          sql.append("and B.PROD_HEAD_PK=c.prod_head_pk  ");
          sql.append("and a.ship_no like 'ZATW%'  ");

          String srn=(String)newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO");

          sql.append("and c.prod_maker in ( ");
          sql.append("select distinct cc.prod_maker from prod_head cc,ship_sc bb ");
          sql.append("where  cc.prod_head_pk=bb.prod_head_pk ");
          sql.append("and  bb.ship_no='");sql.append(srn);sql.append("' ");
          sql.append(") ");

          sql.append("and a.ship_no <> '");sql.append(srn);sql.append("' ");
          sql.append("and A.SHIP_FTY_INV ='");sql.append(ftyInv);sql.append("' ");
          sql.append("group by a.ship_no ");
          util.MiscFunc.showProcessingMessage();
           java.util.Vector vctTestFtyInv=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
                   util.PublicVariable.USER_RECORD,
                  sql.toString(),1,99999
           );
           util.MiscFunc.hideProcessingMessage();
           if(vctTestFtyInv.size()>0){
             StringBuffer sbInSrn=new StringBuffer();
             for(int i=0;i<vctTestFtyInv.size();i++){
               Record recTest = (Record)vctTestFtyInv.get(i);
               if(sbInSrn.length()>0)sbInSrn.append(",");
               sbInSrn.append((String)recTest.get(0));
             }
             if(!exgui.verification.VerifyLib.showConfirm("FTY-INV Already In Other SRN:"+sbInSrn+"\nDo You Want To continue update?",
                                                          "FTY-INV Already In Other SRN",false)){
               return;
             }
           }
        }
      }
      util.MiscFunc.showProcessingMessage();
      recToMapping.set("record_modify_user",
                       util.PublicVariable.USER_RECORD.get("usr_code"));
      java.util.Vector vct=new java.util.Vector();
      vct.add(recToMapping);
      dbprc.updateRecords(vct);
      //exgui.verification.VerifyLib.showPlanMsg("UPDATE OK", "UPDATE OK");
      recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);//cloned for if modified check;
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD =
          recToMapping;

      newtimes.shipping_admin.PnlBaseContainer pnlFunc =
          newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL;
     JPanel pnlBtns=pnlFunc.getExtraButtonPanel();
     Component comps[]=pnlBtns.getComponents();
     for(int i=0;i<comps.length;i++){
       if(comps[i] instanceof javax.swing.JButton){
         if(((JButton)comps[i]).getText().equals(JBUTTON_CAPTION_INI_BY_LATTER_PRODUCTION) &&
            (

              recToMapping.get(COLUMN_INDEX_ship_agent)!=null &&
              recToMapping.get(COLUMN_INDEX_ship_prc_trm)!=null &&
              recToMapping.get(COLUMN_INDEX_ship_prx_term_dest)!=null &&
              recToMapping.get(COLUMN_INDEX_SHIP_PAYMENT_TERM)!=null &&
              recToMapping.get(COLUMN_INDEX_ship_dest)!=null &&
              recToMapping.get(COLUMN_INDEX_ship_USA_port)!=null &&
              //recToMapping.get(COLUMN_INDEX_ship_ic_div)!=null &&
              recToMapping.get(COLUMN_INDEX_ship_ic_sea)!=null &&
              recToMapping.get(COLUMN_INDEX_ship_bill_to)!=null &&
              recToMapping.get(COLUMN_INDEX_ship_ship_to)!=null &&
              newtimes.shipping_admin.process.shiippingmaintain.TgrToInitShipMasterByLatterSc.processing_prod_head_pk!=0
           )){
           ((newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster)this.dbprc).reUpdateSc(
           newtimes.shipping_admin.process.shiippingmaintain.TgrToInitShipMasterByLatterSc.processing_prod_head_pk,
           (String)newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO"));
           pnlFunc.setButtons(false, true, true, true, true);
           pnlFunc.removalAddExtralButtons();
           pnlFunc.addTriggerButton("Detail Records",
                new newtimes.shipping_admin.process.shiippingmaintain.TgrToListAddedStyles());
           pnlFunc.validate();
           pnlFunc.repaint();
           return;
         }
       }
     }

    }catch(Exception e){
      e.printStackTrace();
      util.MiscFunc.hideProcessingMessage();
      util.ExceptionLog.exp2File(e,"update shipping master");
      exgui.verification.VerifyLib.showAlert("Update Fail!!\nPlease Contact System Manager", "Update  Fail");
    }finally{
      util.MiscFunc.hideProcessingMessage();
    }
  }
  public boolean isContextModified(){
    if(lblTItleBar.getText().indexOf("ADD SHIP MASTER BY S/C:")!=-1 && isProcessingExit){
      return false;
    }
    if(isProcessingDelete) return false;
    //if(!isProcessingExit) return false;//update//add new is not need to check context modification.
    return super.isContextModified();
  }
  public void doAddNew(){
    try{
    if(!gui2Record()) return;

    util.MiscFunc.showProcessingMessage();
    recToMapping.set("record_create_user",
                     util.PublicVariable.USER_RECORD.get("usr_code"));
    System.out.println(">>>"+recToMapping.get("ship_no"));

    recToMapping=dbprc.addRecord(recToMapping);

    System.out.println(">>>"+recToMapping.get("ship_no"));
    util.MiscFunc.hideProcessingMessage();
    if(!newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
      exgui.verification.VerifyLib.showPlanMsg("Insert OK,SRN NO :" +
                                               (String)recToMapping.get(0),
                                               "Insert OK");
    }

    recClonedForCheck=(Record)util.MiscFunc.deepCopy(recToMapping);
    //Record rec=((newtimes.shipping_admin.process.shiippingmaintain.DB_ShipMaster)this.dbprc).getRecordByPk((String)recToMapping.get(0));
    newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD=recToMapping;
    processhandler.template.Properties.getCenteralControler().doCommandExecute(
    new newtimes.shipping_admin.process.shiippingmaintain.TgrToEditShipMaster());
    if(
          recToMapping.get(COLUMN_INDEX_ship_agent)==null &&
          recToMapping.get(COLUMN_INDEX_ship_prc_trm)==null &&
          recToMapping.get(COLUMN_INDEX_ship_prx_term_dest)==null &&
          recToMapping.get(COLUMN_INDEX_SHIP_PAYMENT_TERM)==null &&
          recToMapping.get(COLUMN_INDEX_ship_dest)==null &&
          recToMapping.get(COLUMN_INDEX_ship_USA_port)==null &&
          //recToMapping.get(COLUMN_INDEX_ship_ic_div)==null &&
          recToMapping.get(COLUMN_INDEX_ship_ic_sea)==null &&
          recToMapping.get(COLUMN_INDEX_ship_bill_to)==null &&
          recToMapping.get(COLUMN_INDEX_ship_ship_to)==null

      ){
        //since this is add without S/C,can not go further.

      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.setButtons(false, false, false, false, false);
      newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDIT_PANEL.removalAddExtralButtons();

    }

    }catch(Exception e){
          e.printStackTrace();
          util.MiscFunc.hideProcessingMessage();
          util.ExceptionLog.exp2File(e,"insert shipping master");
            exgui.verification.VerifyLib.showAlert(
            "Insert Fail!!\nPlease Contact System Manager", "Insert  Fail");
    }
  }
  public database.datatype.Record getProcessingRecord(){return recToMapping;}
  public void record2Gui() {
   try{
    if(!util.PublicVariable.OPERATTING_CENTER.equals("NTHK")){
      btnGenDefaultSrnDesc.setVisible(false);
    }
    dataBoundGUIs.clear();

    Object vftxtShipVia=exgui.verification.CellFormat.getOrdinaryField(27);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtShipVia,"SHIP_VIA",recToMapping.get("SHIP_VIA"),27,(exgui.Object2String)vftxtShipVia,(exgui.ultratable.CellTxtEditorFormat)vftxtShipVia)
    );

      cbxShipDest.setEditable(true);
      dataBoundGUIs.add(
         new exgui.DataBindEditableJCombobox(
         //new exgui.DataBindJCombobox(
           cbxShipDest, "SHIP_DEST", newtimes.shipping_admin.ShippingAdmin_Const.DESTINATIONS , "Dest_name",
           //"dest_name", recToMapping.get("SHIP_DEST"),"",null);
          "dest_name", recToMapping.get("SHIP_DEST"),"",null,30));

      Object vftxtShipIcYear=exgui.verification.CellFormat.getIntVerifierAllowNull(4);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(txtShip_Ic_Year,
                                            "SHIP_IC_YEAR",
                                            recToMapping.get("SHIP_IC_YEAR"),4,
                                            (exgui.Object2String)vftxtShipIcYear,
                                            (exgui.ultratable.CellTxtEditorFormat)vftxtShipIcYear)
      );


    Object vftxtShipDate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();;
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtShipDate,"SHIP_DATE",recToMapping.get("SHIP_DATE"),10,(exgui.Object2String)vftxtShipDate,(exgui.ultratable.CellTxtEditorFormat)vftxtShipDate)
    );
     cbxPort.setEditable(true);
      dataBoundGUIs.add(
          new exgui.DataBindEditableJCombobox(
          //new exgui.DataBindJCombobox(
           cbxPort, "SHIP_USA_PORT", newtimes.shipping_admin.ShippingAdmin_Const.DESTINATIONS , "Dest_name",
           //"dest_name", recToMapping.get("SHIP_USA_PORT"),"",null));
         "dest_name", recToMapping.get("SHIP_USA_PORT"),"",null,30));


    Object vftxtMAWB=exgui.verification.CellFormat.getOrdinaryField(25);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtMAWB,"SHIP_MAWB",recToMapping.get("SHIP_MAWB"),25,(exgui.Object2String)vftxtMAWB,(exgui.ultratable.CellTxtEditorFormat)vftxtMAWB)
    );

      Object vftxtShipStaffCode=exgui.verification.CellFormat.getOrdinaryField(20);
       dataBoundGUIs.add(
          new exgui.DataBindTextWithChecker(txtShipStaffCode,
                                            "SHIP_STAFF_CODE",
                                            recToMapping.get("SHIP_STAFF_CODE"),20,
                                            (exgui.Object2String)vftxtShipStaffCode,
                                            (exgui.ultratable.CellTxtEditorFormat)vftxtShipStaffCode)
      );


    Object vftxtFLT=exgui.verification.CellFormat.getOrdinaryField(25);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtFLT,"SHIP_FLT_NO",recToMapping.get("SHIP_FLT_NO"),25,(exgui.Object2String)vftxtFLT,(exgui.ultratable.CellTxtEditorFormat)vftxtFLT)
    );
    Object vftxtHAWB=exgui.verification.CellFormat.getOrdinaryField(25);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtHAWB,"SHIP_HAWB",recToMapping.get("SHIP_HAWB"),25,(exgui.Object2String)vftxtHAWB,(exgui.ultratable.CellTxtEditorFormat)vftxtHAWB)
    );
    Object vftxtShipLC=exgui.verification.CellFormat.getOrdinaryField(50);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtShipLC,"SHIP_LC_NO",
         recToMapping.get("SHIP_LC_NO"),50,
         (exgui.Object2String)vftxtShipLC,(exgui.ultratable.CellTxtEditorFormat)vftxtShipLC)
    );
     cbxShipAgent.setEditable(true);
    exgui.DataBindEditableJCombobox  DbJcbxjcbxShipAgent= new exgui.DataBindEditableJCombobox(
       cbxShipAgent, "ship_agent", branches, "BRNCH_BRIEF",
       "BRNCH_BRIEF", recToMapping.get("ship_agent"),"",null,60);
       dataBoundGUIs.add(DbJcbxjcbxShipAgent);


    Object vftxtShipETDdate=exgui.verification.CellFormat.getDateStringFormater();
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtShipETDdate,"SHIP_ETD_DATE",recToMapping.get("SHIP_ETD_DATE"),10,(exgui.Object2String)vftxtShipETDdate,(exgui.ultratable.CellTxtEditorFormat)vftxtShipETDdate)
    );

    Object vftxtShipETAdate=exgui.verification.CellFormat.getDateStringFormaterAllowNull();;
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtShipETAdate,"SHIP_ETA_DATE",recToMapping.get("SHIP_ETA_DATE"),10,(exgui.Object2String)vftxtShipETAdate,(exgui.ultratable.CellTxtEditorFormat)vftxtShipETAdate)
    );

    Object vftxtDimnetWT=exgui.verification.CellFormat.getDoubleFormatAllowNull(6,2);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(
      txtDimnetWT,"SHIP_DIM_WT",recToMapping.get("SHIP_DIM_WT"),9,(exgui.Object2String)vftxtDimnetWT,(exgui.ultratable.CellTxtEditorFormat)vftxtDimnetWT)
    );
    Object vftxtDimentCTN=exgui.verification.CellFormat.getDoubleFormatAllowNull(5,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDimentCTN,"SHIP_DIM_CTN",recToMapping.get("SHIP_DIM_CTN"),8,(exgui.Object2String)vftxtDimentCTN,(exgui.ultratable.CellTxtEditorFormat)vftxtDimentCTN)
    );
     //===20061103,extra fty cash apply field add==========================
      Object vftxtExtraFtyCashApply=exgui.verification.CellFormat.getDoubleFormatAllowNull(9,2);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(
         txtShipExtraFtyCashApply ,
         "SHIP_EXT_FTY_CASH_APPLY",
         recToMapping.get("SHIP_EXT_FTY_CASH_APPLY"),11,
         (exgui.Object2String)vftxtExtraFtyCashApply,
         (exgui.ultratable.CellTxtEditorFormat)vftxtExtraFtyCashApply)
      );
    //=====end of 20061103,extra fty cash apply field add==========================
    Object vftxtDimUnit=exgui.verification.CellFormat.getOrdinaryField(5);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtDimUnit,"SHIP_DIM_WT_UNIT",recToMapping.get("SHIP_DIM_WT_UNIT"),5,(exgui.Object2String)vftxtDimUnit,(exgui.ultratable.CellTxtEditorFormat)vftxtDimUnit)
    );
      Object vftxtDimCuft=exgui.verification.CellFormat.getOrdinaryField(20);
       dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtCuft,"SHIP_DIM_CUFT",
            recToMapping.get("SHIP_DIM_CUFT"),20,
            (exgui.Object2String)vftxtDimCuft,
            (exgui.ultratable.CellTxtEditorFormat)vftxtDimCuft)
      );


    Object vftxtNetNet=exgui.verification.CellFormat.getDoubleFormatAllowNull(6,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtNetNet,"SHIP_NET_NET_WT",recToMapping.get("SHIP_NET_NET_WT"),9,(exgui.Object2String)vftxtNetNet,(exgui.ultratable.CellTxtEditorFormat)vftxtNetNet)
    );
    Object vftxtGrossWT=exgui.verification.CellFormat.getDoubleFormatAllowNull(6,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtGrossWT,"SHIP_GROSS_WT",recToMapping.get("SHIP_GROSS_WT"),9,(exgui.Object2String)vftxtGrossWT,(exgui.ultratable.CellTxtEditorFormat)vftxtGrossWT)
    );
    Object vftxtNetWT=exgui.verification.CellFormat.getDoubleFormatAllowNull(6,2);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtNetWT,"SHIP_NET_WT",recToMapping.get("SHIP_NET_WT"),9,(exgui.Object2String)vftxtNetWT,(exgui.ultratable.CellTxtEditorFormat)vftxtNetWT)
    );
    Object vftxtNetNetUnit=exgui.verification.CellFormat.getOrdinaryField(5);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtNetNetUnit,"SHIP_NET_NET_WT_UNIT",recToMapping.get("SHIP_NET_NET_WT_UNIT"),5,(exgui.Object2String)vftxtNetNetUnit,(exgui.ultratable.CellTxtEditorFormat)vftxtNetNetUnit)
    );
    Object vftxtNetUnit=exgui.verification.CellFormat.getOrdinaryField(5);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtNetUnit,"SHIP_NET_WT_UNIT",recToMapping.get("SHIP_NET_WT_UNIT"),5,(exgui.Object2String)vftxtNetUnit,(exgui.ultratable.CellTxtEditorFormat)vftxtNetUnit)
    );
    Object vftxtGrossUnit=exgui.verification.CellFormat.getOrdinaryField(5);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtGrossUnit,"SHIP_GROSS_WT_UNIT",recToMapping.get("SHIP_GROSS_WT_UNIT"),5,(exgui.Object2String)vftxtGrossUnit,(exgui.ultratable.CellTxtEditorFormat)vftxtGrossUnit)
    );
    Object vftxt_FTY_Inv=exgui.verification.CellFormat.getOrdinaryField(25);
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txt_FTY_Inv,"SHIP_FTY_INV",recToMapping.get("SHIP_FTY_INV"),25,(exgui.Object2String)vftxt_FTY_Inv,(exgui.ultratable.CellTxtEditorFormat)vftxt_FTY_Inv)
    );
    Object vftxtShip_IC_date=exgui.verification.CellFormat.getDateStringFormaterAllowNull();;
     dataBoundGUIs.add(  new exgui.DataBindTextWithChecker(txtShip_IC_date,"SHIP_IC_DATE",recToMapping.get("SHIP_IC_DATE"),10,(exgui.Object2String)vftxtShip_IC_date,(exgui.ultratable.CellTxtEditorFormat)vftxtShip_IC_date)
    );

      Object vftxtShipVessl=
          exgui.verification.CellFormat.getOrdinaryField(70);
       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
            txtAreaVessel,"SHIP_VESSEL",
            recToMapping.get("SHIP_VESSEL"),70,
            (exgui.Object2String)vftxtShipVessl,
            (exgui.ultratable.CellTxtEditorFormat)vftxtShipVessl)
      );

   Object vftxtShippingMark=
       exgui.verification.CellFormat.getOrdinaryField(3000);
    dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(
         txtareaShippingMark,"SHIP_SHIPPING_RMK",
         recToMapping.get("SHIP_SHIPPING_RMK"),3000,
         (exgui.Object2String)vftxtShippingMark,
         (exgui.ultratable.CellTxtEditorFormat)vftxtShippingMark)
    );

      Object vftxtShippRiskOf=
          exgui.verification.CellFormat.getOrdinaryField(255);
       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
            txtRiskOf,"Rick_of",
            recToMapping.get("Rick_of"),255,
            (exgui.Object2String)vftxtShippRiskOf,
            (exgui.ultratable.CellTxtEditorFormat)vftxtShippRiskOf)
       );

    Object vftxtSpecInstru=
        exgui.verification.CellFormat.getOrdinaryField(2000);
     dataBoundGUIs.add(
       new exgui.DataBindTextWithChecker(
          txtSpecInstruc,"SPECIAL_INSTURCTION",
          recToMapping.get("SPECIAL_INSTURCTION"),  2000,
          (exgui.Object2String)vftxtSpecInstru,
          (exgui.ultratable.CellTxtEditorFormat)vftxtSpecInstru)
     );


     //if is add mode,use shipping mark from buer maker.
      if(lblTItleBar.getText().indexOf("ADD SHIP MASTER BY S/C:")!=-1 &&
         recToMapping.get(COLUMN_INDEX_SHIP_PAYMENT_TERM)!=null &&
        (!"-1".equals(recToMapping.get(COLUMN_INDEX_SHIP_PAYMENT_TERM)))){
        String srn=
            (String)newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO");

        StringBuffer sbGetYear=new StringBuffer();

        sbGetYear.append("select a.PROD_YEAR,b.PROD_SC_PRC_TRM,b.PROD_PYT_TRM,b.PROD_SC_DEST ");
        sbGetYear.append("from prod_head a,production b ");
        sbGetYear.append("where a.prod_head_pk=b.prod_head_pk ");
        sbGetYear.append("and b.prod_sc_no='");
        sbGetYear.append(srn);sbGetYear.append("' and b.record_delete_flag='1' and rownum=1");


        java.util.Vector vctGetProdHeadYear=
          exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,
         sbGetYear.toString(),1,99999);
         if(vctGetProdHeadYear.size()>0){
           Record tmpProdHeadRec=(Record)vctGetProdHeadYear.get(0);
           txtShip_Ic_Year.setText((tmpProdHeadRec.get(0)==null?"":tmpProdHeadRec.get(0).toString()));
           recToMapping.set("SHIP_PRC_TRM",tmpProdHeadRec.get(1));
           recToMapping.set("SHIP_PRX_TERM_DEST",tmpProdHeadRec.get(3));
           recToMapping.set(COLUMN_INDEX_SHIP_PAYMENT_TERM,tmpProdHeadRec.get(2));
         }

        StringBuffer sb=new StringBuffer();
        sb.append("select * from shipmark where shipmark.SHIPMARK_BYMKR_SEQ=");
        sb.append("(select prod_head.PROD_BUYER from prod_head,production ");
        sb.append("where prod_head.prod_head_pk=production.prod_head_pk ");
        sb.append("and production.prod_sc_no='");
        sb.append(srn);
        sb.append("' and rownum=1)");
        sb.append(" and record_delete_flag='1' and rownum=1");
        java.util.Vector vctShipMark=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
         util.PublicVariable.USER_RECORD,sb.toString(),1,99999);
        if(vctShipMark.size()>0){
              Record recShipMarkObj=(Record)vctShipMark.get(0);
              String mainMark=((recShipMarkObj.get(2)==null)?"":(String)recShipMarkObj.get(2));
              String sideMark=((recShipMarkObj.get(3)==null)?"":(String)recShipMarkObj.get(3));


              newtimes.production.gui.prodmaintain.PnlRspShowMark pnlshowmark=
                  new newtimes.production.gui.prodmaintain.PnlRspShowMark(mainMark,sideMark);
              pnlshowmark.next();//force text area data set to storeMap of the responsible object.

            txtareaShippingMark.setText(
                  (String)pnlshowmark.storedMap.get(pnlshowmark.KEY_TEXT_AREA_DATA)
                  );
        }
      }
      if("-1".equals((String)recToMapping.get(COLUMN_INDEX_SHIP_PAYMENT_TERM))){
        recToMapping.set(COLUMN_INDEX_SHIP_PAYMENT_TERM,null);
      }
     //if l/c buyer is blnak,automatically get to default for it
     if(recToMapping.get("rick_of")==null ||recToMapping.get("rick_of").toString().trim().length()==0){
       //get L/C buyer name and address
       String srn=null;
       StringBuffer sb=new StringBuffer();
       if(lblTItleBar.getText().indexOf("ADD SHIP MASTER BY S/C:")!=-1){
          srn=(String)newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO");
          sb.append("select b.BYMKR_NAME,b.BYMKR_NAME2,b.BYMKR_ADDR1,b.BYMKR_ADDR2,b.BYMKR_ADDR3,b.BYMKR_ADDR4 from buyer_maker b ");
          sb.append("where b.BYMKR_SEQ=(select prod_head.PROD_BUYER from prod_head,production where prod_head.prod_head_pk=production.prod_head_pk ");
          sb.append(" and production.prod_sc_no='");sb.append(srn);sb.append("' and rownum=1)");
       }else{
         srn=(String)recToMapping.get("ship_no");
         sb.append("select b.BYMKR_NAME,b.BYMKR_NAME2,b.BYMKR_ADDR1,b.BYMKR_ADDR2,b.BYMKR_ADDR3,b.BYMKR_ADDR4 ");
         sb.append("from buyer_maker b where b.BYMKR_SEQ=(select prod_head.PROD_BUYER from prod_head where prod_head.prod_head_pk=");
         sb.append("(select prod_head_pk from ship_sc where ship_no='");
         sb.append(srn);sb.append("'  and record_delete_flag='1' and rownum=1))");

       }


       java.util.Vector vctLcBuyer=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,sb.toString(),1,99999);
       if(vctLcBuyer!=null && vctLcBuyer.size()>0){
        Record recLcBuyer=(Record)vctLcBuyer.get(0);
        StringBuffer sbLcBuyer=new StringBuffer();
        for(int i=0;i<6;i++){
          if(recLcBuyer.get(i)!=null && recLcBuyer.get(i).toString().trim().length()>0){
            if(sbLcBuyer.length()>0)sbLcBuyer.append("\n");
            sbLcBuyer.append(recLcBuyer.get(i).toString().trim());
          }
        }
        txtRiskOf.setText(sbLcBuyer.toString());
       }

     }


      Object vftxtSRNDesc=
          exgui.verification.CellFormat.getOrdinaryField(2000);
       dataBoundGUIs.add(
         new exgui.DataBindTextWithChecker(
            txtShipSRNremark,"SHIP_SRN_DESC",
            recToMapping.get("SHIP_SRN_DESC"),2000,
            (exgui.Object2String)vftxtSRNDesc,
            (exgui.ultratable.CellTxtEditorFormat)vftxtSRNDesc)
       );


    Object vftxtSHIP_MANUFACTURE=
        exgui.verification.CellFormat.getOrdinaryField(1000);
     dataBoundGUIs.add(
       new exgui.DataBindTextWithChecker(
          txtShipManufacture,"SHIP_MANUFACTURE",
          recToMapping.get("SHIP_MANUFACTURE"),1000,
          (exgui.Object2String)vftxtSHIP_MANUFACTURE,
          (exgui.ultratable.CellTxtEditorFormat)vftxtSHIP_MANUFACTURE)
     );
    Object vftxtIcDescVfy=
        exgui.verification.CellFormat.getOrdinaryField(5000);
     dataBoundGUIs.add(
      new exgui.DataBindTextWithChecker(jtaconsignee,
                                  "SHIP_NTFE_CONSIGNEE",
                                  recToMapping.get("SHIP_NTFE_CONSIGNEE"),1000,
                                  (exgui.Object2String)vftxtIcDescVfy,
                                  (exgui.ultratable.CellTxtEditorFormat)vftxtIcDescVfy)
      );


       /*
      Object objshipGF=recToMapping.get("SHIP_GF");
      if(objshipGF==null||objshipGF.toString().equalsIgnoreCase("G")){
        rb_GOH.setSelected(true);
      }else{
        rb_FLAT.setSelected(true);
      }*/
      index_of_bill2=dataBoundGUIs.size();
      slkByrMkr_Bill2.init(
        "SHIP_BILL_TO",recToMapping.get("SHIP_BILL_TO"),slkByrMkr_Bill2.TYPE_BUYER,false);
      slkByrMkr_Bill2.setSelectingCenter(newtimes.shipping_admin.ShippingAdmin_Const.CurrentWorkingCenterCode);
      dataBoundGUIs.add(slkByrMkr_Bill2);

      index_of_ship2=dataBoundGUIs.size();
      slkByrMkrShip2.init(
        "SHIP_SHIP_TO",recToMapping.get("SHIP_SHIP_TO"),slkByrMkrShip2.TYPE_BUYER,false);
      slkByrMkrShip2.setSelectingCenter(newtimes.shipping_admin.ShippingAdmin_Const.CurrentWorkingCenterCode);
      dataBoundGUIs.add(slkByrMkrShip2);

      slkByrMkrXprFwd.init(
        "SHIP_FRWRDR",recToMapping.get("SHIP_FRWRDR"),
        slkByrMkrXprFwd.TYPE_SHIPPING,false);
      slkByrMkrXprFwd.setSelectingCenter(newtimes.shipping_admin.ShippingAdmin_Const.CurrentWorkingCenterCode);
      dataBoundGUIs.add(slkByrMkrXprFwd);

      slkByrMkrXprAgnt.init(
        "SHIP_EXPORT_AGENT",recToMapping.get("SHIP_EXPORT_AGENT"),
        slkByrMkrXprAgnt.TYPE_SHIPPING,false);
      slkByrMkrXprAgnt.setSelectingCenter(newtimes.shipping_admin.ShippingAdmin_Const.CurrentWorkingCenterCode);
      dataBoundGUIs.add(slkByrMkrXprAgnt);


      java.util.Vector vctCountry=newtimes.preproduction.guis.tempProperties.tmpCountries;
      java.util.Vector vctSzn=newtimes.preproduction.guis.tempProperties.tmpSeason;
      java.util.Vector vctDivisions=newtimes.preproduction.guis.tempProperties.tmpDivision;
      java.util.Vector shipPrxTrm=newtimes.preproduction.guis.tempProperties.tmpPriceTerm;

      exgui.DataBindJCombobox DbJcbxcbxShipPrcTerm =
        new exgui.DataBindJCombobox(cbxShipPrcTerm,
                                    "SHIP_PRC_TRM",
                                    shipPrxTrm,
                                    "PRC_TRM","PRC_TRM",
                                    recToMapping.get("SHIP_PRC_TRM"),"N/A",null);

   dataBoundGUIs.add(DbJcbxcbxShipPrcTerm);

    //org init ship value is
     if(!lblShipStaff.isVisible() && recToMapping.get("SHIP_OCEAN_AIR")==null ){
      //s/c no is stored at "newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO")"
      String sc_no=(String)newtimes.shipping_admin.ShippingAdmin_Const.SHIPPING_EDITING_HEAD_RECORD.get("SHIP_NO");
      StringBuffer sb=new StringBuffer();
      sb.append("select nvl(style.STY_RECFM_SHIP,style.STY_ORIG_WAY) as ship_way ");
      sb.append("  from style,production where ");
      sb.append(" style.PROD_HEAD_PK= production.prod_head_pk ");
      sb.append(" and production.prod_sc_no='");
      sb.append(sc_no);sb.append("'  and style.record_delete_flag='1' and rownum=1  order by style.sty_seq");
      Record rectestShipStyle=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,sb.toString(),1,99999).get(0);
      /*
       String orgShipWay=(String)shippingWayHm.get(
         rectestShipStyle.get(0).toString().toUpperCase()
      );*/
       String defaultSthipWay=(String)rectestShipStyle.get(0);
       recToMapping.set("SHIP_OCEAN_AIR",(defaultSthipWay==null)?"S":defaultSthipWay.toUpperCase());

       //recToMapping.set("SHIP_OCEAN_AIR","S");

     }

    exgui.DataBindJCombobox DbJcbxcbxShipOcieanAir =
        new exgui.DataBindJCombobox(cbxShipOcieanAir,
                                    "SHIP_OCEAN_AIR",
                                    newtimes.preproduction.guis.tempProperties.tempShipModes,
                                    "SHIP_MODE_NAME",
                                    "SHIP_MODE_CODE",
                                    recToMapping.get("SHIP_OCEAN_AIR"));
   dataBoundGUIs.add(DbJcbxcbxShipOcieanAir);

    exgui.DataBindJCombobox DbJcbxcbxShipEtaTo =
        new exgui.DataBindJCombobox(
        cbxShipEtaTo,"SHIP_ETA_TO",
        vctCountry,"CNTY_NAME","CNTY_NAME",
        recToMapping.get("SHIP_ETA_TO"),"N/A",null);
   dataBoundGUIs.add(DbJcbxcbxShipEtaTo);

    exgui.DataBindJCombobox DbJcbxcbxShipEtdEx =
        new exgui.DataBindJCombobox(
          cbxShipEtdEx,"SHIP_ETD_EX",
          vctCountry,"CNTY_NAME",
          "CNTY_NAME",
          recToMapping.get("SHIP_ETD_EX"),"N/A",null);
   dataBoundGUIs.add(DbJcbxcbxShipEtdEx);

    dbCbxShipOrg =
        new exgui.DataBindJCombobox(
         cbxShipOrgCnty,
         "SHIP_CNTY_ORIG",
         vctCountry,
         "CNTY_NAME",
         "CNTY_NAME",
         recToMapping.get("SHIP_CNTY_ORIG"),
         "N/A",null);
   dataBoundGUIs.add(dbCbxShipOrg);

     java.util.Vector vctDivs=vctDivisions;

   if(newtimes.shipping_admin.ShippingAdmin_Const.IS_LORAN_MODE){
     cbx_IC_Szn.setEditable(true);
     exgui.DataBindEditableJCombobox DbJcbxcbx_IC_Szn =
         new exgui.DataBindEditableJCombobox(
          cbx_IC_Szn,"SHIP_IC_SEA",
          vctSzn,
          "SEA_NAME",
          "SEA_NAME",
          recToMapping.get("SHIP_IC_SEA"),
          "N/A",null,25);
    dataBoundGUIs.add(DbJcbxcbx_IC_Szn);

   }else{
     exgui.DataBindJCombobox DbJcbxcbx_IC_Szn =
         new exgui.DataBindJCombobox(
          cbx_IC_Szn,"SHIP_IC_SEA",
          vctSzn,
          "SEA_NAME",
          "SEA_NAME",
          recToMapping.get("SHIP_IC_SEA"),
          "N/A",null);
    dataBoundGUIs.add(DbJcbxcbx_IC_Szn);
   }
    index_of_division=dataBoundGUIs.size();
    exgui.DataBindJCombobox DbJcbxcbx_IC_Div =
        new exgui.DataBindJCombobox(
         cbx_IC_Div,"SHIP_IC_DIV",
         vctDivs,"DIV_NAME",
         "DIV_CODE",
         recToMapping.get("SHIP_IC_DIV"),
         "N/A",null);
    dataBoundGUIs.add(DbJcbxcbx_IC_Div);

    dataBoundGUIs.add(//new exgui.DataBindEditableJCombobox(
                new exgui.DataBindJCombobox(
                cbxPriceTermDest,
                "ship_prx_term_dest",
                newtimes.shipping_admin.ShippingAdmin_Const.DESTINATIONS,
                "dest_name",
                "dest_name", recToMapping.get("ship_prx_term_dest"),"N/A",null));//,20));


                java.util.Vector depVects=
                    (java.util.Vector)newtimes.preproduction.guis.tempProperties.tmpH_tbl_CenterDepMap.get(
                    util.PublicVariable.OPERATTING_CENTER);
   if(cbxShipDep.isVisible()){
               dataBoundGUIs.add(//ship -dep,for future salse shift dep but invoice devide
                  new exgui.DataBindJCombobox(
                  cbxShipDep,
                  "ship_dep",
                  depVects,
                  "dep_name",
                  "dep_code", recToMapping.get("ship_dep")));//,20));
   }

   /*
   java.util.Vector recPrxTerm=newtimes.preproduction.guis.tempProperties.tmpPriceTerm;
     exgui.DataBindJCombobox DbJcbxjcbxScPrxTerm= new exgui.DataBindJCombobox(
                    cbxPriceTerm, "SHIP_PRX_TERM", recPrxTerm, "PRC_TRM",
                    "PRC_TRM", recToMapping.get("SHIP_PRX_TERM"));//,"",null);
    dataBoundGUIs.add(DbJcbxjcbxScPrxTerm);*/

    java.util.Vector recPaymentTerm=
        newtimes.preproduction.guis.tempProperties.tmpPaymentTerms;
    /*
    exgui.DataBindJCombobox DbJcbxjcbxPaymentTerm=
        new exgui.DataBindJCombobox(
        cbxPaymentTerm, "SHIP_PAYMENT_TERM", recPaymentTerm, "PYT_TRM",
        "PYT_TRM", recToMapping.get("SHIP_PAYMENT_TERM"),"N/A",null);*/
    cbxPaymentTerm.setEditable(true);
    exgui.DataBindEditableJCombobox  DbJcbxjcbxPaymentTerm=
      new exgui.DataBindEditableJCombobox(
      cbxPaymentTerm, "SHIP_PAYMENT_TERM", recPaymentTerm, "PYT_TRM",
      "PYT_TRM", recToMapping.get("SHIP_PAYMENT_TERM"),"",null,200);

    dataBoundGUIs.add(DbJcbxjcbxPaymentTerm);



    int i=0;
    if(recordColumnsToCopy==null){
      recordColumnsToCopy=new String[dataBoundGUIs.size()+1];//add for ship_GF column
      for (; i < dataBoundGUIs.size(); i++) {
       recordColumnsToCopy[i]=
           ((exgui.DataBindGUIObject)dataBoundGUIs.get(i)).getOrgRecField();
      }
      recordColumnsToCopy[i]="SHIP_GF";
    }
    txtAreaShipExtra.setText(
      (String)recToMapping.get("SHIP_EXTRA_DESC")); //this field is only allow to modify by another gui

    dataBoundGUIs.add(
         new exgui.DataBindJCombobox(cbxProfitCenter,
                              "SHIP_NTFE_MID",
                              newtimes.preproduction.guis.tempProperties.tmpOffShores,
                              "CEN_NAME","CEN_CODE",
                              recToMapping.get("SHIP_NTFE_MID"),"",null)
    );


    PnlShipExtra.repaint();
    PnlShipExtra.validate();
   }catch(Exception e){
     e.printStackTrace();

   }
  }
  public void doDelete(){
    try{

      if(!exgui.verification.VerifyLib.showConfirm("Do You Sure To Delete?","Delete Or Not ?"))return;
      if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
        //TPE center,if delete shiphead,have to get delete reason.
        DlgShipHeadDeleteReason dlg = new DlgShipHeadDeleteReason(
            util.PublicVariable.APP_FRAME,"Delete SRN HEAD REASON", true, "");
        dlg.setSize(490,260);
        exgui.UIHelper.setToScreenCenter(dlg);
        dlg.show();
        if(dlg.getDialogStatus()==dlg.STATUS_CLOSE_NORMALLY && dlg.txtReason.getText().trim().length()>0){
          String lastReason=dlg.txtReason.getText().trim();
          recToMapping.getFieldName().add("_SHIP_HEAD_DEL_REASON");
          recToMapping.getValueFields().add(lastReason);
        }else{
          exgui.verification.VerifyLib.showAlert("To Delete Ship Head,You Have To Input Reason",
                                                 "Must Input Delete Reason");
          return;
        }

      }
      isProcessingExit = false;
      util.MiscFunc.showProcessingMessage();
      super.doDelete();



      isProcessingExit = false;
      isProcessingDelete=true;
      util.MiscFunc.hideProcessingMessage();
      processhandler.template.Properties.getCenteralControler().goBack();
    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error In Deleting Error","Delete Fail");
    }
  }
  public boolean gui2Record(){
    if(isProcessingExit && lblTItleBar.getText().indexOf("ADD SHIP MASTER BY S/C:")!=-1){
      return true;
    }
    if(!super.gui2Record())return false;
    try{
      /*
      //avoid radio box check.
      Object orgShipGfValue=recToMapping.get("ship_gf");
      if (rb_FLAT.isSelected()) {
        recToMapping.set("SHIP_GF", "F");
      } else {
        recToMapping.set("SHIP_GF", "G");
      }//if org is null,also copy to record-cloned-for-check.
      if(orgShipGfValue==null && recClonedForCheck.get("ship_gf")==null){
        recClonedForCheck.set("ship_gf",recToMapping.get("ship_gf"));
      }
      */
      //test if ETD date is out of range in system value data.

      Record recSys=(Record)exgui2.CONST.BASIC_MAIN_EJB.getDatas(
        util.PublicVariable.USER_RECORD,
        "select PLAN_DEL_BGN, PLAN_DEL_END from system_default_value where center='"+CenterCode+"' and record_delete_flag='1' ",1,1).get(0);
       Object etdFrom=recSys.get(0);
       Object etdEnd=recSys.get(1);
       if(etdFrom==null || etdEnd==null){
         exgui.verification.VerifyLib.showAlert("ETD Range Not Assigned,Please Contact System Manager To Assigne \"ETD DEL Range\" in System Default value Unit",
                                                "ETD RANGE NOT ASSIGNED");
         return false;
       }
      Object objShipEtdDate=recToMapping.get("ship_etd_date");
      if(objShipEtdDate==null){
        exgui.verification.VerifyLib.showAlert("Please Assign ETD DATE","Please Assign ETD DATE");
        txtShipETDdate.grabFocus();
        return false;
      }
      //System.out.println("etdFrom class type is :"+etdFrom.getClass().getName());
      //if(isProcessingExit)return true;
      if(isProcessingDelete)return true;

      if(!isProcessingExit && (((java.util.Date)etdFrom).getTime()>((java.util.Date)objShipEtdDate).getTime() ||
         ((java.util.Date)etdEnd).getTime()<((java.util.Date)objShipEtdDate).getTime())){
        exgui.verification.VerifyLib.showAlert(
         "ETD Date Should Between:"+dateformat.format(etdFrom)+"~"+dateformat.format(etdEnd) ,"ETD Date Out Of Range");
         return false;
      }

    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
    return true;
  }
  protected void jbInit() throws java.lang.Exception {
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    border2 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140)),"EXTRA");
    border3 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border3,"EXTRA");
    //lblTitleBar.setText("Shipping SRN ADD");
    //lblTitleBar.setBounds(new Rectangle(0, 4, 801, 25));
    titledBorder3 = new TitledBorder("");
    border4 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(98, 98, 109),new Color(141, 141, 156));
    titledBorder4 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156)),"SHIPPING MARK");
    border5 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(141, 141, 156));
    titledBorder5 = new TitledBorder(border5,"SRN DESCRIPTION");
    titledBorder6 = new TitledBorder("");
    border6 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder7 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"L/C Buyer");
    border7 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder8 = new TitledBorder(border7,"SPECIAL INSTRUCTION");
    titledBorder9 = new TitledBorder("");
    border8 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder10 = new TitledBorder(border8,"MANUFACTURE BY");

    this.setLayout(null);
    /**@todo Implement this processhandler.template.PnlFieldsEditor abstract method*/
    jLabel23.setBounds(new Rectangle(349, 37, 60, 20));
    jLabel23.setText(" Season :");
    jLabel23.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel23.setOpaque(true);
    jLabel23.setForeground(new Color(10, 36, 106));
    jLabel23.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel23.setBackground(new Color(143, 143, 188));
    jPanel3.setBounds(new Rectangle(1, 364, 766, 69));
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(204, 204, 225));
    jPanel3.setBorder(BorderFactory.createTitledBorder(" Inspection Certificate "));
    jLabel25.setBounds(new Rectangle(350, 16, 41, 20));
    jLabel25.setText(" Date :");
    jLabel25.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel25.setOpaque(true);
    jLabel25.setForeground(Color.white);
    jLabel25.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel25.setBackground(new Color(143, 143, 188));
    //txtDes.setBounds(new Rectangle(167, 240, 209, 20));
    //txtTo.setBounds(new Rectangle(583, 33, 180, 20));
    //txtVia.setBounds(new Rectangle(583, 79, 180, 20));
    jLabel121.setBackground(new Color(143, 143, 188));
    jLabel121.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel121.setForeground(Color.white);
    jLabel121.setOpaque(true);
    jLabel121.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel121.setText(" Division :");
    jLabel121.setBounds(new Rectangle(561, 15, 63, 20));
    jLabel110.setBackground(new Color(143, 143, 188));
    jLabel110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel110.setForeground(Color.white);
    jLabel110.setOpaque(true);
    jLabel110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel110.setText(" Factory INV :");
    jLabel110.setBounds(new Rectangle(7, 16, 89, 20));
    jPanel1.setBackground(new Color(202, 202, 225));
    jPanel1.setBorder(border1);
    jPanel1.setBounds(new Rectangle(1, 29, 766, 70));
    jPanel1.setLayout(null);
    jLabel26.setBackground(new Color(143, 143, 188));
    jLabel26.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel26.setForeground(new Color(10,36,106));
    jLabel26.setOpaque(true);
    jLabel26.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel26.setText(" Ship to :");
    jLabel26.setBounds(new Rectangle(510, 4, 76, 20));
    jLabel19.setBackground(new Color(143, 143, 188));
    jLabel19.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel19.setForeground(new Color(10,36,106));
    jLabel19.setOpaque(true);
    jLabel19.setRequestFocusEnabled(true);
    jLabel19.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel19.setText(" Issue Date :");
    jLabel19.setBounds(new Rectangle(3, 5, 93, 20));
    jLabel27.setBounds(new Rectangle(283, 26, 126, 20));
    jLabel27.setText(" Price Term :");
    jLabel27.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel27.setOpaque(true);
    jLabel27.setForeground(Color.white);
    jLabel27.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel27.setBackground(new Color(143, 143, 188));
    jLabel125.setBounds(new Rectangle(224, 4, 88, 20));
    jLabel125.setText(" Bill to :");
    jLabel125.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel125.setOpaque(true);
    jLabel125.setForeground(new Color(10,36,106));
    jLabel125.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel125.setBackground(new Color(143, 143, 188));
    cbxShipPrcTerm.setBounds(new Rectangle(409, 26, 154, 20));
    cbxShipPrcTerm.setBackground(Color.white);
    txtShipDate.setText("");
    txtShipDate.setBounds(new Rectangle(94, 5, 85, 20));
    jPanel2.setBackground(new Color(204, 204, 225));
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(1, 98, 766, 169));
    jPanel2.setLayout(null);
    //cmboExpFowr.setBounds(new Rectangle(322, 36, 117, 20));
    //cmboExpFowr.setBackground(Color.white);
    jLabel126.setBackground(new Color(143, 143, 188));
    jLabel126.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel126.setForeground(new Color(10,36,106));
    jLabel126.setOpaque(true);
    jLabel126.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel126.setText(" Export Forwarder :");
    jLabel126.setBounds(new Rectangle(344, 36, 111, 20));
    jLabel117.setBounds(new Rectangle(2, 90, 58, 75));
    jLabel117.setText(" Vessel :");
    jLabel117.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel117.setOpaque(true);
    jLabel117.setForeground(new Color(10,36,106));
    jLabel117.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel117.setBackground(new Color(143, 143, 188));
    jLabel9.setBounds(new Rectangle(485, 6, 56, 20));
    jLabel9.setText(" Agent :");
    jLabel9.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel9.setOpaque(true);
    jLabel9.setForeground(Color.white);
    jLabel9.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel9.setBackground(new Color(143, 143, 188));
    jLabel127.setBounds(new Rectangle(2, 36, 85, 20));
    jLabel127.setText("Export Agent :");
    jLabel127.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel127.setOpaque(true);
    jLabel127.setForeground(new Color(10,36,106));
    jLabel127.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel127.setBackground(new Color(143, 143, 188));
    txtMAWB.setBounds(new Rectangle(583, 171, 180, 20));
    txtMAWB.setBounds(new Rectangle(554, 66, 205, 20));
    jLabel20.setBackground(new Color(143, 143, 188));
    jLabel20.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel20.setForeground(Color.white);
    jLabel20.setOpaque(true);
    jLabel20.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel20.setText(" Ocean / Air :");
    jLabel20.setBounds(new Rectangle(1, 65, 81, 20));
    jLabel115.setBackground(new Color(143, 143, 188));
    jLabel115.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel115.setForeground(Color.white);
    jLabel115.setOpaque(true);
    jLabel115.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel115.setText(" HAWB / HBL# :");
    jLabel115.setBounds(new Rectangle(181, 67, 103, 20));
    txtFLT.setBounds(new Rectangle(583, 194, 180, 20));
    txtFLT.setBounds(new Rectangle(330, 91, 164, 20));
    jLabel10.setBackground(new Color(143, 143, 188));
    jLabel10.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel10.setForeground(Color.white);
    jLabel10.setOpaque(true);
    jLabel10.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel10.setText(" L / C No. :");
    jLabel10.setBounds(new Rectangle(3, 7, 59, 20));
    //txtAgent.setBounds(new Rectangle(214, 125, 180, 20));
    //txtAgent.setBounds(new Rectangle(552, 4, 209, 20));
    txtHAWB.setBounds(new Rectangle(583, 148, 180, 20));
    txtHAWB.setBounds(new Rectangle(283, 67, 170, 20));
    //cmboExpAgent.setBounds(new Rectangle(88, 36, 97, 20));
    //cmboExpAgent.setBackground(Color.white);
    jLabel1110.setBackground(new Color(143, 143, 188));
    jLabel1110.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1110.setForeground(new Color(10,36,106));
    jLabel1110.setOpaque(true);
    jLabel1110.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1110.setText("CONT# :");
    jLabel1110.setBounds(new Rectangle(284, 91, 46, 20));
    //cmboOceanAir.setBounds(new Rectangle(356, 4, 109, 20));
    //cmboOceanAir.setBackground(Color.white);
    jLabel1111.setBounds(new Rectangle(460, 67, 94, 20));
    jLabel1111.setText(" MAWB / CBL# :");
    jLabel1111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1111.setOpaque(true);
    jLabel1111.setForeground(Color.white);
    jLabel1111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1111.setBackground(new Color(143, 143, 188));
    jLabel112.setBounds(new Rectangle(282, 143, 129, 20));
    jLabel112.setText(" Port Of Discharge :");
    jLabel112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel112.setOpaque(true);
    jLabel112.setForeground(new Color(10,36,106));
    jLabel112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel112.setBackground(new Color(143, 143, 188));
    //txtLC.setBounds(new Rectangle(214, 102, 180, 20));
    //txtLC.setBounds(new Rectangle(61, 4, 209, 20));
    txtShipLC.setBounds(new Rectangle(62, 7, 170, 20));
    cbxShipOcieanAir.setBounds(new Rectangle(82, 65, 96, 20));
    jPanel4.setBackground(new Color(204, 204, 225));
    jPanel4.setBorder(BorderFactory.createEtchedBorder());
    jPanel4.setDebugGraphicsOptions(0);
    jPanel4.setBounds(new Rectangle(1, 292, 766, 70));
    jPanel4.setLayout(null);
    jLabel113.setBackground(new Color(143, 143, 188));
    jLabel113.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel113.setForeground(new Color(10,36,106));
    jLabel113.setOpaque(true);
    jLabel113.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel113.setText(" Ex :");
    jLabel113.setBounds(new Rectangle(254, 270, 35, 20));
    jLabel11.setBounds(new Rectangle(130, 270, 39, 20));
    jLabel11.setText("ETA");
    jLabel11.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel11.setOpaque(true);
    jLabel11.setForeground(new Color(10,36,106));
    jLabel11.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel11.setBackground(new Color(143, 143, 188));
    txtShipETDdate.setText("");
    txtShipETDdate.setBounds(new Rectangle(45, 270, 80, 20));
    jLabel17.setBounds(new Rectangle(548, 270, 55, 20));
    jLabel17.setText(" Original:");
    jLabel17.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel17.setOpaque(true);
    jLabel17.setForeground(new Color(10,36,106));
    jLabel17.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel17.setBackground(new Color(143, 143, 188));
    jLabel15.setBounds(new Rectangle(2, 270, 43, 20));
    jLabel15.setText(" * ETD:");
    jLabel15.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel15.setOpaque(true);
    jLabel15.setForeground(new Color(10,36,106));
    jLabel15.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel15.setBackground(new Color(143, 143, 188));
    txtShipETAdate.setText("");
    txtShipETAdate.setBounds(new Rectangle(168, 270, 81, 20));
    jLabel119.setBackground(new Color(143, 143, 188));
    jLabel119.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel119.setForeground(new Color(10,36,106));
    jLabel119.setOpaque(true);
    jLabel119.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel119.setText(" To :");
    jLabel119.setBounds(new Rectangle(402, 270, 26, 20));
    cbxShipEtaTo.setBounds(new Rectangle(428, 270, 112, 20));
    cbxShipEtdEx.setBounds(new Rectangle(289, 270, 106, 20));
    cbxShipOrgCnty.setBounds(new Rectangle(603, 270, 135, 20));
    jLabel12.setBackground(new Color(143, 143, 188));
    jLabel12.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel12.setForeground(Color.white);
    jLabel12.setOpaque(true);
    jLabel12.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel12.setText(" Dimnet WT :");
    jLabel12.setBounds(new Rectangle(5, 5, 79, 20));
    jLabel14.setBackground(new Color(143, 143, 188));
    jLabel14.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel14.setForeground(Color.white);
    jLabel14.setOpaque(true);
    jLabel14.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel14.setText(" TTL Cartons :");
    jLabel14.setBounds(new Rectangle(262, 5, 79, 20));
    jLabel1116.setBounds(new Rectangle(410, 5, 116, 20));
    jLabel1116.setText(" Dimenesion CUFT :");
    jLabel1116.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1116.setOpaque(true);
    jLabel1116.setForeground(Color.white);
    jLabel1116.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1116.setBackground(new Color(143, 143, 188));
    txtCuft.setBounds(new Rectangle(161, 27, 197, 20));
    txtCuft.setBounds(new Rectangle(525, 5, 209, 20));
    txtDimnetWT.setBounds(new Rectangle(214, 286, 180, 20));
    txtDimnetWT.setText("0");
    txtDimnetWT.setHorizontalAlignment(SwingConstants.RIGHT);
    txtDimnetWT.setBounds(new Rectangle(84, 5, 54, 20));
    txtDimentCTN.setBounds(new Rectangle(214, 309, 180, 20));
    txtDimentCTN.setText("0");
    txtDimentCTN.setHorizontalAlignment(SwingConstants.RIGHT);
    txtDimentCTN.setBounds(new Rectangle(341, 5, 54, 20));
    txtDimUnit.setBounds(new Rectangle(167, 490, 54, 20));
    txtDimUnit.setHorizontalAlignment(SwingConstants.RIGHT);
    txtDimUnit.setText("0");
    txtDimUnit.setBounds(new Rectangle(186, 5, 40, 20));
    jLabel1113.setBounds(new Rectangle(143, 5, 44, 20));
    jLabel1113.setText(" Unit :");
    jLabel1113.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1113.setOpaque(true);
    jLabel1113.setForeground(Color.white);
    jLabel1113.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1113.setBackground(new Color(143, 143, 188));
    jLabel128.setBounds(new Rectangle(229, 5, 17, 20));
    jLabel128.setText("KG");
    jLabel128.setForeground(new Color(10,36,106));
    jLabel128.setFont(new java.awt.Font("Dialog", 1, 12));
    txtNetNet.setBounds(new Rectangle(546, 516, 54, 20));
    txtNetNet.setHorizontalAlignment(SwingConstants.RIGHT);
    txtNetNet.setText("0");
    txtNetNet.setBounds(new Rectangle(576, 42, 54, 20));
    jLabel118.setBounds(new Rectangle(261, 43, 57, 20));
    jLabel118.setText(" Net WT :");
    jLabel118.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel118.setOpaque(true);
    jLabel118.setForeground(new Color(10,36,106));
    jLabel118.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel118.setBackground(new Color(143, 143, 188));
    jLabel1117.setBackground(new Color(143, 143, 188));
    jLabel1117.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1117.setForeground(new Color(10,36,106));
    jLabel1117.setOpaque(true);
    jLabel1117.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1117.setText(" Net Net WT :");
    jLabel1117.setBounds(new Rectangle(497, 42, 79, 20));
    txtGrossWT.setBounds(new Rectangle(583, 309, 180, 20));
    txtGrossWT.setText("0");
    txtGrossWT.setHorizontalAlignment(SwingConstants.RIGHT);
    txtGrossWT.setBounds(new Rectangle(74, 41, 54, 20));
    jLabel114.setBounds(new Rectangle(6, 41, 70, 20));
    jLabel114.setText(" Gross WT :");
    jLabel114.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel114.setOpaque(true);
    jLabel114.setForeground(new Color(10,36,106));
    jLabel114.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel114.setBackground(new Color(143, 143, 188));
    txtNetWT.setBounds(new Rectangle(583, 286, 180, 20));
    txtNetWT.setText("0");
    txtNetWT.setHorizontalAlignment(SwingConstants.RIGHT);
    txtNetWT.setBounds(new Rectangle(317, 43, 54, 20));
    jLabel129.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel129.setForeground(new Color(10,36,106));
    jLabel129.setText("KG");
    jLabel129.setBounds(new Rectangle(225, 41, 17, 20));
    txtNetNetUnit.setBounds(new Rectangle(692, 516, 40, 20));
    txtNetNetUnit.setHorizontalAlignment(SwingConstants.RIGHT);
    txtNetNetUnit.setText("0");
    txtNetNetUnit.setBounds(new Rectangle(683, 42, 40, 20));
    jLabel1210.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1210.setForeground(new Color(10,36,106));
    jLabel1210.setText("KG");
    jLabel1210.setBounds(new Rectangle(459, 43, 17, 20));
    jLabel1114.setBackground(new Color(143, 143, 188));
    jLabel1114.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1114.setForeground(new Color(10,36,106));
    jLabel1114.setOpaque(true);
    jLabel1114.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1114.setText(" Unit :");
    jLabel1114.setBounds(new Rectangle(144, 41, 38, 20));
    txtNetUnit.setBounds(new Rectangle(311, 490, 54, 20));
    txtNetUnit.setText("0");
    txtNetUnit.setHorizontalAlignment(SwingConstants.RIGHT);
    txtNetUnit.setBounds(new Rectangle(416, 43, 40, 20));
    txtGrossUnit.setBounds(new Rectangle(311, 490, 54, 20));
    txtGrossUnit.setText("0");
    txtGrossUnit.setHorizontalAlignment(SwingConstants.RIGHT);
    txtGrossUnit.setBounds(new Rectangle(182, 41, 40, 20));
    jLabel1211.setBounds(new Rectangle(726, 42, 17, 20));
    jLabel1211.setText("KG");
    jLabel1211.setForeground(new Color(10,36,106));
    jLabel1211.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1118.setBounds(new Rectangle(647, 42, 37, 20));
    jLabel1118.setText(" Unit :");
    jLabel1118.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1118.setOpaque(true);
    jLabel1118.setForeground(new Color(10,36,106));
    jLabel1118.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1118.setBackground(new Color(143, 143, 188));
    jLabel1115.setBackground(new Color(143, 143, 188));
    jLabel1115.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1115.setForeground(new Color(10,36,106));
    jLabel1115.setOpaque(true);
    jLabel1115.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1115.setText(" Unit :");
    jLabel1115.setBounds(new Rectangle(377, 43, 40, 20));
     jPanel9.setBorder(BorderFactory.createTitledBorder(" CONSIGNEE "));
    //jButton1.setBounds(new Rectangle(38, 601, 153, 24));
    //jButton1.setText("Edit Ship Extra");
    //jPanel5.setBounds(new Rectangle(14, 488, 771, 95));
    //jPanel5.setLayout(null);

    cbx_IC_Szn.setBackground(Color.white);
    cbx_IC_Szn.setBounds(new Rectangle(409, 37, 116, 20));
    txt_FTY_Inv.setBounds(new Rectangle(168, 42, 589, 20));
    txt_FTY_Inv.setBounds(new Rectangle(95, 16, 147, 20));
    cbx_IC_Div.setBackground(Color.white);
    cbx_IC_Div.setBounds(new Rectangle(621, 15, 122, 20));
    txtShip_IC_date.setBounds(new Rectangle(168, 71, 54, 20));
    txtShip_IC_date.setText("");
    txtShip_IC_date.setBounds(new Rectangle(390, 16, 85, 20));
    PnlShipExtra.setBackground(new Color(202, 202, 224));
    PnlShipExtra.setBorder(titledBorder1);
    PnlShipExtra.setBounds(new Rectangle(-1, 790, 768, 147));
    PnlShipExtra.setLayout(null);
    btnEditShipExtra.setBounds(new Rectangle(13, 19, 114, 45));
    btnEditShipExtra.setFont(new java.awt.Font("Dialog", 1, 11));
    btnEditShipExtra.setHorizontalAlignment(SwingConstants.CENTER);
    btnEditShipExtra.setText("<html><body>EDIT<br> EXTRA Data</body></html>");

     java.awt.event.ActionListener toListen[]= btnEditShipExtra.getActionListeners();
    for(int i=0;i<toListen.length;i++){
      btnEditShipExtra.removeActionListener(toListen[i]);
    }
    btnEditShipExtra.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEditShipExtra_actionPerformed(e);
      }
    });
    jScrollPane1.setBounds(new Rectangle(137, 16, 599, 118));
    txtAreaShipExtra.setText("");
    slkByrMkrXprFwd.setBounds(new Rectangle(455, 36, 300, 21));
    slkByrMkr_Bill2.setBounds(new Rectangle(312, 4, 189, 20));
    slkByrMkrShip2.setBounds(new Rectangle(585, 4, 173, 21));
    jScrollPane2.setBounds(new Rectangle(59, 90, 205, 74));
    txtAreaVessel.setLineWrap(true);
    slkByrMkrXprAgnt.setBounds(new Rectangle(86, 36, 245, 21));
    lblTItleBar.setText("SRN DATA");
    lblTItleBar.setBounds(new Rectangle(1, 4, 771, 25));
    cbxPort.setBounds(new Rectangle(410, 143, 166, 21));
    cbxShipAgent.setBounds(new Rectangle(541, 6, 215, 21));
    lblShipStaff.setBounds(new Rectangle(282, 117, 128, 20));
    lblShipStaff.setText(" Shipp Staff Code :");
    lblShipStaff.setHorizontalAlignment(SwingConstants.LEFT);
    lblShipStaff.setOpaque(true);
    lblShipStaff.setForeground(new Color(10,36,106));
    lblShipStaff.setFont(new java.awt.Font("Dialog", 1, 12));
    lblShipStaff.setBackground(new Color(143, 143, 188));
    txtShipStaffCode.setText("");
    txtShipStaffCode.setBounds(new Rectangle(410, 117, 163, 20));
    jPanel5.setBackground(new Color(202, 202, 224));
    jPanel5.setBorder(titledBorder4);
    jPanel5.setDebugGraphicsOptions(0);
    jPanel5.setBounds(new Rectangle(0, 435, 380, 110));
    jPanel5.setLayout(null);
    //jPanel3.add(txtInv, null);
    //jPanel3.add(txtIC_Y, null);
    //jPanel3.add(cmboDiv, null);
    //jPanel3.add(cmboSeason, null);
    jLabel1119.setBackground(new Color(143, 143, 188));
    jLabel1119.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1119.setForeground(new Color(10,36,106));
    jLabel1119.setOpaque(true);
    jLabel1119.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1119.setText(" YEAR :");
    jLabel1119.setBounds(new Rectangle(7, 38, 89, 20));
    txtShip_Ic_Year.setText("");
    txtShip_Ic_Year.setBounds(new Rectangle(95, 38, 147, 20));
    jLabel210.setBounds(new Rectangle(580, 141, 49, 20));
    jLabel210.setText("VIA :");
    jLabel210.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel210.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel210.setOpaque(true);
    jLabel210.setForeground(Color.white);
    jLabel210.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel210.setBackground(new Color(143, 143, 188));
    txtShipVia.setText("");
    txtShipVia.setBounds(new Rectangle(629, 141, 118, 20));
    jPanel7.setBackground(new Color(204, 204, 225));
    jPanel7.setBorder(titledBorder8);
    jPanel7.setBounds(new Rectangle(2, 547, 379, 124));
    jPanel7.setLayout(null);
    PnlSpecInstruc.setBackground(new Color(204, 204, 225));
    PnlSpecInstruc.setBorder(null);
    PnlSpecInstruc.setBounds(new Rectangle(4, 39, 374, 81));
    PnlSpecInstruc.setLayout(borderLayout3);
    txtSpecInstruc.setText("");
    jLabel111.setBounds(new Rectangle(3, 26, 126, 20));
    jLabel111.setText(" PRICE TERM DEST.");
    jLabel111.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel111.setOpaque(true);
    jLabel111.setForeground(new Color(10, 36, 106));
    jLabel111.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel111.setBackground(new Color(143, 143, 188));
    cbxPriceTermDest.setBounds(new Rectangle(129, 26, 154, 20));
    jLabel1112.setBounds(new Rectangle(235, 7, 97, 20));
    jLabel1112.setText(" Loading Port :");
    jLabel1112.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel1112.setOpaque(true);
    jLabel1112.setForeground(Color.white);
    jLabel1112.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel1112.setBackground(new Color(143, 143, 188));
    cbxShipDest.setBounds(new Rectangle(332, 7, 152, 20));
    jLabel116.setBounds(new Rectangle(3, 48, 109, 20));
    jLabel116.setText(" PAYMENT TERM:");
    jLabel116.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel116.setOpaque(true);
    jLabel116.setForeground(Color.white);
    jLabel116.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel116.setBackground(new Color(143, 143, 188));
    cbxPaymentTerm.setBounds(new Rectangle(114, 48, 647, 20));
    PnlRiskOf.setBackground(new Color(204, 204, 225));
    PnlRiskOf.setBorder(titledBorder7);
    PnlRiskOf.setBounds(new Rectangle(383, 547, 389, 123));
    PnlRiskOf.setLayout(null);
    txtRiskOf.setText("");
    Pnl_manufacture.setBackground(new Color(202, 202, 224));
    Pnl_manufacture.setBorder(titledBorder10);
    Pnl_manufacture.setBounds(new Rectangle(384, 677, 389, 110));
    Pnl_manufacture.setLayout(borderLayout5);
    txtShipManufacture.setText("");
    pnl2PlaceShipRmk.setBounds(new Rectangle(4, 36, 370, 65));
    pnl2PlaceShipRmk.setLayout(borderLayout1);
    txtareaShippingMark.setText("");
    txtareaShippingMark.setFont(new java.awt.Font("DialogInput", 0, 12));
    btnCpyShipRmkFromOtherSRN.setBounds(new Rectangle(209, 11, 162, 23));
    btnCpyShipRmkFromOtherSRN.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCpyShipRmkFromOtherSRN.setText("Copy From Other SRN");
    btnCpyShipRmkFromOtherSRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCpyShipRmkFromOtherSRN_actionPerformed(e);
      }
    });
    btnCpySpecialInstructionFromOtherSRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCpySpecialInstructionFromOtherSRN_actionPerformed(e);
      }
    });
    btnCpySpecialInstructionFromOtherSRN.setText("Copy From Other SRN");
    btnCpySpecialInstructionFromOtherSRN.setBounds(new Rectangle(209, 12, 160, 24));
    btnCpySpecialInstructionFromOtherSRN.setFont(new java.awt.Font("Dialog", 1, 11));
    jPanel8.setBackground(new Color(202, 202, 224));
    jPanel8.setBorder(titledBorder5);
    jPanel8.setBounds(new Rectangle(383, 432, 388, 112));
    jPanel8.setLayout(null);
    jPanel6.setBackground(new Color(202, 202, 224));
    jPanel6.setBorder(null);
    jPanel6.setBounds(new Rectangle(6, 35, 372, 65));
    jPanel6.setLayout(borderLayout2);
    txtShipSRNremark.setText("");
    txtShipSRNremark.setFont(new java.awt.Font("DialogInput", 0, 12));
    btnCopySRNDescFromOtherSRN.setBounds(new Rectangle(214, 17, 163, 18));
    btnCopySRNDescFromOtherSRN.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopySRNDescFromOtherSRN.setText("Copy From Other SRN");
    btnCopySRNDescFromOtherSRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopySRNDescFromOtherSRN_actionPerformed(e);
      }
    });
    btnGenDefaultSrnDesc.setBounds(new Rectangle(87, 17, 123, 17));
    btnGenDefaultSrnDesc.setFont(new java.awt.Font("Dialog", 1, 11));
    btnGenDefaultSrnDesc.setText("Default Desc.");
    btnGenDefaultSrnDesc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnGenDefaultSrnDesc_actionPerformed(e);
      }
    });
    /*
    cbxMfxBy.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cbxMfxBy_itemStateChanged(e);
      }
    });*/
    txtShipExtraFtyCashApply.setText("");
    txtShipExtraFtyCashApply.setBounds(new Rectangle(11, 109, 115, 19));
    lblShipExtraFtyCashApply.setFont(new java.awt.Font("Dialog", 1, 11));
    lblShipExtraFtyCashApply.setText("<html><body>EXTRA FTY<br>CASH APPLY</body></html>");
    lblShipExtraFtyCashApply.setBounds(new Rectangle(10, 71, 120, 41));
    lblShipDep.setText("SHIP DEP.");
    lblShipDep.setBounds(new Rectangle(564, 26, 79, 18));
    cbxShipDep.setBounds(new Rectangle(642, 26, 118, 18));
    lblProfitCenter.setBounds(new Rectangle(500, 91, 100, 20));
    lblProfitCenter.setText("PROFIT CENTER");
    lblProfitCenter.setHorizontalAlignment(SwingConstants.LEFT);
    lblProfitCenter.setOpaque(true);
    lblProfitCenter.setForeground(new Color(10,36,106));
    lblProfitCenter.setFont(new java.awt.Font("Dialog", 1, 12));
    lblProfitCenter.setBackground(new Color(143, 143, 188));
    cbxProfitCenter.setBackground(Color.white);
    cbxProfitCenter.setBounds(new Rectangle(599, 91, 144, 20));
    jScrollPane6.setBounds(new Rectangle(6, 32, 377, 84));
    btnCopyRiskOfFromOtherSRN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnCopyRiskOfFromOtherSRN_actionPerformed(e);
      }
    });
    btnCopyRiskOfFromOtherSRN.setText("Copy From Other SRN");
    btnCopyRiskOfFromOtherSRN.setFont(new java.awt.Font("Dialog", 1, 11));
    btnCopyRiskOfFromOtherSRN.setBounds(new Rectangle(218, 12, 163, 18));
    jPanel9.setBackground(new Color(202, 202, 224));
    jPanel9.setBounds(new Rectangle(4, 676, 373, 110));
    jPanel9.setLayout(borderLayout4);
    jtaconsignee.setText("");
    jPanel3.add(jLabel110, null);
    jPanel3.add(txt_FTY_Inv, null);
    jPanel3.add(jLabel121, null);
    jPanel3.add(cbx_IC_Div, null);
    jPanel3.add(jLabel25, null);
    jPanel3.add(txtShip_IC_date, null);
    jPanel3.add(jLabel23, null);
    jPanel3.add(cbx_IC_Szn, null);
    jPanel3.add(txtShip_Ic_Year, null);
    jPanel3.add(jLabel1119, null);
    //this.add(lblTitleBar, null);
    //cbxShipDest.setEditable(true);
    //cbxPort.setEditable(true);
    jPanel1.add(jLabel19, null);
    jPanel1.add(jLabel125, null);
    jPanel1.add(slkByrMkr_Bill2, null);
    jPanel1.add(jLabel26, null);
    jPanel1.add(slkByrMkrShip2, null);
    jPanel1.add(txtShipDate, null);
    jPanel1.add(jLabel116, null);
    jPanel1.add(cbxPaymentTerm, null);
    jPanel1.add(jLabel111, null);
    jPanel1.add(cbxPriceTermDest, null);
    jPanel1.add(jLabel27, null);
    jPanel1.add(cbxShipPrcTerm, null);

    lblShipDep.setVisible(false);
    cbxShipDep.setVisible(false);


    this.add(jPanel2, null);
    this.add(lblTItleBar, null);
    //jPanel2.add(txtLC, null);
    //jPanel2.add(cmboOceanAir, null);
    //jPanel2.add(txtAgent, null);
    //jPanel2.add(cmboExpAgent, null);
    //jPanel2.add(cmboExpFowr, null);
    jPanel2.add(txtShipLC, null);
    jPanel2.add(jLabel10, null);
    this.add(jLabel15, null);
    this.add(txtShipETDdate, null);
    this.add(jLabel11, null);
    this.add(txtShipETAdate, null);
    this.add(jLabel113, null);
    this.add(cbxShipEtdEx, null);
    this.add(jLabel119, null);
    this.add(cbxShipEtaTo, null);
    this.add(jLabel17, null);
    this.add(cbxShipOrgCnty, null);

    jPanel4.add(jLabel12, null);
    jPanel4.add(txtDimnetWT, null);
    jPanel4.add(jLabel1113, null);
    jPanel4.add(txtDimUnit, null);
    jPanel4.add(jLabel128, null);
    jPanel4.add(jLabel1116, null);
    jPanel4.add(txtDimentCTN, null);
    jPanel4.add(jLabel14, null);
    jPanel4.add(txtCuft, null);
    jPanel4.add(jLabel1115, null);
    jPanel4.add(jLabel114, null);
    jPanel4.add(txtGrossWT, null);
    jPanel4.add(jLabel1114, null);
    jPanel4.add(txtGrossUnit, null);
    jPanel4.add(jLabel129, null);
    jPanel4.add(jLabel118, null);
    jPanel4.add(txtNetWT, null);
    jPanel4.add(txtNetUnit, null);
    jPanel4.add(jLabel1210, null);
    jPanel4.add(jLabel1117, null);
    jPanel4.add(txtNetNet, null);
    jPanel4.add(jLabel1118, null);
    jPanel4.add(txtNetNetUnit, null);
    jPanel4.add(jLabel1211, null);
    this.add(jPanel3, null);
    this.add(jPanel4, null);
    //this.add(jPanel5, null);
    //this.add(jButton1, null);
    PnlShipExtra.add(jScrollPane1, null);
    PnlShipExtra.add(btnEditShipExtra, null);
    this.add(jPanel9, null);
    jPanel9.add(jScrollPane8, BorderLayout.CENTER);
    jScrollPane8.getViewport().add(jtaconsignee, null);
    jScrollPane1.getViewport().add(txtAreaShipExtra, null);
    if(util.PublicVariable.OPERATTING_CENTER.equals("001")){
      PnlShipExtra.add(txtShipExtraFtyCashApply, null);
      PnlShipExtra.add(lblShipExtraFtyCashApply, null);
    }
    this.add(jPanel7, null);
    this.add(jPanel5, null);
    jPanel5.add(pnl2PlaceShipRmk, null);
    pnl2PlaceShipRmk.add(jScrollPane3, BorderLayout.CENTER);
    jScrollPane3.getViewport().add(txtareaShippingMark, null);
    this.add(jPanel1, null);
    jPanel2.add(jLabel117, null);
    jPanel2.add(jScrollPane2, null);
    jPanel2.add(lblShipStaff, null);
    jPanel2.add(jLabel112, null);
    jPanel2.add(cbxPort, null);
    jPanel2.add(txtShipStaffCode, null);
    jPanel2.add(jLabel210, null);
    jPanel2.add(txtShipVia, null);
    jPanel2.add(jLabel1110, null);
    jPanel2.add(txtFLT, null);
    jPanel2.add(txtHAWB, null);
    jPanel2.add(jLabel1111, null);
    jPanel2.add(txtMAWB, null);
    jPanel2.add(jLabel20, null);
    jPanel2.add(cbxShipOcieanAir, null);
    jPanel2.add(jLabel115, null);
    jPanel2.add(jLabel1112, null);
    jPanel2.add(cbxShipDest, null);
    jPanel2.add(jLabel9, null);
    jPanel2.add(cbxShipAgent, null);
    jPanel2.add(jLabel127, null);
    jPanel2.add(slkByrMkrXprAgnt, null);
    jPanel2.add(jLabel126, null);
    jPanel2.add(slkByrMkrXprFwd, null);

    jScrollPane2.getViewport().add(txtAreaVessel, null);
    jPanel7.add(PnlSpecInstruc, null);
    PnlSpecInstruc.add(jScrollPane5, BorderLayout.CENTER);
    jScrollPane5.getViewport().add(txtSpecInstruc, null);
    jPanel7.add(btnCpySpecialInstructionFromOtherSRN, null);
    this.add(Pnl_manufacture, null);
    Pnl_manufacture.add(jScrollPane7, BorderLayout.CENTER);
    this.add(PnlRiskOf, null);
    jScrollPane7.getViewport().add(txtShipManufacture, null);
    this.add(jPanel8, null);
    jPanel8.add(jPanel6, null);
    jPanel6.add(jScrollPane4, BorderLayout.CENTER);
    jPanel8.add(btnCopySRNDescFromOtherSRN, null);
    jPanel8.add(btnGenDefaultSrnDesc, null);
    jScrollPane4.getViewport().add(txtShipSRNremark, null);
    txtAreaShipExtra.setFont(new java.awt.Font("DialogInput", 0, 12));
    txtAreaShipExtra.setEditable(false);
    //addMissGuiFactor();
    jPanel5.add(btnCpyShipRmkFromOtherSRN, null);
    /*
    Pnl_manufacture.add(cbxMfxBy, BorderLayout.NORTH);
    */
    PnlRiskOf.add(jScrollPane6, null);
    PnlRiskOf.add(btnCopyRiskOfFromOtherSRN, null);
    this.add(PnlShipExtra, null);
    jScrollPane6.getViewport().add(txtRiskOf, null);

    if(util.PublicVariable.OPERATTING_CENTER.equals("001") &&
       util.PublicVariable.USER_RECORD.getInt(2)==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
      lblShipDep.setVisible(true);
      cbxShipDep.setVisible(true);
      jPanel1.add(lblShipDep, null);
      jPanel1.add(cbxShipDep, null);
      jPanel2.add(cbxProfitCenter, null);
      jPanel2.add(lblProfitCenter, null);
    }
    cbxPriceTermDest.setUI(new exgui.WideComboBoxUI(300));
    cbxShipDest.setUI(new exgui.WideComboBoxUI(300));
  }
  public void setEnableShipExtraPanel(boolean isEnable){
    PnlShipExtra.setEnabled(isEnable);
    //btnEditShipExtra.setEnabled(isEnable);
    txtAreaShipExtra.setEnabled(isEnable);
    jScrollPane1.setEnabled(isEnable);
  }
  public void doExit() throws Exception{
    try{
      isProcessingExit=true;
      processhandler.template.Properties.getCenteralControler().goBack();
      /*
      processhandler.template.Properties.getCenteralControler().doCommandExecute(
      new newtimes.shipping_admin.process.shiippingmaintain.TgrToQryShipMaster());
      */
    }catch(Exception ie){
      ie.printStackTrace();
    }
  }

 protected void btnEditShipExtra_actionPerformed(ActionEvent e) {
    Object objSRN=recToMapping.get(0);
    if(objSRN==null || objSRN.toString().toUpperCase().startsWith("S")){
      exgui.verification.VerifyLib.showAlert(
      "Before Editing Shipping Extra Data\nPlease Click \"ADD\" Button To Add Shipping Head Data",
      "Pleaes Add Shipp Head Before Editing Extra Data");
      return;
    }
    util.MiscFunc.showProcessingMessage();
    DlgShipExtra dlgXtr=null;
    //tpe have defferent extra edit gui.
    if("001".equals(util.PublicVariable.OPERATTING_CENTER)){
      dlgXtr=new DlgShipExtraTPE(
       processhandler.template.Properties.getMainFrame(),
       "EDIT SHIP EXTRA DATA",true,
       new JcmpPnlShipExtra(),this);
    }else{
      dlgXtr=new DlgShipExtra(
       processhandler.template.Properties.getMainFrame(),
       "EDIT SHIP EXTRA DATA",true,
       new JcmpPnlShipExtra(),this);
    }

    dlgXtr.setSize(new Dimension(650,355));
    util.MiscFunc.hideProcessingMessage();
    dlgXtr.show();

    try{
      //avoid exit checking.
      recClonedForCheck.set("SHIP_EXTRA_DESC",
                            recToMapping.get("SHIP_EXTRA_DESC"));
    }catch(Exception exp){
      exp.printStackTrace();
    }finally{

    }
  }
 protected void copyAndPastRemark(String remarkField,javax.swing.JTextArea txtArea){
   String result=JOptionPane.showInputDialog(
    util.PublicVariable.APP_FRAME,
     "Please Input Numeric part of SRN No:","Copy Ship Remark From Other Ship Head",
     JOptionPane.QUESTION_MESSAGE);
   if(result==null)return;
   if(result.trim().length()==0){
     return;
   }
   if(result.trim().length()!=6){
     exgui.verification.VerifyLib.showAlert("Numberic Of SRN is 6 digits","Numberic Of SRN is 6 digits");
     return;
   }

   //check if s/c exists
   try{
     String resultSearch=
         newtimes.shipping_admin.ShippingAdmin_Const.completeSrnByNum(result);
     if(resultSearch==null){
       exgui.verification.VerifyLib.showAlert("NO Such SRN Number","NO Such SRN Number");
       return;
     }

     util.MiscFunc.showProcessingMessage();
     java.util.Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
     util.PublicVariable.USER_RECORD,
     "select "+remarkField+" from SHIPPING where SHIP_no='"+
      util.MiscFunc.Replace(resultSearch.toUpperCase().trim(),"'","''")+"' and record_delete_flag='1'",
      1,1
     );
     util.MiscFunc.hideProcessingMessage();
     if(vct.size()==0){
       exgui.verification.VerifyLib.showPlanMsg("Sorry,No Such Ship Head","SRN#"+resultSearch+" Not Found");
       return;
     }
     Record recShipRemark=(Record)vct.get(0);
     txtArea.append((recShipRemark.get(0)==null)?"":recShipRemark.get(0).toString());
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
     exgui.verification.VerifyLib.showAlert("Connection Error\nPlease Notify System Manager",
                                            "Connection Error");
   }
 }


 protected void btnCpyShipRmkFromOtherSRN_actionPerformed(ActionEvent e) {
   copyAndPastRemark("SHIP_SHIPPING_RMK",txtareaShippingMark);
  }
 protected void btnCpySpecialInstructionFromOtherSRN_actionPerformed(ActionEvent e) {
   copyAndPastRemark("SPECIAL_INSTURCTION",txtSpecInstruc);
  }

 protected  void btnCopySRNDescFromOtherSRN_actionPerformed(ActionEvent e) {
   copyAndPastRemark("SHIP_SRN_DESC",txtShipSRNremark);
  }
  class CustomMessage extends JPanel {
    JRadioButton btnPanamaType=new JRadioButton("PANAMA",true);
    JRadioButton btnEuroType=new JRadioButton("EUROPE");
     public CustomMessage() {
         super( new BorderLayout(0, 5) );
         add( new JLabel("Please Select Remark Type"), BorderLayout.NORTH );
         JPanel subPanel = new JPanel();
         ButtonGroup group = new ButtonGroup();
         //subPanel.add( new JLabel("Your icon goes here") );
         group.add(btnPanamaType);
         subPanel.add( btnPanamaType );
         group.add(btnEuroType);
         subPanel.add( btnEuroType );
         add( subPanel, BorderLayout.CENTER );
     }

 }

  protected Boolean getDefault_SRN_Remark_Type(){
   CustomMessage myPrxDlg= new CustomMessage();
    int result=
    JOptionPane.showOptionDialog(
        util.PublicVariable.APP_FRAME,
        myPrxDlg,
        "Please Select Remark Type",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        new String[] {"OK","CANCEL"},"OK");

     if(result==JOptionPane.OK_OPTION){
       if (myPrxDlg.btnPanamaType.isSelected()){
         return new Boolean(true);
       }else{
         return new Boolean(false);
       }
     }
     return null;
  }

  void btnGenDefaultSrnDesc_actionPerformed(ActionEvent e) {
     StringBuffer sb=new StringBuffer();
     Boolean result=getDefault_SRN_Remark_Type();
     if(result==null)return;
     if(result.booleanValue()){
       sb.append("TOTAL FOB     : US$ \n");
       sb.append("FREIGHT       : US$ \n");
       sb.append("INSURANCE     : US$ \n");
       sb.append("OTHER CHARGES : US$ \n");
       sb.append("------------------------------------------ \n");
       sb.append("TOTAL CNF     : US$ \n");
     }else{
       //EURO - SRN Description Format.
       sb.append("TOTAL GOOD VALUE    :  US$ \n");
       sb.append("BUYING COMMISSION   :  US$ \n");
       sb.append("OTHER CHARGES       :  US$ \n");
       sb.append("======================================== \n");
       sb.append("TOTAL INVOICE VALUE :  US$ \n");

     }
     txtShipSRNremark.append(sb.toString());
  }
  void btnCopyRiskOfFromOtherSRN_actionPerformed(ActionEvent e) {
    copyAndPastRemark("Rick_of",txtRiskOf);

  }

  /*
  void cbxMfxBy_itemStateChanged(ItemEvent e) {

  }*/
}
