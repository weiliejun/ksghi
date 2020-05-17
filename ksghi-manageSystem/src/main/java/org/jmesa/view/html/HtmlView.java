// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HtmlView.java

package org.jmesa.view.html;

// Referenced classes of package org.jmesa.view.html:
//			AbstractHtmlView, HtmlBuilder, HtmlSnippets

public class HtmlView extends AbstractHtmlView {

    public HtmlView() {
    }

    public Object render() {
        HtmlSnippets snippets = getHtmlSnippets();
        HtmlBuilder html = new HtmlBuilder();
        html.append(snippets.themeStart());
        html.append(snippets.tableStart());
        html.append(snippets.theadStart());
        html.append(snippets.filter());
        html.append(snippets.header());
        html.append(snippets.theadEnd());
        html.append(snippets.tbodyStart());
        html.append(snippets.body());
        html.append(snippets.tbodyEnd());
        html.append(snippets.footer());
        html.append(snippets.toolbar());
        html.append(snippets.tableEnd());
        html.append(snippets.themeEnd());
        html.append(snippets.initJavascriptLimit());
        return html.toString();
    }
}
