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

    public static boolean demonstrateLengthComparison(double value1, Length.LengthUnit unit1, double value2, Length.LengthUnit unit2) {
        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);
        boolean result = l1.equals(l2);
        System.out.println(value1 + " " + unit1 + " equals " + value2 + " " + unit2 + " ? " + result);
        return result;
    }

    public static Length demonstrateLengthConversion(double value, Length.LengthUnit fromUnit,
                                                     Length.LengthUnit toUnit) {
        Length source = new Length(value, fromUnit);
        Length converted = source.convertTo(toUnit);
        System.out.println(source + " converted to " + toUnit + " = " + converted);
        return converted;
    }

    public static void main(String[] args) {
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES);
        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETERS, 39.3701, Length.LengthUnit.INCHES);

        demonstrateLengthConversion(3.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        demonstrateLengthConversion(2.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);
        demonstrateLengthConversion(30.48, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.FEET);
    }
}
