/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.ki.sbamdc.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Flashcard service. Represents a row in the &quot;sbamdc_Flashcard&quot; database table, with each column mapped to a property of this class.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see FlashcardModel
 * @see de.ki.sbamdc.model.impl.FlashcardImpl
 * @see de.ki.sbamdc.model.impl.FlashcardModelImpl
 * @generated
 */
@ImplementationClassName("de.ki.sbamdc.model.impl.FlashcardImpl")
@ProviderType
public interface Flashcard extends FlashcardModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.ki.sbamdc.model.impl.FlashcardImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Flashcard, Long> ID_ACCESSOR = new Accessor<Flashcard, Long>() {
			@Override
			public Long get(Flashcard flashcard) {
				return flashcard.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Flashcard> getTypeClass() {
				return Flashcard.class;
			}
		};
}