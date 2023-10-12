/*Generated code by Binis' code generator.*/
package net.binis.codegen.modifier.test;

import net.binis.codegen.modifier.impl.BaseModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import javax.annotation.processing.Generated;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@Generated(value = "net.binis.codegen.modifier.test.SpotBugsPrototype", comments = "SpotBugs")
public class SpotBugsImpl implements SpotBugs, Modifiable<SpotBugs.Modify> {

    protected boolean active;

    public SpotBugsImpl() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public SpotBugs.Modify with() {
        return new SpotBugsModifyImpl(this);
    }

    @Generated("ModifierEnricher")
    protected class SpotBugsModifyImpl extends BaseModifierImpl<SpotBugs.Modify, SpotBugs> implements SpotBugs.Modify {

        protected SpotBugsModifyImpl(SpotBugs parent) {
            super(parent);
        }

        public SpotBugs.Modify active(boolean active) {
            SpotBugsImpl.this.active = active;
            return this;
        }

        @SuppressFBWarnings("EI_EXPOSE_REP")
        public SpotBugs done() {
            return SpotBugsImpl.this;
        }
    }
}
