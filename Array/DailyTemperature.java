package Array;

import java.util.*;
import java.util.Stack;

public class DailyTemperature {

	public static void main(String[] args) {
		int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
		int[] res = solve_1(nums);
		System.out.println("====result===");
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	public static int[] solve_1(int[] tem) {
		int len = tem.length;
		int[] result = new int[len];
		int max = 0;

		for (int i = 0; i < len; i++) {
			max = i;
			System.out.println("max "+max);
			while (max <= len - 1 && tem[i] >= tem[max]) {
				max++;
			}
			if (max <= len - 1)
				result[i] = max - i;
			else
				result[i] = 0;
		}
		return result;
	}

	public static int[] solve_stack(int[] temper) {
		// 1. ds
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[temper.length];

		// 2. for, while algo
		for (int i = 0; i < temper.length; i++) {
			System.out.println("temper " + temper[i]);
			while (!stack.isEmpty() && temper[stack.peek()] < temper[i]) {
				// 73<74
				int index = stack.pop(); // peek()+remove()
				System.out.println("i " + i + " index " + index);
				result[index] = i - index;
			}
			stack.push(i);// 0
		}
		return result;

	}

	public static int[] solve_2(int[] tem) {
		int count = 0, j;
		int len = tem.length;
		int[] result = new int[len];

		for (int i = 0; i < len - 1; i++) {
			for (j = i + 1; j < len; j++) {
				if (tem[i] < tem[j]) {
					count++;
					break;
				} else
					count++;
			}

			if (j == tem.length)
				result[i] = 0;
			else
				result[i] = count;
			count = 0;
		}

		return result;
	}

}
