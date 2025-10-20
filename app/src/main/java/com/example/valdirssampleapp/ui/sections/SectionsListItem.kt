package com.example.valdirssampleapp.ui.sections

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.valdirssampleapp.ui.theme.IndodanaPrimaryGreen

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
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = IndodanaPrimaryGreen
        )
    ) {
        Text(
            modifier = Modifier
                .padding(4.dp),
            text = text ?: "N/A",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}