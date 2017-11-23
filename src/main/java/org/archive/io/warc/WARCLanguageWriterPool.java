/*
 * Copyright 2017 The International Internet Preservation Consortium.
 *
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
 */
package org.archive.io.warc;

import java.util.concurrent.atomic.AtomicInteger;
import org.archive.io.WriterPool;
import org.archive.io.WriterPoolMember;

/**
 * A pool of WARCWriters.
 * @contributor stack
 * @contributor gojomo
 * @version $Revision: 4566 $ $Date: 2006-08-31 09:51:41 -0700 (Thu, 31 Aug 2006) $
 * modified by Heidi Jauhiainen
 * - using WARCLanguageWriter
 */
public class WARCLanguageWriterPool extends WriterPool {
    /**
     * Constructor
     * @param settings Settings for this pool.
     * @param poolMaximumActive
     * @param poolMaximumWait
     */
    public WARCLanguageWriterPool(final WARCWriterPoolSettings settings,
            final int poolMaximumActive, final int poolMaximumWait) {
    	this(new AtomicInteger(), settings, poolMaximumActive, poolMaximumWait);
    }
    
    /**
     * Constructor
     * @param serial  Used to generate unique filename sequences
     * @param settings Settings for this pool.
     * @param poolMaximumActive
     * @param poolMaximumWait
     */
    public WARCLanguageWriterPool(final AtomicInteger serial,
    		final WARCWriterPoolSettings settings,
            final int poolMaximumActive, final int poolMaximumWait) {
    	super(serial, settings, poolMaximumActive, poolMaximumWait);
    }
    
    /* (non-Javadoc)
     * @see org.archive.io.WriterPool#makeWriter()
     * modified by Heidi Jauhiainen
     * - using WARCLanguageWriter instead of WARCWriter
     */
    protected WriterPoolMember makeWriter() {
        return new WARCLanguageWriter(serialNo, (WARCWriterPoolSettings)settings);
    }
}
