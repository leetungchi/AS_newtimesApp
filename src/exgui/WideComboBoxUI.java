package exgui;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import java.util.*;
import java.awt.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

  public class WideComboBoxUI extends BasicComboBoxUI{
                int specifiedPopWidth=0;
                public WideComboBoxUI(int assignedWidth){
                  super();
                  specifiedPopWidth=assignedWidth;
                }
		public ComboPopup createPopup(){
		    MyComboPopup popup = new MyComboPopup( comboBox,specifiedPopWidth );
		    popup.getAccessibleContext().setAccessibleParent(comboBox);
		    return popup;
		}

      private class MyComboPopup extends BasicComboPopup{
               int myPopWidth=0;
		public MyComboPopup(JComboBox combo){
			super(combo);
		}

		public MyComboPopup(JComboBox combo,int width){
			super(combo);
                        myPopWidth=width;
		}

		public void show(){
		    int widthScaleFactor=5;
			Dimension popupSize = comboBox.getSize();
                    if(myPopWidth==0){
		        popupSize.setSize( popupSize.width*widthScaleFactor, getPopupHeightForRowCount( comboBox.getMaximumRowCount() ) );
                    }else{
                       popupSize.setSize(myPopWidth, getPopupHeightForRowCount( comboBox.getMaximumRowCount() ) );
                    }
		    Rectangle popupBounds = computePopupBounds( 0, comboBox.getBounds().height,
		                                                popupSize.width, popupSize.height);
		    scroller.setMaximumSize( popupBounds.getSize() );
		    scroller.setPreferredSize( popupBounds.getSize() );
		    scroller.setMinimumSize( popupBounds.getSize() );
		    list.invalidate();
		    syncListSelectionWithComboBoxSelection();
		    list.ensureIndexIsVisible( list.getSelectedIndex() );

		    setLightWeightPopupEnabled( comboBox.isLightWeightPopupEnabled() );

		    show( comboBox, popupBounds.x, popupBounds.y );
		}

		protected void syncListSelectionWithComboBoxSelection()
		{
			int selectedIndex = comboBox.getSelectedIndex();

			if ( selectedIndex == -1 ){
			    list.clearSelection();
			}else{
			    list.setSelectedIndex( selectedIndex );
			}
		}
	}
}