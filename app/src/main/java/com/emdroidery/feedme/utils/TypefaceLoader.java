package com.emdroidery.feedme.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;

/**
 * A simple LRU cache implementation for holding the references
 * to loaded typefaces in memory
 *
 * @author farhan
 * @version 1.0
 * @since 31/5/17
 */
public class TypefaceLoader {

    final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
    private LruCache<String, Typeface> cache;//We dedicate a maximum of 1/100 memory available to the app to this cache
    private AssetManager assetManager;
    private static TypefaceLoader instance;

    private TypefaceLoader(Context context) {
        this.assetManager = context.getAssets();
        cache = new LruCache<>(maxMemory / 100);
    }

    public static TypefaceLoader getInstance(Context context) {
        if (instance == null) {
            synchronized (TypefaceLoader.class) {
                if (instance == null) {
                    instance = new TypefaceLoader(context);
                }
            }
        }
        return instance;
    }

    public Typeface getFont(String key) {
        Typeface typeface = cache.get(key);
        if (typeface != null) {
            return typeface;
        } else {
            try {
                typeface = Typeface.createFromAsset(assetManager, key);
                cache.put(key, typeface);
            } catch (Exception e) {
            }
        }
        return typeface;
    }

}