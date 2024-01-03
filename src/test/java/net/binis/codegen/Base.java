/*Generated code by Binis' code generator.*/
package net.binis.codegen;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2024 Binis Belev
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import net.binis.codegen.intf.Typeable;
import net.binis.codegen.enums.TestEnum;
import javax.annotation.processing.Generated;
import java.time.OffsetDateTime;

@Generated(value = "net.binis.codegen.BasePrototype", comments = "BaseImpl")
public interface Base extends Typeable<TestEnum> {
    OffsetDateTime getDate();
    Long getId();

    void setDate(OffsetDateTime date);
    void setId(Long id);

    interface Fields<T> {
        T date(OffsetDateTime date);
        T id(Long id);
        T type(TestEnum type);
    }
}
