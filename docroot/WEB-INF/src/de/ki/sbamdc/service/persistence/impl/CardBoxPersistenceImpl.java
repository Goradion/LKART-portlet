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

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import de.ki.sbamdc.exception.NoSuchCardBoxException;
import de.ki.sbamdc.model.CardBox;
import de.ki.sbamdc.model.impl.CardBoxImpl;
import de.ki.sbamdc.model.impl.CardBoxModelImpl;
import de.ki.sbamdc.service.persistence.CardBoxPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the card box service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see CardBoxPersistence
 * @see de.ki.sbamdc.service.persistence.CardBoxUtil
 * @generated
 */
@ProviderType
public class CardBoxPersistenceImpl extends BasePersistenceImpl<CardBox>
	implements CardBoxPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CardBoxUtil} to access the card box persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CardBoxImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxModelImpl.FINDER_CACHE_ENABLED, CardBoxImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxModelImpl.FINDER_CACHE_ENABLED, CardBoxImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxModelImpl.FINDER_CACHE_ENABLED, CardBoxImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			CardBoxModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the card box where name = &#63; or throws a {@link NoSuchCardBoxException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching card box
	 * @throws NoSuchCardBoxException if a matching card box could not be found
	 */
	@Override
	public CardBox findByName(String name) throws NoSuchCardBoxException {
		CardBox cardBox = fetchByName(name);

		if (cardBox == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCardBoxException(msg.toString());
		}

		return cardBox;
	}

	/**
	 * Returns the card box where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching card box, or <code>null</code> if a matching card box could not be found
	 */
	@Override
	public CardBox fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the card box where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching card box, or <code>null</code> if a matching card box could not be found
	 */
	@Override
	public CardBox fetchByName(String name, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof CardBox) {
			CardBox cardBox = (CardBox)result;

			if (!Objects.equals(name, cardBox.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CARDBOX_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<CardBox> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CardBoxPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CardBox cardBox = list.get(0);

					result = cardBox;

					cacheResult(cardBox);

					if ((cardBox.getName() == null) ||
							!cardBox.getName().equals(name)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, cardBox);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, finderArgs);

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
			return (CardBox)result;
		}
	}

	/**
	 * Removes the card box where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the card box that was removed
	 */
	@Override
	public CardBox removeByName(String name) throws NoSuchCardBoxException {
		CardBox cardBox = findByName(name);

		return remove(cardBox);
	}

	/**
	 * Returns the number of card boxs where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching card boxs
	 */
	@Override
	public int countByName(String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CARDBOX_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "cardBox.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "cardBox.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(cardBox.name IS NULL OR cardBox.name = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_AUTHOR = new FinderPath(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxModelImpl.FINDER_CACHE_ENABLED, CardBoxImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByAuthor",
			new String[] { String.class.getName() },
			CardBoxModelImpl.AUTHOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHOR = new FinderPath(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthor",
			new String[] { String.class.getName() });

	/**
	 * Returns the card box where author = &#63; or throws a {@link NoSuchCardBoxException} if it could not be found.
	 *
	 * @param author the author
	 * @return the matching card box
	 * @throws NoSuchCardBoxException if a matching card box could not be found
	 */
	@Override
	public CardBox findByAuthor(String author) throws NoSuchCardBoxException {
		CardBox cardBox = fetchByAuthor(author);

		if (cardBox == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("author=");
			msg.append(author);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCardBoxException(msg.toString());
		}

		return cardBox;
	}

	/**
	 * Returns the card box where author = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param author the author
	 * @return the matching card box, or <code>null</code> if a matching card box could not be found
	 */
	@Override
	public CardBox fetchByAuthor(String author) {
		return fetchByAuthor(author, true);
	}

	/**
	 * Returns the card box where author = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param author the author
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching card box, or <code>null</code> if a matching card box could not be found
	 */
	@Override
	public CardBox fetchByAuthor(String author, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { author };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_AUTHOR,
					finderArgs, this);
		}

		if (result instanceof CardBox) {
			CardBox cardBox = (CardBox)result;

			if (!Objects.equals(author, cardBox.getAuthor())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CARDBOX_WHERE);

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAuthor) {
					qPos.add(author);
				}

				List<CardBox> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_AUTHOR,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CardBoxPersistenceImpl.fetchByAuthor(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CardBox cardBox = list.get(0);

					result = cardBox;

					cacheResult(cardBox);

					if ((cardBox.getAuthor() == null) ||
							!cardBox.getAuthor().equals(author)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_AUTHOR,
							finderArgs, cardBox);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_AUTHOR, finderArgs);

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
			return (CardBox)result;
		}
	}

	/**
	 * Removes the card box where author = &#63; from the database.
	 *
	 * @param author the author
	 * @return the card box that was removed
	 */
	@Override
	public CardBox removeByAuthor(String author) throws NoSuchCardBoxException {
		CardBox cardBox = findByAuthor(author);

		return remove(cardBox);
	}

	/**
	 * Returns the number of card boxs where author = &#63;.
	 *
	 * @param author the author
	 * @return the number of matching card boxs
	 */
	@Override
	public int countByAuthor(String author) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHOR;

		Object[] finderArgs = new Object[] { author };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CARDBOX_WHERE);

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAuthor) {
					qPos.add(author);
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

	private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_1 = "cardBox.author IS NULL";
	private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_2 = "cardBox.author = ?";
	private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_3 = "(cardBox.author IS NULL OR cardBox.author = '')";

	public CardBoxPersistenceImpl() {
		setModelClass(CardBox.class);
	}

	/**
	 * Caches the card box in the entity cache if it is enabled.
	 *
	 * @param cardBox the card box
	 */
	@Override
	public void cacheResult(CardBox cardBox) {
		entityCache.putResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxImpl.class, cardBox.getPrimaryKey(), cardBox);

		finderCache.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { cardBox.getName() }, cardBox);

		finderCache.putResult(FINDER_PATH_FETCH_BY_AUTHOR,
			new Object[] { cardBox.getAuthor() }, cardBox);

		cardBox.resetOriginalValues();
	}

	/**
	 * Caches the card boxs in the entity cache if it is enabled.
	 *
	 * @param cardBoxs the card boxs
	 */
	@Override
	public void cacheResult(List<CardBox> cardBoxs) {
		for (CardBox cardBox : cardBoxs) {
			if (entityCache.getResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
						CardBoxImpl.class, cardBox.getPrimaryKey()) == null) {
				cacheResult(cardBox);
			}
			else {
				cardBox.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all card boxs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CardBoxImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the card box.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CardBox cardBox) {
		entityCache.removeResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxImpl.class, cardBox.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CardBoxModelImpl)cardBox);
	}

	@Override
	public void clearCache(List<CardBox> cardBoxs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CardBox cardBox : cardBoxs) {
			entityCache.removeResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
				CardBoxImpl.class, cardBox.getPrimaryKey());

			clearUniqueFindersCache((CardBoxModelImpl)cardBox);
		}
	}

	protected void cacheUniqueFindersCache(CardBoxModelImpl cardBoxModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { cardBoxModelImpl.getName() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				cardBoxModelImpl);

			args = new Object[] { cardBoxModelImpl.getAuthor() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_AUTHOR, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_AUTHOR, args,
				cardBoxModelImpl);
		}
		else {
			if ((cardBoxModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cardBoxModelImpl.getName() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					cardBoxModelImpl);
			}

			if ((cardBoxModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_AUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cardBoxModelImpl.getAuthor() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_AUTHOR, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_AUTHOR, args,
					cardBoxModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(CardBoxModelImpl cardBoxModelImpl) {
		Object[] args = new Object[] { cardBoxModelImpl.getName() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((cardBoxModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { cardBoxModelImpl.getOriginalName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}

		args = new Object[] { cardBoxModelImpl.getAuthor() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_AUTHOR, args);

		if ((cardBoxModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_AUTHOR.getColumnBitmask()) != 0) {
			args = new Object[] { cardBoxModelImpl.getOriginalAuthor() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_AUTHOR, args);
		}
	}

	/**
	 * Creates a new card box with the primary key. Does not add the card box to the database.
	 *
	 * @param id the primary key for the new card box
	 * @return the new card box
	 */
	@Override
	public CardBox create(long id) {
		CardBox cardBox = new CardBoxImpl();

		cardBox.setNew(true);
		cardBox.setPrimaryKey(id);

		cardBox.setCompanyId(companyProvider.getCompanyId());

		return cardBox;
	}

	/**
	 * Removes the card box with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the card box
	 * @return the card box that was removed
	 * @throws NoSuchCardBoxException if a card box with the primary key could not be found
	 */
	@Override
	public CardBox remove(long id) throws NoSuchCardBoxException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the card box with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the card box
	 * @return the card box that was removed
	 * @throws NoSuchCardBoxException if a card box with the primary key could not be found
	 */
	@Override
	public CardBox remove(Serializable primaryKey)
		throws NoSuchCardBoxException {
		Session session = null;

		try {
			session = openSession();

			CardBox cardBox = (CardBox)session.get(CardBoxImpl.class, primaryKey);

			if (cardBox == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCardBoxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cardBox);
		}
		catch (NoSuchCardBoxException nsee) {
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
	protected CardBox removeImpl(CardBox cardBox) {
		cardBox = toUnwrappedModel(cardBox);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cardBox)) {
				cardBox = (CardBox)session.get(CardBoxImpl.class,
						cardBox.getPrimaryKeyObj());
			}

			if (cardBox != null) {
				session.delete(cardBox);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cardBox != null) {
			clearCache(cardBox);
		}

		return cardBox;
	}

	@Override
	public CardBox updateImpl(CardBox cardBox) {
		cardBox = toUnwrappedModel(cardBox);

		boolean isNew = cardBox.isNew();

		CardBoxModelImpl cardBoxModelImpl = (CardBoxModelImpl)cardBox;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (cardBox.getCreateDate() == null)) {
			if (serviceContext == null) {
				cardBox.setCreateDate(now);
			}
			else {
				cardBox.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!cardBoxModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cardBox.setModifiedDate(now);
			}
			else {
				cardBox.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (cardBox.isNew()) {
				session.save(cardBox);

				cardBox.setNew(false);
			}
			else {
				cardBox = (CardBox)session.merge(cardBox);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CardBoxModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
			CardBoxImpl.class, cardBox.getPrimaryKey(), cardBox, false);

		clearUniqueFindersCache(cardBoxModelImpl);
		cacheUniqueFindersCache(cardBoxModelImpl, isNew);

		cardBox.resetOriginalValues();

		return cardBox;
	}

	protected CardBox toUnwrappedModel(CardBox cardBox) {
		if (cardBox instanceof CardBoxImpl) {
			return cardBox;
		}

		CardBoxImpl cardBoxImpl = new CardBoxImpl();

		cardBoxImpl.setNew(cardBox.isNew());
		cardBoxImpl.setPrimaryKey(cardBox.getPrimaryKey());

		cardBoxImpl.setId(cardBox.getId());
		cardBoxImpl.setGroupId(cardBox.getGroupId());
		cardBoxImpl.setCompanyId(cardBox.getCompanyId());
		cardBoxImpl.setUserId(cardBox.getUserId());
		cardBoxImpl.setUserName(cardBox.getUserName());
		cardBoxImpl.setCreateDate(cardBox.getCreateDate());
		cardBoxImpl.setModifiedDate(cardBox.getModifiedDate());
		cardBoxImpl.setName(cardBox.getName());
		cardBoxImpl.setAuthor(cardBox.getAuthor());
		cardBoxImpl.setShared(cardBox.isShared());

		return cardBoxImpl;
	}

	/**
	 * Returns the card box with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the card box
	 * @return the card box
	 * @throws NoSuchCardBoxException if a card box with the primary key could not be found
	 */
	@Override
	public CardBox findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCardBoxException {
		CardBox cardBox = fetchByPrimaryKey(primaryKey);

		if (cardBox == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCardBoxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cardBox;
	}

	/**
	 * Returns the card box with the primary key or throws a {@link NoSuchCardBoxException} if it could not be found.
	 *
	 * @param id the primary key of the card box
	 * @return the card box
	 * @throws NoSuchCardBoxException if a card box with the primary key could not be found
	 */
	@Override
	public CardBox findByPrimaryKey(long id) throws NoSuchCardBoxException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the card box with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the card box
	 * @return the card box, or <code>null</code> if a card box with the primary key could not be found
	 */
	@Override
	public CardBox fetchByPrimaryKey(Serializable primaryKey) {
		CardBox cardBox = (CardBox)entityCache.getResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
				CardBoxImpl.class, primaryKey);

		if (cardBox == _nullCardBox) {
			return null;
		}

		if (cardBox == null) {
			Session session = null;

			try {
				session = openSession();

				cardBox = (CardBox)session.get(CardBoxImpl.class, primaryKey);

				if (cardBox != null) {
					cacheResult(cardBox);
				}
				else {
					entityCache.putResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
						CardBoxImpl.class, primaryKey, _nullCardBox);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
					CardBoxImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cardBox;
	}

	/**
	 * Returns the card box with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the card box
	 * @return the card box, or <code>null</code> if a card box with the primary key could not be found
	 */
	@Override
	public CardBox fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, CardBox> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CardBox> map = new HashMap<Serializable, CardBox>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CardBox cardBox = fetchByPrimaryKey(primaryKey);

			if (cardBox != null) {
				map.put(primaryKey, cardBox);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			CardBox cardBox = (CardBox)entityCache.getResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
					CardBoxImpl.class, primaryKey);

			if (cardBox == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, cardBox);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CARDBOX_WHERE_PKS_IN);

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

			for (CardBox cardBox : (List<CardBox>)q.list()) {
				map.put(cardBox.getPrimaryKeyObj(), cardBox);

				cacheResult(cardBox);

				uncachedPrimaryKeys.remove(cardBox.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CardBoxModelImpl.ENTITY_CACHE_ENABLED,
					CardBoxImpl.class, primaryKey, _nullCardBox);
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
	 * Returns all the card boxs.
	 *
	 * @return the card boxs
	 */
	@Override
	public List<CardBox> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CardBox> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CardBox> findAll(int start, int end,
		OrderByComparator<CardBox> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CardBox> findAll(int start, int end,
		OrderByComparator<CardBox> orderByComparator, boolean retrieveFromCache) {
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

		List<CardBox> list = null;

		if (retrieveFromCache) {
			list = (List<CardBox>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CARDBOX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CARDBOX;

				if (pagination) {
					sql = sql.concat(CardBoxModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CardBox>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CardBox>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the card boxs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CardBox cardBox : findAll()) {
			remove(cardBox);
		}
	}

	/**
	 * Returns the number of card boxs.
	 *
	 * @return the number of card boxs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CARDBOX);

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
		return CardBoxModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the card box persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CardBoxImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_CARDBOX = "SELECT cardBox FROM CardBox cardBox";
	private static final String _SQL_SELECT_CARDBOX_WHERE_PKS_IN = "SELECT cardBox FROM CardBox cardBox WHERE id_ IN (";
	private static final String _SQL_SELECT_CARDBOX_WHERE = "SELECT cardBox FROM CardBox cardBox WHERE ";
	private static final String _SQL_COUNT_CARDBOX = "SELECT COUNT(cardBox) FROM CardBox cardBox";
	private static final String _SQL_COUNT_CARDBOX_WHERE = "SELECT COUNT(cardBox) FROM CardBox cardBox WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cardBox.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CardBox exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CardBox exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CardBoxPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static final CardBox _nullCardBox = new CardBoxImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CardBox> toCacheModel() {
				return _nullCardBoxCacheModel;
			}
		};

	private static final CacheModel<CardBox> _nullCardBoxCacheModel = new CacheModel<CardBox>() {
			@Override
			public CardBox toEntityModel() {
				return _nullCardBox;
			}
		};
}