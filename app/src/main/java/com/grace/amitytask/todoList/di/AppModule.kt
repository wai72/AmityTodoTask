package com.grace.amitytask.todoList.di

import android.content.Context
import androidx.room.Room
import com.grace.amitytask.todoList.data.local.TodoDao
import com.grace.amitytask.todoList.data.local.TodoDatabase
import com.grace.amitytask.todoList.data.remote.TodoApi
import com.grace.amitytask.todoList.data.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(context, TodoDatabase::class.java, name = "local_db").build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(db: TodoDatabase) : TodoDao = db.todoDao()

    @Singleton
    @Provides
    fun provideClient(
        @ApplicationContext appContext: Context,
    ) : OkHttpClient =  OkHttpClient.Builder()
        .build()

    @Singleton
    @Provides
    fun provideTodoApi(client : OkHttpClient) : TodoApi = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(TodoApi::class.java)
}