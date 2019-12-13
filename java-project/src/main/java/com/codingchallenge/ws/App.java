package com.codingchallenge.ws;

import java.util.*;

/**
 * @author: Aniket Agarwal
 */
public class App 
{
        public static void main(String[] args) 
        {
            System.out.println("Enter your Input of Zip Code Ranges in [XXXXX,XXXXX],[XXXXX,XXXXX]");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            zip_util util = new zip_util();
            try 
            {
                zip_set zip_set = util.buildzip_set(input);
    
                System.out.println("Ok.....Here is the input of all your Zip Code Ranges");
                System.out.println(zip_set);			
                zip_optimize optimizer = new zip_optimize();
                zip_set optimizedzip_set = optimizer.optimizezip_set(zip_set);
                System.out.println("Ok.....Here is the Optimized Zip Code Ranges");
                System.out.println(optimizedzip_set);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
                scanner.close();
        }
    }
    