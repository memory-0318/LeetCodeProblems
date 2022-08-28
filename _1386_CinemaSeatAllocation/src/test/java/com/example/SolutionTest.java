package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ArgumentsSources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Brian Su <memory0318@gmail.com>
 * @description:
 * @date: 2022/8/26
 */
class SolutionTest {

    @ParameterizedTest
    @ArgumentsSources({
        @ArgumentsSource(SimpleCinemaTestScenarioArgProvider.class),
        @ArgumentsSource(ComplexCinemaTestScenarioArgProvider.class)
    })
    void maxNumberOfFamilies(int real, int totalRows, int[][] reservedSeats) {
        Assertions.assertEquals(real, new Solution().maxNumberOfFamilies(totalRows, reservedSeats));
    }

    private static class SimpleCinemaTestScenarioArgProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                Arguments.of(4, 3, new int[][] { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } }),
                Arguments.of(2, 2, new int[][] { { 2, 1 }, { 1, 8 }, { 2, 6 } }),
                Arguments.of(4, 4, new int[][] { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } })
            );
        }
    }

    private static class ComplexCinemaTestScenarioArgProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            File testFile = new File("src/test/resources/TestCase_1386_1000000000_ReservedSeat.txt");
            BufferedReader fileReader = new BufferedReader(new FileReader(testFile));

            String line = null;
            int rows = Integer.parseInt(fileReader.readLine());
            int answer = Integer.parseInt(fileReader.readLine());
            List<int[]> reservedSeats = new ArrayList<>();
            while ((line = fileReader.readLine()) != null) {
                String[] reservedSeat = line.split(",");
                reservedSeats.add(
                    new int[] { Integer.parseInt(reservedSeat[0]), Integer.parseInt(reservedSeat[1]) }
                );
            }

            return Stream.of(Arguments.of(answer, rows, reservedSeats.toArray(new int[reservedSeats.size()][2])));
        }
    }
}