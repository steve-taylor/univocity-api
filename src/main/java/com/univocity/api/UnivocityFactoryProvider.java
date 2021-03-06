/*******************************************************************************
 * Copyright (c) 2014 uniVocity Software Pty Ltd. All rights reserved.
 * This file is subject to the terms and conditions defined in file
 * 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package com.univocity.api;

import com.univocity.api.data.*;
import com.univocity.api.engine.*;

/**
 * The <code>UnivocityFactoryProvider</code> is used to obtain actual implementations of {@link DatasetFactory} and {@link DataIntegrationEngineFactory}
 * from univocity.jar. It is used internally by the {@link Univocity} class.
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:dev@univocity.com">dev@univocity.com</a>
 *
 */
public interface UnivocityFactoryProvider {

	/**
	 * Returns a {@link DatasetFactory} provided by uniVocity.
	 * @return a {@link DatasetFactory}
	 */
	public DatasetFactory getDatasetFactory();

	/**
	 * Returns a {@link DataIntegrationEngineFactory} provided by uniVocity.
	 * @return a {@link DataIntegrationEngineFactory}
	 */
	public DataIntegrationEngineFactory getDataIntegrationEngineFactory();

}
