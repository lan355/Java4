package com.company;

import java.io.IOException;
import java.io.Serializable;

public class TriangleIsosceles extends Triangle implements ITriangle,Serializable
{
    protected final double height;

    public TriangleIsosceles(double side1, double side2, double side3,double height)
    {
        super(side1, side2, side3);
        this.height = height;
    }

    public boolean ExistsTrianglesIsosceles()
    {
        return side1 == side2 || side1 == side3 || side2 == side3;
    }

    @Override
    public double getSquare()
    {
        return side3 *height/2;
    }

    public String SaveTriangleIsosceles() throws IOException {
        return super.Save();
    }

    @Override
    public String getInfoOfTriangle()
    {
        if (!this.ExistsTrianglesIsosceles())
        {
            return "\nТакой треугольник не существует \nSide1:" + side1 + "\nSide2:" + side2 + "\nSide3:" + side3;
        }
        return "Side 1:" + side1 + "\nSide 2:" + side2 + "\nSide 3:" + side3 + "\nAngle1:" + getAngle1() + "\nAngle2:" + getAngle2() + "\nAngle3:" + getAngle3() + "\nHeight:" + height + "\nPerimeter:" + getPerimeter() + "\nSquare:" + getSquare();

    }
}
