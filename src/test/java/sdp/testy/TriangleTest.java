package sdp.testy;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenOneSideIsZero() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("The sides of the triangle may not be smaller than or equal to 0");
        Triangle triangle = new Triangle(2,3,0);
        triangle.getType();
    }

    @Test
    public void shouldThrowExceptionWhenSumOfTwoSideLessThanThirdSide() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("The sum of two sides cannot be less than or equal to the third side");
        Triangle triangle = new Triangle(2,4,1);
        triangle.getType();
    }

    @Test
    public void shouldThrowExceptionWhenSumOfTwoSideEqualsThirdSide() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("The sum of two sides cannot be less than or equal to the third side");
        Triangle triangle = new Triangle(2,4,2);
        triangle.getType();
    }

    @Test
    public void testWhenTwoSidesAreEqual() throws Exception {
        Triangle triangle = new Triangle(2,3,2);
        Assert.assertEquals(triangle.getType(), TriangleType.ISOSCELES.name);
    }

    @Test
    public void testWhenThreeSidesAreEqual() throws Exception {
        Triangle triangle = new Triangle(3,3,3);
        Assert.assertEquals(triangle.getType(), TriangleType.EQUILATERAL.name);
    }

    @Test
    public void testWhenAllSidesAreDifferent() throws Exception {
        Triangle triangle = new Triangle(3,4,2);
        Assert.assertEquals(triangle.getType(), TriangleType.SCALENE.name);
    }

    @Test
    public void testWhenAllSidesAreDifferentButSumOfTwoSideLessThanThirdSide() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("The sum of two sides cannot be less than or equal to the third side");
        Triangle triangle = new Triangle(2,4,1);
        triangle.getType();
    }

    @Test
    public void testWhenOneSideIsNegative() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("The sides of the triangle may not be smaller than or equal to 0");
        Triangle triangle = new Triangle(2,4,-1);
        triangle.getType();

    }


}
