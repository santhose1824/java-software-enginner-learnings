package creationalPatterns.singletonPattern.problem;

// Creational Patterns - solving the issues/ patterns around the object creation.
// Coding example of Singleton Pattern. First type of creational patterns.
// Question is : I want to track how many times the run and submit button is clicked.

public class SingletonPattern {
    public static void main(String[] args) {
        // When we create an object of JudgeAnalytics and call the countRun() and countSubmit().
        // Consider this object is used by one service called IDE section.
        JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
        judgeAnalytics.countRun();
        judgeAnalytics.countSubmit();

        // Now I create a second object that is used by some other service called Compiler.
        JudgeAnalytics judgeAnalytics2 = new JudgeAnalytics();
        judgeAnalytics2.countRun();
        judgeAnalytics2.countSubmit();

        // Now if we print the count value of run and submit it should be 2.
        // But for the particular object it will be 1.
        /*
                Run count by object 1 : 1
                Run count by object 2 : 1
                Submit count by object 1 : 1
                Submit count by object 2 : 1
        */
        System.out.println("Run count by object 1 : "+judgeAnalytics.getRun());
        System.out.println("Run count by object 2 : "+judgeAnalytics2.getRun());

        System.out.println("Submit count by object 1 : "+judgeAnalytics2.getSubmit());
        System.out.println("Submit count by object 2 : "+judgeAnalytics2.getSubmit());

        // But why it is happened because if we see judgeAnalytics and judgeAnalytics2 both are different objects.
        /*
            Object 1 : creationalPatterns.singletonPattern.problem.JudgeAnalytics@682a0b20
            Object 2 : creationalPatterns.singletonPattern.problem.JudgeAnalytics@3d075dc0
        */
        System.out.println("Object 1 : "+judgeAnalytics);
        System.out.println("Object 2 : "+judgeAnalytics2);

        // This kind of problem is solved by singleton pattern.
        // At the global level I want only one object to be created and used for all the services.
    }
}
