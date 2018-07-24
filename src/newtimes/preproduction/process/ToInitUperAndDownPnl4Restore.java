package newtimes.preproduction.process;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Cursor;

public class ToInitUperAndDownPnl4Restore extends ToInitUperAndDownPnl {
  public ToInitUperAndDownPnl4Restore() {
  }
  static protected void toSetPanelUnderButtons(javax.swing.JPanel pnl,String caption){
    newtimes.preproduction.guis.PnlTabbedButtons triggerBtnPln=
         newtimes.preproduction.Constants.TrgButtons4RestoreColorStyle;
    //pnl.setSize(800,300);
    newtimes.preproduction.Constants.ButtonsWithTriggers.setPreferredSize(
        new java.awt.Dimension((int)pnl.getPreferredSize().getWidth(),
                               (int)pnl.getPreferredSize().getHeight()+50)
    );
    triggerBtnPln.panelToPlaceEditors().removeAll();
    triggerBtnPln.panelToPlaceEditors().add(new JLabel(caption),BorderLayout.NORTH);
    triggerBtnPln.panelToPlaceEditors().add(pnl,BorderLayout.CENTER);
    processhandler.template.Properties.getSplitFrame().setLowerPanel(
      triggerBtnPln
    );
  }
  static protected void toSetPanelUnderButtons(javax.swing.JPanel pnl){
    newtimes.preproduction.guis.PnlTabbedButtons triggerBtnPln=
         newtimes.preproduction.Constants.TrgButtons4RestoreColorStyle;
    //pnl.setSize(800,300);
    newtimes.preproduction.Constants.ButtonsWithTriggers.setPreferredSize(
        new java.awt.Dimension((int)pnl.getPreferredSize().getWidth(),
                               (int)pnl.getPreferredSize().getHeight()+50)
    );
    triggerBtnPln.panelToPlaceEditors().removeAll();
    triggerBtnPln.panelToPlaceEditors().add(pnl);
    processhandler.template.Properties.getSplitFrame().setLowerPanel(
      triggerBtnPln
    );
  }
}
