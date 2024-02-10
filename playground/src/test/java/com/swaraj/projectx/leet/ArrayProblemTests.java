package com.swaraj.projectx.leet;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayProblemTests {
    @Test
    void traverseInBatchSize() {
        int[] originalArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int splitSize = 2;
        List<int[]> splittedArray = getSplitArray(originalArray, splitSize);
        for (int[] ints : splittedArray) {
            printArray(ints);
        }
    }

    private List<int[]> getSplitArray(int[] originalArray, int splitSize) {
        List<int[]> result = new ArrayList<>();
        int length = originalArray.length, startIndex = 0;
        while (startIndex < length) { //startIndex=6
            int endIndex = startIndex + splitSize; //9
            int[] subArray = Arrays.copyOfRange(originalArray, startIndex, endIndex);
            result.add(subArray);
            startIndex += splitSize;
        }

        return result;
    }

    @Test
    void checkDuplicate() {
        int[] elements = {1, 3, 5, 7, 2, 1};
        boolean duplicateExist = false;
        Set<Integer> uniqueElements = new HashSet<>();
        for (int x = 0; x < elements.length; x++) {
            if (uniqueElements.contains(elements[x])) {
                duplicateExist = true;
                break;
            }
            uniqueElements.add(elements[x]);
        }

        assertTrue(duplicateExist);
    }

    @Test
    void checkStringAnagram() {
        boolean option1 = false;
        if (option1) {
            assertTrue(isStringAnagram("one", "one"));
            assertFalse(isStringAnagram("one", "two"));
            assertTrue(isStringAnagram("one", "eno"));
            assertTrue(isStringAnagram("rat", "art"));
            assertFalse(isStringAnagram("rat", "artt"));
        } else {
            assertTrue(isStringAnagram2("one", "one"));
            assertFalse(isStringAnagram2("one", "two"));
            assertTrue(isStringAnagram2("one", "eno"));
            assertTrue(isStringAnagram2("rat", "art"));
            assertFalse(isStringAnagram2("rat", "artt"));
        }
    }

    private boolean isStringAnagram(String string1, String string2) {
        if (string1.length() != string2.length()) return Boolean.FALSE;

        HashMap<Character, Integer> countString1 = new HashMap<>();
        HashMap<Character, Integer> countString2 = new HashMap<>();

        // create the count hash map
        for (int i = 0; i < string1.length(); i++) {
            countString1.put(string1.charAt(i), countString1.getOrDefault(string1.charAt(i), 0) + 1);
            countString2.put(string2.charAt(i), countString2.getOrDefault(string2.charAt(i), 0) + 1);
        }

        if (countString2.size() != countString1.size()) return Boolean.FALSE;
        // iterate through hashmap
        for (Character c : countString1.keySet()) {
            if (!countString1.get(c).equals(countString2.get(c))) return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    private boolean isStringAnagram2(String string1, String string2) {
        if (string1.length() != string2.length()) return Boolean.FALSE;
        char[] charArray = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray2); // TC: O(nlogn) , SC: O()
        return Arrays.toString(charArray).equalsIgnoreCase(Arrays.toString(charArray2));
    }

    @Test
    void two_sum() {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        int[] ints = twoSum(nums, target);
        assertEquals(0, Arrays.compare(ints, new int[]{0, 3}));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> storage = new HashMap<>(); // value : index of value
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (storage.containsKey(difference)) {
                return new int[]{storage.get(difference), i};
            }
            storage.put(nums[i], i);
        }
        return result;
    }

    @Test
    void group_anagrams_test() {
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(input);
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> wordGrouping = new HashMap<>(); // mapping sorted word --> actual word
        for (int i = 0; i < strs.length; i++) {
            char[] sortedWord = strs[i].toCharArray();
            Arrays.sort(sortedWord);
            String sorted = String.valueOf(sortedWord);
            if (wordGrouping.containsKey(sorted)) {
                wordGrouping.get(sorted).add(strs[i]);
            } else {
                ArrayList<String> originalWord = new ArrayList<>();
                originalWord.add(sorted);
                wordGrouping.put(sorted, originalWord);
            }
        }

        result.addAll(wordGrouping.values());

        return result;
    }

    @Test
    void top_k_frequent_elements() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 2, 3};
        int k = 2;
        //List<Integer>[] counts = new List[nums.length];
        HashMap<Integer, Integer> elementFrequency = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            elementFrequency.put(nums[i], elementFrequency.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> values = new ArrayList<>(elementFrequency.keySet());
        values.sort((o1, o2) -> elementFrequency.get(o2) - elementFrequency.get(o1));
        values.forEach(integer -> System.out.println(integer));
    }

    @Test
    void product_except_self() {
        int[] nums = new int[]{1, 2, 3, 4};
        //nums ->1 2 3 4
        //i    ->0 1 2 3
        productExceptSelf(nums);
        //System.out.println("factorial(4) = " + factorial(4));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // prepare prefix array, 1st pass from left to right , o(n)
        /*
        nums    1 2 3 4
        i       0 0 0 0 // take me
        * */
        int[] prefix = new int[nums.length];
        Arrays.fill(prefix, 1);
        int left = 1;
        for (int i = 0; i < prefix.length; i++) {
            prefix[i] = nums[i] * left;
            left = left * nums[i];
        }
        printArray(prefix);

        //i     ->0 1 2 3
        //nums  ->1 2 3 4
        //post  ->      4
        //prepare postfix array , TC: O(n)
        int[] postfix = new int[nums.length];
        Arrays.fill(postfix, 1);
        int right = 1;
        for (int i = postfix.length - 1; i >= 0; i--) {
            postfix[i] = nums[i] * right;
            right = right * nums[i];
        }
        printArray(postfix);

        return result;
    }

    int factorial(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res = res * i;
        }
        return res;
    }

    @Test
    void longest_consecutive_subsequence() {
        /*
         * start of sequence condition -> no left sequence
         * */
        List<Integer> nums = List.of(100, 4, 200, 1, 3, 2);
        Set<Integer> uniqueSet = new HashSet<>(nums);
        int longestStreak = 0, maxLongestStreak = 0;

        for (Integer num : nums) {
            if (!uniqueSet.contains(num - 1)) { // start of sequence
                int numToCheck = num + 1;
                do {
                    boolean nextNumberInSequenceExist = uniqueSet.contains(numToCheck);
                    if (nextNumberInSequenceExist) {
                        longestStreak++;
                        numToCheck++;
                    } else break;
                } while (true);
                if (longestStreak > maxLongestStreak) maxLongestStreak = longestStreak;
            }
            longestStreak = 0;
        }
        System.out.println("maxLongestStreak = " + ++maxLongestStreak);
    }

    void printArray(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i : arr) {
            stringBuilder.append(i + " ");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}
