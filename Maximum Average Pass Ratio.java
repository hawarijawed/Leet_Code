/*
There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.

You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
*/
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[0], a[0]));

        for(int arr[]: classes){
            int pass = arr[0];
            int total = arr[1];
            double diff = findDiff(pass, total);
            pq.offer(new double[]{diff, pass, total});
        }

        while(extraStudents > 0){
            double arr[] = pq.poll();
            int pass = (int) arr[1] + 1;
            int total = (int) arr[2] + 1;
            double diff = findDiff(pass, total);
            pq.offer(new double[]{diff, pass, total});
            extraStudents--;
        }

        double totalPassRatio = 0;
        while(!pq.isEmpty()){
            double arr[] = pq.poll();
            totalPassRatio += arr[1]/arr[2];
        }

        return  totalPassRatio/classes.length;
    }

    public double findDiff(int pass, int total){
        double currentRatio = (double) pass / total;
        double newRatio = (double) (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }

}
