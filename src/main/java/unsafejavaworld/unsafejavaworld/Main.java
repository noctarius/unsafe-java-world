package unsafejavaworld.unsafejavaworld;

import unsafejavaworld.unsafejavaworld.allocateinstance.BytecodeInstantiationHack;
import unsafejavaworld.unsafejavaworld.compareswap.CompareAndSwap;
import unsafejavaworld.unsafejavaworld.exception.SneakyThrow;
import unsafejavaworld.unsafejavaworld.hacks.CreateEnumInstances;
import unsafejavaworld.unsafejavaworld.hacks.ObviousImmutableInstances;
import unsafejavaworld.unsafejavaworld.hacks.ResettingHashCode;
import unsafejavaworld.unsafejavaworld.nativememory.SimpleOffheap;
import unsafejavaworld.unsafejavaworld.security.ExploitingSecurityChecks;

public class Main {

    public static void main(String[] args) throws Exception {
        ObviousImmutableInstances.main(args);
        SimpleOffheap.main(args);
        CompareAndSwap.main(args);
        BytecodeInstantiationHack.main(args);
        ResettingHashCode.main(args);
        CreateEnumInstances.main(args);
        SneakyThrow.main(args);
        ExploitingSecurityChecks.main(args);
        // Replacing JRE Classes
    }
}
