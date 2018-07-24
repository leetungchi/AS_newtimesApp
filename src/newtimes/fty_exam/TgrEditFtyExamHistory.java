package newtimes.fty_exam;
import database.datatype.Record;
import java.util.*;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;
import processhandler.*;
import processhandler.commands.CommandException;
import java.awt.Cursor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TgrEditFtyExamHistory extends CommandTrigger {
  int buyerSeq;
  String buyerName;
  String makerName;
  public TgrEditFtyExamHistory(int _buyerSeq,String _buyerName,String _makerName) {
    buyerSeq= _buyerSeq;
    buyerName= _buyerName;
    makerName= _makerName;
  }
  public void activateThisProcess()throws processhandler.commands.CommandException {
    try{
      processhandler.template.Properties.getCenteralControler().
          setSystemCommander(
          newtimes.preproduction.Constants.CMDSET_PREPRODUCTION_MAINTAIN);
      commander = processhandler.template.Properties.getCenteralControler().
          getCurrentSystemCommand();
      ctnCtl.recordProcess(this); //store this node as "go back" required
      //wait if misc. attributions ready
      javax.swing.JFrame jframe = processhandler.template.Properties.getMainFrame();
      jframe.getContentPane().removeAll();
      jframe.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
      //jframe.getContentPane().add(Constans.PNL2QUERY);
      PnlEditFtyExamList pnl=new PnlEditFtyExamList(buyerSeq,buyerName,makerName);
      pnl.setSize(800, 600);
      jframe.getContentPane().add(pnl);
      jframe.repaint();
      jframe.show();
    }finally{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(
          Cursor.DEFAULT_CURSOR));
    }

  }

}