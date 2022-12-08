package model;

import javax.swing.JOptionPane;

import interfaces.CallBack;

public class ConversorVisual {
  
  public void init(Conversor conversor, String askQuantity, String select1, String select2, CallBack callback) {
    Object response = JOptionPane.showInputDialog(askQuantity);
    if (response == null)
      return;
    double quantity = Double.valueOf(String.valueOf(response));
    if (quantity == 0)
      return;
    String[] options = conversor.getOptions();
    Object from = JOptionPane.showInputDialog(null,
        select1, "Conversion",
        1, null, options,
        options[0]);
    if (from == null)
      return;
    Object to = JOptionPane.showInputDialog(null,
        select2, "Conversion",
        1, null, options,
        options[0]);
    if (to == null)
      return;
    String result = callback.getResultText(quantity, (String) from, (String) to);
    JOptionPane.showMessageDialog(null, result, "Resultado", 3);
  }

  public void init() {
    // To be overrided
  }

}
