package com.srts.utils.docUtils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class DocOperationUtil {
	private ActiveXComponent wordApp;
	private Dispatch documents;
	private Dispatch document;
	private Dispatch selection;
	
	public void openDoc(String path){
		wordApp = new ActiveXComponent("Word.Application");
		Dispatch.put(wordApp, "Visible",new Variant(false));
		documents = Dispatch.get(wordApp, "Documents").toDispatch();
		document = Dispatch.call(documents, "Open",path).toDispatch();
		selection = Dispatch.call(wordApp, "Selection").toDispatch();
	}
	
	public void saveDoc2Html(String doc,String html){
		Dispatch.call(Dispatch.get(document, "Fields").toDispatch(), "Update");
		Dispatch.call(document, "SaveAs", doc);
		Dispatch.invoke(document, "SaveAs", Dispatch.Method, new Object[] {html, new Variant(10) }, new int[1]);
		Dispatch.call(document, "Close", new Variant(0));
		Dispatch.call(wordApp, "Quit");
	}
	
	public void insertTest(String text){
		Dispatch.put(selection, "Text", text);	
		Dispatch.call(selection, "MoveRight");
	}
}
