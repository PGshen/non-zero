package com.conpany.project;

import java.util.Scanner;

/**
 * Created by PG_shen
 * Date : 3/10/18
 * Time : 8:16 PM
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count = count(number);
        System.out.println(count);
    }
    public static boolean isPrimeNumber(int N){
        if( N < 2 ) return false;

        for( int i = 2 ; i*i <= N; i++){

            if( N % i == 0) return false;

        }
        return true;
    }

    public static int count(int N){
        int count = 0;
        for (int i = 2; i < N; i++){
            if (isPrimeNumber(i)){
                for (int j = 2; j < N ; j++){
                    //避免重复
                    if(j==i || (N-i-j ==i) || (N-i-j ==j))
                        continue;
                    if (isPrimeNumber(j) && isPrimeNumber(N - i - j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
