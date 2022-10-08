package com.kwj.tool.paste.util;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class RobotCommander {

	private static final Robot ROBOT = createRobotEssentially();

	private static Robot createRobotEssentially() {
		try {
			return new Robot();
		} catch (AWTException e) {
			System.err.println("There was a problem when create robot object.");
			e.printStackTrace(System.err);
			System.exit(1);
		}

		return null;
	}

	public static void enterKey(int keyCode) {
		ROBOT.keyPress(keyCode);
		ROBOT.keyRelease(keyCode);
	}

	public static void enterKeys(int... keyCodes) {
		java.util.List<Integer> codes = Arrays.stream(keyCodes)
			.boxed()
			.collect(Collectors.toList());

		Arrays.stream(keyCodes)
			.forEach(ROBOT::keyPress);

		Collections.reverse(codes);
		Arrays.stream(keyCodes)
			.forEach(ROBOT::keyRelease);
	}

}
