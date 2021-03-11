package hello.portlet.portlet;

import hello.portlet.constants.HelloPortletKeys;

import com.foo.api.MyApi;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author greg
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HelloPortletKeys.Hello,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HelloPortlet extends MVCPortlet {

	@Override
	protected void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		renderRequest.setAttribute("json", myApi.convertNameToJSON("some text to be jsonified"));

		super.doDispatch(renderRequest, renderResponse);
	}

	@Reference
	private MyApi myApi;

}