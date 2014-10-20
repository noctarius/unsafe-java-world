package unsafejavaworld.unsafejavaworld.exception;

import unsafejavaworld.unsafejavaworld.UnsafeSupport;

public class SneakyThrow {

    public static void main(String[] args){
        // Using sun.misc.Unsafe
        // unsafeThrow();

        // Using Thread.stop
        //threadStop();

        // Using Reflection
        // newInstance();

        // Using Generics
        // SneakyThrow.<RuntimeException> genericRethrow();
    }

    private static void unsafeThrow() {
        UnsafeSupport.UNSAFE.throwException(new Exception("Unsafe::throwException"));
    }

    private static void threadStop() {
        Thread.currentThread().stop(new Exception("Thread::stop"));
    }

    private static void newInstance() {
        Holder.exception = new Exception("Holder::newInstance");
        try {
            Holder.class.newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
    }

    private static <T extends Throwable> RuntimeException genericRethrow() throws T {
        throw (T) new Exception("Generic::rethrow");
    }

    static class Holder {
        public static Exception exception;

        public Holder() throws Exception {
            throw exception;
        }
    }
}
