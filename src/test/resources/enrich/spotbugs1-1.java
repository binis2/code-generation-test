/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.modifier.BaseModifier;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.modifier.test.SpotBugsPrototype", comments = "SpotBugsImpl")
public interface SpotBugs {
    boolean isActive();

    void setActive(boolean active);

    SpotBugs.Modify with();

    interface Fields<T> {
        T active(boolean active);
    }

    interface Modify extends SpotBugs.Fields<SpotBugs.Modify>, BaseModifier<SpotBugs.Modify, SpotBugs> {
    }
}
