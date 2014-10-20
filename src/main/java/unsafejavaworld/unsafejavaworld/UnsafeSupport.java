package unsafejavaworld.unsafejavaworld;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeSupport {

    public static final Unsafe UNSAFE;

    static {
        UNSAFE = findUnsafe();
    }

    private static Unsafe findUnsafe() {
        try {
            return Unsafe.getUnsafe();
        } catch (SecurityException ignore) {
            // Ignore, try next
        }

        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(Unsafe.class);

        } catch (Exception ignore) {
            // Ignore, try hardcore version! :)
        }

        for (Field field : Unsafe.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (Unsafe.class.isAssignableFrom(field.getType())) {
                    return (Unsafe) field.get(Unsafe.class);
                }


            } catch (Exception ignore) {
                // Again just go for ignoring it :D
            }
        }

        throw new NotFeelingUnsafeTodayException();
    }
}
