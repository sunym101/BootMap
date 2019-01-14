package com.sunym.map.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static boolean isBonusTime() {
		Date date = new Date();
		String week = getWeekOfDate(date);
		if ("星期日".equals(week) || "星期二".equals(week) || "星期四".equals(week)) {
			Calendar ca = Calendar.getInstance();
			// int hour = ca.get(Calendar.HOUR);//12小时制
			int hour = ca.get(Calendar.HOUR_OF_DAY);// 24小时制
			if (hour >= 21) {
				return true;
			}
		}
		return false;

	}

	/**
	 * 获取当前日期是星期几<br>
	 * 
	 * @param date
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week < 0) {
			week = 0;
		}

		return weekDays[week];
	}

	public static Date dateAddOrReduce(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		// 让日期加减
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);
		return calendar.getTime();
	}

	public static Date toDate(String dateString, String sFmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(sFmt);
		Date rslt = null;
		try {
			rslt = sdf.parse(dateString);
		} catch (Exception e) {
			return null;
		}
		return rslt;
	}

	public static String formatDate(java.util.Date date, String sPattern) {
		if (date == null)
			return "";
		String sDate;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(sPattern);
		sDate = formatter.format(date);
		return sDate;
	}

	public static String formatDateYMD6(java.util.Date date) {
		if (date == null)
			return "";
		String sDate;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyMMdd");
		sDate = formatter.format(date);
		return sDate;
	}

	public static String formatDateYMD(java.util.Date date) {
		if (date == null)
			return "";
		String sDate;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		sDate = formatter.format(date);
		return sDate;
	}

	public static String formatDateYMD3S(java.util.Date date) {
		if (date == null)
			return "";
		String sDate;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sDate = formatter.format(date);
		return sDate;
	}

	public static String formatDatetime(java.util.Date date) {
		if (date == null)
			return "";
		String sDate;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sDate = formatter.format(date);
		return sDate;
	}

	public static String formatDatesss(java.util.Date date) {
		if (date == null)
			return "";
		String sDate;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddhhmmssSSS");
		sDate = formatter.format(date);
		return sDate;
	}

	@SuppressWarnings("deprecation")
	public static int calDiffMonths(Date startDate, Date endDate) {
		int startYearInt = startDate.getYear();
		int startMonthInt = startDate.getMonth();
		int endYearInt = endDate.getYear();
		int endMonthInt = endDate.getMonth();
		int length = (endYearInt - startYearInt) * 12 + (endMonthInt - startMonthInt);

		return length;
	}

	public static String formatDatetimeNull(java.util.Date date) {
		if (date == null)
			return null;
		String sDate;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sDate = formatter.format(date);
		return sDate;
	}

	/**
	 * 获取当月的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月初日
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthFirstDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 取得月末日
	 * 
	 * @param date
	 * @return
	 */
	public static Date getMonthLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		return calendar.getTime();
	}

	public static String formatDateYMDss(java.util.Date date) {
		if (date == null)
			return "";
		String sDate;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sDate = formatter.format(date);
		return sDate;
	}

	public static long calDiffSeconds(Date startDate, Date endDate) {
		long spend = endDate.getTime() - startDate.getTime();

		return spend / 1000;
	}

}
