package conversor.money;

import interfaces.CallBack;
import model.ConversorVisual;

public class MoneyConversorVisual extends ConversorVisual implements CallBack {
  public String askQuantity = "Ingrese la cantidad que deseas convertir:";
  public String select1 = "Escoja de donde va a convertir";
  public String select2 = "Escoja a que va a convertir";
  public MoneyConversor conversor = new MoneyConversor();

  public String getResultText(double quantity, String from, String to) {
    String fromCode = this.conversor.code(from);
    String toCode = this.conversor.code(to);
    double result = this.conversor.convert(quantity, fromCode, toCode);
    to = this.conversor.plurarize(to);
    return "Tienes $" + String.valueOf(result) + " " + to;
  }

  public void init() {
    super.init(conversor, askQuantity, select1, select2, this);
  }

}
