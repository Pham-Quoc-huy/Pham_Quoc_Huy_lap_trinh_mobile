package com.example.tuan4_mvvm.views
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuan4_mvvm.R
@Composable
fun ListScreen(){
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {},
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .size(56.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0xFF2196F3),
                    contentColor = Color.White
                )) {
                Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)))
            }
            Text(text = "List",
                fontSize = 32.sp,
                color = Color(0xFF2196F3),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().weight(1f),
                textAlign = TextAlign.Center)
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                contentColor = Color.Black,
                containerColor = Color(0x4DBBBBBB)
            ),
            elevation = CardDefaults.cardElevation(1.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.empty),
                        contentDescription = null,
                        modifier = Modifier.size(200.dp)
                    )
                }
                Text(text = "No Tasks Yet!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center)
                Text(text = "Stay productive—add something to do",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center)
            }
        }
    }
}