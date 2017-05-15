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

import de.ki.sbamdc.model.Flashcard;

import java.util.List;

/**
 * The persistence utility for the flashcard service. This utility wraps {@link de.ki.sbamdc.service.persistence.impl.FlashcardPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see FlashcardPersistence
 * @see de.ki.sbamdc.service.persistence.impl.FlashcardPersistenceImpl
 * @generated
 */
@ProviderType
public class FlashcardUtil {
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
	public static void clearCache(Flashcard flashcard) {
		getPersistence().clearCache(flashcard);
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
	public static List<Flashcard> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Flashcard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Flashcard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Flashcard> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Flashcard update(Flashcard flashcard) {
		return getPersistence().update(flashcard);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Flashcard update(Flashcard flashcard,
		ServiceContext serviceContext) {
		return getPersistence().update(flashcard, serviceContext);
	}

	/**
	* Returns all the flashcards where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @return the matching flashcards
	*/
	public static List<Flashcard> findByCardBoxId(long cardBoxId) {
		return getPersistence().findByCardBoxId(cardBoxId);
	}

	/**
	* Returns a range of all the flashcards where cardBoxId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cardBoxId the card box ID
	* @param start the lower bound of the range of flashcards
	* @param end the upper bound of the range of flashcards (not inclusive)
	* @return the range of matching flashcards
	*/
	public static List<Flashcard> findByCardBoxId(long cardBoxId, int start,
		int end) {
		return getPersistence().findByCardBoxId(cardBoxId, start, end);
	}

	/**
	* Returns an ordered range of all the flashcards where cardBoxId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cardBoxId the card box ID
	* @param start the lower bound of the range of flashcards
	* @param end the upper bound of the range of flashcards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flashcards
	*/
	public static List<Flashcard> findByCardBoxId(long cardBoxId, int start,
		int end, OrderByComparator<Flashcard> orderByComparator) {
		return getPersistence()
				   .findByCardBoxId(cardBoxId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the flashcards where cardBoxId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cardBoxId the card box ID
	* @param start the lower bound of the range of flashcards
	* @param end the upper bound of the range of flashcards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching flashcards
	*/
	public static List<Flashcard> findByCardBoxId(long cardBoxId, int start,
		int end, OrderByComparator<Flashcard> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCardBoxId(cardBoxId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flashcard
	* @throws NoSuchFlashcardException if a matching flashcard could not be found
	*/
	public static Flashcard findByCardBoxId_First(long cardBoxId,
		OrderByComparator<Flashcard> orderByComparator)
		throws de.ki.sbamdc.exception.NoSuchFlashcardException {
		return getPersistence()
				   .findByCardBoxId_First(cardBoxId, orderByComparator);
	}

	/**
	* Returns the first flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flashcard, or <code>null</code> if a matching flashcard could not be found
	*/
	public static Flashcard fetchByCardBoxId_First(long cardBoxId,
		OrderByComparator<Flashcard> orderByComparator) {
		return getPersistence()
				   .fetchByCardBoxId_First(cardBoxId, orderByComparator);
	}

	/**
	* Returns the last flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flashcard
	* @throws NoSuchFlashcardException if a matching flashcard could not be found
	*/
	public static Flashcard findByCardBoxId_Last(long cardBoxId,
		OrderByComparator<Flashcard> orderByComparator)
		throws de.ki.sbamdc.exception.NoSuchFlashcardException {
		return getPersistence()
				   .findByCardBoxId_Last(cardBoxId, orderByComparator);
	}

	/**
	* Returns the last flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flashcard, or <code>null</code> if a matching flashcard could not be found
	*/
	public static Flashcard fetchByCardBoxId_Last(long cardBoxId,
		OrderByComparator<Flashcard> orderByComparator) {
		return getPersistence()
				   .fetchByCardBoxId_Last(cardBoxId, orderByComparator);
	}

	/**
	* Returns the flashcards before and after the current flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param id the primary key of the current flashcard
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flashcard
	* @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	*/
	public static Flashcard[] findByCardBoxId_PrevAndNext(long id,
		long cardBoxId, OrderByComparator<Flashcard> orderByComparator)
		throws de.ki.sbamdc.exception.NoSuchFlashcardException {
		return getPersistence()
				   .findByCardBoxId_PrevAndNext(id, cardBoxId, orderByComparator);
	}

	/**
	* Removes all the flashcards where cardBoxId = &#63; from the database.
	*
	* @param cardBoxId the card box ID
	*/
	public static void removeByCardBoxId(long cardBoxId) {
		getPersistence().removeByCardBoxId(cardBoxId);
	}

	/**
	* Returns the number of flashcards where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @return the number of matching flashcards
	*/
	public static int countByCardBoxId(long cardBoxId) {
		return getPersistence().countByCardBoxId(cardBoxId);
	}

	/**
	* Caches the flashcard in the entity cache if it is enabled.
	*
	* @param flashcard the flashcard
	*/
	public static void cacheResult(Flashcard flashcard) {
		getPersistence().cacheResult(flashcard);
	}

	/**
	* Caches the flashcards in the entity cache if it is enabled.
	*
	* @param flashcards the flashcards
	*/
	public static void cacheResult(List<Flashcard> flashcards) {
		getPersistence().cacheResult(flashcards);
	}

	/**
	* Creates a new flashcard with the primary key. Does not add the flashcard to the database.
	*
	* @param id the primary key for the new flashcard
	* @return the new flashcard
	*/
	public static Flashcard create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the flashcard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard that was removed
	* @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	*/
	public static Flashcard remove(long id)
		throws de.ki.sbamdc.exception.NoSuchFlashcardException {
		return getPersistence().remove(id);
	}

	public static Flashcard updateImpl(Flashcard flashcard) {
		return getPersistence().updateImpl(flashcard);
	}

	/**
	* Returns the flashcard with the primary key or throws a {@link NoSuchFlashcardException} if it could not be found.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard
	* @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	*/
	public static Flashcard findByPrimaryKey(long id)
		throws de.ki.sbamdc.exception.NoSuchFlashcardException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the flashcard with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard, or <code>null</code> if a flashcard with the primary key could not be found
	*/
	public static Flashcard fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, Flashcard> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the flashcards.
	*
	* @return the flashcards
	*/
	public static List<Flashcard> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the flashcards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flashcards
	* @param end the upper bound of the range of flashcards (not inclusive)
	* @return the range of flashcards
	*/
	public static List<Flashcard> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the flashcards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flashcards
	* @param end the upper bound of the range of flashcards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flashcards
	*/
	public static List<Flashcard> findAll(int start, int end,
		OrderByComparator<Flashcard> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the flashcards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flashcards
	* @param end the upper bound of the range of flashcards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of flashcards
	*/
	public static List<Flashcard> findAll(int start, int end,
		OrderByComparator<Flashcard> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the flashcards from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of flashcards.
	*
	* @return the number of flashcards
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FlashcardPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FlashcardPersistence)PortletBeanLocatorUtil.locate(de.ki.sbamdc.service.ClpSerializer.getServletContextName(),
					FlashcardPersistence.class.getName());

			ReferenceRegistry.registerReference(FlashcardUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static FlashcardPersistence _persistence;
}