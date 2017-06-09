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

import de.ki.sbamdc.service.LearnProgressLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @generated
 */
@ProviderType
public class LearnProgressLocalServiceClpInvoker {
	public LearnProgressLocalServiceClpInvoker() {
		_methodName0 = "addLearnProgress";

		_methodParameterTypes0 = new String[] { "de.ki.sbamdc.model.LearnProgress" };

		_methodName1 = "createLearnProgress";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteLearnProgress";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteLearnProgress";

		_methodParameterTypes3 = new String[] { "de.ki.sbamdc.model.LearnProgress" };

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchLearnProgress";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getLearnProgress";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getActionableDynamicQuery";

		_methodParameterTypes12 = new String[] {  };

		_methodName13 = "getIndexableActionableDynamicQuery";

		_methodParameterTypes13 = new String[] {  };

		_methodName15 = "deletePersistedModel";

		_methodParameterTypes15 = new String[] {
				"com.liferay.portal.kernel.model.PersistedModel"
			};

		_methodName16 = "getPersistedModel";

		_methodParameterTypes16 = new String[] { "java.io.Serializable" };

		_methodName17 = "getLearnProgresses";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getLearnProgressesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateLearnProgress";

		_methodParameterTypes19 = new String[] {
				"de.ki.sbamdc.model.LearnProgress"
			};

		_methodName46 = "getOSGiServiceIdentifier";

		_methodParameterTypes46 = new String[] {  };

		_methodName51 = "findByUserId";

		_methodParameterTypes51 = new String[] { "long" };

		_methodName52 = "fetchByUserIdAndFlashcardId";

		_methodParameterTypes52 = new String[] { "long", "long" };

		_methodName53 = "addLearnProgress";

		_methodParameterTypes53 = new String[] {
				"long", "de.ki.sbamdc.model.Flashcard"
			};

		_methodName54 = "loadProgressByUserIdAndCardBoxId";

		_methodParameterTypes54 = new String[] { "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return LearnProgressLocalServiceUtil.addLearnProgress((de.ki.sbamdc.model.LearnProgress)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return LearnProgressLocalServiceUtil.createLearnProgress(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return LearnProgressLocalServiceUtil.deleteLearnProgress(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return LearnProgressLocalServiceUtil.deleteLearnProgress((de.ki.sbamdc.model.LearnProgress)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return LearnProgressLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return LearnProgressLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return LearnProgressLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return LearnProgressLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator<?>)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return LearnProgressLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return LearnProgressLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return LearnProgressLocalServiceUtil.fetchLearnProgress(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return LearnProgressLocalServiceUtil.getLearnProgress(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return LearnProgressLocalServiceUtil.getActionableDynamicQuery();
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return LearnProgressLocalServiceUtil.getIndexableActionableDynamicQuery();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return LearnProgressLocalServiceUtil.deletePersistedModel((com.liferay.portal.kernel.model.PersistedModel)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return LearnProgressLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return LearnProgressLocalServiceUtil.getLearnProgresses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return LearnProgressLocalServiceUtil.getLearnProgressesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return LearnProgressLocalServiceUtil.updateLearnProgress((de.ki.sbamdc.model.LearnProgress)arguments[0]);
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return LearnProgressLocalServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return LearnProgressLocalServiceUtil.findByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return LearnProgressLocalServiceUtil.fetchByUserIdAndFlashcardId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return LearnProgressLocalServiceUtil.addLearnProgress(((Long)arguments[0]).longValue(),
				(de.ki.sbamdc.model.Flashcard)arguments[1]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return LearnProgressLocalServiceUtil.loadProgressByUserIdAndCardBoxId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
}