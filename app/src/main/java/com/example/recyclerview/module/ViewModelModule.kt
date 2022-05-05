package com.example.recyclerview.module

import com.example.recyclerview.ui.detail.DetailViewModel
import com.example.recyclerview.ui.history.HistoryViewModel
import com.example.recyclerview.ui.home.HomeViewModel
import com.example.recyclerview.ui.notifications.NotificationsViewModel
import com.example.recyclerview.ui.profile.ProfileViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        HistoryViewModel()
    }
    single {
        HomeViewModel(get())
    }
    single {
        NotificationsViewModel()
    }
    single {
        ProfileViewModel()
    }
    single {
        DetailViewModel(get())
    }
}