package newtimes.production.report;

  import processhandler.commands.*;
  import processhandler.*;
  /**
   * <p>Title: </p>
   * <p>Description: </p>
   * <p>Copyright: Copyright (c) 2003</p>
   * <p>Company: </p>
   * @author not attributable
   * @version 1.0
   */

  public class TgrRptCommInv extends CommandTrigger{
    public TgrRptCommInv() {
    }
    protected void activateThisProcess() throws processhandler.commands.CommandException {
          newtimes.production.ProdMaintain_Properties.setWaitCursor();
          javax.swing.JFrame jframe=processhandler.template.Properties.getMainFrame();
          try{
            while(!newtimes.preproduction.process.AttributeFactory.isAllAccsAttribReady()){
              try{
                Thread.currentThread().sleep(100);
              }catch(java.lang.InterruptedException ie){
              }
            }

            System.out.println("is report engine ok ? "+
                               newtimes.production.report.ReportCmdSet.myReportEngin.checkOk());
             javax.swing.JPanel tempDownPnl=new javax.swing.JPanel();
             tempDownPnl.setLayout(new java.awt.BorderLayout());
             tempDownPnl.add(new com.inet.viewer.ReportViewerBean());
             PnlRptCommInv  pnl=new PnlRptCommInv();
             pnl.jbInit();
             processhandler.template.Properties.getSplitFrame().setPanel(
                pnl,
                tempDownPnl
              );
             processhandler.template.Properties.getSplitFrame().setDividerLocation(0.25);
             newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
                 setFunctionButtonStatus(
                 false, false, false, false,false,false,false);
             processhandler.template.Properties.getSplitFrame().validate();
             processhandler.template.Properties.getSplitFrame().repaint();

             jframe.getContentPane().removeAll();
             jframe.getContentPane().add(processhandler.template.Properties.getSplitFrame());

             jframe.validate();
             jframe.repaint();
          }catch(processhandler.commands.CommandException cexp){
             throw cexp;
          }catch(Exception exp){
            exp.printStackTrace();
            throw new processhandler.commands.CommandException("Error For report engin");
          }finally{
             newtimes.production.ProdMaintain_Properties.setNormalCursor();
          }

       }


  }

