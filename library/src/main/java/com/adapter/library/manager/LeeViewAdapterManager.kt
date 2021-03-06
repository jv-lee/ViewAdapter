package com.adapter.library.manager

import com.adapter.library.listener.DefaultLoadResource
import com.adapter.library.listener.LoadResource

/**
 * @author jv.lee
 * @date 2020/8/11
 * @description 全局设置LoadResource资源
 */
class LeeViewAdapterManager {

    companion object {

        @Volatile
        private var instance: LeeViewAdapterManager? = null

        @JvmStatic
        fun getInstance() = instance
            ?: synchronized(this) {
            instance
                ?: LeeViewAdapterManager()
                    .also { instance = it }
        }
    }

    private var loadResource: LoadResource? = null

    fun getLoadResource() = loadResource ?: DefaultLoadResource()

    fun setLoadResource(loadResource: LoadResource) {
        this.loadResource = loadResource
    }

}