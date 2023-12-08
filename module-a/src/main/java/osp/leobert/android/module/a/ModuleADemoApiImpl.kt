package osp.leobert.android.module.a

import com.google.auto.service.AutoService
import osp.leobert.android.api.DemoApi
import osp.leobert.android.api.DemoApiFactory

@AutoService(DemoApi::class)
class ModuleADemoApiImpl : DemoApi {
    companion object {
        const val NAME = "ModuleADemoApiImpl"
    }

    override fun doSth(): String {
        return "the result by $NAME"
    }

    @AutoService(DemoApiFactory::class)
    class Factory : DemoApiFactory {
        override fun create(): DemoApi {
            return ModuleADemoApiImpl()
        }
    }
}