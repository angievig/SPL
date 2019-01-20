package model;

public class XmlDependecy {

	private String type;
	private String relType;
	private String id;
	private String source;
	private String target;
	
	
	public XmlDependecy(String type, String relType, String id, String source, String target) {
		
		this.type = type;
		this.relType = relType;
		this.id = id;
		this.source = source;
		this.target = target;
	}
	public XmlDependecy() {
	
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRelType() {
		return relType;
	}
	public void setRelType(String relType) {
		this.relType = relType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	
}
