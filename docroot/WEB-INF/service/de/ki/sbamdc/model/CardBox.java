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
 * The extended model interface for the CardBox service. Represents a row in the &quot;sbamdc_CardBox&quot; database table, with each column mapped to a property of this class.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see CardBoxModel
 * @see de.ki.sbamdc.model.impl.CardBoxImpl
 * @see de.ki.sbamdc.model.impl.CardBoxModelImpl
 * @generated
 */
@ImplementationClassName("de.ki.sbamdc.model.impl.CardBoxImpl")
@ProviderType
public interface CardBox extends CardBoxModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.ki.sbamdc.model.impl.CardBoxImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CardBox, Long> ID_ACCESSOR = new Accessor<CardBox, Long>() {
			@Override
			public Long get(CardBox cardBox) {
				return cardBox.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CardBox> getTypeClass() {
				return CardBox.class;
			}
		};
}