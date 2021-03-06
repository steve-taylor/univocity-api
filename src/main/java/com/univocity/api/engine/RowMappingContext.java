/*******************************************************************************
 * Copyright (c) 2013 uniVocity Software Pty Ltd. All rights reserved.
 * This file is subject to the terms and conditions defined in file
 * 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package com.univocity.api.engine;

import com.univocity.api.config.builders.*;

/**
 * The <code>RowMappingContext</code> is available to {@link RowReader} instances used during the execution of a data mapping between two entities.
 *
 * It provides information specific to the mapping being executed, as well as access to the {@link DataIntegrationEngine} execution context.
 *
 *
 * @see RowReader
 * @see EntityMappingContext
 * @see EngineExecutionContext
 * @see MappingCycleContext
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:dev@univocity.com">dev@univocity.com</a>
 *
 */
public interface RowMappingContext extends EntityMappingContext, EngineExecutionContext, MappingCycleContext {

	/**
	 * Discards the current row being processed. This behavior varies depending where the {@link RowReader} is applied:
	 *
	 * <ul>
	 *  <li><i><b>while reading from the input </b></i><code>{@link EntityMapping#addInputRowReader(RowReader)}</code>:
	 * 		<br>discards the input row. The discarded row won't be available to <code>RowReader</code> instances that manipulate output rows.
	 *  </li>
	 *  <li><i><b>before writing to the output </b></i><code>{@link EntityMapping#addInputRowReader(RowReader)}</code>:
	 *  	<br>discards the output row. The discarded row won't be available to <code>RowReader</code> instances that manipulate persisted rows.
	 *  </li>
	 *  <li><i><b>after writing to the output </b></i><code>{@link EntityMapping#addInputRowReader(RowReader)}</code>:
	 *  	<br>does nothing.
	 *  </li>
	 * </ul>
	 */
	public void discardRow();

	/**
	 * Returns the position of a field in the input row.
	 * @param fieldName the name of a field in the input row.
	 * @return the position of the given field name in the input row.
	 */
	public int getInputIndex(String fieldName);

	/**
	 * Returns the position of a field in the output row (if available).
	 * @param fieldName the name of a field in the output row.
	 * @return the position of the given field name in the output row.
	 */
	public int getOutputIndex(String fieldName);

	/**
	 * Return the current count of rows processed.
	 * @return the current count of rows processed.
	 */
	public int getCurrentRow();

	/**
	 * Returns the sequence of fields read from the input data entity.
	 * @return the sequence of fields read from the input data entity.
	 */
	public String[] getInputFields();

	/**
	 * Returns the sequence of fields read from the output data entity (if available).
	 * @return the sequence of fields read from the output data entity.
	 */
	public String[] getOutputFields();
}
