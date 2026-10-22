package pillars_of_object_oriented_programming.encapsulation.access_modifiers;


// To achieve the encapsulation we must need to understand the access modifiers.
// First we will look into the access modifiers and then we do the Example
public class AccessModifiers {
    // private - same class
    private int num;
    // default - same class, same package and subclass of same packager.
    String name;
    // protected - same class, same package, subclass of same package and subclass of different package
    protected int [] arr;

    // public - same class, same package, subclass of same package and subclass of different package, different package and  not subclass
    public AccessModifiers(int num, String name){
        this.num = num;
        this.name = name;
        arr = new int[num];
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
