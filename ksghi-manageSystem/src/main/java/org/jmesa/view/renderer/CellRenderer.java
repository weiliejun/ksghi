/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmesa.view.renderer;

import org.jmesa.view.component.Column;
import org.jmesa.view.editor.CellEditor;

/**
 * @author Jeff Johnston
 * @since 2.0
 */
public interface CellRenderer {
    /**
     * @deprecated Should get/set the value on the Column.
     */
    @Deprecated
    public CellEditor getCellEditor();

    /**
     * @deprecated Should get/set the value on the Column.
     */
    @Deprecated
    public void setCellEditor(CellEditor editor);

    public Column getColumn();

    public void setColumn(Column column);

    public Object render(Object item, int rowcount);
}