
import java.util.Arrays;

public class JobSequeueProblem {

    public int[] JobScheduling(int[][] Jobs) {
        int maxDeadLine = -1;
        for (int i = 0; i < Jobs.length; i++) {
            maxDeadLine = Math.max(maxDeadLine, Jobs[i][1]);
        }
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        boolean[] jobDays = new boolean[maxDeadLine];

        int profit = 0;
        int dayCount = 0;

        for (int i = 0; i < Jobs.length; i++) {
            int j = Jobs[i][1] - 1;
            while (j >= 0) {
                if (!jobDays[j]) {
                    jobDays[j] = true;
                    profit += Jobs[i][2];
                    dayCount++;
                    break;
                } else {
                    j--;
                }
            }
        }
        return new int[]{dayCount, profit};
    }
}
