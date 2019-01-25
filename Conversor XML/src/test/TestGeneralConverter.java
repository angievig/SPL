package test;

import org.junit.jupiter.api.Test;
import xml.converter.Converter;
import xml.converter.ConverterFactory;
class TestGeneralConverter {

	private ConverterFactory converterFactory;
	@Test
	void test() {
		converterFactory = new ConverterFactory();
		Converter converter1 = converterFactory.createConverter("1");
		converter1.loadArrayLists("Conversor XML/resource/documentoXML3.xml");
		converter1.converterXmlElementToHLVLCode();
		converter1.converterXmlDependecyToHLVLCode();
	
//		decomposition(cliente,[id])<1>
//		decomposition(cliente,[nombre])<1>
//		decomposition(cliente,[edad])<0>
//		coreElements(cliente)
//		boolean id
//		boolean nombre
//		boolean edad
		
		
		
//		decomposition(Mobile phone,[Screen])<1>
//		decomposition(Mobile phone,[Media])<0>
//		mutex(Basic,GPS)
//		implies(Camera,High resolution)
//		coreElements(Mobile phone)
//		boolean Calls
//		boolean GPS
//		boolean Screen
//		boolean Media
//		boolean MP3
//		boolean Camera
//		boolean Basic
//		boolean High resolution
	}

}
