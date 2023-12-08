package osp.leobert.android.api

interface DemoApi {

    fun doSth(): String

    interface Builder {

        var foo: Foo

        fun build(): DemoApi

        interface Factory {
            fun create(): Builder
        }
    }
}