package newtimes.basic.chinese_area;

import java.awt.*;
import javax.swing.*;
import java.util.Vector;
import database.datatype.Record;
import java.awt.event.*;
public class DlgEditAreaCity extends JDialog {
  JPanel panel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtAreaEnglish = new JTextField();
  JTextField txtAreaChn = new JTextField();
  JScrollPane jScrollPane1 = new JScrollPane();
  JPanel pnlContantCity = new JPanel();
  JButton btnOK = new JButton();
  JButton btnEXIT = new JButton();
  GridLayout gridLayout=null;
  JCheckBox cities[];
  Vector usingCitys;
  Vector availableCitys;
  Record editingAreaRecord;
  GridLayout gridLayout1 = new GridLayout();
  DB_AreaDb dbHandler=null;
  int pk=0;
  Vector city_data_2_add=new Vector();
  exgui.ultratable.AbstractUltraTablePanel _pnl;
  public DlgEditAreaCity(Frame frame,
                         String title,
                         boolean modal,
                         DB_AreaDb handler,
                         int area_pk,
                         exgui.ultratable.AbstractUltraTablePanel pnl
                           ) {
    super(frame, title, modal);
    try {
      jbInit();
      dbHandler=handler;
      pk=area_pk;
      if(area_pk!=-1){
        editingAreaRecord = dbHandler.findByPk(area_pk);
        String orgAreaEng=(String)editingAreaRecord.get(1);
        String orgAreaChz=(String)editingAreaRecord.get(2);
        txtAreaEnglish.setText(orgAreaEng);
        txtAreaChn.setText((orgAreaChz==null)?"":orgAreaChz);
      }else{
        editingAreaRecord = dbHandler.getBlankRecord();
        dbHandler.allocatedCityRecords=new Vector();
      }
      usingCitys=dbHandler.allocatedCityRecords;
      availableCitys=dbHandler.getCityToSelect();
      cities=new JCheckBox[usingCitys.size()+availableCitys.size()];
      pnlContantCity.removeAll();
      gridLayout=new GridLayout(cities.length,1);
      pnlContantCity.setLayout(gridLayout);
      int count=0;
      for(int i=0;i<usingCitys.size();i++){
        Record rec=(Record)usingCitys.get(i);
        String engName=(String)rec.get(1);
        String chzName=(String)rec.get(2);
        String cbxtitle=engName;
        if(chzName!=null){
          cbxtitle=cbxtitle+"("+chzName+")";
        }
        JCheckBox cbx=new JCheckBox();
        cbx.setText(cbxtitle);
        cbx.setSelected(true);
        cities[count]=cbx;
        pnlContantCity.add(cities[count]);
        city_data_2_add.add(rec);
        count++;
      }
      for(int i=0;i<availableCitys.size();i++){
        Record rec=(Record)availableCitys.get(i);
        String engName=(String)rec.get(1);
        String chzName=(String)rec.get(2);
        String cbxtitle=engName;
        if(chzName!=null){
          cbxtitle=cbxtitle+"("+chzName+")";
        }
        JCheckBox cbx=new JCheckBox();
        cbx.setText(cbxtitle);
        cbx.setSelected(false);
        cities[count]=cbx;
        pnlContantCity.add(cities[count]);
        city_data_2_add.add(rec);
        count++;
      }
      pack();
      _pnl=pnl;
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public DlgEditAreaCity() {
    this(null, "", false,null,0,null);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(null);
    jLabel1.setText("AREA NAME:");
    jLabel1.setBounds(new Rectangle(19, 40, 102, 22));
    jLabel2.setBounds(new Rectangle(20, 72, 102, 22));
    jLabel2.setText("區域中文名稱:");
    txtAreaEnglish.setText("");
    txtAreaEnglish.setBounds(new Rectangle(127, 41, 186, 23));
    txtAreaChn.setText("");
    txtAreaChn.setBounds(new Rectangle(127, 72, 186, 24));
    jScrollPane1.setBounds(new Rectangle(19, 110, 335, 216));
    btnOK.setBounds(new Rectangle(41, 336, 99, 26));
    btnOK.setText("UPDATE");
    btnOK.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnOK_actionPerformed(e);
      }
    });
    btnEXIT.setBounds(new Rectangle(240, 336, 99, 26));
    btnEXIT.setText("EXIT");
    btnEXIT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnEXIT_actionPerformed(e);
      }
    });
    //pnlContantCity.setLayout(gridLayout1);
    //gridLayout1.setColumns(1);
    getContentPane().add(panel1);
    panel1.add(jLabel2, null);
    panel1.add(jLabel1, null);
    panel1.add(txtAreaEnglish, null);
    panel1.add(txtAreaChn, null);
    panel1.add(jScrollPane1, null);
    jScrollPane1.getViewport().add(pnlContantCity, null);
    panel1.add(btnEXIT, null);
    panel1.add(btnOK, null);
  }

  void btnOK_actionPerformed(ActionEvent e) {
    if(txtAreaChn.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input chinese Area  Name",
                                             "Please Input chinese Area  Name");
      return;
    }
    if(txtAreaEnglish.getText().trim().length()==0){
      exgui.verification.VerifyLib.showAlert("Please Input Area  Name",
                                             "Please Input Area  Name");
      return;
    }
    editingAreaRecord.set(1,txtAreaEnglish.getText().trim());
    editingAreaRecord.set(2,txtAreaChn.getText().trim());
   Vector vct2Add=new Vector();
   for(int i=0;i<cities.length;i++){
     JCheckBox chkbox=cities[i];
     if(chkbox.isSelected()){
       vct2Add.add(city_data_2_add.get(i));
     }
   }
   if(vct2Add.size()==0){
     exgui.verification.VerifyLib.showAlert("Please Select A City To This Area",
                                            "Please Select A City");
     return;
   }
   try{
     util.MiscFunc.showProcessingMessage();
     dbHandler.allocatedCityRecords = vct2Add;
     if (pk < 0) {
       editingAreaRecord.set("record_create_user",
                             util.PublicVariable.USER_RECORD.get("usr_code"));
       dbHandler.addRecord(editingAreaRecord);
     } else {
       editingAreaRecord.set("record_modify_user",
                             util.PublicVariable.USER_RECORD.get("usr_code"));
       dbHandler.updateRecord(editingAreaRecord);
     }
     _pnl.reload();
     dispose();
   }catch(Exception exp){
     exp.printStackTrace();
     util.ExceptionLog.exp2File(exp,"");
     exgui.verification.VerifyLib.showAlert("Error While Update Area & Cities\nPlease Contact System Manager",
                                            "Error In Updating Data");
   }finally{
     util.MiscFunc.hideProcessingMessage();
   }
  }

  void btnEXIT_actionPerformed(ActionEvent e) {
    this.dispose();
  }
}
