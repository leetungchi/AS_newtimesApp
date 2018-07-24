package exgui;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.basic.*;

public class WideComboBox extends JComboBox {

  protected int popupWidth = 0;

  public WideComboBox() {
    super();
    init();
  }

  public WideComboBox(ComboBoxModel model) {
    super(model);
    init();
  }

  public WideComboBox(final Object[] items) {
    super(items);
    init();
  }

  public WideComboBox(Vector items) {
    super(items);
    init();
  }

  private void init() {
    setUI( new MetalWideComboBoxUI() );
    setPopupWidth( getPreferredSize().width );
  }

  public void setBounds(int x, int y, int width, int height) {
    super.setBounds(x, y, width, height);
    setPreferredSize(new Dimension(width, height));
  }

  public void setBounds(Rectangle r) {
    super.setBounds(r);
    setPreferredSize(new Dimension(r.width, r.height));
  }

  public void setPopupWidth(int width) {
    popupWidth = width;
  }

  public Dimension getPopupSize() {
      Dimension size = getSize();
      if (popupWidth < 1) {
        popupWidth = size.width;
      }
    return new Dimension(popupWidth, size.height);
  }

    public class MetalWideComboBoxUI extends MetalComboBoxUI {
      protected ComboPopup createPopup() {
      BasicComboPopup popup = new BasicComboPopup( comboBox ) {
        /** Method copied (!!) from jdk 1.3.0 javax.swing.plaf.basic.BasicComboPopup */
        public void show() {
          // Dimension popupSize = comboBox.getSize();
          Dimension popupSize = ((WideComboBox)comboBox).getPopupSize();
          popupSize.setSize( popupSize.width, getPopupHeightForRowCount( comboBox.getMaximumRowCount() ) );
          Rectangle popupBounds = computePopupBounds( 0, comboBox.getBounds().height,
          popupSize.width, popupSize.height);
          scroller.setMaximumSize( popupBounds.getSize() );
          scroller.setPreferredSize( popupBounds.getSize() );
          scroller.setMinimumSize( popupBounds.getSize() );
          list.invalidate();
          // package private method syncListSelectionWithComboBoxSelection(); included
          int selectedIndex = comboBox.getSelectedIndex();

          if ( selectedIndex == -1 ) {
            list.clearSelection();
          }
          else {
            list.setSelectedIndex( selectedIndex );
          }

            list.ensureIndexIsVisible( list.getSelectedIndex() );

            setLightWeightPopupEnabled( comboBox.isLightWeightPopupEnabled() );

            show( comboBox, popupBounds.x, popupBounds.y );
          }
        };
          popup.getAccessibleContext().setAccessibleParent(comboBox);
          return popup;
      }
    }

}
