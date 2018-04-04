package com.ninja.testninja.Interfaces

interface RequestCallBack<T>{
    fun OnSuccess(obj: T)
    fun onFail()
}