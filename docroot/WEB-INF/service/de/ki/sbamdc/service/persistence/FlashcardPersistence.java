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

import de.ki.sbamdc.exception.NoSuchFlashcardException;
import de.ki.sbamdc.model.Flashcard;

/**
 * The persistence interface for the flashcard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see de.ki.sbamdc.service.persistence.impl.FlashcardPersistenceImpl
 * @see FlashcardUtil
 * @generated
 */
@ProviderType
public interface FlashcardPersistence extends BasePersistence<Flashcard> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlashcardUtil} to access the flashcard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the flashcards where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @return the matching flashcards
	*/
	public java.util.List<Flashcard> findByCardBoxId(long cardBoxId);

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
	public java.util.List<Flashcard> findByCardBoxId(long cardBoxId, int start,
		int end);

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
	public java.util.List<Flashcard> findByCardBoxId(long cardBoxId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flashcard> orderByComparator);

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
	public java.util.List<Flashcard> findByCardBoxId(long cardBoxId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flashcard> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flashcard
	* @throws NoSuchFlashcardException if a matching flashcard could not be found
	*/
	public Flashcard findByCardBoxId_First(long cardBoxId,
		com.liferay.portal.kernel.util.OrderByComparator<Flashcard> orderByComparator)
		throws NoSuchFlashcardException;

	/**
	* Returns the first flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flashcard, or <code>null</code> if a matching flashcard could not be found
	*/
	public Flashcard fetchByCardBoxId_First(long cardBoxId,
		com.liferay.portal.kernel.util.OrderByComparator<Flashcard> orderByComparator);

	/**
	* Returns the last flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flashcard
	* @throws NoSuchFlashcardException if a matching flashcard could not be found
	*/
	public Flashcard findByCardBoxId_Last(long cardBoxId,
		com.liferay.portal.kernel.util.OrderByComparator<Flashcard> orderByComparator)
		throws NoSuchFlashcardException;

	/**
	* Returns the last flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flashcard, or <code>null</code> if a matching flashcard could not be found
	*/
	public Flashcard fetchByCardBoxId_Last(long cardBoxId,
		com.liferay.portal.kernel.util.OrderByComparator<Flashcard> orderByComparator);

	/**
	* Returns the flashcards before and after the current flashcard in the ordered set where cardBoxId = &#63;.
	*
	* @param id the primary key of the current flashcard
	* @param cardBoxId the card box ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flashcard
	* @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	*/
	public Flashcard[] findByCardBoxId_PrevAndNext(long id, long cardBoxId,
		com.liferay.portal.kernel.util.OrderByComparator<Flashcard> orderByComparator)
		throws NoSuchFlashcardException;

	/**
	* Removes all the flashcards where cardBoxId = &#63; from the database.
	*
	* @param cardBoxId the card box ID
	*/
	public void removeByCardBoxId(long cardBoxId);

	/**
	* Returns the number of flashcards where cardBoxId = &#63;.
	*
	* @param cardBoxId the card box ID
	* @return the number of matching flashcards
	*/
	public int countByCardBoxId(long cardBoxId);

	/**
	* Caches the flashcard in the entity cache if it is enabled.
	*
	* @param flashcard the flashcard
	*/
	public void cacheResult(Flashcard flashcard);

	/**
	* Caches the flashcards in the entity cache if it is enabled.
	*
	* @param flashcards the flashcards
	*/
	public void cacheResult(java.util.List<Flashcard> flashcards);

	/**
	* Creates a new flashcard with the primary key. Does not add the flashcard to the database.
	*
	* @param id the primary key for the new flashcard
	* @return the new flashcard
	*/
	public Flashcard create(long id);

	/**
	* Removes the flashcard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard that was removed
	* @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	*/
	public Flashcard remove(long id) throws NoSuchFlashcardException;

	public Flashcard updateImpl(Flashcard flashcard);

	/**
	* Returns the flashcard with the primary key or throws a {@link NoSuchFlashcardException} if it could not be found.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard
	* @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	*/
	public Flashcard findByPrimaryKey(long id) throws NoSuchFlashcardException;

	/**
	* Returns the flashcard with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the flashcard
	* @return the flashcard, or <code>null</code> if a flashcard with the primary key could not be found
	*/
	public Flashcard fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Flashcard> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the flashcards.
	*
	* @return the flashcards
	*/
	public java.util.List<Flashcard> findAll();

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
	public java.util.List<Flashcard> findAll(int start, int end);

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
	public java.util.List<Flashcard> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flashcard> orderByComparator);

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
	public java.util.List<Flashcard> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Flashcard> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the flashcards from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of flashcards.
	*
	* @return the number of flashcards
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}