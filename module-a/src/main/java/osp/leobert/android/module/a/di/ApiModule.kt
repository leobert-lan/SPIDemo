package osp.leobert.android.module.a.di

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import osp.leobert.android.module.a.SomeOp
import javax.inject.Singleton

/**
 * Classname: ApiModule </p>
 * Description: TODO </p>
 * Created by leobert on 2023/12/10.
 */


@Module
@ContributesTo(AppScope::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideSomeOp(): SomeOp {
        return SomeOp()
    }
}