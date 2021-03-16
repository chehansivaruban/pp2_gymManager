//package com.company;
//
//public class BubbleSort {
//
//    public static void bubbleSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; i < arr.length - (i + 1); j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j + 1] = temp;
//                }
//            }
//
//        }
//    }
//    public static void bubbleSort(int[] arr,boolean asc) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; i < arr.length - (i + 1); j++) {
//                if(asc){
//                    if (arr[j] > arr[j + 1]) {
//                        int temp = arr[j];
//                        arr[j] = arr[j+1];
//                        arr[j + 1] = temp;
//                    }
//                }
//                else{
//                    if (arr[j] < arr[j + 1]) {
//                        int temp = arr[j];
//                        arr[j] = arr[j+1];
//                        arr[j + 1] = temp;
//                    }
//                }
//            }
//
//        }
//    }
//
//    public static <T extends Comparable<T>> void bubbleSort(DefaultMember[] arr,boolean asc){
//        for (int i = 0; i < arr.length-1; i++){
//            for(int j = 0; j < arr.length-(i+1); j++){
//                if(asc){
//                    if (arr[j].compareTo(arr[j+1]) > 0){
//                        DefaultMember temp = arr[j];
//                        arr[j] = arr[j + 1];
//                        arr[j+1] = temp;
//                    }
//                }
//                else{
//                    if (arr[j].compareTo(arr[j+1]) < 0){
//                        DefaultMember temp = arr[j];
//                        arr[j] = arr[j + 1];
//                        arr[j+1] = temp;
//                    }
//                }
//            }
//        }
//    }
//}
