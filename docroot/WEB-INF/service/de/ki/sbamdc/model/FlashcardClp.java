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
		attributes.put("question_txt", getQuestion_txt());
		attributes.put("question_pct", getQuestion_pct());
		attributes.put("answer_txt", getAnswer_txt());
		attributes.put("answer_pct", getAnswer_pct());
		attributes.put("cardBoxId", getCardBoxId());

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

		String question_txt = (String)attributes.get("question_txt");

		if (question_txt != null) {
			setQuestion_txt(question_txt);
		}

		String question_pct = (String)attributes.get("question_pct");

		if (question_pct != null) {
			setQuestion_pct(question_pct);
		}

		String answer_txt = (String)attributes.get("answer_txt");

		if (answer_txt != null) {
			setAnswer_txt(answer_txt);
		}

		String answer_pct = (String)attributes.get("answer_pct");

		if (answer_pct != null) {
			setAnswer_pct(answer_pct);
		}

		Long cardBoxId = (Long)attributes.get("cardBoxId");

		if (cardBoxId != null) {
			setCardBoxId(cardBoxId);
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
	public String getQuestion_txt() {
		return _question_txt;
	}

	@Override
	public void setQuestion_txt(String question_txt) {
		_question_txt = question_txt;

		if (_flashcardRemoteModel != null) {
			try {
				Class<?> clazz = _flashcardRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion_txt", String.class);

				method.invoke(_flashcardRemoteModel, question_txt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuestion_pct() {
		return _question_pct;
	}

	@Override
	public void setQuestion_pct(String question_pct) {
		_question_pct = question_pct;

		if (_flashcardRemoteModel != null) {
			try {
				Class<?> clazz = _flashcardRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion_pct", String.class);

				method.invoke(_flashcardRemoteModel, question_pct);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer_txt() {
		return _answer_txt;
	}

	@Override
	public void setAnswer_txt(String answer_txt) {
		_answer_txt = answer_txt;

		if (_flashcardRemoteModel != null) {
			try {
				Class<?> clazz = _flashcardRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer_txt", String.class);

				method.invoke(_flashcardRemoteModel, answer_txt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAnswer_pct() {
		return _answer_pct;
	}

	@Override
	public void setAnswer_pct(String answer_pct) {
		_answer_pct = answer_pct;

		if (_flashcardRemoteModel != null) {
			try {
				Class<?> clazz = _flashcardRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswer_pct", String.class);

				method.invoke(_flashcardRemoteModel, answer_pct);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCardBoxId() {
		return _cardBoxId;
	}

	@Override
	public void setCardBoxId(long cardBoxId) {
		_cardBoxId = cardBoxId;

		if (_flashcardRemoteModel != null) {
			try {
				Class<?> clazz = _flashcardRemoteModel.getClass();

				Method method = clazz.getMethod("setCardBoxId", long.class);

				method.invoke(_flashcardRemoteModel, cardBoxId);
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
		clone.setQuestion_txt(getQuestion_txt());
		clone.setQuestion_pct(getQuestion_pct());
		clone.setAnswer_txt(getAnswer_txt());
		clone.setAnswer_pct(getAnswer_pct());
		clone.setCardBoxId(getCardBoxId());

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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", question_txt=");
		sb.append(getQuestion_txt());
		sb.append(", question_pct=");
		sb.append(getQuestion_pct());
		sb.append(", answer_txt=");
		sb.append(getAnswer_txt());
		sb.append(", answer_pct=");
		sb.append(getAnswer_pct());
		sb.append(", cardBoxId=");
		sb.append(getCardBoxId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("de.ki.sbamdc.model.Flashcard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question_txt</column-name><column-value><![CDATA[");
		sb.append(getQuestion_txt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question_pct</column-name><column-value><![CDATA[");
		sb.append(getQuestion_pct());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer_txt</column-name><column-value><![CDATA[");
		sb.append(getAnswer_txt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer_pct</column-name><column-value><![CDATA[");
		sb.append(getAnswer_pct());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardBoxId</column-name><column-value><![CDATA[");
		sb.append(getCardBoxId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _question_txt;
	private String _question_pct;
	private String _answer_txt;
	private String _answer_pct;
	private long _cardBoxId;
	private BaseModel<?> _flashcardRemoteModel;
	private Class<?> _clpSerializerClass = de.ki.sbamdc.service.ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}