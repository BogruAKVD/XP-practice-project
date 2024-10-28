import java.time.OffsetDateTime;
import java.util.List;

public class Sync {
    public class Deadline {
        public String name;
        public OffsetDateTime deadline;
        public Long timeToComplete; // Time in minutes
    }

    static boolean isSyncable(List<Deadline> deadlineList, Deadline newDeadline) {
        OffsetDateTime newStart = newDeadline.deadline.minusMinutes(newDeadline.timeToComplete);
        OffsetDateTime newEnd = newDeadline.deadline;

        for (Deadline existing : deadlineList) {
            OffsetDateTime existingStart = existing.deadline.minusMinutes(existing.timeToComplete);
            OffsetDateTime existingEnd = existing.deadline;

            if (newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart)) {
                return false;
            }
        }

        return true;
    }
}
