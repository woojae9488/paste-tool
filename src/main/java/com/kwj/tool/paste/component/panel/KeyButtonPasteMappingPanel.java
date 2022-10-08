package com.kwj.tool.paste.component.panel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.kwj.tool.paste.constant.PasteToolConstants;
import com.kwj.tool.paste.model.KeyButton;
import com.kwj.tool.paste.model.PasteMapping;
import com.kwj.tool.paste.util.GridBagConstraintsBuilder;

public class KeyButtonPasteMappingPanel extends JPanel {

	private final PasteMapping<KeyButton> mapping;

	private final JLabel keyButtonLabel;
	private final JTextField inputTextField;
	private final JButton activationButton;

	public KeyButtonPasteMappingPanel(PasteMapping<KeyButton> mapping) {
		this.mapping = mapping;

		this.keyButtonLabel = new JLabel(String.valueOf(this.mapping.getMappingKey()));
		this.inputTextField = new JTextField(this.mapping.getInputText());
		this.activationButton = new JButton(getActivationText());

		configPanelSetting();
		addComponents();
		attachComponentListeners();
	}

	private void configPanelSetting() {
		setLayout(new GridBagLayout());

		this.keyButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}

	private void addComponents() {
		this.keyButtonLabel.setBorder(new EmptyBorder(0, 10, 0, 10));
		add(this.keyButtonLabel, new GridBagConstraintsBuilder().gridX(0).gridY(0).build());
		add(this.inputTextField, new GridBagConstraintsBuilder().gridX(1).gridY(0)
			.gridWidth(2).weightX(1).fill(GridBagConstraints.HORIZONTAL).build());
		add(this.activationButton, new GridBagConstraintsBuilder().gridX(3).gridY(0).build());
	}

	private void attachComponentListeners() {
		attachInputTextFieldListener();
		attachActivationButtonListener();
	}

	private void attachInputTextFieldListener() {
		this.inputTextField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				mapping.setInputText(inputTextField.getText());
			}

		});
	}

	private void attachActivationButtonListener() {
		this.activationButton.addActionListener(e -> {
			if (mapping.isEnabled()) {
				mapping.disable();
			} else {
				mapping.enable();
			}
			activationButton.setText(getActivationText());
		});
	}

	private String getActivationText() {
		return this.mapping.isEnabled()
			? PasteToolConstants.MAPPING_DISABLE_BUTTON_TEXT
			: PasteToolConstants.MAPPING_ENABLE_BUTTON_TEXT;
	}

}
