/*
 * Copyright 2005 Joe Walker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.directwebremoting.proxy.jsx3.html;

import java.lang.reflect.Constructor;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.proxy.ProxyHelper;

/**
 * @author Joe Walker [joe at getahead dot org]
 * @author DRAPGEN - Dwr Reverse Ajax Proxy GENerator
 */
public class Tag extends org.directwebremoting.proxy.jsx3.lang.Object
{
    /**
     * All reverse ajax proxies need context to work from
     * @param helper The store of the context for the current action
     */
    public Tag(ProxyHelper helper)
    {
        super(helper);
    }

    /**
     * The instance initializer.
     * @param strTagNS 
     * @param strTagName 
     */
    public Tag(String strTagNS, String strTagName)
    {
        super((ProxyHelper) null);
    }

    /**
     * Sdds a child to the list of this tag's children; may be vetoed by onAppendChild().
     * @param child the child to add, must not already have a parent
     */
    public void appendChild(org.directwebremoting.proxy.jsx3.html.Tag child)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("appendChild(").appendData(child).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes a child from the list of this tag's children; may be vetoed by onRemoveChild().
     * @param child the child to remove, must exist in the list of children
     */
    public void removeChild(org.directwebremoting.proxy.jsx3.html.Tag child)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("removeChild(").appendData(child).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Replaces a child of this tag.
     * @param child the new child.
     * @param oldChild the child to replace.
     */
    public void replaceChild(org.directwebremoting.proxy.jsx3.html.Tag child, org.directwebremoting.proxy.jsx3.html.Tag oldChild)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("replaceChild(").appendData(child).appendScript(",")

        .appendData(oldChild).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Removes all the children of this tag.
     */
    public void removeChildren()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("removeChildren(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Returns the parent tag.
     * @return parent
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.html.Tag getParent()
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getParent().");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.html.Tag> ctor = org.directwebremoting.proxy.jsx3.html.Tag.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.html.Tag.class.getName());
        }
    }

    /**
     * Returns the parent tag.
     * @param returnType The expected return type
     * @return parent
     */
    @SuppressWarnings("unchecked")
    public <T> T getParent(Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getParent().");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /*
     * Returns the children tags.
     * @return children
     *
    @SuppressWarnings("unchecked")
    public Object[] getChildren(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the id field.
     * @return id
     *
    @SuppressWarnings("unchecked")
    public String getId(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the id field.
     * @param id the new value for id
     */
    public void setId(String id)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setId(").appendData(id).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the cssClass field.
     * @return cssClass
     *
    @SuppressWarnings("unchecked")
    public String getClassName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets the cssClass field, the HTML 'class' attribute.
     * @param cssClass the new value for cssClass
     */
    public void setClassName(String cssClass)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setClassName(").appendData(cssClass).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets the extraStyles field, this string is prepended as-is to the generated value for the style attribute of the tag.
     * @param extraStyles the new value for extraStyles
     */
    public void setExtraStyles(String extraStyles)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setExtraStyles(").appendData(extraStyles).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Releases all bi-directional references between this instance and its children.
     */
    public void release()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("release(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Called before appending a child.
     * @param child 
     * @return <code>true</code> to allow the append, <code>false</code> to veto.
     *
    @SuppressWarnings("unchecked")
    public boolean onAppendChild(org.directwebremoting.proxy.jsx3.html.Tag child, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Called before removing a child.
     * @param child 
     * @return <code>true</code> to allow the removal, <code>false</code> to veto.
     *
    @SuppressWarnings("unchecked")
    public boolean onRemoveChild(org.directwebremoting.proxy.jsx3.html.Tag child, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Sets an attribute of this HTML element. This method may be called with a variable number of arguments, which are
    interpreted as name/value pairs, i.e.: tag.setProperty(n1, p1, n2, p2);.
     * @param strName the name of the attribute.
     * @param strValue the value of the attribute. If <code>null</code>, the attribute is removed.
     */
    public void setProperty(String strName, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setProperty(").appendData(strName).appendScript(",")

        .appendData(strValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns an attribute of this HTML element.
     * @param strName the name of the attribute.
     * @return the value of the attribute.
     *
    @SuppressWarnings("unchecked")
    public String getProperty(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Removes any number of properties from this HTML element.
     * @param strName the names of the attributes.
     */
    public void removeProperty(String strName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("removeProperty(").appendData(strName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /**
     * Sets a style of this HTML element. This method may be called with a variable number of arguments, which are
    interpreted as name/value pairs, i.e.: tag.setStyle(n1, s1, n2, s2);.
     * @param strName the name of the style.
     * @param strValue the value of the style.
     */
    public void setStyle(String strName, String strValue)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("setStyle(").appendData(strName).appendScript(",")

        .appendData(strValue).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns a style of this HTML element.
     * @param strName the name of the style.
     * @return the value of the style.
     *
    @SuppressWarnings("unchecked")
    public String getStyle(String strName, Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Removes any number of styles from this HTML element.
     * @param strName the names of the styles.
     */
    public void removeStyle(String strName)
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("removeStyle(").appendData(strName).appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * Returns the name of this HTML element, such as "table" or "div".
     * @return the tag name
     *
    @SuppressWarnings("unchecked")
    public String getTagName(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Returns the namespace of this HTML element.
     * @return the tag name
     *
    @SuppressWarnings("unchecked")
    public String getTagNS(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Serializes this HTML element to an HTML string using various overridable methods in this class.
    This method is only available in the VML version of this class.
     * @return this tag serialized to HTML.
     *
    @SuppressWarnings("unchecked")
    public String paint(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /*
     * Prepares this HTML element for insertion into the live browser DOM and returns the underlying native HTML element.
    This method is only available in the SVG version of this class.
     * @return the native browser html element.
     *
    @SuppressWarnings("unchecked")
    public String paintDom(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * This method is called on each HTML tag before it is painted to screen. Methods in subclasses of this class that
    override this method should begin with a call to jsxsuper().
     */
    public void paintUpdate()
    {
        ScriptBuffer script = new ScriptBuffer();
        script.appendData(getProxyHelper().getContext()).appendScript("paintUpdate(").appendScript(");");
        getProxyHelper().getScriptProxy().addScript(script);
    }

    /*
     * 
     *
    @SuppressWarnings("unchecked")
    public String toString(Callback callback)
    {
        String key = // Generate some id
        ScriptSession session = WebContext.get().getScriptSession();
        Map<String, Callback> callbackMap = session.getAttribute(CALLBACK_KEY);
        calbackMap.put(key, callback);
        session.addAttribute(CALLBACK_KEY, callbackMap);
    }
    */

    /**
     * Returns the first child tag of type type.
     * @param type the fully-qualified class name or the class constructor function.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.html.Tag getFirstChildOfType(String type)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + type + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.html.Tag> ctor = org.directwebremoting.proxy.jsx3.html.Tag.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.html.Tag.class.getName());
        }
    }

    /**
     * Returns the first child tag of type type.
     * @param type the fully-qualified class name or the class constructor function.
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChildOfType(String type, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + type + "\").");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

    /**
     * Returns the first child tag of type type.
     * @param type the fully-qualified class name or the class constructor function.
     */
    @SuppressWarnings("unchecked")
    public org.directwebremoting.proxy.jsx3.html.Tag getFirstChildOfType(org.directwebremoting.proxy.CodeBlock type)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + type + "\").");
        try
        {
            Constructor<org.directwebremoting.proxy.jsx3.html.Tag> ctor = org.directwebremoting.proxy.jsx3.html.Tag.class.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported type: " + org.directwebremoting.proxy.jsx3.html.Tag.class.getName());
        }
    }

    /**
     * Returns the first child tag of type type.
     * @param type the fully-qualified class name or the class constructor function.
     */
    @SuppressWarnings("unchecked")
    public <T> T getFirstChildOfType(org.directwebremoting.proxy.CodeBlock type, Class<T> returnType)
    {
        ProxyHelper child = getProxyHelper().getChildHelper("getFirstChildOfType(\"" + type + "\").");
        try
        {
            Constructor<T> ctor = returnType.getConstructor(ProxyHelper.class);
            return ctor.newInstance(child);
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException("Unsupported return type: " + returnType.getName());
        }
    }

}
