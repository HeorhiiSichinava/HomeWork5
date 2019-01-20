package com.alevel.hw5.Part3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 0, 2, 3, 4, 0, 0, 3, 0, 5, 6, 6, 4, 6, 3, 6, 9, 0, 4, 4};
        System.out.println("36) Сompress array by removing zeros from it:\n   -> " + Arrays.toString(compressArray(array1)));
        System.out.println("37) Array even numbers and array odd numbers:" + evenArrayOneAndOddArrayTwo(array1));
        System.out.println("38) The product of two numbers is equal to the target: " + Arrays.toString(theProductOfTwoNumbersIsEqualToTheTarget(array1, 9)));
        System.out.println("39) " + Arrays.toString(replaseNumberMinimumValueAverage(array1)));
        int[] array2 = {-3, 4, 5, 2, 3, -4, 0, 3, 4, 3, 0, 0, 3, 7, 3, -3, -8, 0, 3, 5, 4};
        System.out.println("40" + Arrays.toString(replaseArrayB(array2, array1)));
        int[] pointXY = {1, 1, 3, 2, 2, 4, 5, 6, 5, 8, 4, 2, 2, 9, 9, 3, 3, 4, 5, 5, 2, 6, 7, 4, 3, 3, 9, 9, 11, 4, 3, 0, 0, 23};
        System.out.println("42) The greatest distance PointA(x.y) to PointB(x.y): " + (String.format("%.3g", theGreatestDistanceXY(pointXY))));
        System.out.println("43) Summa sigment with min value number to max value number: " + summSigmentMinMaxNumber(array2));
        String[] animalPollResult = {"tiger", "panda", "tiger", "panda", "tiger", "panda", "tiger", "panda",
                "tiger", "panda", "tiger", "panda", "tiger", "panda", "tiger", "panda",
                "tiger", "panda", "dog", "panda", "dog", "panda", "dog", "panda",
                "dog", "panda", "seal", "panda", "seal", "mouse", "seal", "mouse",
                "seal", "mouse", "seal", "mouse", "seal", "mouse", "seal", "mouse",
                "seal", "mouse"};

        System.out.println("44) Result poll result animal is associated with japan: " + pollResultStatistic(animalPollResult));
        int[] array3 = {222, 321, 223, 32, 42, 24, 55, 52, 62, 1, 2, 3, 2, 5, 6, 6, 55, 65, 56, 74, 62, 23};
        System.out.println("45) Array of numbers ending in K: " + Arrays.toString(arrayOfNumbersEndingInK(array3, 3)));

    }

    ////////////////////////////////////////////////////////
    // 36
    public static int[] compressArray(int[] array) {
        int countNoZeroNumbers = 0;
        int[] newArray;
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            countNoZeroNumbers += array[i] == 0 ? 0 : 1;
        }
        newArray = new int[countNoZeroNumbers];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) continue;
            else {
                newArray[index] = array[i];
                index++;
            }
        }
        return newArray;
    }

    ////////////////////////////////////////////////////////
    // 37
    public static String evenArrayOneAndOddArrayTwo(int[] array) {
        int[] arrayEven;
        int[] arrayOdd;
        int countEven = 0;
        int indexEven = 0, indexOdd = 0;
        for (int i = 0; i < array.length; i++) {
            countEven += array[i] % 2 == 0 ? 1 : 0;
        }
        arrayEven = new int[countEven];
        arrayOdd = new int[array.length - countEven];
        for (int i = 0; i < array.length; i++) {
            if (evenNumber(array[i])) {
                arrayEven[indexEven] = array[i];
                indexEven++;
            } else if (!evenNumber(array[i])) {
                arrayOdd[indexOdd] = array[i];
                indexOdd++;
            }
        }
        return "\n Even array: " + Arrays.toString(arrayEven) + "\n Odd array" + Arrays.toString(arrayOdd);
    }

    ////////////////////////////////////////////////////////
    // 38
    public static String[] theProductOfTwoNumbersIsEqualToTheTarget(int[] array, int target) {
        String[] addNumbers;
        int index = 0;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                count += (array[i] + array[j]) == target ? 1 : 0;
            }
        }
        addNumbers = new String[count];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] + array[j]) == target) {
                    addNumbers[index] = "\n(" + array[i] + " + " + array[j] + ") = " + target;
                    index++;
                }
            }
        }
        return addNumbers;
    }

    ////////////////////////////////////////////////////////
    // 39
    public static int[] replaseNumberMinimumValueAverage(int[] array) {
        int index = 0;
        int minNumber = Integer.MAX_VALUE;
        boolean findMinNumber = false;
        boolean endCycle = false;
        while (!endCycle) {
            if (!findMinNumber) {
                findMinNumber = index == array.length - 1 ? true : false;
                minNumber = minNumber > array[index] ? array[index] : minNumber;
                index++;
            } else if (findMinNumber) {
                --index;
                if (array[index] == minNumber) {
                    array[index] = everage(array);
                    endCycle = true;
//                    break;
                }
            }
        }
        return array;
    }

    ////////////////////////////////////////////////////////
    // 40
    public static int[] replaseArrayB(int[] arrayA, int[] arrayB) {
        int lenges = arrayA.length <= arrayB.length ? arrayA.length : arrayB.length;
        for (int i = 0; i < lenges; i++) {
            arrayB[i] = arrayA[i] <= 0 ? arrayB[i] * 10 : 0;
        }
        return arrayB;
    }
    ////////////////////////////////////////////////////////
    // 41

    ////////////////////////////////////////////////////////
    // 42
    public static double theGreatestDistanceXY(int[] pointXY) {
        double maxDistance = 0.0;
        double findMaxDistance = 0.0;
        int x1 = 0, x2 = 0;
        int y1 = 0, y2 = 0;
        String GreatestDistance = "";

        for (int i = 0; i < pointXY.length - 2; i += 2) {
            for (int j = i + 2; j < pointXY.length; j += 2) {
                x1 = i;
                y1 = x1 + 1;
                x2 = j;
                y2 = x2 + 1;
                findMaxDistance = distancePointAB(pointXY[x1], pointXY[y1], pointXY[x2], pointXY[y2]);
                if (maxDistance < findMaxDistance) {
                    maxDistance = findMaxDistance;
                    GreatestDistance = "point1[" + pointXY[x1] + "." + pointXY[y1] + "] point2[" + pointXY[x2] + "." + pointXY[y2] + "]";
                }
            }
        }
        System.out.println(GreatestDistance);
        return maxDistance;
    }

    ////////////////////////////////////////////////////////
    // 43
    public static int summSigmentMinMaxNumber(int[] array) {
        System.out.println(Arrays.toString(array));
        int summ = 0;
        int minValueNumber = Integer.MAX_VALUE;
        int maxValueNumber = Integer.MIN_VALUE;
        int index = 0;
        boolean endCycle = false;
        boolean findMinMax = false;
        boolean firsMin = false;
        boolean firsMax = false;
        while (!endCycle) {
            if (!findMinMax) {
                maxValueNumber = array[index] > maxValueNumber ? array[index] : maxValueNumber;
                minValueNumber = array[index] < minValueNumber ? array[index] : minValueNumber;
                findMinMax = index == array.length - 1 ? true : false;
            } else if (findMinMax) {
                if (!firsMin && !firsMax) {
                    firsMin = array[index] == minValueNumber ? true : false;
                    firsMax = array[index] == maxValueNumber ? true : false;

                }
                if (firsMin) {
                    summ += array[index];
                    endCycle = array[index] == maxValueNumber ? true : false;
                } else if (firsMax) {
                    summ += array[index];
                    endCycle = array[index] == maxValueNumber ? true : false;
                }
            }
            index = index < array.length - 1 ? index + 1 : 0;
        }
//        System.out.println(minValueNumber + " " + maxValueNumber);
        return summ;
    }

    ////////////////////////////////////////////////////////
    // 44
    public static String pollResultStatistic(String[] resultPoll) {
        String resultStatistik = "";
        String[] answers = new String[resultPoll.length];
        boolean answerRecorded = false;
        int index = 0;
        for (int i = 0; i < resultPoll.length; i++) {
            for (int j = 0; j < index; j++) {
                answerRecorded = answers[j] == resultPoll[i] ? true : false;
                if (answerRecorded) break;
            }
            if (!answerRecorded) {
                answers[index] = resultPoll[i];
                index++;
            } else if (answerRecorded) {
                answerRecorded = false;
                continue;
            }
        }
        int length = index;
        double[] count = new double[length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < resultPoll.length; j++) {
                count[i] += answers[i] == resultPoll[j] ? 1 : 0;
            }
            count[i] = (count[i] / resultPoll.length) * 100;
            System.out.println(answers[i] + " = " + String.format("%.3g", count[i]) + " %");
        }
        return resultStatistik;
    }

    ////////////////////////////////////////////////////////
    // 45
    public static int[] arrayOfNumbersEndingInK(int[] array, int k) {
        int[] newArray = new int[0];
        int count = 0;
        int index1 = 0, index2 = 0;
        boolean endCycle = false;
        boolean endCountNumbers = false;
        while (!endCycle) {
            if (!endCountNumbers) {
                if (index1 < array.length && newArray.length == 0) {
                    endCountNumbers = index1 == array.length - 1 ? true : false;
                } else if (index2 < newArray.length && newArray.length > 0) {
                    if (k == array[index1] % 10) {
                        newArray[index2] = array[index1];
                        endCycle = index2 == newArray.length - 1 ? true : false;
                        index2 ++;
                    }
                }
                count += k == array[index1] % 10 ? 1 : 0;
                index1++;
            }
            if (endCountNumbers) {
                newArray = new int[count];
                index1 = 0;
                count = 0;
                endCountNumbers = false;
            }
        }
        return newArray;
    }

    ////////////////////////////////////////////////////////
    // 46


    ////////////////////////////////////////////////////////
    // even numbers true or false
    public static boolean evenNumber(int number) {
        boolean evenNumber = number % 2 == 0 ? true : false;
        return evenNumber;
    }

    ////////////////////////////////////////////////////////
    // everage
    public static int everage(int[] array) {
        int everage = 0;
        for (int i = 0; i < array.length; i++) {
            everage += array[i];
        }
        return everage / array.length;
    }

    ////////////////////////////////////////////////////////
    // square root
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

    ////////////////////////////////////////////////////////
    // distance poit A{x,y} to point B(x,y)
    public static double distancePointAB(int x1, int y1, int x2, int y2) {
//        System.out.println("point1 ["+x1+"."+y1+"] point2 ["+x2+"."+y2+"] = "+String.format("%.3g", squareRoot(squareOfNumber(x1 - x2) + squareOfNumber(y1 - y2))));
        return squareRoot(squareOfNumber(x1 - x2) + squareOfNumber(y1 - y2));
    }

    ////////////////////////////////////////////////////////
    // square root
    public static int squareOfNumber(int number) {
        return number * number;
    }
}
