/*Generated code by Binis' code generator.*/
package net.binis.codegen;

import net.binis.codegen.spring.modifier.impl.BaseEntityModifierImpl;
import net.binis.codegen.modifier.Modifiable;
import net.binis.codegen.factory.CodeFactory;
import javax.annotation.processing.Generated;

@Generated(value = "net.binis.codegen.prototype.TestMockEntityPrototype", comments = "TestMock")
public class TestMockEntity implements TestMock, Modifiable<TestMock.Modify> {

    protected String actionLink;

    protected String buttonText;

    protected String code;

    protected String description;

    protected String name;

    static {
        CodeFactory.registerType(TestMock.class, TestMockEntity::new, null);
    }

    public TestMockEntity() {
    }

    public String getActionLink() {
        return actionLink;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setActionLink(String actionLink) {
        this.actionLink = actionLink;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestMock.Modify with() {
        return new TestMockEntityModifyImpl(this);
    }

    @Generated("ModifierEnricher")
    protected class TestMockEntityModifyImpl extends BaseEntityModifierImpl<TestMock.Modify, TestMock> implements TestMock.Modify {

        protected TestMockEntityModifyImpl(TestMock parent) {
            super(parent);
        }

        public TestMock.Modify actionLink(String actionLink) {
            TestMockEntity.this.actionLink = actionLink;
            return this;
        }

        public TestMock.Modify buttonText(String buttonText) {
            TestMockEntity.this.buttonText = buttonText;
            return this;
        }

        public TestMock.Modify code(String code) {
            TestMockEntity.this.code = code;
            return this;
        }

        public TestMock.Modify description(String description) {
            TestMockEntity.this.description = description;
            return this;
        }

        public TestMock done() {
            return TestMockEntity.this;
        }

        public TestMock.Modify name(String name) {
            TestMockEntity.this.name = name;
            return this;
        }
    }
}
