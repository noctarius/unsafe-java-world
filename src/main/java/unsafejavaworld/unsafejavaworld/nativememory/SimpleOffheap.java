package unsafejavaworld.unsafejavaworld.nativememory;

import unsafejavaworld.unsafejavaworld.UnsafeSupport;

import static org.junit.Assert.assertEquals;

public class SimpleOffheap {

    public static void main(String[] args) {
        // Allocate a native memory address
        long address = UnsafeSupport.UNSAFE.allocateMemory(1024);

        // Write 1024 long values
        for (int i = 0; i < 1024; i += 8)
            UnsafeSupport.UNSAFE.putLong(address + i, i);

        // Read 1024 long values and make sure they are the same
        for (int i = 0; i < 102400; i += 8) {
            long aLong = UnsafeSupport.UNSAFE.getLong(address + i);
            assertEquals(aLong, i);
            System.out.println(aLong);
        }

        // Free allocates memory
        UnsafeSupport.UNSAFE.freeMemory(address);
    }
}
