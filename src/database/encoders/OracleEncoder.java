package database.encoders;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */
import java.sql.*;
public class OracleEncoder extends PostgreSQL {

  public OracleEncoder() {
  }
    public String encode(String value)
    {
        if(value==null) return "null";
        try{
          int len = value.length();
          StringBuffer buf = new StringBuffer(len + 2);
          buf.append("'");
          for(int i = 0; i < len; i++)
          {
              char c = value.charAt(i);
              if(c == '\''){
                  buf.append("''");
              }else{
                 buf.append(c);
              }

          }

          buf.append("'");
          return buf.toString();
        }catch(Exception e){
          return new String("''");
        }
    }
    public String encode(Date value)
    {
        StringBuffer buf = new StringBuffer();
        buf.append(" ");
        buf.append("to_date('");
        //buf.append(new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(value));
        buf.append(new java.text.SimpleDateFormat("yyyy/MM/dd").format(value));
        //buf.append("','YYYY/MM/DD HH24:MI:SS'");
        buf.append("','YYYY/MM/DD'");
        buf.append(")");
        return buf.toString();
    }

}
