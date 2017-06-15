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

import de.ki.sbamdc.model.LearnProgress;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing LearnProgress in entity cache.
 *
 * @author Simon Bastian, Alexander Mueller, Diego Castellanos
 * @see LearnProgress
 * @generated
 */
@ProviderType
public class LearnProgressCacheModel implements CacheModel<LearnProgress>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LearnProgressCacheModel)) {
			return false;
		}

		LearnProgressCacheModel learnProgressCacheModel = (LearnProgressCacheModel)obj;

		if (id == learnProgressCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", userId_fk=");
		sb.append(userId_fk);
		sb.append(", cardBoxId_fk=");
		sb.append(cardBoxId_fk);
		sb.append(", flashcardId_fk=");
		sb.append(flashcardId_fk);
		sb.append(", progress=");
		sb.append(progress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LearnProgress toEntityModel() {
		LearnProgressImpl learnProgressImpl = new LearnProgressImpl();

		learnProgressImpl.setId(id);
		learnProgressImpl.setUserId_fk(userId_fk);
		learnProgressImpl.setCardBoxId_fk(cardBoxId_fk);
		learnProgressImpl.setFlashcardId_fk(flashcardId_fk);
		learnProgressImpl.setProgress(progress);

		learnProgressImpl.resetOriginalValues();

		return learnProgressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		userId_fk = objectInput.readLong();

		cardBoxId_fk = objectInput.readLong();

		flashcardId_fk = objectInput.readLong();

		progress = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(userId_fk);

		objectOutput.writeLong(cardBoxId_fk);

		objectOutput.writeLong(flashcardId_fk);

		objectOutput.writeInt(progress);
	}

	public long id;
	public long userId_fk;
	public long cardBoxId_fk;
	public long flashcardId_fk;
	public int progress;
}