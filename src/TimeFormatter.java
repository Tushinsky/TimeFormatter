import java.util.stream.IntStream;

public class TimeFormatter {

    /*
    в минуте 60 секунд, в часе 60*60=3600 секунд, в сутках 24*60*60=86400 секунд, в году 365*24*60*60=31536000 секунд
     */
    public static String formatDuration(int seconds) {
        String result = "";
        // your code goes here
        if (seconds == 0) {
            return "now";
        }
        String[] strArray = new String[0];
        int year = seconds / 31536000;// годы
        int time = year * 31536000;
        int day = (seconds - time) / 86400;// дни
        time += day * 86400;
        int hour = (seconds - time) / 3600;// часы
        time += hour * 3600;
        int minute = (seconds - time) / 60;// минуты
        time += minute * 60;
        int second = seconds - time;// секунды
        String years = getTimeComponent(year, "year");// форматируем годы
        strArray = getStringArray(strArray, years);
        String days = getTimeComponent(day, "day");// форматируем дни
        strArray = getStringArray(strArray, days);
        String hours = getTimeComponent(hour, "hour");// форматируем часы
        strArray = getStringArray(strArray, hours);
        String minutes = getTimeComponent(minute, "minute");// форматируем минуты
        strArray = getStringArray(strArray, minutes);
        String sec = getTimeComponent(second, "second");// форматируем секунды
        strArray = getStringArray(strArray, sec);
        if (strArray.length == 1) {
            result = strArray[0];
        } else {
            for (int i = 0; i < strArray.length - 1; i++) {
                result = result.concat(strArray[i]).concat(", ");
            }
            result = result.substring(0, result.length() - 2).concat(" and ").concat(strArray[strArray.length - 1]);
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

    private static String[] getStringArray(String[] array, String item) {
        String[] retArray;
        if(array.length == 0) {
            if (!item.equals("")) {
                retArray = new String[1];
                retArray[0] = item;
                return retArray;
            } else {
                return new String[0];
            }
        } else {
            if (!item.equals("")) {
                retArray = new String[array.length + 1];
                IntStream.range(0, array.length).forEach(i -> retArray[i] = array[i]);
                retArray[retArray.length - 1] = item;
                return retArray;
            } else {
                return array;
            }
        }
    }
}
