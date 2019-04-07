package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {
    @Test
    public void IITestPass() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("II");
        assertEquals(converter.toArabic(), 2);
    }



    @Test
    public void MMTestPass() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("MM");
        assertEquals(converter.toArabic(), 2000);
    }


    @Test
    public void CCTestPass() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("CC");
        assertEquals(converter.toArabic(), 200);
    }


    @Test
    public void XXTestPass() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("XX");
        assertEquals(converter.toArabic(), 20);
    }

    @Test
    public void NTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNN");
        assertEquals(converter.toArabic(), 9000);
    }


    @Test
    public void DTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("DDD");
        assertEquals(converter.toArabic(), 900);
    }

    @Test
    public void YTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("YYY");
        assertEquals(converter.toArabic(), 90);
    }

    @Test
    public void JTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("JJJ");
        assertEquals(converter.toArabic(), 9);
    }




    @Test
    public void Con() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NNMDYYYJI");
        assertEquals(converter.toArabic(), 7394);
    }

    @Test
    public void Con1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("7394");
        assertEquals(converter.toElbonian(), "NNMDYYYJI");
    }

    @Test
    public void Con2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("23");
        assertEquals(converter.toElbonian(), "XXJ");
    }





    @Test(expected = ValueOutOfBoundsException.class)
    public void OutOfBoundsLowTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("0");
    }


    @Test(expected = MalformedNumberException.class)
    public void IllegalSpaceArabicTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9 9");
    }

    @Test(expected = MalformedNumberException.class)
    public void IllegalSpaceElbonianTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I I");
    }

    @Test(expected = MalformedNumberException.class)
    public void CheckEmpty () throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("        ");
    }
    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3000");
        assertEquals(converter.toElbonian(), "N");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("NI");
        assertEquals(converter.toArabic(), 3001);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    // TODO Add more test cases
}
