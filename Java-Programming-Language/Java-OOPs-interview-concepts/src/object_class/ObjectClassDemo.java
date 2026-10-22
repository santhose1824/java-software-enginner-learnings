package object_class;

public class ObjectClassDemo {

    int num;
    float score;

    public ObjectClassDemo(int num, float score) {
        super();
        this.num = num;
        this.score = score;
    }

    // Let's modify the hashCode()
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.num == ((ObjectClassDemo)obj).num;
    }

    // For clone we need to understand interface we will see after learn about interfaces in java.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    // These 2 methods we already covered in the pillars of OOPs and introduction to OOPs.

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        // hasCode() of above object is  1826771953
        ObjectClassDemo objectClassDemo = new ObjectClassDemo(20,89.0f);
        // hasCode() - now the hashCode() will return the num we pass
        System.out.println(objectClassDemo.hashCode());
        // hasCode() of above object is  1406718218
        ObjectClassDemo objectClassDemo2 = new ObjectClassDemo(20,90.4f);
        // hashCode() - now the hashCode() will return the num we pass
        System.out.println(objectClassDemo2.hashCode());


        /*
            if(objectClassDemo < objectClassDemo2){
                If we do like this it will show error.
                Java may confuse which one I compare num or score,
            }
        */

        // Comparator - checks both variables in same object
        if(objectClassDemo == objectClassDemo2){
            System.out.println("==");
            System.out.println("objectClassDemo equal to objectClassDemo2");
        }
        // Method - checking the content
        if(objectClassDemo .equals(objectClassDemo2)){
            System.out.println("Equals methods");
            System.out.println("objectClassDemo equal to objectClassDemo2");
        }

        // Check wheteher the object belongs to that particular class or not,return true or false.
        System.out.println(objectClassDemo instanceof ObjectClassDemo);

        // Get the information about the class - class object_class.ObjectClassDemo it has so many build in methods.
        System.out.println(objectClassDemo.getClass());

//        ObjectClassDemo newObject = (ObjectClassDemo) objectClassDemo.clone();
//        System.out.println(objectClassDemo);
//        System.out.println(newObject);
    }
}
