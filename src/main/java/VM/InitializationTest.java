package VM;

/**
 * Created by bitbook on 7/21/18.
 */
class SuperClass {
    static {
        System.out.println("super class init");
    }
}

public class InitializationTest {

    static {
        System.out.println("main class init");
    }

    public static void main(String[] args) {
        SuperClass[] array = new SuperClass[3];
    }
}
