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

package de.ki.sbamdc.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import de.ki.sbamdc.model.Flashcard;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Flashcard in entity cache.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see Flashcard
 * @generated
 */
@ProviderType
public class FlashcardCacheModel implements CacheModel<Flashcard>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlashcardCacheModel)) {
			return false;
		}

		FlashcardCacheModel flashcardCacheModel = (FlashcardCacheModel)obj;

		if (id == flashcardCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", question_txt=");
		sb.append(question_txt);
		sb.append(", question_pct=");
		sb.append(question_pct);
		sb.append(", answer_txt=");
		sb.append(answer_txt);
		sb.append(", answer_pct=");
		sb.append(answer_pct);
		sb.append(", cardBoxId=");
		sb.append(cardBoxId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Flashcard toEntityModel() {
		FlashcardImpl flashcardImpl = new FlashcardImpl();

		flashcardImpl.setId(id);

		if (question_txt == null) {
			flashcardImpl.setQuestion_txt(StringPool.BLANK);
		}
		else {
			flashcardImpl.setQuestion_txt(question_txt);
		}

		if (question_pct == null) {
			flashcardImpl.setQuestion_pct(StringPool.BLANK);
		}
		else {
			flashcardImpl.setQuestion_pct(question_pct);
		}

		if (answer_txt == null) {
			flashcardImpl.setAnswer_txt(StringPool.BLANK);
		}
		else {
			flashcardImpl.setAnswer_txt(answer_txt);
		}

		if (answer_pct == null) {
			flashcardImpl.setAnswer_pct(StringPool.BLANK);
		}
		else {
			flashcardImpl.setAnswer_pct(answer_pct);
		}

		flashcardImpl.setCardBoxId(cardBoxId);

		flashcardImpl.resetOriginalValues();

		return flashcardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		question_txt = objectInput.readUTF();
		question_pct = objectInput.readUTF();
		answer_txt = objectInput.readUTF();
		answer_pct = objectInput.readUTF();

		cardBoxId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (question_txt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question_txt);
		}

		if (question_pct == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question_pct);
		}

		if (answer_txt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer_txt);
		}

		if (answer_pct == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer_pct);
		}

		objectOutput.writeLong(cardBoxId);
	}

	public long id;
	public String question_txt;
	public String question_pct;
	public String answer_txt;
	public String answer_pct;
	public long cardBoxId;
}