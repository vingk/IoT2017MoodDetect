package com.mooddetect.mooddetectapp;

/**
 * Created by kulka on 2018-03-24.
 */

//taken default values from Open android project
import java.util.UUID;

public class Constants {
    public static final int BAND_PRESSURE_COUNT = 50;
    public static final byte CMD_ANTI_LOST_RATE = (byte) 80;
    public static final byte CMD_BIND_SUCCESS = (byte) 16;
    public static final byte CMD_BP_TIMING_MONITOR_CONFIRM = (byte) 14;
    public static final byte CMD_BP_TIMING_MONITOR_DATA = (byte) 13;
    public static final byte CMD_BP_TIMING_MONITOR_SWITCH = (byte) 12;
    public static final byte CMD_CALIBRATION_RATE = (byte) 32;
    public static int CMD_DATA_LENGTH = 16;
    public static final byte CMD_DISPLAY_CLOCK = (byte) 18;
    public static final byte CMD_DISPLAY_STYLE = (byte) 42;
    public static final byte CMD_FANWAN = (byte) 5;
    public static final byte CMD_GET_ALARM_CLOCK = (byte) 36;
    public static final byte CMD_GET_ANCS_ON_OFF = (byte) 97;
    public static final byte CMD_GET_BAND_PRESSURE = (byte) 20;
    public static final byte CMD_GET_DEVICE_ELECTRICITY_VALUE = (byte) 3;
    public static final byte CMD_GET_DRINK_TIME = (byte) 40;
    public static final byte CMD_GET_HEART_RATE = (byte) 21;
    public static final byte CMD_GET_PERSONALIZATION_SETTING = (byte) 23;
    public static final byte CMD_GET_SIT_LONG = (byte) 38;
    public static final byte CMD_GET_SLEEP = (byte) 68;
    public static final byte CMD_GET_SPORT = (byte) 19;
    public static final byte CMD_GET_STEP_SOMEDAY_DETAIL = (byte) 67;
    public static final byte CMD_GET_STEP_TODAY = (byte) 72;
    public static final byte CMD_GET_STEP_TOTAL_SOMEDAY = (byte) 7;
    public static final byte CMD_GET_TIME_SETTING = (byte) 10;
    public static final byte CMD_HR_TIMING_MONITOR_CONFIRM = (byte) 14;
    public static final byte CMD_HR_TIMING_MONITOR_DATA = (byte) 13;
    public static final byte CMD_HR_TIMING_MONITOR_SWITCH = (byte) 22;
    public static final byte CMD_INTELL = (byte) 9;
    public static final byte CMD_MSG_GET_HW_AND_FW_VERSION = (byte) -109;
    public static final byte CMD_MSG_NOTIFY = (byte) 114;
    public static final byte CMD_MUTE = (byte) 6;
    public static final byte CMD_ORIENTATION = (byte) 41;
    public static final byte CMD_PHONE_NOTIFY = (byte) 17;
    public static final byte CMD_PUSH_MSG = (byte) 114;
    public static final byte CMD_QUERY_DATA_DISTRIBUTION = (byte) 70;
    public static final byte CMD_RE_BOOT = (byte) 8;
    public static final byte CMD_RE_STORE = (byte) -1;
    public static final byte CMD_SET_ALARM_CLOCK = (byte) 35;
    public static final byte CMD_SET_ANCS_ON_OFF = (byte) 96;
    public static final byte CMD_SET_DEVICE_TIME = (byte) 1;
    public static final byte CMD_SET_DRINK_TIME = (byte) 39;
    public static final byte CMD_SET_PHONE_OS = (byte) 4;
    public static final byte CMD_SET_SIT_LONG = (byte) 37;
    public static final byte CMD_START_HEART_RATE = (byte) 105;
    public static final byte CMD_STOP_HEART_RATE = (byte) 106;
    public static final byte CMD_SWITCH_HEART_RATE = (byte) 22;
    public static final byte CMD_TAKING_PICTURE = (byte) 2;
    public static final byte CMD_TUNE_TIME_DIRECT = (byte) 115;
    public static final byte CMD_TUNE_TIME_INVERSE = (byte) 116;
    public static int FLAG_MASK_ERROR = 128;
    public static final byte Intell_time = (byte) 5;
    public static final int STRING_LIMITE = 64;
    public static final byte TO_OTA = (byte) 15;
    public static final UUID UUID_READ = UUID.fromString("6e400003-b5a3-f393-e0a9-e50e24dcca9e");
    public static final UUID UUID_SERVICE = UUID.fromString("6e40fff0-b5a3-f393-e0a9-e50e24dcca9e");
    public static final UUID UUID_WRITE = UUID.fromString("6e400002-b5a3-f393-e0a9-e50e24dcca9e");
}
