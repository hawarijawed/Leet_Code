/*
A string s is called happy if it satisfies the following conditions:

s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.
*/
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        if (a > 0) {
            pq.offer(new Pair(a, 'a'));
        }
        if (b > 0) {
            pq.offer(new Pair(b, 'b'));
        }
        if (c > 0) {
            pq.offer(new Pair(c, 'c'));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair pr = pq.poll();
            int n = sb.length();
            char ch = pr.ch;
            int count = pr.count;

            // If the last two characters are the same as the current character
            if (n >= 2 && sb.charAt(n - 1) == ch && sb.charAt(n - 2) == ch) {
                // If the queue is empty, break
                if (pq.isEmpty()) {
                    break;
                }

                // Get the next character with the highest frequency
                Pair sec = pq.poll();
                sb.append(sec.ch);
                sec.count--;

                // Reinsert the secondary character if it still has a count left
                if (sec.count > 0) {
                    pq.offer(sec);
                }

                // Reinsert the primary character back to the queue
                pq.offer(pr);
            } else {
                // Append the primary character and decrease its count
                sb.append(ch);
                count--;

                // If it still has a count left, reinsert it into the queue
                if (count > 0) {
                    pq.offer(new Pair(count, ch));
                }
            }
        }

        return sb.toString();
    }
}

class Pair implements Comparable<Pair> {
    int count;
    char ch;

    Pair(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }

    public int compareTo(Pair that) {
        return that.count - this.count; // Max heap based on count
    }
}
