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
 * Provides a wrapper for {@link LearnProgressLocalService}.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see LearnProgressLocalService
 * @generated
 */
@ProviderType
public class LearnProgressLocalServiceWrapper
	implements LearnProgressLocalService,
		ServiceWrapper<LearnProgressLocalService> {
	public LearnProgressLocalServiceWrapper(
		LearnProgressLocalService learnProgressLocalService) {
		_learnProgressLocalService = learnProgressLocalService;
	}

	/**
	* Adds the learn progress to the database. Also notifies the appropriate model listeners.
	*
	* @param learnProgress the learn progress
	* @return the learn progress that was added
	*/
	@Override
	public de.ki.sbamdc.model.LearnProgress addLearnProgress(
		de.ki.sbamdc.model.LearnProgress learnProgress) {
		return _learnProgressLocalService.addLearnProgress(learnProgress);
	}

	@Override
	public de.ki.sbamdc.model.LearnProgress addLearnProgress(long userId,
		de.ki.sbamdc.model.Flashcard flashcard) {
		return _learnProgressLocalService.addLearnProgress(userId, flashcard);
	}

	/**
	* Creates a new learn progress with the primary key. Does not add the learn progress to the database.
	*
	* @param id the primary key for the new learn progress
	* @return the new learn progress
	*/
	@Override
	public de.ki.sbamdc.model.LearnProgress createLearnProgress(long id) {
		return _learnProgressLocalService.createLearnProgress(id);
	}

	/**
	* Deletes the learn progress with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress that was removed
	* @throws PortalException if a learn progress with the primary key could not be found
	*/
	@Override
	public de.ki.sbamdc.model.LearnProgress deleteLearnProgress(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _learnProgressLocalService.deleteLearnProgress(id);
	}

	/**
	* Deletes the learn progress from the database. Also notifies the appropriate model listeners.
	*
	* @param learnProgress the learn progress
	* @return the learn progress that was removed
	*/
	@Override
	public de.ki.sbamdc.model.LearnProgress deleteLearnProgress(
		de.ki.sbamdc.model.LearnProgress learnProgress) {
		return _learnProgressLocalService.deleteLearnProgress(learnProgress);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _learnProgressLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _learnProgressLocalService.dynamicQuery();
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
		return _learnProgressLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _learnProgressLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _learnProgressLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _learnProgressLocalService.dynamicQueryCount(dynamicQuery);
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
		return _learnProgressLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.ki.sbamdc.model.LearnProgress fetchByUserIdAndFlashcardId(
		long userId, long flashcardId) {
		return _learnProgressLocalService.fetchByUserIdAndFlashcardId(userId,
			flashcardId);
	}

	@Override
	public de.ki.sbamdc.model.LearnProgress fetchLearnProgress(long id) {
		return _learnProgressLocalService.fetchLearnProgress(id);
	}

	@Override
	public java.util.List<de.ki.sbamdc.model.LearnProgress> findByUserId(
		long userId_fk) {
		return _learnProgressLocalService.findByUserId(userId_fk);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _learnProgressLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _learnProgressLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the learn progress with the primary key.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress
	* @throws PortalException if a learn progress with the primary key could not be found
	*/
	@Override
	public de.ki.sbamdc.model.LearnProgress getLearnProgress(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _learnProgressLocalService.getLearnProgress(id);
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
	@Override
	public java.util.List<de.ki.sbamdc.model.LearnProgress> getLearnProgresses(
		int start, int end) {
		return _learnProgressLocalService.getLearnProgresses(start, end);
	}

	/**
	* Returns the number of learn progresses.
	*
	* @return the number of learn progresses
	*/
	@Override
	public int getLearnProgressesCount() {
		return _learnProgressLocalService.getLearnProgressesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _learnProgressLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _learnProgressLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _learnProgressLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.HashMap<java.lang.Long, de.ki.sbamdc.model.LearnProgress> loadProgressByUserIdAndCardBoxId(
		long userId, long cardBoxId) {
		return _learnProgressLocalService.loadProgressByUserIdAndCardBoxId(userId,
			cardBoxId);
	}

	/**
	* Updates the learn progress in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param learnProgress the learn progress
	* @return the learn progress that was updated
	*/
	@Override
	public de.ki.sbamdc.model.LearnProgress updateLearnProgress(
		de.ki.sbamdc.model.LearnProgress learnProgress) {
		return _learnProgressLocalService.updateLearnProgress(learnProgress);
	}

	@Override
	public LearnProgressLocalService getWrappedService() {
		return _learnProgressLocalService;
	}

	@Override
	public void setWrappedService(
		LearnProgressLocalService learnProgressLocalService) {
		_learnProgressLocalService = learnProgressLocalService;
	}

	private LearnProgressLocalService _learnProgressLocalService;
}