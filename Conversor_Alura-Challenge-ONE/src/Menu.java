
import java.util.HashMap;

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
    String[] options = conversors.keySet().toArray(new String[0]);

    Object response = JOptionPane.showInputDialog(null,
        "Seleccione una opción de conversión", "Menu",
        -1, null, options,
        options[0]);
    if (response == null) {
      JOptionPane.showMessageDialog(null, "Programa terminado", "Fin del programa", 1, null);
      return;
    }
    ConversorVisual currentConversor = conversors.get(response);
    currentConversor.init();
    if (JOptionPane.showConfirmDialog(null,
        "¿Desea continuar?", "Continuar", 0, 2, null) != 0) {
      JOptionPane.showMessageDialog(null, "Programa terminado", "Fin del programa", 1, null);
      return;
    }
    Menu.main(args);
  }

}