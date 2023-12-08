package osp.leobert.android.module.a

import com.google.auto.service.AutoService
import osp.leobert.android.api.DemoApi
import osp.leobert.android.api.DemoApiFactory
import osp.leobert.android.api.Foo

//@AutoService(DemoApi::class)
class ModuleADemoApiImpl3(val someOp: SomeOp, val needProvideByHost: Foo) : DemoApi {


    companion object {
        const val NAME = "ModuleADemoApiImpl3"
    }

    override fun doSth(): String {
        return "${someOp.execute()} ,param2 create at${needProvideByHost.createdAt} - the result by $NAME"
    }


    class Builder(val someOp: SomeOp) : DemoApi.Builder {

        override lateinit var foo: Foo

        override fun build(): DemoApi {
            return ModuleADemoApiImpl3(someOp, foo)
        }

        @AutoService(DemoApi.Builder.Factory::class)
        class Factory : DemoApi.Builder.Factory {
            override fun create(): DemoApi.Builder {
                //the logic to get SomeOp instance,it may be complex
                val someOp = SomeOp()
                return Builder(someOp)
            }
        }
    }
}