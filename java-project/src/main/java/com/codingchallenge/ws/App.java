package com.codingchallenge.ws;
import com.codingchallenge.ws.zip_set;
import java.util.*;

/**
 * @author: Aniket Agarwal
 */
public class App 
{
        public static void main(String[] args) 
        {
            System.out.println("Enter your Input in this format [XXXXX,XXXXX] [XXXXX,XXXXX] \n");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            zip_util util = new zip_util();
            try 
            {
                zip_set zip_set1Set = util.buildzip_set(input);
                System.out.println("Your input of all your Zip Code Ranges:- \n" + zip_set1Set);
                zip_optimize optimizer = new zip_optimize();
                zip_set optimizedzip_set = optimizer.optimizezip_set(zip_set1Set);
                System.out.println("Optimized Output for Zip Code Ranges:- \n"+ optimizedzip_set);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
    