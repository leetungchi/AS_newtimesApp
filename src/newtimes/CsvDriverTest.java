package newtimes;
import java.sql.*;
import org.relique.jdbc.csv.* ;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class CsvDriverTest {
  public CsvDriverTest() {
    try
        {
          // load the driver into memory
          Class.forName("org.relique.jdbc.csv.CsvDriver");

          // create a connection. The first command line parameter is assumed to
          //  be the directory in which the .csv files are held
          Connection conn = DriverManager.getConnection("jdbc:relique:csv:\\\\127.0.0.1\\uploadEDI\\20090120");   //E:\\uploadEDI\\20090120"   );

          // create a Statement object to execute the query with
          //Statement stmt = conn.createStatement();
          Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 0);

          // Select the ID and NAME columns from sample.csv
          ResultSet results = stmt.executeQuery("SELECT * FROM 20080601_20090120_stydtls" );//where po='01011'");

          // dump out the results
          System.out.println("System time of Begin:"+System.currentTimeMillis());
          int rowPos=1;
          for(int i=0;i<4;i++){
            results.absolute(rowPos);
            System.out.println(results.getString("PO"));
            System.out.println("del data is "+results.getString(4));
            rowPos++;
          }
          System.out.println("System time of End:"+System.currentTimeMillis());
          for(int i=0;i<4;i++){
            results.absolute(rowPos);
            System.out.println(results.getString("PO"));
            rowPos++;
          }
          //goto IMP500799
          System.out.println("System time of Begin:"+System.currentTimeMillis());
          rowPos=75984-1;
          System.out.println("---------------------------------");
          for(int i=0;i<4;i++){
            results.absolute(rowPos);
            String poStr=results.getString("PO");
            if(null==poStr)break;
            System.out.println("PO:"+poStr+"  PCIX:"+results.getString("PCIX"));
            rowPos++;
          }
          System.out.println("System time of End:"+System.currentTimeMillis());

          rowPos=49887-1;
          System.out.println("---------------------------------");
          System.out.println("System time of Begin:"+System.currentTimeMillis());
          for(int i=0;i<8;i++){
            results.absolute(rowPos);
            System.out.println("PO:"+results.getString("PO")+"  PCIX:"+results.getString("PCIX"));
            rowPos++;
          }


          rowPos=49825-1;
          System.out.println("---------------------------------");
          System.out.println("System time of Begin:"+System.currentTimeMillis());
          for(int i=0;i<15;i++){
            results.absolute(rowPos);
            System.out.println("PO:"+results.getString("PO")+"  PCIX:"+results.getString("PCIX")+" ,dlv date:"+results.getString("DLVY_DATE"));
            rowPos++;
          }
          System.out.println("System time of end :"+System.currentTimeMillis());
          //goto row
          /*
          while (results.next())
          {
            System.out.println(results.getString("PO"));
          }*/

          // clean up
          results.close();
       /*
        ResultSet  results2 = stmt.executeQuery("SELECT * FROM 20080601_20090120_stydtls where po='IMP500799'");

                    // dump out the results
                    while (results2.next())
                    {
                      System.out.println(results2.getString("STYLE"));
                    }

                    // clean up
                    results2.close();

                    ResultSet  results3 = stmt.executeQuery("SELECT * FROM 20080601_20090120_stydtls where po='1124374'");

                                // dump out the results
                                while (results3.next())
                                {
                                  System.out.println(results3.getString("STYLE"));
                                }

                                // clean up
                                results3.close();
            */

          System.out.println("System time of end :"+System.currentTimeMillis());
          stmt.close();
          conn.close();
        }
        catch(Exception e)
        {
          System.out.println("Oops-> " + e);
        }

  }
  public static void main(String[] args) {
    CsvDriverTest csvDriverTest1 = new CsvDriverTest();
  }

}
