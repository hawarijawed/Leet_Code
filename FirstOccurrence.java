class Solution {
    public int strStr(String haystack, String needle) {
         // Edge case: if needle is empty, return 0
    if (needle.length() == 0) {
        return 0;
    }

    int n = haystack.length();
    int m = needle.length();

    // If needle is longer than haystack, it cannot be found
    if (m > n) {
        return -1;
    }

    // Iterate over haystack to find the needle
    for (int i = 0; i <= n - m; i++) {
        int j;
        // Check if the substring starting at i matches needle
        for (j = 0; j < m; j++) {
            if (haystack.charAt(i + j) != needle.charAt(j)) {
                break;
            }
        }
        // If j == m, all characters matched
        if (j == m) {
            return i;
        }
    }

    // Needle not found in haystack
    return -1;
    }
}
