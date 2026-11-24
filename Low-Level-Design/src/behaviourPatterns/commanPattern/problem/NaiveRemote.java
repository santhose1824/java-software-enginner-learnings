package behaviourPatterns.commanPattern.problem;

public class NaiveRemote {
    private Light light;
    private AC ac;
    private String lastAction = "";

    public NaiveRemote(Light light, AC ac){
        this.light = light;
        this.ac = ac;
    }

    public void pressLightOn(){
        light.on();
        lastAction = "Light_on";
    }

    public void pressLightOff(){
        light.off();
        lastAction = "Light_off";
    }


    public void pressACOn(){
        ac.on();
        lastAction = "AC_on";
    }

    public void pressACOff(){
        ac.off();
        lastAction = "AC_off";
    }

    public void pressUndo(){
        switch (lastAction) {
            case "Light_on" -> {
                light.off();
                lastAction = "Light_off";
            }
            case "Light_off" -> {
                light.on();
                lastAction = "Light_on";
            }
            case "AC_on" -> {
                ac.off();
                lastAction = "AC_off";
            }
            case "AC_off" -> {
                ac.on();
                lastAction = "AC_on";
            }
            default -> System.out.println("No action is undo");
        }
    }

}
