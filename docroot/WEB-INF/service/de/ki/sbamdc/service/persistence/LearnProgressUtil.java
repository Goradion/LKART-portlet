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

package de.ki.sbamdc.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import de.ki.sbamdc.model.LearnProgress;

import java.util.List;

/**
 * The persistence utility for the learn progress service. This utility wraps {@link de.ki.sbamdc.service.persistence.impl.LearnProgressPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see LearnProgressPersistence
 * @see de.ki.sbamdc.service.persistence.impl.LearnProgressPersistenceImpl
 * @generated
 */
@ProviderType
public class LearnProgressUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(LearnProgress learnProgress) {
		getPersistence().clearCache(learnProgress);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LearnProgress> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LearnProgress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LearnProgress> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LearnProgress> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LearnProgress update(LearnProgress learnProgress) {
		return getPersistence().update(learnProgress);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LearnProgress update(LearnProgress learnProgress,
		ServiceContext serviceContext) {
		return getPersistence().update(learnProgress, serviceContext);
	}

	/**
	* Returns all the learn progresses where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @return the matching learn progresses
	*/
	public static List<LearnProgress> findByUserId(long userId_fk) {
		return getPersistence().findByUserId(userId_fk);
	}

	/**
	* Returns a range of all the learn progresses where userId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId_fk the user id_fk
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @return the range of matching learn progresses
	*/
	public static List<LearnProgress> findByUserId(long userId_fk, int start,
		int end) {
		return getPersistence().findByUserId(userId_fk, start, end);
	}

	/**
	* Returns an ordered range of all the learn progresses where userId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId_fk the user id_fk
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching learn progresses
	*/
	public static List<LearnProgress> findByUserId(long userId_fk, int start,
		int end, OrderByComparator<LearnProgress> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId_fk, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the learn progresses where userId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId_fk the user id_fk
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching learn progresses
	*/
	public static List<LearnProgress> findByUserId(long userId_fk, int start,
		int end, OrderByComparator<LearnProgress> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId_fk, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public static LearnProgress findByUserId_First(long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence().findByUserId_First(userId_fk, orderByComparator);
	}

	/**
	* Returns the first learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public static LearnProgress fetchByUserId_First(long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId_fk, orderByComparator);
	}

	/**
	* Returns the last learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public static LearnProgress findByUserId_Last(long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence().findByUserId_Last(userId_fk, orderByComparator);
	}

	/**
	* Returns the last learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public static LearnProgress fetchByUserId_Last(long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId_fk, orderByComparator);
	}

	/**
	* Returns the learn progresses before and after the current learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param id the primary key of the current learn progress
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next learn progress
	* @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	*/
	public static LearnProgress[] findByUserId_PrevAndNext(long id,
		long userId_fk, OrderByComparator<LearnProgress> orderByComparator)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence()
				   .findByUserId_PrevAndNext(id, userId_fk, orderByComparator);
	}

	/**
	* Removes all the learn progresses where userId_fk = &#63; from the database.
	*
	* @param userId_fk the user id_fk
	*/
	public static void removeByUserId(long userId_fk) {
		getPersistence().removeByUserId(userId_fk);
	}

	/**
	* Returns the number of learn progresses where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @return the number of matching learn progresses
	*/
	public static int countByUserId(long userId_fk) {
		return getPersistence().countByUserId(userId_fk);
	}

	/**
	* Returns all the learn progresses where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @return the matching learn progresses
	*/
	public static List<LearnProgress> findByCardBoxId(long cardBoxId_fk) {
		return getPersistence().findByCardBoxId(cardBoxId_fk);
	}

	/**
	* Returns a range of all the learn progresses where cardBoxId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cardBoxId_fk the card box id_fk
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @return the range of matching learn progresses
	*/
	public static List<LearnProgress> findByCardBoxId(long cardBoxId_fk,
		int start, int end) {
		return getPersistence().findByCardBoxId(cardBoxId_fk, start, end);
	}

	/**
	* Returns an ordered range of all the learn progresses where cardBoxId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cardBoxId_fk the card box id_fk
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching learn progresses
	*/
	public static List<LearnProgress> findByCardBoxId(long cardBoxId_fk,
		int start, int end, OrderByComparator<LearnProgress> orderByComparator) {
		return getPersistence()
				   .findByCardBoxId(cardBoxId_fk, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the learn progresses where cardBoxId_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cardBoxId_fk the card box id_fk
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching learn progresses
	*/
	public static List<LearnProgress> findByCardBoxId(long cardBoxId_fk,
		int start, int end, OrderByComparator<LearnProgress> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCardBoxId(cardBoxId_fk, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public static LearnProgress findByCardBoxId_First(long cardBoxId_fk,
		OrderByComparator<LearnProgress> orderByComparator)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence()
				   .findByCardBoxId_First(cardBoxId_fk, orderByComparator);
	}

	/**
	* Returns the first learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public static LearnProgress fetchByCardBoxId_First(long cardBoxId_fk,
		OrderByComparator<LearnProgress> orderByComparator) {
		return getPersistence()
				   .fetchByCardBoxId_First(cardBoxId_fk, orderByComparator);
	}

	/**
	* Returns the last learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public static LearnProgress findByCardBoxId_Last(long cardBoxId_fk,
		OrderByComparator<LearnProgress> orderByComparator)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence()
				   .findByCardBoxId_Last(cardBoxId_fk, orderByComparator);
	}

	/**
	* Returns the last learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public static LearnProgress fetchByCardBoxId_Last(long cardBoxId_fk,
		OrderByComparator<LearnProgress> orderByComparator) {
		return getPersistence()
				   .fetchByCardBoxId_Last(cardBoxId_fk, orderByComparator);
	}

	/**
	* Returns the learn progresses before and after the current learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param id the primary key of the current learn progress
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next learn progress
	* @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	*/
	public static LearnProgress[] findByCardBoxId_PrevAndNext(long id,
		long cardBoxId_fk, OrderByComparator<LearnProgress> orderByComparator)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence()
				   .findByCardBoxId_PrevAndNext(id, cardBoxId_fk,
			orderByComparator);
	}

	/**
	* Removes all the learn progresses where cardBoxId_fk = &#63; from the database.
	*
	* @param cardBoxId_fk the card box id_fk
	*/
	public static void removeByCardBoxId(long cardBoxId_fk) {
		getPersistence().removeByCardBoxId(cardBoxId_fk);
	}

	/**
	* Returns the number of learn progresses where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @return the number of matching learn progresses
	*/
	public static int countByCardBoxId(long cardBoxId_fk) {
		return getPersistence().countByCardBoxId(cardBoxId_fk);
	}

	/**
	* Returns the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; or throws a {@link NoSuchLearnProgressException} if it could not be found.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @return the matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public static LearnProgress findByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence()
				   .findByUserIdAndFlashcardId(userId_fk, flashcardId_fk);
	}

	/**
	* Returns the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @return the matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public static LearnProgress fetchByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk) {
		return getPersistence()
				   .fetchByUserIdAndFlashcardId(userId_fk, flashcardId_fk);
	}

	/**
	* Returns the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public static LearnProgress fetchByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByUserIdAndFlashcardId(userId_fk, flashcardId_fk,
			retrieveFromCache);
	}

	/**
	* Removes the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; from the database.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @return the learn progress that was removed
	*/
	public static LearnProgress removeByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence()
				   .removeByUserIdAndFlashcardId(userId_fk, flashcardId_fk);
	}

	/**
	* Returns the number of learn progresses where userId_fk = &#63; and flashcardId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @return the number of matching learn progresses
	*/
	public static int countByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk) {
		return getPersistence()
				   .countByUserIdAndFlashcardId(userId_fk, flashcardId_fk);
	}

	/**
	* Caches the learn progress in the entity cache if it is enabled.
	*
	* @param learnProgress the learn progress
	*/
	public static void cacheResult(LearnProgress learnProgress) {
		getPersistence().cacheResult(learnProgress);
	}

	/**
	* Caches the learn progresses in the entity cache if it is enabled.
	*
	* @param learnProgresses the learn progresses
	*/
	public static void cacheResult(List<LearnProgress> learnProgresses) {
		getPersistence().cacheResult(learnProgresses);
	}

	/**
	* Creates a new learn progress with the primary key. Does not add the learn progress to the database.
	*
	* @param id the primary key for the new learn progress
	* @return the new learn progress
	*/
	public static LearnProgress create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the learn progress with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress that was removed
	* @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	*/
	public static LearnProgress remove(long id)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence().remove(id);
	}

	public static LearnProgress updateImpl(LearnProgress learnProgress) {
		return getPersistence().updateImpl(learnProgress);
	}

	/**
	* Returns the learn progress with the primary key or throws a {@link NoSuchLearnProgressException} if it could not be found.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress
	* @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	*/
	public static LearnProgress findByPrimaryKey(long id)
		throws de.ki.sbamdc.exception.NoSuchLearnProgressException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the learn progress with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress, or <code>null</code> if a learn progress with the primary key could not be found
	*/
	public static LearnProgress fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, LearnProgress> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the learn progresses.
	*
	* @return the learn progresses
	*/
	public static List<LearnProgress> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the learn progresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @return the range of learn progresses
	*/
	public static List<LearnProgress> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the learn progresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of learn progresses
	*/
	public static List<LearnProgress> findAll(int start, int end,
		OrderByComparator<LearnProgress> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the learn progresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LearnProgressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of learn progresses
	* @param end the upper bound of the range of learn progresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of learn progresses
	*/
	public static List<LearnProgress> findAll(int start, int end,
		OrderByComparator<LearnProgress> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the learn progresses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of learn progresses.
	*
	* @return the number of learn progresses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LearnProgressPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LearnProgressPersistence)PortletBeanLocatorUtil.locate(de.ki.sbamdc.service.ClpSerializer.getServletContextName(),
					LearnProgressPersistence.class.getName());

			ReferenceRegistry.registerReference(LearnProgressUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static LearnProgressPersistence _persistence;
}