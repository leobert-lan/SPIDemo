package osp.leobert.android.module.a

import com.google.auto.service.AutoService
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import osp.leobert.android.api.DemoApi
import osp.leobert.android.api.DemoApiFactory
import osp.leobert.android.api.DemoApiFactory2
import osp.leobert.android.api.Foo
import osp.leobert.android.module.a.di.DaggerAppComponent

class ModuleADemoApiImpl4
@AssistedInject constructor(
    val someOp: SomeOp,
    @Assisted val needProvideByHost: Foo
) : DemoApi {

    companion object {
        const val NAME = "ModuleADemoApiImpl4"
    }

    override fun doSth(): String {
        return "${someOp.execute()} ,param2 create at${needProvideByHost.createdAt} - the result by $NAME"
    }

    @AutoService(DemoApiFactory2::class)
    class SpiFactory : DemoApiFactory2 {
        private val factory by lazy {
            DaggerAppComponent.create().provideFactory()
        }

        override fun create(foo: Foo): DemoApi {
            return factory.create(foo)
        }
    }

    @AssistedFactory
    abstract class Factory {
        abstract fun create(@Assisted needProvideByHost: Foo): ModuleADemoApiImpl4
    }
}