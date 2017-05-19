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
 * This class is used by SOAP remote services, specifically {@link de.ki.sbamdc.service.http.FlashcardServiceSoap}.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see de.ki.sbamdc.service.http.FlashcardServiceSoap
 * @generated
 */
@ProviderType
public class FlashcardSoap implements Serializable {
	public static FlashcardSoap toSoapModel(Flashcard model) {
		FlashcardSoap soapModel = new FlashcardSoap();

		soapModel.setId(model.getId());
		soapModel.setQuestion_txt(model.getQuestion_txt());
		soapModel.setQuestion_pct(model.getQuestion_pct());
		soapModel.setAnswer_txt(model.getAnswer_txt());
		soapModel.setAnswer_pct(model.getAnswer_pct());
		soapModel.setCardBoxId_fk(model.getCardBoxId_fk());

		return soapModel;
	}

	public static FlashcardSoap[] toSoapModels(Flashcard[] models) {
		FlashcardSoap[] soapModels = new FlashcardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlashcardSoap[][] toSoapModels(Flashcard[][] models) {
		FlashcardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlashcardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlashcardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlashcardSoap[] toSoapModels(List<Flashcard> models) {
		List<FlashcardSoap> soapModels = new ArrayList<FlashcardSoap>(models.size());

		for (Flashcard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlashcardSoap[soapModels.size()]);
	}

	public FlashcardSoap() {
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

	public String getQuestion_txt() {
		return _question_txt;
	}

	public void setQuestion_txt(String question_txt) {
		_question_txt = question_txt;
	}

	public String getQuestion_pct() {
		return _question_pct;
	}

	public void setQuestion_pct(String question_pct) {
		_question_pct = question_pct;
	}

	public String getAnswer_txt() {
		return _answer_txt;
	}

	public void setAnswer_txt(String answer_txt) {
		_answer_txt = answer_txt;
	}

	public String getAnswer_pct() {
		return _answer_pct;
	}

	public void setAnswer_pct(String answer_pct) {
		_answer_pct = answer_pct;
	}

	public long getCardBoxId_fk() {
		return _cardBoxId_fk;
	}

	public void setCardBoxId_fk(long cardBoxId_fk) {
		_cardBoxId_fk = cardBoxId_fk;
	}

	private long _id;
	private String _question_txt;
	private String _question_pct;
	private String _answer_txt;
	private String _answer_pct;
	private long _cardBoxId_fk;
}