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

package de.ki.sbamdc.service.base;

import aQute.bnd.annotation.ProviderType;

import de.ki.sbamdc.service.FlashcardServiceUtil;

import java.util.Arrays;

/**
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @generated
 */
@ProviderType
public class FlashcardServiceClpInvoker {
	public FlashcardServiceClpInvoker() {
		_methodName36 = "getOSGiServiceIdentifier";

		_methodParameterTypes36 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return FlashcardServiceUtil.getOSGiServiceIdentifier();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName36;
	private String[] _methodParameterTypes36;
}