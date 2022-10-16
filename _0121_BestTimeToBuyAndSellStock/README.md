# 0121 - Best Time to Buy and Sell Stock

## 問題

- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

## 說明

- 賣 (Sell)的時間點必須**晚於**買 (Buy)的時間點。
- 陣列中每一個元素代表當天的價格。

## 解法

- 用一個迴圈找到最大的買賣價差。
    - 設定第一天的股價為最低買入價格`lowestPrice`，最大買賣價格`maxProfit`為0。
    - 依序檢查每一天的股價，並執行以下兩件事：
        - 比較當天價格是否小於目前最低買入價格 `lowestPrice`，若是，則更新`lowestPrice`。
        - 若 (當天價格 - `lowestPrice`) > `maxProfit`，則更新當前的`maxProfit`為 (當天價格- `lowestPrice`)。
- 假設有6天的股價資料：[7, 1, 5, 3, 6, 4]，從頭到尾scan一次：
    - 假設在第1天買入，假定當前的最低買入價格`lowestPrice`為7，最大買賣價差`maxProfit`為0。
    - 檢查第2天價格，價格為1:
        - 因為第2天的價格比`lowestPrice`低，因此重新假設第2天才買入股票，更新`lowestPrice`為1。
        - (第2天價格 - `lowestPrice`) <= `maxProfit`，因此不更新`maxProfit`。
    - 檢查第3天價格，價格為5:
        - 因為第3天價格比`lowestPrice`高，所以不更新`lowestPrice`。
        - (第3天價格 - `lowestPrice`) > `maxProfit`，因此更新`maxProfit`為4。
    - 檢查第4天價格，當天價格為3:
        - 因為第4天價格比`lowestPrice`高，所以不更新`lowestPrice`。
        - (第4天價格 - `lowestPrice`) <= `maxProfit`，因此不更新`maxProfit`。
    - 檢查第5天價格，當天價格為6:
        - 因為第5天價格比`lowestPrice`高，所以不更新`lowestPrice`。
        - (第5天價格 - `lowestPrice`) > `maxProfit`，因此更新`maxProfit`為5。
    - 檢查第6天價格，當天價格為4:
        - 因為第5天價格比`lowestPrice`高，所以不更新`lowestPrice`。
        - (第5天價格 - `lowestPrice`) <= `maxProfit`，因此不更新`maxProfit`。
    - 因此最大買賣價差`maxProfit`為5。