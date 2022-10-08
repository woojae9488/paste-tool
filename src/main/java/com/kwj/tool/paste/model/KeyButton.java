package com.kwj.tool.paste.model;

import java.awt.event.KeyEvent;
import java.util.Arrays;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public enum KeyButton {

	NUM_1(KeyEvent.VK_1, NativeKeyEvent.VC_1, '1'),
	NUM_2(KeyEvent.VK_2, NativeKeyEvent.VC_2, '2'),
	NUM_3(KeyEvent.VK_3, NativeKeyEvent.VC_3, '3'),
	NUM_4(KeyEvent.VK_4, NativeKeyEvent.VC_4, '4'),
	NUM_5(KeyEvent.VK_5, NativeKeyEvent.VC_5, '5'),
	NUM_6(KeyEvent.VK_6, NativeKeyEvent.VC_6, '6'),
	NUM_7(KeyEvent.VK_7, NativeKeyEvent.VC_7, '7'),
	NUM_8(KeyEvent.VK_8, NativeKeyEvent.VC_8, '8'),
	NUM_9(KeyEvent.VK_9, NativeKeyEvent.VC_9, '9'),
	NUM_0(KeyEvent.VK_0, NativeKeyEvent.VC_0, '0'),
	;

	private final int swingKeyCode;
	private final int nativeKeyCode;
	private final char keyChar;

	KeyButton(int swingKeyCode, int nativeKeyCode, char keyChar) {
		this.swingKeyCode = swingKeyCode;
		this.nativeKeyCode = nativeKeyCode;
		this.keyChar = keyChar;
	}

	public static KeyButton nativeKeyCodeOf(int nativeKeyCode) {
		return Arrays.stream(values())
			.filter(keyButton -> keyButton.nativeKeyCode == nativeKeyCode)
			.findFirst()
			.orElse(null);
	}

	public int getSwingKeyCode() {
		return this.swingKeyCode;
	}

	public int getNativeKeyCode() {
		return this.nativeKeyCode;
	}

	public int getKeyChar() {
		return this.keyChar;
	}

	@Override
	public String toString() {
		return name();
	}

}
