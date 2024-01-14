package com.pacheco.purrfectbreeds.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.compose.AsyncImage
import com.pacheco.purrfectbreeds.R
import com.purrfectbreeds.model.BreedModel

@Composable
fun BreedsGrid(
    pagingItems: LazyPagingItems<BreedModel>? = null,
    items: List<BreedModel> = listOf(),
    isFavoriteClickable: Boolean = true,
    onFavoriteClick: (String) -> Unit = {},
    content: @Composable (BreedModel) -> Unit = {}
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(count = 2),
        modifier = Modifier.padding(top = 20.dp)
    ) {
        items(count = pagingItems?.itemCount ?: items.size) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = pagingItems?.get(it)?.url ?: items[it].url,
                    contentDescription = null,
                    error = painterResource(id = R.drawable.ic_downloading),
                    placeholder = painterResource(id = R.drawable.ic_downloading)
                )
                Body(
                    text = pagingItems?.get(it)?.name ?: items[it].name,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
                content(pagingItems?.get(it) ?: items[it])
            }

            Box(contentAlignment = Alignment.TopEnd) {
                FavoriteButton(
                    isFavorite = pagingItems?.get(it)?.isFavorite ?: items[it].isFavorite,
                    isClickable = isFavoriteClickable
                ) {
                    onFavoriteClick(pagingItems?.get(it)?.id ?: items[it].id)
                }
            }
        }
    }
}
