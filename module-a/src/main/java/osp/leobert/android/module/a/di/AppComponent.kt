package osp.leobert.android.module.a.di

import com.squareup.anvil.annotations.MergeComponent
import osp.leobert.android.module.a.ModuleADemoApiImpl4
import javax.inject.Singleton

@Singleton
@MergeComponent(AppScope::class)
interface AppComponent {
    //    @Provides
    fun provideFactory(): ModuleADemoApiImpl4.Factory
}