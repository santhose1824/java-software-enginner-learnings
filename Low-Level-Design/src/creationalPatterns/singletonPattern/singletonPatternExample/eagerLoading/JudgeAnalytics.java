    package creationalPatterns.singletonPattern.singletonPatternExample.eagerLoading;


    // Eager loading - the instance is created when the class is loading.

    public class JudgeAnalytics{
        private int run = 0;
        private  int submit = 0;

        // Here  when the class is loaded it create an object.
        // Whenever this class loaded at the only time the object is called.
        private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();

        private JudgeAnalytics(){

        }

        public static  JudgeAnalytics getInstance(){
            return judgeAnalytics;
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

