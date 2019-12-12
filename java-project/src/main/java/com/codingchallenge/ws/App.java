package com.codingchallenge.ws;

import java.util.*;

/**
 * @author: Aniket Agarwal
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Coding Challenge by Williams Sonoma\n Please enter the values: \n" );
        
        List zip_code_range =  new ArrayList();
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(scanner.nextLine());
        while(input.hasNext())
            zip_code_range.add(input.next());
        scanner.close();
        
        

        
    }
}
