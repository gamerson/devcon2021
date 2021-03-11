package unsafe.portlet.portlet;

import unsafe.portlet.constants.UnsafePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.UnsafeRunnable;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author greg
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Unsafe",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UnsafePortletKeys.UNSAFE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UnsafePortlet extends MVCPortlet {
	@Override
	protected void doDispatch(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		UnsafeRunnable<Throwable> unsafe = new UnsafeRunnable<Throwable>() {
			@Override
			public void run() throws Throwable {
				throw new Exception("unsafe!");
			}
		};
	
		super.doDispatch(renderRequest, renderResponse);
	}

}