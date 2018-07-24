package newtimes.production.report;

import java.awt.*;
import javax.swing.*;
import exgui.*;
import java.awt.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class DlgTpeBatchAddNbProdHead extends JDialog {
  JPanel panel1 = new JPanel();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  JTextField txtSrcRefNo = new JTextField();
  JTextField txtBatchNo = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel2 = new BlueBkgWhiteCharLabel();
  JTextField txtItemCount = new JTextField();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel3 = new BlueBkgWhiteCharLabel();
  JButton btnOK = new JButton();
  JButton btnExit = new JButton();
  JScrollPane jScrollPane1 = new JScrollPane();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextArea txtProdPkList = new JTextArea();
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel4 = new BlueBkgWhiteCharLabel();
  JComboBox cbxCreateUser = new JComboBox();
  exgui.DataBindJCombobox dbCbxCreateUser=null;
  public DlgTpeBatchAddNbProdHead(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgTpeBatchAddNbProdHead() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    blueBkgWhiteCharLabel1.setText("SRC PROD REF# :");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(14, 22, 127, 29));
    txtSrcRefNo.setText("");
    txtSrcRefNo.setBounds(new Rectangle(141, 22, 109, 29));
    txtBatchNo.setBounds(new Rectangle(141, 60, 109, 29));
    txtBatchNo.setText("jTextField1");
    txtBatchNo.setText("");
    blueBkgWhiteCharLabel2.setBounds(new Rectangle(14, 60, 127, 29));
    blueBkgWhiteCharLabel2.setText("BATCH # :");
    txtItemCount.setBounds(new Rectangle(141, 98, 109, 29));
    txtItemCount.setText("jTextField1");
    txtItemCount.setText("");
    blueBkgWhiteCharLabel3.setBounds(new Rectangle(14, 98, 127, 29));
    blueBkgWhiteCharLabel3.setText("ITEM COUNT :");
    btnOK.setBounds(new Rectangle(287, 27, 97, 28));
    btnOK.setFont(new java.awt.Font("Dialog", 1, 11));
    btnOK.setForeground(Color.red);
    btnOK.setText("Generate");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnExit.setBounds(new Rectangle(289, 76, 68, 26));
    btnExit.setFont(new java.awt.Font("Dialog", 1, 11));
    btnExit.setText("EXIT");
    btnExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnExit_actionPerformed(e);
      }
    });
    jScrollPane1.setBounds(new Rectangle(15, 221, 366, 202));
    whiteBkgBlueCharLabel1.setText("RETURNED REF #:");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(16, 196, 366, 23));
    txtProdPkList.setText("");
    blueBkgWhiteCharLabel4.setText("CREATE USER :");
    blueBkgWhiteCharLabel4.setBounds(new Rectangle(14, 136, 127, 29));
    cbxCreateUser.setBounds(new Rectangle(140, 136, 246, 29));
    getContentPane().add(panel1);
    panel1.add(blueBkgWhiteCharLabel1, null);
    panel1.add(txtSrcRefNo, null);
    panel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(txtProdPkList, null);
    panel1.add(whiteBkgBlueCharLabel1, null);
    panel1.add(blueBkgWhiteCharLabel2, null);
    panel1.add(txtBatchNo, null);
    panel1.add(blueBkgWhiteCharLabel3, null);
    panel1.add(txtItemCount, null);
    panel1.add(blueBkgWhiteCharLabel4, null);
    panel1.add(cbxCreateUser, null);
    panel1.add(btnOK, null);
    panel1.add(btnExit, null);

    java.util.Vector vct =null;
    if(util.PublicVariable.USER_RECORD.getInt("USR_TYPE")==newtimesejb.preproduction.PreProductionHead.USER_TYPE_SUPERVIOSER_MIS){
      String cenCode=util.PublicVariable.OPERATTING_CENTER;
      vct=
      exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select usr_code from userfile where usr_cen_code='" +cenCode + "' and record_delete_flag='1' order by usr_code",
          1, 9999);
    }else{

      vct=
      exgui2.CONST.BASIC_MAIN_EJB.getDatas(
          util.PublicVariable.USER_RECORD,
          "select usr_code from userfile where usr_dep_code='" +
          util.PublicVariable.USER_RECORD.get(5) + "' and record_delete_flag='1' order by usr_code",
          1, 9999);
    }
      dbCbxCreateUser=
          new exgui.DataBindJCombobox(cbxCreateUser,"",vct,"usr_code","usr_code",
                                      util.PublicVariable.USER_RECORD.get(0));

  }

  void btnOK_actionPerformed(ActionEvent e) {
    //test if ref is tpe and greater than 20100101
    int prod_head_pk=-1;
    if(txtSrcRefNo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Source REF NO",
                                             "Please Input Source REF NO");
      return;
    }
    //test if prod_head_pk is vailid
    try{
      prod_head_pk=Integer.parseInt(txtSrcRefNo.getText().trim());
      StringBuffer sb=new StringBuffer();
      sb.append("select prod_head_pk from prod_head ");
      sb.append(" where prod_cen_code='001' ");
      sb.append(" and record_create_date >=to_date('2010/01/01','yyyy/mm/dd') ");
      sb.append(" and prod_head_pk=");sb.append(String.valueOf(prod_head_pk));
      java.util.Vector vctTest=exgui2.CONST.BASIC_MAIN_EJB.getDatas(
       util.PublicVariable.USER_RECORD,
       sb.toString(),1,99999999);
       if(vctTest.size()==0){
         exgui.verification.VerifyLib.showAlert("This Ref No Is Not Valid","This Ref No Is Not Valid");
         return;
       }
    }catch(Exception exp){
      exp.printStackTrace();
      exgui.verification.VerifyLib.showAlert("Error While Checking SRC REF NO\nPlease Contact System Manager",
                                             "Error While Checking SRC REF NO");
      this.dispose();
      return;
    }
    if(txtItemCount.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input ITEM COUNT",
                                             "Please Input ITEM COUNT");
      return;
    }
    if(txtBatchNo.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input BATCH NO",
                                             "Please Input BATCH NO");
      return;
    }

    int itemcount=-1;
    try{
      itemcount=Integer.parseInt(txtItemCount.getText().trim());
      if(itemcount>100){
        exgui.verification.VerifyLib.showAlert("ITEM COUNT 須小於100",
                                               "ITEM COUNT 須小於100");
        return;
      }
      if(itemcount<1){
        exgui.verification.VerifyLib.showAlert("ITEM COUNT 須為正整數",
                                               "ITEM COUNT 須為正整數");
        return;
      }

    }catch(Exception exp){
      exgui.verification.VerifyLib.showAlert("ITEM COUNT 須為正整數",
                                             "ITEM COUNT 須為正整數");
      return;
    }

   try {

        newtimesejb.TPE_MIS.TpeMisFuncHome ejbHome=
            (newtimesejb.TPE_MIS.TpeMisFuncHome)
            info_ejb.WeblogicServiceLocator.locateServiceHome(
            util.PublicVariable.SERVER_URL,
            "newtimesejb.TPE_MIS.TpeMisFunc");
        newtimesejb.TPE_MIS.TpeMisFunc ejb2update=ejbHome.create();
        java.util.HashMap hmParam=new java.util.HashMap();
        /*
                 String usrCode=(String)param.get("user_code");
                 String prod_head_pk=(String)param.get("prod_head_pk");
                 String batchNO=(String)param.get("batch_no");
                 String itemCount=(String)param.get("item_count");
                 String refList=batchNbProdHead(Long.parseLong(prod_head_pk),Long.parseLong(itemCount),batchNO,usrCode);
                 HashMap hm=new HashMap();
                 hm.put("PROD_HEAD_PK_LIST",refList);

         */
        util.MiscFunc.showProcessingMessage();
        hmParam.put("TPEMISCFUNC_ACTION_CODE","BATCH_ADD_TPE_NB_PROD_HEAD");
        String userCode=(String)dbCbxCreateUser.getSelectedValue();//cbxCreateUser.getSelectedItem().toString();
            /*
            (txtUserCode.getText().trim().length()==0)?
            (String)util.PublicVariable.USER_RECORD.get(0):
            txtUserCode.getText().trim();
            */
        hmParam.put("user_code",  userCode);
        hmParam.put("prod_head_pk",txtSrcRefNo.getText().trim());
        hmParam.put("batch_no",txtBatchNo.getText().trim());
        hmParam.put("item_count",txtItemCount.getText().trim());
        java.util.HashMap hm_result=ejb2update.tpeMisFunc(hmParam);
        String result=(String)hm_result.get("PROD_HEAD_PK_LIST");
        if(result!=null)txtProdPkList.setText(result);
        util.MiscFunc.hideProcessingMessage();
        if(exgui.verification.VerifyLib.showConfirm("Do you want to modify po's Destination & Plan Delivery Date?",
                                                  "Do you want to modify po's Destination & Plan Delivery Date?",false)){
        DlgModifyProdsDestPlanDlv dlg=new
            DlgModifyProdsDestPlanDlv(util.PublicVariable.APP_FRAME,"MODIFY DEST & PLAN DLV",
                                      result,true);
            dlg.setSize(800,520);
            exgui.UIHelper.setToScreenCenter(dlg);
            dlg.setPanel2List();
            dlg.show();
            util.MiscFunc.showProcessingMessage();
            util.MiscFunc.hideProcessingMessage();

        }

    }catch(Exception exp){
      exp.printStackTrace();
      util.ExceptionLog.exp2File(exp,"");
      exgui.verification.VerifyLib.showAlert("Error While processing batch add!!","Error !!");
    }
    //this.dispose();
    return;
  }

  void btnExit_actionPerformed(ActionEvent e) {
    this.dispose();
    return;
  }
}
