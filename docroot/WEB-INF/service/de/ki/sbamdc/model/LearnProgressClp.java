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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import de.ki.sbamdc.service.ClpSerializer;
import de.ki.sbamdc.service.LearnProgressLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class LearnProgressClp extends BaseModelImpl<LearnProgress>
	implements LearnProgress {
	public LearnProgressClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LearnProgress.class;
	}

	@Override
	public String getModelClassName() {
		return LearnProgress.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("userId_fk", getUserId_fk());
		attributes.put("cardBoxId_fk", getCardBoxId_fk());
		attributes.put("flashcardId_fk", getFlashcardId_fk());
		attributes.put("progress", getProgress());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long userId_fk = (Long)attributes.get("userId_fk");

		if (userId_fk != null) {
			setUserId_fk(userId_fk);
		}

		Long cardBoxId_fk = (Long)attributes.get("cardBoxId_fk");

		if (cardBoxId_fk != null) {
			setCardBoxId_fk(cardBoxId_fk);
		}

		Long flashcardId_fk = (Long)attributes.get("flashcardId_fk");

		if (flashcardId_fk != null) {
			setFlashcardId_fk(flashcardId_fk);
		}

		Integer progress = (Integer)attributes.get("progress");

		if (progress != null) {
			setProgress(progress);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_learnProgressRemoteModel != null) {
			try {
				Class<?> clazz = _learnProgressRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_learnProgressRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId_fk() {
		return _userId_fk;
	}

	@Override
	public void setUserId_fk(long userId_fk) {
		_userId_fk = userId_fk;

		if (_learnProgressRemoteModel != null) {
			try {
				Class<?> clazz = _learnProgressRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId_fk", long.class);

				method.invoke(_learnProgressRemoteModel, userId_fk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCardBoxId_fk() {
		return _cardBoxId_fk;
	}

	@Override
	public void setCardBoxId_fk(long cardBoxId_fk) {
		_cardBoxId_fk = cardBoxId_fk;

		if (_learnProgressRemoteModel != null) {
			try {
				Class<?> clazz = _learnProgressRemoteModel.getClass();

				Method method = clazz.getMethod("setCardBoxId_fk", long.class);

				method.invoke(_learnProgressRemoteModel, cardBoxId_fk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFlashcardId_fk() {
		return _flashcardId_fk;
	}

	@Override
	public void setFlashcardId_fk(long flashcardId_fk) {
		_flashcardId_fk = flashcardId_fk;

		if (_learnProgressRemoteModel != null) {
			try {
				Class<?> clazz = _learnProgressRemoteModel.getClass();

				Method method = clazz.getMethod("setFlashcardId_fk", long.class);

				method.invoke(_learnProgressRemoteModel, flashcardId_fk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getProgress() {
		return _progress;
	}

	@Override
	public void setProgress(int progress) {
		_progress = progress;

		if (_learnProgressRemoteModel != null) {
			try {
				Class<?> clazz = _learnProgressRemoteModel.getClass();

				Method method = clazz.getMethod("setProgress", int.class);

				method.invoke(_learnProgressRemoteModel, progress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLearnProgressRemoteModel() {
		return _learnProgressRemoteModel;
	}

	public void setLearnProgressRemoteModel(
		BaseModel<?> learnProgressRemoteModel) {
		_learnProgressRemoteModel = learnProgressRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _learnProgressRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_learnProgressRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			LearnProgressLocalServiceUtil.addLearnProgress(this);
		}
		else {
			LearnProgressLocalServiceUtil.updateLearnProgress(this);
		}
	}

	@Override
	public LearnProgress toEscapedModel() {
		return (LearnProgress)ProxyUtil.newProxyInstance(LearnProgress.class.getClassLoader(),
			new Class[] { LearnProgress.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LearnProgressClp clone = new LearnProgressClp();

		clone.setId(getId());
		clone.setUserId_fk(getUserId_fk());
		clone.setCardBoxId_fk(getCardBoxId_fk());
		clone.setFlashcardId_fk(getFlashcardId_fk());
		clone.setProgress(getProgress());

		return clone;
	}

	@Override
	public int compareTo(LearnProgress learnProgress) {
		long primaryKey = learnProgress.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LearnProgressClp)) {
			return false;
		}

		LearnProgressClp learnProgress = (LearnProgressClp)obj;

		long primaryKey = learnProgress.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", userId_fk=");
		sb.append(getUserId_fk());
		sb.append(", cardBoxId_fk=");
		sb.append(getCardBoxId_fk());
		sb.append(", flashcardId_fk=");
		sb.append(getFlashcardId_fk());
		sb.append(", progress=");
		sb.append(getProgress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("de.ki.sbamdc.model.LearnProgress");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId_fk</column-name><column-value><![CDATA[");
		sb.append(getUserId_fk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardBoxId_fk</column-name><column-value><![CDATA[");
		sb.append(getCardBoxId_fk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flashcardId_fk</column-name><column-value><![CDATA[");
		sb.append(getFlashcardId_fk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progress</column-name><column-value><![CDATA[");
		sb.append(getProgress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _userId_fk;
	private long _cardBoxId_fk;
	private long _flashcardId_fk;
	private int _progress;
	private BaseModel<?> _learnProgressRemoteModel;
	private Class<?> _clpSerializerClass = de.ki.sbamdc.service.ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}