/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.

For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.
*/
class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean mat[][] = new boolean[numCourses][numCourses];
        for(int i=0; i<prerequisites.length; i++){
            int s = prerequisites[i][0];
            int d = prerequisites[i][1];
            mat[s][d] = true;
        }

        for(int k=0; k<numCourses; k++){
            for(int s=0; s<numCourses; s++){
                for(int d=0; d<numCourses; d++){
                    mat[s][d] = mat[s][d] || (mat[s][k] && mat[k][d]);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            int s = queries[i][0];
            int d = queries[i][1];
            res.add(mat[s][d]);
        }

        return res;
    }
}
