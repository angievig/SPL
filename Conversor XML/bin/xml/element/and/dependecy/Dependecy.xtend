package xml.element.and.dependecy

/**
 * Documentacion de la clase..
 * 
 * modified on 25th January by avillota
 */

class Dependecy {

	/**
	 * *Documentar los atributos
	 */
	String type;
	String relType;
	String id;
	String source;
	String target;
	
	/**
	 * Completar la documentacion
	 */
	def CharSequence generateHLVLCode(String target, String source) {
		switch relType{
			case "mandatory": '''decomposition( «target»,[«source»])<1>'''
			case "optional": '''	decomposition(«target»,[«source»])<0>'''
			case "requires": '''	implies(«source»,«target»)'''
			case "excludes": '''	mutex(«source»,«target»)'''
		}
	}
	
	/*
	 * Getters and Setters
	 */
		def String getType() {
		return type;
	}

	def void setType(String type) {
		this.type = type;
	}

	def String getRelType() {
		return relType;
	}

	def void setRelType(String relType) {
		this.relType = relType;
	}

	def String getId() {
		return id;
	}

	def void setId(String id) {
		this.id = id;
	}

	def String getSource() {
		return source;
	}

	def void setSource(String source) {
		this.source = source;
	}

	def String getTarget() {
		return target;
	}

	def void setTarget(String target) {
		this.target = target;
	}

}
