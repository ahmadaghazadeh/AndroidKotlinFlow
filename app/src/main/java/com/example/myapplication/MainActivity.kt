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

    val userList= listOf("User1","User2","User3","User4","User5")
    val flowUserList = flowOf("User1","User2","User3","User4","User5")
    val ageList= listOf(10,20,30,40,50,60)

    var TAG="MyAPP"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //flowBuilder()
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
//
//
//        }


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