package com.example.valdirssampleapp.ui.userList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.valdirssampleapp.networking.data.response.sections.ButtonSectionResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionResponse
import com.example.valdirssampleapp.networking.data.response.sections.SectionsResponse
import com.example.valdirssampleapp.networking.data.response.sections.TextSectionResponse

@SuppressLint("Range")
@Composable
fun UserListScreen(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel = viewModel()
) {
    Column {
        Column(modifier = modifier.fillMaxHeight(10f)) {
            val sectionsList by userViewModel.sectionsList.observeAsState()
            sectionsList?.let { SectionsList(sections = it) }
        }
    }
}

@Composable
fun SetSectionsView(section: SectionResponse) {
    when (section) {
        is TextSectionResponse -> {
            TextSection(
                text = section.text
            )
        }

        is ButtonSectionResponse -> {
            ButtonSection(
                text = section.content
            ) {
                // Handle button click
            }
        }
    }
}

@Composable
fun SectionsList(
    sections: SectionsResponse,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        // TODO criar componente de toolbar
        item {
            MyToolbar(title = sections.title)
        }
        items(sections.sections) {
            SetSectionsView(section = it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolbar(title: String) {
    CenterAlignedTopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Gray
        )
    )
}