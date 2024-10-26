package com.example.autenticador

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.autenticador.ui.theme.AutenticadorTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val auth = Firebase.auth

        Log.i(TAG, "onCreate: usuário atual: ${auth.currentUser}")
        auth.createUserWithEmailAndPassword(
            "james.francis.byrnes@example-pet-store.com",
            "123456"
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.i(TAG, "onCreate: Sucesso")
            }
            else
            {
                Log.i(TAG, "onCreate: Falha -> ${task.exception}")
            }
            auth.signInWithEmailAndPassword(
                "james.francis.byrnes@example-pet-store.com",
                "123456"
            )
        }
        setContent()
        {
            AutenticadorTheme()
            {
                Scaffold(modifier = Modifier.fillMaxSize())
                { padding ->
                    Column(modifier = Modifier.padding(padding))
                    {
                        Text(text = "Autenticador") // Texto adionado para parar de dar erro no innerPadding
                    }

                }
            }
        }
    }
}
