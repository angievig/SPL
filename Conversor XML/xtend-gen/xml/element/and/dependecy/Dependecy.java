package xml.element.and.dependecy;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Dependecy {
  private String type;
  
  private String relType;
  
  private String id;
  
  private String source;
  
  private String target;
  
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
  
  public CharSequence generateHLVLCode(final String target, final String source) {
    boolean _equals = this.relType.equals("mandatory");
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\t");
      _builder.append("decomposition( ");
      _builder.append(target, "\t");
      _builder.append(",[");
      _builder.append(source, "\t");
      _builder.append("])<1>");
      return _builder;
    } else {
      boolean _equals_1 = this.relType.equals("optional");
      if (_equals_1) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("\t");
        _builder_1.append("decomposition( ");
        _builder_1.append(target, "\t");
        _builder_1.append(",[");
        _builder_1.append(source, "\t");
        _builder_1.append("])<0>");
        return _builder_1;
      } else {
        boolean _equals_2 = this.relType.equals("requires");
        if (_equals_2) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("\t");
          _builder_2.append("implies( ");
          _builder_2.append(source, "\t");
          _builder_2.append(",");
          _builder_2.append(target, "\t");
          _builder_2.append(")");
          return _builder_2;
        } else {
          boolean _equals_3 = this.relType.equals("excludes");
          if (_equals_3) {
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("\t");
            _builder_3.append("mutex( ");
            _builder_3.append(source, "\t");
            _builder_3.append(",");
            _builder_3.append(target, "\t");
            _builder_3.append(")");
            return _builder_3;
          }
        }
      }
    }
    return null;
  }
}
