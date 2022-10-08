package com.kwj.tool.paste.util;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public enum SystemOs {

	WINDOWS("win", KeyEvent.VK_CONTROL),
	MAC("mac", KeyEvent.VK_META),
	OTHER(null, KeyEvent.VK_CONTROL),
	;

	private final String osWord;
	private final int controlKeyCode;

	SystemOs(String osWord, int controlKeyCode) {
		this.osWord = osWord;
		this.controlKeyCode = controlKeyCode;
	}

	public static SystemOs current() {
		String osName = System.getProperty("os.name").toLowerCase();

		return Arrays.stream(values())
			.filter(os -> os.osWord != null && osName.contains(os.osWord))
			.findFirst()
			.orElse(OTHER);
	}

	public int getControlKeyCode() {
		return this.controlKeyCode;
	}

}
