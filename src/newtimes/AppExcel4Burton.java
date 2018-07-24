package newtimes;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
import database.datatype.*;
import javax.naming.*;
import java.util.*;
import java.io.File;
import jxl.*;


public class AppExcel4Burton {
  public AppExcel4Burton() {
  }
  public static void main(String[] args) {
    AppExcel4Burton appExcel4Burton1 = new AppExcel4Burton();
    try{
      appExcel4Burton1.processTest();
    }catch(Exception exp){
      exp.printStackTrace();
    }
  }
  util.InsertionOrderedHashMap hmCntyAStyleColorToCells[]=new util.InsertionOrderedHashMap[5];
  String countryNames[] = {"", "", "", "", ""};
  StringBuffer sbMsg = new StringBuffer();
  String toString(Cell cell) {
    if (cell.getContents() == null)return "";
    if (cell.getContents().trim().equals("\n"))return "";
    return cell.getContents().trim().toUpperCase();
  }

   public void processTest()throws Exception{
     String timeStr="19711972";
     String fileName="c:\\"+timeStr+".xls";
     java.text.NumberFormat nfTotal=new java.text.DecimalFormat("###########.###");
     try{
       Workbook  workbook = Workbook.getWorkbook(new File(fileName));
       Sheet sheet = workbook.getSheet(0);
       //there are always 5 country to export.
       //1stly ,found out the row begin with "material" and end with "total"
       for(int i=0;i<5;i++)hmCntyAStyleColorToCells[i]=new util.InsertionOrderedHashMap();

       // style,color, 2XS, XS, S, M, L, XL, 2XL, 3XL
       //  0     1      2    3  4  5  6  7   8     9
       int DEST_STYLE_COLUMN_AT=0,DEST_COLOR_AT=1;
       int DEST_TOTAL_COLUMN_AT=12;
       /*
       int DEST_SIZE_2XS_AT=2;
       int DEST_SIZE_XS_AT =3;
       int DEST_SIZE_S_AT  =4;
       int DEST_SIZE_M_AT  =5;
       int DEST_SIZE_L_AT  =6;
       int DEST_SIZE_XL_AT =7;
       int DEST_SIZE_2XL_AT=8;
       int DEST_SIZE_3XL_AT=9;
       */
       HashMap hmSizeAtClmIndex=new HashMap();
       hmSizeAtClmIndex.put("2XS","2");
       hmSizeAtClmIndex.put("XS","3");
       hmSizeAtClmIndex.put("S","4");
       hmSizeAtClmIndex.put("M","5");
       hmSizeAtClmIndex.put("L","6");
       hmSizeAtClmIndex.put("XL","7");
       hmSizeAtClmIndex.put("2XL","8");
       hmSizeAtClmIndex.put("3XL","9");
       hmSizeAtClmIndex.put("4XL","10");
       hmSizeAtClmIndex.put("5XL","11");
       for(int i=0;i<sheet.getRows();i++){
           Cell[] cells=sheet.getRow(i);
           if(cells.length<12)continue;
           if(toString(cells[0]).equalsIgnoreCase("MATERIAL") &&
              toString(cells[11]).equals("TOTAL") &&
              toString(cells[5]).equalsIgnoreCase("SIZE")
              ){
                for(int j=6;j<11;j++)countryNames[j-6]=toString(cells[j]);
                 /*
                 String country1=toString( cells[6]);
                 hmContryList.put(country1,"0");

                 String country2=toString( cells[7]);
                 hmContryList.put(country2,"1");

                 String country3=toString( cells[8]);
                 hmContryList.put(country3,"2");

                 String country4=toString( cells[9]);
                 hmContryList.put(country4,"3");

                 String country5=toString( cells[10]);
                 hmContryList.put(country5,"4");
                 */
                 continue;
           }
           //for some "total" row,skip the row
           if(toString(cells[0]).length()==0 &&
              toString(cells[2]).length()==0 &&
              toString(cells[3]).length()==0){
             continue;
           }
           sbMsg.append("parsing row at "+String.valueOf(i)+"\n") ;
           //key is style & color.
           String style=toString(cells[0])+"/"+toString(cells[3]);
           String color=toString(cells[4]);
           // style,color, 2XS, XS, S, M, L, XL, 2XL, 3XL  4XL   5XL   TOTAL
           //  0     1      2    3  4  5  6  7   8     9     10  11    12
           for(int j=6;j<11;j++){
             sbMsg=new StringBuffer();
             try{
              Thread.currentThread().sleep(200);
            }catch(Exception e){
            }
            sbMsg.append(" Row:"+i+"  ");

             String sizeString=toString(cells[5]);
             String strSizeAt=(String)hmSizeAtClmIndex.get(sizeString);
             if(null==strSizeAt)break;
             util.InsertionOrderedHashMap hmStoredStyleColor=hmCntyAStyleColorToCells[j-6];
             sbMsg.append("parsing for " + countryNames[j-6]);
             String key=style+"||"+color;
             String destCells[]=(String[])hmStoredStyleColor.get(key);

             if(null==destCells){
               sbMsg.append("key "+ key+" NOT FOUND"+"\n");
               //System.out.println(sbMsg.toString());
               destCells=new String[13];
               for(int k=0;k<11;k++)destCells[k]=new String("");
               //System.out.println("destCells size is "+destCells.length);
               destCells[DEST_COLOR_AT]=color;
               destCells[DEST_STYLE_COLUMN_AT]=style;
               destCells[DEST_TOTAL_COLUMN_AT]="0";//defaul set to zero total
             }else{
               sbMsg.append("key "+ key+" Stored "+"\n");
               //System.out.println(sbMsg.toString());
             }
             //get from size.

              String qty=toString(cells[j]);
              sbMsg.append("sizeString is "+sizeString+"\n");
              int sizeColAt=Integer.parseInt(strSizeAt);
              sbMsg.append("sizeColAt :"+sizeColAt+"\n");
              sbMsg.append("qty is :"+qty+"\n");

              System.out.println(sbMsg.toString());

              destCells[sizeColAt]=qty;
              float total=Float.parseFloat(destCells[DEST_TOTAL_COLUMN_AT]);
              total+=(qty==null||qty.trim().length()==0)?0:Float.parseFloat(qty);
              destCells[DEST_TOTAL_COLUMN_AT]= nfTotal.format(total); //String.valueOf(total);
              //after ready,setback to hashmap.
              //hmStoredStyleColor.remove(key);
              hmStoredStyleColor.put(key,destCells);
              hmCntyAStyleColorToCells[j-6]=hmStoredStyleColor;
           }
       }
       //after all row are parsed,set to bank work sheet for return;
       System.out.println("end of proess");
     }catch(Exception exp){
       exp.printStackTrace();
       util.ExceptionLog.exp2File(exp,"");
       throw exp;
     }


   }
}
