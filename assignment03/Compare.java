import java.util.*;

public class Compare {
    void compare(Job[] jList, int numJobs)
    {
        Arrays.sort(jList, new Comparator<Job>()
            {
                @Override
                public int compare(Job a, Job b){return a.finish-b.finish;}
            }
        );
    }
}
