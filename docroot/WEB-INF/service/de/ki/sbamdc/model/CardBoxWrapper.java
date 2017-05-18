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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CardBox}.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see CardBox
 * @generated
 */
@ProviderType
public class CardBoxWrapper implements CardBox, ModelWrapper<CardBox> {
	public CardBoxWrapper(CardBox cardBox) {
		_cardBox = cardBox;
	}

	@Override
	public Class<?> getModelClass() {
		return CardBox.class;
	}

	@Override
	public String getModelClassName() {
		return CardBox.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cardBoxId", getCardBoxId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("author", getAuthor());
		attributes.put("shared", getShared());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cardBoxId = (Long)attributes.get("cardBoxId");

		if (cardBoxId != null) {
			setCardBoxId(cardBoxId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Boolean shared = (Boolean)attributes.get("shared");

		if (shared != null) {
			setShared(shared);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new CardBoxWrapper((CardBox)_cardBox.clone());
	}

	@Override
	public int compareTo(de.ki.sbamdc.model.CardBox cardBox) {
		return _cardBox.compareTo(cardBox);
	}

	/**
	* Returns the author of this card box.
	*
	* @return the author of this card box
	*/
	@Override
	public java.lang.String getAuthor() {
		return _cardBox.getAuthor();
	}

	/**
	* Returns the card box ID of this card box.
	*
	* @return the card box ID of this card box
	*/
	@Override
	public long getCardBoxId() {
		return _cardBox.getCardBoxId();
	}

	/**
	* Returns the company ID of this card box.
	*
	* @return the company ID of this card box
	*/
	@Override
	public long getCompanyId() {
		return _cardBox.getCompanyId();
	}

	/**
	* Returns the create date of this card box.
	*
	* @return the create date of this card box
	*/
	@Override
	public Date getCreateDate() {
		return _cardBox.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cardBox.getExpandoBridge();
	}

	/**
	* Returns the group ID of this card box.
	*
	* @return the group ID of this card box
	*/
	@Override
	public long getGroupId() {
		return _cardBox.getGroupId();
	}

	/**
	* Returns the modified date of this card box.
	*
	* @return the modified date of this card box
	*/
	@Override
	public Date getModifiedDate() {
		return _cardBox.getModifiedDate();
	}

	/**
	* Returns the name of this card box.
	*
	* @return the name of this card box
	*/
	@Override
	public java.lang.String getName() {
		return _cardBox.getName();
	}

	/**
	* Returns the primary key of this card box.
	*
	* @return the primary key of this card box
	*/
	@Override
	public long getPrimaryKey() {
		return _cardBox.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cardBox.getPrimaryKeyObj();
	}

	/**
	* Returns the shared of this card box.
	*
	* @return the shared of this card box
	*/
	@Override
	public boolean getShared() {
		return _cardBox.getShared();
	}

	/**
	* Returns the user ID of this card box.
	*
	* @return the user ID of this card box
	*/
	@Override
	public long getUserId() {
		return _cardBox.getUserId();
	}

	/**
	* Returns the user name of this card box.
	*
	* @return the user name of this card box
	*/
	@Override
	public java.lang.String getUserName() {
		return _cardBox.getUserName();
	}

	/**
	* Returns the user uuid of this card box.
	*
	* @return the user uuid of this card box
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _cardBox.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _cardBox.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _cardBox.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cardBox.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cardBox.isNew();
	}

	/**
	* Returns <code>true</code> if this card box is shared.
	*
	* @return <code>true</code> if this card box is shared; <code>false</code> otherwise
	*/
	@Override
	public boolean isShared() {
		return _cardBox.isShared();
	}

	@Override
	public void persist() {
		_cardBox.persist();
	}

	/**
	* Sets the author of this card box.
	*
	* @param author the author of this card box
	*/
	@Override
	public void setAuthor(java.lang.String author) {
		_cardBox.setAuthor(author);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cardBox.setCachedModel(cachedModel);
	}

	/**
	* Sets the card box ID of this card box.
	*
	* @param cardBoxId the card box ID of this card box
	*/
	@Override
	public void setCardBoxId(long cardBoxId) {
		_cardBox.setCardBoxId(cardBoxId);
	}

	/**
	* Sets the company ID of this card box.
	*
	* @param companyId the company ID of this card box
	*/
	@Override
	public void setCompanyId(long companyId) {
		_cardBox.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this card box.
	*
	* @param createDate the create date of this card box
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_cardBox.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_cardBox.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cardBox.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cardBox.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this card box.
	*
	* @param groupId the group ID of this card box
	*/
	@Override
	public void setGroupId(long groupId) {
		_cardBox.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this card box.
	*
	* @param modifiedDate the modified date of this card box
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_cardBox.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this card box.
	*
	* @param name the name of this card box
	*/
	@Override
	public void setName(java.lang.String name) {
		_cardBox.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_cardBox.setNew(n);
	}

	/**
	* Sets the primary key of this card box.
	*
	* @param primaryKey the primary key of this card box
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cardBox.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cardBox.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this card box is shared.
	*
	* @param shared the shared of this card box
	*/
	@Override
	public void setShared(boolean shared) {
		_cardBox.setShared(shared);
	}

	/**
	* Sets the user ID of this card box.
	*
	* @param userId the user ID of this card box
	*/
	@Override
	public void setUserId(long userId) {
		_cardBox.setUserId(userId);
	}

	/**
	* Sets the user name of this card box.
	*
	* @param userName the user name of this card box
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_cardBox.setUserName(userName);
	}

	/**
	* Sets the user uuid of this card box.
	*
	* @param userUuid the user uuid of this card box
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_cardBox.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<de.ki.sbamdc.model.CardBox> toCacheModel() {
		return _cardBox.toCacheModel();
	}

	@Override
	public de.ki.sbamdc.model.CardBox toEscapedModel() {
		return new CardBoxWrapper(_cardBox.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cardBox.toString();
	}

	@Override
	public de.ki.sbamdc.model.CardBox toUnescapedModel() {
		return new CardBoxWrapper(_cardBox.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _cardBox.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CardBoxWrapper)) {
			return false;
		}

		CardBoxWrapper cardBoxWrapper = (CardBoxWrapper)obj;

		if (Validator.equals(_cardBox, cardBoxWrapper._cardBox)) {
			return true;
		}

		return false;
	}

	@Override
	public CardBox getWrappedModel() {
		return _cardBox;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cardBox.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cardBox.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cardBox.resetOriginalValues();
	}

	private final CardBox _cardBox;
}