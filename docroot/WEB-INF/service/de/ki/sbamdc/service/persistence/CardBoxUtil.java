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

import de.ki.sbamdc.model.CardBox;

import java.util.List;

/**
 * The persistence utility for the card box service. This utility wraps {@link de.ki.sbamdc.service.persistence.impl.CardBoxPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see CardBoxPersistence
 * @see de.ki.sbamdc.service.persistence.impl.CardBoxPersistenceImpl
 * @generated
 */
@ProviderType
public class CardBoxUtil {
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
	public static void clearCache(CardBox cardBox) {
		getPersistence().clearCache(cardBox);
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
	public static List<CardBox> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CardBox> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CardBox> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CardBox> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CardBox update(CardBox cardBox) {
		return getPersistence().update(cardBox);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CardBox update(CardBox cardBox, ServiceContext serviceContext) {
		return getPersistence().update(cardBox, serviceContext);
	}

	/**
	* Returns the card box where name = &#63; or throws a {@link NoSuchCardBoxException} if it could not be found.
	*
	* @param name the name
	* @return the matching card box
	* @throws NoSuchCardBoxException if a matching card box could not be found
	*/
	public static CardBox findByName(java.lang.String name)
		throws de.ki.sbamdc.exception.NoSuchCardBoxException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the card box where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching card box, or <code>null</code> if a matching card box could not be found
	*/
	public static CardBox fetchByName(java.lang.String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the card box where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching card box, or <code>null</code> if a matching card box could not be found
	*/
	public static CardBox fetchByName(java.lang.String name,
		boolean retrieveFromCache) {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the card box where name = &#63; from the database.
	*
	* @param name the name
	* @return the card box that was removed
	*/
	public static CardBox removeByName(java.lang.String name)
		throws de.ki.sbamdc.exception.NoSuchCardBoxException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of card boxs where name = &#63;.
	*
	* @param name the name
	* @return the number of matching card boxs
	*/
	public static int countByName(java.lang.String name) {
		return getPersistence().countByName(name);
	}

	/**
	* Returns the card box where author = &#63; or throws a {@link NoSuchCardBoxException} if it could not be found.
	*
	* @param author the author
	* @return the matching card box
	* @throws NoSuchCardBoxException if a matching card box could not be found
	*/
	public static CardBox findByAuthor(java.lang.String author)
		throws de.ki.sbamdc.exception.NoSuchCardBoxException {
		return getPersistence().findByAuthor(author);
	}

	/**
	* Returns the card box where author = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param author the author
	* @return the matching card box, or <code>null</code> if a matching card box could not be found
	*/
	public static CardBox fetchByAuthor(java.lang.String author) {
		return getPersistence().fetchByAuthor(author);
	}

	/**
	* Returns the card box where author = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param author the author
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching card box, or <code>null</code> if a matching card box could not be found
	*/
	public static CardBox fetchByAuthor(java.lang.String author,
		boolean retrieveFromCache) {
		return getPersistence().fetchByAuthor(author, retrieveFromCache);
	}

	/**
	* Removes the card box where author = &#63; from the database.
	*
	* @param author the author
	* @return the card box that was removed
	*/
	public static CardBox removeByAuthor(java.lang.String author)
		throws de.ki.sbamdc.exception.NoSuchCardBoxException {
		return getPersistence().removeByAuthor(author);
	}

	/**
	* Returns the number of card boxs where author = &#63;.
	*
	* @param author the author
	* @return the number of matching card boxs
	*/
	public static int countByAuthor(java.lang.String author) {
		return getPersistence().countByAuthor(author);
	}

	/**
	* Caches the card box in the entity cache if it is enabled.
	*
	* @param cardBox the card box
	*/
	public static void cacheResult(CardBox cardBox) {
		getPersistence().cacheResult(cardBox);
	}

	/**
	* Caches the card boxs in the entity cache if it is enabled.
	*
	* @param cardBoxs the card boxs
	*/
	public static void cacheResult(List<CardBox> cardBoxs) {
		getPersistence().cacheResult(cardBoxs);
	}

	/**
	* Creates a new card box with the primary key. Does not add the card box to the database.
	*
	* @param id the primary key for the new card box
	* @return the new card box
	*/
	public static CardBox create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the card box with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the card box
	* @return the card box that was removed
	* @throws NoSuchCardBoxException if a card box with the primary key could not be found
	*/
	public static CardBox remove(long id)
		throws de.ki.sbamdc.exception.NoSuchCardBoxException {
		return getPersistence().remove(id);
	}

	public static CardBox updateImpl(CardBox cardBox) {
		return getPersistence().updateImpl(cardBox);
	}

	/**
	* Returns the card box with the primary key or throws a {@link NoSuchCardBoxException} if it could not be found.
	*
	* @param id the primary key of the card box
	* @return the card box
	* @throws NoSuchCardBoxException if a card box with the primary key could not be found
	*/
	public static CardBox findByPrimaryKey(long id)
		throws de.ki.sbamdc.exception.NoSuchCardBoxException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the card box with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the card box
	* @return the card box, or <code>null</code> if a card box with the primary key could not be found
	*/
	public static CardBox fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, CardBox> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the card boxs.
	*
	* @return the card boxs
	*/
	public static List<CardBox> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the card boxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CardBoxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of card boxs
	* @param end the upper bound of the range of card boxs (not inclusive)
	* @return the range of card boxs
	*/
	public static List<CardBox> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the card boxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CardBoxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of card boxs
	* @param end the upper bound of the range of card boxs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of card boxs
	*/
	public static List<CardBox> findAll(int start, int end,
		OrderByComparator<CardBox> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the card boxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CardBoxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of card boxs
	* @param end the upper bound of the range of card boxs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of card boxs
	*/
	public static List<CardBox> findAll(int start, int end,
		OrderByComparator<CardBox> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the card boxs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of card boxs.
	*
	* @return the number of card boxs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CardBoxPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CardBoxPersistence)PortletBeanLocatorUtil.locate(de.ki.sbamdc.service.ClpSerializer.getServletContextName(),
					CardBoxPersistence.class.getName());

			ReferenceRegistry.registerReference(CardBoxUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static CardBoxPersistence _persistence;
}