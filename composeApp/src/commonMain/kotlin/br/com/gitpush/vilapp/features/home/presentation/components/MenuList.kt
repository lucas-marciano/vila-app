package br.com.gitpush.vilapp.features.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.gitpush.vilapp.features.home.domain.ListData

@Composable
internal fun MenuList(
    modifier: Modifier = Modifier,
    menus: List<ListData> = emptyList(),
    addAction: () -> Unit
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        itemsIndexed(menus) { index, item ->
            val isLastItem = index == menus.lastIndex
            if (isLastItem) {
                ShortCutAddCard(addAction = addAction)
            } else {
                ShortCutMenuCard(item = item)
            }
        }
    }
}
