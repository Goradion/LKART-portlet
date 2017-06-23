package lkart.portlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import de.ki.sbamdc.model.Flashcard;
import de.ki.sbamdc.model.LearnProgress;

public class LeitnerProgress extends ArrayList<Queue<Flashcard>>{

	private static final long serialVersionUID = 6051907382827369329L;
	
	private HashMap<Long, LearnProgress> progressMap = null;
	
	private List<String> progressColors = new ArrayList<String>(Arrays.asList(new String[]{"red", "orange", "yellow", "skyblue", "green"}));
	
	public LeitnerProgress(HashMap<Long, LearnProgress> progressMap){
		this.setProgressMap(progressMap);
	}

	public HashMap<Long, LearnProgress> getProgressMap() {
		return progressMap;
	}

	public void setProgressMap(HashMap<Long, LearnProgress> progressMap) {
		this.progressMap = progressMap;
	}
	
	public String getColor(int progress){
		if (progressColors != null && progress >= 0 && progress < progressColors.size()){
			return progressColors.get(progress);
		} else {
			return "white";
		}
		
	}
}
