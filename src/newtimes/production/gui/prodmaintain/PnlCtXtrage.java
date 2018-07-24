package newtimes.production.gui.prodmaintain;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class PnlCtXtrage
    //extends JPanel {
    extends processhandler.template.PnlFieldsEditor{
  JTextField txtXtaChgFee1 = new JTextField();
  JLabel blueBkgWhiteCharLabel9 = new JLabel();
  JLabel whiteBkgBlueCharLabel8 = new JLabel();
  JTextField txtXtaChgRmk_1 = new JTextField();
  JLabel blueBkgWhiteCharLabel7 = new JLabel();
  JLabel blueBkgWhiteCharLabel8 = new JLabel();
  JLabel whiteBkgBlueCharLabel7 = new JLabel();
  JPanel PnlCtExt = new JPanel();
  JTextField txtXtaChgRmk_3 = new JTextField();
  JTextField txtXtaChgFee2 = new JTextField();
  JLabel whiteBkgBlueCharLabel6 = new JLabel();
  JTextField txtXtaChgFee3 = new JTextField();
  JTextField txtXtaChgRmk_2 = new JTextField();
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  JLabel whiteBkgBlueCharLabel9 = new JLabel();
  JTextField txtXtaChgRmk_4 = new JTextField();
  JLabel blueBkgWhiteCharLabel10 = new JLabel();
  JTextField txtXtaChgFee4 = new JTextField();

  public PnlCtXtrage() {
    try {
      jbInit();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
  public void record2Gui(){

    try {
      titledBorder2.setTitle("C/T SEQ:"+recToMapping.getInt(1));
      dataBoundGUIs.clear();

      Object vftxtXtaChgRmk_1 = exgui.verification.CellFormat.getOrdinaryField(
          50);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_1,
          "PROD_MKR_EXTRA1_REMK", recToMapping.get("PROD_MKR_EXTRA1_REMK"), 50,
          (exgui.Object2String) vftxtXtaChgRmk_1,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_1)
                        );

      Object vftxtXtaChgRmk_2 = exgui.verification.CellFormat.getOrdinaryField(
          50);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_2,
          "PROD_MKR_EXTRA2_REMK", recToMapping.get("PROD_MKR_EXTRA2_REMK"), 50,
          (exgui.Object2String) vftxtXtaChgRmk_2,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_2)
                        );
      Object vftxtXtaChgRmk_3 = exgui.verification.CellFormat.getOrdinaryField(
          50);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_3,
          "PROD_MKR_EXTRA3_REMK", recToMapping.get("PROD_MKR_EXTRA3_REMK"), 50,
          (exgui.Object2String) vftxtXtaChgRmk_3,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_3)
                        );

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgRmk_4,
          "PROD_MKR_EXTRA4_REMK", recToMapping.get("PROD_MKR_EXTRA4_REMK"), 50,
          (exgui.Object2String) vftxtXtaChgRmk_3,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgRmk_3)
                        );


      Object vftxtXtaChgFee2 = exgui.verification.CellFormat.
          getDoubleFormatAllowNull(7, 3);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee2,
          "PROD_MKR_EXTRA2_CHG", recToMapping.get("PROD_MKR_EXTRA2_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee2,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee2)
                        );


      Object vftxtXtaChgFee3 = exgui.verification.CellFormat.
          getDoubleFormatAllowNull(7, 3);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee3,
          "PROD_MKR_EXTRA3_CHG", recToMapping.get("PROD_MKR_EXTRA3_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee3,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee3)
                        );

      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee4,
          "PROD_MKR_EXTRA4_CHG", recToMapping.get("PROD_MKR_EXTRA4_CHG"), 11,
          (exgui.Object2String) vftxtXtaChgFee3,
                        (exgui.ultratable.CellTxtEditorFormat) vftxtXtaChgFee3)
                        );


      Object vftxtXtaChgFee1 = exgui.verification.CellFormat.
          getDoubleFormatAllowNull(7, 3);
      dataBoundGUIs.add(new exgui.DataBindTextWithChecker(txtXtaChgFee1,
          "PROD_MKR_EXTRA1_CHG", recToMapping.get("PROD_MKR_EXTRA1_CHG"), 11,
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

 protected void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    border1 = BorderFactory.createEtchedBorder(Color.white,new Color(148, 145, 140));
    titledBorder2 = new TitledBorder(border1,"C/T SEQ:0");
    PnlCtExt.setLayout(null);
    PnlCtExt.setBounds(new Rectangle(3, 0, 749, 88));
    PnlCtExt.setFont(new java.awt.Font("SansSerif", 1, 12));
    PnlCtExt.setBorder(titledBorder2);
    whiteBkgBlueCharLabel7.setBounds(new Rectangle(366, 17, 64, 23));
    whiteBkgBlueCharLabel7.setText("Remark 3");
    blueBkgWhiteCharLabel8.setBounds(new Rectangle(186, 52, 36, 22));
    blueBkgWhiteCharLabel8.setText("Fee 2");
    blueBkgWhiteCharLabel7.setBounds(new Rectangle(366, 52, 34, 22));
    blueBkgWhiteCharLabel7.setText("Fee 3");
    txtXtaChgRmk_1.setText("");
    txtXtaChgRmk_1.setBounds(new Rectangle(58, 17, 121, 23));
    whiteBkgBlueCharLabel8.setText("Remark 1");
    whiteBkgBlueCharLabel8.setBounds(new Rectangle(6, 17, 74, 23));
    blueBkgWhiteCharLabel9.setText("Fee 1");
    blueBkgWhiteCharLabel9.setBounds(new Rectangle(10, 52, 41, 22));
    txtXtaChgFee1.setText("");
    txtXtaChgFee1.setBounds(new Rectangle(58, 52, 121, 22));
    this.setLayout(null);
    txtXtaChgRmk_3.setText("");
    txtXtaChgRmk_3.setBounds(new Rectangle(430, 17, 117, 23));
    txtXtaChgFee2.setText("");
    txtXtaChgFee2.setBounds(new Rectangle(242, 52, 116, 22));
    whiteBkgBlueCharLabel6.setBounds(new Rectangle(186, 17, 69, 23));
    whiteBkgBlueCharLabel6.setText("Remark 2");
    txtXtaChgFee3.setText("");
    txtXtaChgFee3.setBounds(new Rectangle(430, 52, 118, 22));
    txtXtaChgRmk_2.setBounds(new Rectangle(241, 17, 117, 23));
    txtXtaChgRmk_2.setText("");
    whiteBkgBlueCharLabel9.setText("Remark 4");
    whiteBkgBlueCharLabel9.setBounds(new Rectangle(563, 17, 64, 23));
    txtXtaChgRmk_4.setBounds(new Rectangle(627, 17, 117, 23));
    txtXtaChgRmk_4.setText("");
    blueBkgWhiteCharLabel10.setText("Fee 4");
    blueBkgWhiteCharLabel10.setBounds(new Rectangle(563, 52, 34, 22));
    txtXtaChgFee4.setBounds(new Rectangle(627, 52, 118, 22));
    txtXtaChgFee4.setText("");
    PnlCtExt.add(blueBkgWhiteCharLabel9, null);
    PnlCtExt.add(txtXtaChgRmk_1, null);
    PnlCtExt.add(txtXtaChgFee1, null);
    PnlCtExt.add(whiteBkgBlueCharLabel6, null);
    PnlCtExt.add(blueBkgWhiteCharLabel8, null);
    PnlCtExt.add(txtXtaChgRmk_2, null);
    PnlCtExt.add(txtXtaChgFee2, null);
    PnlCtExt.add(whiteBkgBlueCharLabel7, null);
    PnlCtExt.add(blueBkgWhiteCharLabel7, null);
    PnlCtExt.add(txtXtaChgFee3, null);
    PnlCtExt.add(txtXtaChgRmk_3, null);
    PnlCtExt.add(whiteBkgBlueCharLabel9, null);
    PnlCtExt.add(txtXtaChgRmk_4, null);
    PnlCtExt.add(blueBkgWhiteCharLabel10, null);
    PnlCtExt.add(txtXtaChgFee4, null);
    PnlCtExt.add(whiteBkgBlueCharLabel8, null);
    this.add(PnlCtExt, null);
  }
  public database.datatype.Record getEdingRecord(){
    return recToMapping;
  }
  public void doUpdate()throws Exception{
    //super.doUpdate();
    super.gui2Record();
  }
  public void doAddNew()throws Exception{

  }
  public void doPrint()throws Exception{

  }
}
