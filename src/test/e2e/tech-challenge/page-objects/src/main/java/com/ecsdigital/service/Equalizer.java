package com.ecsdigital.service;



import java.util.*;
import java.util.logging.Logger;

public class Equalizer implements Equalizable {

    private List<Integer> numberList = new ArrayList();
    private List<Integer> reversedList = new ArrayList();

    private static final Logger LOGGER = Logger.getLogger(Equalizer.class.getName());

    @Override
    public Integer checkLeftAndRightEquality(final String[] numbers) {

        LOGGER.info("Checking equality");


        this.addElementsToList(numbers);
        reversedList.addAll(numberList);
        this.inverseList(reversedList);
        ListIterator<Integer> numberListIterator = numberList.listIterator();
        ListIterator<Integer> reversedListIterator = reversedList.listIterator();

        final int sumCheckerDigit = numbers.length - 1;
        boolean flag = true;

        int leftIndexPointer = 0;
        int rightIndexPointer = 0;
        int leftSum = numberListIterator.next();
        int rightSum = reversedListIterator.next();

        while (flag) {

            if (leftSum > rightSum) {
                rightIndexPointer = reversedListIterator.nextIndex();

                if ((leftIndexPointer + rightIndexPointer) == sumCheckerDigit) {
                    flag = false;
                    break;
                }
                rightSum += reversedListIterator.next();

            } else if (rightSum > leftSum) {
                leftIndexPointer = numberListIterator.nextIndex();

                if ((leftIndexPointer + rightIndexPointer) == sumCheckerDigit) {
                    flag = false;
                    break;
                }
                leftSum += numberListIterator.next();

            } else if (leftSum == rightSum) {
                flag = false;
                Integer indexIdentified = leftIndexPointer + 1;
                LOGGER.info("The sum of equality is: " + leftSum);
                LOGGER.info("The index is: " + indexIdentified);

                this.clearAllLists();
                return indexIdentified;
            }
        }
        this.clearAllLists();
        return null;
    }

    private List<Integer> inverseList(List list) {
        Collections.reverse(list);
        return list;
    }

    private void addElementsToList(String [] array) {
        Arrays.stream(array).forEach(number -> numberList.add(Integer.parseInt(number)));
    }

    private void clearAllLists() {
        numberList.clear();
        reversedList.clear();
    }
}
