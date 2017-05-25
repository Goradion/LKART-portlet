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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Flashcard}.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see Flashcard
 * @generated
 */
@ProviderType
public class FlashcardWrapper implements Flashcard, ModelWrapper<Flashcard> {
	public FlashcardWrapper(Flashcard flashcard) {
		_flashcard = flashcard;
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

	@Override
	public boolean isCachedModel() {
		return _flashcard.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _flashcard.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _flashcard.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _flashcard.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbamdc.model.Flashcard> toCacheModel() {
		return _flashcard.toCacheModel();
	}

	@Override
	public de.ki.sbamdc.model.Flashcard toEscapedModel() {
		return new FlashcardWrapper(_flashcard.toEscapedModel());
	}

	@Override
	public de.ki.sbamdc.model.Flashcard toUnescapedModel() {
		return new FlashcardWrapper(_flashcard.toUnescapedModel());
	}

	@Override
	public int compareTo(de.ki.sbamdc.model.Flashcard flashcard) {
		return _flashcard.compareTo(flashcard);
	}

	@Override
	public int hashCode() {
		return _flashcard.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _flashcard.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new FlashcardWrapper((Flashcard)_flashcard.clone());
	}

	/**
	* Returns the content of this flashcard.
	*
	* @return the content of this flashcard
	*/
	@Override
	public java.lang.String getContent() {
		return _flashcard.getContent();
	}

	@Override
	public java.lang.String toString() {
		return _flashcard.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flashcard.toXmlString();
	}

	/**
	* Returns the card box id_fk of this flashcard.
	*
	* @return the card box id_fk of this flashcard
	*/
	@Override
	public long getCardBoxId_fk() {
		return _flashcard.getCardBoxId_fk();
	}

	/**
	* Returns the ID of this flashcard.
	*
	* @return the ID of this flashcard
	*/
	@Override
	public long getId() {
		return _flashcard.getId();
	}

	/**
	* Returns the primary key of this flashcard.
	*
	* @return the primary key of this flashcard
	*/
	@Override
	public long getPrimaryKey() {
		return _flashcard.getPrimaryKey();
	}

	@Override
	public void persist() {
		_flashcard.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flashcard.setCachedModel(cachedModel);
	}

	/**
	* Sets the card box id_fk of this flashcard.
	*
	* @param cardBoxId_fk the card box id_fk of this flashcard
	*/
	@Override
	public void setCardBoxId_fk(long cardBoxId_fk) {
		_flashcard.setCardBoxId_fk(cardBoxId_fk);
	}

	/**
	* Sets the content of this flashcard.
	*
	* @param content the content of this flashcard
	*/
	@Override
	public void setContent(java.lang.String content) {
		_flashcard.setContent(content);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_flashcard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_flashcard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_flashcard.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this flashcard.
	*
	* @param id the ID of this flashcard
	*/
	@Override
	public void setId(long id) {
		_flashcard.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_flashcard.setNew(n);
	}

	/**
	* Sets the primary key of this flashcard.
	*
	* @param primaryKey the primary key of this flashcard
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flashcard.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_flashcard.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlashcardWrapper)) {
			return false;
		}

		FlashcardWrapper flashcardWrapper = (FlashcardWrapper)obj;

		if (Objects.equals(_flashcard, flashcardWrapper._flashcard)) {
			return true;
		}

		return false;
	}

	@Override
	public Flashcard getWrappedModel() {
		return _flashcard;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _flashcard.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _flashcard.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_flashcard.resetOriginalValues();
	}

	private final Flashcard _flashcard;
}