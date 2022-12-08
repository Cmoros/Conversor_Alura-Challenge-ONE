package conversor.money;

import java.util.HashMap;
import model.Conversor;

public class MoneyConversor extends Conversor {

  private HashMap<String, Double> ratios = new HashMap<String, Double>();

  private HashMap<String, String> toCode = new HashMap<String, String>();
  private HashMap<String, String> toDecode = new HashMap<String, String>();
  private HashMap<String, String> plural = new HashMap<String, String>();
  

  private void initRatios() {
    this.ratios.put("USD", 1.0);
    this.ratios.put("JPY", 136.79);
    this.ratios.put("EUR", 0.95);
    this.ratios.put("KRW", 1318.20);
    this.ratios.put("ARS", 169.81);
    this.ratios.put("GBP", 0.82);
  }

  private void initTranslate() {
    this.toCode.put("won coreano", "KRW");
    this.toCode.put("dolar", "USD");
    this.toCode.put("yen", "JPY");
    this.toCode.put("peso argentino", "ARS");
    this.toCode.put("euro", "EUR");
    this.toCode.put("libra", "GBP");

    this.toDecode.put("EUR", "euro");
    this.toDecode.put("JPY", "yen");
    this.toDecode.put("KRW", "won coreano");
    this.toDecode.put("ARS", "peso argentino");
    this.toDecode.put("USD", "dolar");
    this.toDecode.put("GBP", "libra");
  }

  private void initPlural() {
    this.plural.put("won coreano", "won coreanos");
    this.plural.put("dolar", "dolares");
    this.plural.put("yen", "yenes");
    this.plural.put("peso argentino", "pesos argentinos");
    this.plural.put("euro", "euros");
    this.plural.put("libra", "libras");
  }

  public String plurarize(String to) {
    return this.plural.get(to);
  }

  public MoneyConversor() {
    initRatios();
    initTranslate();
    initPlural();
  }

  @Override
  public String code(String currency) {
    return this.toCode.get(currency);
  }

  @Override
  public String decode(String code) {
    return this.toDecode.get(code);
  }

  @Override
  public String[] getOptions() {
    return (String[]) this.toCode.keySet().toArray(new String[0]);
  }

  @Override
  public double convert(double quantity, String fromCode, String toCode) {
    return quantity / this.ratios.get(fromCode) * this.ratios.get(toCode);
  }

  public static void main(String[] args) {
    MoneyConversor mc = new MoneyConversor();
    System.out.println(mc.getOptions()[0]);
    System.out.println(mc.convert(10.0, "EUR", "ARS"));
  }

}

