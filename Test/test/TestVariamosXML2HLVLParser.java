package test;

import org.junit.jupiter.api.Test;

import variamosXMLParser.Converter;
import variamosXMLParser.ConverterFactory;
class TestVariamosXML2HLVLParser {

	private ConverterFactory converterFactory;
	@Test
	void test() {
		converterFactory = new ConverterFactory();
		Converter converter1 = converterFactory.createConverter("1");
		converter1.loadArrayLists("Conversor XML/resource/documentoXML3.xml");
		converter1.converterXmlElementToHLVLCode();
		converter1.converterXmlDependecyToHLVLCode();
	
	}

}
