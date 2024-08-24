package com.example.valdirssampleapp.ui.userList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun UserListItem(value: String?) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
    ) {
        UserName(value)
        UserImage(value)
        UserGender(value)
        UserAbout(value)
    }
}

@Composable
fun UserAbout(about: String?) {
    Text(
        modifier = Modifier
            .padding(4.dp),
        text = "About",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
    about?.let {
        Text(
            modifier = Modifier
                .padding(4.dp),
            text = it
        )
    }
}

@Composable
fun UserGender(gender: String?) {
    Text(
        modifier = Modifier
            .padding(4.dp),
        text = "Gender",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        modifier = Modifier
            .padding(4.dp),
        text = gender ?: "N/A"
    )
}

@Composable
fun UserImage(img: String?) {
    AsyncImage(
        model = img,
        contentDescription = "user image",
        Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .size(350.dp, 350.dp)
            .border(border = BorderStroke(3.dp, color = Color.Black), RectangleShape),
        contentScale = ContentScale.Fit
    )
}

@Composable
fun UserName(name: String?) {
    Text(
        modifier = Modifier
            .padding(4.dp),
        text = name ?: "N/A",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun UserSchool(school: String?) {
    Text(
        modifier = Modifier
            .padding(4.dp),
        text = school ?: "N/A",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun UserHobbies(hobbies: List<String>?) {
    Text(
        modifier = Modifier
            .padding(4.dp),
        text = hobbies.toString() ?: "N/A",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

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