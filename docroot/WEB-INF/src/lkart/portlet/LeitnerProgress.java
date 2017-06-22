package lkart.portlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

import de.ki.sbamdc.model.Flashcard;
import de.ki.sbamdc.model.LearnProgress;

public class LeitnerProgress extends ArrayList<Queue<Flashcard>>{

	private static final long serialVersionUID = 6051907382827369329L;
	
	private HashMap<Long, LearnProgress> progressMap = null;
	
	public LeitnerProgress(HashMap<Long, LearnProgress> progressMap){
		this.setProgressMap(progressMap);
	}

	public HashMap<Long, LearnProgress> getProgressMap() {
		return progressMap;
	}

	public void setProgressMap(HashMap<Long, LearnProgress> progressMap) {
		this.progressMap = progressMap;
	}
}
