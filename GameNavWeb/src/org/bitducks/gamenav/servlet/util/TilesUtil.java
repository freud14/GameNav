
package org.bitducks.gamenav.servlet.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.Attribute;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.Request;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;

public class TilesUtil {

	public static void render(String page, String title,
			HttpServletRequest request, HttpServletResponse response) {

		ApplicationContext appCtx = ServletUtil.getApplicationContext(request
				.getSession().getServletContext());
		TilesContainer container = TilesAccess.getContainer(appCtx);
		Request tilesRequest = new ServletRequest(
				container.getApplicationContext(), request, response);
		if (title != null) {
			container.getAttributeContext(tilesRequest).putAttribute("title",
					new Attribute(title));
		}
		container.render(page, tilesRequest);
	}

	public static void render(String page, HttpServletRequest request,
			HttpServletResponse response) {
		render(page, null, request, response);
	}
}
