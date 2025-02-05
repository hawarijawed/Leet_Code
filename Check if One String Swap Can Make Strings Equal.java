/*
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
*/
class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        int firstIndexDiff = 0;
        int secondIndexDiff = 0;
        int numDiffs = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numDiffs++;
                // numDiffs is more than 2, one string swap will not make two strings equal
                if (numDiffs > 2) return false;
                else if (numDiffs == 1) {
                    // store the index of first difference
                    firstIndexDiff = i;
                } else {
                    // store the index of second difference
                    secondIndexDiff = i;
                }
            }
        }
        // check if swap is possible
        return (
            s1.charAt(firstIndexDiff) == s2.charAt(secondIndexDiff) &&
            s1.charAt(secondIndexDiff) == s2.charAt(firstIndexDiff)
        );
    }
}
