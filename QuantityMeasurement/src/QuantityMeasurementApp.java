class Length{
    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor){
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor(){
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit){
        this.value = value;
        this.unit = unit;
    }

    public double convertToBaseUnit(){
        return this.value*this.unit.getConversionFactor();
    }

    public boolean compare(Length thatLength){
        return Double.compare(this.convertToBaseUnit(),thatLength.convertToBaseUnit())==0;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length that = (Length) o;
        return this.compare(that);
    }
    /*
    public static void main(String[] args){
        Length length1 = new Length(1.0,LengthUnit.FEET);
        Length length2 = new Length(12.0,LengthUnit.INCHES);
        System.out.println("are lengths equal? "+length1.equals(length2));
    }
     */

}

public class QuantityMeasurementApp {

    public static void demonstrateFeetEquality() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        System.out.println("Feet equality: " + length1.equals(length2));
    }

    public static void demonstrateInchesEquality() {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        System.out.println("Inches equality: " + length1.equals(length2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        System.out.println("Feet vs Inches equality: " + length1.equals(length2));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}
