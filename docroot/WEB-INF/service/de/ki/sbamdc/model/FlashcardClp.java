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
import de.ki.sbamdc.service.FlashcardLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class FlashcardClp extends BaseModelImpl<Flashcard> implements Flashcard {
	public FlashcardClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Flashcard.class;
	}

	@Override
	public String getModelClassName() {
		return Flashcard.class.getName();
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
		attributes.put("content", getContent());
		attributes.put("cardBoxId_fk", getCardBoxId_fk());
		attributes.put("title", getTitle());

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

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long cardBoxId_fk = (Long)attributes.get("cardBoxId_fk");

		if (cardBoxId_fk != null) {
			setCardBoxId_fk(cardBoxId_fk);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
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

		if (_flashcardRemoteModel != null) {
			try {
				Class<?> clazz = _flashcardRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_flashcardRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_flashcardRemoteModel != null) {
			try {
				Class<?> clazz = _flashcardRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_flashcardRemoteModel, content);
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

		if (_flashcardRemoteModel != null) {
			try {
				Class<?> clazz = _flashcardRemoteModel.getClass();

				Method method = clazz.getMethod("setCardBoxId_fk", long.class);

				method.invoke(_flashcardRemoteModel, cardBoxId_fk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_flashcardRemoteModel != null) {
			try {
				Class<?> clazz = _flashcardRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_flashcardRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlashcardRemoteModel() {
		return _flashcardRemoteModel;
	}

	public void setFlashcardRemoteModel(BaseModel<?> flashcardRemoteModel) {
		_flashcardRemoteModel = flashcardRemoteModel;
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

		Class<?> remoteModelClass = _flashcardRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flashcardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			FlashcardLocalServiceUtil.addFlashcard(this);
		}
		else {
			FlashcardLocalServiceUtil.updateFlashcard(this);
		}
	}

	@Override
	public Flashcard toEscapedModel() {
		return (Flashcard)ProxyUtil.newProxyInstance(Flashcard.class.getClassLoader(),
			new Class[] { Flashcard.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlashcardClp clone = new FlashcardClp();

		clone.setId(getId());
		clone.setContent(getContent());
		clone.setCardBoxId_fk(getCardBoxId_fk());
		clone.setTitle(getTitle());

		return clone;
	}

	@Override
	public int compareTo(Flashcard flashcard) {
		int value = 0;

		if (getId() < flashcard.getId()) {
			value = -1;
		}
		else if (getId() > flashcard.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlashcardClp)) {
			return false;
		}

		FlashcardClp flashcard = (FlashcardClp)obj;

		long primaryKey = flashcard.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", cardBoxId_fk=");
		sb.append(getCardBoxId_fk());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("de.ki.sbamdc.model.Flashcard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardBoxId_fk</column-name><column-value><![CDATA[");
		sb.append(getCardBoxId_fk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _content;
	private long _cardBoxId_fk;
	private String _title;
	private BaseModel<?> _flashcardRemoteModel;
	private Class<?> _clpSerializerClass = de.ki.sbamdc.service.ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}