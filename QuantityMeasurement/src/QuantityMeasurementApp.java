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

    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        System.out.println(f1.equals(f2));

    }
}
