package xml.element.and.dependecy

/**
 * Documentacion de la clase..
 * 
 * modified on 25th January by avillota
 */

class Element {

	String name;
	String id;
	String type;
	String selected;
	String bundleType;


	def CharSequence generateHLVLCode() {

		if (type.equals("root")) {

			return '''	coreElements(«name»)''';
		} else if (type.equals("general") || type.equals("leaf")) {

			return '''	boolean «name»''';

		}
	}
	
	/*
	 * Getters and Setters
	 */
	def String getBundleType() {
		return bundleType;
	}

	def void setBundleType(String bundleType) {
		this.bundleType = bundleType;
	}

	def String getSelected() {
		return selected;
	}

	def void setSelected(String selected) {
		this.selected = selected;
	}

	def String getName() {
		return name;
	}

	def void setName(String name) {
		this.name = name;
	}

	def String getId() {
		return id;
	}

	def void setId(String id) {
		this.id = id;
	}

	def String getType() {
		return type;
	}

	def void setType(String type) {
		this.type = type;
	}

}
