package com.company;

import com.alibaba.fastjson.JSON;
import lombok.Getter;

import java.io.*;

public class Triangle implements ITriangle, Serializable
{
    @Getter
    protected final double side1;
    protected final double side2;
    protected final double side3;

    public Triangle(double side1, double side2, double side3)
    {
            this.side1 = setSide(side1);
            this.side2 = setSide(side2);
            this.side3 = setSide(side3);
    }

    public boolean ExistsTriangles()
    {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }


    public double setSide(double side)
    {
        return side > 0 ? side : 1;
    }

    public double getPerimeter()
    {
        return side1 + side2 + side3;
    }

    public double getAngle1()
    {
        return (double) Math.round( Math.toDegrees( Math.acos(( Math.pow(side2, 2) + Math.pow(side3, 2) - Math.pow(side1, 2) ) / (2 * side2 * side3))));
    }
    public double getAngle2()
    {
        return (double) Math.round(Math.toDegrees( Math.acos(( Math.pow(side1, 2) + Math.pow(side3, 2) - Math.pow(side2, 2) ) / (2 * side1 * side3))));
    }
    public double getAngle3()
    {
        return (double) Math.round( Math.toDegrees( Math.acos(( Math.pow(side1, 2) + Math.pow(side2, 2) - Math.pow(side3, 2) ) / (2 * side1 * side2))));
    }
    public String Save() throws IOException
    {
        String save = getInfoOfTriangle();
        String fileSave = "save_s.txt";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileSave, true));
        out.writeObject(save + "\n");
        System.out.println("Треугольники:\n");
        out.close();
        return save;
    }
    /*public void Load() throws IOException,ClassNotFoundException
    {
        String fileSave = "save_s.txt";
        FileInputStream fileIn = new FileInputStream(fileSave);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        in.readObject();
        in.close();
    }*/
    /*public String Save() throws IOException
    {
        String save = getInfoOfTriangle();
        String fileSave = "save_s.txt";
        BufferedWriter file = new BufferedWriter(new FileWriter(fileSave, true));
        file.write(save + "\n");
        System.out.println("????????????:\n");
        file.newLine();
        file.close();
        return save;
    }*/
    public String Load() throws IOException
    {
        StringBuilder loadString = new StringBuilder();
        String fileName = "save_s.txt";
        BufferedReader load = new BufferedReader(new FileReader(fileName));

        while ((fileName = load.readLine()) != null)
        {
            loadString.append('\n').append(fileName);
        }
        load.close();
        return loadString.toString();
    }

    public String saveFastJSON() throws IOException
    {
        String save = getInfoOfTriangle();
        String fileSave = "save_sJSON.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileSave,true));
        bw.write(JSON.toJSONString(save));
        System.out.println("\n");
        System.out.println("Треугольники:\n");
        bw.newLine();
        bw.close();
        return save;
    }
    public String loadFastJSON()throws IOException
    {
        StringBuilder loadString = new StringBuilder();
        String fileName = "save_sJSON.txt";
        BufferedReader load = new BufferedReader(new FileReader(fileName));
        while ((fileName = load.readLine()) != null)
        {
            loadString.append('\n').append(fileName);
        }
        load.close();
        return loadString.toString();
    }
    @Override
    public double getSquare()
    {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String getInfoOfTriangle()
    {   if (!this.ExistsTriangles())
        {
            return "\nТакой треугольник не существует \nSide1:" + side1 + "\nSide2:" + side2 + "\nSide3:" + side3;
        }
        return "Side 1:" + side1 + "\nSide 2:" + side2 + "\nSide 3:" + side3 + "\nAngle1:" + getAngle1() + "\nAngle2:" + getAngle2() + "\nAngle3:" + getAngle3() + "\nPerimeter:" + getPerimeter() + "\nSquare:" + getSquare();
    }

}