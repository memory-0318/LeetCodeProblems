package org.example;

import com.sun.org.apache.xpath.internal.Arg;
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
class ProductCalculatorTest {

    @ParameterizedTest
    @ArgumentsSource(ProductExceptSelftArgProvider.class)
    void productExceptSelf(int[] nums, int[] answer) {
        ProductCalculator calculator = new ProductCalculator();
        org.assertj.core.api.Assertions.assertThat(calculator.productExceptSelf(nums))
            .containsExactlyInAnyOrder(answer);
    }

    private static class ProductExceptSelftArgProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(new int[] { 1, 2, 3, 4 }, new int[] { 24, 12, 8, 6 }),
                Arguments.of(new int[] { -1, 1, 0, -3, 3 }, new int[] { 0, 0, 9, 0, 0 })
            );
        }
    }
}