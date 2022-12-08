
import java.util.HashMap;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import conversor.money.MoneyConversorVisual;
import conversor.temperature.TempConversorVisual;
import model.ConversorVisual;

public class Menu {

  public static HashMap<String, ConversorVisual> conversors = new HashMap<>();

  public static void initConversors() {
    conversors.put("Conversor de Moneda", new MoneyConversorVisual());
    conversors.put("Conversor de Temperatura", new TempConversorVisual());
  }

  public static void main(String[] args) {
    initConversors();

    // JFrame mainJFrame = new JFrame("Conversor de Monedas - Challenge ONE Java");
    // mainJFrame.setSize(500, 300);

    String[] options = conversors.keySet().toArray(new String[0]);

    Object response = JOptionPane.showInputDialog(null,
        "Seleccione una opción de conversión", "Menu",
        -1, null, options,
        options[0]);
    if (response == null)
      return;
    ConversorVisual currentConversor = conversors.get(response);
    currentConversor.init();
    Menu.main(args);
  }

}