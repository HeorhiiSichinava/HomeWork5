package com.alevel.hw5.Part1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] mass = {-13, 2, 34, 25, 4, 0, -100, 20, -17, 0, 120, 0, -100, 70, 20, 120, 74, 88};

        System.out.println("array: " + Arrays.toString(mass));
        System.out.println(" 1) Multiples of K = 2: " + sumK(mass, 2));
        System.out.println(" 2) array indices of numbers '0': \n   ->" + Arrays.toString(indexMass(mass)));
        System.out.println(" 3) first number: " + positivNegativNumber(mass));
        double[] mass2 = {0.315, 0.456, 2.0, 3.1565468, 20, 147.456};

        System.out.println("array: " + Arrays.toString(mass2));
        System.out.print(" 4)increasing sequence of numbers: (" + increasingSequenceNumber(mass2) + ")\n");
        System.out.println("array: " + Arrays.toString(mass));
        System.out.println(" 5) Array to Even Numbers: \n   ->" + Arrays.toString(arrayOfEvenNumbers(mass)));
        System.out.println(" 6) Min length segment axis: " + minLengthSegmentAxis(mass));
        System.out.print(" 7) ");
        System.out.println("Array after replacing numbers with large Z: \n   ->" + Arrays.toString(numbersLargerZ(mass, 90)));
        System.out.println("array: " + Arrays.toString(mass));
        System.out.println(" 8) Numbers ending in '0': \n   ->" + Arrays.toString(numbersEndingInZero(mass)));
        System.out.println(" 9) Count number positive, negativ and zero numbers: " + countNegativPositivZeroNumber(mass));
        System.out.println("10) Swap the highest number with the least: \n   ->" + Arrays.toString(swapHighestWithLeast(mass)));
        System.out.println("11) Least or equally I=20: \n   ->" + Arrays.toString(leastOrEqually(mass, 20)));
        System.out.println("12) Remainder of division by M equality L:\n   ->" + Arrays.toString(remainderOfDivisionByMEqualityL(mass, 9)));
        System.out.println("13) Swap the numbers on even places with odd:\n   ->" + Arrays.toString(swapEvenWithOdd(mass)));
        int[] array = {2, 3, 5, 3, 5, 3, 5, 4, 4, 4, 2, 2, 5, 2, 2, 4};

        System.out.println("array: " + Arrays.toString(array));
        System.out.println("14) Number of unauthorized applicants: " + quantityUnauthorized(array));
        System.out.println("array: " + Arrays.toString(mass));
        System.out.println("15) All numbers to the first number zero in array:\n   ->" + Arrays.toString(allNumbersToTheFirstZero(mass)));
        int[] array2 = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};

        System.out.println("array: " + Arrays.toString(array2));
        System.out.println("16) Argument and function:");
        argumentValueAndFunctionValue(array2);
        double[] parts = {10, 11.6, 12.5, 11.6, 8.0, 8.7, 9.8, 7.9, 8.0, 10.8, 10.3, 11.0, 9.7, 9.8, 12.0};

        System.out.println("array: " + Arrays.toString(parts));
        System.out.println("17) Marriages: "+checkTheQualityOfParts(parts,10, 1.9));

        String exchangeRates = "_Alfa bank $" + 27 + "_Mega bank $" + 26.5 + "_PUMB $" + 27.5;
        System.out.println("18) Best exchange rates: " + currencyExchange(exchangeRates));
        int[] array3 = {2, 9, 4, 27, 8, 81, 16, 243, 32, 729, 64, 2187, 128, 6561, 256, 19683, 512, 59049, 1024, 177147,
                2048, 531441, 4096, 1594329, 8192, 4782969, 16384, 14348907, 32768, 43046721, 65536, 129140163, 131072, 387420489, 262144};
        System.out.println("19) Multiples of degrees 2:\n   ->" + Arrays.toString(multiplesOfDegrees2(array3)));

        System.out.println("array: " + Arrays.toString(array2));
        System.out.println("20) maximum value (a2+a4+...a2k) and minimum value(a1+a3+...a2k-1): "+maxAMinB(array2));

    }

    //////////////////////////////////////////////////////////
    //1
    public static int sumK(int[] mass, int k) {
        int result = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] % k == 0) {
                result += mass[i];
            }
        }
        return result;
    }

    //////////////////////////////////////////////////////////
    //2
    public static int[] indexMass(int[] mass) {

        int length = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == 0) {
                length++;
            }
        }
        int[] indexMass = new int[length];
        for (int j = mass.length - 1; j >= 0; j--) {
            if (mass[j] == 0) {
                indexMass[length - 1] = j;
                length -= 1;
            }
        }

        return indexMass;
    }

    //////////////////////////////////////////////////////////
    //3
    public static String positivNegativNumber(int[] mass) {
        String firstNumber = "";
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] > 0) {
                firstNumber = "positive";
                break;
            } else if (mass[i] < 0) {
                firstNumber = "negative";
                break;
            } else if (i == (mass.length - 1)) {
                firstNumber = "no negative and no positive";
            }
        }
        return firstNumber;
    }

    //////////////////////////////////////////////////////////
    //4
    public static boolean increasingSequenceNumber(double[] mass) {
        boolean increasing = true;
        for (int i = 1; i < mass.length; i++) {
            if (increasing = mass[i - 1] < mass[i] ? true : false) {
            } else {
                break;
            }
        }
        return increasing;
    }

    //////////////////////////////////////////////////////////
    //5
    public static int[] arrayOfEvenNumbers(int[] mass) {
        int length = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] % 2 == 0 && mass[i] > 0) {
                length++;
            }
        }
        int[] evenNumbers = new int[length];
        for (int i = mass.length - 1; i >= 0; i--) {
            if (mass[i] % 2 == 0 && mass[i] > 0) {
                evenNumbers[length - 1] += mass[i];
                length--;
            }
        }
        return evenNumbers;
    }

    //////////////////////////////////////////////////////////
    //6
    public static int minLengthSegmentAxis(int[] mass) {
        boolean findMinLength = true;
        int[] minLengthSegmentAB = new int[2];
        minLengthSegmentAB[0] = mass[0];
        minLengthSegmentAB[1] = mass[1];
        int length = 0;

        for (int i = 0; i < mass.length; i++) {
            for (int j = mass.length - 1; j > i; j--) {
                if (mass[i] != mass[j]) {
                    findMinLength = Math.abs((mass[i] - mass[j])) < Math.abs((minLengthSegmentAB[0] - minLengthSegmentAB[1]));
                    if (findMinLength) {
                        minLengthSegmentAB[0] = mass[i];
                        minLengthSegmentAB[1] = mass[j];
                        findMinLength = false;
//                        System.out.println("min length point A[" + minLengthSegmentAB[0] + "] [" + minLengthSegmentAB[1] + "] = " + (minLengthSegmentAB[0] - minLengthSegmentAB[1]));
                    }
                } else continue;
            }
        }
        return length = minLengthSegmentAB[0] - minLengthSegmentAB[1];
    }

    //////////////////////////////////////////////////////////
    //7
    public static int[] numbersLargerZ(int[] mass, int z) {
        int countReplace = 0;
        for (int i = 0; i < mass.length; i++) {
            countReplace += mass[i] > z ? 1 : 0;
            mass[i] = mass[i] > z ? z : mass[i];
        }
        System.out.println("Replace number large Z=[" + z + "]: " + countReplace);
        return mass;
    }

    //////////////////////////////////////////////////////////
    //8
    public static int[] numbersEndingInZero(int[] mass) {
        int countNumbersEndingInZero = 0;
        for (int i = 0; i < mass.length; i++) {
            countNumbersEndingInZero += mass[i] % 10 == 0 ? 1 : 0;
        }
        int[] massEndingInZero = new int[countNumbersEndingInZero];
        int index = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] % 10 == 0) {
                massEndingInZero[index] = mass[i];
                index++;
            }
        }
        return massEndingInZero;
    }

    //////////////////////////////////////////////////////////
    //9
    public static String countNegativPositivZeroNumber(int[] mass) {
        String result = "";
        int countNegativ = 0, countPositiv = 0, countZero = 0;
        for (int i = 0; i < mass.length; i++) {
            countNegativ += mass[i] < 0 ? 1 : 0;
            countPositiv += mass[i] > 0 ? 1 : 0;
            countZero += mass[i] == 0 ? 1 : 0;
        }
        return result = "Count numbers:\n negative = " + countNegativ + "\n positive =" + countPositiv + "\n zero = " + countZero;
    }

    //////////////////////////////////////////////////////////
    //10
    public static int[] swapHighestWithLeast(int[] mass) {
        int leasNumber = mass[0], highestNumber = mass[0];
        int startSwap = 0, finSwap = mass.length;

        for (int i = 0; i < mass.length; i++) {
            if (leasNumber > mass[i]) {
                startSwap = i;
                leasNumber = mass[i];
            }
            if (highestNumber <= mass[i]) {
                finSwap = i;
                highestNumber = mass[i];
            }
        }
        for (int i = startSwap; i < finSwap + 1; i++) {
            if (mass[i] == leasNumber) {
                mass[i] = highestNumber;
                continue;
            } else if (mass[i] == highestNumber) {
                mass[i] = leasNumber;
            }
        }
        return mass;
    }

    //////////////////////////////////////////////////////////
    //11
    public static int[] leastOrEqually(int[] mass, int number) {
        int lengthArray = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] <= number) {
                lengthArray++;
            }
        }
        int array[] = new int[lengthArray];
        int index = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] <= number) {
                array[index] = mass[i];
                index++;
            }
        }
        return array;
    }

    //////////////////////////////////////////////////////////
    //12
    public static int[] remainderOfDivisionByMEqualityL(int mass[], int m) {
        int lengthArray = 0;
        for (int i = 0; i < mass.length; i++) {
            if ((mass[i] % m) <= m - 1 && (mass[i] % m) >= 0) {
                lengthArray++;
            }
        }
        int array[] = new int[lengthArray];
        int index = 0;
        for (int i = 0; i < mass.length; i++) {
            if ((mass[i] % m) <= m - 1 && (mass[i] % m) >= 0) {
                array[index] = mass[i];
                index++;
            }
        }
        return array;
    }

    //////////////////////////////////////////////////////////
    //13
    public static int[] swapEvenWithOdd(int[] mass) {
        int buff = 0;
        for (int i = 0; i < mass.length - 1; i += 2) {
            buff = mass[i + 1];
            mass[i + 1] = mass[i];
            mass[i] = buff;
        }
        return mass;
    }

    //////////////////////////////////////////////////////////
    //14
    public static int quantityUnauthorized(int[] mass) {
        int quantity = 0;
        for (int i = 0; i < mass.length; i++) {
            quantity += mass[i] < 3 ? 1 : 0;
        }
        return quantity;
    }

    //////////////////////////////////////////////////////////
    //15
    public static int[] allNumbersToTheFirstZero(int[] mass) {
        int count = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] != 0) {
                count++;
            } else {
                count++;
                break;
            }
        }
        int[] allNumbersToTheFirstZeroNumber = new int[count];
        for (int i = 0; i < count; i++) {
            allNumbersToTheFirstZeroNumber[i] = mass[i];
        }

        return allNumbersToTheFirstZeroNumber;
    }

    //////////////////////////////////////////////////////////
    //16
    public static void argumentValueAndFunctionValue(int[] argumentValue) {
        double result=0;
        System.out.println("y = x^3 - 3x");
        for(int i=0; i<argumentValue.length; i++){
            result= Math.pow(argumentValue[i],3)-3*argumentValue[i];
            System.out.print("x = ["+argumentValue[i]+"] ");
            System.out.println("y = ["+result+"]");
        }
        return;
    }
    //////////////////////////////////////////////////////////
    //17
    public static int checkTheQualityOfParts (double[] parts, double interval, double sigma){
        System.out.print("Allowable range is from "+(interval-sigma)+" to "+(interval+sigma)+"\n");
        int quantityOfMarriages=0;
        for (int i=0; i<parts.length; i++){
            quantityOfMarriages += parts[i]>interval+sigma || parts[i]<interval-sigma ? 1 : 0;
        }
        return quantityOfMarriages;
    }
    //////////////////////////////////////////////////////////
    //18
    public static String currencyExchange(String exchangeRates) {
        char[] rates = exchangeRates.toCharArray();
        boolean findDollar = false;
        boolean dot = false;
        int countNumber = 0;
        String bestExchangeRate = "";
        String[] bank = new String[exchangeRates.length()];
        double bestRate = 0;
        double[] indexNumber = new double[rates.length];
        double x1 = 0, x2 = 0;
        for (int i = 0; i < rates.length; i++) {
            if (!findDollar) {
                bank[countNumber] += rates[i];
            }
            if (rates[i] == '$') {
                findDollar = true;
                continue;
            }
            if (findDollar) {
                if (rates[i] == '_') {
                    findDollar = false;
                    dot = false;
                    countNumber++;
                    x1 = 0;
                    continue;
                }
                if (rates[i] == '.') {
                    dot = true;
                    continue;
                }
                if (!dot) {
                    x1 += (rates[i] - 48);
                    indexNumber[countNumber] = x1;
                    x1 = x1 * 10;
                } else if (dot) {
                    x2 = (rates[i] - 48);
                    x2 = x2 / 10;
                    indexNumber[countNumber] += x2;
                }
            }
        }
//        System.out.println(countNumber);
        for (int i = countNumber; i >= 0; i--) {
            bestRate = indexNumber[i] > bestRate ? indexNumber[i] : bestRate;
        }
        bestExchangeRate = "" + bestRate;
        return bestExchangeRate;
    }

    //////////////////////////////////////////////////////////
    //19
    public static int[] multiplesOfDegrees2(int[] array) {
        boolean check = false;
        int count = 0;
        double checkTheNumber = 0;
        for (int i = 0; i < array.length; i++) {
            checkTheNumber = array[i];
//            System.out.println("next number->" + checkTheNumber);
            while (checkTheNumber >= 2) {
                count += checkTheNumber == 2 ? 1 : 0;
                checkTheNumber = checkTheNumber / 2;
            }
//            System.out.println("count->"+count+"----------------");
        }
        int[] multiplesOfDegrees = new int[count];
        count = 0;
        for (int i = 0; i < array.length; i++) {
            checkTheNumber = array[i];
            while (checkTheNumber >= 2) {
                multiplesOfDegrees[count] = checkTheNumber == 2 ? array[i] : 0;
                count += checkTheNumber == 2 ? 1 : 0;
                checkTheNumber /= 2;
            }
        }
        return multiplesOfDegrees;
    }

    //////////////////////////////////////////////////////////
    //20
    public static String maxAMinB(int[] array) {
        int max = 0, min = Integer.MAX_VALUE;
        boolean evenNumbers=true;
        for (int i = 0; i < array.length; i++) {
            evenNumbers=i%2!=0 ? true : false;
            if (evenNumbers) {
                max = array[i]>max ? array[i] : max;
            }
            else if(!evenNumbers) {
                min = array[i]<min ? array[i] : min;
            }
        }
        return "Max = " + max + " Min = " + min;
    }
}