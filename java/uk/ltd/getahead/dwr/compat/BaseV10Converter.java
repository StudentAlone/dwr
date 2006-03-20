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
package uk.ltd.getahead.dwr.compat;

import uk.ltd.getahead.dwr.MarshallException;
import uk.ltd.getahead.dwr.OutboundContext;
import uk.ltd.getahead.dwr.OutboundVariable;
import uk.ltd.getahead.dwr.dwrp.Converter;

/**
 * A way to migrate from the DWRv1.x Converter style to something in the future.
 * Inheriting from this is advised to help with forwards compatibility.
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 * @noinspection AbstractClassNeverImplemented
 */
public abstract class BaseV10Converter implements Converter
{
    /* (non-Javadoc)
     * @see uk.ltd.getahead.dwr.Converter#convertOutbound(java.lang.Object, uk.ltd.getahead.dwr.OutboundContext)
     */
    public OutboundVariable convertOutbound(Object data, OutboundContext outctx) throws MarshallException
    {
        OutboundVariable ov = outctx.createOutboundVariable(data);
        ov.setInitCode(convertOutbound(data, ov.getAssignCode(), outctx));
        return ov;
    }

    /**
     * @see Converter#convertOutbound(Object, OutboundContext)
     * @param varname The name of the variable to declare
     * @param data The data to convert
     * @param outctx Objects already converted and the results
     * @return The OutboundVariable that represents the data to convert
     * @throws MarshallException If the conversion failed for some reason
     */
    public abstract String convertOutbound(Object data, String varname, OutboundContext outctx) throws MarshallException;
}
