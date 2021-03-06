package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("How many of each suit?");
        int dupes = getNumInput();
        System.out.println("How many suits?");
        int numSuits = getNumInput();
        String[] suits = new String[numSuits];
        for(int i = 0; i < numSuits; i++)
        {
            System.out.println("What is the name of suit " + (i + 1) + "?");
            suits[i] = getStringInput();
        }
        System.out.println("Enter lowest card and highest card. (2 Numbers separated by a space)");
        int lowCard = 0;
        int highCard = 0;
        while(lowCard < 1)
        {
            try
            {
                String loHi[] = getStringInput().split(" ");
                lowCard = Integer.parseInt(loHi[0]);
                highCard = Integer.parseInt(loHi[1]);
                if(lowCard > highCard)
                    throw new Exception();
            } catch(Exception e)
            {
                System.out.println("Low card must be less than highest card.");
                lowCard = 0;
                highCard = 0;
            }
        }
        System.out.println("Standard face? y/n");
        boolean face = getStringInput().equalsIgnoreCase("y");
        ArrayList<String> extras = new ArrayList<>();
        System.out.println("Extra cards and amount? (card amount card amount...)");
        boolean success = false;
        while(!success)
        {
            try
            {
                String[] extraCards = getStringInput().split(" ");
                if(extraCards.length > 1)
                {
                    for(int i = 1; i < extraCards.length; i += 2)
                    {
                        if(Integer.parseInt(extraCards[i]) < 1)
                            throw new Exception();
                    }
                    for(int i = 0; i < extraCards.length; i += 2)
                    {
                        for(int j = 0; j < Integer.parseInt(extraCards[i + 1]); j++)
                        {
                            extras.add(extraCards[i]);
                        }
                    }
                }
                success = true;
            }
            catch(Exception e)
            {
                System.out.println("Extra cards must have positive integer amounts.");
                extras.clear();
            }
        }
        for(int i = 0; i < dupes; i++)
        {
            for(int j = 0; j < numSuits; j++)
            {
                for(int k = lowCard; k <= highCard; k++)
                {
                    System.out.println(k + " of " + suits[j]);
                }
                if(face)
                {
                    System.out.println("Jack of " + suits[j]);
                    System.out.println("Queen of " + suits[j]);
                    System.out.println("King of " + suits[j]);
                    System.out.println("Ace of " + suits[j]);
                }
            }
        }
        for(String s : extras)
            System.out.println(s);
    }

    public static int getNumInput()
    {
        Scanner input = new Scanner(System.in);
        int ret = 0;
        while(ret < 1)
        try
        {
            ret = input.nextInt();
            if(ret < 1)
                throw new Exception();
        }
        catch(Exception e)
        {
            System.out.println("Numbers must be integers greater than 0");
            input.nextLine();
        }
        return ret;
    }

    public static String getStringInput()
    {
        Scanner input = new Scanner(System.in);
        String ret = input.nextLine();
        return ret;
    }
}
