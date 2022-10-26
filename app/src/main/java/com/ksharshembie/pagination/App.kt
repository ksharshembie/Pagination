package com.ksharshembie.pagination

import android.app.Application
import com.ksharshembie.pagination.model.PixaApi
import com.ksharshembie.pagination.model.PixaService

class App : Application() {
    companion object {
        lateinit var api: PixaApi
    }

    override fun onCreate() {
        super.onCreate()
        api = PixaService().getApi()
    }
}