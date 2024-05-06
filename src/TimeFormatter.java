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
        int minute = seconds / 60;// получаем минуты
        String strConcat;
        strConcat = getTimeComponent((seconds - minute * 60), "second");
        result = result.concat(strConcat);// остаток секунд

        if (minute == 0) {
            return result;
        } else {
            int hour = seconds / 3600;// получаем часы
            strConcat = getTimeComponent((minute - hour * 60), "minute");
            if(strConcat.isEmpty()) {
                result = strConcat.concat(result);// остаток минут
            } else {
                result = strConcat.concat(" and ").concat(result);// остаток минут
            }

            if (hour == 0) {
                return result;
            } else {
                int day = seconds / 86400;// получаем дни
                strConcat = getTimeComponent((hour - day * 24), "hour");
                if(strConcat.isEmpty()) {
                    result = strConcat.concat(result);// остаток часов
                } else {
                    result = strConcat.concat(", ").concat(result);// остаток часов
                }

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
