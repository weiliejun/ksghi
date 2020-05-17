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
package org.jmesa.view.html;

import org.jmesa.core.CoreContext;
import org.jmesa.view.html.component.HtmlTable;
import org.jmesa.view.html.toolbar.Toolbar;

/**
 * @author Jeff Johnston
 * @since 2.0
 * @deprecated You should extend the HtmlSnippets class directly.
 */
@Deprecated
public class HtmlSnippetsImpl extends HtmlSnippets {
    /**
     * @deprecated You should extend the HtmlSnippets class directly.
     */
    @Deprecated
    public HtmlSnippetsImpl(HtmlTable table, Toolbar toolbar, CoreContext coreContext) {
        super(table, toolbar, coreContext);
    }
}
