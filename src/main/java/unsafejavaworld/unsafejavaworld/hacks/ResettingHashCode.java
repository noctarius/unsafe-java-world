package unsafejavaworld.unsafejavaworld.hacks;

import unsafejavaworld.unsafejavaworld.UnsafeSupport;

public class ResettingHashCode {

    public static void main(String[] args) {
        UnsafeRandomInt rand = new UnsafeRandomInt();
        for (int i = 0; i < 10; i++) {
            System.out.println(Integer.toHexString(rand.next31()));
        }

    }

    static class UnsafeRandomInt {
        public int next31() {
            UnsafeSupport.UNSAFE.putInt(this, 1L, 0);
            return hashCode();
        }
    }
}
