package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.*
import java.lang.Exception
import kotlin.math.log

@FlowPreview
class MainActivity : AppCompatActivity() {

    val userList= listOf("User1","User2","User3","User4","User5","User6")
    val flowUserList = flowOf("User1","User2","User3","User4","User5")
    val ageList= listOf(10,20,30,40,50,60)

    var TAG="MyAPP"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // if run in onCreate after backbutton stop this but if run in function run
//        lifecycleScope.launch(IO) {
//            simpleFlow().collect {user->
//                Log.d(TAG, "Flow1 $user")
//            }
//        }

//        lifecycleScope.launch(IO) {
//            ageList.asFlow().filter { age-> age%3==1 }
//                .collect { age->
//                    Log.d(TAG, "age : ${age.toString()}")
//                }
//
//        }


//        lifecycleScope.launch(IO) {
//            ageList.asFlow().filter { age-> age%3==1 }
//                .map{ age->
//                    "Age: $age"
//                }
//                .collect { age->
//                    Log.d(TAG, "age : ${age}")
//                }
//
//        }

//        lifecycleScope.launch(IO) {
//            ageList.asFlow()
//                .take(3)
//                .collect { age->
//                    Log.d(TAG, "age : ${age}")
//                }
//
//        }

//        lifecycleScope.launch(IO) {
//            val sum=ageList.asFlow()
//                .reduce { a,b->
//                    a+b
//                }
//            Log.d(TAG, "sum : ${sum}")
//
//        }

//        lifecycleScope.launch(IO) {
//            val sum=ageList.asFlow()
//                .toList()
//            Log.d(TAG, "sum : ${sum}")
//
//        }
//
//
//        lifecycleScope.launch(IO) {
//            val sum=ageList.asFlow()
//                .first()
//            Log.d(TAG, "sum : ${sum}")
//
//        }

//        lifecycleScope.launch(IO) {
//            ageList.asFlow()
//                .onCompletion {
//                    Log.d(TAG, "onCompletion")
//                }
//                .collect { age->
//                    Log.d(TAG, "age : ${age}")
//                }
//        }

//        lifecycleScope.launch(IO) {
//            val time = measureTimeMillis { simpleFlow()
//                .buffer()
//                .collect { user->
//                    delay(200)
//                    Log.d(TAG, "log2 ${user }}")
//                }
//            }
//            Log.d(TAG, "time ${time }}")
//        }

//        lifecycleScope.launch(IO) {
//            val time = measureTimeMillis { simpleFlow()
//                .conflate()
//                .collect { user->
//                    delay(1000)
//                    Log.d(TAG, "log2 ${user }}")
//                }
//            }
//            Log.d(TAG, "time ${time }}")
//        }

//        lifecycleScope.launch(IO) {
//            val time = measureTimeMillis { simpleFlow()
//                .conflate()
//                .collectLatest { user->
//                    delay(200)
//                    Log.d(TAG, "log2 ${user }}")
//                }
//            }
//            Log.d(TAG, "time ${time }}")
//        }

//        lifecycleScope.launch(IO) {
//                val users=userList.asFlow()
//                val ages=ageList.asFlow()
//
//            users.zip(ages){age,user->
//                "User $user, age $age"
//            }.collect {
//                Log.d(TAG, "${it }}")
//            }
//        }
//        lifecycleScope.launch(IO) {
//            val users=userList.asFlow()
//            val ages=ageList.asFlow()
//
//            users.combine(ages){age,user->
//                "User $user, age $age"
//            }.collect {
//                Log.d(TAG, "${it }}")
//            }
//        }
//        lifecycleScope.launch {
//            simpleFlow().collect { user ->
//                Log.d(TAG, "Flow1 $user")
//            }
//        }

//        CoroutineScope(IO).launch {
//            withTimeoutOrNull(4000){
//                simpleFlow().collect {user->
//                    Log.d(TAG, "Flow1 $user")
//                }
//            }
//        }

//        lifecycleScope.launch(Dispatchers.IO) {
//                simpleFlow().collect {user->
//                    Log.d(TAG, "Flow1 $user")
//                }
//        }

//        lifecycleScope.launch(Dispatchers.IO) {
//          val age=  ageList.asFlow().map { age->
//                check(age<50){
//                    "Error on value:$age"
//                }// throw exception with message
//            }
//            try {
//                age.collect { age->
//                    Log.d(TAG, "Flow1 $age")
//                }
//            }catch (e: Exception){
//                Log.d(TAG, e.toString())
//            }
//        }

//        lifecycleScope.launch(Dispatchers.IO) {
//            val age=  ageList.asFlow()
//            age.catch {e->
//                Log.d(TAG, e.toString())
//            }
//            .collect { age->
//                check(age<50){
//                    "Error on value:$age"
//                }// throw exception with message
//                Log.d(TAG, "Flow1 $age")
//            }
//        }

//        lifecycleScope.launch(Dispatchers.IO) {
//            ageList.asFlow()
//                .onEach {
//                    delay(100)
//                }
//                .flatMapConcat { age->
//                    userList.asFlow()
//                        .map {user->
//                            delay(500)
//                            "User : $user -Age $age"
//                        }
//                }
//                .collect {
//                    Log.d(TAG, "map $it")
//                }
//        }


//         lifecycleScope.launch(Dispatchers.IO) {
//            ageList.asFlow()
//                .onEach {
//                    delay(100)
//                }
//                .flatMapMerge { age->
//                    userList.asFlow()
//                        .map {user->
//                            "User : $user -Age $age"
//                        }
//                }
//                .collect {
//                    Log.d(TAG, "map $it")
//                }
//        }

        lifecycleScope.launch(Dispatchers.IO) {
            ageList.asFlow()
                .onEach {
                    delay(100)
                }
                .flatMapLatest { age->
                    userList.asFlow()
                        .map {user->
                            "User : $user -Age $age"
                        }
                }
                .collect {
                    Log.d(TAG, "map $it")
                }
        }

    }


    private fun flowBuilder() {
        CoroutineScope(IO).launch {
            launch {
                flowUserList.collect { user ->
                    Log.d(TAG, "Flow1 $user")
                }
            }
            launch {
                userList.asFlow().collect { user ->
                    Log.d(TAG, "Flow1 $user")
                }
            }


        }
    }

    private fun simpleFlow(): Flow<String> = flow{
        userList.forEach { user->
            emit(user)
            delay(5000)
        }
    }
}
