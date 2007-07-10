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
package org.directwebremoting.servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.WebContextFactory;
import org.directwebremoting.extend.DwrConstants;
import org.directwebremoting.extend.ServerLoadMonitor;
import org.directwebremoting.util.MimeConstants;

/**
 * A Handler that supports requests for engine.js
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class EngineHandler extends FileHandler
{
    /**
     * Setup the {@link FileHandler} defaults
     */
    public EngineHandler()
    {
        setMimeType(MimeConstants.MIME_JS);
    }

    /**
     * The URL for this Handler.
     * @param url The URL for this Handler.
     */
    public void setEngineHandlerUrl(String url)
    {
        setFilePath(url);
    }

    /* (non-Javadoc)
     * @see org.directwebremoting.servlet.FileHandler#getSearchReplacePairs()
     */
    @Override
    public Map<String, String> getSearchReplacePairs()
    {
        HttpServletRequest request = WebContextFactory.get().getHttpServletRequest();
        Map<String, String> replace = new HashMap<String, String>();

        // If we are dynamic then we might need to pre-configure some variables.
        // TODO: Move this code into EngineHandler
        boolean streaming = true;

        // If the maxWaitAfterWrite time is less than half a second then we
        // count ourselves to be not streaming, and use the simple XHR
        // connection method.
        if (maxWaitAfterWrite > -1 && maxWaitAfterWrite < 500)
        {
            streaming = false;
        }

        // If the ServerLoadMonitor says no streaming, then obviously ...
        if (!serverLoadMonitor.supportsStreaming())
        {
            streaming = false;
        }

        // Poll using XHR (to avoid IE clicking) if we close
        // the connection than 1sec after output happens.
        String pollWithXhr = streaming ? "false" : "true";
        replace.put(PARAM_SCRIPT_POLLXHR, pollWithXhr);

        String path = request.getContextPath() + request.getServletPath();
        if (overridePath != null)
        {
            path = overridePath;
        }
        replace.put(PARAM_DEFAULT_PATH, path);

        replace.put(PARAM_SCRIPT_COOKIENAME, sessionCookieName);
        replace.put(PARAM_SCRIPT_ALLOWGET, String.valueOf(allowGetForSafariButMakeForgeryEasier));
        replace.put(PARAM_SCRIPT_TAG_PROTECTION, scriptTagProtection);

        return replace;
    }

    /**
     * Are we supporting streaming?
     * @param serverLoadMonitor the serverLoadMonitor to set
     */
    public void setServerLoadMonitor(ServerLoadMonitor serverLoadMonitor)
    {
        this.serverLoadMonitor = serverLoadMonitor;
    }

    /**
     * @param allowGetForSafariButMakeForgeryEasier Do we reduce security to help Safari
     */
    public void setAllowGetForSafariButMakeForgeryEasier(boolean allowGetForSafariButMakeForgeryEasier)
    {
        this.allowGetForSafariButMakeForgeryEasier = allowGetForSafariButMakeForgeryEasier;
    }

    /**
     * What is the string we use for script tag hack protection
     * @param scriptTagProtection the scriptTagProtection to set
     */
    public void setScriptTagProtection(String scriptTagProtection)
    {
        this.scriptTagProtection = scriptTagProtection;
    }

    /**
     * If we need to override the default path
     * @param overridePath The new override path
     */
    public void setOverridePath(String overridePath)
    {
        this.overridePath = overridePath;
    }

    /**
     * If we need to override the default path
     */
    private String overridePath = null;

    /**
     * By default we disable GET, but this hinders old Safaris
     */
    private boolean allowGetForSafariButMakeForgeryEasier = false;

    /**
     * What is the string we use for script tag hack protection
     */
    private String scriptTagProtection = DwrConstants.SCRIPT_TAG_PROTECTION;

    /**
     * Are we supporting streaming?
     */
    private ServerLoadMonitor serverLoadMonitor;
}
