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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.ki.sbamdc.exception.NoSuchCardBoxException;
import de.ki.sbamdc.model.CardBox;

/**
 * The persistence interface for the card box service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see de.ki.sbamdc.service.persistence.impl.CardBoxPersistenceImpl
 * @see CardBoxUtil
 * @generated
 */
@ProviderType
public interface CardBoxPersistence extends BasePersistence<CardBox> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CardBoxUtil} to access the card box persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the card box where name = &#63; or throws a {@link NoSuchCardBoxException} if it could not be found.
	*
	* @param name the name
	* @return the matching card box
	* @throws NoSuchCardBoxException if a matching card box could not be found
	*/
	public CardBox findByName(java.lang.String name)
		throws NoSuchCardBoxException;

	/**
	* Returns the card box where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching card box, or <code>null</code> if a matching card box could not be found
	*/
	public CardBox fetchByName(java.lang.String name);

	/**
	* Returns the card box where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching card box, or <code>null</code> if a matching card box could not be found
	*/
	public CardBox fetchByName(java.lang.String name, boolean retrieveFromCache);

	/**
	* Removes the card box where name = &#63; from the database.
	*
	* @param name the name
	* @return the card box that was removed
	*/
	public CardBox removeByName(java.lang.String name)
		throws NoSuchCardBoxException;

	/**
	* Returns the number of card boxs where name = &#63;.
	*
	* @param name the name
	* @return the number of matching card boxs
	*/
	public int countByName(java.lang.String name);

	/**
	* Returns the card box where author = &#63; or throws a {@link NoSuchCardBoxException} if it could not be found.
	*
	* @param author the author
	* @return the matching card box
	* @throws NoSuchCardBoxException if a matching card box could not be found
	*/
	public CardBox findByAuthor(java.lang.String author)
		throws NoSuchCardBoxException;

	/**
	* Returns the card box where author = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param author the author
	* @return the matching card box, or <code>null</code> if a matching card box could not be found
	*/
	public CardBox fetchByAuthor(java.lang.String author);

	/**
	* Returns the card box where author = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param author the author
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching card box, or <code>null</code> if a matching card box could not be found
	*/
	public CardBox fetchByAuthor(java.lang.String author,
		boolean retrieveFromCache);

	/**
	* Removes the card box where author = &#63; from the database.
	*
	* @param author the author
	* @return the card box that was removed
	*/
	public CardBox removeByAuthor(java.lang.String author)
		throws NoSuchCardBoxException;

	/**
	* Returns the number of card boxs where author = &#63;.
	*
	* @param author the author
	* @return the number of matching card boxs
	*/
	public int countByAuthor(java.lang.String author);

	/**
	* Caches the card box in the entity cache if it is enabled.
	*
	* @param cardBox the card box
	*/
	public void cacheResult(CardBox cardBox);

	/**
	* Caches the card boxs in the entity cache if it is enabled.
	*
	* @param cardBoxs the card boxs
	*/
	public void cacheResult(java.util.List<CardBox> cardBoxs);

	/**
	* Creates a new card box with the primary key. Does not add the card box to the database.
	*
	* @param id the primary key for the new card box
	* @return the new card box
	*/
	public CardBox create(long id);

	/**
	* Removes the card box with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the card box
	* @return the card box that was removed
	* @throws NoSuchCardBoxException if a card box with the primary key could not be found
	*/
	public CardBox remove(long id) throws NoSuchCardBoxException;

	public CardBox updateImpl(CardBox cardBox);

	/**
	* Returns the card box with the primary key or throws a {@link NoSuchCardBoxException} if it could not be found.
	*
	* @param id the primary key of the card box
	* @return the card box
	* @throws NoSuchCardBoxException if a card box with the primary key could not be found
	*/
	public CardBox findByPrimaryKey(long id) throws NoSuchCardBoxException;

	/**
	* Returns the card box with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the card box
	* @return the card box, or <code>null</code> if a card box with the primary key could not be found
	*/
	public CardBox fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, CardBox> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the card boxs.
	*
	* @return the card boxs
	*/
	public java.util.List<CardBox> findAll();

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
	public java.util.List<CardBox> findAll(int start, int end);

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
	public java.util.List<CardBox> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CardBox> orderByComparator);

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
	public java.util.List<CardBox> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CardBox> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the card boxs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of card boxs.
	*
	* @return the number of card boxs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}