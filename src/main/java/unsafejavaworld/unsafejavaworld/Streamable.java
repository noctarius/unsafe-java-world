package unsafejavaworld.unsafejavaworld;

import java.nio.ByteBuffer;

public interface Streamable {

    void write(ByteBuffer byteBuffer);

    void read(ByteBuffer byteBuffer);
}
