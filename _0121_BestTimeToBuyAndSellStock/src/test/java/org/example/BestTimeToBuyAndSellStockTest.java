package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Brian Su <memory0318@gmail.com>
 * @description:
 * @date: 2022/10/16
 */
class BestTimeToBuyAndSellStockTest {

    @ParameterizedTest
    @ArgumentsSource(MaxProfitArgProvider.class)
    void testMaxProfit(int[] prices, int answer) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        Assertions.assertEquals(answer, bestTimeToBuyAndSellStock.maxProfit(prices));
    }

    private static class MaxProfitArgProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(new int[] { 7, 1, 5, 3, 6, 4 }, 5),
                Arguments.of(new int[] { 7, 6, 4, 3, 1 }, 0),
                Arguments.of(new int[] { 2, 4, 1 }, 2)
            );
        }
    }
}