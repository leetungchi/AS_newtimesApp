package newtimes.production.gui.prodmaintain;
import java.awt.*;
import exgui.*;
import newtimes.preproduction.buyermakerselect.*;
import javax.swing.*;
import exgui.chaindialog.*;
import database.datatype.Record;
public class PnlRspInit4ShipPackMark extends JPanel  implements Responsible,
       newtimes.preproduction.buyermakerselect.BuyerMakerChanged {
  BlueBkgWhiteCharLabel blueBkgWhiteCharLabel1 = new BlueBkgWhiteCharLabel();
  SelectBuyerMaker slkBuyerMaker = new SelectBuyerMaker();
  WhiteBkgBlueCharLabel whiteBkgBlueCharLabel1 = new WhiteBkgBlueCharLabel();
  JTextField txtIndexBySeq = new JTextField();
  Responsible nextRspObj=null;
  public static int Search_TYPE;
  public static int SEARCH_SHIPPIMG_MARK=0;
  public static int SEARCH_PACKING_MARK=1;
  String NAME_SHIPMARK_OR_PACKINGMARK;
  public static final String KEY_TYPE_IS_SHIPPING_PACKING="newtimes.production.gui.prodmaintain_SHIPPING_RACKING";
  public static final String KEY_BUYER_MAKER_SEQ="newtimes.production.gui.prodmaintain_BUYER_MAKER_SEQ";
  public static final String KEY_REMARK_RECORD="newtimes.production.gui.prodmaintain_KEY_REMARK_RECORD";
  public static final String KEY_SQL_TO_SEARCH_REMARK="newtimes.production.gui.prodmaintain_KEY_buyerMakerSeq";
  public PnlRspInit4ShipPackMark(String title,int type) {
    try {
      jbInit();
      NAME_SHIPMARK_OR_PACKINGMARK=title;
      Search_TYPE=type;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  void jbInit() throws Exception {
    setBackground(new java.awt.Color(204, 204, 225));
    blueBkgWhiteCharLabel1.setText("<html><body>Search By<br>Buyer/Maker</body></html>");
    blueBkgWhiteCharLabel1.setBounds(new Rectangle(60, 86, 122, 36));
    this.setLayout(null);
    slkBuyerMaker.setBounds(new Rectangle(182, 86, 210, 36));
    whiteBkgBlueCharLabel1.setText("Or Direct Index By Seq No.");
    whiteBkgBlueCharLabel1.setBounds(new Rectangle(61, 145, 241, 34));
    txtIndexBySeq.setBounds(new Rectangle(302, 145, 90, 34));
    this.add(blueBkgWhiteCharLabel1, null);
    this.add(slkBuyerMaker, null);
    this.add(whiteBkgBlueCharLabel1, null);
    this.add(txtIndexBySeq, null);
    slkBuyerMaker.setModifyNotifyTo(this);
    //limit the ext field only allow integer.
    slkBuyerMaker.init("",null,slkBuyerMaker.TYPE_BUYER,true);
    Object seqChkObj=exgui.verification.CellFormat.getIntVerifier(7);
    txtIndexBySeq.addKeyListener(new keyListenObj());
    exgui.DataBindTextWithChecker dbChk=
        new exgui.DataBindTextWithChecker(txtIndexBySeq,"",null,7,
                                          (exgui.Object2String)seqChkObj,
                                          (exgui.ultratable.CellTxtEditorFormat)seqChkObj);
    txtIndexBySeq.setText("");

  }
  class keyListenObj extends java.awt.event.KeyAdapter {
    public void keyReleased(java.awt.event.KeyEvent ke){
      if(!ke.isActionKey()){
        ((javax.swing.text.JTextComponent)slkBuyerMaker.getGUIcomponent()).setText("");
      }
    }
  }

  public void changeBuyerMaker(database.datatype.Record rec){
    if(rec!=null)txtIndexBySeq.setText("");
  }
  public JComponent getGUI(){
    return this;
  }
  public void setDefalutNext(Responsible dfltRsp){
    nextRspObj=dfltRsp;
  }
  public Responsible next()throws NextResponsibleIsNotReady{
    if(txtIndexBySeq.getText().trim().length()==0&&
       ((javax.swing.text.JTextComponent)slkBuyerMaker.getGUIcomponent()).getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Assigne Buyer Maker To Search,Or Input SEQ No. OF Remkar.",
                                              "Please Assigne Column To Select");
      throw new NextResponsibleIsNotReady();
    }
    if(txtIndexBySeq.getText().trim().length()>0){
      try{
        int indexSeq = Integer.parseInt(txtIndexBySeq.getText().trim());
      }catch(Exception exp){
       exgui.verification.VerifyLib.showAlert("Integer Format Error","Integer Format Error");
       throw new NextResponsibleIsNotReady();
      }

        StringBuffer sb=new StringBuffer();
        sb.append("select * from ");
        if(Search_TYPE==SEARCH_PACKING_MARK){
          sb.append(" PACKING_MARK where PACKING_PK=");
        }else{
          sb.append(" SHIPMARK where SHIPMARK_PK=");
        }
        sb.append(txtIndexBySeq.getText().trim());
        sb.append(" and record_delete_flag='1' ");

        java.util.Vector vct=null;
        try{
          vct = exgui2.CONST.BASIC_MAIN_EJB.getDatas(util.PublicVariable.
              USER_RECORD,
              sb.toString(), 1, 1);
        }catch(Exception ejbExp){

        }
        if(vct==null){
          exgui.verification.VerifyLib.showAlert("Server Side Error while Retreiving " +NAME_SHIPMARK_OR_PACKINGMARK+ " Data",
                                                 "Server Side Error while Retreiving "+ NAME_SHIPMARK_OR_PACKINGMARK +"Remark Data");
          throw new NextResponsibleIsNotReady();
        }
        if(vct.size()==0){
          exgui.verification.VerifyLib.showAlert("No Such "+NAME_SHIPMARK_OR_PACKINGMARK+" Data",
                                                 "No Such Record");
          throw new NextResponsibleIsNotReady();
        }
        Record rec=(Record)vct.get(0);
        if(Search_TYPE==SEARCH_PACKING_MARK){
           nextRspObj = new  PnlRspShowMark((String)rec.get(2),null);
        }else{
          Object mainMarkObj=rec.get(2);
          Object shidMarkObj=rec.get(3);
          String mainMark=(mainMarkObj==null)?" ":mainMarkObj.toString();//get main mark;
          String sideMark=(shidMarkObj==null)?" ":shidMarkObj.toString();//get main mark;
          nextRspObj=new PnlRspShowMark(mainMark,sideMark);
        }
        //storedMap.put(KEY_REMARK_RECORD,rec);

    }else{
       storedMap.put(KEY_BUYER_MAKER_SEQ,slkBuyerMaker.getSelectedValue());
       if(Search_TYPE==SEARCH_PACKING_MARK){
         storedMap.put(KEY_SQL_TO_SEARCH_REMARK,
         "select * from PACKING_MARK where record_delete_flag='1' and PACKING_BYMKR_SEQ="+slkBuyerMaker.getSelectedValue());
         PnlRspListPackMarks pnl= new PnlRspListPackMarks();
         pnl.StartPosition=0;
         nextRspObj=pnl;
       }else{
         storedMap.put(KEY_SQL_TO_SEARCH_REMARK,
         "select * from SHIPMARK where record_delete_flag='1' and SHIPMARK_BYMKR_SEQ="+slkBuyerMaker.getSelectedValue());
         PnlRspListShipMarks pnl=new PnlRspListShipMarks();
         pnl.StartPosition=0;
         nextRspObj=pnl;
       }
    }
    return nextRspObj;
  }

  public boolean isAllowOkNow(){
    return false;
  }

}
