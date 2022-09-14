package com.string;

import java.util.Optional;

/**
 * String操作实例
 */
public class StringManipulation {

    //字符串截取
    private static void useAgeOfSubString(){
        String str="helloworld";
        System.out.println("first 5 words are :"+str.substring(0,5));
        System.out.println("last 5 words are :"+str.substring(str.length()-5,str.length()));
    }

    //字符串对比
    private static void useAgeOfCompareTo(){
        String str="abc";
        System.out.println(str.compareTo("cba"));
        System.out.println(str.compareToIgnoreCase("ABC"));
    }

    //字符串比较
    private static void useAgeOfEquals(){
        String a="abc";
        String b="abc";
        String c=new String("abc");
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a==b);
        System.out.println(a==c);
    }

    /**
     * 回文检查
     * 回文：如abcba,12321
     */
    private static boolean checkPalindrome(String str){
        if(str==null){
            return false;
        }
        if(str.length()<=1){
            return true;
        }
        String first=str.substring(0,1);
        String last=str.substring(str.length()-1);
        if(!first.equals(last)){
            return false;
        }else{
            return checkPalindrome(str.substring(1,str.length()-1));
        }
    }

    //字符串与字符互转
    private static void stringToChar(){
        String str="helloworld";
        char [] chars=str.toCharArray();

        char c=str.charAt(2);
        char []chars1=new char[10];
        str.getChars(0,10,chars1,0);
        System.out.println(chars1);
    }

    //字符串分割
    private static void useAgeOfSplit(){
        String str="hello-world";
        String [] strs=str.split("-");
        System.out.println(strs[0]);
        System.out.println(strs[1]);
    }

    public static void main(String[] args) {
//        useAgeOfSubString();
//        useAgeOfCompareTo();
//        useAgeOfEquals();
//        System.out.println(checkPalindrome("abcba"));
//        stringToChar();
        useAgeOfSplit();
    }
}
