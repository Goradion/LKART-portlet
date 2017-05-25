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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import de.ki.sbamdc.model.Flashcard;
import de.ki.sbamdc.model.FlashcardModel;
import de.ki.sbamdc.model.FlashcardSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Flashcard service. Represents a row in the &quot;sbamdc_Flashcard&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link FlashcardModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FlashcardImpl}.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see FlashcardImpl
 * @see Flashcard
 * @see FlashcardModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class FlashcardModelImpl extends BaseModelImpl<Flashcard>
	implements FlashcardModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a flashcard model instance should use the {@link Flashcard} interface instead.
	 */
	public static final String TABLE_NAME = "sbamdc_Flashcard";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id_", Types.BIGINT },
			{ "content", Types.VARCHAR },
			{ "cardBoxId_fk", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cardBoxId_fk", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table sbamdc_Flashcard (id_ LONG not null primary key,content VARCHAR(75) null,cardBoxId_fk LONG)";
	public static final String TABLE_SQL_DROP = "drop table sbamdc_Flashcard";
	public static final String ORDER_BY_JPQL = " ORDER BY flashcard.id DESC";
	public static final String ORDER_BY_SQL = " ORDER BY sbamdc_Flashcard.id_ DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.de.ki.sbamdc.model.Flashcard"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.de.ki.sbamdc.model.Flashcard"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.de.ki.sbamdc.model.Flashcard"),
			true);
	public static final long CARDBOXID_FK_COLUMN_BITMASK = 1L;
	public static final long ID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Flashcard toModel(FlashcardSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Flashcard model = new FlashcardImpl();

		model.setId(soapModel.getId());
		model.setContent(soapModel.getContent());
		model.setCardBoxId_fk(soapModel.getCardBoxId_fk());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Flashcard> toModels(FlashcardSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Flashcard> models = new ArrayList<Flashcard>(soapModels.length);

		for (FlashcardSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.de.ki.sbamdc.model.Flashcard"));

	public FlashcardModelImpl() {
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
	public Class<?> getModelClass() {
		return Flashcard.class;
	}

	@Override
	public String getModelClassName() {
		return Flashcard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("content", getContent());
		attributes.put("cardBoxId_fk", getCardBoxId_fk());

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
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_columnBitmask = -1L;

		_id = id;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@JSON
	@Override
	public long getCardBoxId_fk() {
		return _cardBoxId_fk;
	}

	@Override
	public void setCardBoxId_fk(long cardBoxId_fk) {
		_columnBitmask |= CARDBOXID_FK_COLUMN_BITMASK;

		if (!_setOriginalCardBoxId_fk) {
			_setOriginalCardBoxId_fk = true;

			_originalCardBoxId_fk = _cardBoxId_fk;
		}

		_cardBoxId_fk = cardBoxId_fk;
	}

	public long getOriginalCardBoxId_fk() {
		return _originalCardBoxId_fk;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Flashcard.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Flashcard toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Flashcard)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FlashcardImpl flashcardImpl = new FlashcardImpl();

		flashcardImpl.setId(getId());
		flashcardImpl.setContent(getContent());
		flashcardImpl.setCardBoxId_fk(getCardBoxId_fk());

		flashcardImpl.resetOriginalValues();

		return flashcardImpl;
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

		if (!(obj instanceof Flashcard)) {
			return false;
		}

		Flashcard flashcard = (Flashcard)obj;

		long primaryKey = flashcard.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		FlashcardModelImpl flashcardModelImpl = this;

		flashcardModelImpl._originalCardBoxId_fk = flashcardModelImpl._cardBoxId_fk;

		flashcardModelImpl._setOriginalCardBoxId_fk = false;

		flashcardModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Flashcard> toCacheModel() {
		FlashcardCacheModel flashcardCacheModel = new FlashcardCacheModel();

		flashcardCacheModel.id = getId();

		flashcardCacheModel.content = getContent();

		String content = flashcardCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			flashcardCacheModel.content = null;
		}

		flashcardCacheModel.cardBoxId_fk = getCardBoxId_fk();

		return flashcardCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", cardBoxId_fk=");
		sb.append(getCardBoxId_fk());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

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

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Flashcard.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Flashcard.class
		};
	private long _id;
	private String _content;
	private long _cardBoxId_fk;
	private long _originalCardBoxId_fk;
	private boolean _setOriginalCardBoxId_fk;
	private long _columnBitmask;
	private Flashcard _escapedModel;
}