package xml.element.and.dependecy;

import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Documentacion de la clase..
 * 
 * modified on 25th January by avillota
 */
@SuppressWarnings("all")
public class Dependecy {
  /**
   * *Documentar los atributos
   */
  private String type;
  
  private String relType;
  
  private String id;
  
  private String source;
  
  private String target;
  
  /**
   * Completar la documentacion
   */
  public CharSequence generateHLVLCode(final String target, final String source) {
    CharSequence _switchResult = null;
    final String relType = this.relType;
    if (relType != null) {
      switch (relType) {
        case "mandatory":
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("decomposition( ");
          _builder.append(target);
          _builder.append(",[");
          _builder.append(source);
          _builder.append("])<1>");
          _switchResult = _builder;
          break;
        case "optional":
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("\t");
          _builder_1.append("decomposition(");
          _builder_1.append(target, "\t");
          _builder_1.append(",[");
          _builder_1.append(source, "\t");
          _builder_1.append("])<0>");
          _switchResult = _builder_1;
          break;
        case "requires":
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("\t");
          _builder_2.append("implies(");
          _builder_2.append(source, "\t");
          _builder_2.append(",");
          _builder_2.append(target, "\t");
          _builder_2.append(")");
          _switchResult = _builder_2;
          break;
        case "excludes":
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("\t");
          _builder_3.append("mutex(");
          _builder_3.append(source, "\t");
          _builder_3.append(",");
          _builder_3.append(target, "\t");
          _builder_3.append(")");
          _switchResult = _builder_3;
          break;
      }
    }
    return _switchResult;
  }
  
  /**
   * Getters and Setters
   */
  public String getType() {
    return this.type;
  }
  
  public void setType(final String type) {
    this.type = type;
  }
  
  public String getRelType() {
    return this.relType;
  }
  
  public void setRelType(final String relType) {
    this.relType = relType;
  }
  
  public String getId() {
    return this.id;
  }
  
  public void setId(final String id) {
    this.id = id;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public void setSource(final String source) {
    this.source = source;
  }
  
  public String getTarget() {
    return this.target;
  }
  
  public void setTarget(final String target) {
    this.target = target;
  }
}
