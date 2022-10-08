package com.kwj.tool.paste.component.panel;

import javax.swing.*;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.kwj.tool.paste.constant.PasteToolConstants;
import com.kwj.tool.paste.listener.KeyButtonListener;
import com.kwj.tool.paste.model.KeyButton;
import com.kwj.tool.paste.model.PasteMappingHolder;

public class PasteActivationButton extends JButton {

	public PasteActivationButton(PasteMappingHolder<KeyButton> mappingHolder) {
		setText(PasteToolConstants.MAPPING_ACTIVATE_BUTTON_TEXT);
		GlobalScreen.addNativeKeyListener(new KeyButtonListener(mappingHolder));

		addActionListener(e -> {
			if (isActivated()) {
				deactivatePasteMapping();
			} else {
				activatePasteMapping();
			}
		});
	}

	private boolean isActivated() {
		return getText().equals(PasteToolConstants.MAPPING_DEACTIVATE_BUTTON_TEXT);
	}

	private void activatePasteMapping() {
		try {
			setText(PasteToolConstants.MAPPING_DEACTIVATE_BUTTON_TEXT);
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			System.err.println("There was a problem when register the native hook.");
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	private void deactivatePasteMapping() {
		try {
			setText(PasteToolConstants.MAPPING_ACTIVATE_BUTTON_TEXT);
			GlobalScreen.unregisterNativeHook();
			GlobalScreen.setEventDispatcher(null);
		} catch (NativeHookException e) {
			System.err.println("There was a problem when unregister the native hook.");
			e.printStackTrace(System.err);
		}
	}

}
