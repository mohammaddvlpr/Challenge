package com.jabama.challenge.ui.search

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jabama.challenge.login.R
import com.jabama.challenge.ui.HyperLinkText
import com.jabama.challenge.ui.search.model.SearchUiModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SearchScreenContent()
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreenContent() {
    SearchBar(query = "",
        onQueryChange = {},
        onSearch = {},
        active = true,
        onActiveChange = {}) {
        LazyColumn {

        }
    }
}

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    searchUiModel: SearchUiModel
) {
    Row(modifier) {

        Column(modifier = Modifier.weight(1f)) {
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
            modifier = Modifier.clip(RoundedCornerShape(8.dp)).aspectRatio(1f).fillMaxHeight(),
            contentDescription = stringResource(R.string.repository_image)
        )


    }
}

@Preview
@Composable
fun SearchItemPrev() {
    SearchItem(
        searchUiModel = SearchUiModel(
            "Tetris game",
            "https://avatars.githubusercontent.com/u/54574371?v=4&size=64",
            url = "https://github.com/pouyaam/JabamaCodeChallenge",
            privacy = "private"
        )
    )
}
