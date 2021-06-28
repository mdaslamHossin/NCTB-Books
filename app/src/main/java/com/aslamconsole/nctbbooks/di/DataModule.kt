package com.aslamconsole.nctbbooks.di

import com.aslamconsole.nctbbooks.data.remote.firebase.books.BookRepo
import com.aslamconsole.nctbbooks.data.remote.firebase.books.BookRepoImpl
import com.aslamconsole.nctbbooks.data.remote.firebase.categories.CategoryRepo
import com.aslamconsole.nctbbooks.data.remote.firebase.categories.CategoryRepoImpl
import com.aslamconsole.nctbbooks.data.remote.firebase.user.UserRepo
import com.aslamconsole.nctbbooks.data.remote.firebase.user.UserRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Created by Aslam Hossin on 6/13/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideUserRepo(userRepo: UserRepoImpl): UserRepo

    @Binds
    @Singleton
    abstract fun provideCategoryRepo(categoryRepoImpl: CategoryRepoImpl): CategoryRepo

    @Binds
    @Singleton
    abstract fun provideBookRepo(bookRepoImpl: BookRepoImpl): BookRepo
}