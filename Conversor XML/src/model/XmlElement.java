package model;

public class XmlElement {

	private String name;
	private String id;
	private String type;
	private String selected;
	private String bundleType;
	
	
	public XmlElement(String name, String id, String type, String selected, String bundleType) {
		
		this.name = name;
		this.id = id;
		this.type = type;
		this.selected = selected;
		this.bundleType = bundleType;
	}
	public XmlElement(String name, String id, String type, String selected) {
	
		this.name = name;
		this.id = id;
		this.type = type;
		this.selected = selected;
	}
	public XmlElement(String name, String id, String type) {
		
		this.name = name;
		this.id = id;
		this.type = type;
	}
	public XmlElement() {
		
	}
	
	
	
	public String getBundleType() {
		return bundleType;
	}
	public void setBundleType(String bundleType) {
		this.bundleType = bundleType;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
