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
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", frontSide=");
		sb.append(frontSide);
		sb.append(", backSide=");
		sb.append(backSide);
		sb.append(", cardBoxId_fk=");
		sb.append(cardBoxId_fk);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Flashcard toEntityModel() {
		FlashcardImpl flashcardImpl = new FlashcardImpl();

		flashcardImpl.setId(id);
		flashcardImpl.setUserId(userId);

		if (frontSide == null) {
			flashcardImpl.setFrontSide(StringPool.BLANK);
		}
		else {
			flashcardImpl.setFrontSide(frontSide);
		}

		if (backSide == null) {
			flashcardImpl.setBackSide(StringPool.BLANK);
		}
		else {
			flashcardImpl.setBackSide(backSide);
		}

		flashcardImpl.setCardBoxId_fk(cardBoxId_fk);

		if (title == null) {
			flashcardImpl.setTitle(StringPool.BLANK);
		}
		else {
			flashcardImpl.setTitle(title);
		}

		flashcardImpl.resetOriginalValues();

		return flashcardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		userId = objectInput.readLong();
		frontSide = objectInput.readUTF();
		backSide = objectInput.readUTF();

		cardBoxId_fk = objectInput.readLong();
		title = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(userId);

		if (frontSide == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(frontSide);
		}

		if (backSide == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(backSide);
		}

		objectOutput.writeLong(cardBoxId_fk);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}
	}

	public long id;
	public long userId;
	public String frontSide;
	public String backSide;
	public long cardBoxId_fk;
	public String title;
}