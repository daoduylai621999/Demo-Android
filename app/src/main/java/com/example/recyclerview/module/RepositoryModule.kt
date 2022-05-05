package com.example.recyclerview.module

import com.example.recyclerview.repository.MovieRepository
import com.example.recyclerview.repository.MovieRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
}