package lkart.util;

import java.util.Comparator;

import de.ki.sbamdc.model.Flashcard;

public class FlashcardComparatorUtil {

	public static Comparator<Flashcard> getComparator(String column, String type) {
		Comparator<Flashcard> comparator = null;
		switch (column) {
		case "bezeichnung":
			comparator = new TitleComparator();
			break;
		default:
			comparator = new IdComparator();
		}
		if (type == null || type.equals("asc")){
			return comparator;
		} else {
			return comparator.reversed();
		}
		
	}

	private static class IdComparator implements Comparator<Flashcard> {

		@Override
		public int compare(Flashcard c1, Flashcard c2) {
			return Long.compare(c1.getId(),c2.getId());
		}

	}
	private static class TitleComparator implements Comparator<Flashcard> {

		@Override
		public int compare(Flashcard c1, Flashcard c2) {
			return c1.getTitle().compareTo(c2.getTitle());
		}

	}
}
