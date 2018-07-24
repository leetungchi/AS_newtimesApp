package newtimes.preproduction;
import database.datatype.Record;
import javax.swing.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Constants extends processhandler.template.Constants {
  static protected boolean isInNormalModNow=false;
  static PopMenuObj editPopMenu=new PopMenuObj();
  static MouseAdapter tblMouseAdapter=new MouseAdapter();
  public static String BYMKR_WAREHOUSE_STRING=null;
  public static void swithToGeneralMode(){
    processhandler.template.Properties.getSplitFrame().jSplitPane.setDividerSize(10);
      newtimes.preproduction.process.ToInitUperAndDownPnl.setToNthkMode(false);
      processhandler.template.Properties.getCommandFactory().registerCommand(
          newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN,
          newtimes.preproduction.Constants.Org_PREPROD_COMMAND_SET
          );

      //regist commandset of productions.
      if(!isInNormalModNow){
        newtimes.preproduction.Constants.Org_PRODUCTION_COMMAND_SET.
            setCommandButtons();
        isInNormalModNow=true;
      }
      processhandler.template.Properties.getCommandFactory().registerCommand(
          newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN,
          newtimes.preproduction.Constants.Org_PRODUCTION_COMMAND_SET
          );
  }
  public static void addPopEditorMenue(processhandler.template.PnlTableEditor pnl){
    pnl.getJtable().removeMouseListener(tblMouseAdapter);
    tblMouseAdapter.setJTable(pnl.getJtable());
    pnl.getJtable().addMouseListener(tblMouseAdapter);
  }
  static public class MouseAdapter extends java.awt.event.MouseAdapter{
    static JTable tbl2listen;
    public MouseAdapter(){
    }
    public void setJTable(JTable tbl){
      tbl2listen=tbl;
    }
    public void mouseClicked(java.awt.event.MouseEvent me){

      if ((me.getModifiers() & java.awt.event.InputEvent.BUTTON3_MASK) == java.awt.event.InputEvent.BUTTON3_MASK){
        editPopMenu.show(tbl2listen,me.getX(),me.getY());
      }
    }
  }

  static public class PopMenuObj extends javax.swing.JPopupMenu implements java.awt.event.ActionListener {
     JMenuItem itemCopy;
     JMenuItem itemDelete;
     JMenuItem itemPaste;
        public PopMenuObj(){
          super();
          itemCopy=new JMenuItem("COPY");
          itemCopy.addActionListener(this);
          itemDelete=new JMenuItem("DELETE");
          itemDelete.addActionListener(this);
          itemPaste=new JMenuItem("PASTE");
          itemPaste.addActionListener(this);
          add(itemCopy);
          add(itemDelete);
          add(itemPaste);
        }
        public void actionPerformed(java.awt.event.ActionEvent ae){
          if(ae.getSource()==itemCopy){
            //doCopy();
            processhandler.template.Properties.getCenteralControler().getDataProcesser().doCopy();
            return;
          }
          if(ae.getSource()==itemDelete){
            try{
              //doDelete();
              processhandler.template.Properties.getCenteralControler().getDataProcesser().doDelete();
              return;
            }catch(Exception exp){
              exp.printStackTrace();
            }
          }
          if(ae.getSource()==itemPaste){
            //doPaste();
            processhandler.template.Properties.getCenteralControler().getDataProcesser().doPaste();
            return;
          }
        }

  }

  public static boolean isNthkModeNow(){
    return !isInNormalModNow;
  }
  public static void swithToNTHKMode(){
    processhandler.template.Properties.getSplitFrame().jSplitPane.setDividerSize(0);
    newtimes.preproduction.process.ToInitUperAndDownPnl.setToNthkMode(true);
    processhandler.template.Properties.getCommandFactory().registerCommand(
        newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN,
        newtimes.preproduction.Constants.NTHK_PREPROD_COMMAND_SET
        );

    //regist commandset of productions.
    if("NTD".equals(util.PublicVariable.OPERATTING_CENTER)){
      if(isInNormalModNow){
        newtimes.preproduction.Constants.ND_PRODUCTION_COMMAND_SET.
            setCommandButtons();
        isInNormalModNow=false;
      }
      newtimes.preproduction.Constants.ND_PRODUCTION_COMMAND_SET.
          setCommandButtons();

      processhandler.template.Properties.getCommandFactory().registerCommand(
          newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN,
          newtimes.preproduction.Constants.ND_PRODUCTION_COMMAND_SET
     );
    } else{

      if(isInNormalModNow){
        newtimes.preproduction.Constants.NTHK_PRODUCTION_COMMAND_SET.
            setCommandButtons();
        isInNormalModNow=false;
      }
      newtimes.preproduction.Constants.NTHK_PRODUCTION_COMMAND_SET.
          setCommandButtons();

      processhandler.template.Properties.getCommandFactory().registerCommand(
          newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN,
          newtimes.preproduction.Constants.NTHK_PRODUCTION_COMMAND_SET
     );
    }

  }

  public static String CMDSET_PREPRODUCTION_MAINTAIN =
      "newtimes.preproduction.Constants.COMMANDSET4MAINTAIN";

  public static newtimes.preproduction.process.PP_Maintain_CmdSet Org_PREPROD_COMMAND_SET=
      new newtimes.preproduction.process.PP_Maintain_CmdSet();

  public static newtimes.preproduction.process.NTHK_PreprodMaintain_CmdSet NTHK_PREPROD_COMMAND_SET=
      new newtimes.preproduction.process.NTHK_PreprodMaintain_CmdSet();

  public static newtimes.production.process.prodmaintain.ProdMaintain_CmdSet Org_PRODUCTION_COMMAND_SET=
      new newtimes.production.process.prodmaintain.ProdMaintain_CmdSet();

  public static newtimes.production.process.prodmaintain.NTHK_ProdMaintain_CmdSet NTHK_PRODUCTION_COMMAND_SET=
      new newtimes.production.process.prodmaintain.NTHK_ProdMaintain_CmdSet();

  public static newtimes.production.process.prodmaintain.NTHK_ProdMaintain_CmdSet ND_PRODUCTION_COMMAND_SET=
      new newtimes.production.process.prodmaintain.NTD_ProdMaintain_CmdSet();


  public static String CMD_GENERATE_QUERY_GUI="newtimes.preproduction.Constants.toGENERATE_QUEYRGUI";
  final public static  newtimes.preproduction.guis.PnlTabbedButtons ButtonsWithTriggers=
         new newtimes.preproduction.guis.PnlTabbedButtons();
  final public static  newtimes.preproduction.guis.PnlTabbedButtons
         TrgButtons4RestoreColorStyle=
         new newtimes.preproduction.guis.PnlTabbedButtons();

  public static int CURRENT_PREPROD_HEAD_PK=0;
  public static java.util.Vector PREPROD_USING_MTRL_DTLS;
  public static String PREPROD_USING_MTRL_DTLS_STRING;
  public static Record SELECTED_ORG_COLOR_LIB_RECORD;
  public static Record CURRENT_PREPROD_HEAD_RECORD;
  public static String TEMP_MILL_MTRL_NO;
  public static database.datatype.Record SYSTEM_DEFAULT_RECORD=null;
  public static java.util.HashMap mapping4ComboboxKeyInt(java.util.Vector vct,int pk,int col2display){
    if(vct==null||vct.size()==0)return new java.util.HashMap();
    java.util.HashMap hm=new java.util.HashMap();
    for(int i=0;i<vct.size();i++){
       Record aRec=(Record)vct.get(i);
       Object keyObj=aRec.get(pk);
       Object valueObj=aRec.get(col2display);
       if(keyObj!=null && valueObj!=null)hm.put(keyObj.toString(),valueObj);
    }
    return hm;
  }
  public static java.util.HashMap mapping4ComboboxKeyInt(java.util.Vector vct,String pk,String col2display)throws Exception{
    if(vct==null||vct.size()==0)return new java.util.HashMap();
    Record rec=(Record)vct.get(0);
    int pkAt=util.MiscFunc.getFieldIndexAtRecord(rec,pk);
    if(pkAt==-1)throw new Exception("column:"+pk+" not found in record:"+rec);
    int col2showAt=util.MiscFunc.getFieldIndexAtRecord(rec,col2display);
    if(col2showAt==-1)throw new Exception("column:"+col2display+" not found in record:"+rec);
    return mapping4ComboboxKeyInt(vct,pkAt,col2showAt);
  }
  public static String getAuditStatusName(int auditStatusCode){
     if(isNthkModeNow()){
       switch(auditStatusCode){
         case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_CONFIRMED:
           return "APPROVAL";
         case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_EDITING:
           return "PENDING";
         case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_PRINTED:
           return "APPROVAL";
         case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_REJECTED:
           return "CANCELED";
         case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_WAIT_CONFIRM:
           return "PENDING";
         case 7:
           return "SHIPPED";
       }
       return null;
     }
     switch(auditStatusCode){
       case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_CONFIRMED:
         return "CONFIRMED";
       case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_EDITING:
         return "EDITING";
       case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_PRINTED:
         return "PRINTED";
       case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_REJECTED:
         return "REJECTED";
       case newtimesejb.preproduction.PreProductionHead.AUDIT_STATUS_WAIT_CONFIRM:
         return "WAIT CONFIRM";
       case 7:
         return "SHIPPED";
     }
     return null;
  }
  public Constants() {
    String captions4Mtrl[]=null;
    try{
      int usr_type_id = util.PublicVariable.USER_RECORD.getInt("USR_TYPE");
      if (usr_type_id ==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS ||
          usr_type_id ==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
          usr_type_id ==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS) {
        captions4Mtrl =
            new String[] {"Sty", "Prod Clr", "Fab", "Extra", };
      } else {
        captions4Mtrl =
            new String[] {"Sty", "Prod Clr", "Fab", "Extra", "Print Draft",
            "OD Print"};

      }

      java.util.List colorList = new java.util.ArrayList();

      java.util.Vector list = new java.util.Vector();
      list.add(new newtimes.production.process.prodmaintain.
               TgrToListStylesNoProdHead());
      colorList.add(newtimes.production.process.prodmaintain.
                    ProdMaintain_CmdSet.color_GRP_PLAN2ORD_PRINT);
      //list.add(new newtimes.production.process.prodmaintain.TgrToListPlanQuota());
      //colorList.add(newtimes.production.process.prodmaintain.ProdMaintain_CmdSet.color_GRP_PLAN2ORD_PRINT);
      list.add(new newtimes.production.process.prodmaintain.TgrToListProdColors());
      colorList.add(newtimes.production.process.prodmaintain.
                    ProdMaintain_CmdSet.color_GRP_PLAN2ORD_PRINT);
      list.add(new newtimes.production.process.prodmaintain.
               TgrToListFbkPoNoProdHead());
      colorList.add(newtimes.production.process.prodmaintain.
                    ProdMaintain_CmdSet.color_GRP_PLAN2ORD_PRINT);
      list.add(new newtimes.production.process.prodmaintain.TgrToEdit_SC_Head());
      colorList.add(newtimes.production.process.prodmaintain.
                    ProdMaintain_CmdSet.color_GRP_PLAN2ORD_PRINT);
      if (usr_type_id ==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_SHIPPING_USERS ||
          usr_type_id ==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_ACCOUNTING_USERS||
          usr_type_id ==
          newtimesejb.preproduction.PreProductionHead.USER_TYPE_OTHERS) {
      }else{
        list.add(new newtimes.production.process.prodmaintain.
                 TgrToEditSty_SC_SndCfm());
        colorList.add(newtimes.production.process.prodmaintain.
                      ProdMaintain_CmdSet.color_GRP_PLAN2ORD_PRINT);
        list.add(new newtimes.preproduction.process.TgrToDoOrderPrint());
        colorList.add(newtimes.production.process.prodmaintain.
                      ProdMaintain_CmdSet.color_GRP_PLAN2ORD_PRINT);

      }
      ButtonsWithTriggers.setButtonActions(captions4Mtrl, list, colorList);

      //=================================for color and style restore==================
      String captions4Restor[] = new String[] {
          "Restore Styles",
          "Restore Color Libs"
      };
      //"<html><body>Cost Sheet</body></html>"

      java.util.Vector list4Restore = new java.util.Vector();

      list4Restore.add(new newtimes.preproduction.process.
                       TgrToListStyle2Restore());
      list4Restore.add(new newtimes.preproduction.process.
                       TgrToListPpClib4Restore());
      //list.add(new newtimes.preproduction.process.TgrEditCostSheet());
      TrgButtons4RestoreColorStyle.setButtonActions(captions4Restor,
          list4Restore);
    }catch(Exception exp){
      exp.printStackTrace();
    }

  }
  class tempTrigger extends processhandler.CommandTrigger{
    public tempTrigger(){}
    protected void activateThisProcess()throws processhandler.commands.CommandException {

    }
  }
}
