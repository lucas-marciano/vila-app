package br.com.gitpush.vilapp.features.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.gitpush.vilapp.features.home.domain.ListData
import br.com.gitpush.vilapp.ui.theme.VilaTheme

@Composable
internal fun ShortCutAddCard(
    modifier: Modifier = Modifier, addAction: () -> Unit
) {
    Card(
        modifier = modifier
            .height(80.dp)
            .width(40.dp)
            .clickable { addAction() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardColors(
            containerColor = VilaTheme.colors.success,
            contentColor = VilaTheme.colors.onPrimary,
            disabledContentColor = VilaTheme.colors.onPrimary,
            disabledContainerColor = VilaTheme.colors.success,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(VilaTheme.spaces.large),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
internal fun ShortCutMenuCard(
    modifier: Modifier = Modifier,
    item: ListData,
) {
    Card(
        modifier = modifier.height(80.dp).clickable { item.action(item.id) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardColors(
            containerColor = VilaTheme.colors.success,
            contentColor = VilaTheme.colors.onPrimary,
            disabledContentColor = VilaTheme.colors.onPrimary,
            disabledContainerColor = VilaTheme.colors.success,
        )
    ) {
        Column(
            modifier = Modifier.padding(VilaTheme.spaces.large),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = item.name, color = Color.White, fontSize = 20.sp)
            Text(text = item.details, color = Color.White.copy(alpha = .7f), fontSize = 15.sp)
        }
    }
}
