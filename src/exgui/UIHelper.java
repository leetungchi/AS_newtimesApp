package exgui;
import javax.swing.*;
import database.datatype.Record;
import java.util.*;
import util.MiscFunc;
import java.awt.*;
/**
 * <p>Title: Swing GUI Helper Class,provde some function for gui.</p>
 * <p>Description: Swing GUI Helper Class,provde some function for gui.</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: inforich.com.tw</p>
 * @author John.Cheng(Crazy John)
 * @version 0.01
 */

public class UIHelper {
   public static UIHelper uihelper=null;
   private UIHelper(){
   }
   /**
    * to allow client class to get icon image for image folder ,according to default class recource path
    * @param fileName,the file name of image to get
    * @return javax.swing.ImageIcon,if null,means no such image in mage folder of class resource
    */
   static public ImageIcon getIcon(String fileName){
    if(uihelper==null) uihelper=new UIHelper();
    /*
    System.out.println(
    "uihelper get image at:"+
    uihelper.getClass().getClassLoader().getResource("images/"+fileName)
    );*/

    return new ImageIcon(uihelper.getClass().getClassLoader().getResource("images/"+fileName));
   }
   static public void setToScreenCenter(java.awt.Window windowObj){
     if(windowObj==null) return;
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      windowObj.setBounds((screenSize.width - windowObj.getWidth()) / 2,
       (screenSize.height - windowObj.getHeight()) / 2,
       windowObj.getWidth(),windowObj.getHeight());
   }
   /**
    * to find out the path string a file in classes folder
    * @param folderName--folder name
    * @return--phsycal path of this fold in classes folder of this application.
    * @throws Exception--null exception if folder is not found under classes folder of this application.
    */
   static public String getFolderPath(String folderName)throws Exception{
    if(uihelper==null) uihelper=new UIHelper();
     return uihelper.getClass().getClassLoader().getResource(folderName).getPath();
   }
   /**
    * to get url of files,sometime it's description of download jar files
    * @param destFileName
    * @return the java.net.url of the destFile
    * @throws Exception //java.io.exception.
    */
   static public java.net.URL  getFolderURL(String destFileName)throws Exception{
    if(uihelper==null) uihelper=new UIHelper();
     return uihelper.getClass().getClassLoader().getResource(destFileName);
   }

   /**
    * to mapping records(in vector) to jlist object,if the match column in recod matches selectedValue,hightlight the indeies of jlist
    * @param jlist--the gui object to bind to data
    * @param records--vector stores with records
    * @param showColumn--record column from which the string to show in list
    * @param matchColumn--target column data to search in each record
    * @param selectedValue--the match key ,by which to indicate the jlist index is to hightlight or not
    */
   static public void Data2JList(JList jlist,Vector records,String showColumn,String matchColumn,Object selectedValue){
     HashMap hm=new HashMap();
     hm.put(matchColumn,selectedValue);
     Data2JList(jlist,records,showColumn,hm);
   }
   /**
    * to mapping records(in vector) to jlist object,if recod matches the keys and datas in hashmap,hightlight the indeies of jlist
    * @param jlist--the gui object to bind to data
    * @param records--vector stores with records
    * @param showColumn--record column from which the string to show in list
    * @param obj2find--hashmap contains keys(string of fields in record) and object to find.
    */

   static public void Data2JList(JList jlist,Vector records,String showColumn,HashMap objs2find){
     jlist.removeAll();
     JlistDataModel myModel=new JlistDataModel(records,showColumn,objs2find);
     jlist.setModel(myModel);
     int selectAtArr[]=new int[myModel.selectedAt.size()];
     for(int i=0;i<myModel.selectedAt.size();i++){
       selectAtArr[i]=Integer.parseInt(myModel.selectedAt.get(i).toString());
     }
     jlist.setSelectedIndices(selectAtArr);
     //jlist.repaint();

   }

   /**
    * to mapping records(in vector) to jcombobox object,if the match column in recod matches selectedValue,hightlight the indeies of jcombobox
    * @param jcbx--jcombo box to binding data.
    * @param records--vector stores with records
    * @param showColumn--record column from which the string to show in list
    * @param matchColumn--target column data to search in each record
    * @param selectedValue--the match key ,by which to indicate the jlist index is to hightlight or not
    */

   static public void Data2ComboBox(JComboBox jcbx,Vector records,String showColumn,String matchColumn,Object selectedValue){
     HashMap hm=new HashMap();
     hm.put(matchColumn,selectedValue);
     Data2ComboBox(jcbx,records,showColumn,hm);
   }

   /**
    * to mapping records(in vector) to jcombobox object,if records matches keys and datas in hashmap,hightlight the indeies of jcombobox
    * @param jcbx--jcombo box to binding data.
    * @param records--vector stores with records
    * @param showColumn--record column from which the string to show in list
    * @param obj2find--hashmap contains keys(string of fields in record) and object to find.
    */
   static public void Data2ComboBox(JComboBox jcbx,Vector records,String showColumn,HashMap objs2find){
     Data2ComboBox(jcbx,records,showColumn,objs2find,null,null);
    /*
     try{
       for(int i=0;i<records.size();i++){
         Record rec=(Record)records.get(i);
         jcbx.addItem(rec.get(showColumn));
         //if((rec.get(matchColumn).toString().equalsIgnoreCase(selectedValue.toString()))) jcbx.setSelectedIndex(i);
         if(MiscFunc.isHashMapInRecod(rec,objs2find))jcbx.setSelectedIndex(i);
       }
     }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"exp while mapping vector record data to jcombobox object");
     }
     //jcbx.repaint();
     */
   }
   static protected void Data2ComboBox(JComboBox jcbx,Vector records,String showColumn,String matchColumn,Object objs2find,
                                       String iniString,String iniStringValue){
     boolean withNull=false;
     int showColAt=0;
     int matchColAt=0;
     if(iniString !=null){
       jcbx.addItem(iniString);
       jcbx.setSelectedIndex(0);
       jcbx.setSelectedItem(iniStringValue);
       withNull=true;
     }
     boolean objFind=false;
     try{
       for(int i=0;i<records.size();i++){
         if(i==0){
            showColAt=util.MiscFunc.getFieldIndexAtRecord((Record)records.get(0),showColumn);
            matchColAt=util.MiscFunc.getFieldIndexAtRecord((Record)records.get(0),matchColumn);
         }
         Record rec=(Record)records.get(i);
         //Object valObj=rec.get(showColumn);
         Object valObj=rec.get(showColAt);
         if(valObj!=null){
           jcbx.addItem(valObj);
         }else{
           jcbx.addItem("");
         }
         //if((rec.get(matchColumn).toString().equalsIgnoreCase(selectedValue.toString()))) jcbx.setSelectedIndex(i);
         if(withNull){
          if(util.MiscFunc.isEqual(rec.get(matchColAt),objs2find)){
            jcbx.setSelectedIndex(i + 1);
            objFind=true;
          }
         }else{
            if(util.MiscFunc.isEqual(rec.get(matchColAt),objs2find)){
             jcbx.setSelectedIndex(i);
             objFind=true;
           }
         }
       }
       if(!objFind && records!=null && records.size()>0)jcbx.setSelectedIndex(0);
       if(!objFind && jcbx.getItemCount() ==0)jcbx.setSelectedIndex(-1);
     }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"exp while mapping vector record data to jcombobox object");
     }
   }

   static protected void Data2ComboBox(JComboBox jcbx,Vector records,String showColumn,HashMap objs2find,String iniString,String iniStringValue){

     if(objs2find.keySet().size() ==1){
        String matchcolName=(String)objs2find.keySet().iterator().next();
        Object tgtObj=objs2find.get(matchcolName);
        Data2ComboBox(jcbx,records,showColumn,matchcolName,tgtObj,
                                       iniString,iniStringValue);
        return;
     }

     boolean withNull=false;
     int showColAt=0;
     if(iniString !=null){
       jcbx.addItem(iniString);
       jcbx.setSelectedIndex(0);
       jcbx.setSelectedItem(iniStringValue);
       withNull=true;
     }
     try{
       for(int i=0;i<records.size();i++){
         if(i==0) showColAt=util.MiscFunc.getFieldIndexAtRecord((Record)records.get(0),showColumn);
         Record rec=(Record)records.get(i);
         //Object valObj=rec.get(showColumn);
         Object valObj=rec.get(showColAt);
         if(valObj!=null){
           jcbx.addItem(valObj);
         }else{
           jcbx.addItem("");
         }
         //if((rec.get(matchColumn).toString().equalsIgnoreCase(selectedValue.toString()))) jcbx.setSelectedIndex(i);
         if(withNull){
          if(MiscFunc.isHashMapInRecod(rec,objs2find))jcbx.setSelectedIndex(i+1);
         }else{
           if(MiscFunc.isHashMapInRecod(rec,objs2find))jcbx.setSelectedIndex(i);
         }
       }
     }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"exp while mapping vector record data to jcombobox object");
     }
     //jcbx.repaint();
   }


   /**
    * to binding recods to jradio buttons,if selectedValue matches data in matchColumn of record,checked the radio box
    * @param jpanel2containt--the target jpanel which to display radio button,if null,not do "add(JRadioButton)" process
    * @param btnGrp--the radiobutton group to add buttons
    * @param records--vector stores with records
    * @param showColumn--record column from which the string to show in list
    * @param matchColumn--target column data to search in each record
    * @param selectedValue--the match key ,by which to indicate the jlist index is to hightlight or not
    * @return the rendered jradiobuttons belongs to this buttongroup
    */
   static public JRadioButton[] Data2GrpButton(JPanel jpanel2containt,ButtonGroup btnGrp,Vector records,String showColumn,String matchColumn,Object selectedValue){
     HashMap hm=new HashMap();
     hm.put(matchColumn,selectedValue);
     return Data2GrpButton(jpanel2containt,btnGrp,records,showColumn,hm);
   }

   /**
    * to binding recods to jradio buttons,if hashmap contains keys and datas in some records,checked the radio box
    * @param jpanel2containt--the target jpanel which to display radio button,if null,not do "add(JRadioButton)" process
    * @param btnGrp--the radiobutton group to add buttons
    * @param records--vector stores with records
    * @param showColumn--record column from which the string to show in list
    * @param objs2find --hashmap to check if keys and datas in records or not
    * @return the rendered jradiobuttons belongs to this buttongroup
    */
   static public JRadioButton[] Data2GrpButton(JPanel jpanel2containt,ButtonGroup btnGrp,Vector records,String showColumn,HashMap objs2find){
     JRadioButton jrb[]=new JRadioButton[0];
     ArrayList buttons_arr=new ArrayList();
     boolean need2Add2panel=!(jpanel2containt==null);
     try{
       for(int i=0;i<records.size();i++){
         Record rec=(Record)records.get(i);
         JRadioButton tempBtn=null;
         //if((rec.get(matchColumn).toString().equalsIgnoreCase(selectedValue.toString()))){
         if(MiscFunc.isHashMapInRecod(rec,objs2find)){
           tempBtn=new JRadioButton(rec.get(showColumn).toString(),true);
         }else{
           tempBtn=new JRadioButton(rec.get(showColumn).toString());
         }
         btnGrp.add(tempBtn);
         buttons_arr.add(tempBtn);
         if(need2Add2panel)jpanel2containt.add(tempBtn);
       }
     }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"exp while mapping vector record data to jbutton group object");
     }
     return (JRadioButton[])buttons_arr.toArray(jrb);
   }

   /**
    * to binding recods to jcheckboxes,if selectedValue matches data in matchColumn of record,checked the jcheckboxes
    * @param jpanel2containt--the target jpanel which to display jcheckbox,if null,not do "add(JCheckBox)" process
    * @param records--vector stores with records
    * @param showColumn--record column from which the string to show in list
    * @param matchColumn--target column data to search in each record
    * @param selectedValue--the match key ,by which to indicate the jlist index is to hightlight or not
    * @return jcheckBox according to elements of records in vector
    */
   static public JCheckBox[] Data2ChkBox(JPanel jpanel2containt,Vector records,String showColumn,String matchColumn,Object selectedValue){
     HashMap hm=new HashMap();
     hm.put(matchColumn,selectedValue);
    return Data2ChkBox(jpanel2containt,records,showColumn,hm);
   }
   /**
    * to binding recods to jcheckboxes,if datas and keyes of hashmap exists in some records,checked the jcheckboxes
    * @param jpanel2containt--the target jpanel which to display jcheckbox,if null,not do "add(JCheckBox)" process
    * @param records--vector stores with records
    * @param showColumn--record column from which the string to show in list
    * @param objs2find--hashmap contains keys and data to find.
    * @return jcheckBox according to elements of records in vector
    */
   static public JCheckBox[] Data2ChkBox(JPanel jpanel2containt,Vector records,String showColumn,HashMap objs2find){
     JCheckBox jcbx[]=new JCheckBox[0];
     ArrayList boxes=new ArrayList();
     boolean need2Add2panel=!(jpanel2containt==null);
     try{
       for(int i=0;i<records.size();i++){
         Record rec=(Record)records.get(i);
         JCheckBox  tempBtn=null;
         if(MiscFunc.isHashMapInRecod(rec,objs2find)){
           tempBtn=new JCheckBox(rec.get(showColumn).toString(),true);
         }else{
           tempBtn=new JCheckBox(rec.get(showColumn).toString());
         }
         jpanel2containt.add(tempBtn);
         boxes.add(tempBtn);
         if(need2Add2panel)jpanel2containt.add(tempBtn);
       }
     }catch(Exception e){
       e.printStackTrace();
       util.ExceptionLog.exp2File(e,"exp while mapping vector record data to jbutton group object");
     }
     //if(need2Add2panel) jpanel2containt.repaint();
     return (JCheckBox[])boxes.toArray(jcbx);
   }
   /**
    * to find out objects in array,according selected jcheckboxes,mapping to records and name of record
    * @param jbxes--JCheckBox ,generated by Data2ChkBox method
    * @param records--vectored reocrds ,used as Data2ChkBox parameter
    * @param getColumn--the index string as column name to find out in record
    * @return object array stored at field index by column in records.
    */
  static public Object[] ChkBox2Data(JCheckBox[] jbxes,Vector records,String getColumn){
    ArrayList objArr=new ArrayList();
    Object objs[]=new Object[0];
    try{
      for(int i=0;i<jbxes.length;i++){
       if(jbxes[i].isSelected()){
         Record rec=(Record)records.get(i);
         objArr.add(rec.get(getColumn));
       }
    }
    }catch(Exception e){
     e.printStackTrace();
     util.ExceptionLog.exp2File(e,"xp while get data objects chkbox2data");
     return null;
    }
    return objArr.toArray(objs);
  }
  /**
   * get objects stored in records according to column name.
   * @param jlist--JList
   * @param records--records to mapping,refer to Data2GrpButton parameter "Records"
   * @param getColumn--to index the column in record
   * @return Object[]--object stored in records at the column name field
   */
  static public Object[] Jlist2Data(JList jlist,Vector records,String getColumn){
    ArrayList objArr=new ArrayList();
    Object objs[]=new Object[0];
    try{
    int indeies[]=jlist.getSelectedIndices();
    for(int i=0;i<indeies.length;i++){
       Record rec=(Record)records.get(indeies[i]);
       objArr.add(rec.get(getColumn));
    }
    }catch(Exception e){
     e.printStackTrace();
     util.ExceptionLog.exp2File(e,"xp while get data objects chkbox2data");
     return null;
    }
    return objArr.toArray(objs);
  }
  /**
   * to get objct stored at column in records index by jcombobox selected index
   * @param jcmbx--jcombobox
   * @param records--records,refered by Data2ComboBox
   * @param getColumn--the column name to index field in record
   * @return Object--object stored in record.get(getColumn)
   */
  static public Object ComboBox2Data(JComboBox jcmbx,Vector records,String getColumn){
    Record rec=(Record)records.get(jcmbx.getSelectedIndex());
    try{
     return rec.get(getColumn);
    }catch(Exception e){
     e.printStackTrace();
     util.ExceptionLog.exp2File(e,"exp while mapping selected item to object");
     return null;
    }
  }
  /**
   * get object stored in records according to JRadio Button index and column name
   * @param jrbtns--JRadioButtons array.refer to Data2GrpButton parameter "ButtonGroup"
   * @param records--records to mapping,refer to Data2GrpButton parameter "Records"
   * @param getColumn--to index the column in record
   * @return Object--object stored in record at the column name field
   */
  static public Object RadioButtons2Data(JRadioButton jrbtns[],Vector records,String getColumn){
    Object obj2Return=null;
    for(int i=0;i<jrbtns.length;i++){
      if(jrbtns[i].isSelected()){
        Record rec=(Record)records.get(i);
        try{
          obj2Return=rec.get(getColumn);
          break;
        }catch(Exception e){
           e.printStackTrace();
           util.ExceptionLog.exp2File(e,"exp while get JRadioButton to data");
           break;
        }
      }
    }
    return obj2Return;
  }
  /**
   * to assign focuse sequecence for jcomponents,to enable TAB & Shift-Tab to shifting focus.
   * this is for JTextField or JTable to use.
   * @param prvFxObj--previouse focuse jcomponet
   * @param nxtFxObj--next focuse jcomponet
   * @parma thisObj--subject jcomponet
   */
 static public void setFocusChain(final JComponent prvFxObj,final JComponent nxtFxObj,JComponent thisObj){
   java.awt.event.KeyAdapter kadp=new java.awt.event.KeyAdapter(){
      public void keyPressed(java.awt.event.KeyEvent e){
       if(e.getKeyCode()==java.awt.event.KeyEvent.VK_TAB){
         if(e.isShiftDown()){
           prvFxObj.grabFocus();
         }else{
           nxtFxObj.grabFocus();
         }
         e.setKeyCode(0);
       }
      }
   };
   thisObj.addKeyListener(kadp);
 }
 /**
  * for ordinary JComponent to set next focus Jcomponet as chained process.
  * @param jcomponents--jcomponents stored in vector
  */
 static public void setFocusChain(java.util.Vector jcomponents){
   for(int i=0;i<jcomponents.size()-1;i++){
     JComponent jcpn=(JComponent) jcomponents.get(i);
     jcpn.setNextFocusableComponent((JComponent) jcomponents.get(i+1));
   }
 }
}
