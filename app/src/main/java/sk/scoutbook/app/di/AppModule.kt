package sk.scoutbook.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sk.scoutbook.app.ui.screen.home.data.repository.FakeRepository
import sk.scoutbook.app.ui.screen.home.data.repository.Repository

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRepository(): Repository = FakeRepository()
}