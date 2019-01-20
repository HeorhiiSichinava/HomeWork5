package com.alevel.hw5.Part2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        System.out.println("array: " + Arrays.toString(array1));
        System.out.println("21) Print all number segment from C to D:" + Arrays.toString(segmentAB(array1, 2, 12)));
        System.out.println("22) Print all number greaters M: " + Arrays.toString(numbersGreaterThanM(array1, 21)));
        int[] array2 = {0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1};
        System.out.println("array: " + Arrays.toString(array2));
        System.out.println("23) Sort the numbers firs zeros then ones:\n   -> " + Arrays.toString(sortZeroOne(array2)));
        int[] array3 = {-44, -24, -23, -16, 5, 3, 6, 12, 22, 21, 1, 2, -22, -42, -3, 2, 21, -25};
        System.out.println("array: " + Arrays.toString(array3));
        System.out.println("24 replace the numbers that give a larger modulo value than the maximum number:\n   ->" + Arrays.toString(replaceNumbersModuloWhoseValueGreaterMaximumNumber(array3)));
        int[] array4 = {80, 61, 42, 13, 34, 55, 16, 47, 80, 1, 0, 0, 1, 1, 23, 74, 35, 46, 0, 1, 22, 9, 2, 21, 80, 80};
        System.out.println("array: " + Arrays.toString(array4));
        System.out.println("25) Maximum value of sum (a1+a2n, a2+a2n-1, an+an+1): " + maximumValueSum(array4));
        System.out.println("26) Who is greater than the sum of positive numbers or the sum of negative numbers:" + whoIsGreaterSumP1OrSumP2(array3));
        System.out.println("27) Replace first great number to zero: " + Arrays.toString(firstMaximumValueNumberReplaceZero(array4)));
        System.out.println("28) Insert a new number so that the sequence is increasing: " + Arrays.toString(addNumberInArray(array1, 23)));
        int[] array5 = {25, 4, 9, 36, 81, 64, 49, 1, 100, 400, 361, 256, 289, 196, 289, 324, 225, 144, 121};
        System.out.println("29) Squares of number N = [8]:" + Arrays.toString(squaresOfNumberN(array5, 8)));
        System.out.println("30) Remove the minimum value numbers:\n   ->" + Arrays.toString(removeTheMinimumNumbers(array4)));
//        System.out.println("31)---");
        System.out.println("32) password: " + Arrays.toString(secretLock(6, 3)));
        System.out.println("33) The most encountered numbers: " + mostEncounteredNumbers(array4));
        String[] weather = {"overcast weather", "overcast weather", "overcast weather", "overcast weather", "overcast weather",
                "sunny day", "sunny day", "sunny day", "sunny day", "sunny day",
                "sunny day", "sunny day", "sunny day", "sunny day", "sunny day",
                "sunny day", "sunny day", "sunny day", "sunny day", "sunny day",
                "sunny day", "sunny day", "sunny day", "sunny day", "sunny day",
                "overcast weather", "overcast weather", "overcast weather", "overcast weather", "overcast weather"};

        System.out.println("34) Position snail over earth: " + snailPositionOverEarth(weather, 25, 1));
        System.out.println("35) Zip archiv:\n   ->" + Arrays.toString(zipArray(array5)));
    }

    //////////////////////////////////////////////////////////
    //21
    public static int[] segmentAB(int[] array, int pointC, int pointD) {
        int count = 0, c = 0, d = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= pointC && array[i] <= pointD) {
                c = array[i - 1] < pointC && array[i] >= pointC ? i : c;
                d = array[i] <= pointD ? i + 1 : d;
            }
        }
        int[] segmentCD = new int[d - c];
        for (int i = c; i < d; i++) {
            segmentCD[count] = array[i];
            count++;
        }
        return segmentCD;
    }

    //////////////////////////////////////////////////////////
    //22
    public static int[] numbersGreaterThanM(int[] array, int numberM) {
        int count = 0, m = array.length;
        for (int i = 1; i < array.length; i++) {
            m = array[i] > numberM && array[i - 1] <= numberM ? i : m;
        }
        int[] greaterM = new int[array.length - m];
        if (m == array.length) {
            System.out.println("no numbers greater M = [" + numberM + "]");
        } else if (m < array.length) {
            for (int i = m; i < array.length; i++) {
                greaterM[count] = array[i];
                count++;
            }
        }
        return greaterM;
    }

    //////////////////////////////////////////////////////////
    //23
    public static int[] sortZeroOne(int[] array) {
        int countOneAndZero = 0;
        for (int i = 0; i < array.length; i++) {
            countOneAndZero += array[i] == 0 || array[i] == 1 ? 1 : 0;
        }
        int[] sort = new int[countOneAndZero];
        int indexZero = 0, indexOne = countOneAndZero;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                sort[indexZero] = array[i];
                indexZero++;
            } else if (array[i] == 1) {
                sort[indexOne - 1] = 1;
                indexOne--;
            }
        }
        System.out.println(" 1 = " + (countOneAndZero - indexOne) + " 0 = " + indexZero);
        return sort;
    }

    //////////////////////////////////////////////////////////
    //24
    public static int[] replaceNumbersModuloWhoseValueGreaterMaximumNumber(int[] array) {
        boolean endReplace = false;
        boolean findMaxValueNumber = false;
        int number = array[0], index = 0;
        while (!endReplace) {
            if (!findMaxValueNumber && index < array.length) {
                number = array[index] > number ? array[index] : number;
                findMaxValueNumber = index + 1 == array.length ? true : false;
                index++;
            } else if (findMaxValueNumber) {
                index--;
                array[index] = Math.abs(array[index]) > number ? 0 : array[index];
                endReplace = index == 0 ? true : false;
            }
        }
        System.out.println("max value: " + number);
        return array;
    }

    //////////////////////////////////////////////////////////
    //25
    public static int maximumValueSum(int[] array) {
        int maxSum = 0, sum = 0, indexAN = array.length - 1;
        if (array.length % 2 == 0) {
            for (int i = 0; i <= indexAN; i++) {
                if (i != (indexAN - i)) {
                    sum = (array[i] + array[indexAN - i]);
                    maxSum = sum > maxSum ? sum : maxSum;
                }
//            else maxSum = array[i]>maxSum? array[i]:maxSum;
            }
        } else System.out.println("The size of your sequence does not satisfy condition A = 2n");
        return maxSum;
    }

    //////////////////////////////////////////////////////////
    //26
    public static int whoIsGreaterSumP1OrSumP2(int[] array) {
        int positiv = 0, negativ = 0, resultGreater = 0;
        for (int i = 0; i < array.length; i++) {
            positiv += array[i] > 0 ? array[i] : 0;
            negativ += array[i] < 0 ? array[i] : 0;
        }
        return resultGreater = positiv > sumMod(negativ) ? positiv : negativ;
    }

    //////////////////////////////////////////////////////////
    //27
    public static int[] firstMaximumValueNumberReplaceZero(int[] array) {
        boolean replaceFirstGreatNumber = false;
        int greatNumber = array[array.length - 1];
        int index = array.length - 1;
        int indexFirstGreatNumber = 0;
        while (!replaceFirstGreatNumber) {
            if (index >= 0) {
                indexFirstGreatNumber = array[index] >= greatNumber ? index : indexFirstGreatNumber;
                greatNumber = array[index] > greatNumber ? array[index] : greatNumber;
                index--;
            } else {
                array[indexFirstGreatNumber] = 0;
//                replaceFirstGreatNumber=true;
                break;
            }
        }
        return array;
    }

    //////////////////////////////////////////////////////////
    //28
    public static int[] addNumberInArray(int[] oldArray, int addNumber) {
        int indexNewArray = 0, indexOldArray = 0;
        boolean addNewNumber = false;
        int[] newArray = new int[oldArray.length + 1];
        while (indexNewArray < newArray.length) {
            if (!addNewNumber) {
                if (indexOldArray < oldArray.length) addNewNumber = addNumber <= oldArray[indexOldArray] ? true : false;
                if (addNewNumber || indexOldArray == oldArray.length) {
                    newArray[indexNewArray] = addNumber;
                    indexNewArray++;
                } else if (!addNewNumber) {
                    newArray[indexNewArray] = oldArray[indexOldArray];
                    indexNewArray++;
                    indexOldArray++;
                }
            } else if (addNewNumber) {
                newArray[indexNewArray] = oldArray[indexOldArray];
                indexNewArray++;
                indexOldArray++;
            }
        }
        return newArray;
    }

    //////////////////////////////////////////////////////////
    //29
    public static int[] squaresOfNumberN(int[] array, int squaresOfNumber) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += squareRoot(array[i]) == squaresOfNumber ? 1 : 0;
        }
        int[] addNumberOfNewArray = new int[count];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (squareRoot(array[i]) == squaresOfNumber) {
                addNumberOfNewArray[count] = array[i];
                count++;
            }
        }

        return addNumberOfNewArray;
    }

    //////////////////////////////////////////////////////////
    //30
    public static int[] removeTheMinimumNumbers(int[] array) {
        if (array.length > 1) {
            int lengthNewArray = array.length;
            int minimumValueNumber = Integer.MAX_VALUE;
            boolean findMinNumber = false;
            int index = lengthNewArray - 1;

            while (lengthNewArray <= array.length) {
                if (!findMinNumber) {
                    minimumValueNumber = array[index] < minimumValueNumber ? array[index] : minimumValueNumber;
                    findMinNumber = index - 1 == 0 ? true : false;
                    index--;
                } else if (findMinNumber && index < array.length) {
                    lengthNewArray -= array[index] == minimumValueNumber ? 1 : 0;
                    index++;
                } else break;
            }
            int[] newArray = new int[lengthNewArray];
            index = 0;

            for (int i = 0; i < array.length; i++) {
                if (array[i] != minimumValueNumber) {
                    newArray[index] = array[i];
                    index++;
                } else continue;
            }
            return newArray;
        } else return null;
    }

    //////////////////////////////////////////////////////////
    //31
    public static int timeInLine(int timeInSecondToServiceOneCustomer, int sequenceNumberInTheQueue) {
        return timeInSecondToServiceOneCustomer * sequenceNumberInTheQueue;
    }

    //////////////////////////////////////////////////////////
    //32
    public static int[] secretLock(int number1, int number2) {
        if ((number1 > 0 && number1 < 7) && (number2 > 0 && number2 < 7)) {
            int[] pass = new int[10];
            int setIndex1 = 0, setIndex2 = 5;
            pass[setIndex1] = number1;
            pass[setIndex2] = number2;
            boolean lockPass = false;
            boolean chek = true;
            int index = 0, num1 = 0, num2 = 0, num3 = 0;
            int summ=0;
            while (!lockPass) {
                if (index < 9) {

                        chek = chekSumm(pass[index], pass[index + 1], pass[index + 2]) == 10 ? true : false;


                    System.out.println(index+" - "+Arrays.toString(pass));

                    if (chek) {
                        index++;
                    }
                    else if(!chek){
                      summ =  chekSumm(pass[index], pass[index + 1], pass[index + 2]);
                      if(summ>10){
                          System.out.println("test1");
                            if(!(index+2==setIndex1 || index+2==setIndex2)){
                                pass[index+2]= pass[index+2]>1 ?-1 : 0;
                            }
                            else if(!(index+1==setIndex1 || index+1==setIndex2)) {
                                pass[index+1]-= pass[index+1]>1 ?1 : 0;
                                if (index>0&&!(index==setIndex1 || index==setIndex2)){
                                    pass[index]+=1;
                                }
                                if(!(index==setIndex1 || index==setIndex2)) {
                                    pass[index]= pass[index]>1 ?-1 : 0;
                                }
                            }

                        }
                      else if(summ<10){
                          System.out.println("test2");
                          if(!(index+2==setIndex1 || index+2==setIndex2)){
                              pass[index+2]+= pass[index+2]<6 ?1 : 0;
                          }
                          else if(!(index+1==setIndex1 || index+1==setIndex2)) {
                              pass[index+1]+= pass[index+1]<6 ?1 : 0;
                              if (index>0&&!(index==setIndex1 || index==setIndex2)&&summ>10){
                                  pass[index]=0;
                              }
                              if(pass[index+1]==6) {
                                  pass[index]+= pass[index]<6 ?1 : 0;
                              }
                          }
                      }
                    }
                }
                lockPass = index==8 ? true : false;
            }
            return pass;
        } else if (number1 > 6) {
            String[] error = {"error number 1, a combination of numbers from 1 to 6"};
            return null;
        } else if (number2 > 6) {
            String[] error = {"error number 1, a combination of numbers from 1 to 6"};
            return null;
        } else return null;
    }

    //////////////////////////////////////////////////////////
    //33
    public static int mostEncounteredNumbers(int[] number) {
        int result = 0;
        int currentQuantity = 0, largeQuantity = 0;
        for (int i = 0; i < number.length; i++) {
            currentQuantity = 0;
            for (int j = 0; j < number.length; j++) {
                currentQuantity += number[i] == number[j] ? 1 : 0;
            }
            result = currentQuantity > largeQuantity ||
                    (currentQuantity == largeQuantity && number[i] < result) ?
                    number[i] : result;
            largeQuantity = currentQuantity > largeQuantity ? currentQuantity : largeQuantity;
        }
        return result;
    }

    //////////////////////////////////////////////////////////
    //34
    public static String snailPositionOverEarth(String[] weather, int positionSnailInCentimeters, int sizeTreeInMeters) {
        String positionSnail = "";
        int newPositionSnail = positionSnailInCentimeters;
        boolean maximumUpperPosition = false;
        boolean minimumBottomPosition = false;
        for (int i = 0; i < weather.length; i++) {
            maximumUpperPosition = newPositionSnail == sizeTreeInMeters * 100 ? true : false;
            minimumBottomPosition = newPositionSnail == 0 ? true : false;
            if (!maximumUpperPosition && !minimumBottomPosition) {
                newPositionSnail -= weather[i] == "overcast weather" ? 1 : 0;
                newPositionSnail += weather[i] == "sunny day" ? 2 : 0;
                newPositionSnail = newPositionSnail > sizeTreeInMeters * 100 ? sizeTreeInMeters * 100 : newPositionSnail;
            } else if (maximumUpperPosition) {
                newPositionSnail -= weather[i] == "overcast weather" ? 1 : 0;
            } else if (minimumBottomPosition) {
                newPositionSnail += weather[i] == "sunny day" ? 2 : 0;
            }
//            System.out.println("snail: "+newPositionSnail+" cm");
        }
        return positionSnail = "" + newPositionSnail + " cm over earth.";
    }

    //////////////////////////////////////////////////////////
    //35

    public static double[] zipArray(int[] array) { //in work
        int index = 0;
        double[] zip = new double[array.length / 2];
        for (int i = 1; i < array.length; i += 2) {
            zip[index] = (double) array[i - 1] + zeroShiftToRightSide(array[i]);
            index++;
        }
        return zip;
    }

    //------------------------------------------------------------------------------
    //////////////////////////////////////////////////////////
    //return square of number N
    public static double squareRoot(int number) {
        double result = 0.0;
        boolean end = false;
        double square = 0.01;

        while (!end) {
            result = square * square <= number ? square : 0;
            end = ((square + 0.01) * (square + 0.01)) > number ? true : false;
            square += 0.01;
        }
        return result;
    }

    //////////////////////////////////////////////////////////
    //modulo amount
    public static int sumMod(int number) {
        return number = number < 0 ? number - 2 * number : number;
    }
    //////////////////////////////////////////////////////////
    //summ 3 numbers
    public static int chekSumm (int number1, int number2, int number3){
        return number1+number2+number3;
    }

    public static double zeroShiftToRightSide(int number) {
        double zeroRight = number;
        while (zeroRight >= 1) {
            zeroRight /= 10;
        }
        return zeroRight;
    }
}
