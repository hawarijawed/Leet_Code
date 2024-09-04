/*
A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot can receive a sequence of these three possible types of commands:

-2: Turn left 90 degrees.
-1: Turn right 90 degrees.
1 <= k <= 9: Move forward k units, one unit at a time.
Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). 
If the robot runs into an obstacle, then it will instead stay in its current location and move on to the next command.

Return the maximum Euclidean distance that the robot ever gets from the origin squared (i.e. if the distance is 5, return 25).

Note:

North means +Y direction.
East means +X direction.
South means -Y direction.
West means -X direction.
There can be obstacle in [0,0].
*/
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        //0: North, 1: East, 2: South, 3: West
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int [] curPos  = {0, 0};
        int res = 0;
        int curDir = 0;

        HashMap<Integer, HashSet<Integer>> obstacleMap = new HashMap<>();
        for(int [] obstacle: obstacles){
            if(!obstacleMap.containsKey(obstacle[0])){
                obstacleMap.put(obstacle[0], new HashSet<>());
            }
            obstacleMap.get(obstacle[0]).add(obstacle[1]);
        }

        for(int command: commands){
            if(command == -1){
                //turn right 90 degree
                curDir = (curDir+1)%4;
                continue;
            }

            if(command == -2){
                // turn left
                curDir = (curDir -1);
                if(curDir == -1){
                    curDir = 3;
                }
                continue;
            }

            //Move Forward
            int [] direction = directions[curDir];
            for(int step = 0; step<command; step++){
                int nextX  = curPos[0] + direction[0];
                int nextY  = curPos[1] + direction[1];
                if(obstacleMap.containsKey(nextX) && obstacleMap.get(nextX).contains(nextY)){
                    break;
                }
                curPos[0] = nextX;
                curPos[1] = nextY;
            }

            res = Math.max(res, curPos[0]*curPos[0] + curPos[1]*curPos[1]);

        }
        return res;
    }
}
