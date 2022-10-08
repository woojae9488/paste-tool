package com.kwj.tool.paste.model;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class PasteMappingHolder<T> {

	private final Map<T, PasteMapping<T>> mappingMap;

	public PasteMappingHolder() {
		this.mappingMap = new ConcurrentHashMap<>();
	}

	public PasteMapping<T> makePasteMapping(T mappingKey) {
		PasteMapping<T> mapping = new PasteMapping<>(mappingKey);
		savePasteMapping(mappingKey, mapping);
		return mapping;
	}

	public void savePasteMapping(T mappingKey, PasteMapping<T> mapping) {
		this.mappingMap.put(mappingKey, mapping);
	}

	public PasteMapping<T> getPasteMapping(T mappingKey) {
		return this.mappingMap.get(mappingKey);
	}

	public String getPasteInputText(T mappingKey) {
		PasteMapping<T> mapping = this.mappingMap.get(mappingKey);

		return Optional.ofNullable(mapping)
			.filter(PasteMapping::isEnabled)
			.map(PasteMapping::getInputText)
			.orElse("");
	}

}
