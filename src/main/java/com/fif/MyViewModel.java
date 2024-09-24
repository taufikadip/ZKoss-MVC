package com.fif;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class MyViewModel {

	private int count;
	private int test;
	private String hello;

	@Init
	public void init() {
		count = 100;
		test = 200;
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		++count;
	}

	@Command
	@NotifyChange("test")
	public void testcmd() {
		--test;
	}

	public int getCount() {
		return count;
	}

	public String getName() {
		return "Hello World Update";
	}

	public int getTest() {return test;}
}
