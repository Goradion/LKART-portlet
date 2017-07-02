package lkart.util;

import java.util.Comparator;

import de.ki.sbamdc.model.CardBox;

public class CardBoxComparatorUtil {

	public static Comparator<CardBox> getComparator(String column, String type) {
		Comparator<CardBox> comparator = null;
		switch (column) {
		case "Name":
			comparator = new NameComparator();
			break;
		case "Geteilt":
			comparator = new SharedComparator();
		default:
			comparator = new IdComparator();
			break;
		}
		if (type == null || type.equals("asc")){
			return comparator;
		} else {
			return comparator.reversed();
		}
		
	}

	private static class IdComparator implements Comparator<CardBox> {

		@Override
		public int compare(CardBox c1, CardBox c2) {
			return Long.compare(c1.getId(),c2.getId());
		}

	}
	private static class NameComparator implements Comparator<CardBox> {

		@Override
		public int compare(CardBox c1, CardBox c2) {
			return c1.getName().toLowerCase().compareTo(c2.getName().toLowerCase());
		}

	}

	public static class SharedComparator implements Comparator<CardBox> {
		@Override
		public int compare(CardBox o1, CardBox o2) {
			return Boolean.compare(o1.getShared(), o2.getShared());
		}

	}
}
