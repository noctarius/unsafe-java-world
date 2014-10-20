package unsafejavaworld.unsafejavaworld.hacks;

import unsafejavaworld.unsafejavaworld.UnsafeSupport;

public class ReplaceSuperclass {

    public static void main(String[] args) throws Exception {
        // Reading the address of the String class
        long strClassAddress = normalize(UnsafeSupport.UNSAFE.getInt("", 8L));

        // Reading the address of the Integer class
        long intClassAddress = normalize(UnsafeSupport.UNSAFE.getInt(new Integer(0), 8L));

        // Write String class address as superclass to Integer class
        UnsafeSupport.UNSAFE.putAddress(intClassAddress + 32, strClassAddress);

        // Creating a new Integer object
        Integer intValue = new Integer(666);

        // Casting the Integer to it's now String superclass
        String value = (String) (Object) intValue;

        // Proof it works :)
        System.out.println("String (Integer) value is: " + value);

        Class<?> clazz = Integer.class;
        while (clazz != null) {
            System.out.println("Class: " + clazz);
            clazz = clazz.getSuperclass();
        }
    }

    private static long normalize(long value) {
        if (value >= 0) {
            return value;
        }
        return (~0L >>> 32) & value;
    }
}
