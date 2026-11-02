package creationalPatterns.singletonPattern.singletonPatternExample.lazyLoading;

// Lazy Loading - the instance is not created when the class is loading.
// Lazy loading is not thread safe, because we are not create a new object here.
// We check and if the object is already created we will just use it.
// So if the object is already used by one service another service will also access it at same time.

    public class JudgeAnalytics{
    private int run = 0;
    private  int submit = 0;

    private static JudgeAnalytics judgeAnalytics;

    private JudgeAnalytics(){

    }

    public static  JudgeAnalytics getInstance(){
        if(judgeAnalytics == null){
            judgeAnalytics = new JudgeAnalytics();
        }

        return  judgeAnalytics;
    }

    public void countRun(){
        run++;
    }
    public void countSubmit(){
        submit++;
    }

    public int getRun(){
        return run;
    }

    public int getSubmit(){
        return submit;
    }
}

// To make thread safety with synchronized.
// This is the most very inefficient way.
/*
  public class JudgeAnalytics{
    private int run = 0;
    private  int submit = 0;

    private static JudgeAnalytics judgeAnalytics;

    private JudgeAnalytics(){

    }
    // This will make the object able to access only in the synchronized way.
    // So the thread will access one at time.
    public static synchronized JudgeAnalytics getInstance(){
        if(judgeAnalytics == null){
            judgeAnalytics = new JudgeAnalytics();
        }

        return  judgeAnalytics;
    }

    public void countRun(){
        run++;
    }
    public void countSubmit(){
        submit++;
    }

    public int getRun(){
        return run;
    }

    public int getSubmit(){
        return submit;
    }
}
*/

// To make thread safety with double-checking.
// This is efficient compare to the synchronized way.
/*
    public class JudgeAnalytics{
    private int run = 0;
    private  int submit = 0;

    private static volatile JudgeAnalytics judgeAnalytics;

    private JudgeAnalytics(){

    }
    // This will make the object able to access only in the synchronized way.
    // This will first check whether the object is accessed by anything or not.
    // And make them synchronized only if it is not.
    public static synchronized JudgeAnalytics getInstance(){
        if(judgeAnalytics == null){
            synchronized (JudgeAnalytics.class){
                if(judgeAnalytics == null){
                    judgeAnalytics = new JudgeAnalytics();
                }
            }
        }

        return  judgeAnalytics;
    }

    public void countRun(){
        run++;
    }
    public void countSubmit(){
        submit++;
    }

    public int getRun(){
        return run;
    }

    public int getSubmit(){
        return submit;
    }
}
*/

// To make thread safety by using Bill Pagh method.

/*
    public class JudgeAnalytics{
    private int run = 0;
    private  int submit = 0;

    private static volatile JudgeAnalytics judgeAnalytics;

    private JudgeAnalytics(){

    }
    // By making like this it will create at one time when the Holder class is called because it is static.
    // Static elements are loaded only one time.
    private static class Holder{
        private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
    }

    public void countRun(){
        run++;
    }
    public void countSubmit(){
        submit++;
    }

    public int getRun(){
        return run;
    }

    public int getSubmit(){
        return submit;
    }
}
*/




