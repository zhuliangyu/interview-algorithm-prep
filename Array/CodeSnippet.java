Python
>>> int(123 / 10**2 % 10)
1
>>> int(123 / 10**1 % 10)
2
>>> int(123 / 10**0 % 10)
3

// 获取个十百位上的数字
// 个位
int(123 / 10^0  % 10) = 3
// 十位
int(123 / 10^1 % 10) = 2
// 百位
int(123 / 10^2 % 10) = 1

// 大小写转换
public char lowercaseToUppercase(char character) {
        // Write your code here
        //获得character与'a'的差值，在'A'的基础上加上这个差值
        return (char)(character - 'a' + 'A');
}

// 闰年
if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {}

// switch用法
public int calculate(int a, char operator, int b) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

// 三个数求最大
public int maxOfThreeNumbers(int a, int b, int c) {
    if (a >= b && a >= c) {
        // a 最大
        return a;
    } else if (b >= a && b >= c) {
        // b 最大
        return b;
    } else {
        // c 最大
        return c;
    }
}

// 两数互换
public void swapIntegers(int[] A, int index1, int index2) {
    int tmp = A[index1];
    A[index1] = A[index2];
    A[index2] = tmp;
}

// 打擂台 求最值
int max=Integer.MIN_Value;
for(int i = 0;i < arr.length; i++){
    if(arr[i] > max){
        max = arr[i];
    }
}

// fizz buzz
public ArrayList<String> fizzBuzz(int n) {
    ArrayList<String> results = new ArrayList<String>();
    for (int i = 1; i <= n; i++) {
        //能同时被3跟5整除的数，肯定也能被3整除，也能被5整除，所以要先判断能否被15整除
        if (i % 3 == 0 && i % 5 == 0) {
            results.add("fizz buzz");
        } else if (i % 5 == 0) {
            results.add("buzz");
        } else if (i % 3 == 0) {
            results.add("fizz");
        } else {
            results.add(String.valueOf(i));
        }
    }
    return results;
}

// 冰雹猜想
// 对于任意一个自然数N，如果N是偶数，就把它变成N / 2；
// 如果N是奇数，就把它变成 3 * N+1。
// 按照这个法则运算下去，最终必然得1。
// 试问，该数通过几轮变换，会变成1呢？
public int getAnswer(int num) {
        // write your code here.
        int count = 0;
        while(num != 1){
            if(num % 2 == 1){
                num = num * 3 + 1;
            } else{
                num /= 2;
            }
            count++;
        }
        return count;
    }

// 找素数
