package conversor.temperature;

import interfaces.CallBack;
import model.ConversorVisual;

public class TempConversorVisual extends ConversorVisual implements CallBack {
  public String askQuantity = "Ingrese la cantidad que deseas convertir:";
  public String select1 = "Escoja de donde va a convertir";
  public String select2 = "Escoja a que va a convertir";
  public TempConversor conversor = new TempConversor();

  @Override
  public String getResultText(double quantity, String from, String to) {
    String fromCode = this.conversor.code(from);
    String toCode = this.conversor.code(to);
    double result = this.conversor.convert(quantity, fromCode, toCode);
    return "Total de " + String.valueOf(result) + " grados " + to;
  }

  public void init() {
    super.init(conversor, askQuantity, select1, select2, this);
  }
  
}
