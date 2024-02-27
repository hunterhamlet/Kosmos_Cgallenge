package com.hamon.kosmos_challenge

import android.app.Application
import com.hamon.kosmos_challenge.data.datasource.RickAndMortyDataSource
import com.hamon.kosmos_challenge.data.datasource.RickAndMortyDataSourceImpl
import com.hamon.kosmos_challenge.data.repository_impl.RickAndMortyRepositoryImpl
import com.hamon.kosmos_challenge.domain.repository.RickAndMortyRepository
import com.hamon.kosmos_challenge.domain.use_case.GetCharacterUserCaseImpl
import com.hamon.kosmos_challenge.domain.use_case.GetCharactersUseCase
import com.hamon.kosmos_challenge.network.API
import com.hamon.kosmos_challenge.network.services.RickAndMortyServices
import com.hamon.kosmos_challenge.ui.view_models.ListMainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    services, repository, dataSource, useCase, viewModel
                )
            )
        }
    }

}

val services = module {
    single { API.getServices<RickAndMortyServices>() }
}

val dataSource = module {
    single<RickAndMortyDataSource> { RickAndMortyDataSourceImpl(get()) }
}

val repository = module {
    single<RickAndMortyRepository> { RickAndMortyRepositoryImpl(get()) }
}

val useCase = module {
    single<GetCharactersUseCase> { GetCharacterUserCaseImpl(get()) }
}

val viewModel = module {
    viewModel { ListMainViewModel(get()) }
}