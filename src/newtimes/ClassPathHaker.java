package newtimes;
import java.net.*;
import java.lang.reflect.*;
import java.io.*;

public class ClassPathHaker {

  private static final Class[] parameters = new Class[]{URL.class};

  public static void addFile(String s,ClassLoader classloader) throws IOException {
          File f = new File(s);
          addFile(f,classloader);
  }//end method

  public static void addFile(File f,ClassLoader classloader) throws IOException {
          addURL(f.toURL(),classloader);
  }//end method


  public static void addURL(URL u,ClassLoader loader) throws IOException {
          /*
          URLClassLoader sysloader = (URLClassLoader)ClassLoader.getSystemClassLoader();
          Class sysclass = URLClassLoader.class;
          */
         Class sysclass = URLClassLoader.class;
          try {
                  Method method = sysclass.getDeclaredMethod("addURL",parameters);
                  method.setAccessible(true);
                  method.invoke(loader,new Object[]{ u });
          } catch (Throwable t) {
                  t.printStackTrace();
                  throw new IOException("Error, could not add URL to system classloader");
          }//end try catch

  }//end method

  }//end class
