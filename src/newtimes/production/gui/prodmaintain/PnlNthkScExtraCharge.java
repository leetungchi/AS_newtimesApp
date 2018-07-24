package newtimes.production.gui.prodmaintain;

import java.awt.*;
import exgui.*;
import javax.swing.*;
import javax.swing.border.*;
import newtimes.preproduction.buyermakerselect.*;
import java.util.*;
import database.datatype.Record;

public class PnlNthkScExtraCharge
    //extends JPanel {
    extends processhandler.template.PnlFieldsEditor{
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  //JLabel blueBkgWhiteCharLabel1 = new JLabel();
  exgui.BlueBkgWhiteCharLabel  blueBkgWhiteCharLabel1 = new exgui.BlueBkgWhiteCharLabel();
  JPanel PnlScChg = new JPanel();
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  JLabel whiteBkgBlueCharLabel6 = new JLabel();
  JLabel whiteBkgBlueCharLabel7 = new JLabel();
  public JTextField txtXtaChgRmk_1 = new JTextField();//for command executer to focuse on
  JTextField txtXtaChgRmk_2 = new JTextField();
  JTextField txtXtaChgRmk_3 = new JTextField();
  JLabel whiteBkgBlueCharLabel8 = new JLabel();
  JLabel blueBkgWhiteCharLabel7 = new JLabel();
  JLabel blueBkgWhiteCharLabel8 = new JLabel();
  JTextField txtXtaChgFee2 = new JTextField();
  JTextField txtXtaChgFee3 = new JTextField();
  JLabel blueBkgWhiteCharLabel9 = new JLabel();
  JTextField txtXtaChgFee1 = new JTextField();
  TitledBorder titledBorder3;
  Border border2;
  TitledBorder titledBorder4;
  TitledBorder titledBorder5;
  Border border3;
  //JTextField txtScDest = new JTextField();
  //JTextField txtScEndRmk = new JTextField();

  TitledBorder titledBorder6;
  Border border4;
  TitledBorder titledBorder7;
  //JTextField txtCT_Dest = new JTextField();
  Object SCCT_IncludeExclude_Value[]={null,"I","E"};
  String SCCT_IncludeExclude_String[]={"N/A","Include","Exclude"};
  //JComboBox cbxScIncXld = new JComboBox(SCCT_IncludeExclude_String);
  //JComboBox cbxCT_IncXld = new JComboBox(SCCT_IncludeExclude_String);
  Border border5;
  TitledBorder titledBorder8;
  protected int lastCtYPos=139;
  Vector vctCtPanels;
  JLabel whiteBkgBlueCharLabel9 = new JLabel();
  JTextField txtXtaChgRmk_4 = new JTextField();
  JLabel blueBkgWhiteCharLabel10 = new JLabel();
  JTextField txtXtaChgFee4 = new JTextField();
  public PnlNthkScExtraCharge() {
    try {
      jbInit();
      recordColumnsToCopy=null;
      id4ApplicationProperties=this.getClass().getName();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

 protected void jbInit() throws Exception {
    //this.setPreferredSize(new Dimension(780,470));
    titledBorder1 = new TitledBorder("");
    border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"S/C Extra Charge");
    titledBorder3 = new TitledBorder("");
    border2 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder4 = new TitledBorder(border2,"Buyer Data");
    titledBorder5 = new TitledBorder("");
    border3 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"");
    titledBorder6 = new TitledBorder("");
    border4 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder7 = new TitledBorder(border4,"C/T Attributes");
    border5 = BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140));
    titledBorder8 = new TitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,Color.white,Color.white,new Color(103, 101, 98),new Color(148, 145, 140)),"C/T Extra Charge");
    this.setLayout(borderLayout1);
    jPanel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("EXTRA CHARGE");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(0, 1, 780, 27));
    PnlScChg.setFont(new java.awt.Font("SansSerif", 1, 12));
    PnlScChg.setBorder(titledBorder2);
    PnlScChg.setBounds(new Rectangle(4, 32, 749, 98));
    PnlScChg.setLayout(null);
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(184, 26, 65, 23));
    whiteBkgBlueCharLabel6.setText("Remark 2");
    whiteBkgBlueCharLabel7.setText("Remark 3");
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(360, 24, 65, 23));
    txtXtaChgRmk_1.setBounds(new Rectangle(65, 25, 110, 23));
    txtXtaChgRmk_1.setText("");
    txtXtaChgRmk_2.setBounds(new Rectangle(238, 24, 116, 23));
    txtXtaChgRmk_2.setText("");
    txtXtaChgRmk_3.setText("");
    txtXtaChgRmk_3.setBounds(new Rectangle(423, 24, 115, 23));
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(10, 25, 64, 23));
    whiteBkgBlueCharLabel8.setText("Remark 1");
    blueBkgWhiteCharLabel7.setText("Fee 3");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(360, 60, 34, 22));
    blueBkgWhiteCharLabel8.setText("Fee 2");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(184, 62, 36, 22));
    txtXtaChgFee2.setText("");
    txtXtaChgFee2.setBounds(new Rectangle(237, 60, 116, 22));
    txtXtaChgFee3.setText("");
    txtXtaChgFee3.setBounds(new Rectangle(423, 60, 116, 22));
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(8, 61, 41, 22));
    blueBkgWhiteCharLabel9.setText("Fee 1");
    txtXtaChgFee1.setBounds(new Rectangle(65, 61, 108, 22));
    txtXtaChgFee1.setText("");
    jPanel1.setFont(new java.awt.Font("Dialog", 1, 11));
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(546, 24, 70, 23));
    whiteBkgBlueCharLabel9.setText("Remark 4");
    txtXtaChgRmk_4.setBounds(new Rectangle(615, 24, 123, 23));
    txtXtaChgRmk_4.setText("");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(554, 60, 34, 22));
    blueBkgWhiteCharLabel10.setText("Fee 4");
    txtXtaChgFee4.setBounds(new Rectangle(615, 60, 123, 22));
    txtXtaChgFee4.setText("");
    this.add(jPanel1,  BorderLayout.CENTER);
    PnlScChg.add(whiteBkgBlueCharLabel8, null);
    PnlScChg.add(blueBkgWhiteCharLabel9, null);
    PnlScChg.add(txtXtaChgRmk_1, null);
    PnlScChg.add(txtXtaChgFee1, null);
    PnlScChg.add(whiteBkgBlueCharLabel6, null);
    PnlScChg.add(blueBkgWhiteCharLabel8, null);
    PnlScChg.add(txtXtaChgFee2, null);
    PnlScChg.add(whiteBkgBlueCharLabel7, null);
    PnlScChg.add(blueBkgWhiteCharLabel7, null);
    PnlScChg.add(txtXtaChgRmk_3, null);
    PnlScChg.add(txtXtaChgFee3, null);
    PnlScChg.add(txtXtaChgFee4, null);
    PnlScChg.add(txtXtaChgRmk_4, null);
    PnlScChg.add(txtXtaChgRmk_2, null);
    PnlScChg.add(whiteBkgBlueCharLabel9, null);
    PnlScChg.add(blueBkgWhiteCharLabel10, null);
    jPanel1.add(PnlScChg, null);
    jPanel1.add(blueBkgWhiteCharLabel1, null);
    lastCtYPos=140;
    /*
    each C/T Extra chage panel hight is 100 pixel
    pnlCtXtrage1.setBounds(new Rectangle(6, 140, 750, 100));
    pnlCtXtrage2.setBounds(new Rectangle(6, 240, 750, 100));

    jPanel1.add(pnlCtXtrage1, null);
    jPanel1.add(pnlCtXtrage2, null);*/
  }
  public int getFinaCtPosition(){
      return lastCtYPos;
  }
  protected void getCtRecords2Show()throws Exception{
    vctCtPanels=new Vector();
    StringBuffer sb = new StringBuffer();
    sb.append("select a.prod_head_pk,a.prod_ct_seq, ");
    sb.append("b.PROD_BUY_EXTRA1_CHG,b.PROD_BUY_EXTRA1_REMK,");
    sb.append("b.PROD_BUY_EXTRA2_CHG,b.PROD_BUY_EXTRA2_REMK,");
    sb.append("b.PROD_BUY_EXTRA3_CHG,b.PROD_BUY_EXTRA3_REMK,");
    sb.append("b.PROD_BUY_EXTRA4_CHG,b.PROD_BUY_EXTRA4_REMK,");
    sb.append("b.PROD_MKR_EXTRA1_CHG,b.PROD_MKR_EXTRA1_REMK,");
    sb.append("b.PROD_MKR_EXTRA2_CHG,b.PROD_MKR_EXTRA2_REMK,");
    sb.append("b.PROD_MKR_EXTRA3_CHG,b.PROD_MKR_EXTRA3_REMK,");
    sb.append("b.PROD_MKR_EXTRA4_CHG,b.PROD_MKR_EXTRA4_REMK,");
    sb.append("b.RECORD_MODIFY_USER,b.RECORD_MODIFY_date ");
    sb.append("from prod_ct_infor a,production b where  ");
    String sc_no = (String)recToMapping.get("prod_sc_no");
    sb.append(" a.prod_sc_no='");sb.append(sc_no);sb.append("'");
    sb.append(" and a.prod_head_pk=b.prod_head_pk  ");
    sb.append(" and a.record_delete_flag='1' ");
    Vector vct=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
      util.PublicVariable.USER_RECORD,sb.toString(),1,999);
    lastCtYPos=140;
    for(int i=0;i<vct.size();i++){
      Record rec=(Record)vct.get(i);
      PnlCtXtrage pnl=new PnlCtXtrage();
      pnl.setRecord(rec);
      pnl.setPagedDataFactory(this.dbprc);
      pnl.record2Gui();
      pnl.setBounds(new Rectangle(6, lastCtYPos, 750, 100));
      lastCtYPos+=100;
      jPanel1.add(pnl,null);
      vctCtPanels.add(pnl);
    }
  }
  public void record2Gui(){
    try {
      getCtRecords2Show();
      dataBoundGUIs.clear();

      Object vftxtXtaChgRmk_1 = exgui.verification.CellFormat.getOrdinaryField(70);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_1,
          "PROD_BUY_EXTRA1_REMK", recToMapping.get("PROD_BUY_EXTRA1_REMK"), 70,
          (exgui.Object2String) vftxtXtaChgRmk_1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_1)
                        );

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_2,
          "PROD_BUY_EXTRA2_REMK", recToMapping.get("PROD_BUY_EXTRA2_REMK"), 70,
          (exgui.Object2String) vftxtXtaChgRmk_1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_1)
                        );

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_3,
          "PROD_BUY_EXTRA3_REMK", recToMapping.get("PROD_BUY_EXTRA3_REMK"), 70,
          (exgui.Object2String) vftxtXtaChgRmk_1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_1)
                        );

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_4,
          "PROD_BUY_EXTRA4_REMK", recToMapping.get("PROD_BUY_EXTRA4_REMK"), 70,
          (exgui.Object2String) vftxtXtaChgRmk_1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_1)
                        );





//=====================================================================================
      Object vftxtXtaChgFee1 = exgui.verification.CellFormat.
          getDoubleFormatAllowNull(7, 3);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee1,
          "PROD_BUY_EXTRA1_CHG", recToMapping.get("PROD_BUY_EXTRA1_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee1)
                        );



      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee2,
          "PROD_BUY_EXTRA2_CHG", recToMapping.get("PROD_BUY_EXTRA2_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee1)
                        );


      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee3,
          "PROD_BUY_EXTRA3_CHG", recToMapping.get("PROD_BUY_EXTRA3_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee1)
                        );


      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee4,
                         "PROD_BUY_EXTRA4_CHG", recToMapping.get("PROD_BUY_EXTRA4_CHG"), 11,
                         (exgui.Object2String) vftxtXtaChgFee1,
                         (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee1)
                        );


      if (recordColumnsToCopy == null) {
        recordColumnsToCopy = new String[dataBoundGUIs.size()];
        for (int i = 0; i < dataBoundGUIs.size(); i++) {
          recordColumnsToCopy[i] = ((exgui.DataBindGUIObject) dataBoundGUIs.
                                    get(i)).getOrgRecField();


        }
      }
    }catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void doPaste(){
    try{
      database.datatype.Record tmprec =
          (database.datatype.Record) util.ApplicationProperites.getProperties(
        id4ApplicationProperties);
      if(tmprec==null){
        exgui.verification.VerifyLib.showAlert("There Is No Copied Data To Past",
                                               "No Data To Past");
        return;
      }
    recToMapping.set("PROD_SC_INCL_EXCL_QTA",
                     util.ApplicationProperites.getProperties(
        "newtimes.production.gui.prodmaintain.PnlScHead_SC_IncludeExclueCopyValue"));
    recToMapping.set("PROD_CT_INCL_EXCL_QTA",
                     util.ApplicationProperites.getProperties(
        "newtimes.production.gui.prodmaintain.PnlScHead_CT_IncludeExclueCopyValue"));
   //set to application properties
   util.ApplicationProperites.setProperties(id4ApplicationProperties,tmprec);
    //super.doPaste();
    for(int i=0;i<recordColumnsToCopy.length;i++){
      if(recordColumnsToCopy[i].trim().toUpperCase().equals("PROD_SC_NO")){
        continue;
      }
      recToMapping.set(
         recordColumnsToCopy[i],
         tmprec.get(recordColumnsToCopy[i])
      );
    }
    recToMapping.set(
       "prod_sc_dest",
       util.ApplicationProperites.getProperties(id4ApplicationProperties+"_copy_sc_dest"));
    //System.out.println("restore from past:"+util.ApplicationProperites.getProperties(id4ApplicationProperties+"_copy_sc_dest"));
    record2Gui();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  int getIncXldIndex(String str)throws Exception{
    if(str==null) return 0;
    for(int i=1;i<SCCT_IncludeExclude_Value.length;i++){
      if(str.equalsIgnoreCase(SCCT_IncludeExclude_Value[i].toString())) return i;
    }
    throw new Exception("value :"+str+" for PROD_CT_INCL_EXCL_QTA OR PROD_ST_INCL_EXCL_QTA not found");
  }
  public void doUpdate()throws Exception{
    try{
      newtimes.production.ProdMaintain_Properties.setWaitCursor();
      util.MiscFunc.showProcessingMessage();
      super.doUpdate();
      Record recScExt2update=(Record)util.MiscFunc.deepCopy(recToMapping);
      Vector vct2update=new Vector();
      for(int i=0;i<vctCtPanels.size();i++){
            ((PnlCtXtrage)vctCtPanels.get(i)).doUpdate();
            Record rec2update=((PnlCtXtrage)vctCtPanels.get(i)).getEdingRecord();
            rec2update.set("PROD_BUY_EXTRA1_REMK",recScExt2update.get("PROD_BUY_EXTRA1_REMK"));
            rec2update.set("PROD_BUY_EXTRA2_REMK",recScExt2update.get("PROD_BUY_EXTRA2_REMK"));
            rec2update.set("PROD_BUY_EXTRA3_REMK",recScExt2update.get("PROD_BUY_EXTRA3_REMK"));
            rec2update.set("PROD_BUY_EXTRA4_REMK",recScExt2update.get("PROD_BUY_EXTRA4_REMK"));
            rec2update.set("PROD_BUY_EXTRA1_CHG",recScExt2update.get("PROD_BUY_EXTRA1_CHG"));
            rec2update.set("PROD_BUY_EXTRA2_CHG",recScExt2update.get("PROD_BUY_EXTRA2_CHG"));
            rec2update.set("PROD_BUY_EXTRA3_CHG",recScExt2update.get("PROD_BUY_EXTRA3_CHG"));
            rec2update.set("PROD_BUY_EXTRA4_CHG",recScExt2update.get("PROD_BUY_EXTRA4_CHG"));
            if(rec2update.getModifiedFields().size()>0) vct2update.add(rec2update);
      }
      ((newtimes.production.process.prodmaintain.DB_ProdSC)dbprc).updateCtDatas(vct2update);

      javax.swing.SwingUtilities.invokeLater(
       new Runnable(){
        public void run() {
           txtXtaChgRmk_1.grabFocus();
        }
        }
      );

    }catch(Exception e){
      e.printStackTrace();
      util.MiscFunc.hideProcessingMessage();
      exgui.verification.VerifyLib.showAlert("Update Fail!!","Update Fail!!");
      throw e;
    }finally{
      util.MiscFunc.hideProcessingMessage();
            newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

  }
  public void doPrint(){
  }
}
