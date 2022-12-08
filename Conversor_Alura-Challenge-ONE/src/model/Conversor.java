package model;

public abstract class Conversor {

  public abstract double convert(double quantity, String fromCode,String toCode);
  
  public abstract String[] getOptions();

  public abstract String code(String currency);
  public abstract String decode(String code);

}
