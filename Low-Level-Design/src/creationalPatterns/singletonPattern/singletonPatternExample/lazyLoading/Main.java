package creationalPatterns.singletonPattern.singletonPatternExample.lazyLoading;



public class Main {
    public static void main(String[] args) {

        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
        judgeAnalytics.countRun();
        judgeAnalytics.countSubmit();

        JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();

        judgeAnalytics2.countRun();
        judgeAnalytics2.countSubmit();

        // Now if we run reference variable point to the same object.
        // And then if we see the count it will be 2 for both.

        /*
            Run count by object 1 : 2
            Run count by object 2 : 2
            Submit count by object 1 : 2
            Submit count by object 2 : 2
        */

        System.out.println("Run count by object 1 : "+judgeAnalytics.getRun());
        System.out.println("Run count by object 2 : "+judgeAnalytics2.getRun());

        System.out.println("Submit count by object 1 : "+judgeAnalytics2.getSubmit());
        System.out.println("Submit count by object 2 : "+judgeAnalytics2.getSubmit());



        // Both are the same objects.
        System.out.println("Object 1 : "+judgeAnalytics);
        System.out.println("Object 2 : "+judgeAnalytics2);
    }
}
