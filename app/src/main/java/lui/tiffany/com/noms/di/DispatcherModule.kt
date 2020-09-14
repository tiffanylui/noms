package lui.tiffany.com.noms.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DispatcherModule {

    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): Dispatchers = Dispatchers

}