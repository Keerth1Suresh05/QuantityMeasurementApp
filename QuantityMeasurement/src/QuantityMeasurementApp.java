public class QuantityMeasurementApp {
    public static class Feet{
        private final double value;

        public Feet(double value){
            this.value = value;
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj) return true;
            if (obj == null) return false;
            if (obj.getClass() != this.getClass()) return false;
            if(Double.compare(this.value,((Feet) obj).value)==0) return true;
            else return false;
        }
    }

    public static class Inches{
        private final double value;

        public Inches(double value){
            this.value = value;
        }

        @Override
        public boolean equals(Object obj){
            if (this == obj) return true;
            if (obj == null) return false;
            if (obj.getClass() != this.getClass()) return false;
            if(Double.compare(this.value,((Inches) obj).value)==0) return true;
            else return false;
        }
    }

    public static void demonstrateFeetEquality(){
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        System.out.println(f1.equals(f2));
    }

    public static void demonstrateInchesEquality(){
        Inches in1 = new Inches(1.0);
        Inches in2 = new Inches(1.0);
        System.out.println(in1.equals(in2));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();

    }
}
