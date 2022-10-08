package com.kwj.tool.paste.listener;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Optional;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.kwj.tool.paste.model.KeyButton;
import com.kwj.tool.paste.model.PasteMapping;
import com.kwj.tool.paste.model.PasteMappingHolder;
import com.kwj.tool.paste.util.RobotCommander;
import com.kwj.tool.paste.util.SystemOs;

public class KeyButtonListener implements NativeKeyListener {

	private final PasteMappingHolder<KeyButton> mappingHolder;

	public KeyButtonListener(PasteMappingHolder<KeyButton> mappingHolder) {
		this.mappingHolder = mappingHolder;
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		Optional.of(e.getKeyCode())
			.map(KeyButton::nativeKeyCodeOf)
			.map(mappingHolder::getPasteMapping)
			.ifPresent(this::pasteMappingInputText);
	}

	private void pasteMappingInputText(PasteMapping<KeyButton> mapping) {
		if (mapping.isEnabled()) {
			String text = mapping.getInputText();
			System.out.println("Paste Tool: " + text);

			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection selection = new StringSelection(text);
			clipboard.setContents(selection, null);

			RobotCommander.enterKey(KeyEvent.VK_BACK_SPACE);
			RobotCommander.enterKeys(SystemOs.current().getControlKeyCode(), KeyEvent.VK_V);
		}
	}

}
