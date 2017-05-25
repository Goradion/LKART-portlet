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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableLocalService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the local service utility for Flashcard. This utility wraps
 * {@link de.ki.sbamdc.service.impl.FlashcardLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see FlashcardLocalService
 * @see de.ki.sbamdc.service.base.FlashcardLocalServiceBaseImpl
 * @see de.ki.sbamdc.service.impl.FlashcardLocalServiceImpl
 * @generated
 */
@ProviderType
public class FlashcardLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.ki.sbamdc.service.impl.FlashcardLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static de.ki.sbamdc.model.Flashcard addFlashcard(
		java.lang.String content, long cardBoxId) {
		return getService().addFlashcard(content, cardBoxId);
	}

	/**
	* Adds the flashcard to the database. Also notifies the appropriate model listeners.
	*
	* @param flashcard the flashcard
	* @return the flashcard that was added
	*/
	public static de.ki.sbamdc.model.Flashcard addFlashcard(
		de.ki.sbamdc.model.Flashcard flashcard) {
		return getService().addFlashcard(flashcard);
	}

	/**
	* Creates a new flashcard with the primary key. Does not add the flashcard to the database.
	*
	* @param id the primary key for the new flashcard
	* @return the new flashcard
	*/
	public static de.ki.sbamdc.model.Flashcard createFlashcard(long id) {
		return getService().createFlashcard(id);
	}

	/**
	* Deletes the flashcard from the database. Also notifies the appropriate model listeners.
	*
	* @param flashcard the flashcard
	* @return the flashcard that was removed
	*/
	public static de.ki.sbamdc.model.Flashcard deleteFlashcard(
		de.ki.sbamdc.model.Flashcard flashcard) {
		return getService().deleteFlashcard(flashcard);
	}

	/**
	* Deletes the flashcard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard that was removed
	* @throws PortalException if a flashcard with the primary key could not be found
	*/
	public static de.ki.sbamdc.model.Flashcard deleteFlashcard(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteFlashcard(id);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static de.ki.sbamdc.model.Flashcard fetchFlashcard(long id) {
		return getService().fetchFlashcard(id);
	}

	public static java.util.List<de.ki.sbamdc.model.Flashcard> findByCardBoxId(
		long cardBoxId) {
		return getService().findByCardBoxId(cardBoxId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the flashcard with the primary key.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard
	* @throws PortalException if a flashcard with the primary key could not be found
	*/
	public static de.ki.sbamdc.model.Flashcard getFlashcard(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFlashcard(id);
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
	public static java.util.List<de.ki.sbamdc.model.Flashcard> getFlashcards(
		int start, int end) {
		return getService().getFlashcards(start, end);
	}

	/**
	* Returns the number of flashcards.
	*
	* @return the number of flashcards
	*/
	public static int getFlashcardsCount() {
		return getService().getFlashcardsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Updates the flashcard in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param flashcard the flashcard
	* @return the flashcard that was updated
	*/
	public static de.ki.sbamdc.model.Flashcard updateFlashcard(
		de.ki.sbamdc.model.Flashcard flashcard) {
		return getService().updateFlashcard(flashcard);
	}

	public static void clearService() {
		_service = null;
	}

	public static FlashcardLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FlashcardLocalService.class.getName());

			if (invokableLocalService instanceof FlashcardLocalService) {
				_service = (FlashcardLocalService)invokableLocalService;
			}
			else {
				_service = new FlashcardLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FlashcardLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static FlashcardLocalService _service;
}