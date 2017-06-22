package lkart.portlet;

import static lkart.util.Constants.CARDBOX_OVERVIEW_JSP;
import static lkart.util.Constants.EDIT_CARDBOX_JSP;
import static lkart.util.Constants.EDIT_CONTENT_JSP;
import static lkart.util.Constants.EDIT_FLASHCARD_JSP;
import static lkart.util.Constants.FLASHCARD_OVERVIEW_JSP;
import static lkart.util.Constants.LEARN_JSP;
import static lkart.util.Constants.LEARN_MENU_JSP;
import static lkart.util.Constants.NEW_CARDBOX_JSP;
import static lkart.util.Constants.NEW_FLASHCARD_JSP;
import static lkart.util.Constants.VIEW_JSP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import de.ki.sbamdc.exception.NoSuchCardBoxException;
import de.ki.sbamdc.exception.NoSuchFlashcardException;
import de.ki.sbamdc.model.CardBox;
import de.ki.sbamdc.model.Flashcard;
import de.ki.sbamdc.model.LearnProgress;
import de.ki.sbamdc.service.CardBoxLocalServiceUtil;
import de.ki.sbamdc.service.FlashcardLocalServiceUtil;
import de.ki.sbamdc.service.LearnProgressLocalServiceUtil;

public class LernkarteiPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(LernkarteiPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletContext portletContext = this.getPortletContext();
		PortletRequestDispatcher portletRequestDispatcher = portletContext.getRequestDispatcher(VIEW_JSP);
		Object o = renderRequest.getPortletSession().getAttribute("currentPage", PortletSession.PORTLET_SCOPE);
		String curPage = VIEW_JSP;
		if (o != null) {
			curPage = o.toString();
			portletRequestDispatcher = portletContext.getRequestDispatcher(curPage);
		}
		portletRequestDispatcher.include(renderRequest, renderResponse);

	}

	public void toMainMenu(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", VIEW_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void toEditMode(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_CONTENT_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void toLearnMenue(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<CardBox> learnableBoxes = CardBoxLocalServiceUtil
				.findLearnableCardBoxes(getThemeDisplay(actionRequest).getUserId());
		actionRequest.getPortletSession().setAttribute("cardBoxList", learnableBoxes, PortletSession.APPLICATION_SCOPE);
		actionRequest.getPortletSession().setAttribute("currentPage", LEARN_MENU_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void toLearnMode(ActionRequest actionRequest, ActionResponse actionResponse) {
		long cardBoxId = ParamUtil.getLong(actionRequest, "kartei");
		// String[] split = cardBoxIdString.split(".");
		try {
			CardBox chosenCardBox = CardBoxLocalServiceUtil.fetchCardBox(cardBoxId);
			// if (split.length == 2) {
			// System.out.println(cardBoxIdString);
			// chosenCardBox =
			// CardBoxLocalServiceUtil.findByNameAndUserName(split[0],
			// split[1]);
			// }
			if (chosenCardBox != null) {
				List<Flashcard> flashcards = FlashcardLocalServiceUtil.findByCardBoxId(chosenCardBox.getId());
				long userId = getThemeDisplay(actionRequest).getUserId();
				HashMap<Long, LearnProgress> progressMap = LearnProgressLocalServiceUtil
						.loadProgressByUserIdAndCardBoxId(userId, chosenCardBox.getId());
				LeitnerProgress leitnerProgress = new LeitnerProgress(progressMap);
				Queue<Flashcard> progress0Flashcards = new LinkedList<>();
				Queue<Flashcard> progress1Flashcards = new LinkedList<>();
				Queue<Flashcard> progress2Flashcards = new LinkedList<>();
				Queue<Flashcard> progress3Flashcards = new LinkedList<>();
				Queue<Flashcard> progress4Flashcards = new LinkedList<>();
				leitnerProgress.add(progress0Flashcards);
				leitnerProgress.add(progress1Flashcards);
				leitnerProgress.add(progress2Flashcards);
				leitnerProgress.add(progress3Flashcards);
				leitnerProgress.add(progress4Flashcards);
				// if the CardBox is shared by a different User, the current
				// user might not have any learnProgress records for the
				// flashcards
				for (Flashcard flashcard : flashcards) {
					if (!progressMap.containsKey(flashcard.getId())) {
						LearnProgress newLearnProgress = LearnProgressLocalServiceUtil.addLearnProgress(userId,
								flashcard);
						progressMap.put(flashcard.getId(), newLearnProgress);
					}
					int progress = progressMap.get(flashcard.getId()).getProgress();
					if (progress >= 0 && progress <= 4) {
						leitnerProgress.get(progress).add(flashcard);
					} else {
						log.warn("Invalid progress for flashcard with id " + flashcard.getId() + "! was " + progress
								+ " expected 0<=progress<=4");
					}
				}
				int startProgress = 0;
				for (Queue<Flashcard> q : leitnerProgress){
					if (q.size() != 0){
						break;
					} else {
						startProgress++;
					}
				}
//				actionRequest.getPortletSession().setAttribute("flashcards", flashcards,
//						PortletSession.APPLICATION_SCOPE);
				actionRequest.getPortletSession().setAttribute("progressQueues", leitnerProgress,
						PortletSession.PORTLET_SCOPE);
				actionRequest.getPortletSession().setAttribute("progress", startProgress,
						PortletSession.PORTLET_SCOPE);
				actionRequest.getPortletSession().setAttribute("currentPage", LEARN_JSP, PortletSession.PORTLET_SCOPE);
			} else {
				actionRequest.getPortletSession().setAttribute("currentPage", VIEW_JSP, PortletSession.PORTLET_SCOPE);
				SessionErrors.add(actionRequest, "error");
			}
		} catch (NumberFormatException nfe) {
			// nfe.printStackTrace();//TODO
		}
	}

	/**
	 * navigates to a cardBox overview and clears the portlet session of
	 * attributes of a cardBox
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */

	public void toCardBoxOverview(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", CARDBOX_OVERVIEW_JSP,
				PortletSession.PORTLET_SCOPE);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.removeAttribute("cardBoxId", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("cardBoxName", PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * navigates to a form to create a new cardBox and clears the portlet
	 * session of attributes of a cardBox
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void toNewCardBox(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", NEW_CARDBOX_JSP, PortletSession.PORTLET_SCOPE);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.removeAttribute("cardBoxId", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("cardBoxName", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("cardBoxShared", PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * navigates to a form to edit an existing cardBox and fills the portlet
	 * session with attributes of the cardBox
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void toEditCardbox(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_CARDBOX_JSP, PortletSession.PORTLET_SCOPE);
		fillCardBoxEditForm(actionRequest, actionResponse);
	}

	/**
	 * fills the portlet session with attributes of the cardBox to use in a page
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	private void fillCardBoxEditForm(ActionRequest actionRequest, ActionResponse actionResponse) {
		String cardBoxId = actionRequest.getParameter("cardBoxId");
		try {
			CardBox cardBox = CardBoxLocalServiceUtil.getCardBox(Long.parseLong(cardBoxId));
			PortletSession portletSession = actionRequest.getPortletSession();
			portletSession.setAttribute("cardBoxId", cardBox.getId(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("cardBoxName", cardBox.getName(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("cardBoxShared", cardBox.isShared(), PortletSession.APPLICATION_SCOPE);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toFlashcardOverview(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", FLASHCARD_OVERVIEW_JSP,
				PortletSession.PORTLET_SCOPE);
	}

	/**
	 * Sets the next view to NEW_FLASHCARD_JSP and passes the card boxes of the
	 * current user to it
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void toNewFlashcard(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", NEW_FLASHCARD_JSP, PortletSession.PORTLET_SCOPE);

		List<CardBox> cardBoxList = getMyCardboxes(getThemeDisplay(actionRequest).getUserId());
		actionRequest.getPortletSession().setAttribute("cardBoxList", cardBoxList, PortletSession.APPLICATION_SCOPE);

	}

	private ThemeDisplay getThemeDisplay(ActionRequest actionRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay;
	}

	private List<CardBox> getMyCardboxes(long userId) {
		int end = CardBoxLocalServiceUtil.getCardBoxesCountOfUser(userId);
		return CardBoxLocalServiceUtil.getCardBoxesOfUser(userId, 0, end);
	}

	/**
	 * Sets the next view to EDIT_FLASHCARD_JSP and passes the flashcard and
	 * cardboxes of current user to it
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void toEditFlashcard(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_FLASHCARD_JSP, PortletSession.PORTLET_SCOPE);
		
		ThemeDisplay td = getThemeDisplay(actionRequest);
		List<CardBox> cardBoxList = getMyCardboxes(td.getUserId());
		actionRequest.getPortletSession().setAttribute("cardBoxList", cardBoxList, PortletSession.PORTLET_SCOPE);

		// actionRequest.getPortletSession().setAttribute("fcId", "" + fcId,
		// PortletSession.PORTLET_SCOPE);

		try {
			long fcId = Long.parseLong(actionRequest.getParameter("fcId"));
			Flashcard fc = FlashcardLocalServiceUtil.getFlashcard(fcId);
			String fcFrontSide = fc.getFrontSide();
			String fcBackSide = fc.getBackSide();
			String fcTitle = fc.getTitle();

			actionRequest.getPortletSession().setAttribute("cardBoxName",
					CardBoxLocalServiceUtil.getCardBox(fc.getCardBoxId_fk()).getName());
			actionRequest.getPortletSession().setAttribute("fcFrontSide", fcFrontSide);
			actionRequest.getPortletSession().setAttribute("fcBackSide", fcBackSide);
			actionRequest.getPortletSession().setAttribute("fcTitle", fcTitle);
			actionRequest.getPortletSession().setAttribute("fcId", ""+fcId);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Creates a new flashcard.
	 * On submit if the flashcard cannot be created the filled out fields keep their content.
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void createNewFlashcard(ActionRequest actionRequest, ActionResponse actionResponse) {
		String fcFrontSide = actionRequest.getParameter("fcFrontSide");
		String fcBackSide = actionRequest.getParameter("fcBackSide");
		String cardBoxName = actionRequest.getParameter("kartei");
		String flashcardTitle = actionRequest.getParameter("flashcardTitle");
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		CardBox cardbox = CardBoxLocalServiceUtil.findByNameAndUserId(cardBoxName, userId);
		long cardBoxId = -1;
		if (cardbox != null)
			cardBoxId = cardbox.getId();

		if (!(cardBoxId < 0)) {
			try {
				if (!fcFrontSide.isEmpty()) {
					Flashcard fc = FlashcardLocalServiceUtil.fetchByCardBoxIdAndTitle(cardBoxId, flashcardTitle);
					if(fc==null){
						Flashcard newFlashcard = FlashcardLocalServiceUtil.addFlashcard(fcFrontSide, fcBackSide,
								flashcardTitle, cardBoxId, userId);
						LearnProgressLocalServiceUtil.addLearnProgress(userId, newFlashcard);
						SessionMessages.add(actionRequest, "success");
					}else {
						actionRequest.getPortletSession().setAttribute("fcFrontSide", fcFrontSide);
						actionRequest.getPortletSession().setAttribute("fcBackSide", fcBackSide);
						actionRequest.getPortletSession().setAttribute("kartei", cardBoxName);
						actionRequest.getPortletSession().setAttribute("flashcardTitle", flashcardTitle);
						List<CardBox> cardBoxList = getMyCardboxes(td.getUserId());
						actionRequest.getPortletSession().setAttribute("cardBoxList", cardBoxList, PortletSession.PORTLET_SCOPE);
						SessionErrors.add(actionRequest, "titleExistsError");
					}
				}
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				SessionErrors.add(actionRequest, "error");
			} 
		}

	}

	/**
	 * Updates a flashcard.
	 * On submit if the flashcard cannot be updated the filled out fields keep their content.
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void updateFlashcard(ActionRequest actionRequest, ActionResponse actionResponse) {
		// actionRequest.getPortletSession().setAttribute("currentPage",
		// FLASHCARD_OVERVIEW_JSP,
		// PortletSession.PORTLET_SCOPE);
		try {
			String fcFrontSide = actionRequest.getParameter("fcFrontSide");
			String fcBackSide = actionRequest.getParameter("fcBackSide");
			String cardBoxName = actionRequest.getParameter("kartei");
			String flashcardTitle = actionRequest.getParameter("flashcardTitle");
			long fcId = Long.parseLong(actionRequest.getParameter("fcId"));

			ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long uid = td.getUserId();

			long cardBoxId = CardBoxLocalServiceUtil.findByNameAndUserId(cardBoxName, uid).getId();

			Flashcard fc = FlashcardLocalServiceUtil.fetchByCardBoxIdAndTitle(cardBoxId, flashcardTitle);
			
			// noch keine karte oder die karte ist die die gerade bearbeitet wird
			if(fc==null || fc.getId()==fcId){
				FlashcardLocalServiceUtil.updateFlashcard(fcFrontSide, fcBackSide, flashcardTitle, fcId, cardBoxId);
				SessionMessages.add(actionRequest, "success");
				toEditFlashcard(actionRequest, actionResponse);
			} else {
				List<CardBox> cardBoxList = getMyCardboxes(uid);
				actionRequest.getPortletSession().setAttribute("cardBoxList", cardBoxList, PortletSession.PORTLET_SCOPE);
				actionRequest.getPortletSession().setAttribute("fcFrontSide", fcFrontSide, PortletSession.PORTLET_SCOPE);
				actionRequest.getPortletSession().setAttribute("fcBackSide", fcBackSide, PortletSession.PORTLET_SCOPE);
				actionRequest.getPortletSession().setAttribute("fcTitle", flashcardTitle, PortletSession.PORTLET_SCOPE);
				actionRequest.getPortletSession().setAttribute("fcId", ""+fcId, PortletSession.PORTLET_SCOPE);	
				SessionErrors.add(actionRequest, "titleExistsError");
			}	
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			SessionErrors.add(actionRequest, "error");
		}
	}

	public void saveCardBox(ActionRequest actionRequest, ActionResponse actionResponse) {
		String cardBoxIdString = actionRequest.getParameter("cardBoxId");
		String cardBoxName = actionRequest.getParameter("cardBoxName");
		String shared = actionRequest.getParameter("shared");
		boolean isShared = (shared != null);
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = td.getUser();
		try {
			if (cardBoxIdString == null) {
				if (CardBoxLocalServiceUtil.findByNameAndUserId(cardBoxName, user.getUserId()) != null) {
					actionRequest.setAttribute("error", "Name " + cardBoxName + " bereits vorhanden!");
					toNewCardBox(actionRequest, actionResponse);
				} else {
					CardBoxLocalServiceUtil.addCardBox(cardBoxName, user.getUserId());
				}
			} else {
				long cardBoxId = Long.parseLong(cardBoxIdString);
				CardBox cardBox = CardBoxLocalServiceUtil.getCardBox(cardBoxId);
				cardBox.setName(cardBoxName);
				cardBox.setShared(isShared);
				CardBoxLocalServiceUtil.updateCardBox(cardBox);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toCardBoxOverview(actionRequest, actionResponse);
	}

	public void deleteCardBox(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			long cardBoxId = ParamUtil.getLong(actionRequest, "cardBoxId", -1);
			FlashcardLocalServiceUtil.removeByCardBoxId(cardBoxId);
			CardBoxLocalServiceUtil.deleteCardBox(cardBoxId);
			// TODO delete learnProgress
		} catch (NoSuchCardBoxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteFlashcard(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			long flashcardId = Long.parseLong(actionRequest.getParameter("fcId"));
			FlashcardLocalServiceUtil.deleteFlashcard(flashcardId);
			// TODO delte learnProgress
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test(ActionRequest actionRequest, ActionResponse actionResponse) {
		// FlashcardLocalServiceUtil.getFlashcard(0).get
		// CardBoxLocalServiceUtil.fi
	}

	public void clearCardBoxes(ActionRequest actionRequest, ActionResponse actionResponse) {
		CardBoxLocalServiceUtil.removeAll();
	}

	public void clearUser(ActionRequest actionRequest, ActionResponse actionResponse) {
		CardBoxLocalServiceUtil.removeByUserId(ParamUtil.getLong(actionRequest, "userId"));
	}

	public void submitLeitner(ActionRequest actionRequest, ActionResponse actionResponse) {
		int progress = (int) actionRequest.getPortletSession().getAttribute("progress");
		boolean known = ParamUtil.getBoolean(actionRequest, "known");
		long userId = getThemeDisplay(actionRequest).getUserId();
		LeitnerProgress leitnerProgress = (LeitnerProgress) actionRequest.getPortletSession().getAttribute("progressQueues");

		if (leitnerProgress != null && progress >= 0 && progress < leitnerProgress.size()) {
			Flashcard flashcard = leitnerProgress.get(progress).poll();
			if (flashcard != null) {
				LearnProgress learnProgress = leitnerProgress.getProgressMap().get(flashcard.getId());
				if (learnProgress == null) {
					learnProgress = LearnProgressLocalServiceUtil.addLearnProgress(userId, flashcard);
					leitnerProgress.getProgressMap().put(flashcard.getId(), learnProgress);
				}
				if (known) {
					if (progress < 4) {
						progress++;
					}
				} else {
					progress = 0;
				}
				Queue<Flashcard> queue = leitnerProgress.get(progress);
				queue.add(flashcard);
				learnProgress.setProgress(progress);
				LearnProgressLocalServiceUtil.updateLearnProgress(learnProgress);
			}
		}
	}
	
	public void chooseProgress(ActionRequest actionRequest, ActionResponse actionResponse) {
		int newProgress = ParamUtil.getInteger(actionRequest, "progress",0);
		actionRequest.getPortletSession().setAttribute("progress", newProgress);
	}
}
