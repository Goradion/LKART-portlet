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

import de.ki.sbamdc.exception.NoSuchLearnProgressException;
import de.ki.sbamdc.model.LearnProgress;

/**
 * The persistence interface for the learn progress service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see de.ki.sbamdc.service.persistence.impl.LearnProgressPersistenceImpl
 * @see LearnProgressUtil
 * @generated
 */
@ProviderType
public interface LearnProgressPersistence extends BasePersistence<LearnProgress> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LearnProgressUtil} to access the learn progress persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the learn progresses where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @return the matching learn progresses
	*/
	public java.util.List<LearnProgress> findByUserId(long userId_fk);

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
	public java.util.List<LearnProgress> findByUserId(long userId_fk,
		int start, int end);

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
	public java.util.List<LearnProgress> findByUserId(long userId_fk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator);

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
	public java.util.List<LearnProgress> findByUserId(long userId_fk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public LearnProgress findByUserId_First(long userId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException;

	/**
	* Returns the first learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public LearnProgress fetchByUserId_First(long userId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator);

	/**
	* Returns the last learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public LearnProgress findByUserId_Last(long userId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException;

	/**
	* Returns the last learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public LearnProgress fetchByUserId_Last(long userId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator);

	/**
	* Returns the learn progresses before and after the current learn progress in the ordered set where userId_fk = &#63;.
	*
	* @param id the primary key of the current learn progress
	* @param userId_fk the user id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next learn progress
	* @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	*/
	public LearnProgress[] findByUserId_PrevAndNext(long id, long userId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException;

	/**
	* Removes all the learn progresses where userId_fk = &#63; from the database.
	*
	* @param userId_fk the user id_fk
	*/
	public void removeByUserId(long userId_fk);

	/**
	* Returns the number of learn progresses where userId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @return the number of matching learn progresses
	*/
	public int countByUserId(long userId_fk);

	/**
	* Returns all the learn progresses where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @return the matching learn progresses
	*/
	public java.util.List<LearnProgress> findByCardBoxId(long cardBoxId_fk);

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
	public java.util.List<LearnProgress> findByCardBoxId(long cardBoxId_fk,
		int start, int end);

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
	public java.util.List<LearnProgress> findByCardBoxId(long cardBoxId_fk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator);

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
	public java.util.List<LearnProgress> findByCardBoxId(long cardBoxId_fk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public LearnProgress findByCardBoxId_First(long cardBoxId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException;

	/**
	* Returns the first learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public LearnProgress fetchByCardBoxId_First(long cardBoxId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator);

	/**
	* Returns the last learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public LearnProgress findByCardBoxId_Last(long cardBoxId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException;

	/**
	* Returns the last learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public LearnProgress fetchByCardBoxId_Last(long cardBoxId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator);

	/**
	* Returns the learn progresses before and after the current learn progress in the ordered set where cardBoxId_fk = &#63;.
	*
	* @param id the primary key of the current learn progress
	* @param cardBoxId_fk the card box id_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next learn progress
	* @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	*/
	public LearnProgress[] findByCardBoxId_PrevAndNext(long id,
		long cardBoxId_fk,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException;

	/**
	* Removes all the learn progresses where cardBoxId_fk = &#63; from the database.
	*
	* @param cardBoxId_fk the card box id_fk
	*/
	public void removeByCardBoxId(long cardBoxId_fk);

	/**
	* Returns the number of learn progresses where cardBoxId_fk = &#63;.
	*
	* @param cardBoxId_fk the card box id_fk
	* @return the number of matching learn progresses
	*/
	public int countByCardBoxId(long cardBoxId_fk);

	/**
	* Returns the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; or throws a {@link NoSuchLearnProgressException} if it could not be found.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @return the matching learn progress
	* @throws NoSuchLearnProgressException if a matching learn progress could not be found
	*/
	public LearnProgress findByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk) throws NoSuchLearnProgressException;

	/**
	* Returns the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @return the matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public LearnProgress fetchByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk);

	/**
	* Returns the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching learn progress, or <code>null</code> if a matching learn progress could not be found
	*/
	public LearnProgress fetchByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk, boolean retrieveFromCache);

	/**
	* Removes the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; from the database.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @return the learn progress that was removed
	*/
	public LearnProgress removeByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk) throws NoSuchLearnProgressException;

	/**
	* Returns the number of learn progresses where userId_fk = &#63; and flashcardId_fk = &#63;.
	*
	* @param userId_fk the user id_fk
	* @param flashcardId_fk the flashcard id_fk
	* @return the number of matching learn progresses
	*/
	public int countByUserIdAndFlashcardId(long userId_fk, long flashcardId_fk);

	/**
	* Caches the learn progress in the entity cache if it is enabled.
	*
	* @param learnProgress the learn progress
	*/
	public void cacheResult(LearnProgress learnProgress);

	/**
	* Caches the learn progresses in the entity cache if it is enabled.
	*
	* @param learnProgresses the learn progresses
	*/
	public void cacheResult(java.util.List<LearnProgress> learnProgresses);

	/**
	* Creates a new learn progress with the primary key. Does not add the learn progress to the database.
	*
	* @param id the primary key for the new learn progress
	* @return the new learn progress
	*/
	public LearnProgress create(long id);

	/**
	* Removes the learn progress with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress that was removed
	* @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	*/
	public LearnProgress remove(long id) throws NoSuchLearnProgressException;

	public LearnProgress updateImpl(LearnProgress learnProgress);

	/**
	* Returns the learn progress with the primary key or throws a {@link NoSuchLearnProgressException} if it could not be found.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress
	* @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	*/
	public LearnProgress findByPrimaryKey(long id)
		throws NoSuchLearnProgressException;

	/**
	* Returns the learn progress with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the learn progress
	* @return the learn progress, or <code>null</code> if a learn progress with the primary key could not be found
	*/
	public LearnProgress fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, LearnProgress> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the learn progresses.
	*
	* @return the learn progresses
	*/
	public java.util.List<LearnProgress> findAll();

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
	public java.util.List<LearnProgress> findAll(int start, int end);

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
	public java.util.List<LearnProgress> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator);

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
	public java.util.List<LearnProgress> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LearnProgress> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the learn progresses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of learn progresses.
	*
	* @return the number of learn progresses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}