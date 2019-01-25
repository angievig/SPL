package variamosXMLParser;

import java.util.ArrayList;

public interface Converter {

	public void loadArrayLists(String path);

	public ArrayList<CharSequence> converterXmlDependecyToHLVLCode();

	public String searchForName(String id);

	public ArrayList<CharSequence> converterXmlElementToHLVLCode();
}
