package com.alorma.github.utils;

import android.content.Context;

import com.alorma.github.R;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.ocpsoft.prettytime.PrettyTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Bernat on 10/04/2015.
 */
public class TimeUtils {

    public static String getDateToText(Context context, Date date, int resId) {
        SimpleDateFormat sdf = new SimpleDateFormat(context.getString(R.string.at_date_format), Locale.getDefault());

        return context.getString(resId, sdf.format(date));
    }

    public static String getTimeAgoString(Context context, String date) {
        /*DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

        DateTime dt = formatter.parseDateTime(date);
        DateTime dtNow = DateTime.now();

        Years years = Years.yearsBetween(dt.withTimeAtStartOfDay(), dtNow.withTimeAtStartOfDay());
        int text = R.plurals.years_ago;
        int time = years.getYears();

        if (time == 0) {
            Months months = Months.monthsBetween(dt.withTimeAtStartOfDay(), dtNow.withTimeAtStartOfDay());
            text = R.plurals.months_ago;
            time = months.getMonths();

            if (time == 0) {

                Days days = Days.daysBetween(dt.withTimeAtStartOfDay(), dtNow.withTimeAtStartOfDay());
                text = R.plurals.days_ago;
                time = days.getDays();

                if (time == 0) {
                    Hours hours = Hours.hoursBetween(dt.toLocalDateTime(), dtNow.toLocalDateTime());
                    time = hours.getHours();
                    text = R.plurals.hours_ago;

                    if (time == 0) {
                        Minutes minutes = Minutes.minutesBetween(dt.toLocalDateTime(), dtNow.toLocalDateTime());
                        time = minutes.getMinutes();
                        text = R.plurals.minutes_ago;
                        if (time == 0) {
                            Seconds seconds = Seconds.secondsBetween(dt.toLocalDateTime(), dtNow.toLocalDateTime());
                            time = seconds.getSeconds();
                            if (time > 5) {
                                text = R.plurals.seconds_ago;
                            } else {
                                text = R.plurals.time_just_now;
                            }
                        }
                    }
                }
            }
        }

        return context.getResources().getQuantityString(text, time, time);*/

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(DateTimeZone.UTC);

        DateTime dt = formatter.parseDateTime(date);
        PrettyTime p = new PrettyTime();

        return p.format(new Date(dt.getMillis()));
    }
}
