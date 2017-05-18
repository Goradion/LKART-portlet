package lkart.portlet;

import static lkart.util.Constants.*;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

public class LernkarteiPortlet extends MVCPortlet{

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletContext portletContext = this.getPortletContext();
		PortletRequestDispatcher portletRequestDispatcher = portletContext
				.getRequestDispatcher("/html/infonaergame/view.jsp");
		Object o = renderRequest.getPortletSession().getAttribute("currentPage", PortletSession.PORTLET_SCOPE);
		String curPage = VIEW_JSP;
		if (o != null) {
			curPage = o.toString();
			portletRequestDispatcher = portletContext.getRequestDispatcher(curPage);
		}
		portletRequestDispatcher.include(renderRequest, renderResponse);

	}
	
	public void gotoEditMode(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_CONTENT_JSP, PortletSession.PORTLET_SCOPE);
	}
	
	/**
	 * navigates to a category overview clears the portlet session of attributes
	 * of a category
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	//TODO anpassen an Karteikasten
	public void gotoCategoryOverview(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", CATEGORY_OVERVIEW_JSP,
				PortletSession.PORTLET_SCOPE);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.removeAttribute("categoryId", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("categoryName", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("unlocked", PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * navigates to a form to create a new category clears the portlet session
	 * of attributes of a category
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	//TODO anpassen an Karteikasten
	public void gotoNewCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", NEW_CATEGORY_JSP, PortletSession.PORTLET_SCOPE);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.removeAttribute("categoryId", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("categoryName", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("unlocked", PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * navigates to a form to edit an existing category fills the portlet
	 * session with attributes of the category
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void gotoEditCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_CATEGORY_JSP, PortletSession.PORTLET_SCOPE);
		fillCategoryEditForm(actionRequest, actionResponse);
	}

	/**
	 * fills the portlet session with attributes of the category to use in a
	 * page
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	private void fillCategoryEditForm(ActionRequest actionRequest, ActionResponse actionResponse) {
		// TODO Auto-generated method stub
	}

	
}
