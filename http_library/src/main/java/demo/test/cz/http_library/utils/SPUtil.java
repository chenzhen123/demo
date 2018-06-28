package demo.test.cz.http_library.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;

import demo.test.cz.http_library.HttpApplication;

/**
 * File: SPUtil.java
 * Author: zhenchen
 * Version: 1.0.1
 * Create: 2018/6/26 17:32
 * E-mail:zhenchen@ecarx.com.cn
 **/
public class SPUtil {
    private static final String TAG = SPUtil.class.getSimpleName();
    private static final String SP_NAME = HttpApplication.context.getPackageName() + "_SP1";
    private static SPUtil spUtil;
    private SharedPreferences sp;
    private Gson gson;

    public static SPUtil getInstance(Context context) {
        if (spUtil == null) {
            synchronized (SPUtil.class) {
                spUtil = new SPUtil(context);
            }
        }
        return spUtil;
    }

    @SuppressLint("WrongConstant")
    private SPUtil(Context context) {
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_APPEND);
        gson = new Gson();
    }

    /**
     * sp写入string
     *
     * @param key   key
     * @param value value
     */
    public void put(@NonNull String key, @NonNull String value) {
        sp.edit().putString(key, value).apply();
    }

    /**
     * sp中写入int
     *
     * @param key
     * @param value
     */
    public void put(@NonNull String key, @NonNull int value) {
        sp.edit().putInt(key, value).apply();
    }

    /**
     * 写入boolean
     *
     * @param key
     * @param value
     */
    public void put(@NonNull String key, @NonNull boolean value) {
        sp.edit().putBoolean(key, value);
    }

    /**
     * 写入float
     *
     * @param key
     * @param value
     */
    public void put(@NonNull String key, @NonNull float value) {
        sp.edit().putFloat(key, value).apply();
    }

    /**
     * 写入long
     *
     * @param key
     * @param value
     */
    public void put(@NonNull String key, @NonNull long value) {
        sp.edit().putLong(key, value).apply();
    }

    /**
     * 写入set集合
     *
     * @param key
     * @param value
     */
    public void put(@NonNull String key, @NonNull Set<String> value) {
        sp.edit().putStringSet(key, value).apply();
    }

    /**
     * 存入javabean
     *
     * @param key key
     * @param t   t
     * @param <T> javabean
     */
    public <T> void put(@NonNull String key, @NonNull T t) {
        String value = gson.toJson(t);
        sp.edit().putString(key, value).apply();
    }

    public int get(@NonNull String key, int defaultvalue) {
        return sp.getInt(key, defaultvalue);
    }

    public float get(@NonNull String key, float defaultvalue) {
        return sp.getFloat(key, defaultvalue);
    }

    public String get(@NonNull String key, String defaultvalue) {
        return sp.getString(key, defaultvalue);
    }

    public String get(@NonNull String key) {
        return sp.getString(key, "");
    }

    public Set<String> get(@NonNull String key, Set<String> defaultvalue) {
        return sp.getStringSet(key, defaultvalue);
    }

    public boolean get(@NonNull String key, boolean defaultvalue) {
        return sp.getBoolean(key, defaultvalue);
    }

    public long get(@NonNull String key, long defaultvalue) {
        return sp.getLong(key, defaultvalue);
    }

    public <T> T get(@NonNull String key, Class<T> tClass) {
        String json = get(key);
        if (!TextUtils.isEmpty(json)) {
            return gson.fromJson(json, tClass);
        }
        return null;
    }

    public void clear() {
        sp.edit().clear().apply();
    }

    public boolean contains(@NonNull String key) {
        return sp.contains(key);
    }

    public void remove(@NonNull String key) {
        sp.edit().remove(key).apply();
    }

    /**
     * 获取所有的映射
     *
     * @return
     */
    public Map<String, ?> getAll() {
        return sp.getAll();
    }
}