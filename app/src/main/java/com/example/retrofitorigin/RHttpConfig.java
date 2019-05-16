/*
 * Copyright (c) 2017.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.retrofitorigin;

import android.content.Context;
import android.util.ArrayMap;

import okhttp3.Cache;
import okhttp3.Interceptor;


/**
 * 网络请求公共配置类
 *
 * @author yangchong
 *         created on 2017/11/7 15:14
 */
public final class RHttpConfig {
    private static String sDomain = "";
    private static ArrayMap<String, String> mHeaders;
    private static Interceptor mRequestInterceptor;
    private static Interceptor mReponseInterceptor;

    static Cache sCache;


    private RHttpConfig() {
    }

    /**
     * set domain
     */
    public static void setDomain(String domain) {
        sDomain = domain;
    }

    /**
     * set headers
     */
    public static void setHeader(ArrayMap<String, String> headers) {
        mHeaders = headers;
    }


    public static ArrayMap<String, String> getHeaders() {
        return mHeaders;
    }


    public static String getDomain() {
        return sDomain;
    }


    public static void setCache(Context ctx, int cacheSize) {
        if (ctx != null) {
            sCache = new Cache(ctx.getCacheDir(), cacheSize);
        }
    }

    /**
     * 设置请求拦截器
     */
    public static void setRequestInterceptor(Interceptor requestInterceptor) {
        mRequestInterceptor = requestInterceptor;
    }

    /**
     * 设置响应拦截器
     */
    public static void setResposeInterceptor(Interceptor resposeInterceptor) {
        mReponseInterceptor = resposeInterceptor;
    }

    /**
     * 获取响应拦截器
     */
    public static Interceptor getReponseInterceptor() {
        return mReponseInterceptor;
    }

    /**
     * 获取请求拦截器
     */
    public static Interceptor getRequestInterceptor() {
        return mRequestInterceptor;
    }


}
