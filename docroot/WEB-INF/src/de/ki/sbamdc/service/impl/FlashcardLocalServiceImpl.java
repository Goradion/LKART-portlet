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

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import de.ki.sbamdc.model.Flashcard;
import de.ki.sbamdc.service.base.FlashcardLocalServiceBaseImpl;

/**
 * The implementation of the flashcard local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.ki.sbamdc.service.FlashcardLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see FlashcardLocalServiceBaseImpl
 * @see de.ki.sbamdc.service.FlashcardLocalServiceUtil
 */
@ProviderType
public class FlashcardLocalServiceImpl extends FlashcardLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link de.ki.sbamdc.service.FlashcardLocalServiceUtil} to access the flashcard local service.
	 */	
	
	public Flashcard addFlashcard(String frontSide,String backSide, String title, long cardBoxId){
		long fcId = counterLocalService.increment();
		Flashcard fc = flashcardPersistence.create(fcId);
		fc.setFrontSide(frontSide);
		fc.setBackSide(backSide);
		fc.setCardBoxId_fk(cardBoxId);
		fc.setTitle(title);
		flashcardPersistence.update(fc);
		return fc;
	}
	
	public Flashcard updateFlashcard(String frontSide,String backSide, String title, long fcId, long cardBoxId){
		Flashcard fc = flashcardPersistence.fetchByPrimaryKey(fcId);
		if(fc!=null){
			fc.setFrontSide(frontSide);
			fc.setBackSide(backSide);
			fc.setCardBoxId_fk(cardBoxId);
			fc.setTitle(title);
			flashcardPersistence.update(fc);
		}
		return fc;
	}
	
	public List<Flashcard> findByCardBoxId(long cardBoxId){
		return flashcardPersistence.findByCardBoxId(cardBoxId);
	}
	
	public void removeByCardBoxId(long id) {
		flashcardPersistence.removeByCardBoxId(id);
	}

}