package sdp.testy;

import lombok.Data;

@Data
public class Triangle {

    private Integer a;
    private Integer b;
    private Integer c;

    public Triangle(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getType() throws Exception {
        if((getA() <= 0 || getB() <= 0 || getC() <= 0)){
            throw new Exception("The sides of the triangle may not be smaller than or equal to 0");

        } else if(getA() + getB() <= getC() || getA() + getC() <= getB() || getC()+getB() <= getA()){
            throw new Exception("The sum of two sides cannot be less than or equal to the third side");
        } else{
            if(!getA().equals(getB()) && !getA().equals(getC()) && !getB().equals(getC())){
                return TriangleType.SCALENE.name;
            } else if(getA().equals(getB()) && getA().equals(getC()) && getB().equals(getC())){
                return  TriangleType.EQUILATERAL.name;
            } else{
                return TriangleType.ISOSCELES.name;
            }
        }
    }

}
