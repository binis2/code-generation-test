/*Generated code by Binis' code generator.*/
package net.binis.codegen.impl;

/*-
 * #%L
 * code-generation-test
 * %%
 * Copyright (C) 2021 - 2022 Binis Belev
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

import net.binis.codegen.Base;
import net.binis.codegen.enums.TestEnum;
import javax.annotation.processing.Generated;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Generated(value = "BasePrototype", comments = "Base")
public class BaseEntity implements Base {

    protected OffsetDateTime date;

    @Id
    protected Long id;

    protected TestEnum type;

    public BaseEntity() {
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public TestEnum getType() {
        return type;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
