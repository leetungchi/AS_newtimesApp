package newtimes.preproduction.buyermakerselect;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class FrmTestDlg extends JFrame {
  JPanel contentPane;
  JButton jButton1 = new JButton();
  newtimesejb.preproduction.BuyerMaker ejb=null;
  JList jList1 = new JList();
  JButton jButton2 = new JButton();
  //Construct the frame
  public FrmTestDlg() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
      newtimesejb.preproduction.BuyerMakerHome ejbHome=
          (newtimesejb.preproduction.BuyerMakerHome)info_ejb.WeblogicServiceLocator.locateServiceHome(
          util.PublicVariable.SERVER_URL,"newtimesejb.preproduction.BuyerMaker"
          );
      ejb=ejbHome.create();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //Component initialization
  private void jbInit() throws Exception  {
    Object orgValue=new java.math.BigInteger("3872");
    contentPane = (JPanel) this.getContentPane();
    jButton1.setBounds(new Rectangle(247, 207, 83, 29));
    jButton1.setText("jButton1");
    jButton1.addActionListener(new FrmTestDlg_jButton1_actionAdapter(this));
    contentPane.setLayout(null);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Frame Title");
    jList1.setBounds(new Rectangle(110, 46, 197, 138));
    jButton2.setBounds(new Rectangle(251, 254, 81, 22));
    jButton2.setText("verify");
    jButton2.addActionListener(new FrmTestDlg_jButton2_actionAdapter(this));
    contentPane.add(jList1, null);
    contentPane.add(jButton1, null);
    contentPane.add(jButton2, null);
    DefaultListModel mdl=new DefaultListModel();
    mdl.add(0,"item1");
    mdl.add(1,"item2");
    jList1.setModel(mdl);

  }
  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  void beginMapping(){
    /*
    selectBuyerMaker1.init("null",null,selectBuyerMaker1.TYPE_MAKER,true);
    selectBuyerMaker1.setModifyNotifyTo(selectMaterial1);
    selectMaterial1.init("column1",null,null,true,"MTRDTL_MILL_NO");
   */
  }

  void jButton1_actionPerformed(ActionEvent e) {
    //chain the dialog ..
    //PnlAtoZ pnlInit=new PnlAtoZ();
    PnlKeyWordSlkMtrDtl pnlInit=new PnlKeyWordSlkMtrDtl();
    SelectMtrlDtl4MtrVPreProd pnlMtrlDtl=new  SelectMtrlDtl4MtrVPreProd();
    pnlMtrlDtl.setSelectedMtrlDtl(new java.util.Vector());
    pnlInit.setDefalutNext(pnlMtrlDtl);
    DlgSelectBuyerMaker dlg=new DlgSelectBuyerMaker(this,"select Matrial Data",true,pnlInit);
    dlg.setSize(500,400);
    exgui.UIHelper.setToScreenCenter(dlg);
    pnlInit.storedMap.put(Kies.KEY_INIT_SELEC_BUYERMAKER_TYPE_NAME,"Material No.");//select buyer maker type is 2---maker.
    dlg.show();
    if(dlg.getDialogStatus()==dlg.DIALOG_OK){
      //System.out.println("reslut is:"+dlg.getDialogResult());
      java.util.HashMap hm=
      (java.util.HashMap)((java.util.HashMap)dlg.getDialogResult()).get(Kies.KESY_HM_SELECTED_MATERIAL_DETAIL_RECORDS);
      java.util.Vector vct=new java.util.Vector(hm.values());
      for(int i=0;i<vct.size();i++){
        System.out.println("element is:"+vct.get(i));
      }

    }else{
      System.out.println("conversation is over");
    }

  }

  void jButton2_actionPerformed(ActionEvent e) {
    /*
    if(selectBuyerMaker1.isValid()){
      System.out.print("selectBuyerMaker1 get value:"+selectBuyerMaker1.getSelectedValue());
    }
   */
  }
}

class FrmTestDlg_jButton1_actionAdapter implements java.awt.event.ActionListener {
  FrmTestDlg adaptee;

  FrmTestDlg_jButton1_actionAdapter(FrmTestDlg adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}

class FrmTestDlg_jButton2_actionAdapter implements java.awt.event.ActionListener {
  FrmTestDlg adaptee;

  FrmTestDlg_jButton2_actionAdapter(FrmTestDlg adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton2_actionPerformed(e);
  }
}