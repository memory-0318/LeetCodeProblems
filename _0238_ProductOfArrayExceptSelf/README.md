# 0238 - Product of Array Except Self

## 問題

- https://leetcode.com/problems/product-of-array-except-self/

## 說明

- 除了該index對應的元素外，陣列元素相乘求積。
- 陣列元素均為整數。
- 不可使用除法。

## 解法

- 由左至右計算當前元素之前的所有元素乘積，並儲存在當前陣列
- 宣告一個陣列`result`儲存計算結果
- 先從左至右依序檢查每一個`nums`陣列元素
    - `num[0]`為1，其沒有前一個陣列元素，直接`result[0]=1`
    - `num[1]`為1，其之前的元素為`num[0]`，`result[1] = result[0] x num[0] = 1 x 1 = 1`
    - `num[2]`為3，其之前的元素為`num[1]`與`num[0]`，`result[2] = result[1] x num[0] x num[1] = 1 x 2 = 2`
    - `num[3]`為4，其之前的元素為`num[2]`、`num[1]`與`num[0]`，`result[3] = result[2] x num[2] = 2 x 3 = 6`
- 此時`result`陣列為`[1, 1, 2, 6]`
- 再從右至左檢查每一個`nums`陣列元素
    - `num[3]`為4，其沒有後一個陣列元素，直接`result[3] = result[3] x 1 = 6`
    - `num[2]`為3，其後的元素為`num[3]`，result[2]=result[2]*num[3] = 2 x 4 = 8`
    - `num[1]`為2，其後的元素為`num[2]`與`num[3]`，`result[1]=result[1]*num[3] x num[2] = 2 x 3 x 4 = 12`
    - `num[0]`為1，其後的元素為`num[1]`、`num[2]`與`num[3]`，`result[0]=result[0]*num[3] x num[2] x num[1] = 1 x 4 x 3 x 2`
- 示意圖如下：
  ```text
    idx      0      1      2      3
  -----------------------------------
   nums      1      2      3      4
   Left      1      1     1x2   1x2x3
  Right    4x3x2   4x3     4      1
  -----------------------------------
             24     12     8      6
  ```