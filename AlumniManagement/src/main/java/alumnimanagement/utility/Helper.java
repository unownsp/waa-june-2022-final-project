package alumnimanagement.utility;

import alumnimanagement.dto.ReportList;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Helper {

    public static Long getLoggedUserId()
    {
        return 1L;
    }

    public static LocalDateTime getCurrentDate()
    {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return localDateTime;
    }

    public static List<ReportList> getReportLists(Map<String, Integer> map) {
        List<ReportList> result2 = new ArrayList<>();
        for (Map.Entry<String, Integer> set :
                map.entrySet()) {
            ReportList dto = new ReportList();
            dto.value = (long) set.getValue();
            dto.name = set.getKey();
            result2.add(dto);

        }
        return result2;
    }

}
