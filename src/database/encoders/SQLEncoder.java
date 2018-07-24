package database.encoders;
// Decompiled by Jad v1.5.7f. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3)
// Source File Name:   PostgreSQL.java
import java.sql.*;
import database.*;
public class SQLEncoder
    implements Encoder
{
    public SQLEncoder()
    {
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
              if(c == '\'')
                  buf.append("''");
              else if(c=='\\'){
                  buf.append("\\\\");
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

    public String encode(boolean value)
    {
        StringBuffer buf = new StringBuffer(7);
        buf.append("'");
        buf.append(value);
        buf.append("'");
        return buf.toString();
    }

    public String encode(int value)
    {
        StringBuffer buf = new StringBuffer();
        buf.append(value);
        return buf.toString();
    }

    public String encode(long value)
    {
        StringBuffer buf = new StringBuffer();
        buf.append(value);
        return buf.toString();
    }

    public String encode(float value)
    {
        StringBuffer buf = new StringBuffer();
        buf.append(value);
        return buf.toString();
    }

    public String encode(double value)
    {
        StringBuffer buf = new StringBuffer();
        buf.append(value);
        return buf.toString();
    }
    public String encode(java.util.Date  value){
      return encode(new java.sql.Date(value.getTime()));
    }
    public String encode(Date value)
    {
        StringBuffer buf = new StringBuffer();
        buf.append("'");
        buf.append(new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(value));
        buf.append("'");
        return buf.toString();
    }

    public String encode(Time value)
    {
        StringBuffer buf = new StringBuffer();
        buf.append("'");
        buf.append(value);
        buf.append("'");
        return buf.toString();
    }

    public String encode(Timestamp value)
    {
        StringBuffer buf = new StringBuffer();
        buf.append("'");
        buf.append(value);
        buf.append("'");
        return buf.toString();
    }
   public String encode(Object value){
    if(value==null) return "null";
    //try{
       //if(value.getClass()==Class.forName("java.lang.Integer"))
       if(value instanceof java.lang.Integer)
           return value.toString();
       //if(value.getClass()==Class.forName("java.lang.Float"))
       if(value instanceof java.lang.Float)
             return value.toString();
       //if(value.getClass()==Class.forName("java.lang.Double"))
       if(value instanceof java.lang.Double )
             return value.toString();
       //if(value.getClass()==Class.forName("java.lang.Long"))
       if(value instanceof java.lang.Long)
             return value.toString();
       //if(value.getClass()==Class.forName("java.lang.String"))
       if(value instanceof java.lang.String)
             return encode((String)value);
       //if(value.getClass()==Class.forName("java.sql.Date"))
       if(value instanceof java.sql.Date)
             return encode(((Date) value));
       return encode(value.toString());//for java.sql.TimeStamp class
      /*
      }catch(java.lang.ClassNotFoundException e){
       //return null;
       return value.toString();
     }*/

   }
}
