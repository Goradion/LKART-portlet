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

package de.ki.sbamdc.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CardBoxLocalService}.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see CardBoxLocalService
 * @generated
 */
@ProviderType
public class CardBoxLocalServiceWrapper implements CardBoxLocalService,
	ServiceWrapper<CardBoxLocalService> {
	public CardBoxLocalServiceWrapper(CardBoxLocalService cardBoxLocalService) {
		_cardBoxLocalService = cardBoxLocalService;
	}

	/**
	* Adds the card box to the database. Also notifies the appropriate model listeners.
	*
	* @param cardBox the card box
	* @return the card box that was added
	*/
	@Override
	public de.ki.sbamdc.model.CardBox addCardBox(
		de.ki.sbamdc.model.CardBox cardBox) {
		return _cardBoxLocalService.addCardBox(cardBox);
	}

	@Override
	public de.ki.sbamdc.model.CardBox addCardBox(java.lang.String name,
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return _cardBoxLocalService.addCardBox(name, userId);
	}

	/**
	* Creates a new card box with the primary key. Does not add the card box to the database.
	*
	* @param id the primary key for the new card box
	* @return the new card box
	*/
	@Override
	public de.ki.sbamdc.model.CardBox createCardBox(long id) {
		return _cardBoxLocalService.createCardBox(id);
	}

	/**
	* Deletes the card box from the database. Also notifies the appropriate model listeners.
	*
	* @param cardBox the card box
	* @return the card box that was removed
	*/
	@Override
	public de.ki.sbamdc.model.CardBox deleteCardBox(
		de.ki.sbamdc.model.CardBox cardBox) {
		return _cardBoxLocalService.deleteCardBox(cardBox);
	}

	/**
	* Deletes the card box with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the card box
	* @return the card box that was removed
	* @throws PortalException if a card box with the primary key could not be found
	*/
	@Override
	public de.ki.sbamdc.model.CardBox deleteCardBox(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cardBoxLocalService.deleteCardBox(id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cardBoxLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cardBoxLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _cardBoxLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbamdc.model.impl.CardBoxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _cardBoxLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbamdc.model.impl.CardBoxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _cardBoxLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _cardBoxLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _cardBoxLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.ki.sbamdc.model.CardBox fetchCardBox(long id) {
		return _cardBoxLocalService.fetchCardBox(id);
	}

	@Override
	public de.ki.sbamdc.model.CardBox findByNameAndUserId(
		java.lang.String name, long userId) {
		return _cardBoxLocalService.findByNameAndUserId(name, userId);
	}

	@Override
	public de.ki.sbamdc.model.CardBox findByNameAndUserName(
		java.lang.String name, java.lang.String userName) {
		return _cardBoxLocalService.findByNameAndUserName(name, userName);
	}

	@Override
	public java.util.List<de.ki.sbamdc.model.CardBox> findByUserId(long userId) {
		return _cardBoxLocalService.findByUserId(userId);
	}

	@Override
	public java.util.SortedMap<java.lang.String, java.util.List<de.ki.sbamdc.model.CardBox>> findLearnableCardBoxes(
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return _cardBoxLocalService.findLearnableCardBoxes(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _cardBoxLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the card box with the primary key.
	*
	* @param id the primary key of the card box
	* @return the card box
	* @throws PortalException if a card box with the primary key could not be found
	*/
	@Override
	public de.ki.sbamdc.model.CardBox getCardBox(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cardBoxLocalService.getCardBox(id);
	}

	@Override
	public int getCardBoxesCountOfUser(long userId) {
		return _cardBoxLocalService.getCardBoxesCountOfUser(userId);
	}

	@Override
	public java.util.List<de.ki.sbamdc.model.CardBox> getCardBoxesOfUser(
		long userId, int start, int end) {
		return _cardBoxLocalService.getCardBoxesOfUser(userId, start, end);
	}

	/**
	* Returns a range of all the card boxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbamdc.model.impl.CardBoxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of card boxs
	* @param end the upper bound of the range of card boxs (not inclusive)
	* @return the range of card boxs
	*/
	@Override
	public java.util.List<de.ki.sbamdc.model.CardBox> getCardBoxs(int start,
		int end) {
		return _cardBoxLocalService.getCardBoxs(start, end);
	}

	/**
	* Returns the number of card boxs.
	*
	* @return the number of card boxs
	*/
	@Override
	public int getCardBoxsCount() {
		return _cardBoxLocalService.getCardBoxsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _cardBoxLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _cardBoxLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cardBoxLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cardBoxLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void removeAll() {
		_cardBoxLocalService.removeAll();
	}

	@Override
	public void removeByUserId(long userId) {
		_cardBoxLocalService.removeByUserId(userId);
	}

	@Override
	public void setShared(long id) {
		_cardBoxLocalService.setShared(id);
	}

	/**
	* Updates the card box in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cardBox the card box
	* @return the card box that was updated
	*/
	@Override
	public de.ki.sbamdc.model.CardBox updateCardBox(
		de.ki.sbamdc.model.CardBox cardBox) {
		return _cardBoxLocalService.updateCardBox(cardBox);
	}

	@Override
	public CardBoxLocalService getWrappedService() {
		return _cardBoxLocalService;
	}

	@Override
	public void setWrappedService(CardBoxLocalService cardBoxLocalService) {
		_cardBoxLocalService = cardBoxLocalService;
	}

	private CardBoxLocalService _cardBoxLocalService;
}