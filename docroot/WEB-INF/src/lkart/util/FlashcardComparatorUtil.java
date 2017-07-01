package lkart.util;

import java.util.Comparator;

import de.ki.sbamdc.model.Flashcard;

public class FlashcardComparatorUtil {

	public static Comparator<Flashcard> getComparator(String column, String type) {
		Comparator<Flashcard> comparator = null;
		switch (column) {
		case "Bezeichnung":
			comparator = new TitleComparator();
			break;
		case "Lernkartei":
			comparator = new CardBoxComparator();
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
		public int compare(Flashcard f1, Flashcard f2) {
			return Long.compare(f1.getId(),f2.getId());
		}

	}
	private static class TitleComparator implements Comparator<Flashcard> {

		@Override
		public int compare(Flashcard f1, Flashcard f2) {
			return f1.getTitle().toLowerCase().compareTo(f2.getTitle().toLowerCase());
		}

	}
	
	private static class CardBoxComparator implements Comparator<Flashcard> {

		@Override
		public int compare(Flashcard f1, Flashcard f2) {
			return Long.compare(f1.getCardBoxId_fk(), f2.getCardBoxId_fk());
		}
		
	}
}
