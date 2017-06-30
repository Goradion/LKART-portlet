package lkart.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class NameComparator extends OrderByComparator<String>{

	private static final long serialVersionUID = -5815030227204146701L;

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}

}
