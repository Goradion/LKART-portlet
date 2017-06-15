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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;

import de.ki.sbamdc.model.LearnProgress;
import de.ki.sbamdc.service.LearnProgressService;
import de.ki.sbamdc.service.persistence.CardBoxPersistence;
import de.ki.sbamdc.service.persistence.FlashcardPersistence;
import de.ki.sbamdc.service.persistence.LearnProgressPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the learn progress remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.ki.sbamdc.service.impl.LearnProgressServiceImpl}.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see de.ki.sbamdc.service.impl.LearnProgressServiceImpl
 * @see de.ki.sbamdc.service.LearnProgressServiceUtil
 * @generated
 */
public abstract class LearnProgressServiceBaseImpl extends BaseServiceImpl
	implements LearnProgressService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link de.ki.sbamdc.service.LearnProgressServiceUtil} to access the learn progress remote service.
	 */

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
	 * Returns the card box remote service.
	 *
	 * @return the card box remote service
	 */
	public de.ki.sbamdc.service.CardBoxService getCardBoxService() {
		return cardBoxService;
	}

	/**
	 * Sets the card box remote service.
	 *
	 * @param cardBoxService the card box remote service
	 */
	public void setCardBoxService(
		de.ki.sbamdc.service.CardBoxService cardBoxService) {
		this.cardBoxService = cardBoxService;
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
	 * Returns the flashcard remote service.
	 *
	 * @return the flashcard remote service
	 */
	public de.ki.sbamdc.service.FlashcardService getFlashcardService() {
		return flashcardService;
	}

	/**
	 * Sets the flashcard remote service.
	 *
	 * @param flashcardService the flashcard remote service
	 */
	public void setFlashcardService(
		de.ki.sbamdc.service.FlashcardService flashcardService) {
		this.flashcardService = flashcardService;
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
	public de.ki.sbamdc.service.LearnProgressLocalService getLearnProgressLocalService() {
		return learnProgressLocalService;
	}

	/**
	 * Sets the learn progress local service.
	 *
	 * @param learnProgressLocalService the learn progress local service
	 */
	public void setLearnProgressLocalService(
		de.ki.sbamdc.service.LearnProgressLocalService learnProgressLocalService) {
		this.learnProgressLocalService = learnProgressLocalService;
	}

	/**
	 * Returns the learn progress remote service.
	 *
	 * @return the learn progress remote service
	 */
	public LearnProgressService getLearnProgressService() {
		return learnProgressService;
	}

	/**
	 * Sets the learn progress remote service.
	 *
	 * @param learnProgressService the learn progress remote service
	 */
	public void setLearnProgressService(
		LearnProgressService learnProgressService) {
		this.learnProgressService = learnProgressService;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return LearnProgressService.class.getName();
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
	@BeanReference(type = de.ki.sbamdc.service.CardBoxService.class)
	protected de.ki.sbamdc.service.CardBoxService cardBoxService;
	@BeanReference(type = CardBoxPersistence.class)
	protected CardBoxPersistence cardBoxPersistence;
	@BeanReference(type = de.ki.sbamdc.service.FlashcardLocalService.class)
	protected de.ki.sbamdc.service.FlashcardLocalService flashcardLocalService;
	@BeanReference(type = de.ki.sbamdc.service.FlashcardService.class)
	protected de.ki.sbamdc.service.FlashcardService flashcardService;
	@BeanReference(type = FlashcardPersistence.class)
	protected FlashcardPersistence flashcardPersistence;
	@BeanReference(type = de.ki.sbamdc.service.LearnProgressLocalService.class)
	protected de.ki.sbamdc.service.LearnProgressLocalService learnProgressLocalService;
	@BeanReference(type = LearnProgressService.class)
	protected LearnProgressService learnProgressService;
	@BeanReference(type = LearnProgressPersistence.class)
	protected LearnProgressPersistence learnProgressPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private ClassLoader _classLoader;
	private LearnProgressServiceClpInvoker _clpInvoker = new LearnProgressServiceClpInvoker();
}