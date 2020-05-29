package pl.pszczolkowski.covidapp.service;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class CovidService {


    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getToDate(){
        Calendar calendarTo = Calendar.getInstance();
        calendarTo = new Calendar
                .Builder()
                .setDate(calendarTo.get(Calendar.YEAR), calendarTo.get(Calendar.MONTH), calendarTo.get(Calendar.DAY_OF_MONTH))
                .setTimeOfDay(23,59,59)
                .build();
        Date dateTempTo = calendarTo.getTime();

        return simpleDateFormat.format(dateTempTo).replace(" ", "T").concat("Z");
    }

    public String getFromDate(){
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom = new Calendar
                .Builder()
                .setDate(calendarFrom.get(Calendar.YEAR), calendarFrom.get(Calendar.MONTH), calendarFrom.get(Calendar.DAY_OF_MONTH)-1)
                .setTimeOfDay(0,0,0)
                .build();

        Date dateTempFrom = calendarFrom.getTime();
        return simpleDateFormat.format(dateTempFrom).replace(" ", "T").concat("Z");
    }

    public String buildUrl(String countryName, String type) {
        return "https://api.covid19api.com/country/"
                + countryName
                + "/status/"
                + type
                + "?from="
                + getFromDate()
                + "&to="
                + getToDate();
    }


}
