package variamosXMLParser;

import java.util.ArrayList;
import xml.Reader.XmlReader;
import xml.element.and.dependecy.Dependecy;
import xml.element.and.dependecy.Element;

/**
 * Esta es una clase que es responsable de extraer informaci�n del objeto del
 * elemento XML y del objeto de dependencia XML y convertir esa informaci�n en
 * el c�digo HLVL.
 * 
 * @version 1.5, 19/01/2019
 * @author Joan David Colina Echeverry
 */
public class VariamosXML2HlvlParser implements Converter {

	private ArrayList<Dependecy> importantXmlDependecy;

	private ArrayList<Element> importantXmlElement;

	private XmlReader xmlReader;

	/**
	 * this method is responsible for load the XML fiel and inicializate the
	 * ArrayList
	 * 
	 * @param path: string that represent the XML source to load.
	 */
	public void loadArrayLists(String path) {
		xmlReader = new XmlReader();
		xmlReader.loadXmlFiel(path);
		importantXmlDependecy = xmlReader.getImportantXmlDependecy();
		importantXmlElement = xmlReader.getImportantXmlElement();
	}

	/**
	 * this method is responsible for become the Array's Dependecy to HLVL code
	 * 
	 * @return ArrayList<CharSequence> that contain all HLVL code lines
	 */
	public ArrayList<CharSequence> converterXmlDependecyToHLVLCode() {
		ArrayList<CharSequence> result = new ArrayList<CharSequence>();
		CharSequence aux = "";
		for (int i = 0; i < importantXmlDependecy.size(); i++) {
			aux = importantXmlDependecy.get(i).generateHLVLCode(
					searchForName((String) importantXmlDependecy.get(i).getTarget()),
					searchForName((String) importantXmlDependecy.get(i).getSource()));
			// TODO: Solucionar problema con null.
			if (aux != null) {
				System.out.println(aux);

				result.add(aux);
			}
		}
		return result;
	}

	/**
	 * this method is responsible for searh into the ArrayList<Element> the XML
	 * Element's name having the XML Element's id
	 * 
	 * @param id: string that represent the XML Element's id.
	 * @return Strign that represent the XML Element's name.
	 */
	public String searchForName(String id) {
		String result = "";
		for (int i = 0; i < importantXmlElement.size(); i++) {
			if (importantXmlElement.get(i).getId().equals(id)) {
				result = (String) importantXmlElement.get(i).getName();
			}
		}
		return result;
	}

	/**
	 * this method is responsible for become the Array's Element to HLVL code
	 * 
	 * @return ArrayList<CharSequence> that contain all HLVL code lines
	 */
	public ArrayList<CharSequence> converterXmlElementToHLVLCode() {
		ArrayList<CharSequence> result = new ArrayList<CharSequence>();
		CharSequence aux = "";
		for (int i = 0; i < importantXmlElement.size(); i++) {
			aux = importantXmlElement.get(i).generateHLVLCode();
			// TODO: Solucionar problema con null.
			if (aux != null) {
				System.out.println(aux);

				result.add(aux);
			}
			
		}
		return result;

	}
}
