class Length{
    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor){
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor(){
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit){
        if(unit==null){
            throw new IllegalArgumentException("Unit must not be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit(){
        double inches =  this.value*this.unit.getConversionFactor();
        return Math.round(inches*100.0)/100.0;
    }

    public boolean compare(Length thatLength){
        return Double.compare(this.convertToBaseUnit(),thatLength.convertToBaseUnit())==0;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length that = (Length) o;
        return this.compare(that);
    }

    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit must not be null");
        }
        double inches = this.convertToBaseUnit();
        double convertedValue = inches / targetUnit.getConversionFactor();
        convertedValue = Math.round(convertedValue * 100.0) / 100.0;
        return new Length(convertedValue, targetUnit);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    public Length add(Length thatLength) {
        double sumInches = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double convertedValue = sumInches / this.unit.getConversionFactor();
        convertedValue = Math.round(convertedValue * 100.0) / 100.0;
        return new Length(convertedValue, this.unit);
    }

    public Length add(Length thatLength, LengthUnit targetUnit) {
        double sumInches = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double convertedValue = sumInches / targetUnit.getConversionFactor();
        convertedValue = Math.round(convertedValue * 100.0) / 100.0;
        return new Length(convertedValue, targetUnit);
    }

    /*
    public static void main(String[] args){
        Length length1 = new Length(1.0, LengthUnit.YARDS);
        Length length2 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Are lengths equal? " + length1.equals(length2)); // true

        Length converted = length1.convertTo(LengthUnit.FEET);
        System.out.println("Converted: " + converted);
    }

     */
}

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1,Length length2) {
        boolean result = length1.equals(length2);
        System.out.println(length1 + " equals " + length2 + " ? " + result);
        return result;
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        Length result = length1.add(length2);
        System.out.println(length1 + " + " + length2 + " = " + result);
        return result;
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, Length.LengthUnit targetUnit) {
        Length result = length1.add(length2, targetUnit);
        System.out.println(length1 + " + " + length2 + " in " + targetUnit + " = " + result);
        return result;
    }

    public static void main(String[] args) {
        demonstrateLengthEquality(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(3.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCHES), Length.LengthUnit.FEET);
        demonstrateLengthAddition(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCHES), Length.LengthUnit.INCHES);
    }
}
