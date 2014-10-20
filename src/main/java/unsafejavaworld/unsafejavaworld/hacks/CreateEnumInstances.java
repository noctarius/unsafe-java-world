package unsafejavaworld.unsafejavaworld.hacks;

import unsafejavaworld.unsafejavaworld.UnsafeSupport;

import java.lang.reflect.Field;

public class CreateEnumInstances {

    public static void main(String[] args) throws Exception {
        // Create new YesNo instance
        YesNo Maybe = (YesNo) UnsafeSupport.UNSAFE.allocateInstance(YesNo.class);

        // Get field name
        Field name = Enum.class.getDeclaredField("name");
        name.setAccessible(true);

        // Rename the new instance to Maybe
        name.set(Maybe, "Maybe");

        // Get field ordinal
        Field ordinal = Enum.class.getDeclaredField("ordinal");
        ordinal.setAccessible(true);

        // Reset ordinal of the new instance to 2
        ordinal.set(Maybe, 2);

        // Proof the new enum instance exists
        System.out.println("Maybe is " + Maybe.getClass() + " " + Maybe);
    }

    enum YesNo {
        No,
        Yes
    }
}
