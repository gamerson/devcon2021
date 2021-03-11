package com.foo.provider;

import com.foo.api.MyApi;

import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

/**
 * @author rotty
 */
@Component
public class MyProvider implements MyApi {

	@Override
	public String convertNameToJSON(String name) {
		return new JSONObject().append("name", name).toString();
	}

}