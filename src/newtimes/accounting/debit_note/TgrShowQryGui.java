package newtimes.accounting.debit_note;
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

public class TgrShowQryGui extends CommandTrigger {
  public TgrShowQryGui() {
  }
  public static void setBankDataString(){
    if(Constans.BankDataString==null){
      Constans.BankDataString=new java.util.HashMap();
            StringBuffer sb=new StringBuffer();
            //LIGHT&HEAVY
            sb.append("PLS MAKE THE PAYMENTS BY WIRE TRANSFER TO FOLLOWING ACCOUNT, THANKS.\n");
            sb.append("BENEFICIARY NAME   : LIGHT & HEAVY IND.SUPPLIER LTD.\n");
            sb.append("BENEFICIARY A/C NO.: 007-05-00901-0\n");
            sb.append("BANK NAME          : MEGA INTERNATIONAL COMMERCIAL BANK CO.,LTD.\n");
            sb.append("                     HEAD OFFICE-FOREIGN DEPT.\n");
            sb.append("SWIFT CODE         : ICBCTWTP007\n");
            sb.append("BANK ADDRESS       : 100 CHI LIN ROAD,TAIPEI,TAIWAN,R.O.C.");
            String light_Have=new String(sb.toString());
            Constans.BankDataString.put("LIGHT&HEAVY",light_Have);

            //GLOBALTEAM
            sb=new StringBuffer();
            sb.append("PLS MAKE THE PAYMENTS BY WIRE TRANSFER TO FOLLOWING ACCOUNT, THANKS.\n");
            sb.append("BENEFICIARY NAME   : GLOBALTEAM LTD.\n");
            sb.append("BENEFICIARY A/C NO.: 007-05-04512-8 \n");
            sb.append("BANK NAME          : MEGA INTERNATIONAL COMMERCIAL BANK CO.,LTD.\n");
            sb.append("                     HEAD OFFICE-FOREIGN DEPT.\n");
            sb.append("SWIFT CODE         : ICBCTWTP007\n");
            sb.append("BANK ADDRESS       : 100 CHI LIN ROAD,TAIPEI,TAIWAN,R.O.C.");
            String globalTeam=new String(sb.toString());
            Constans.BankDataString.put("GLOBALTEAM LIMITED",globalTeam);

            //NEWTIMES WORLDWIDE
            sb=new StringBuffer();
            sb.append("PLS MAKE THE PAYMENTS BY WIRE TRANSFER TO FOLLOWING ACCOUNT, THANKS.\n");
            sb.append("BENEFICIARY NAME   : NEWTIMES WORLDWIDE LTD.\n");
            sb.append("BENEFICIARY A/C NO.: 007-53-00170-1\n");
            sb.append("BANK NAME          : MEGA INTERNATIONAL COMMERCIAL BANK CO.,LTD.\n");
            sb.append("                     HEAD OFFICE-FOREIGN DEPT.\n");
            sb.append("SWIFT CODE         : ICBCTWTP007\n");
            sb.append("BANK ADDRESS       : 100 CHI LIN ROAD,TAIPEI,TAIWAN,R.O.C.");
            String newtimesWorlWide=new String(sb.toString());
            Constans.BankDataString.put("NEWTIMES WORLDWIDE",newtimesWorlWide);

            //NEWTIMES INT''L
            sb=new StringBuffer();
            sb.append("PLS MAKE THE PAYMENTS BY WIRE TRANSFER TO FOLLOWING ACCOUNT, THANKS.\n");
            sb.append("BENEFICIARY NAME   : NEWTIMES INTERNATIONAL LTD.\n");
            sb.append("BENEFICIARY A/C NO.: 580-273654-274\n");
            sb.append("BANK NAME          : THE HONGKONG AND SHANGHAI BANKING CORPORATION LIMITED\n");
            sb.append("                     MONGKOK BRANCH\n");
           // sb.append("                     (FORMALLY KNOWN AS ABN AMRO BANK,N.V. TAIPEI)\n");
            //sb.append("SWIFT NO.          : ABNATWTP\n");
            //sb.append("BANK ADDRESS       : 110 FLOOR 18, NO. 7, SUNG-JEN ROAD\n");
            sb.append("SWIFT CODE         : HSBCHKHHHKH\n");
            sb.append("BANK ADDRESS       : 673 NATHAN ROAD, KOWLOON, HONG KONG(MONGKOK BRANCH)");
//            sb.append("                     TAIPEI, TAIWAN");
            String newitemsIntl=new String(sb.toString());
            Constans.BankDataString.put("NEWTIMES INT''L",newitemsIntl);

            //GENEXCO WORLDWIDE LTD.
            sb=new StringBuffer();
            sb.append("PLS MAKE THE PAYMENTS BY WIRE TRANSFER TO FOLLOWING ACCOUNT, THANKS.\n");
            sb.append("BENEFICIARY NAME   : GENEXCO WORLDWIDE LTD.\n");
            sb.append("BENEFICIARY A/C NO.: 007-53-07336-0\n");
            sb.append("BANK NAME          : MEGA INTERNATIONAL COMMERCIAL BANK CO., LTD.\n");
            sb.append("                     HEAD OFFICE-FOREIGN DEPT.\n");
            sb.append("SWIFT CODE         : ICBCTWTP007\n");
            sb.append("BANK ADDRESS       : 100 CHI LIN ROAD,TAIPEI,TAIWAN,R.O.C");
            String newitemsGnxWW=new String(sb.toString());
            Constans.BankDataString.put("GENEXCO WORLDWIDE",newitemsGnxWW);
    }
  }
  protected void activateThisProcess() throws processhandler.commands.CommandException {
    try{
      setBankDataString();
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
      if(Constans.PNL2QUERY==null){
        while (!newtimes.preproduction.process.AttributeFactory.
               isAllAccsAttribReady()) {
          try {
            Thread.currentThread().sleep(100);
          } catch (java.lang.InterruptedException ie) {
          }
        }
         Constans.PNL2QUERY = new PnlQryDebitNote();

      }
      Constans.PNL2QUERY.setSize(800, 600);
      jframe.getContentPane().add(Constans.PNL2QUERY);
      jframe.repaint();
      jframe.show();
    }finally{
      util.PublicVariable.APP_FRAME.getContentPane().setCursor(new Cursor(
          Cursor.DEFAULT_CURSOR));
    }

  }
}
