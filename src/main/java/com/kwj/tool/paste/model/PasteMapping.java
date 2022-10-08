package com.kwj.tool.paste.model;

public class PasteMapping<T> {

	private final T mappingKey;

	private volatile String inputText;

	private volatile boolean enabled;

	public PasteMapping(T mappingKey) {
		this.mappingKey = mappingKey;
		this.inputText = "";
		this.enabled = true;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public void enable() {
		this.enabled = true;
	}

	public void disable() {
		this.enabled = false;
	}

	public T getMappingKey() {
		return this.mappingKey;
	}

	public String getInputText() {
		return this.inputText;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

}
