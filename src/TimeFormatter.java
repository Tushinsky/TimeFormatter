/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergii.Tushinskyi
 */
public class TimeFormatter {
     /*
    в минуте 60 секунд, в часе 60*60=3600 секунд, в сутках 24*60*60=86400 секунд,
    в году 365*24*60*60=31536000 секунд
     */
    public static String formatDuration(int seconds) {
        String result = "";
        // your code goes here
        if (seconds == 0) {
            return "now";
        }
        int year = seconds / 31536000;// годы
        int time = year * 31536000;
        int day = (seconds - time) / 86400;// дни
        time += day * 86400;
        int hour = (seconds - time) / 3600;// часы
        time += hour * 3600;
        int minute = (seconds - time) / 60;// минуты
        time += minute * 60;
        int second = seconds - time;// секунды
        String years = getTimeComponent(year, "year");
        String days = getTimeComponent(day, "day");
        String hours = getTimeComponent(hour, "hour");
        String minutes = getTimeComponent(minute, "minute");
        String sec = getTimeComponent(second, "second");
        result = result.concat(years);
        if(!days.equals("")) {
            if(!result.equals("")) {
                result = result.concat(", ").concat(days);
            } else {
                result = result.concat(days);
            }
        }
        if(!hours.equals("")) {
            if(!result.equals("")) {
                result = result.concat(", ").concat(hours);
            } else {
                result = result.concat(hours);
            }
        }
        if(!minutes.equals("")) {
            if(!result.equals("")) {
                result = result.concat(", ").concat(minutes);
            } else {
                result = result.concat(minutes);
            }
            
        }
        if(!sec.equals("")) {
            if(!result.equals("")) {
                result = result.concat(" and ").concat(sec);
            } else {
                result = result.concat(sec);
            }
        }
        
        return result;
    }
    
    private static String getTimeComponent(int i, String s) {
        if (i == 0) {
            return "";
        }
        if (i > 1) {
            return i + " " + s + "s";

        } else {
            return i + " " + s;

        }
    }
}
