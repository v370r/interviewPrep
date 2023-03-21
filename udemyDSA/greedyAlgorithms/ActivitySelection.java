package udemyDSA.greedyAlgorithms;

import java.util.*;

public class ActivitySelection {
    static void activitySelection(ArrayList<Activity> activityList) {
        Comparator<Activity> finishTimComparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.getFinishTime() - o2.getFinishTime();
            }
        };
        Collections.sort(activityList, finishTimComparator);
        Activity previousActivity = activityList.get(0);
        System.out.println("\n\nRecommended Schedule: \n" + activityList.get(0));

        for (int i = 1; i < activityList.size(); i++) {
            Activity activity = activityList.get(i);
            if (activity.getStartTime() >= previousActivity.getFinishTime()) {
                System.out.println(activity.toString());
                previousActivity = activity;
            }
        }
    }
}
