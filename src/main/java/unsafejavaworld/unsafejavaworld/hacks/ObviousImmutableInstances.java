package unsafejavaworld.unsafejavaworld.hacks;

import java.lang.reflect.Field;

public class ObviousImmutableInstances {

    public static void main(String[] args) throws Exception {
        // Creating Integer value object
        Integer i = 5;

        // Retrieving the value field inside Integer
        Field value = Integer.class.getDeclaredField("value");
        value.setAccessible(true);

        // Rewrite internal value to 6
        value.set(i, 6);

        // Sum up
        Integer sum = 3 + 2;
        System.out.println("3 + 2 = " + sum);

        // Compare
        Integer five = 5;
        Integer six = 6;
        System.out.println("5 equals 6 is " + five.equals(six));
    }
}
