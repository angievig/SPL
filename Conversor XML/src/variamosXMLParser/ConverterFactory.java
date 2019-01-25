package variamosXMLParser;

/**
 * This is a class which is responsible for create specific XML converter.
 * 
 * @version 1.5, 19/01/2019
 * @author Joan David Colina Echeverry
 */

public class ConverterFactory {

	/**
	 * this method is responsible for create specific XML converter
	 * 
	 * @param type: string to identify the converter to creating
	 * @return specific converter depending of type
	 */
	public Converter createConverter(String type) {

		if (type.equals("1")) {
			return new VariamosXML2HlvlParser();
		} else {
			return null;
		}
	}
}
