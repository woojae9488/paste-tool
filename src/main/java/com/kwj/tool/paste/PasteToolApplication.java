package com.kwj.tool.paste;

import com.kwj.tool.paste.component.frame.PasteToolFrame;
import com.kwj.tool.paste.model.KeyButton;
import com.kwj.tool.paste.model.PasteMappingHolder;

public class PasteToolApplication {

	public static void main(String[] args) {
		PasteMappingHolder<KeyButton> mappingHolder = new PasteMappingHolder<>();
		new PasteToolFrame(mappingHolder);
	}

}
