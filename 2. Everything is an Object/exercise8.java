import java.util.Date;

/**
 * Static fields
 */
public class Exercise8 {

    public class StaticDemo {
        static int i = 1;
    }

    public void StaticInvestigation() {
        StaticDemo static1 = new StaticDemo();
        StaticDemo static2 = new StaticDemo();
        StaticDemo static3 = new StaticDemo();

        System.out.println("Static 1 i:" + static1.i);
        System.out.println("Static 2 i:" + static2.i);
        System.out.println("Static 3 i:" + static3.i);

        static2.i++;

        System.out.println("Static 1 i:" + static1.i);
        System.out.println("Static 2 i:" + static2.i);
        System.out.println("Static 3 i:" + static3.i);,

        StaticDemo.i++;

        System.out.println("Static 1 i:" + static1.i);
        System.out.println("Static 2 i:" + static2.i);
        System.out.println("Static 3 i:" + static3.i);
    }

    public static void main(String[] args) {
        new Exercise8().StaticInvestigation();
    }
}
