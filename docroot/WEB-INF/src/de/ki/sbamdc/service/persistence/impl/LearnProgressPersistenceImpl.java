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

import de.ki.sbamdc.exception.NoSuchLearnProgressException;
import de.ki.sbamdc.model.LearnProgress;
import de.ki.sbamdc.model.impl.LearnProgressImpl;
import de.ki.sbamdc.model.impl.LearnProgressModelImpl;
import de.ki.sbamdc.service.persistence.LearnProgressPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the learn progress service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see LearnProgressPersistence
 * @see de.ki.sbamdc.service.persistence.LearnProgressUtil
 * @generated
 */
@ProviderType
public class LearnProgressPersistenceImpl extends BasePersistenceImpl<LearnProgress>
	implements LearnProgressPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LearnProgressUtil} to access the learn progress persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LearnProgressImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED,
			LearnProgressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED,
			LearnProgressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED,
			LearnProgressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED,
			LearnProgressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId", new String[] { Long.class.getName() },
			LearnProgressModelImpl.USERID_FK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the learn progresses where userId_fk = &#63;.
	 *
	 * @param userId_fk the user id_fk
	 * @return the matching learn progresses
	 */
	@Override
	public List<LearnProgress> findByUserId(long userId_fk) {
		return findByUserId(userId_fk, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<LearnProgress> findByUserId(long userId_fk, int start, int end) {
		return findByUserId(userId_fk, start, end, null);
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
	@Override
	public List<LearnProgress> findByUserId(long userId_fk, int start, int end,
		OrderByComparator<LearnProgress> orderByComparator) {
		return findByUserId(userId_fk, start, end, orderByComparator, true);
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
	@Override
	public List<LearnProgress> findByUserId(long userId_fk, int start, int end,
		OrderByComparator<LearnProgress> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId_fk };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId_fk, start, end, orderByComparator };
		}

		List<LearnProgress> list = null;

		if (retrieveFromCache) {
			list = (List<LearnProgress>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LearnProgress learnProgress : list) {
					if ((userId_fk != learnProgress.getUserId_fk())) {
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

			query.append(_SQL_SELECT_LEARNPROGRESS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_FK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LearnProgressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId_fk);

				if (!pagination) {
					list = (List<LearnProgress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LearnProgress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first learn progress in the ordered set where userId_fk = &#63;.
	 *
	 * @param userId_fk the user id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching learn progress
	 * @throws NoSuchLearnProgressException if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress findByUserId_First(long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException {
		LearnProgress learnProgress = fetchByUserId_First(userId_fk,
				orderByComparator);

		if (learnProgress != null) {
			return learnProgress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId_fk=");
		msg.append(userId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLearnProgressException(msg.toString());
	}

	/**
	 * Returns the first learn progress in the ordered set where userId_fk = &#63;.
	 *
	 * @param userId_fk the user id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching learn progress, or <code>null</code> if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress fetchByUserId_First(long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator) {
		List<LearnProgress> list = findByUserId(userId_fk, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last learn progress in the ordered set where userId_fk = &#63;.
	 *
	 * @param userId_fk the user id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching learn progress
	 * @throws NoSuchLearnProgressException if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress findByUserId_Last(long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException {
		LearnProgress learnProgress = fetchByUserId_Last(userId_fk,
				orderByComparator);

		if (learnProgress != null) {
			return learnProgress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId_fk=");
		msg.append(userId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLearnProgressException(msg.toString());
	}

	/**
	 * Returns the last learn progress in the ordered set where userId_fk = &#63;.
	 *
	 * @param userId_fk the user id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching learn progress, or <code>null</code> if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress fetchByUserId_Last(long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator) {
		int count = countByUserId(userId_fk);

		if (count == 0) {
			return null;
		}

		List<LearnProgress> list = findByUserId(userId_fk, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LearnProgress[] findByUserId_PrevAndNext(long id, long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException {
		LearnProgress learnProgress = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LearnProgress[] array = new LearnProgressImpl[3];

			array[0] = getByUserId_PrevAndNext(session, learnProgress,
					userId_fk, orderByComparator, true);

			array[1] = learnProgress;

			array[2] = getByUserId_PrevAndNext(session, learnProgress,
					userId_fk, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LearnProgress getByUserId_PrevAndNext(Session session,
		LearnProgress learnProgress, long userId_fk,
		OrderByComparator<LearnProgress> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEARNPROGRESS_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_FK_2);

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
			query.append(LearnProgressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId_fk);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(learnProgress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LearnProgress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the learn progresses where userId_fk = &#63; from the database.
	 *
	 * @param userId_fk the user id_fk
	 */
	@Override
	public void removeByUserId(long userId_fk) {
		for (LearnProgress learnProgress : findByUserId(userId_fk,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(learnProgress);
		}
	}

	/**
	 * Returns the number of learn progresses where userId_fk = &#63;.
	 *
	 * @param userId_fk the user id_fk
	 * @return the number of matching learn progresses
	 */
	@Override
	public int countByUserId(long userId_fk) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId_fk };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEARNPROGRESS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_FK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId_fk);

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

	private static final String _FINDER_COLUMN_USERID_USERID_FK_2 = "learnProgress.userId_fk = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CARDBOXID =
		new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED,
			LearnProgressImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCardBoxId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDBOXID =
		new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED,
			LearnProgressImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCardBoxId", new String[] { Long.class.getName() },
			LearnProgressModelImpl.CARDBOXID_FK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARDBOXID = new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCardBoxId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the learn progresses where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @return the matching learn progresses
	 */
	@Override
	public List<LearnProgress> findByCardBoxId(long cardBoxId_fk) {
		return findByCardBoxId(cardBoxId_fk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LearnProgress> findByCardBoxId(long cardBoxId_fk, int start,
		int end) {
		return findByCardBoxId(cardBoxId_fk, start, end, null);
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
	@Override
	public List<LearnProgress> findByCardBoxId(long cardBoxId_fk, int start,
		int end, OrderByComparator<LearnProgress> orderByComparator) {
		return findByCardBoxId(cardBoxId_fk, start, end, orderByComparator, true);
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
	@Override
	public List<LearnProgress> findByCardBoxId(long cardBoxId_fk, int start,
		int end, OrderByComparator<LearnProgress> orderByComparator,
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

		List<LearnProgress> list = null;

		if (retrieveFromCache) {
			list = (List<LearnProgress>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LearnProgress learnProgress : list) {
					if ((cardBoxId_fk != learnProgress.getCardBoxId_fk())) {
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

			query.append(_SQL_SELECT_LEARNPROGRESS_WHERE);

			query.append(_FINDER_COLUMN_CARDBOXID_CARDBOXID_FK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LearnProgressModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(cardBoxId_fk);

				if (!pagination) {
					list = (List<LearnProgress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LearnProgress>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first learn progress in the ordered set where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching learn progress
	 * @throws NoSuchLearnProgressException if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress findByCardBoxId_First(long cardBoxId_fk,
		OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException {
		LearnProgress learnProgress = fetchByCardBoxId_First(cardBoxId_fk,
				orderByComparator);

		if (learnProgress != null) {
			return learnProgress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cardBoxId_fk=");
		msg.append(cardBoxId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLearnProgressException(msg.toString());
	}

	/**
	 * Returns the first learn progress in the ordered set where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching learn progress, or <code>null</code> if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress fetchByCardBoxId_First(long cardBoxId_fk,
		OrderByComparator<LearnProgress> orderByComparator) {
		List<LearnProgress> list = findByCardBoxId(cardBoxId_fk, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last learn progress in the ordered set where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching learn progress
	 * @throws NoSuchLearnProgressException if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress findByCardBoxId_Last(long cardBoxId_fk,
		OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException {
		LearnProgress learnProgress = fetchByCardBoxId_Last(cardBoxId_fk,
				orderByComparator);

		if (learnProgress != null) {
			return learnProgress;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cardBoxId_fk=");
		msg.append(cardBoxId_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLearnProgressException(msg.toString());
	}

	/**
	 * Returns the last learn progress in the ordered set where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching learn progress, or <code>null</code> if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress fetchByCardBoxId_Last(long cardBoxId_fk,
		OrderByComparator<LearnProgress> orderByComparator) {
		int count = countByCardBoxId(cardBoxId_fk);

		if (count == 0) {
			return null;
		}

		List<LearnProgress> list = findByCardBoxId(cardBoxId_fk, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LearnProgress[] findByCardBoxId_PrevAndNext(long id,
		long cardBoxId_fk, OrderByComparator<LearnProgress> orderByComparator)
		throws NoSuchLearnProgressException {
		LearnProgress learnProgress = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			LearnProgress[] array = new LearnProgressImpl[3];

			array[0] = getByCardBoxId_PrevAndNext(session, learnProgress,
					cardBoxId_fk, orderByComparator, true);

			array[1] = learnProgress;

			array[2] = getByCardBoxId_PrevAndNext(session, learnProgress,
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

	protected LearnProgress getByCardBoxId_PrevAndNext(Session session,
		LearnProgress learnProgress, long cardBoxId_fk,
		OrderByComparator<LearnProgress> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEARNPROGRESS_WHERE);

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
			query.append(LearnProgressModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(cardBoxId_fk);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(learnProgress);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LearnProgress> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the learn progresses where cardBoxId_fk = &#63; from the database.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 */
	@Override
	public void removeByCardBoxId(long cardBoxId_fk) {
		for (LearnProgress learnProgress : findByCardBoxId(cardBoxId_fk,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(learnProgress);
		}
	}

	/**
	 * Returns the number of learn progresses where cardBoxId_fk = &#63;.
	 *
	 * @param cardBoxId_fk the card box id_fk
	 * @return the number of matching learn progresses
	 */
	@Override
	public int countByCardBoxId(long cardBoxId_fk) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARDBOXID;

		Object[] finderArgs = new Object[] { cardBoxId_fk };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEARNPROGRESS_WHERE);

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

	private static final String _FINDER_COLUMN_CARDBOXID_CARDBOXID_FK_2 = "learnProgress.cardBoxId_fk = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID = new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED,
			LearnProgressImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdAndFlashcardId",
			new String[] { Long.class.getName(), Long.class.getName() },
			LearnProgressModelImpl.USERID_FK_COLUMN_BITMASK |
			LearnProgressModelImpl.FLASHCARDID_FK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDFLASHCARDID = new FinderPath(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndFlashcardId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; or throws a {@link NoSuchLearnProgressException} if it could not be found.
	 *
	 * @param userId_fk the user id_fk
	 * @param flashcardId_fk the flashcard id_fk
	 * @return the matching learn progress
	 * @throws NoSuchLearnProgressException if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress findByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk) throws NoSuchLearnProgressException {
		LearnProgress learnProgress = fetchByUserIdAndFlashcardId(userId_fk,
				flashcardId_fk);

		if (learnProgress == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId_fk=");
			msg.append(userId_fk);

			msg.append(", flashcardId_fk=");
			msg.append(flashcardId_fk);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLearnProgressException(msg.toString());
		}

		return learnProgress;
	}

	/**
	 * Returns the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId_fk the user id_fk
	 * @param flashcardId_fk the flashcard id_fk
	 * @return the matching learn progress, or <code>null</code> if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress fetchByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk) {
		return fetchByUserIdAndFlashcardId(userId_fk, flashcardId_fk, true);
	}

	/**
	 * Returns the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId_fk the user id_fk
	 * @param flashcardId_fk the flashcard id_fk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching learn progress, or <code>null</code> if a matching learn progress could not be found
	 */
	@Override
	public LearnProgress fetchByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId_fk, flashcardId_fk };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID,
					finderArgs, this);
		}

		if (result instanceof LearnProgress) {
			LearnProgress learnProgress = (LearnProgress)result;

			if ((userId_fk != learnProgress.getUserId_fk()) ||
					(flashcardId_fk != learnProgress.getFlashcardId_fk())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LEARNPROGRESS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDFLASHCARDID_USERID_FK_2);

			query.append(_FINDER_COLUMN_USERIDANDFLASHCARDID_FLASHCARDID_FK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId_fk);

				qPos.add(flashcardId_fk);

				List<LearnProgress> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LearnProgressPersistenceImpl.fetchByUserIdAndFlashcardId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					LearnProgress learnProgress = list.get(0);

					result = learnProgress;

					cacheResult(learnProgress);

					if ((learnProgress.getUserId_fk() != userId_fk) ||
							(learnProgress.getFlashcardId_fk() != flashcardId_fk)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID,
							finderArgs, learnProgress);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID,
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
			return (LearnProgress)result;
		}
	}

	/**
	 * Removes the learn progress where userId_fk = &#63; and flashcardId_fk = &#63; from the database.
	 *
	 * @param userId_fk the user id_fk
	 * @param flashcardId_fk the flashcard id_fk
	 * @return the learn progress that was removed
	 */
	@Override
	public LearnProgress removeByUserIdAndFlashcardId(long userId_fk,
		long flashcardId_fk) throws NoSuchLearnProgressException {
		LearnProgress learnProgress = findByUserIdAndFlashcardId(userId_fk,
				flashcardId_fk);

		return remove(learnProgress);
	}

	/**
	 * Returns the number of learn progresses where userId_fk = &#63; and flashcardId_fk = &#63;.
	 *
	 * @param userId_fk the user id_fk
	 * @param flashcardId_fk the flashcard id_fk
	 * @return the number of matching learn progresses
	 */
	@Override
	public int countByUserIdAndFlashcardId(long userId_fk, long flashcardId_fk) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDFLASHCARDID;

		Object[] finderArgs = new Object[] { userId_fk, flashcardId_fk };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LEARNPROGRESS_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDFLASHCARDID_USERID_FK_2);

			query.append(_FINDER_COLUMN_USERIDANDFLASHCARDID_FLASHCARDID_FK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId_fk);

				qPos.add(flashcardId_fk);

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

	private static final String _FINDER_COLUMN_USERIDANDFLASHCARDID_USERID_FK_2 = "learnProgress.userId_fk = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDFLASHCARDID_FLASHCARDID_FK_2 =
		"learnProgress.flashcardId_fk = ?";

	public LearnProgressPersistenceImpl() {
		setModelClass(LearnProgress.class);
	}

	/**
	 * Caches the learn progress in the entity cache if it is enabled.
	 *
	 * @param learnProgress the learn progress
	 */
	@Override
	public void cacheResult(LearnProgress learnProgress) {
		entityCache.putResult(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressImpl.class, learnProgress.getPrimaryKey(),
			learnProgress);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID,
			new Object[] {
				learnProgress.getUserId_fk(), learnProgress.getFlashcardId_fk()
			}, learnProgress);

		learnProgress.resetOriginalValues();
	}

	/**
	 * Caches the learn progresses in the entity cache if it is enabled.
	 *
	 * @param learnProgresses the learn progresses
	 */
	@Override
	public void cacheResult(List<LearnProgress> learnProgresses) {
		for (LearnProgress learnProgress : learnProgresses) {
			if (entityCache.getResult(
						LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
						LearnProgressImpl.class, learnProgress.getPrimaryKey()) == null) {
				cacheResult(learnProgress);
			}
			else {
				learnProgress.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all learn progresses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LearnProgressImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the learn progress.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LearnProgress learnProgress) {
		entityCache.removeResult(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressImpl.class, learnProgress.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LearnProgressModelImpl)learnProgress);
	}

	@Override
	public void clearCache(List<LearnProgress> learnProgresses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LearnProgress learnProgress : learnProgresses) {
			entityCache.removeResult(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
				LearnProgressImpl.class, learnProgress.getPrimaryKey());

			clearUniqueFindersCache((LearnProgressModelImpl)learnProgress);
		}
	}

	protected void cacheUniqueFindersCache(
		LearnProgressModelImpl learnProgressModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					learnProgressModelImpl.getUserId_fk(),
					learnProgressModelImpl.getFlashcardId_fk()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_USERIDANDFLASHCARDID,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID,
				args, learnProgressModelImpl);
		}
		else {
			if ((learnProgressModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						learnProgressModelImpl.getUserId_fk(),
						learnProgressModelImpl.getFlashcardId_fk()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_USERIDANDFLASHCARDID,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID,
					args, learnProgressModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		LearnProgressModelImpl learnProgressModelImpl) {
		Object[] args = new Object[] {
				learnProgressModelImpl.getUserId_fk(),
				learnProgressModelImpl.getFlashcardId_fk()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDFLASHCARDID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID, args);

		if ((learnProgressModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID.getColumnBitmask()) != 0) {
			args = new Object[] {
					learnProgressModelImpl.getOriginalUserId_fk(),
					learnProgressModelImpl.getOriginalFlashcardId_fk()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDFLASHCARDID,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERIDANDFLASHCARDID,
				args);
		}
	}

	/**
	 * Creates a new learn progress with the primary key. Does not add the learn progress to the database.
	 *
	 * @param id the primary key for the new learn progress
	 * @return the new learn progress
	 */
	@Override
	public LearnProgress create(long id) {
		LearnProgress learnProgress = new LearnProgressImpl();

		learnProgress.setNew(true);
		learnProgress.setPrimaryKey(id);

		return learnProgress;
	}

	/**
	 * Removes the learn progress with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the learn progress
	 * @return the learn progress that was removed
	 * @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	 */
	@Override
	public LearnProgress remove(long id) throws NoSuchLearnProgressException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the learn progress with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the learn progress
	 * @return the learn progress that was removed
	 * @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	 */
	@Override
	public LearnProgress remove(Serializable primaryKey)
		throws NoSuchLearnProgressException {
		Session session = null;

		try {
			session = openSession();

			LearnProgress learnProgress = (LearnProgress)session.get(LearnProgressImpl.class,
					primaryKey);

			if (learnProgress == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLearnProgressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(learnProgress);
		}
		catch (NoSuchLearnProgressException nsee) {
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
	protected LearnProgress removeImpl(LearnProgress learnProgress) {
		learnProgress = toUnwrappedModel(learnProgress);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(learnProgress)) {
				learnProgress = (LearnProgress)session.get(LearnProgressImpl.class,
						learnProgress.getPrimaryKeyObj());
			}

			if (learnProgress != null) {
				session.delete(learnProgress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (learnProgress != null) {
			clearCache(learnProgress);
		}

		return learnProgress;
	}

	@Override
	public LearnProgress updateImpl(LearnProgress learnProgress) {
		learnProgress = toUnwrappedModel(learnProgress);

		boolean isNew = learnProgress.isNew();

		LearnProgressModelImpl learnProgressModelImpl = (LearnProgressModelImpl)learnProgress;

		Session session = null;

		try {
			session = openSession();

			if (learnProgress.isNew()) {
				session.save(learnProgress);

				learnProgress.setNew(false);
			}
			else {
				learnProgress = (LearnProgress)session.merge(learnProgress);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LearnProgressModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((learnProgressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						learnProgressModelImpl.getOriginalUserId_fk()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { learnProgressModelImpl.getUserId_fk() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((learnProgressModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDBOXID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						learnProgressModelImpl.getOriginalCardBoxId_fk()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CARDBOXID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDBOXID,
					args);

				args = new Object[] { learnProgressModelImpl.getCardBoxId_fk() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CARDBOXID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CARDBOXID,
					args);
			}
		}

		entityCache.putResult(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
			LearnProgressImpl.class, learnProgress.getPrimaryKey(),
			learnProgress, false);

		clearUniqueFindersCache(learnProgressModelImpl);
		cacheUniqueFindersCache(learnProgressModelImpl, isNew);

		learnProgress.resetOriginalValues();

		return learnProgress;
	}

	protected LearnProgress toUnwrappedModel(LearnProgress learnProgress) {
		if (learnProgress instanceof LearnProgressImpl) {
			return learnProgress;
		}

		LearnProgressImpl learnProgressImpl = new LearnProgressImpl();

		learnProgressImpl.setNew(learnProgress.isNew());
		learnProgressImpl.setPrimaryKey(learnProgress.getPrimaryKey());

		learnProgressImpl.setId(learnProgress.getId());
		learnProgressImpl.setUserId_fk(learnProgress.getUserId_fk());
		learnProgressImpl.setCardBoxId_fk(learnProgress.getCardBoxId_fk());
		learnProgressImpl.setFlashcardId_fk(learnProgress.getFlashcardId_fk());
		learnProgressImpl.setProgress(learnProgress.getProgress());

		return learnProgressImpl;
	}

	/**
	 * Returns the learn progress with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the learn progress
	 * @return the learn progress
	 * @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	 */
	@Override
	public LearnProgress findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLearnProgressException {
		LearnProgress learnProgress = fetchByPrimaryKey(primaryKey);

		if (learnProgress == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLearnProgressException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return learnProgress;
	}

	/**
	 * Returns the learn progress with the primary key or throws a {@link NoSuchLearnProgressException} if it could not be found.
	 *
	 * @param id the primary key of the learn progress
	 * @return the learn progress
	 * @throws NoSuchLearnProgressException if a learn progress with the primary key could not be found
	 */
	@Override
	public LearnProgress findByPrimaryKey(long id)
		throws NoSuchLearnProgressException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the learn progress with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the learn progress
	 * @return the learn progress, or <code>null</code> if a learn progress with the primary key could not be found
	 */
	@Override
	public LearnProgress fetchByPrimaryKey(Serializable primaryKey) {
		LearnProgress learnProgress = (LearnProgress)entityCache.getResult(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
				LearnProgressImpl.class, primaryKey);

		if (learnProgress == _nullLearnProgress) {
			return null;
		}

		if (learnProgress == null) {
			Session session = null;

			try {
				session = openSession();

				learnProgress = (LearnProgress)session.get(LearnProgressImpl.class,
						primaryKey);

				if (learnProgress != null) {
					cacheResult(learnProgress);
				}
				else {
					entityCache.putResult(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
						LearnProgressImpl.class, primaryKey, _nullLearnProgress);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
					LearnProgressImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return learnProgress;
	}

	/**
	 * Returns the learn progress with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the learn progress
	 * @return the learn progress, or <code>null</code> if a learn progress with the primary key could not be found
	 */
	@Override
	public LearnProgress fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, LearnProgress> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LearnProgress> map = new HashMap<Serializable, LearnProgress>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LearnProgress learnProgress = fetchByPrimaryKey(primaryKey);

			if (learnProgress != null) {
				map.put(primaryKey, learnProgress);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			LearnProgress learnProgress = (LearnProgress)entityCache.getResult(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
					LearnProgressImpl.class, primaryKey);

			if (learnProgress == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, learnProgress);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LEARNPROGRESS_WHERE_PKS_IN);

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

			for (LearnProgress learnProgress : (List<LearnProgress>)q.list()) {
				map.put(learnProgress.getPrimaryKeyObj(), learnProgress);

				cacheResult(learnProgress);

				uncachedPrimaryKeys.remove(learnProgress.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LearnProgressModelImpl.ENTITY_CACHE_ENABLED,
					LearnProgressImpl.class, primaryKey, _nullLearnProgress);
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
	 * Returns all the learn progresses.
	 *
	 * @return the learn progresses
	 */
	@Override
	public List<LearnProgress> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LearnProgress> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<LearnProgress> findAll(int start, int end,
		OrderByComparator<LearnProgress> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<LearnProgress> findAll(int start, int end,
		OrderByComparator<LearnProgress> orderByComparator,
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

		List<LearnProgress> list = null;

		if (retrieveFromCache) {
			list = (List<LearnProgress>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LEARNPROGRESS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEARNPROGRESS;

				if (pagination) {
					sql = sql.concat(LearnProgressModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LearnProgress>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LearnProgress>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the learn progresses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LearnProgress learnProgress : findAll()) {
			remove(learnProgress);
		}
	}

	/**
	 * Returns the number of learn progresses.
	 *
	 * @return the number of learn progresses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LEARNPROGRESS);

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
		return LearnProgressModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the learn progress persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LearnProgressImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_LEARNPROGRESS = "SELECT learnProgress FROM LearnProgress learnProgress";
	private static final String _SQL_SELECT_LEARNPROGRESS_WHERE_PKS_IN = "SELECT learnProgress FROM LearnProgress learnProgress WHERE id_ IN (";
	private static final String _SQL_SELECT_LEARNPROGRESS_WHERE = "SELECT learnProgress FROM LearnProgress learnProgress WHERE ";
	private static final String _SQL_COUNT_LEARNPROGRESS = "SELECT COUNT(learnProgress) FROM LearnProgress learnProgress";
	private static final String _SQL_COUNT_LEARNPROGRESS_WHERE = "SELECT COUNT(learnProgress) FROM LearnProgress learnProgress WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "learnProgress.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LearnProgress exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LearnProgress exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LearnProgressPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static final LearnProgress _nullLearnProgress = new LearnProgressImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LearnProgress> toCacheModel() {
				return _nullLearnProgressCacheModel;
			}
		};

	private static final CacheModel<LearnProgress> _nullLearnProgressCacheModel = new CacheModel<LearnProgress>() {
			@Override
			public LearnProgress toEntityModel() {
				return _nullLearnProgress;
			}
		};
}