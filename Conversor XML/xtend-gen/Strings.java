import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Strings {
  private CharSequence Ejemplo;
  
  private int n = 0;
  
  public String getEjemplo() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("este es una cadena compleja que ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("tiene saltos");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("sin caracteres especiales");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("y concatena sin operadores ");
    _builder.append(this.n, "\t\t");
    return _builder.toString();
  }
}
