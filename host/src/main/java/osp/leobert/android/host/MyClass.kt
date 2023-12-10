package osp.leobert.android.host

import osp.leobert.android.api.DemoApi
import osp.leobert.android.api.DemoApiFactory
import osp.leobert.android.api.DemoApiFactory2
import osp.leobert.android.api.Foo
import java.util.ServiceLoader


fun main() {

    directLoadDemo()

    useFactoryDemo()

    useBuilderDemo()

    withDaggerDemo()

}

fun directLoadDemo() {

    val loader = ServiceLoader.load(DemoApi::class.java)
    val iterator = loader.iterator()
    var hasNext = false
    do {
        try {
            hasNext = iterator.hasNext()
            if (hasNext) {
                iterator.next().let {
                    println("find a impl of DemoApi, doSth:")
                    println(it.doSth())
                    println()
                }
            }
        } catch (e: Throwable) {
            println("thr: " + e.message)
        }
    } while (hasNext)

    println("finish directLoadDemo\r\n")
}

fun useFactoryDemo() {
    val loader = ServiceLoader.load(DemoApiFactory::class.java)
    val iterator = loader.iterator()
    var hasNext = false
    do {
        try {
            hasNext = iterator.hasNext()
            if (hasNext) {
                iterator.next().create().let {
                    println("find a impl of DemoApi, doSth:")
                    println(it.doSth())
                    println()
                }
            }
        } catch (e: Throwable) {
            println("thr: " + e.message)
        }
    } while (hasNext)

    println("finish useFactoryDemo\r\n")
}


fun useBuilderDemo() {
    val loader = ServiceLoader.load(DemoApi.Builder.Factory::class.java)
    val iterator = loader.iterator()
    var hasNext = false
    do {
        try {
            hasNext = iterator.hasNext()
            if (hasNext) {
                iterator.next().create().let {
                    it.foo = Foo()
                    it.build()
                }.let {
                    println("find a impl of DemoApi, doSth:")
                    println(it.doSth())
                    println()
                }
            }
        } catch (e: Throwable) {
            println("thr: " + e.message)
        }
    } while (hasNext)

    println("finish useBuilderDemo\r\n")
}

fun withDaggerDemo() {
    val loader = ServiceLoader.load(DemoApiFactory2::class.java)
    val iterator = loader.iterator()
    var hasNext = false
    do {
        try {
            hasNext = iterator.hasNext()
            if (hasNext) {
                val next = iterator.next()
                var round = 1
                repeat(2) {
                    next.create(foo = Foo()).let {
                        println("round ${round++} find a impl of DemoApi, doSth:")
                        println(it.doSth())
                        println()
                    }
                }
            }
        } catch (e: Throwable) {
            println("thr: " + e.message)
        }
    } while (hasNext)

    println("finish withDaggerDemo\r\n")
}