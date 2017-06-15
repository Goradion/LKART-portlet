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
 * Provides the local service utility for LearnProgress. This utility wraps
 * {@link de.ki.sbamdc.service.impl.LearnProgressLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see LearnProgressLocalService
 * @see de.ki.sbamdc.service.base.LearnProgressLocalServiceBaseImpl
 * @see de.ki.sbamdc.service.impl.LearnProgressLocalServiceImpl
 * @generated
 */
@ProviderType
public class LearnProgressLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.ki.sbamdc.service.impl.LearnProgressLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the learn progress to the database. Also notifies the appropriate model listeners.
	*
	* @param learnProgress the learn progress
	* @return the learn progress that was added
	*/
	public static de.ki.sbamdc.model.LearnProgress addLearnProgress(
		de.ki.sbamdc.model.LearnProgress learnProgress) {
		return getService().addLearnProgress(learnProgress);
	}

	public static de.ki.sbamdc.model.LearnProgress addLearnProgress(
		long userId, de.ki.sbamdc.model.Flashcard flashcard) {
		return getService().addLearnProgress(userId, flashcard);
	}

	/**
	* Creates a new learn progress with the primary key. Does not add the learn progress to the database.
	*
	* @param id the primary key for the new learn progress
	* @return the new learn progress
	*/
	public static de.ki.sbamdc.model.LearnProgress createLearnProgress(long id) {
		return getService().createLearnProgress(id);
	}

	/**
	* Deletes the learn progress from the database. Also notifies the appropriate model listeners.
	*
	* @param learnProgress the learn progress
	* @return the learn progress that was removed
	*/
	public static de.ki.sbamdc.model.LearnProgress deleteLearnProgress(
		de.ki.sbamdc.model.LearnProgress learnProgress) {
		return getService().deleteLearnProgress(learnProgress);
	}

	/**
	* Deletes the learn progress with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress that was removed
	* @throws PortalException if a learn progress with the primary key could not be found
	*/
	public static de.ki.sbamdc.model.LearnProgress deleteLearnProgress(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLearnProgress(id);
	}

	public static de.ki.sbamdc.model.LearnProgress fetchByUserIdAndFlashcardId(
		long userId, long flashcardId) {
		return getService().fetchByUserIdAndFlashcardId(userId, flashcardId);
	}

	public static de.ki.sbamdc.model.LearnProgress fetchLearnProgress(long id) {
		return getService().fetchLearnProgress(id);
	}

	/**
	* Returns the learn progress with the primary key.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress
	* @throws PortalException if a learn progress with the primary key could not be found
	*/
	public static de.ki.sbamdc.model.LearnProgress getLearnProgress(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLearnProgress(id);
	}

	/**
	* Updates the learn progress in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param learnProgress the learn progress
	* @return the learn progress that was updated
	*/
	public static de.ki.sbamdc.model.LearnProgress updateLearnProgress(
		de.ki.sbamdc.model.LearnProgress learnProgress) {
		return getService().updateLearnProgress(learnProgress);
	}

	/**
	* Returns the number of learn progresses.
	*
	* @return the number of learn progresses
	*/
	public static int getLearnProgressesCount() {
		return getService().getLearnProgressesCount();
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.HashMap<java.lang.Long, de.ki.sbamdc.model.LearnProgress> loadProgressByUserIdAndCardBoxId(
		long userId, long cardBoxId) {
		return getService().loadProgressByUserIdAndCardBoxId(userId, cardBoxId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbamdc.model.impl.LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbamdc.model.impl.LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<de.ki.sbamdc.model.LearnProgress> findByUserId(
		long userId_fk) {
		return getService().findByUserId(userId_fk);
	}

	/**
	* Returns a range of all the learn progresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.ki.sbamdc.model.impl.LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @return the range of learn progresses
	*/
	public static java.util.List<de.ki.sbamdc.model.LearnProgress> getLearnProgresses(
		int start, int end) {
		return getService().getLearnProgresses(start, end);
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

	public static void clearService() {
		_service = null;
	}

	public static LearnProgressLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LearnProgressLocalService.class.getName());

			if (invokableLocalService instanceof LearnProgressLocalService) {
				_service = (LearnProgressLocalService)invokableLocalService;
			}
			else {
				_service = new LearnProgressLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LearnProgressLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static LearnProgressLocalService _service;
}