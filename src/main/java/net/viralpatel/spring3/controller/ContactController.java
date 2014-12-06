package net.viralpatel.spring3.controller;

import net.viralpatel.spring3.FreemarkerUtil;
import net.viralpatel.spring3.form.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class ContactController {

	private static Map<String, Object> contactMap = new HashMap<String, Object>();

	private void init() {
		contactMap.clear();
        //构造嵌套MAP的List
        Map<String, String> map1=new LinkedHashMap<String, String>();
        map1.put("a1","111");
        map1.put("a2","222");
        Map<String, String> map2=new LinkedHashMap<String, String>();
        map2.put("a1","aaa");
        map2.put("a2","bbb");
        List<Map> mapList = new ArrayList<Map>();
        mapList.add(map1);
        mapList.add(map2);

		List<String> mobiles = new ArrayList<String>();
		mobiles.add("18610545767");
		mobiles.add("13601395811");

		Map<String, String> attrMap = new LinkedHashMap<String, String>();
		attrMap.put("attr1", "aaaa");
		attrMap.put("attr2", "bbbb");

        contactMap.put("name", "John");
		contactMap.put("lastname", "Lennon");
		contactMap.put("genres", "Rock, Pop");
		contactMap.put("mobiles", mobiles);
		contactMap.put("attrMap", attrMap);
		contactMap.put("mapList", mapList);
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView get() {
		ContactForm contactForm = new ContactForm();
		init();
		contactForm.setContactMap(contactMap);
		contactForm.setGenerateCode(FreemarkerUtil.generateCode("contactMap", contactMap, 0));
		return new ModelAndView("add_contact", "contactForm", contactForm);
	}

	@RequestMapping(value = "/add")
	public ModelAndView save(HttpServletRequest request, @ModelAttribute("contactForm") ContactForm contactForm) {
		System.out.println(contactForm);
		if (null != contactForm.getContactMap()) {
			contactMap = contactForm.getContactMap();
			System.out.println(contactMap);
			System.out.println(contactMap.keySet());
		}
		return new ModelAndView("show_contact", "contactForm", contactForm);
	}
}
