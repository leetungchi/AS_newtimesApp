package util;
import java.util.StringTokenizer;
import java.util.Vector;
import java.sql.Date;
import java.util.Calendar;
import java.net.*;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.io.*;
import sun.net.www.protocol.http.*;
import sun.net.www.http.HttpClient;
import java.util.Properties;
import java.util.ArrayList;
import java.math.*;
import database.datatype.Record;

/**
 * Title:the miscellaneous functions liabaray
 * Description:miscellaneous functions ,depens on case need.
 * Copyright:    Copyright (c) 2001
 * Company:inforich.com.tw
 * @author John.Cheng(Crazy John)
 * @version 1.0
 */

public class MiscFunc {
  static Thread processMsgThread=null;
  static FrameProcessingBar msgframe=null;
  static DlgPrgsBar dlgProcessing=null;
  static boolean isToShowProcessingBar=false;
  static protected String  JAR_CACHE_FOLDER=null;
  static protected MiscFunc InstanceOfMine=null;
  static protected java.text.DateFormat dateformateobj=new java.text.SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
  protected MiscFunc(){
    super();
    if(JAR_CACHE_FOLDER==null){
        final java.net.URL location;
        final String classLocation = this.getClass().getName().replace('.', '/') + ".class";
        final ClassLoader loader = this.getClass().getClassLoader();
        if (loader == null) {
          location = ClassLoader.getSystemResource(classLocation);
        } else {
          location = loader.getResource(classLocation);
        }
        if (location != null ) {
          String urlString=location.toString();
          System.out.println("getJarLocation() url of MAIN CLASS IS----"+urlString);
          if(!"jar".equals(location.getProtocol())){

          }else{
            //this class is now located in jar file,
            //file path is like that jar:file:C:/x/y/z.jar!/com/foo/bar/Baz.class
            if(urlString.startsWith("jar:file:")){
              String floderAt=urlString.substring(9,urlString.lastIndexOf("!"));
              //--/C:/Program Files/....... brabrabar,so you have to add "file:" begin.
              JAR_CACHE_FOLDER=""+floderAt.substring(0,floderAt.lastIndexOf("/")+1);
              System.out.println("JarFolderAt detemened!! --"+JAR_CACHE_FOLDER);

            }
          }

        }
    }

  }
  static class ProcFrmRunner implements Runnable{
    public void run(){
      while (true) {
        try {
         //if (isToShowProcessingBar && dlgProcessing!=null && dlgProcessing.isVisible()){
         if (isToShowProcessingBar &&  dlgProcessing.isVisible()){
            dlgProcessing.lblAnimation.paint(dlgProcessing.lblAnimation.getGraphics());
             //return;
          //}else if (isToShowProcessingBar && dlgProcessing==null ) {
           }else if (isToShowProcessingBar && !dlgProcessing.isVisible()) {
            dlgProcessing.setSize(250, 100);
            exgui.UIHelper.setToScreenCenter(dlgProcessing);
            dlgProcessing.validate();
            dlgProcessing.setVisible(true);
            //dlgProcessing.show();
            //msgframe.show();
            dlgProcessing.paint(dlgProcessing.getGraphics());
            dlgProcessing.paintAll(dlgProcessing.getGraphics());
            dlgProcessing.lblAnimation.paint(dlgProcessing.lblAnimation.getGraphics());
            //return;
          //}else  if (!isToShowProcessingBar && dlgProcessing!=null && dlgProcessing.isVisible()){
            }else  if (!isToShowProcessingBar &&  dlgProcessing.isVisible()){
            dlgProcessing.setVisible(false);
            //dlgProcessing.dispose();
            //dlgProcessing=null;
            //return;
          }
          Thread.currentThread().sleep(10);
        } catch (Exception exp) {

        }
      }
    }
  }
  protected static void initMsgFrame(){
    if(processMsgThread==null){
     isToShowProcessingBar=false;
     dlgProcessing=new DlgPrgsBar(util.PublicVariable.APP_FRAME,"   Processing...",false);
     //msgframe=new FrameProcessingBar();
     processMsgThread=new Thread(new ProcFrmRunner());
     processMsgThread.setPriority(Thread.MAX_PRIORITY);
     processMsgThread.start();
    }
  }
  public static void showProcessingMessage(){
    initMsgFrame();
    isToShowProcessingBar=true;
    /*
    if(dlgProcessing!=null && !dlgProcessing.isVisible()){
      dlgProcessing.setSize(250, 100);
      exgui.UIHelper.setToScreenCenter(dlgProcessing);
      dlgProcessing.validate();
      dlgProcessing.setVisible(true);
      //dlgProcessing.show();
      //msgframe.show();
      dlgProcessing.paint(dlgProcessing.getGraphics());
      dlgProcessing.paintAll(dlgProcessing.getGraphics());
      dlgProcessing.lblAnimation.paint(dlgProcessing.lblAnimation.getGraphics());
    }
    */
  }
  public static void hideProcessingMessage(){
    initMsgFrame();
    isToShowProcessingBar=false;
    if(dlgProcessing!=null && dlgProcessing.isVisible())dlgProcessing.setVisible(false);
    //msgframe.setVisible(false);
  }

  static public String table2Text(javax.swing.JTable tbl){
    StringBuffer totalSB=new StringBuffer();
    int  maxLength[]=new int[tbl.getColumnCount()];
    String modelData[][]=
        new String[tbl.getRowCount()+1][tbl.getColumnCount()];
    String blanks="                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ";
    //fisrt is to trevorse all the cell,and determ the max char of each column
    for(int j=0;j<tbl.getColumnCount();j++){
      maxLength[j]=0;
      for (int i = -1; i < tbl.getRowCount(); i++) {
        Object cellData=null;
        if (i==-1){
           cellData=tbl.getColumnName(j);
           if(cellData!=null){
            cellData= util.MiscFunc.Replace(cellData.toString(),"¡¿"," ");
           }
        }else{
          cellData = tbl.getValueAt(i, j);
        }
        String cellDataString=
          (cellData==null)?"":cellData.toString();

        if(cellDataString.length()>maxLength[j]){
          maxLength[j]=(cellDataString.length())+1;//at least,leading a space.
        }
        modelData[i+1][j]=cellDataString;
      }
    }
    for(int i=0;i<tbl.getRowCount()+1;i++){
      for(int j=0;j<tbl.getColumnCount();j++ ){
         String destString=blanks.substring(0,maxLength[j]-modelData[i][j].length()+1) +modelData[i][j];
             //complementStringAlignRight(' ',modelData[i][j],maxLength[j]-modelData[i][j].length()+1);

         totalSB.append(destString);
      }
      //at each row,append the return character.
      totalSB.append("\n");
    }
   return totalSB.toString();
  }
  public static void installEJBStubJar(String downloadFolderURL,String jarFileName)throws Exception{
    if(JAR_CACHE_FOLDER==null)InstanceOfMine=new MiscFunc();
    if(JAR_CACHE_FOLDER==null){
      exgui.verification.VerifyLib.showAlert("CURRENT APP SHOULD RUN AT jar-app-mode\nPlease Contact System Manager",
                            "Plase Use newtimes Netx Webstart Launcher to download & add this plug in");
      throw new  Exception ("APP SHOULD LAUNCHED BY Netx webStart");
    }
    boolean haveToDownload=false;
    java.io.File orgJarFile=new java.io.File(JAR_CACHE_FOLDER+jarFileName);
    String url2dowload=downloadFolderURL+"/"+jarFileName;
    boolean isOrgJarExists=orgJarFile.exists();
    java.net.URLConnection con=util.MiscFunc.EnableTimeOutURLConnection(url2dowload,30000);
    con.connect();

    if(isOrgJarExists){
      java.io.File file2download=new java.io.File(url2dowload);
      java.sql.Date dateOrg=new java.sql.Date(orgJarFile.lastModified());
      java.sql.Date dateLastModifyDate=new java.sql.Date(con.getLastModified());

      System.out.println("Modify date of Org jar file is :"+dateformateobj.format(dateOrg));
      System.out.println("Modify date of NEW jar file is :"+dateformateobj.format(dateLastModifyDate));

      if(dateOrg.before(dateLastModifyDate)){
        orgJarFile.delete();
        haveToDownload=true;
      }
    }else{
      haveToDownload=true;
    }

    if(haveToDownload){
         System.out.println("downloading jar:"+jarFileName);
         showProcessingMessage();
         java.io.InputStream fi=con.getInputStream();
        // if(!isOrgJarExists)orgJarFile.createNewFile();
         java.io.FileOutputStream fo=new java.io.FileOutputStream(orgJarFile);
         byte[] buff=new byte[1024];
         int byteRead=0;
         while((byteRead=fi.read(buff))!=-1){
           fo.write(buff,0,byteRead);
         }
         fi.close();
         fo.flush();
         fo.close();
         hideProcessingMessage();
         System.out.println("download finished jar:"+jarFileName);
    }
    ClassLoader xLoader = URLClassLoader.newInstance(new URL[]{orgJarFile.toURL()},
                                    Thread.currentThread().getContextClassLoader());
    Thread.currentThread().setContextClassLoader(xLoader);
  }
  public static Class installJAR(String downloadFolderURL,String jarFileName,String className)throws Exception{
   if(JAR_CACHE_FOLDER==null)InstanceOfMine=new MiscFunc();
   if(JAR_CACHE_FOLDER==null){
     exgui.verification.VerifyLib.showAlert("CURRENT APP SHOULD RUN AT jar-app-mode\nPlease Contact System Manager",
                           "Plase Use newtimes Netx Webstart Launcher to download & add this plug in");
     throw new  Exception ("APP SHOULD LAUNCHED BY Netx webStart");
   }
   boolean haveToDownload=false;
   java.io.File orgJarFile=new java.io.File(JAR_CACHE_FOLDER+jarFileName);
   String url2dowload=downloadFolderURL+"/"+jarFileName;
   boolean isOrgJarExists=orgJarFile.exists();
   java.net.URLConnection con=util.MiscFunc.EnableTimeOutURLConnection(url2dowload,10000);
   con.connect();

   if(isOrgJarExists){
     java.io.File file2download=new java.io.File(url2dowload);
     java.sql.Date dateOrg=new java.sql.Date(orgJarFile.lastModified());
     java.sql.Date dateLastModifyDate=new java.sql.Date(con.getLastModified());

     System.out.println("Modify date of Org jar file is :"+dateformateobj.format(dateOrg));
     System.out.println("Modify date of NEW jar file is :"+dateformateobj.format(dateLastModifyDate));

     if(dateOrg.before(dateLastModifyDate)){
       orgJarFile.delete();
       haveToDownload=true;
     }
   }else{
     haveToDownload=true;
   }

   if(haveToDownload){
        System.out.println("downloading jar:"+jarFileName);
        showProcessingMessage();
        java.io.InputStream fi=con.getInputStream();
       // if(!isOrgJarExists)orgJarFile.createNewFile();
        java.io.FileOutputStream fo=new java.io.FileOutputStream(orgJarFile);
        byte[] buff=new byte[1024];
        int byteRead=0;
        while((byteRead=fi.read(buff))!=-1){
          fo.write(buff,0,byteRead);
        }
        fi.close();
        fo.flush();
        fo.close();
        hideProcessingMessage();
        System.out.println("download finished jar:"+jarFileName);
   }
   ClassLoader xLoader = URLClassLoader.newInstance(new URL[]{orgJarFile.toURL()},
                                   Thread.currentThread().getContextClassLoader());
   //Thread.currentThread().setContextClassLoader(xLoader);
   return xLoader.loadClass(className);
   /*
   boolean isAlreadyInClassPath=false;
   ClassLoader previous = Thread.currentThread().getContextClassLoader();
   if(previous instanceof java.net.URLClassLoader ){
     java.net.URLClassLoader testLoader=(java.net.URLClassLoader)previous;
     java.net.URL[] urls=testLoader.getURLs();
     for(int i=0;i<urls.length;i++){
       System.out.println(" url classpath is :"+urls[i].getPath());
       if(urls[i].getPath().indexOf(jarFileName)!=-1){
         isAlreadyInClassPath=true;
         break;
       }
     }
   }
   if(isAlreadyInClassPath)return;
   ClassLoader xLoader = URLClassLoader.newInstance(new URL[]{orgJarFile.toURL()}, previous);
   //for "SUN's" webstart,will counter the security exception while calls Thead's "setContextClassLoader" Function
   Thread.currentThread().setContextClassLoader(xLoader);
   */
  }
  public static String complementStringAlignRight(char char2Leading,String string2Follow,int length){
    if(string2Follow==null)return null;
    if(string2Follow.length()>=length)return string2Follow.substring(0,length);
    char chars[]=new char[length];
    java.util.Arrays.fill(chars,char2Leading);
    String leadingStr=new String(chars);
    return  string2Follow+leadingStr.substring(0, length - string2Follow.length()) ;
  }

  /**
   * to complete string with leading characters.
   * @param char2Leading char
   * @param string2Follow String
   * @param length int
   * @return String
   */
  public static String complementString(char char2Leading,String string2Follow,int length){
    if(string2Follow==null)return null;
    if(string2Follow.length()>=length)return string2Follow.substring(0,length);
    char chars[]=new char[length];
    java.util.Arrays.fill(chars,char2Leading);
    String leadingStr=new String(chars);
    return  leadingStr.substring(0, length - string2Follow.length()) +string2Follow;
  }


  /**
   * compose text array with top row and button row with dashes
   * as text table format.
   * @param txtArr String[]
   * @param rows int
   * @param columns int
   * @return String
   */
  static public String txtArrayToTableNoDeshLine(String txtArr[],int rows,int columns){
   //to remove the price column
   StringBuffer totalSB=new StringBuffer();
   int  maxLength[]=new int[columns];
   String modelData[][]=new String[rows][columns];
   String blanks="                                        ";
   //fisrt is to trevorse all the cell,and determ the max char of each column
   //copy "TOTAL:" to column before price column of last row.
   //tbl.setValueAt("TOTAL:",tbl.getRowCount()-1,priceColumnAt-1);
   int colBegin=0;
   for(int j=0;j<columns;j++){
     maxLength[j]=0;
     for (int i = 0; i < rows; i++) {
         String cellData = txtArr[i*columns+j];
         String cellDataString =
             (cellData == null) ? "" : cellData.toString();

         if (cellDataString.length() > maxLength[j]) {
           maxLength[j] = (cellDataString.length()) + 1; //at least,leading a space.
         }
         modelData[i][j] = cellDataString;
     }
   }
   int maxDshLength=0;
   for(int i=0;i<rows;i++){
     /*
     if(i==(rows-1)){
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }*/
     for(int j=0;j<columns;j++ ){
      String destString="";
        if(maxLength[j]>0){
          destString=blanks.substring(0, maxLength[j] - modelData[i][j].length() + 1) + modelData[i][j];
              //complementStringAlignRight(' ',modelData[i][j],maxLength[j] - modelData[i][j].length() + 1);

        }
        totalSB.append(destString);
        //if(j<columns-1)totalSB.append("||");
     }
     //at each row,append the return character.
     totalSB.append("\n");
     /*
     if(i==0){
        maxDshLength=totalSB.toString().length();
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }*/
   }
   return totalSB.toString();
 }



  /**
   * compose text array with top row and button row with dashes
   * as text table format.
   * @param txtArr String[]
   * @param rows int
   * @param columns int
   * @return String
   */
  static public String txtArrayToTable(String txtArr[],int rows,int columns){
   String dashes="-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
   //to remove the price column
   StringBuffer totalSB=new StringBuffer();
   int  maxLength[]=new int[columns];
   String modelData[][]=new String[rows][columns];
   String blanks="                                        ";
   //fisrt is to trevorse all the cell,and determ the max char of each column
   //copy "TOTAL:" to column before price column of last row.
   //tbl.setValueAt("TOTAL:",tbl.getRowCount()-1,priceColumnAt-1);
   int colBegin=0;
   for(int j=0;j<columns;j++){
     maxLength[j]=0;
     for (int i = 0; i < rows; i++) {
         String cellData = txtArr[i*columns+j];
         String cellDataString =
             (cellData == null) ? "" : cellData.toString();

         if (cellDataString.length() > maxLength[j]) {
           maxLength[j] = (cellDataString.length()) + 1; //at least,leading a space.
         }
         modelData[i][j] = cellDataString;
     }
   }
   int maxDshLength=0;
   for(int i=0;i<rows;i++){
     if(i==(rows-1)){
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }
     for(int j=0;j<columns;j++ ){
      String destString="";
        if(maxLength[j]>0){
          destString=blanks.substring(0, maxLength[j] - modelData[i][j].length() + 1) + modelData[i][j];
              //complementStringAlignRight(' ',modelData[i][j],maxLength[j] - modelData[i][j].length() + 1);

        }
        totalSB.append(destString);
        //if(j<columns-1)totalSB.append("||");
     }
     //at each row,append the return character.
     totalSB.append("\n");
     if(i==0){
        maxDshLength=totalSB.toString().length();
       totalSB.append(dashes.substring(0,maxDshLength));
       totalSB.append("\n");
     }
   }
   return totalSB.toString();
 }
 static public String udpateTotalQtyDesc(String firstColumnTitle,String colorName,String QTYvalue){
   String qtyDescArr[]=new String[]{firstColumnTitle,"QTY",colorName,QTYvalue,"TOTAL",QTYvalue};
   return txtArrayToTable(qtyDescArr,3,2);
 }
 static public String unicodeToBig5(String inString){
     try{
        return new String(inString.getBytes("ISO8859_1"),"CP950");
     }catch(Exception e){
       e.printStackTrace();
       return inString;
     }
 }
 static public String big5ToUnicode(String inString){
     try{
        return new String(inString.getBytes("CP950"),"ISO8859_1");
     }catch(Exception e){
       e.printStackTrace();
       return inString;
     }
 }
 static public byte[] longToByte(long value2Conv){
   long serverInt =value2Conv; // the value that you get from the server
   int mask = 0xff; // 255 - 8 bits set to 1.
   byte [] bytes = new byte [8];
   for(int a = 0; a < 8; a++) {
     bytes[a] = (byte)(serverInt&mask);
     serverInt = serverInt >> 8;
   }
   return bytes;
 }
 static public  byte [] IntegerToByte(int _in){
      int serverInt =_in; // the value that you get from the server
      int mask = 0xff; // 255 - 8 bits set to 1.
      byte [] bytes = new byte [4];
      for(int a = 0; a < 4; a++) {
        bytes[a] = (byte)(serverInt&mask);
        serverInt = serverInt >> 8;
      }
      return bytes;
 }
 /**
  * to combine 2 byte array into one byte array
  * @param array1,the 1st byte array
  * @param array2,the 2nd byte array
  * @return the combined byte array.
  */
 static public byte[] combineArray(byte[] array1,byte[] array2){
    //create an array that can hold all elements
    byte[] master = new byte[(array1.length)+(array2.length)];
    // copy the first array into the master starting a index 0
    System.arraycopy(array1,0,master,0,array1.length);
    // copy the second array starting at the first free slot
    System.arraycopy(array2,0,master,array1.length,array2.length);
    return master;
 }
 /**
  * to combine two object array into one array
  * @param array1,the first object array
  * @param array2,the 2nd object array
  * @return the combined Object array
  */
 static public Object[] combineArray(Object[] array1,Object[] array2){
    //create an array that can hold all elements
    Object[] master = new Object[(array1.length)+(array2.length)];
    // copy the first array into the master starting a index 0
    System.arraycopy(array1,0,master,0,array1.length);
    // copy the second array starting at the first free slot
    System.arraycopy(array2,0,master,array1.length,array2.length);
    return master;
 }
 /**
  * function for deep copy of an object to different referece
  * @param objObj,the sorce objct to copy
  * @return new objct ,but defferent reference
  * @exception:maybe caused by unserializiable object
  */
 static public Object deepCopy(Object oldObj) throws Exception
   {
      ObjectOutputStream oos = null;
      ObjectInputStream ois = null;
      try
      {
         ByteArrayOutputStream bos =
               new ByteArrayOutputStream(); // A
         oos = new ObjectOutputStream(bos); // B
         // serialize and pass the object
         oos.writeObject(oldObj);   // C
         oos.flush();               // D
         ByteArrayInputStream bin =
               new ByteArrayInputStream(bos.toByteArray()); // E
         ois = new ObjectInputStream(bin);                  // F
         // return the new object
         return ois.readObject(); // G
      }
      catch(Exception e)
      {
         System.out.println("Exception in ObjectCloner = " + e);
         throw(e);
      }
      finally
      {
         oos.close();
         ois.close();
      }
   }

 /**
  * to get a string array from a string ,by a character as delimiter
  * this function use Stringtokenizer function to perform.
  * @param instr ,the source string
  * @param delimiterStr,as stringtokenizer
  * @return the splitted string array.
  */
   public static String[] SplitByStringTokenizer(String instr,String delimiterStr){
       StringTokenizer st=new StringTokenizer(instr,delimiterStr);
       String arrStr[]=new String[st.countTokens()];
       int i=0;
       while (st.hasMoreTokens()){
         arrStr[i]=st.nextToken();
         i++;
       }
       return arrStr;
   }
   /**
    * to encode objects(String)/values(String) by java.net.URLEncoder.
    * @param hm
    * @return
    */
   public static HashMap URLEncode(HashMap hm){
        java.util.Set keys=hm.keySet();
        java.util.Iterator iter = keys.iterator();
        while (iter.hasNext()) {
          String nextName = (String)iter.next();
          String value = java.net.URLEncoder.encode((String)hm.get(nextName));
          hm.put(nextName, value);
        }
        return hm;
   }

   /**
    * since the string tokenize can not do complicate spliting process
    * here is the complex string splinting.
    * @param instr ,the source string to split
    * @param delimiterStr,the delimiter string
    * @return the splitted string array.
    */
   public static String[] split(String instr,String delimiterStr){
   /*
       StringTokenizer st=new StringTokenizer(instr,delimiterStr);
       String arrStr[]=new String[st.countTokens()];
       int i=0;
       while (st.hasMoreTokens()){
         arrStr[i]=st.nextToken();
         i++;
       }
       return arrStr;
     */
     String Src=instr;
     String Dlm=delimiterStr;
     ArrayList al=new ArrayList();
      while(Src.indexOf(Dlm)!=-1){
          //al.add(split2Head(Src,Dlm).trim());
          al.add(split2Head(Src,Dlm));
          Src=split2Tail(Src,Dlm);
      }
      al.add(Src);
      return  (String [])al.toArray(new String[0]);
     /*
     Vector StringArr=new Vector();
      while(Src.indexOf(Dlm)!=-1){
          StringArr.add(split2Head(Src,Dlm).trim());
          Src=split2Tail(Src,Dlm);
      }
      StringArr.add(Src);
      */
      /*
      String returnArr[]=new String[StringArr.size()];
      for(int i=0;i<StringArr.size();i++) returnArr[i]=(String)StringArr.get(i);
      return returnArr;
      */
   }
  /**
   * to findout the tail string behind the delimeter
   * @param in,the source string to delimte
   * @param delimeter,the delimter string as tokenizer
   * @return the string behind this delimeter
   */
  public static String split2Tail(String in,String delimeter){
    if (in.length()<delimeter.length()) return in;
    if(in.indexOf(delimeter)==-1) return in;
    String result= in.substring(in.indexOf(delimeter)+delimeter.length());
    if(result.equals(delimeter)) return "";
    return result;
  }
  /**
   * to findout the tail string in front of   delimeter
   * @param in,the source string to delimte
   * @param delimeter,the delimter string as tokenizer
   * @return the string in front of  this delimeter
   */
  public static String split2Head(String in,String delimeter){
    if(in.indexOf(delimeter)==-1) return "";
    return in.substring(0,in.indexOf(delimeter));
  }
  /**
   * get column index by column name,helpful to allow you get value from record by column index not by name.
   * @param rec record object to search column names
   * @param tgtColumnName target column name to search ,case insensitive
   * @return the index of column in the record object,if "-1" means not found.
   */
  public static int getFieldIndexAtRecord(Record rec,String tgtColumnName){
    java.util.List fldNameList = rec.getFieldName();
    for (int i = 0; i < fldNameList.size(); i++) {
      String srcKlmName = (String) fldNameList.get(i);
      if (srcKlmName.equalsIgnoreCase(tgtColumnName))
        return i;
    }
    return -1;
  }

 /**
  * to get year number from a java.sql.Date object
  * @param d,the date object
  * @return the year number of this date object
  */
 public static int getYear(Date d){
   Calendar calender = Calendar.getInstance();
   calender.setTime(d);
   return calender.get(calender.YEAR);
  }
 /**
  * to get mounth number from a java.sql.Date object
  * @param d,the date object
  * @return the mounth number of this date object
  */

 public static int getMonth(Date d){
   Calendar calender = Calendar.getInstance();
   calender.setTime(d);
   return calender.get(calender.MONTH)+1;
 }
 /**
  * to get day number from a java.sql.Date object
  * @param d,the date object
  * @return the day number of this date object
  */

 public static int getDay(Date d){
   Calendar calender = Calendar.getInstance();
   calender.setTime(d);
   return calender.get(calender.DATE);
 }
 /**
  * to convert yyyy,mm,dd data into a java.sql.Date object,but is the 0:0:0 of that date object
  * @param year_in,the year number
  * @param month_in,the month number
  * @param day_in,the day number
  * @return the Date object of the convertion result
  */
 public static java.util.Date toDate000000(int year_in,int month_in,int day_in){
    Calendar calender = Calendar.getInstance();
    /*
    calender.set(calender.YEAR,year_in);
    calender.set(calender.MONTH,month_in-1);
    calender.set(calender.DAY_OF_MONTH,day_in);
    Date tD=new Date(calender.getTime().getTime());
    */
    calender.set(
      year_in,
      month_in-1,
      day_in,
      0,
      0,
      0
    );
    java.util.Date tD=new java.util.Date(calender.getTime().getTime());
    return tD;
 }
 public static java.util.Date toDate(int year_in,int month_in,int day_in){
   return toDate000000(year_in,month_in,day_in);
 }
 public static boolean isEqual(Object obj1,Object obj2){
   if(obj1==null && obj2==null)return true;
   if(obj1==null && obj2!=null){
     if(obj2.toString().length()==0)return true;
     return false;
   }
   if(obj1!=null && obj2==null){
     if(obj1.toString().length()==0)return true;
     return false;
   }
   //if(obj1.toString().trim().equals(obj2.toString().trim()))return true;
   //return false;
   return obj1.equals(obj2);
 }
 /**
 * to convert yyyy,mm,dd data into a java.sql.Date object,and time is 23:59:59
 * @param year_in,the year number
 * @param month_in,the month number
 * @param day_in,the day number
 * @return the Date object of the convertion result
 */

 public static java.util.Date toDate235959(int year_in,int month_in,int day_in){
    Calendar calender = Calendar.getInstance();
    /*
    calender.set(calender.YEAR,year_in);
    calender.set(calender.MONTH,month_in-1);
    calender.set(calender.DAY_OF_MONTH,day_in);
    Date tD=new Date(calender.getTime().getTime());
    */
    calender.set(
      year_in,
      month_in-1,
      day_in,
      23,
      59,
      59
    );
    java.util.Date tD=new java.util.Date(calender.getTime().getTime());
    return tD;
 }

 /**
  * to replace specified strings in a string,with a flag to trim each splited string or not.
  * @param in,the souce string
  * @param toFind,the target string to search
  * @param toPut,the string to replace "toFind" with
  * @param toTrim,the flag to indicate to trim each node or not.
  * @return the totalString which is replace with the toPut string.
  */
 public static String Replace(String in,String toFind,String toPut,boolean toTrim){
     if(in.indexOf(toFind)==-1) return in;
    String arrStr[]=split(in,toFind);
    StringBuffer sb=new StringBuffer();
    for(int i=0;i<arrStr.length;i++){
      if(toTrim){
        sb.append(arrStr[i].trim());
      }else{
        sb.append(arrStr[i]);
      }
      if(i!=(arrStr.length-1)) sb.append(toPut);
    }
    return sb.toString();
 }

 /**
  * to replace specified strings in a string
  * @param in,the souce string
  * @param toFind,the target string to search
  * @param toPut,the string to replace "toFind" with
  * @return the totalString which is replace with the toPut string.
  */
 public static String Replace(String in,String toFind,String toPut){
   return Replace(in,toFind,toPut,true);
 }
 /**
  * nothing,just a max days in a month function
  * @param d,the java.sql.Date
  * @return the max days in the Date object's month
  */
 public static int getMonthMaxDays(java.util.Date d){
   Calendar cld=Calendar.getInstance();
   cld.setTime(d);
   return cld.getActualMaximum(cld.DAY_OF_MONTH);
   /*
   int maxDays=0;
   switch(getMonth(d)){
     case 1:
     case 3:
     case 5:
     case 7:
     case 8:
     case 10:
     case 12:
        maxDays=31;
        break;
     case 4:
     case 6:
     case 9:
     case 11:
        maxDays=30;
        break;
     case 2:
        if(getYear(d)%4==0){
           maxDays=29;
        }else{
           maxDays=28;
        }
   }
   return maxDays;
   */
 }
 /**
  * to figure out the 13th code as barcode type ean3 format
  * @param EAN12Codes,the 0-11 digit
  * @return the 13th code value
  * @throw ,incase the para EAN12Codes is not numerc or too short.
  */
 public static char getEAN13thCode(String EAN12Codes) throws Exception{
   if(EAN12Codes.length()<12) throw new Exception("EAN12Codes is too short");
   int sumEve=0,sumOdd=0;
   for(int i=1;i<13;i+=2){
    sumEve+=Integer.parseInt(EAN12Codes.substring(i,i+1));
   }
    sumEve*=3;
   for(int i=0;i<11;i+=2){
    sumOdd+=Integer.parseInt(EAN12Codes.substring(i,i+1));
   }
   sumOdd+=sumEve;
   return Integer.toString(10-(sumOdd%10)).charAt(0);
 }
/**
 * to get a java.net.URLConnection,with Timeout paramater stick on it<br>
 * C'oz the original URLConnection will blocking while waiting for inputstream<br>
 * the source code is from <b>"http://www.larsan.net/java/index.jsp?page=tricks/url.html"</b><br>
 * @param urlString,the String to connection to a url source
 * @param timeOutMills ,the MilleSeconds for time out or not.
 * @return java.net.URLConnection
 * @exception ,may cause java.io or java.net exception.
 */
public  static URLConnection EnableTimeOutURLConnection(String urlString,int timeOutMills) throws Exception{
  TimeoutHttpURLConnection.TIMEOUT=timeOutMills;
  URL url=new URL(new URL(urlString),"",new TimeoutHttpStreamHandler());
  return url.openConnection();
}
  private static class TimeoutHttpClient extends HttpClient {

        private Socket socket;


        public TimeoutHttpClient(URL url, String str, int i) throws IOException {
            super(url, str, i);
        }

        public static HttpClient New(URL url_1) throws IOException {
/*
            HttpClient httpc = (HttpClient)kac.get(url_1);

            if(httpc == null) httpc = new TimeoutHttpClient(url_1, null, -1);
            else httpc = HttpClient.New(url_1);
*/
            HttpClient httpc =  new TimeoutHttpClient(url_1, null, -1);
            return httpc;

        }

        public int setTimeout(int millis) throws SocketException {
            if(socket != null){
              socket.setSoTimeout(millis);
              return millis;
            }
            return -1;
        }
       /*
       public void setTimeout(int millis) throws SocketException {
         if (socket != null) {
           socket.setSoTimeout(millis);
         }
       }
       */
        public int getTimeout() throws SocketException {
            if(socket != null) return socket.getSoTimeout();
            else return -1;
        }

        protected Socket doConnect(String host, int port) throws IOException, UnknownHostException {

            socket = new Socket(host, port);

            socket.setSoTimeout(TimeoutHttpURLConnection.TIMEOUT);

            return socket;
        }
    }


private static class TimeoutHttpURLConnection extends sun.net.www.protocol.http.HttpURLConnection {

        public static int TIMEOUT = 30000;

        public TimeoutHttpURLConnection(URL url, String proxy, int proxyPort) throws IOException {
            super(url, proxy, proxyPort);
        }

        public TimeoutHttpURLConnection(URL url) throws IOException {
            this(url, null, -1);
        }

        protected HttpClient getNewClient(URL url) throws IOException {
            return new TimeoutHttpClient(url, null, -1);
        }

        protected HttpClient getProxiedClient(URL url, String s, int i) throws IOException {
            return new TimeoutHttpClient(url, s, i);
        }

        public void connect() throws IOException {

            if(connected) return;

            Properties prop = System.getProperties();
            String set = (String)prop.get("proxySet");

            if(set != null && set.equalsIgnoreCase("true")) {

               String host = (String)prop.get("proxyHost");
               int port = -1;

               try {
                   port = Integer.parseInt((String)prop.get("proxyPort"));
               } catch(Exception e) { }

               if(host != null && port != -1) http = new TimeoutHttpClient(url, host, port);
              else http = TimeoutHttpClient.New(url);

            } else http = TimeoutHttpClient.New(url);

            if(http instanceof TimeoutHttpClient) ((TimeoutHttpClient)http).setTimeout(TIMEOUT);

           ps = (PrintStream)http.getOutputStream();

           connected = true;
       }
    }

    private static class TimeoutHttpStreamHandler extends URLStreamHandler {

        public TimeoutHttpStreamHandler() {
            super();
        }

        public URLConnection openConnection(URL url) throws IOException {
            return new TimeoutHttpURLConnection(url);
        }
    }
    /**
     * to run the multiply process of 2 double value
     * @param d1--double value1
     * @param d2--double value2
     * @return the result of multiply proess
     */
    public static double getDoubleMultiply(double d1,double d2){
       java.math.BigDecimal BigDec1,BigDec2;
       double result=0.0;

       BigDec1=new BigDecimal(Double.toString(d1));
       BigDec2=new BigDecimal(Double.toString(d2));
       result=(BigDec1.multiply(BigDec2)).doubleValue();
       return result;
    }
    /**
     * to run the division process of 2 double value
     * @param d1--double value1
     * @param d2--double value2
     * @return the result of division proess
     */
    public static double getDoubleDivide(double d1,double d2,int r){
       java.math.BigDecimal BigDec1,BigDec2;
       double result=0.0;

       BigDec1=new BigDecimal(Double.toString(d1));
       BigDec2=new BigDecimal(Double.toString(d2));
       result=(BigDec1.divide(BigDec2,r,0)).doubleValue();
       return result;
    }

    public static double getDoubleSubtract(double d1,double d2){
       java.math.BigDecimal BigDec1,BigDec2;
       double result=0.0;

       BigDec1=new BigDecimal(Double.toString(d1));
       BigDec2=new BigDecimal(Double.toString(d2));
       result=(BigDec1.subtract(BigDec2)).doubleValue();
       return result;
    }
    /**
     * proceed the pluse process of 2 double value
     * @param d1--double value1
     * @param d2--double value2
     * @return the result of pluse proess
     */

    public static double getDoubleAdd(double d1,double d2){
       java.math.BigDecimal BigDec1,BigDec2;
       double result=0.0;

       BigDec1=new BigDecimal(Double.toString(d1));
       BigDec2=new BigDecimal(Double.toString(d2));
       result=(BigDec1.add(BigDec2)).doubleValue();
       return result;
    }
    /**
     * to see if a hashmap (key and data) exists in record object
     * @param rec--record object to search
     * @param hmObj--hashmap object where data and keys store to find.
     * @return--if record contains such keys and datas
     */
   public static synchronized boolean isHashMapInRecod(Record rec,HashMap hmObj){
      Set keis=hmObj.keySet();
      Iterator kit=keis.iterator();
      while(kit.hasNext()){
        String keyName=(String)kit.next();
        Object objInHm=hmObj.get(keyName);
        try{
          Object objInRec=rec.get(keyName);
        if(objInRec instanceof java.sql.Timestamp)
            objInRec=new java.sql.Date(((java.sql.Timestamp)objInRec).getTime());
        if(objInHm instanceof java.sql.Timestamp)
           objInHm=new java.sql.Date(((java.sql.Timestamp)objInHm).getTime());

          //first is to see object type matches or not.
          if(objInHm==null){
            if(objInRec==null) continue;
            if(objInRec!=null) return false;
          }
          if(objInRec==null){
            if(objInHm!=null) return false;
            if(objInHm==null) continue;
          }else if(objInRec instanceof java.sql.Date){
            if(((java.sql.Date)objInRec).getTime()!=((java.sql.Date)objInHm).getTime())
              return false;
            else
              continue;
          }else if(objInRec instanceof java.lang.String ){
            if(!((String)objInRec).trim().equals(((String)objInHm).trim()))
               return false;
             else
               continue;
          }else{
            if(!objInRec.toString().equals(objInHm.toString()))
              return false;
              else
              continue;
          }
        }catch(Exception e){
          e.printStackTrace();
          util.ExceptionLog.exp2File(e,"exp while attempt to match hashmap and object");
          return false;
        }
      }
      //since every key and data in hash map matches the fields and data,the hashmap is in this reacord
      return true;
   }

}
