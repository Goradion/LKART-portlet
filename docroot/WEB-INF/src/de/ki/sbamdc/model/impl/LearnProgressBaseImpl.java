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

package de.ki.sbamdc.model.impl;

import aQute.bnd.annotation.ProviderType;

import de.ki.sbamdc.model.LearnProgress;
import de.ki.sbamdc.service.LearnProgressLocalServiceUtil;

/**
 * The extended model base implementation for the LearnProgress service. Represents a row in the &quot;sbamdc_LearnProgress&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LearnProgressImpl}.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see LearnProgressImpl
 * @see LearnProgress
 * @generated
 */
@ProviderType
public abstract class LearnProgressBaseImpl extends LearnProgressModelImpl
	implements LearnProgress {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a learn progress model instance should use the {@link LearnProgress} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			LearnProgressLocalServiceUtil.addLearnProgress(this);
		}
		else {
			LearnProgressLocalServiceUtil.updateLearnProgress(this);
		}
	}
}