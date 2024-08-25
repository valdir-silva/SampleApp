package com.example.valdirssampleapp.ui.userList

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.valdirssampleapp.domain.models.ButtonSectionModel
import com.example.valdirssampleapp.domain.models.SectionModel
import com.example.valdirssampleapp.domain.models.SectionsModel
import com.example.valdirssampleapp.domain.models.TextSectionModel
import com.example.valdirssampleapp.ui.sections.ButtonSection
import com.example.valdirssampleapp.ui.sections.TextSection
import org.koin.androidx.compose.koinViewModel

@SuppressLint("Range")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = koinViewModel()
) {
    Column {
        Column(modifier = modifier.fillMaxHeight(10f)) {
            val isLoading by homeViewModel.isLoading.collectAsState()
            val sectionsList by homeViewModel.sectionsList.observeAsState()

            Box(modifier = modifier.fillMaxSize()) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                } else {
                    sectionsList?.let { SectionsList(sections = it) }
                }
            }
            sectionsList?.let { SectionsList(sections = it) }
        }
    }
}

// TODO tirar daqui
@Composable
fun SetSectionsView(section: SectionModel) {
    when (section) {
        is TextSectionModel -> {
            TextSection(
                text = section.text
            )
        }

        is ButtonSectionModel -> {
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
    sections: SectionsModel,
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