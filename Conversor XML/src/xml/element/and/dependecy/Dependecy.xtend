package xml.element.and.dependecy

class Dependecy {

	String type;
	String relType;
	String id;
	String source;
	String target;

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

	def CharSequence generateHLVLCode(String target, String source) {

		if (relType.equals("mandatory")) {
			return '''	decomposition( «target»,[«source»])<1>''';
		} else if (relType.equals("optional")) {
			return '''	decomposition( «target»,[«source»])<0>''';
		} else if (relType.equals("requires")) {
			return '''	implies( «source»,«target»)''';
		} else if (relType.equals("excludes")) {
			return '''	mutex( «source»,«target»)''';

		}
	}

}
