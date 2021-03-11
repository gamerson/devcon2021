package com.test.library.two.service;

import org.osgi.service.component.annotations.Component;

import com.test.library.two.api.LibraryTwo;

@Component
public class LiferayTwoService implements LibraryTwo {

	@Override
	public String anotherThing() {
		return "anotheThing";
	}

	@Override
	public String anotherThingToCall(String another) {
		return "another: " + another;
	}


}
