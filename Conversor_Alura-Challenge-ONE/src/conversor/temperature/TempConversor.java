package conversor.temperature;

import java.util.HashMap;

import model.Conversor;

public class TempConversor extends Conversor {

  private HashMap<String, TempOp> toC = new HashMap<String, TempOp>();
  private HashMap<String, TempOp> toNewT = new HashMap<String, TempOp>();

  private HashMap<String, String> toCode = new HashMap<String, String>();
  private HashMap<String, String> toDecode = new HashMap<String, String>();

  private void initRatios() {
    TempOp toFarenheit = new TempOp() {
      @Override
      public double tempOperation(double quantity) {
        return quantity * 9 / 5 + 32;
      }
    };

    TempOp fromFarenheit = new TempOp() {
      @Override
      public double tempOperation(double quantity) {
        return (quantity - 32) * 5 / 9;
      }
    };

    TempOp toKelvin = new TempOp() {
      @Override
      public double tempOperation(double quantity) {
        return quantity + 273.15;
      }
    };

    TempOp fromKelvin = new TempOp() {
      @Override
      public double tempOperation(double quantity) {
        return quantity - 273.15;
      }
    };

    TempOp toRankine = new TempOp() {
      @Override
      public double tempOperation(double quantity) {
        return toKelvin.tempOperation(quantity) * 9 / 5;
      }
    };

    TempOp fromRankine = new TempOp() {
      @Override
      public double tempOperation(double quantity) {
        return (quantity - 491.67) * 5 / 9;
      }
    };

    TempOp fromCelsius = new TempOp() {
      @Override
      public double tempOperation(double quantity) {
        return quantity;
      }
    };

    TempOp toCelsius = new TempOp() {
      @Override
      public double tempOperation(double quantity) {
        return quantity;
      }
    };

    toC.put("F", fromFarenheit);
    toC.put("R", fromRankine);
    toC.put("K", fromKelvin);
    toC.put("C", fromCelsius);

    toNewT.put("F", toFarenheit);
    toNewT.put("R", toRankine);
    toNewT.put("K", toKelvin);
    toNewT.put("C", toCelsius);
  }

  private void initTranslate() {
    this.toCode.put("centigrados", "C");
    this.toCode.put("farenheit", "F");
    this.toCode.put("rankine", "R");
    this.toCode.put("kelvin", "K");

    this.toDecode.put("F", "farenheit");
    this.toDecode.put("R", "rankine");
    this.toDecode.put("C", "centigrados");
    this.toDecode.put("K", "kelvin");
  }

  public TempConversor() {
    initRatios();
    initTranslate();
  }

  @Override
  public double convert(double quantity, String fromCode, String toCode) {
    double c = toC.get(fromCode).tempOperation(quantity);
    double newT = toNewT.get(toCode).tempOperation(c);
    return newT;
  }

  @Override
  public String[] getOptions() {
    return (String[]) this.toCode.keySet().toArray(new String[0]);
  }

  @Override
  public String code(String currency) {
    return this.toCode.get(currency);
  }

  @Override
  public String decode(String code) {
    return this.toDecode.get(code);
  }

}
