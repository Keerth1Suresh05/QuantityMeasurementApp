import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
    @Test
    public void testFeetEqualsInches() {
        assertTrue(new Length(1.0, Length.LengthUnit.FEET).equals(new Length(12.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testYardEquals36Inches() {
        assertTrue(new Length(1.0, Length.LengthUnit.YARDS).equals(new Length(36.0, Length.LengthUnit.INCHES)));
    }

    @Test
    public void test100CmEquals39Point37Inches() {
        assertTrue(new Length(100.0, Length.LengthUnit.CENTIMETERS).equals(new Length(39.37, Length.LengthUnit.INCHES)));
    }

    @Test
    public void testFeetNotEqualToYards() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET).equals(new Length(1.0, Length.LengthUnit.YARDS)));
    }

    @Test
    public void testDifferentValuesSameUnitNotEqual() {
        assertFalse(new Length(1.0, Length.LengthUnit.FEET).equals(new Length(2.0, Length.LengthUnit.FEET)));
    }

    @Test
    public void testConvertFeetToInches() {
        Length converted = new Length(3.0, Length.LengthUnit.FEET).convertTo(Length.LengthUnit.INCHES);
        assertEquals(new Length(36.0, Length.LengthUnit.INCHES), converted);
    }

    @Test
    public void testConvertYardsToFeet() {
        Length converted = new Length(2.0, Length.LengthUnit.YARDS).convertTo(Length.LengthUnit.FEET);
        assertEquals(new Length(6.0, Length.LengthUnit.FEET), converted);
    }

    @Test
    public void testConvertCmToFeet() {
        Length converted = new Length(30.48, Length.LengthUnit.CENTIMETERS).convertTo(Length.LengthUnit.FEET);
        assertEquals(new Length(1.0, Length.LengthUnit.FEET), converted);
    }

    @Test
    public void testAddFeetAndInches() {
        Length sum = new Length(1.0, Length.LengthUnit.FEET).add(new Length(12.0, Length.LengthUnit.INCHES));
        assertEquals(new Length(2.0, Length.LengthUnit.FEET), sum);
    }

    @Test
    public void testAddYardsAndFeet() {
        Length sum = new Length(2.0, Length.LengthUnit.YARDS)
                .add(new Length(1.0, Length.LengthUnit.FEET));
        assertEquals(new Length(2.33, Length.LengthUnit.YARDS), sum);
    }

    @Test
    public void testAddCentimetersAndInches() {
        Length sum = new Length(100.0, Length.LengthUnit.CENTIMETERS)
                .add(new Length(10.0, Length.LengthUnit.INCHES));
        assertEquals(new Length(125.40, Length.LengthUnit.CENTIMETERS), sum);
    }
}