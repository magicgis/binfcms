package me.binf.admin.mvc.editor;


import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

public class CustomFloatEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text)
			throws java.lang.IllegalArgumentException {
		if (text != null && text instanceof String && StringUtils.isNotBlank(text)) {
			text=text.toString().replaceAll(",", "");
			super.setValue(Float.valueOf(text));
		} else {
			super.setValue(null);
		}
	}

	@Override
	public String getAsText() {
		Object obj=super.getValue();
		String text=null;
		if (obj != null && obj instanceof String && StringUtils.isNotBlank(text)) {
			text=obj.toString().replaceAll(",", "");
		}
		return text;
	}

}
