package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Su <memory0318@gmail.com>
 * @description:
 * @date: 2022/8/25
 */
public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        short allSeatAvailableInRow = 1023;
        short[] fourGroupPatterns = {30, 120, 480};

        Map<Integer, Short> seatRowToRowAvailabilityMap = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int seatRow = reservedSeat[0];
            int seatCol = reservedSeat[1];
            int availableSeatCheckPointer = 512;

            int seatAvailabilityInRow = seatRowToRowAvailabilityMap.getOrDefault(seatRow, allSeatAvailableInRow);
            int seatOccupied = allSeatAvailableInRow ^ (availableSeatCheckPointer >> (seatCol - 1));
            seatRowToRowAvailabilityMap.put(seatRow, (short) (seatAvailabilityInRow & seatOccupied));
        }

        int totalCnt = 2 * (n - seatRowToRowAvailabilityMap.size());
        for (short seatAvailabilityInRow : seatRowToRowAvailabilityMap.values()) {
            int tempAvailability = seatAvailabilityInRow;
            for (short fourGroupPattern : fourGroupPatterns) {
                if ((tempAvailability & fourGroupPattern) == fourGroupPattern) {
                    tempAvailability ^= fourGroupPattern;
                    ++totalCnt;
                }
            }
        }

        return totalCnt;
    }
}
