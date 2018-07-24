package newtimes.preproduction.process;
public class SynchRequestor   {
  protected static int REMAINNING_PROCESS_COUNT=0;
  public SynchRequestor() {

  }
 public static void addAndRunThread(java.util.List runnable_list){
   REMAINNING_PROCESS_COUNT+=runnable_list.size();
   for(int i=0;i<runnable_list.size();i++){
     Runnable toRun=(Runnable)runnable_list.get(i);
     RunnerWrapper obj2Run=new RunnerWrapper(toRun);
     new Thread(obj2Run).start();
   }
 }
 public static void addAndRunThread(Runnable toRun){
   RunnerWrapper obj2Run=new RunnerWrapper(toRun);
   REMAINNING_PROCESS_COUNT++;
   new Thread(obj2Run).start();
 }
 public static boolean isAllProcessFinished(){
   return REMAINNING_PROCESS_COUNT<1;
 }
}
class RunnerWrapper implements Runnable{
  Runnable orgTask=null;
  static SynchRequestor container;
  RunnerWrapper(Runnable aThread){
    orgTask=aThread;
  }
  public void run(){
    orgTask.run();
    container.REMAINNING_PROCESS_COUNT--;
  }
}

