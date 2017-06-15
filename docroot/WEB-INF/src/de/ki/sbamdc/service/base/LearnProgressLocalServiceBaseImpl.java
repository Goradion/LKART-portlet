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

package de.ki.sbamdc.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import de.ki.sbamdc.model.LearnProgress;
import de.ki.sbamdc.service.LearnProgressLocalService;
import de.ki.sbamdc.service.persistence.CardBoxPersistence;
import de.ki.sbamdc.service.persistence.FlashcardPersistence;
import de.ki.sbamdc.service.persistence.LearnProgressPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the learn progress local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.ki.sbamdc.service.impl.LearnProgressLocalServiceImpl}.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see de.ki.sbamdc.service.impl.LearnProgressLocalServiceImpl
 * @see de.ki.sbamdc.service.LearnProgressLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class LearnProgressLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements LearnProgressLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link de.ki.sbamdc.service.LearnProgressLocalServiceUtil} to access the learn progress local service.
	 */

	/**
	 * Adds the learn progress to the database. Also notifies the appropriate model listeners.
	 *
	 * @param learnProgress the learn progress
	 * @return the learn progress that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LearnProgress addLearnProgress(LearnProgress learnProgress) {
		learnProgress.setNew(true);

		return learnProgressPersistence.update(learnProgress);
	}

	/**
	 * Creates a new learn progress with the primary key. Does not add the learn progress to the database.
	 *
	 * @param id the primary key for the new learn progress
	 * @return the new learn progress
	 */
	@Override
	public LearnProgress createLearnProgress(long id) {
		return learnProgressPersistence.create(id);
	}

	/**
	 * Deletes the learn progress with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the learn progress
	 * @return the learn progress that was removed
	 * @throws PortalException if a learn progress with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LearnProgress deleteLearnProgress(long id) throws PortalException {
		return learnProgressPersistence.remove(id);
	}

	/**
	 * Deletes the learn progress from the database. Also notifies the appropriate model listeners.
	 *
	 * @param learnProgress the learn progress
	 * @return the learn progress that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LearnProgress deleteLearnProgress(LearnProgress learnProgress) {
		return learnProgressPersistence.remove(learnProgress);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(LearnProgress.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return learnProgressPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return learnProgressPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return learnProgressPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return learnProgressPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return learnProgressPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public LearnProgress fetchLearnProgress(long id) {
		return learnProgressPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the learn progress with the primary key.
	 *
	 * @param id the primary key of the learn progress
	 * @return the learn progress
	 * @throws PortalException if a learn progress with the primary key could not be found
	 */
	@Override
	public LearnProgress getLearnProgress(long id) throws PortalException {
		return learnProgressPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(learnProgressLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(LearnProgress.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(learnProgressLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(LearnProgress.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(learnProgressLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(LearnProgress.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return learnProgressLocalService.deleteLearnProgress((LearnProgress)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return learnProgressPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<LearnProgress> getLearnProgresses(int start, int end) {
		return learnProgressPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of learn progresses.
	 *
	 * @return the number of learn progresses
	 */
	@Override
	public int getLearnProgressesCount() {
		return learnProgressPersistence.countAll();
	}

	/**
	 * Updates the learn progress in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param learnProgress the learn progress
	 * @return the learn progress that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LearnProgress updateLearnProgress(LearnProgress learnProgress) {
		return learnProgressPersistence.update(learnProgress);
	}

	/**
	 * Returns the card box local service.
	 *
	 * @return the card box local service
	 */
	public de.ki.sbamdc.service.CardBoxLocalService getCardBoxLocalService() {
		return cardBoxLocalService;
	}

	/**
	 * Sets the card box local service.
	 *
	 * @param cardBoxLocalService the card box local service
	 */
	public void setCardBoxLocalService(
		de.ki.sbamdc.service.CardBoxLocalService cardBoxLocalService) {
		this.cardBoxLocalService = cardBoxLocalService;
	}

	/**
	 * Returns the card box persistence.
	 *
	 * @return the card box persistence
	 */
	public CardBoxPersistence getCardBoxPersistence() {
		return cardBoxPersistence;
	}

	/**
	 * Sets the card box persistence.
	 *
	 * @param cardBoxPersistence the card box persistence
	 */
	public void setCardBoxPersistence(CardBoxPersistence cardBoxPersistence) {
		this.cardBoxPersistence = cardBoxPersistence;
	}

	/**
	 * Returns the flashcard local service.
	 *
	 * @return the flashcard local service
	 */
	public de.ki.sbamdc.service.FlashcardLocalService getFlashcardLocalService() {
		return flashcardLocalService;
	}

	/**
	 * Sets the flashcard local service.
	 *
	 * @param flashcardLocalService the flashcard local service
	 */
	public void setFlashcardLocalService(
		de.ki.sbamdc.service.FlashcardLocalService flashcardLocalService) {
		this.flashcardLocalService = flashcardLocalService;
	}

	/**
	 * Returns the flashcard persistence.
	 *
	 * @return the flashcard persistence
	 */
	public FlashcardPersistence getFlashcardPersistence() {
		return flashcardPersistence;
	}

	/**
	 * Sets the flashcard persistence.
	 *
	 * @param flashcardPersistence the flashcard persistence
	 */
	public void setFlashcardPersistence(
		FlashcardPersistence flashcardPersistence) {
		this.flashcardPersistence = flashcardPersistence;
	}

	/**
	 * Returns the learn progress local service.
	 *
	 * @return the learn progress local service
	 */
	public LearnProgressLocalService getLearnProgressLocalService() {
		return learnProgressLocalService;
	}

	/**
	 * Sets the learn progress local service.
	 *
	 * @param learnProgressLocalService the learn progress local service
	 */
	public void setLearnProgressLocalService(
		LearnProgressLocalService learnProgressLocalService) {
		this.learnProgressLocalService = learnProgressLocalService;
	}

	/**
	 * Returns the learn progress persistence.
	 *
	 * @return the learn progress persistence
	 */
	public LearnProgressPersistence getLearnProgressPersistence() {
		return learnProgressPersistence;
	}

	/**
	 * Sets the learn progress persistence.
	 *
	 * @param learnProgressPersistence the learn progress persistence
	 */
	public void setLearnProgressPersistence(
		LearnProgressPersistence learnProgressPersistence) {
		this.learnProgressPersistence = learnProgressPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("de.ki.sbamdc.model.LearnProgress",
			learnProgressLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"de.ki.sbamdc.model.LearnProgress");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return LearnProgressLocalService.class.getName();
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return LearnProgress.class;
	}

	protected String getModelClassName() {
		return LearnProgress.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = learnProgressPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = de.ki.sbamdc.service.CardBoxLocalService.class)
	protected de.ki.sbamdc.service.CardBoxLocalService cardBoxLocalService;
	@BeanReference(type = CardBoxPersistence.class)
	protected CardBoxPersistence cardBoxPersistence;
	@BeanReference(type = de.ki.sbamdc.service.FlashcardLocalService.class)
	protected de.ki.sbamdc.service.FlashcardLocalService flashcardLocalService;
	@BeanReference(type = FlashcardPersistence.class)
	protected FlashcardPersistence flashcardPersistence;
	@BeanReference(type = LearnProgressLocalService.class)
	protected LearnProgressLocalService learnProgressLocalService;
	@BeanReference(type = LearnProgressPersistence.class)
	protected LearnProgressPersistence learnProgressPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private ClassLoader _classLoader;
	private LearnProgressLocalServiceClpInvoker _clpInvoker = new LearnProgressLocalServiceClpInvoker();
}