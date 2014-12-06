package net.viralpatel.spring3.form;

import java.util.HashMap;
import java.util.Map;

public class ContactForm {

	private Map<String, Object> contactMap = new HashMap<String, Object>();
	private String generateCode;

	public Map<String, Object> getContactMap() {
		return contactMap;
	}

	public String getGenerateCode() {
		return generateCode;
	}

	public void setGenerateCode(String generateCode) {
		this.generateCode = generateCode;
	}

	public void setContactMap(Map<String, Object> contactMap) {
		this.contactMap = contactMap;
	}

}
