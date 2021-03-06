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

package de.ki.sbamdc.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import de.ki.sbamdc.exception.NoSuchFlashcardException;
import de.ki.sbamdc.model.Flashcard;
import de.ki.sbamdc.model.impl.FlashcardImpl;
import de.ki.sbamdc.model.impl.FlashcardModelImpl;
import de.ki.sbamdc.service.persistence.FlashcardPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the flashcard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see FlashcardPersistence
 * @see de.ki.sbamdc.service.persistence.FlashcardUtil
 * @generated
 */
@ProviderType
public class FlashcardPersistenceImpl extends BasePersistenceImpl<Flashcard>
	implements FlashcardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlashcardUtil} to access the flashcard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlashcardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, FlashcardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, FlashcardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, FlashcardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, FlashcardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			FlashcardModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the flashcards where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching flashcards
	 */
	@Override
	public List<Flashcard> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flashcards where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of flashcards
	 * @param end the upper bound of the range of flashcards (not inclusive)
	 * @return the range of matching flashcards
	 */
	@Override
	public List<Flashcard> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flashcards where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of flashcards
	 * @param end the upper bound of the range of flashcards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flashcards
	 */
	@Override
	public List<Flashcard> findByUserId(long userId, int start, int end,
		OrderByComparator<Flashcard> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the flashcards where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of flashcards
	 * @param end the upper bound of the range of flashcards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching flashcards
	 */
	@Override
	public List<Flashcard> findByUserId(long userId, int start, int end,
		OrderByComparator<Flashcard> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Flashcard> list = null;

		if (retrieveFromCache) {
			list = (List<Flashcard>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Flashcard flashcard : list) {
					if ((userId != flashcard.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FLASHCARD_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlashcardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Flashcard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Flashcard>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first flashcard in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flashcard
	 * @throws NoSuchFlashcardException if a matching flashcard could not be found
	 */
	@Override
	public Flashcard findByUserId_First(long userId,
		OrderByComparator<Flashcard> orderByComparator)
		throws NoSuchFlashcardException {
		Flashcard flashcard = fetchByUserId_First(userId, orderByComparator);

		if (flashcard != null) {
			return flashcard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlashcardException(msg.toString());
	}

	/**
	 * Returns the first flashcard in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flashcard, or <code>null</code> if a matching flashcard could not be found
	 */
	@Override
	public Flashcard fetchByUserId_First(long userId,
		OrderByComparator<Flashcard> orderByComparator) {
		List<Flashcard> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flashcard in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flashcard
	 * @throws NoSuchFlashcardException if a matching flashcard could not be found
	 */
	@Override
	public Flashcard findByUserId_Last(long userId,
		OrderByComparator<Flashcard> orderByComparator)
		throws NoSuchFlashcardException {
		Flashcard flashcard = fetchByUserId_Last(userId, orderByComparator);

		if (flashcard != null) {
			return flashcard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlashcardException(msg.toString());
	}

	/**
	 * Returns the last flashcard in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flashcard, or <code>null</code> if a matching flashcard could not be found
	 */
	@Override
	public Flashcard fetchByUserId_Last(long userId,
		OrderByComparator<Flashcard> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Flashcard> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flashcards before and after the current flashcard in the ordered set where userId = &#63;.
	 *
	 * @param id the primary key of the current flashcard
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flashcard
	 * @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	 */
	@Override
	public Flashcard[] findByUserId_PrevAndNext(long id, long userId,
		OrderByComparator<Flashcard> orderByComparator)
		throws NoSuchFlashcardException {
		Flashcard flashcard = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Flashcard[] array = new FlashcardImpl[3];

			array[0] = getByUserId_PrevAndNext(session, flashcard, userId,
					orderByComparator, true);

			array[1] = flashcard;

			array[2] = getByUserId_PrevAndNext(session, flashcard, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Flashcard getByUserId_PrevAndNext(Session session,
		Flashcard flashcard, long userId,
		OrderByComparator<Flashcard> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASHCARD_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FlashcardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flashcard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Flashcard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flashcards where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (Flashcard flashcard : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(flashcard);
		}
	}

	/**
	 * Returns the number of flashcards where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching flashcards
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASHCARD_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "flashcard.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CARDBOXID =
		new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, FlashcardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCardBoxId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDBOXID =
		new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, FlashcardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCardBoxId",
			new String[] { Long.class.getName() },
			FlashcardModelImpl.CARDBOXID_FK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARDBOXID = new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCardBoxId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the flashcards where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @return the matching flashcards
	 */
	@Override
	public List<Flashcard> findByCardBoxId(long cardBoxId_fk) {
		return findByCardBoxId(cardBoxId_fk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flashcards where cardBoxId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param start the lower bound of the range of flashcards
	 * @param end the upper bound of the range of flashcards (not inclusive)
	 * @return the range of matching flashcards
	 */
	@Override
	public List<Flashcard> findByCardBoxId(long cardBoxId_fk, int start, int end) {
		return findByCardBoxId(cardBoxId_fk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flashcards where cardBoxId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param start the lower bound of the range of flashcards
	 * @param end the upper bound of the range of flashcards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flashcards
	 */
	@Override
	public List<Flashcard> findByCardBoxId(long cardBoxId_fk, int start,
		int end, OrderByComparator<Flashcard> orderByComparator) {
		return findByCardBoxId(cardBoxId_fk, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the flashcards where cardBoxId_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FlashcardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param start the lower bound of the range of flashcards
	 * @param end the upper bound of the range of flashcards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching flashcards
	 */
	@Override
	public List<Flashcard> findByCardBoxId(long cardBoxId_fk, int start,
		int end, OrderByComparator<Flashcard> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDBOXID;
			finderArgs = new Object[] { cardBoxId_fk };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CARDBOXID;
			finderArgs = new Object[] {
					cardBoxId_fk,
					
					start, end, orderByComparator
				};
		}

		List<Flashcard> list = null;

		if (retrieveFromCache) {
			list = (List<Flashcard>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Flashcard flashcard : list) {
					if ((cardBoxId_fk != flashcard.getCardBoxId_fk())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FLASHCARD_WHERE);

			query.append(_FINDER_COLUMN_CARDBOXID_CARDBOXID_FK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlashcardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cardBoxId_fk);

				if (!pagination) {
					list = (List<Flashcard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Flashcard>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first flashcard in the ordered set where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flashcard
	 * @throws NoSuchFlashcardException if a matching flashcard could not be found
	 */
	@Override
	public Flashcard findByCardBoxId_First(long cardBoxId_fk,
		OrderByComparator<Flashcard> orderByComparator)
		throws NoSuchFlashcardException {
		Flashcard flashcard = fetchByCardBoxId_First(cardBoxId_fk,
				orderByComparator);

		if (flashcard != null) {
			return flashcard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cardBoxId_fk=");
		msg.append(cardBoxId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlashcardException(msg.toString());
	}

	/**
	 * Returns the first flashcard in the ordered set where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flashcard, or <code>null</code> if a matching flashcard could not be found
	 */
	@Override
	public Flashcard fetchByCardBoxId_First(long cardBoxId_fk,
		OrderByComparator<Flashcard> orderByComparator) {
		List<Flashcard> list = findByCardBoxId(cardBoxId_fk, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flashcard in the ordered set where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flashcard
	 * @throws NoSuchFlashcardException if a matching flashcard could not be found
	 */
	@Override
	public Flashcard findByCardBoxId_Last(long cardBoxId_fk,
		OrderByComparator<Flashcard> orderByComparator)
		throws NoSuchFlashcardException {
		Flashcard flashcard = fetchByCardBoxId_Last(cardBoxId_fk,
				orderByComparator);

		if (flashcard != null) {
			return flashcard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cardBoxId_fk=");
		msg.append(cardBoxId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlashcardException(msg.toString());
	}

	/**
	 * Returns the last flashcard in the ordered set where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flashcard, or <code>null</code> if a matching flashcard could not be found
	 */
	@Override
	public Flashcard fetchByCardBoxId_Last(long cardBoxId_fk,
		OrderByComparator<Flashcard> orderByComparator) {
		int count = countByCardBoxId(cardBoxId_fk);

		if (count == 0) {
			return null;
		}

		List<Flashcard> list = findByCardBoxId(cardBoxId_fk, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flashcards before and after the current flashcard in the ordered set where cardBoxId_fk = &#63;.
	 *
	 * @param id the primary key of the current flashcard
	 * @param cardBoxId_fk the card box id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flashcard
	 * @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	 */
	@Override
	public Flashcard[] findByCardBoxId_PrevAndNext(long id, long cardBoxId_fk,
		OrderByComparator<Flashcard> orderByComparator)
		throws NoSuchFlashcardException {
		Flashcard flashcard = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Flashcard[] array = new FlashcardImpl[3];

			array[0] = getByCardBoxId_PrevAndNext(session, flashcard,
					cardBoxId_fk, orderByComparator, true);

			array[1] = flashcard;

			array[2] = getByCardBoxId_PrevAndNext(session, flashcard,
					cardBoxId_fk, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Flashcard getByCardBoxId_PrevAndNext(Session session,
		Flashcard flashcard, long cardBoxId_fk,
		OrderByComparator<Flashcard> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASHCARD_WHERE);

		query.append(_FINDER_COLUMN_CARDBOXID_CARDBOXID_FK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FlashcardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cardBoxId_fk);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flashcard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Flashcard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flashcards where cardBoxId_fk = &#63; from the database.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 */
	@Override
	public void removeByCardBoxId(long cardBoxId_fk) {
		for (Flashcard flashcard : findByCardBoxId(cardBoxId_fk,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flashcard);
		}
	}

	/**
	 * Returns the number of flashcards where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @return the number of matching flashcards
	 */
	@Override
	public int countByCardBoxId(long cardBoxId_fk) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARDBOXID;

		Object[] finderArgs = new Object[] { cardBoxId_fk };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASHCARD_WHERE);

			query.append(_FINDER_COLUMN_CARDBOXID_CARDBOXID_FK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cardBoxId_fk);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CARDBOXID_CARDBOXID_FK_2 = "flashcard.cardBoxId_fk = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE = new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, FlashcardImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCardBoxIdAndTitle",
			new String[] { Long.class.getName(), String.class.getName() },
			FlashcardModelImpl.CARDBOXID_FK_COLUMN_BITMASK |
			FlashcardModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARDBOXIDANDTITLE = new FinderPath(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCardBoxIdAndTitle",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the flashcard where cardBoxId_fk = &#63; and title = &#63; or throws a {@link NoSuchFlashcardException} if it could not be found.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param title the title
	 * @return the matching flashcard
	 * @throws NoSuchFlashcardException if a matching flashcard could not be found
	 */
	@Override
	public Flashcard findByCardBoxIdAndTitle(long cardBoxId_fk, String title)
		throws NoSuchFlashcardException {
		Flashcard flashcard = fetchByCardBoxIdAndTitle(cardBoxId_fk, title);

		if (flashcard == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("cardBoxId_fk=");
			msg.append(cardBoxId_fk);

			msg.append(", title=");
			msg.append(title);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFlashcardException(msg.toString());
		}

		return flashcard;
	}

	/**
	 * Returns the flashcard where cardBoxId_fk = &#63; and title = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param title the title
	 * @return the matching flashcard, or <code>null</code> if a matching flashcard could not be found
	 */
	@Override
	public Flashcard fetchByCardBoxIdAndTitle(long cardBoxId_fk, String title) {
		return fetchByCardBoxIdAndTitle(cardBoxId_fk, title, true);
	}

	/**
	 * Returns the flashcard where cardBoxId_fk = &#63; and title = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param title the title
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching flashcard, or <code>null</code> if a matching flashcard could not be found
	 */
	@Override
	public Flashcard fetchByCardBoxIdAndTitle(long cardBoxId_fk, String title,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { cardBoxId_fk, title };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE,
					finderArgs, this);
		}

		if (result instanceof Flashcard) {
			Flashcard flashcard = (Flashcard)result;

			if ((cardBoxId_fk != flashcard.getCardBoxId_fk()) ||
					!Objects.equals(title, flashcard.getTitle())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FLASHCARD_WHERE);

			query.append(_FINDER_COLUMN_CARDBOXIDANDTITLE_CARDBOXID_FK_2);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_CARDBOXIDANDTITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CARDBOXIDANDTITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_CARDBOXIDANDTITLE_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cardBoxId_fk);

				if (bindTitle) {
					qPos.add(title);
				}

				List<Flashcard> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FlashcardPersistenceImpl.fetchByCardBoxIdAndTitle(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Flashcard flashcard = list.get(0);

					result = flashcard;

					cacheResult(flashcard);

					if ((flashcard.getCardBoxId_fk() != cardBoxId_fk) ||
							(flashcard.getTitle() == null) ||
							!flashcard.getTitle().equals(title)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE,
							finderArgs, flashcard);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Flashcard)result;
		}
	}

	/**
	 * Removes the flashcard where cardBoxId_fk = &#63; and title = &#63; from the database.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param title the title
	 * @return the flashcard that was removed
	 */
	@Override
	public Flashcard removeByCardBoxIdAndTitle(long cardBoxId_fk, String title)
		throws NoSuchFlashcardException {
		Flashcard flashcard = findByCardBoxIdAndTitle(cardBoxId_fk, title);

		return remove(flashcard);
	}

	/**
	 * Returns the number of flashcards where cardBoxId_fk = &#63; and title = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param title the title
	 * @return the number of matching flashcards
	 */
	@Override
	public int countByCardBoxIdAndTitle(long cardBoxId_fk, String title) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARDBOXIDANDTITLE;

		Object[] finderArgs = new Object[] { cardBoxId_fk, title };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FLASHCARD_WHERE);

			query.append(_FINDER_COLUMN_CARDBOXIDANDTITLE_CARDBOXID_FK_2);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_CARDBOXIDANDTITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CARDBOXIDANDTITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_CARDBOXIDANDTITLE_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cardBoxId_fk);

				if (bindTitle) {
					qPos.add(title);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CARDBOXIDANDTITLE_CARDBOXID_FK_2 = "flashcard.cardBoxId_fk = ? AND ";
	private static final String _FINDER_COLUMN_CARDBOXIDANDTITLE_TITLE_1 = "flashcard.title IS NULL";
	private static final String _FINDER_COLUMN_CARDBOXIDANDTITLE_TITLE_2 = "flashcard.title = ?";
	private static final String _FINDER_COLUMN_CARDBOXIDANDTITLE_TITLE_3 = "(flashcard.title IS NULL OR flashcard.title = '')";

	public FlashcardPersistenceImpl() {
		setModelClass(Flashcard.class);
	}

	/**
	 * Caches the flashcard in the entity cache if it is enabled.
	 *
	 * @param flashcard the flashcard
	 */
	@Override
	public void cacheResult(Flashcard flashcard) {
		entityCache.putResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardImpl.class, flashcard.getPrimaryKey(), flashcard);

		finderCache.putResult(FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE,
			new Object[] { flashcard.getCardBoxId_fk(), flashcard.getTitle() },
			flashcard);

		flashcard.resetOriginalValues();
	}

	/**
	 * Caches the flashcards in the entity cache if it is enabled.
	 *
	 * @param flashcards the flashcards
	 */
	@Override
	public void cacheResult(List<Flashcard> flashcards) {
		for (Flashcard flashcard : flashcards) {
			if (entityCache.getResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
						FlashcardImpl.class, flashcard.getPrimaryKey()) == null) {
				cacheResult(flashcard);
			}
			else {
				flashcard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flashcards.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FlashcardImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flashcard.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Flashcard flashcard) {
		entityCache.removeResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardImpl.class, flashcard.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FlashcardModelImpl)flashcard);
	}

	@Override
	public void clearCache(List<Flashcard> flashcards) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Flashcard flashcard : flashcards) {
			entityCache.removeResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
				FlashcardImpl.class, flashcard.getPrimaryKey());

			clearUniqueFindersCache((FlashcardModelImpl)flashcard);
		}
	}

	protected void cacheUniqueFindersCache(
		FlashcardModelImpl flashcardModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					flashcardModelImpl.getCardBoxId_fk(),
					flashcardModelImpl.getTitle()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_CARDBOXIDANDTITLE, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE, args,
				flashcardModelImpl);
		}
		else {
			if ((flashcardModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flashcardModelImpl.getCardBoxId_fk(),
						flashcardModelImpl.getTitle()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_CARDBOXIDANDTITLE,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE,
					args, flashcardModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		FlashcardModelImpl flashcardModelImpl) {
		Object[] args = new Object[] {
				flashcardModelImpl.getCardBoxId_fk(),
				flashcardModelImpl.getTitle()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_CARDBOXIDANDTITLE, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE, args);

		if ((flashcardModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE.getColumnBitmask()) != 0) {
			args = new Object[] {
					flashcardModelImpl.getOriginalCardBoxId_fk(),
					flashcardModelImpl.getOriginalTitle()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CARDBOXIDANDTITLE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_CARDBOXIDANDTITLE,
				args);
		}
	}

	/**
	 * Creates a new flashcard with the primary key. Does not add the flashcard to the database.
	 *
	 * @param id the primary key for the new flashcard
	 * @return the new flashcard
	 */
	@Override
	public Flashcard create(long id) {
		Flashcard flashcard = new FlashcardImpl();

		flashcard.setNew(true);
		flashcard.setPrimaryKey(id);

		return flashcard;
	}

	/**
	 * Removes the flashcard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the flashcard
	 * @return the flashcard that was removed
	 * @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	 */
	@Override
	public Flashcard remove(long id) throws NoSuchFlashcardException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the flashcard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flashcard
	 * @return the flashcard that was removed
	 * @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	 */
	@Override
	public Flashcard remove(Serializable primaryKey)
		throws NoSuchFlashcardException {
		Session session = null;

		try {
			session = openSession();

			Flashcard flashcard = (Flashcard)session.get(FlashcardImpl.class,
					primaryKey);

			if (flashcard == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlashcardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flashcard);
		}
		catch (NoSuchFlashcardException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Flashcard removeImpl(Flashcard flashcard) {
		flashcard = toUnwrappedModel(flashcard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flashcard)) {
				flashcard = (Flashcard)session.get(FlashcardImpl.class,
						flashcard.getPrimaryKeyObj());
			}

			if (flashcard != null) {
				session.delete(flashcard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flashcard != null) {
			clearCache(flashcard);
		}

		return flashcard;
	}

	@Override
	public Flashcard updateImpl(Flashcard flashcard) {
		flashcard = toUnwrappedModel(flashcard);

		boolean isNew = flashcard.isNew();

		FlashcardModelImpl flashcardModelImpl = (FlashcardModelImpl)flashcard;

		Session session = null;

		try {
			session = openSession();

			if (flashcard.isNew()) {
				session.save(flashcard);

				flashcard.setNew(false);
			}
			else {
				flashcard = (Flashcard)session.merge(flashcard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FlashcardModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((flashcardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flashcardModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { flashcardModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((flashcardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDBOXID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flashcardModelImpl.getOriginalCardBoxId_fk()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CARDBOXID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDBOXID,
					args);

				args = new Object[] { flashcardModelImpl.getCardBoxId_fk() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CARDBOXID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDBOXID,
					args);
			}
		}

		entityCache.putResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
			FlashcardImpl.class, flashcard.getPrimaryKey(), flashcard, false);

		clearUniqueFindersCache(flashcardModelImpl);
		cacheUniqueFindersCache(flashcardModelImpl, isNew);

		flashcard.resetOriginalValues();

		return flashcard;
	}

	protected Flashcard toUnwrappedModel(Flashcard flashcard) {
		if (flashcard instanceof FlashcardImpl) {
			return flashcard;
		}

		FlashcardImpl flashcardImpl = new FlashcardImpl();

		flashcardImpl.setNew(flashcard.isNew());
		flashcardImpl.setPrimaryKey(flashcard.getPrimaryKey());

		flashcardImpl.setId(flashcard.getId());
		flashcardImpl.setUserId(flashcard.getUserId());
		flashcardImpl.setFrontSide(flashcard.getFrontSide());
		flashcardImpl.setBackSide(flashcard.getBackSide());
		flashcardImpl.setCardBoxId_fk(flashcard.getCardBoxId_fk());
		flashcardImpl.setTitle(flashcard.getTitle());

		return flashcardImpl;
	}

	/**
	 * Returns the flashcard with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flashcard
	 * @return the flashcard
	 * @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	 */
	@Override
	public Flashcard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlashcardException {
		Flashcard flashcard = fetchByPrimaryKey(primaryKey);

		if (flashcard == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlashcardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flashcard;
	}

	/**
	 * Returns the flashcard with the primary key or throws a {@link NoSuchFlashcardException} if it could not be found.
	 *
	 * @param id the primary key of the flashcard
	 * @return the flashcard
	 * @throws NoSuchFlashcardException if a flashcard with the primary key could not be found
	 */
	@Override
	public Flashcard findByPrimaryKey(long id) throws NoSuchFlashcardException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the flashcard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flashcard
	 * @return the flashcard, or <code>null</code> if a flashcard with the primary key could not be found
	 */
	@Override
	public Flashcard fetchByPrimaryKey(Serializable primaryKey) {
		Flashcard flashcard = (Flashcard)entityCache.getResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
				FlashcardImpl.class, primaryKey);

		if (flashcard == _nullFlashcard) {
			return null;
		}

		if (flashcard == null) {
			Session session = null;

			try {
				session = openSession();

				flashcard = (Flashcard)session.get(FlashcardImpl.class,
						primaryKey);

				if (flashcard != null) {
					cacheResult(flashcard);
				}
				else {
					entityCache.putResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
						FlashcardImpl.class, primaryKey, _nullFlashcard);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
					FlashcardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flashcard;
	}

	/**
	 * Returns the flashcard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the flashcard
	 * @return the flashcard, or <code>null</code> if a flashcard with the primary key could not be found
	 */
	@Override
	public Flashcard fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Flashcard> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Flashcard> map = new HashMap<Serializable, Flashcard>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Flashcard flashcard = fetchByPrimaryKey(primaryKey);

			if (flashcard != null) {
				map.put(primaryKey, flashcard);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Flashcard flashcard = (Flashcard)entityCache.getResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
					FlashcardImpl.class, primaryKey);

			if (flashcard == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, flashcard);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FLASHCARD_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Flashcard flashcard : (List<Flashcard>)q.list()) {
				map.put(flashcard.getPrimaryKeyObj(), flashcard);

				cacheResult(flashcard);

				uncachedPrimaryKeys.remove(flashcard.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FlashcardModelImpl.ENTITY_CACHE_ENABLED,
					FlashcardImpl.class, primaryKey, _nullFlashcard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the flashcards.
	 *
	 * @return the flashcards
	 */
	@Override
	public List<Flashcard> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Flashcard> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Flashcard> findAll(int start, int end,
		OrderByComparator<Flashcard> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Flashcard> findAll(int start, int end,
		OrderByComparator<Flashcard> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Flashcard> list = null;

		if (retrieveFromCache) {
			list = (List<Flashcard>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FLASHCARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASHCARD;

				if (pagination) {
					sql = sql.concat(FlashcardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Flashcard>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Flashcard>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the flashcards from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Flashcard flashcard : findAll()) {
			remove(flashcard);
		}
	}

	/**
	 * Returns the number of flashcards.
	 *
	 * @return the number of flashcards
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FLASHCARD);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FlashcardModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the flashcard persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FlashcardImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_FLASHCARD = "SELECT flashcard FROM Flashcard flashcard";
	private static final String _SQL_SELECT_FLASHCARD_WHERE_PKS_IN = "SELECT flashcard FROM Flashcard flashcard WHERE id_ IN (";
	private static final String _SQL_SELECT_FLASHCARD_WHERE = "SELECT flashcard FROM Flashcard flashcard WHERE ";
	private static final String _SQL_COUNT_FLASHCARD = "SELECT COUNT(flashcard) FROM Flashcard flashcard";
	private static final String _SQL_COUNT_FLASHCARD_WHERE = "SELECT COUNT(flashcard) FROM Flashcard flashcard WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flashcard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Flashcard exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Flashcard exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FlashcardPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static final Flashcard _nullFlashcard = new FlashcardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Flashcard> toCacheModel() {
				return _nullFlashcardCacheModel;
			}
		};

	private static final CacheModel<Flashcard> _nullFlashcardCacheModel = new CacheModel<Flashcard>() {
			@Override
			public Flashcard toEntityModel() {
				return _nullFlashcard;
			}
		};
}