''' 
There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
'''

class Solution:
    def minSteps(self, n: int) -> int:
        cache = {}
        
        def helper(count, paste):
            if count == n:
                return 0
            if count > n:
                return 1000
            # Paste operation
            res1 = 1 + helper(count+paste, paste)
            # Copy and paste operation
            res2 = 2 + helper(count+count, count)

            cache[(count, paste)] = min(res1, res2)
            return cache[(count, paste)]
        
        # Base case
        if n==1:
            return 0
        
        return 1 + helper(1,1)
