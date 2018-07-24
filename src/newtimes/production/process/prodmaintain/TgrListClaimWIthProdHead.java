package newtimes.production.process.prodmaintain;

import processhandler.commands.CommandException;
import processhandler.*;
import javax.swing.*;
import java.awt.*;

public class TgrListClaimWIthProdHead extends CommandTrigger {
  public TgrListClaimWIthProdHead() {
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    processhandler.template.Properties.getCenteralControler().setSystemCommander(
          newtimes.production.ProdMaintain_Properties.CMDS_PROD_MAINTAIN
         );
    commander=processhandler.template.Properties.getCenteralControler().getCurrentSystemCommand();
    if(commander==null)
      throw new CommandException("commander is null");
       try{
         toListClaim();
       }catch(processhandler.commands.CommandIncompleteException cie){
       }catch(Exception e){
          e.printStackTrace();
          throw new CommandException(e.getMessage());
       }

  }
  void setTitle()throws Exception{
    String sc_no=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("prod_sc_no");
    String today=new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date(System.currentTimeMillis())) ;
    String createUser=(String)newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.get("record_create_user");
    StringBuffer sb=new StringBuffer();
    sb.append(today); sb.append(" ");
    sb.append("USER ID:");sb.append(util.PublicVariable.USER_RECORD.get(0)); sb.append(" ");
    sb.append("Create By:");sb.append(createUser); sb.append(" ");
    sb.append("S/C: ");sb.append(sc_no);sb.append(" ");
    sb.append("REF NO: ");sb.append(newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_RECORD.getInt(0));
    util.PublicVariable.APP_FRAME.setTitle(sb.toString());

  }
  public void toListClaim()throws Exception{
    javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
    java.awt.Cursor ksr=jframe.getContentPane().getCursor();
    try{
      jframe.getContentPane().setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
      newtimes.preproduction.process.ToInitUperAndDownPnl.setPreProdDisplayer();
      //specific process of doing this command.
      newtimes.production.gui.prodmaintain.PnlClaim pnl=
          new newtimes.production.gui.prodmaintain.PnlClaim();
      pnl.setPreferredSize(
         new java.awt.Dimension(780,385)
       );
      newtimes.production.process.prodmaintain.ToCheckB4StyleProc.addLowerPanel("Claim Form",pnl);
      processhandler.template.Properties.getCenteralControler().setDataProcesser(pnl);
      //processhandler.template.Properties.getSplitFrame().setDividerLocation(0.18);
      processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
      processhandler.template.Properties.getSplitFrame().jSplitPane.setDividerSize(0);
      setTitle();
      processhandler.template.Properties.getSplitFrame().repaint();
      if(newtimes.production.ProdMaintain_Properties.isAbleToEdit()){
        newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(false,true,false,false,false,false);
      }else{
        newtimes.production.process.prodmaintain.ToCheckB4StyleProc.setFunctionButtonStatus(false,false,true,false,false,false);
      }
      jframe.validate();jframe.repaint();
      pnl.firstPage();
    }finally{
      jframe.getContentPane().setCursor(ksr);
    }
  }
}
