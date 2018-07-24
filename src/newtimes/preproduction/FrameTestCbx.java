package newtimes.preproduction;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameTestCbx extends JFrame {
  JPanel contentPane;
      String data[]={"            a         你看夠了吧        OK?",
                     "            b        還沒看夠嗎?        Not OK",
                     "            C      再看.也不見的會吧?    Taiwan 1st!"};

  JComboBox jComboBox1 = new JComboBox(data);

  //Construct the frame
  public FrameTestCbx() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //Component initialization
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setSize(new Dimension(400, 300));
    this.setState(Frame.NORMAL);
    this.setTitle("Frame Title");
    jComboBox1.setUI(new exgui.WideComboBoxUI(150));
    jComboBox1.setBounds(new Rectangle(61, 82, 74, 18));
    contentPane.add(jComboBox1, null);
    MyCellRenderer rdr=new MyCellRenderer();
    rdr.setPreferredSize(new Dimension(200, 130));
    jComboBox1.setRenderer(new MyCellRenderer());
  }
  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

class MyCellRenderer extends JLabel implements ListCellRenderer {

  public MyCellRenderer() {
      setOpaque(true);
  }

  public Component getListCellRendererComponent(
      JList list,
      Object value,
      int index,
      boolean isSelected,
      boolean cellHasFocus)
  {
      setText(value.toString());
      setBackground(isSelected ? Color.red : Color.white);
      setForeground(isSelected ? Color.white : Color.black);
      return this;
  }
  public void paintComponents(Graphics g){
       g.setColor(Color.black);
       g.drawLine(0,0,100,200);
  }
}

}