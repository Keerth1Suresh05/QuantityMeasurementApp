import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {
    @Test
    public void testFeetEqualsInches() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);
        assertTrue(feet.equals(inches));
    }

    @Test
    public void testYardEquals36Inches() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);
        assertTrue(yard.equals(inches));
    }

    @Test
    public void test100CmEquals39Point37Inches() {
        Length cm = new Length(100.0, Length.LengthUnit.CENTIMETERS);
        Length inches = new Length(39.37, Length.LengthUnit.INCHES);
        assertTrue(cm.equals(inches));
    }

    @Test
    public void testFeetNotEqualToYards() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        assertFalse(feet.equals(yard));
    }

    @Test
    public void testDifferentValuesSameUnitNotEqual() {
        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testConvertFeetToInches() {
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length converted = feet.convertTo(Length.LengthUnit.INCHES);
        assertEquals(new Length(36.0, Length.LengthUnit.INCHES), converted);
    }

    @Test
    public void testConvertYardsToFeet() {
        Length yards = new Length(2.0, Length.LengthUnit.YARDS);
        Length converted = yards.convertTo(Length.LengthUnit.FEET);
        assertEquals(new Length(6.0, Length.LengthUnit.FEET), converted);
    }

    @Test
    public void testConvertCmToFeet() {
        Length cm = new Length(30.48, Length.LengthUnit.CENTIMETERS);
        Length converted = cm.convertTo(Length.LengthUnit.FEET);
        assertEquals(new Length(1.0, Length.LengthUnit.FEET), converted);
    }

    @Test
    public void testEqualsReturnsFalseForNull() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertNotEquals(feet, null);
    }

    @Test
    public void testEqualsReturnsFalseForDifferentClass() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        String notLength = "Not a Length";
        assertNotEquals(feet, notLength);
    }

    @Test
    public void testReferenceEquality() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        assertEquals(feet, feet);
    }

    @Test
    public void testToStringFormatting() {
        Length feet = new Length(1.234, Length.LengthUnit.FEET);
        assertEquals("1.23 FEET", feet.toString());
    }
}