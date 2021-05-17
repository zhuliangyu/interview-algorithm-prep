class Solution {
    
    // 如果一个数的约数在其开平方的右边 则必然会存在一个约数在其开平方的左边 所以 
    // 判断一个数是否为质数 只需要观察在其2 到 开平方数中间是否含有约数即可
    
    // 比如说 判断16是否为质数 我们去找16的约数时 判断它的范围 只需要找到 
    // 16的开平方数就可以了 而不必一直找到<16 或者<= 16/2

    public int countPrimes(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPrime(int num) {
        // 只需要遍历到i的平方根即可
        int max = (int)Math.sqrt(num);

        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
