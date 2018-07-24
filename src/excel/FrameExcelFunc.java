package excel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.util.*;
import jxl.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class FrameExcelFunc extends JFrame {
  JPanel contentPane;
  JButton jButton1 = new JButton();

  //Construct the frame
  public FrameExcelFunc() {
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
    jButton1.setBounds(new Rectangle(374, 323, 132, 41));
    jButton1.setText("jButton1");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    contentPane.setLayout(null);
    this.setSize(new Dimension(606, 410));
    this.setTitle("Frame Title");
    contentPane.add(jButton1, null);
  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }
  public void batchHandl(String[] clm0To8,Vector vctBrfQty){

  }
  public boolean isNewRec(String[] str,Cell[] cells){
    for(int i=0;i<8;i++){
      if(!str[i].equalsIgnoreCase(cells[i].getContents())){
        return true;
      }
    }
    return false;
  }
  void jButton1_actionPerformed(ActionEvent e) {
    Workbook workbook=null;
    try{
      workbook = Workbook.getWorkbook(new File("D:/NewtimesChloeClient/NewtimesApp/upload_sample.xls"));
      Sheet sheet = workbook.getSheet(0);
      Vector lastHandledBrfQty=null;
      String lastHeadCells[]={"","","","","","","",""};
      for(int i=0;i<6;i++){
        Cell[] cells = sheet.getRow(i);
        if(i==0){
          for(int j=0;j<8;j++)lastHeadCells[j]=cells[j].getContents();
          lastHandledBrfQty=new Vector();
        }
        if(isNewRec(lastHeadCells,cells)){
          batchHandl(lastHeadCells,lastHandledBrfQty);
          for(int j=0;j<8;j++)lastHeadCells[j]=cells[j].getContents();
          lastHandledBrfQty=new Vector();
        }
        //new BrfQty record,
        for(int j=8;j<cells.length;j++){
          //set to brf qty record
        }
        //add to lastHandledBrfQty
      }

    }catch(Exception exp){
      exp.printStackTrace();
    }finally{
      workbook.close();
    }

  }
}
