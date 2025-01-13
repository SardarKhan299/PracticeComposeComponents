package com.example.samplecomposeapp.PracticeScreens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.samplecomposeapp.textField.CharacterCountComposable
import com.example.samplecomposeapp.ui.theme.SampleComposeAppTheme
import kotlinx.coroutines.launch

@Composable
fun AssignmentScreen(notificationItem: NotificationItem,modifier: Modifier = Modifier) {
  LazyColumn(
    modifier = modifier
      .fillMaxSize()
      .background(Color.White),
    verticalArrangement = Arrangement.spacedBy(16.dp)){
    item {
      NotificationCard(notificationItem)
    }
  }
}


@Composable
fun NotificationCard(notificationItem: NotificationItem,modifier: Modifier = Modifier) {
    Column (
      modifier = Modifier
        .padding(
          top = 45.dp,
          start = 8.dp, end = 8.dp
        )
        .clip(RoundedCornerShape(6.dp))
        .background(Color.Red)
        .fillMaxSize()
        .heightIn(
          min = 150.dp,
          max = 200.dp
        )
    ){
      Row(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          imageVector = Icons.Default.CheckCircle,
          contentDescription = null,
          tint = Color.White
        )

        Text(text = "Project X",
          color = Color.White,
          fontSize = 32.sp,
          modifier = Modifier
            .weight(1f)
        )

        Icon(
          imageVector = Icons.Default.MoreVert,
          contentDescription = null,
          tint = Color.White,
          modifier = Modifier.rotate(90f)

        )
      }

      Text(text = "This is a short Description",
        color = Color.White,
        fontSize = 20.sp,
        modifier = Modifier
          .fillMaxWidth(),
        textAlign = TextAlign.Center
      )
      Text(text = "Mar 5, 10:00",
        color = Color.White,
        fontSize = 24.sp,
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 12.dp,
            end = 8.dp),
        textAlign = TextAlign.End
      )


    }
}


@PreviewScreenSizes
@Preview(showBackground = true)
@Composable
fun AssignmentScreenPreview() {
  SampleComposeAppTheme {
    AssignmentScreen(
      notificationItem = NotificationItem(
        title = "My notification",
        text = """
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et est tellus. Donec placerat sodales arcu. Quisque malesuada iaculis est. Sed vestibulum enim est, eu venenatis eros egestas rhoncus. Praesent nec quam ipsum. Phasellus venenatis placerat enim, nec rhoncus nunc pretium quis. In id tincidunt purus. Donec pretium, magna hendrerit feugiat suscipit, nibh sem efficitur arcu, quis tempus mi felis id diam. Quisque tempor enim a est tempus, eget interdum eros ultricies. Aliquam fringilla rutrum sapien ut elementum. Sed consectetur justo lorem, sit amet hendrerit tortor tincidunt sed. Nulla dolor ligula, lobortis ut dapibus id, varius eu massa. Nullam ut pharetra dolor, id feugiat nisi. Suspendisse a lorem neque. Proin et sapien eu tortor venenatis tincidunt et et orci. Aliquam erat volutpat.
                """.trimIndent(),
        date = "Jan 5, 11:45"
      )
    )
  }
}

data class  NotificationItem (val title:String, val text:String, val date:String)