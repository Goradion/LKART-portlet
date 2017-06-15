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

package de.ki.sbamdc.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.ki.sbamdc.service.http.LearnProgressServiceSoap}.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see de.ki.sbamdc.service.http.LearnProgressServiceSoap
 * @generated
 */
@ProviderType
public class LearnProgressSoap implements Serializable {
	public static LearnProgressSoap toSoapModel(LearnProgress model) {
		LearnProgressSoap soapModel = new LearnProgressSoap();

		soapModel.setId(model.getId());
		soapModel.setUserId_fk(model.getUserId_fk());
		soapModel.setCardBoxId_fk(model.getCardBoxId_fk());
		soapModel.setFlashcardId_fk(model.getFlashcardId_fk());
		soapModel.setProgress(model.getProgress());

		return soapModel;
	}

	public static LearnProgressSoap[] toSoapModels(LearnProgress[] models) {
		LearnProgressSoap[] soapModels = new LearnProgressSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LearnProgressSoap[][] toSoapModels(LearnProgress[][] models) {
		LearnProgressSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LearnProgressSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LearnProgressSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LearnProgressSoap[] toSoapModels(List<LearnProgress> models) {
		List<LearnProgressSoap> soapModels = new ArrayList<LearnProgressSoap>(models.size());

		for (LearnProgress model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LearnProgressSoap[soapModels.size()]);
	}

	public LearnProgressSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getUserId_fk() {
		return _userId_fk;
	}

	public void setUserId_fk(long userId_fk) {
		_userId_fk = userId_fk;
	}

	public long getCardBoxId_fk() {
		return _cardBoxId_fk;
	}

	public void setCardBoxId_fk(long cardBoxId_fk) {
		_cardBoxId_fk = cardBoxId_fk;
	}

	public long getFlashcardId_fk() {
		return _flashcardId_fk;
	}

	public void setFlashcardId_fk(long flashcardId_fk) {
		_flashcardId_fk = flashcardId_fk;
	}

	public int getProgress() {
		return _progress;
	}

	public void setProgress(int progress) {
		_progress = progress;
	}

	private long _id;
	private long _userId_fk;
	private long _cardBoxId_fk;
	private long _flashcardId_fk;
	private int _progress;
}