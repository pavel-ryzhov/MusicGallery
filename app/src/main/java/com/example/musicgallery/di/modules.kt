package com.example.musicgallery.di

import android.content.Context
import androidx.room.Room
import com.example.musicgallery.data.data_sources.local.albums.LocalAlbumsDataSource
import com.example.musicgallery.data.data_sources.local.albums.LocalAlbumsDataSourceImpl
import com.example.musicgallery.data.data_sources.local.tags.LocalTagsDataSource
import com.example.musicgallery.data.data_sources.local.tags.LocalTagsDataSourceImpl
import com.example.musicgallery.data.data_sources.local.tracks.LocalTracksDataSource
import com.example.musicgallery.data.data_sources.local.tracks.LocalTracksDataSourceImpl
import com.example.musicgallery.data.data_sources.remote.albums.RemoteAlbumsDataSource
import com.example.musicgallery.data.data_sources.remote.albums.RemoteAlbumsDataSourceImpl
import com.example.musicgallery.data.data_sources.remote.tags.RemoteTagsDataSource
import com.example.musicgallery.data.data_sources.remote.tags.RemoteTagsDataSourceImpl
import com.example.musicgallery.data.data_sources.remote.tracks.RemoteTracksDataSource
import com.example.musicgallery.data.data_sources.remote.tracks.RemoteTracksDataSourceImpl
import com.example.musicgallery.data.local.*
import com.example.musicgallery.data.repository.AlbumsRepositoryImpl
import com.example.musicgallery.data.repository.TagsRepositoryImpl
import com.example.musicgallery.data.repository.TracksRepositoryImpl
import com.example.musicgallery.data.services.AlbumsService
import com.example.musicgallery.data.services.TagsService
import com.example.musicgallery.data.services.TracksService
import com.example.musicgallery.domain.albums.AlbumsInteractor
import com.example.musicgallery.domain.albums.AlbumsInteractorImpl
import com.example.musicgallery.domain.albums.AlbumsRepository
import com.example.musicgallery.domain.login.LoginInteractor
import com.example.musicgallery.domain.login.LoginInteractorImpl
import com.example.musicgallery.domain.registration.RegistrationInteractor
import com.example.musicgallery.domain.registration.RegistrationInteractorImpl
import com.example.musicgallery.domain.tags.TagsInteractor
import com.example.musicgallery.domain.tags.TagsInteractorImpl
import com.example.musicgallery.domain.tags.TagsRepository
import com.example.musicgallery.domain.tracks.TracksInteractor
import com.example.musicgallery.domain.tracks.TracksInteractorImpl
import com.example.musicgallery.domain.tracks.TracksRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
class ProvideModule {
    @Provides
    fun providesUserDao(@ApplicationContext context: Context): UserDao {
        return Room.databaseBuilder(context, AppRoomDB::class.java, "AppRoomDB").build()
            .getUserDao()
    }

    @Provides
    fun providesAlbumDao(@ApplicationContext context: Context): AlbumDao {
        return Room.databaseBuilder(context, AppRoomDB::class.java, "AppRoomDB").build()
            .getAlbumDao()
    }

    @Provides
    fun providesTagDao(@ApplicationContext context: Context): TagDao {
        return Room.databaseBuilder(context, AppRoomDB::class.java, "AppRoomDB").build()
            .getTagDao()
    }

    @Provides
    fun providesTrackDaoDao(@ApplicationContext context: Context): TrackDao {
        return Room.databaseBuilder(context, AppRoomDB::class.java, "AppRoomDB").build()
            .getTrackDao()
    }

    @Provides
    fun providesAlbumsService(): AlbumsService {
        return Retrofit.Builder()
            .baseUrl("https://ws.audioscrobbler.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AlbumsService::class.java)
    }

    @Provides
    fun providesTagsService(): TagsService {
        return Retrofit.Builder()
            .baseUrl("https://ws.audioscrobbler.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TagsService::class.java)
    }

    @Provides
    fun providesTracksService(): TracksService {
        return Retrofit.Builder()
            .baseUrl("https://ws.audioscrobbler.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TracksService::class.java)
    }
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class BindModule {
    @Binds
    abstract fun bindsLoginInteractor(
        loginInteractor: LoginInteractorImpl
    ): LoginInteractor

    @Binds
    abstract fun bindsRegistrationInteractor(
        registrationInteractor: RegistrationInteractorImpl
    ): RegistrationInteractor

    @Binds
    abstract fun bindsLocalAlbumsDataSource(
        localAlbumsDataSourceImpl: LocalAlbumsDataSourceImpl
    ): LocalAlbumsDataSource

    @Binds
    abstract fun bindsRemoteAlbumsDataSource(
        remoteAlbumsDataSourceImpl: RemoteAlbumsDataSourceImpl
    ): RemoteAlbumsDataSource

    @Binds
    abstract fun bindsAlbumsRepository(
        albumsRepositoryImpl: AlbumsRepositoryImpl
    ): AlbumsRepository

    @Binds
    abstract fun bindsAlbumsInteractor(
        albumsInteractorImpl: AlbumsInteractorImpl
    ): AlbumsInteractor

    @Binds
    abstract fun bindsLocalTagsDataSource(
        localTagsDataSourceImpl: LocalTagsDataSourceImpl
    ): LocalTagsDataSource

    @Binds
    abstract fun bindsRemoteTagsDataSource(
        remoteTagsDataSourceImpl: RemoteTagsDataSourceImpl
    ): RemoteTagsDataSource

    @Binds
    abstract fun bindsTagsRepository(
        tagsRepositoryImpl: TagsRepositoryImpl
    ): TagsRepository

    @Binds
    abstract fun bindsTagsInteractor(
        tagsInteractorImpl: TagsInteractorImpl
    ): TagsInteractor

    @Binds
    abstract fun bindsLocalTracksDataSource(
        localTracksDataSourceImpl: LocalTracksDataSourceImpl
    ): LocalTracksDataSource

    @Binds
    abstract fun bindsRemoteTracksDataSource(
        remoteTracksDataSourceImpl: RemoteTracksDataSourceImpl
    ): RemoteTracksDataSource

    @Binds
    abstract fun bindsTracksRepository(
        tracksRepositoryImpl: TracksRepositoryImpl
    ): TracksRepository

    @Binds
    abstract fun bindsTracksInteractor(
        tracksInteractorImpl: TracksInteractorImpl
    ): TracksInteractor
}























