package osp.leobert.android.module.a

import com.google.auto.service.AutoService
import osp.leobert.android.api.DemoApi
import osp.leobert.android.api.DemoApiFactory

@AutoService(DemoApi::class)
class ModuleADemoApiImpl2(val someOp: SomeOp) : DemoApi {
    companion object {
        const val NAME = "ModuleADemoApiImpl2"
    }

    override fun doSth(): String {
        return "${someOp.execute()} - the result by $NAME"
    }

    @AutoService(DemoApiFactory::class)
    class Factory : DemoApiFactory {
        override fun create(): DemoApi {
            return ModuleADemoApiImpl2(SomeOp())
        }
    }
}