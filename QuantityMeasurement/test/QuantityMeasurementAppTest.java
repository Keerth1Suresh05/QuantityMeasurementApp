import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class QuantityMeasurementAppTest {
    @Test
    public void testFeetEqualsInches(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        assertEquals(length1, length2);
    }

    @Test
    public void testDifferentLengthsNotEqual(){
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(10.0, Length.LengthUnit.INCHES);
        assertNotEquals(length1, length2);
    }

    @Test
    public void testSameUnitSameValue(){
        Length length1 = new Length(5.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(5.0, Length.LengthUnit.INCHES);
        assertEquals(length1, length2);
    }

    @Test
    public void testNullComparison(){
        Length length1 = new Length(2.0, Length.LengthUnit.FEET);
        assertNotEquals(null, length1);
    }

    @Test
    public void testDifferentClassComparison(){
        Length length1 = new Length(2.0, Length.LengthUnit.FEET);
        String notLength = "Not a Length";
        assertNotEquals(notLength, length1);
    }

    @Test
    public void testSameReference(){
        Length length1 = new Length(3.0, Length.LengthUnit.INCHES);
        assertEquals(length1, length1);
    }
}