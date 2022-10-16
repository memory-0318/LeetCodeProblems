package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

/**
 * @author Brian Su <memory0318@gmail.com>
 * @description:
 * @date: 2022/10/16
 */
class SumUpTest {

    @ParameterizedTest
    @ArgumentsSource(SumUpTestArgProvider.class)
    void twoSum(int[] nums, int target, int[] answer) {
        SumUp sumUp = new SumUp();

        org.assertj.core.api.Assertions.assertThat(sumUp.twoSum(nums, target)).containsExactlyInAnyOrder(answer);
    }

    private static class SumUpTestArgProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 }),
                Arguments.of(new int[] { 3, 2, 4 }, 6, new int[] { 1, 2 }),
                Arguments.of(new int[] { 3, 3 }, 6, new int[] { 0, 1 })
            );
        }
    }
}