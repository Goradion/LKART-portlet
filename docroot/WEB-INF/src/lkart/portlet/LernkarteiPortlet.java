package lkart.portlet;

import static lkart.util.Constants.CARDBOX_OVERVIEW_JSP;
import static lkart.util.Constants.EDIT_CARDBOX_JSP;
import static lkart.util.Constants.EDIT_CONTENT_JSP;
import static lkart.util.Constants.EDIT_FLASHCARD_JSP;
import static lkart.util.Constants.FLASHCARD_OVERVIEW_JSP;
import static lkart.util.Constants.LEARN_JSP;
import static lkart.util.Constants.NEW_CARDBOX_JSP;
import static lkart.util.Constants.NEW_FLASHCARD_JSP;
import static lkart.util.Constants.VIEW_JSP;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import de.ki.sbamdc.exception.NoSuchCardBoxException;
import de.ki.sbamdc.model.CardBox;
import de.ki.sbamdc.model.Flashcard;
import de.ki.sbamdc.service.CardBoxLocalServiceUtil;
import de.ki.sbamdc.service.FlashcardLocalServiceUtil;

public class LernkarteiPortlet extends MVCPortlet {

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

	public void toLearnMode(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", LEARN_JSP, PortletSession.PORTLET_SCOPE);
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

	public void toNewFlashcard(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", NEW_FLASHCARD_JSP, PortletSession.PORTLET_SCOPE);

		List<CardBox> cardBoxList = CardBoxLocalServiceUtil.getCardBoxs(0, CardBoxLocalServiceUtil.getCardBoxsCount());
		actionRequest.getPortletSession().setAttribute("cardBoxList", cardBoxList, PortletSession.APPLICATION_SCOPE);
		
		// Debug
		for(CardBox cb : cardBoxList){
			System.out.println(cb.getName());
		}
		for(Flashcard f : FlashcardLocalServiceUtil.getFlashcards(0, FlashcardLocalServiceUtil.getFlashcardsCount())){
			System.out.println(f.getContent());
		}
	}

	public void toEditFlashcard(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_FLASHCARD_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void createNewFlashcard(ActionRequest actionRequest, ActionResponse actionResponse) {
		String fcContent = actionRequest.getParameter("flashcardEditor");
		String cardBoxName = actionRequest.getParameter("kartei");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// now read your parameters, e.g. like this:
		// long someParameter = ParamUtil.getLong(request, "someParameter");
		long uid = themeDisplay.getUserId();

		

		long cardBoxId = CardBoxLocalServiceUtil.findByNameAndUser(cardBoxName, uid).getId();
		//Debug
		System.out.println(fcContent);
		System.out.println(cardBoxName);
		//
		
		if (!(cardBoxId<0)) {
			try {
				if (!fcContent.isEmpty()) {
					// create and store flashcard in database
					FlashcardLocalServiceUtil.addFlashcard(fcContent, cardBoxId);
				}

			} catch (NumberFormatException nfe) {
				// hier eventuell ein Feedback an User
				nfe.printStackTrace();
			}
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
				if (CardBoxLocalServiceUtil.findByNameAndUser(cardBoxName, user.getUserId()) != null) {
					actionRequest.setAttribute("error", "Name " + cardBoxName + " bereits vorhanden!");
					toNewCardBox(actionRequest, actionResponse);
				} else {
					CardBox cardBox = CardBoxLocalServiceUtil.addCardBox(cardBoxName, user.getUserId());
					CardBoxLocalServiceUtil.addCardBox(cardBox);
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
		String cardBoxId = actionRequest.getParameter("cardBoxId");
		try {
			CardBoxLocalServiceUtil.deleteCardBox(Long.parseLong(cardBoxId));
		} catch (NoSuchCardBoxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void test(ActionRequest actionRequest, ActionResponse actionResponse) {
		// FlashcardLocalServiceUtil.getFlashcard(0).get
		// CardBoxLocalServiceUtil.fi
	}

}
