import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class QuantityMeasurementAppTest {
    @Test
    public void testEquality_YardToYard_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(l1, l2);
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(2.0, Length.LengthUnit.YARDS);
        assertNotEquals(l1, l2);
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);
        assertEquals(l1, l2);
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        Length l1 = new Length(3.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(l1, l2);
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(36.0, Length.LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        Length l1 = new Length(36.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(l1, l2);
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);
        assertNotEquals(l1, l2);
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(0.393701, Length.LengthUnit.INCHES);
        assertEquals(l1, l2);
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        assertNotEquals(l1, l2);
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length yards = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertEquals(yards, feet);
        assertEquals(feet, inches);
        assertEquals(yards, inches); // transitive property
    }

    @Test
    public void testEquality_YardSameReference() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        assertEquals(l1, l1);
    }

    @Test
    public void testEquality_YardNullComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        assertNotEquals(l1, null);
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        Length l1 = new Length(10.0, Length.LengthUnit.CENTIMETERS);
        assertEquals(l1, l1);
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        Length l1 = new Length(10.0, Length.LengthUnit.CENTIMETERS);
        assertNotEquals(l1, null);
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        Length yards = new Length(2.0, Length.LengthUnit.YARDS);
        Length feet = new Length(6.0, Length.LengthUnit.FEET);
        Length inches = new Length(72.0, Length.LengthUnit.INCHES);

        assertEquals(yards, feet);
        assertEquals(feet, inches);
        assertEquals(yards, inches);
    }
}