package newtimes.production.process.prodmaintain;
import newtimes.preproduction.process.*;
import database.datatype.Record;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ToNtfePrintDraft
  extends ToCheckB4StyleProc
  implements AbleToEditSty_SC_SndCfm{
  public ToNtfePrintDraft() {
  }
  public void toEditSty_SC_SndCfm()throws processhandler.commands.CommandException,
                                          processhandler.commands.CommandIncompleteException{
     newtimes.production.ProdMaintain_Properties.setWaitCursor();
     try{
       if(!newtimes.production.process.prodmaintain.ToEditSty_SC_SndCfm.isDataReady()) throw new processhandler.commands.CommandIncompleteException();
       newtimes.production.gui.prodmaintain.PnlSC_CT_SndCnfm  pnl =
           new newtimes.production.gui.prodmaintain.PnlSC_CT_SndCnfm(
          newtimes.preproduction.Constants.CURRENT_PREPROD_HEAD_PK);
       StringBuffer sb=new StringBuffer();
       sb.append("=====  S/C DRAFT  ====");

       /*
       addLowerPanel(sb.toString(),pnl);
       super.setFunctionButtonStatus(false,false,false,false,false,false);
       }*/
       //toSetPanelUnderButtons(pnl,sb.toString());
       super.addLowerPanel(sb.toString(),pnl);
       processhandler.template.Properties.getSplitFrame().setDividerLocation(0.0);
       newtimes.production.process.prodmaintain.ToCheckB4StyleProc.
           setFunctionButtonStatus(
           false, false, false, false,false,false);
       processhandler.template.Properties.getCenteralControler().setDataProcesser(null);
     }catch(processhandler.commands.CommandIncompleteException cie){
       throw cie;
     }catch(Exception e){
       throw new processhandler.commands.CommandException(e.getMessage());
    }finally{
      newtimes.production.ProdMaintain_Properties.setNormalCursor();
    }

   }


}
