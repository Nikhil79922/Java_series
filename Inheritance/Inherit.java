package Inheritance;

import java.util.HashSet;
import java.util.Set;

public class Inherit {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        v1.start();

        Car c1 = new Car();
        c1.start();
        c1.setGear();

        Solution s1 = new Solution();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int solution = s1.longestConsecutive(nums);
        System.out.println(solution);

        Solution2 s2 = new Solution2();
        int[] nums2 = new int[]{5, 2, 9};
        int k = 7;
        int solution2 = s2.subarraysWithXorK(nums2, 7);
        System.out.println(solution2);
    }
}

class Vehicle {

    public Vehicle() {
        System.out.println("Vechicle's class constructor is invoked");
    }

    void start() {
        System.out.println("Engine started");
    }
}

class Car extends Vehicle {

    void setGear() {
        System.out.println("Gear Shifted....");
    }
}

class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i] - 1)) {
                int curr = nums[i] + 1;
                int currCount = 1;
                while (list.contains(curr)) {
                    currCount++;
                    curr++;
                }
                count = Math.max(currCount, count);
            }
        }
        return count;
    }
}

class Solution2 {

    public int subarraysWithXorK(int[] nums, int k) {
        int ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int firstNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                firstNum = firstNum ^ nums[j];
                if (firstNum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
