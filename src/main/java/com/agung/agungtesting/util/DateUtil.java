package com.agung.agungtesting.util;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateUtil {
    public static String hariInIndonesia(int index)
    {
        String [] hari = {"", "Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
        return hari[index];
    }

    public static String bulanInIndonesia(int index)
    {
        String [] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        return bulan[index];
    }

    public static Date stringToDate(String dateStr, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date tgl) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(tgl);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        return df.format(tgl); //cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
    }

    public static String dateToStringTextIndo(Date tgl) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(tgl);
        int month = cal.get(Calendar.MONTH);
        DateFormat day = new SimpleDateFormat("dd");
        DateFormat year = new SimpleDateFormat("yyyy");

        return day.format(tgl) + " " + bulanInIndonesia(month) + " " + year.format(tgl); //cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.YEAR);
    }
}
