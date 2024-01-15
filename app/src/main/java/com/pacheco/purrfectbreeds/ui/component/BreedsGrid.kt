package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.purrfectbreeds.model.BreedModel

@Composable
fun BreedsGrid(
    pagingItems: LazyPagingItems<BreedModel>? = null,
    items: List<BreedModel> = listOf(),
    isFavoriteClickable: Boolean = true,
    onFavoriteClick: (String) -> Unit = {},
    onClick: (String) -> Unit,
    content: @Composable (BreedModel) -> Unit = {}
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(count = 2),
        modifier = Modifier.padding(top = 20.dp),
        verticalItemSpacing = 10.dp,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(count = pagingItems?.itemCount ?: items.size) {
            val id = pagingItems?.get(it)?.id ?: items[it].id

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { onClick(id) }
            ) {
                CatImage(url = pagingItems?.get(it)?.url ?: items[it].url)

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.surfaceBright)
                ) {
                    Body(
                        text = pagingItems?.get(it)?.name ?: items[it].name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 5.dp)
                            .weight(weight = 1f)
                    )

                    FavoriteButton(
                        isFavorite = pagingItems?.get(it)?.isFavorite ?: items[it].isFavorite,
                        isClickable = isFavoriteClickable
                    ) {
                        onFavoriteClick(id)
                    }
                }

                content(pagingItems?.get(it) ?: items[it])
            }
        }
    }
}
