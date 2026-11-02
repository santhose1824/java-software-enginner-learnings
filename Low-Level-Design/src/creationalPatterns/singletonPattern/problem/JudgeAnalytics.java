package creationalPatterns.singletonPattern.problem;

// This is the sample class that handles the operation of run and submit in the online compiler.

public class JudgeAnalytics{
    private int run = 0;
    private  int submit = 0;

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
