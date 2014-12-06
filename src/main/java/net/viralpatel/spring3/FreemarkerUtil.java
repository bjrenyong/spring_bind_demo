package net.viralpatel.spring3;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateHashModel;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by renyong on 14-12-6.
 */
public class FreemarkerUtil {

	private static String TEMPLATE_DIR = "freemarker";
	private static String TEMPLATE_TESTDATASHOW = "add_contact.ftl";

	public static boolean isTypeList(Object obj) {
		return obj instanceof List;
	}

	public static boolean isTypeMap(Object obj) {
		return obj instanceof Map;
	}

	public static String generateCode(String name, Object obj, int classLevel) {
		try {
			classLevel++;
			BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
			TemplateHashModel staticModels = wrapper.getStaticModels();
			TemplateHashModel codeGenerator = (TemplateHashModel) staticModels
					.get("net.viralpatel.spring3.FreemarkerUtil");
			Configuration freeMarkerCfg = new Configuration();
			File f = new File(TEMPLATE_DIR);
			freeMarkerCfg.setDefaultEncoding("utf-8");
			freeMarkerCfg.setDirectoryForTemplateLoading(f);
			Template template = freeMarkerCfg.getTemplate(TEMPLATE_TESTDATASHOW);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("namePerfix", name);
			parameters.put("contactData", obj);
			parameters.put("classLevel", classLevel);
			parameters.put("freemarkerUtil", codeGenerator);
			Writer out = new StringWriter();
			template.process(parameters, out);
			return out.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
