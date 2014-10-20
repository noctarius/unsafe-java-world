package unsafejavaworld.unsafejavaworld.compareswap;

import unsafejavaworld.unsafejavaworld.UnsafeSupport;
import sun.nio.ch.DirectBuffer;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class CompareAndSwap {

    public static void main(String[] args) throws Exception {
        // Create Filechannel
        FileChannel fc = new RandomAccessFile("/tmp/counters", "rw").getChannel();

        // Map file into memory
        MappedByteBuffer map = fc.map(FileChannel.MapMode.READ_WRITE, 0, 1024);

        // Get address of the mapped DirectByteBuffer
        long address = ((DirectBuffer) map).address();

        // Give me 1000 unique sequence numbers
        for (int i = 0; i < 100; i++) {
            long next = getAndIncrement(address);
            System.out.println(next);
        }

        // Close Filechannel
        fc.close();
    }

    private static long getAndIncrement(long address) {
        // Increment and return value
        return UnsafeSupport.UNSAFE.getAndAddLong(null, address, 1);
    }
}
