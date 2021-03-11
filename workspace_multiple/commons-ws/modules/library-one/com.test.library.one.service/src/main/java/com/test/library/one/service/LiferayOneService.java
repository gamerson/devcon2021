package com.test.library.one.service;

import org.osgi.service.component.annotations.Component;

import com.test.library.one.api.LibraryOne;

@Component
public class LiferayOneService implements LibraryOne {

	@Override
	public String thisThing() {
		return "this";
	}

	@Override
	public String thatThing(String that) {
		return "that: " + that;
	}

}
