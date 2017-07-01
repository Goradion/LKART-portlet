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

import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.exception.NoSuchUserException;

import aQute.bnd.annotation.ProviderType;
import de.ki.sbamdc.exception.NoSuchFlashcardException;
import de.ki.sbamdc.exception.NoSuchLearnProgressException;
import de.ki.sbamdc.model.Flashcard;
import de.ki.sbamdc.model.LearnProgress;
import de.ki.sbamdc.service.base.LearnProgressLocalServiceBaseImpl;

/**
 * The implementation of the learn progress local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.ki.sbamdc.service.LearnProgressLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see LearnProgressLocalServiceBaseImpl
 * @see de.ki.sbamdc.service.LearnProgressLocalServiceUtil
 */
@ProviderType
public class LearnProgressLocalServiceImpl
	extends LearnProgressLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link de.ki.sbamdc.service.LearnProgressLocalServiceUtil} to access the learn progress local service.
	 */
	
	public List<LearnProgress> findByUserId(long userId_fk){
		return learnProgressPersistence.findByUserId(userId_fk);
	}
	
	public LearnProgress fetchByUserIdAndFlashcardId(long userId, long flashcardId) {
		 return learnProgressPersistence.fetchByUserIdAndFlashcardId(userId, flashcardId);
	}
	
	public LearnProgress addLearnProgress(long userId, Flashcard flashcard) {
		try {
			userPersistence.findByPrimaryKey(userId);
			flashcardPersistence.findByPrimaryKey(flashcard.getId());
		} catch (NoSuchUserException | NoSuchFlashcardException e) {
			return null;
		}
		
		long id = counterLocalService.increment();
		LearnProgress learnProgress = learnProgressPersistence.create(id);
		learnProgress.setUserId_fk(userId);
		learnProgress.setCardBoxId_fk(flashcard.getCardBoxId_fk());
		learnProgress.setFlashcardId_fk(flashcard.getId());
		return learnProgressPersistence.update(learnProgress);
	}
	
	public void removeByCardBoxId(long cardBoxId){
		learnProgressPersistence.removeByCardBoxId(cardBoxId);
	}
	
	public void removeByUserIdAndFlashcardId(long userId, long flashcardId) throws NoSuchLearnProgressException{
			learnProgressPersistence.removeByUserIdAndFlashcardId(userId, flashcardId);
	}
	
	public HashMap<Long, LearnProgress> loadProgressByUserIdAndCardBoxId(long userId, long cardBoxId){
		HashMap<Long, LearnProgress> progressMap = new HashMap<>();
		List<LearnProgress> cardBoxProgress = learnProgressPersistence.findByCardBoxId(cardBoxId);
		for (LearnProgress learnProgress : cardBoxProgress){
			progressMap.put(learnProgress.getFlashcardId_fk(), learnProgress);
		}
		return progressMap;
	}
}