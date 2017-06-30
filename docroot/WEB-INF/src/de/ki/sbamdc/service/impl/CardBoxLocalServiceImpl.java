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

package de.ki.sbamdc.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import aQute.bnd.annotation.ProviderType;
import de.ki.sbamdc.model.CardBox;
import de.ki.sbamdc.service.base.CardBoxLocalServiceBaseImpl;

/**
 * The implementation of the card box local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link de.ki.sbamdc.service.CardBoxLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see CardBoxLocalServiceBaseImpl
 * @see de.ki.sbamdc.service.CardBoxLocalServiceUtil
 */
@ProviderType
public class CardBoxLocalServiceImpl extends CardBoxLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * de.ki.sbamdc.service.CardBoxLocalServiceUtil} to access the card box
	 * local service.
	 */

	public CardBox findByNameAndUserId(String name, long userId) {
		return cardBoxPersistence.fetchByNameAndUserId(name, userId);
	}

	public CardBox findByNameAndUserName(String name, String userName) {
		return cardBoxPersistence.fetchByNameAndUserName(name, userName);
	}

	public SortedMap<String,List<CardBox>> findLearnableCardBoxes(long userId) throws PortalException {
		SortedMap<String,List<CardBox>> cardBoxesOfUsers = new TreeMap<>();
		List<CardBox> own = cardBoxPersistence.findByUserId(userId);
		UserLocalServiceUtil.getUser(userId).getScreenName();
		cardBoxesOfUsers.put("Eigene", own);
		List<CardBox> foreignAndShared = cardBoxPersistence.findByForeignAndShared(userId);
		for (CardBox cardBox : foreignAndShared){
			if (cardBoxesOfUsers.containsKey(cardBox.getUserName())){
				cardBoxesOfUsers.get(cardBox.getUserName()).add(cardBox);
			} else {
				List<CardBox> cardBoxesOfUser = new ArrayList<>();
				cardBoxesOfUser.add(cardBox);
				cardBoxesOfUsers.put(cardBox.getUserName(), cardBoxesOfUser);
			}
		}
		return Collections.unmodifiableSortedMap(cardBoxesOfUsers);
	}

	public List<CardBox> findByUserId(long userId){
		return cardBoxPersistence.findByUserId(userId);
	}
	public List<CardBox> getCardBoxesOfUser(long userId, int start, int end) {
		return cardBoxPersistence.findByUserId(userId, start, end);
	}

	public int getCardBoxesCountOfUser(long userId) {
		return cardBoxPersistence.countByUserId(userId);
	}

	public CardBox addCardBox(String name, long userId) throws PortalException {
		CardBox cardBox = cardBoxPersistence.fetchByNameAndUserId(name, userId);
		if (cardBox == null) {
			long cardBoxId = counterLocalService.increment();
			cardBox = cardBoxPersistence.create(cardBoxId);
			cardBox.setName(name);
			cardBox.setUserId(userId);
			cardBox.setUserName(UserLocalServiceUtil.getUser(userId).getScreenName());
			addCardBox(cardBox);
		}
		return cardBox;
	}

	public void removeByUserId(long userId) {
		flashcardPersistence.removeByUserId(userId);
		learnProgressPersistence.removeByUserId(userId);
		cardBoxPersistence.removeByUserId(userId);
	}

	public void removeAll() {
		flashcardPersistence.removeAll();
		cardBoxPersistence.removeAll();
		learnProgressPersistence.removeAll();
	}

	public void setShared(long id) {
		CardBox cb = cardBoxPersistence.fetchByPrimaryKey(id);
		if (cb != null) {
			cb.setShared(!cb.isShared());
			cardBoxPersistence.update(cb);
		}
	}
}