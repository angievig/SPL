package xml.element.and.dependecy;

import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Documentacion de la clase..
 * 
 * modified on 25th January by avillota
 */
@SuppressWarnings("all")
public class Element {
  private String name;
  
  private String id;
  
  private String type;
  
  private String selected;
  
  private String bundleType;
  
  public CharSequence generateHLVLCode() {
    boolean _equals = this.type.equals("root");
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t");
      _builder.append("coreElements(");
      _builder.append(this.name, "\t");
      _builder.append(")");
      return _builder;
    } else {
      if ((this.type.equals("general") || this.type.equals("leaf"))) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("\t");
        _builder_1.append("boolean ");
        _builder_1.append(this.name, "\t");
        return _builder_1;
      }
    }
    return null;
  }
  
  /**
   * Getters and Setters
   */
  public String getBundleType() {
    return this.bundleType;
  }
  
  public void setBundleType(final String bundleType) {
    this.bundleType = bundleType;
  }
  
  public String getSelected() {
    return this.selected;
  }
  
  public void setSelected(final String selected) {
    this.selected = selected;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public String getId() {
    return this.id;
  }
  
  public void setId(final String id) {
    this.id = id;
  }
  
  public String getType() {
    return this.type;
  }
  
  public void setType(final String type) {
    this.type = type;
  }
}
