import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class QuantityMeasurementAppTest {
    @Test
    public void testFeetEquality_SameValue(){
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);
        assertEquals(f1, f2);
    }

    @Test
    public void testFeetEquality_DifferentValue(){
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);
        assertNotEquals(f1,f2);
    }

    @Test
    public void testFeetEquality_NullComparison(){
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        assertNotEquals(null, f1);
    }

    @Test
    public void testFeetEquality_DifferentClass(){
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        String obj = "not a feet";
        assertNotEquals(obj, f1);
    }

    @Test
    public void testFeetEquality_SameReference(){
        QuantityMeasurementApp.Inches f1 = new QuantityMeasurementApp.Inches(1.0);
        assertEquals(f1,f1);
    }

    @Test
    public void testInchesEquality_SameValue(){
        QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(1.0);
        assertEquals(i1, i2);
    }

    @Test
    public void testInchesEquality_DifferentValue(){
        QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches i2 = new QuantityMeasurementApp.Inches(2.0);
        assertNotEquals(i1,i2);
    }

    @Test
    public void testInchesEquality_NullComparison(){
        QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(1.0);
        assertNotEquals(null, i1);
    }

    @Test
    public void testInchesEquality_DifferentClass(){
        QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(1.0);
        String obj = "not an Inch";
        assertNotEquals(obj, i1);
    }

    @Test
    public void testInchesEquality_SameReference(){
        QuantityMeasurementApp.Inches i1 = new QuantityMeasurementApp.Inches(1.0);
        assertEquals(i1,i1);
    }
}