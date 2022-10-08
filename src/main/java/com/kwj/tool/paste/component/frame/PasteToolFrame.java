package com.kwj.tool.paste.component.frame;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

import com.kwj.tool.paste.component.panel.KeyButtonPasteMappingPanel;
import com.kwj.tool.paste.component.panel.PasteActivationButton;
import com.kwj.tool.paste.constant.PasteToolConstants;
import com.kwj.tool.paste.model.KeyButton;
import com.kwj.tool.paste.model.PasteMapping;
import com.kwj.tool.paste.model.PasteMappingHolder;

public class PasteToolFrame extends JFrame {

	private final PasteMappingHolder<KeyButton> mappingHolder;

	public PasteToolFrame(PasteMappingHolder<KeyButton> mappingHolder) {
		this.mappingHolder = mappingHolder;

		addComponents();
		configFrameSetting();
	}

	private void configFrameSetting() {
		setLayout(new GridLayout(11, 1));

		setTitle(PasteToolConstants.MAIN_FRAME_TITLE);
		setSize(PasteToolConstants.MAIN_FRAME_WIDTH_SIZE, PasteToolConstants.MAIN_FRAME_HEIGHT_SIZE);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addComponents() {
		Arrays.stream(KeyButton.values())
			.forEach(this::addKeyEventPasteMappingPanel);

		add(new PasteActivationButton(this.mappingHolder));
	}

	private void addKeyEventPasteMappingPanel(KeyButton keyButton) {
		PasteMapping<KeyButton> mapping = this.mappingHolder.makePasteMapping(keyButton);
		KeyButtonPasteMappingPanel mappingPanel = new KeyButtonPasteMappingPanel(mapping);
		add(mappingPanel);
	}

}
