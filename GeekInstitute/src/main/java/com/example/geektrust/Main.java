package com.example.geektrust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.geektrust.appConfig.ApplicationConfig;
import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.exceptions.NoSuchCommandException;

public class Main {

	public static long swapBits(long n) {
        long ans = 0;

        for(int i=30; i>0; i-=2){
            long even = (n>>i) & 1;
            long odd = (n>>(i-1)) & 1;
            System.out.println(Long.toBinaryString(n>>i)+","+Long.toBinaryString(n>>(i-1)));
            if(even!=odd){
                //long temp = 1<<30;
                System.out.print(Long.toBinaryString(n)+"^"+Long.toBinaryString(1<<i)+"=");
                n ^= (1<<i);
                System.out.println(Long.toBinaryString(n));
                System.out.print(Long.toBinaryString(n)+"^"+Long.toBinaryString(1<<(i-1))+"=");
                n ^= 1<<(i-1); 
                System.out.println(Long.toBinaryString(n));
            }
            //System.out.println(Long.toBinaryString(n));
        }
        return n;
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
       // long n = scanner.nextLong();
        //scanner.close();
        long v = 1;
        long po = 31;
        long temp = v<<po;
        System.out.println(temp);
        System.out.println(Long.toBinaryString(temp));
        long result = swapBits(1748556023);
        System.out.println(result);
    }	

}
