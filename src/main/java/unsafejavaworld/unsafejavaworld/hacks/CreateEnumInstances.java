package unsafejavaworld.unsafejavaworld.hacks;

import unsafejavaworld.unsafejavaworld.UnsafeSupport;

import java.lang.reflect.Field;

public class CreateEnumInstances {

    public static void main(String[] args) throws Exception {
        YesNo Maybe = (YesNo) UnsafeSupport.UNSAFE.allocateInstance(YesNo.class);
        Field name = Enum.class.getDeclaredField("name");
        name.setAccessible(true);
        name.set(Maybe, "Maybe");
        Field ordinal = Enum.class.getDeclaredField("ordinal");
        ordinal.setAccessible(true);
        ordinal.set(Maybe, 2);
        System.out.println("Maybe is " + Maybe.getClass() + " " + Maybe);
    }

    enum YesNo {
        No,
        Yes
    }
}
