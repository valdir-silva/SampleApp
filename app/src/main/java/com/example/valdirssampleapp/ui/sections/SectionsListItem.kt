package com.example.valdirssampleapp.ui.sections

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextSection(text: String?) {
    Text(
        modifier = Modifier
            .padding(4.dp),
        text = text ?: "N/A",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ButtonSection(text: String?, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(
            modifier = Modifier
                .padding(4.dp),
            text = text ?: "N/A",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}