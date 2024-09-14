package com.jabama.challenge.ui.search

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.jabama.challenge.login.R
import com.jabama.challenge.ui.HyperLinkText
import com.jabama.challenge.ui.search.model.SearchScreenState
import com.jabama.challenge.ui.search.model.SearchUiModel
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val state by searchViewModel.state.collectAsState()
            SearchScreenContent(
                searchScreenState = state,
                pagingDataFlow = searchViewModel.pagingFlow
            ) {
                searchViewModel.onQueryChange(it)
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreenContent(
    searchScreenState: SearchScreenState,
    pagingDataFlow: Flow<PagingData<SearchUiModel>>,
    onQueryChange: (String) -> Unit
) {

    val pagingItems = pagingDataFlow.collectAsLazyPagingItems()

    SearchBar(modifier = Modifier.fillMaxSize(), query = searchScreenState.query,
        onQueryChange = onQueryChange,
        onSearch = {},
        placeholder = { Text(text = stringResource(id = R.string.start_searching)) },
        active = true,
        onActiveChange = {}) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            if (pagingItems.itemCount == 0 && pagingItems.loadState.refresh is LoadState.NotLoading)
                item {
                    EmptyView(Modifier.fillParentMaxSize())
                }
            else if (pagingItems.loadState.refresh is LoadState.Loading)
                item {
                    Loading(Modifier.fillParentMaxSize())
                }
            else if (pagingItems.loadState.refresh is LoadState.Error)
                item {
                    Retry(modifier = Modifier.fillParentMaxSize()) {
                        pagingItems.retry()
                    }
                }
            else if (pagingItems.itemCount > 0 && pagingItems.loadState.refresh is LoadState.NotLoading)
                items(count = pagingItems.itemCount , key = {
                    val item = pagingItems[it]
                    item?.id ?: it
                }) {
                    val item = pagingItems[it]
                    if (item != null)
                        SearchItem(searchUiModel = item)

                }

            item {
                if (pagingItems.loadState.source.append is LoadState.Loading)
                    Loading(Modifier.fillParentMaxWidth())
                else if (pagingItems.loadState.source.append is LoadState.Error)
                    Retry(
                        modifier = Modifier.fillParentMaxWidth(),
                        onClick = { pagingItems.retry() })
            }
        }
    }
}

@Composable
fun EmptyView(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .wrapContentSize(align = Alignment.Center),
        text = stringResource(id = R.string.no_result_message)
    )
}

@Composable
fun Retry(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(modifier = modifier.wrapContentSize(Alignment.Center), onClick = onClick) {
        Text(text = stringResource(id = R.string.retry))
    }
}

@Composable
fun Loading(modifier: Modifier = Modifier) {
    CircularProgressIndicator(
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    searchUiModel: SearchUiModel
) {
    Surface(
        shadowElevation = 8.dp,
        tonalElevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier
                .padding(8.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = searchUiModel.fullName,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 18.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = searchUiModel.privacy,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                )

                HyperLinkText(
                    url = searchUiModel.url,
                )


            }
            AsyncImage(
                model = searchUiModel.avatarUrl,
                placeholder = painterResource(id = R.drawable.default_avatar),
                error = painterResource(id = R.drawable.default_avatar),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .aspectRatio(1f)
                    .fillMaxSize(),
                contentDescription = stringResource(R.string.repository_image)
            )


        }
    }
}

@Preview
@Composable
fun SearchItemPrev() {
    SearchItem(
        searchUiModel = SearchUiModel(
            id = 1,
            "Tetris game",
            "https://avatars.githubusercontent.com/u/54574371?v=4&size=64",
            url = "https://github.com/pouyaam/JabamaCodeChallenge",
            privacy = "private"
        )
    )
}
