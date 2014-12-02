package me.binf.admin.mvc.editor;


import java.beans.PropertyEditorSupport;

public class CustomFileEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws java.lang.IllegalArgumentException{
		
	}
	
	@Override
	public void setValue(Object value) {
		if(value ==null || value instanceof String){
			super.setValue(null);
		}else{
			super.setValue(value);
		}
	}
	
}
