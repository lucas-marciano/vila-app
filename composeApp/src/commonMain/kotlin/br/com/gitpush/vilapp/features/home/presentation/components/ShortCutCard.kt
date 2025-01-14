package br.com.gitpush.vilapp.features.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.gitpush.vilapp.features.home.domain.HomeMenus
import br.com.gitpush.vilapp.ui.theme.VilaTheme

@Composable
internal fun ShortCutCard(
    modifier: Modifier = Modifier,
    item: HomeMenus,
) {
    Card(
        modifier = modifier.height(80.dp)
    ) {
        Row(
            modifier = Modifier.padding(VilaTheme.spaces.medium),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(imageVector = item.icon, contentDescription = null, tint = Color.White)
            Text(text = item.name, color = Color.White)
        }
    }
}
