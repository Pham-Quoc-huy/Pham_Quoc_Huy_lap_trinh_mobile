package views
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.foundation.clickable
@Composable
fun SettingScreen() {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

    // Tải màu đã lưu từ SharedPreferences
    val savedColor = loadColor(sharedPreferences)
    var selectedColor by remember { mutableStateOf(savedColor) }  // Trạng thái lưu màu đã chọn

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(selectedColor),  // Đặt màu nền theo màu đã chọn
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Tiêu đề và mô tả Setting
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Setting",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Choosing the right theme sets the tone and personality of your app.",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Blue
        )

        // Các ô màu (Boxes)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ColorOption(color = Color.Cyan, onClick = {
                selectedColor = Color.Cyan
                saveColor(sharedPreferences, Color.Cyan)  // Lưu màu vào SharedPreferences
            })
            ColorOption(color = Color.Magenta, onClick = {
                selectedColor = Color.Magenta
                saveColor(sharedPreferences, Color.Magenta)
            })
            ColorOption(color = Color.Black, onClick = {
                selectedColor = Color.Black
                saveColor(sharedPreferences, Color.Black)
            })
        }

        // Nút Apply
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Xử lý hành động Apply */ },
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) {
            Text(text = "Apply")
        }
    }
}

// Hàm lưu màu vào SharedPreferences
fun saveColor(sharedPreferences: SharedPreferences, color: Color) {
    val editor = sharedPreferences.edit()
    editor.putInt("selectedColor", color.toArgb())  // Lưu màu dưới dạng số nguyên (ARGB)
    editor.apply()
}

// Hàm tải màu từ SharedPreferences
fun loadColor(sharedPreferences: SharedPreferences): Color {
    val savedColor = sharedPreferences.getInt("selectedColor", Color.White.toArgb())  // Mặc định là màu trắng
    return Color(savedColor)
}

@Composable
fun ColorOption(color: Color, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(color)
            .border(2.dp, Color.Black)
            .clickable(onClick = onClick)  // Tạo ô màu có thể nhấn
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingScreen() {
    SettingScreen()
}
