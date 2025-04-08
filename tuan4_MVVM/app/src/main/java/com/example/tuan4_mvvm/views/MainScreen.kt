package com.example.tuan4_mvvm.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tuan4_mvvm.R
import com.example.tuan4_mvvm.viewmodel.MainViewModel
import com.example.tuan4_mvvm.model.TaskItem
import com.example.tuan4_mvvm.viewmodel.TaskItem

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        // Khung đầu với 2 nút (Back và Add New)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Sử dụng hình ảnh từ drawable cho nút Back
            IconButton(onClick = { viewModel.goBack() }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back), // Thay "ic_back" bằng tên tệp hình của bạn
                    contentDescription = "Back"
                )
            }
            // Sử dụng hình ảnh từ drawable cho nút Add New
            IconButton(onClick = { viewModel.navigateToAddNewScreen() }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add), // Thay "ic_add" bằng tên tệp hình của bạn
                    contentDescription = "Add New"
                )
            }
        }

        // Khung thân với LazyColumn chứa nội dung
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(uiState.items) { item ->
                TaskItem(item = item)
            }
        }

        // Khung cuối với 5 ô, các nút chuyển trang
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { viewModel.navigateToPage(1) }) {
                Text(text = "Trang 1")
            }
            Button(onClick = { viewModel.navigateToPage(2) }) {
                Text(text = "Trang 2")
            }
            Button(onClick = { viewModel.navigateToPage(3) }) {
                Text(text = "Trang 3")
            }
            Button(onClick = { viewModel.navigateToPage(4) }) {
                Text(text = "Trang 4")
            }
            Button(onClick = { viewModel.navigateToPage(5) }) {
                Text(text = "Trang 5")
            }
        }
    }
}
