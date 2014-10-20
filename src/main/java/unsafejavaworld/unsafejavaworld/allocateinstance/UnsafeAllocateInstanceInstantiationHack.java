package unsafejavaworld.unsafejavaworld.allocateinstance;

import unsafejavaworld.unsafejavaworld.UnsafeSupport;

import java.lang.reflect.Field;

public class UnsafeAllocateInstanceInstantiationHack {

    public static void main(String[] args) throws Exception {
        // Instantiate String without calling the constructor
        String foo = (String) UnsafeSupport.UNSAFE.allocateInstance(String.class);

        // Get accessor to the internal char[] field
        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);

        // Show content of the String instance
        System.out.println("Value before Field::set: " + valueField.get(foo));
        System.out.println("Value before Field::set: " + foo);

        // Rewrite the value to "Something"->char[]
        valueField.set(foo, "Something".toCharArray());

        // Show content after changing the String instance
        System.out.println("Value after Field::set: " + valueField.get(foo));
        System.out.println("Value before Field::set: " + foo);
    }
}
