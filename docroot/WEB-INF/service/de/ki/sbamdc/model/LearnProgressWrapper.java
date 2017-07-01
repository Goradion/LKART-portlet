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
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LearnProgress}.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see LearnProgress
 * @generated
 */
@ProviderType
public class LearnProgressWrapper implements LearnProgress,
	ModelWrapper<LearnProgress> {
	public LearnProgressWrapper(LearnProgress learnProgress) {
		_learnProgress = learnProgress;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("userId_fk", getUserId_fk());
		attributes.put("cardBoxId_fk", getCardBoxId_fk());
		attributes.put("flashcardId_fk", getFlashcardId_fk());
		attributes.put("progress", getProgress());

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
	}

	@Override
	public java.lang.Object clone() {
		return new LearnProgressWrapper((LearnProgress)_learnProgress.clone());
	}

	@Override
	public int compareTo(de.ki.sbamdc.model.LearnProgress learnProgress) {
		return _learnProgress.compareTo(learnProgress);
	}

	/**
	* Returns the card box id_fk of this learn progress.
	*
	* @return the card box id_fk of this learn progress
	*/
	@Override
	public long getCardBoxId_fk() {
		return _learnProgress.getCardBoxId_fk();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _learnProgress.getExpandoBridge();
	}

	/**
	* Returns the flashcard id_fk of this learn progress.
	*
	* @return the flashcard id_fk of this learn progress
	*/
	@Override
	public long getFlashcardId_fk() {
		return _learnProgress.getFlashcardId_fk();
	}

	/**
	* Returns the ID of this learn progress.
	*
	* @return the ID of this learn progress
	*/
	@Override
	public long getId() {
		return _learnProgress.getId();
	}

	/**
	* Returns the primary key of this learn progress.
	*
	* @return the primary key of this learn progress
	*/
	@Override
	public long getPrimaryKey() {
		return _learnProgress.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _learnProgress.getPrimaryKeyObj();
	}

	/**
	* Returns the progress of this learn progress.
	*
	* @return the progress of this learn progress
	*/
	@Override
	public int getProgress() {
		return _learnProgress.getProgress();
	}

	/**
	* Returns the user id_fk of this learn progress.
	*
	* @return the user id_fk of this learn progress
	*/
	@Override
	public long getUserId_fk() {
		return _learnProgress.getUserId_fk();
	}

	@Override
	public int hashCode() {
		return _learnProgress.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _learnProgress.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _learnProgress.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _learnProgress.isNew();
	}

	@Override
	public void persist() {
		_learnProgress.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_learnProgress.setCachedModel(cachedModel);
	}

	/**
	* Sets the card box id_fk of this learn progress.
	*
	* @param cardBoxId_fk the card box id_fk of this learn progress
	*/
	@Override
	public void setCardBoxId_fk(long cardBoxId_fk) {
		_learnProgress.setCardBoxId_fk(cardBoxId_fk);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_learnProgress.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_learnProgress.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_learnProgress.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the flashcard id_fk of this learn progress.
	*
	* @param flashcardId_fk the flashcard id_fk of this learn progress
	*/
	@Override
	public void setFlashcardId_fk(long flashcardId_fk) {
		_learnProgress.setFlashcardId_fk(flashcardId_fk);
	}

	/**
	* Sets the ID of this learn progress.
	*
	* @param id the ID of this learn progress
	*/
	@Override
	public void setId(long id) {
		_learnProgress.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_learnProgress.setNew(n);
	}

	/**
	* Sets the primary key of this learn progress.
	*
	* @param primaryKey the primary key of this learn progress
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_learnProgress.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_learnProgress.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the progress of this learn progress.
	*
	* @param progress the progress of this learn progress
	*/
	@Override
	public void setProgress(int progress) {
		_learnProgress.setProgress(progress);
	}

	/**
	* Sets the user id_fk of this learn progress.
	*
	* @param userId_fk the user id_fk of this learn progress
	*/
	@Override
	public void setUserId_fk(long userId_fk) {
		_learnProgress.setUserId_fk(userId_fk);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbamdc.model.LearnProgress> toCacheModel() {
		return _learnProgress.toCacheModel();
	}

	@Override
	public de.ki.sbamdc.model.LearnProgress toEscapedModel() {
		return new LearnProgressWrapper(_learnProgress.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _learnProgress.toString();
	}

	@Override
	public de.ki.sbamdc.model.LearnProgress toUnescapedModel() {
		return new LearnProgressWrapper(_learnProgress.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _learnProgress.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LearnProgressWrapper)) {
			return false;
		}

		LearnProgressWrapper learnProgressWrapper = (LearnProgressWrapper)obj;

		if (Validator.equals(_learnProgress, learnProgressWrapper._learnProgress)) {
			return true;
		}

		return false;
	}

	@Override
	public LearnProgress getWrappedModel() {
		return _learnProgress;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _learnProgress.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _learnProgress.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_learnProgress.resetOriginalValues();
	}

	private final LearnProgress _learnProgress;
}