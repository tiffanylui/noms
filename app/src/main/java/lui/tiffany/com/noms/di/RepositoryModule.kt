package lui.tiffany.com.noms.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import lui.tiffany.com.noms.api.RecipesRepository
import lui.tiffany.com.noms.api.RecipesRepositoryImpl


@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRecipesRepository(impl: RecipesRepositoryImpl): RecipesRepository
}