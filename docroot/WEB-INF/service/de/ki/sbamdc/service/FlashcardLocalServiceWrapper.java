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
 * Provides a wrapper for {@link FlashcardLocalService}.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see FlashcardLocalService
 * @generated
 */
@ProviderType
public class FlashcardLocalServiceWrapper implements FlashcardLocalService,
	ServiceWrapper<FlashcardLocalService> {
	public FlashcardLocalServiceWrapper(
		FlashcardLocalService flashcardLocalService) {
		_flashcardLocalService = flashcardLocalService;
	}

	@Override
	public de.ki.sbamdc.model.Flashcard addFlashcard(java.lang.String content,
		long cardBoxId) {
		return _flashcardLocalService.addFlashcard(content, cardBoxId);
	}

	/**
	* Adds the flashcard to the database. Also notifies the appropriate model listeners.
	*
	* @param flashcard the flashcard
	* @return the flashcard that was added
	*/
	@Override
	public de.ki.sbamdc.model.Flashcard addFlashcard(
		de.ki.sbamdc.model.Flashcard flashcard) {
		return _flashcardLocalService.addFlashcard(flashcard);
	}

	/**
	* Creates a new flashcard with the primary key. Does not add the flashcard to the database.
	*
	* @param id the primary key for the new flashcard
	* @return the new flashcard
	*/
	@Override
	public de.ki.sbamdc.model.Flashcard createFlashcard(long id) {
		return _flashcardLocalService.createFlashcard(id);
	}

	/**
	* Deletes the flashcard from the database. Also notifies the appropriate model listeners.
	*
	* @param flashcard the flashcard
	* @return the flashcard that was removed
	*/
	@Override
	public de.ki.sbamdc.model.Flashcard deleteFlashcard(
		de.ki.sbamdc.model.Flashcard flashcard) {
		return _flashcardLocalService.deleteFlashcard(flashcard);
	}

	/**
	* Deletes the flashcard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard that was removed
	* @throws PortalException if a flashcard with the primary key could not be found
	*/
	@Override
	public de.ki.sbamdc.model.Flashcard deleteFlashcard(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _flashcardLocalService.deleteFlashcard(id);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _flashcardLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _flashcardLocalService.dynamicQuery();
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
		return _flashcardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbamdc.model.impl.FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _flashcardLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbamdc.model.impl.FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _flashcardLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _flashcardLocalService.dynamicQueryCount(dynamicQuery);
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
		return _flashcardLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public de.ki.sbamdc.model.Flashcard fetchFlashcard(long id) {
		return _flashcardLocalService.fetchFlashcard(id);
	}

	@Override
	public java.util.List<de.ki.sbamdc.model.Flashcard> findByCardBoxId(
		long cardBoxId) {
		return _flashcardLocalService.findByCardBoxId(cardBoxId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _flashcardLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the flashcard with the primary key.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard
	* @throws PortalException if a flashcard with the primary key could not be found
	*/
	@Override
	public de.ki.sbamdc.model.Flashcard getFlashcard(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _flashcardLocalService.getFlashcard(id);
	}

	/**
	* Returns a range of all the flashcards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbamdc.model.impl.FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flashcards
	* @param end the upper bound of the range of flashcards (not inclusive)
	* @return the range of flashcards
	*/
	@Override
	public java.util.List<de.ki.sbamdc.model.Flashcard> getFlashcards(
		int start, int end) {
		return _flashcardLocalService.getFlashcards(start, end);
	}

	/**
	* Returns the number of flashcards.
	*
	* @return the number of flashcards
	*/
	@Override
	public int getFlashcardsCount() {
		return _flashcardLocalService.getFlashcardsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _flashcardLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _flashcardLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _flashcardLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flashcardLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Updates the flashcard in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param flashcard the flashcard
	* @return the flashcard that was updated
	*/
	@Override
	public de.ki.sbamdc.model.Flashcard updateFlashcard(
		de.ki.sbamdc.model.Flashcard flashcard) {
		return _flashcardLocalService.updateFlashcard(flashcard);
	}

	@Override
	public FlashcardLocalService getWrappedService() {
		return _flashcardLocalService;
	}

	@Override
	public void setWrappedService(FlashcardLocalService flashcardLocalService) {
		_flashcardLocalService = flashcardLocalService;
	}

	private FlashcardLocalService _flashcardLocalService;
}