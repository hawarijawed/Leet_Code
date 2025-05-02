/*
There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.
*/
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int [] arr = new int[n];
        int force = 0;
        //Left pass
        for(int i=0; i<n; i++){
            char ch = dominoes.charAt(i);
            if(ch=='R'){
                force = n;
            }
            else if(ch=='L'){
                force = 0;
            }
            else{
                force = Math.max(force-1, 0);
            }

            arr[i] = force;
        }
        force = 0;
        //Right pass
        for(int i=n-1; i>=0; i--){
            char ch = dominoes.charAt(i);
            if(ch=='L'){
                force=n;
            }
            else if(ch=='R'){
                force = 0;
            }
            else{
                force = Math.max(force-1,0);
            }

            arr[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(arr[i]>0){
                sb.append('R');
            }
            else if(arr[i]<0){
                sb.append('L');
            }
            else{
                sb.append('.');
            }
        }

        return sb.toString();
    }
}
