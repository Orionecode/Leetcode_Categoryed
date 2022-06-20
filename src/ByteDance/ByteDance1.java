package ByteDance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author YixiaoZeng
 * @Date 2022/6/16 16:50
 * @Filename ByteDance.Main
 */

// 给出一个数字，重新排序使其变成一个最大的数字

public class ByteDance1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt(); //输入
        int[] num = new int[String.valueOf(number).length()]; //创建一个与number同位数大小的数组
        for(int i = 0; i < num.length; i++){ //遍历数字的每个位，逆序存入数组
            num[i] = number % 10;
            number /= 10;
        }
        Arrays.sort(num);
        for(int i = num.length-1; i >= 0; i--){ //逆序遍历数组输出结果
            System.out.print(num[i]);
        }
    }
}
