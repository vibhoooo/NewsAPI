package com.example.newsapi.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.newsapi.Article

@Composable
fun ArticleItem(
    article: Article
) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Surface(

        ) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = article.urlToImage ?: "",
                        builder = {
                            scale(Scale.FILL)
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = article.description ?: "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.2f)
                ) {
                    Text(
                        text = article.title ?: "",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )
                    Text(
                        text = article.author ?: "",
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )
                    Text(
                        text = article.description ?: "",
                        style = MaterialTheme.typography.body1,
                        maxLines = 2
                    )
                    Spacer(
                        modifier = Modifier.height(2.dp)
                    )
                    Text(
                        text = article.content ?: "",
                        style = MaterialTheme.typography.body2,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}
@Composable
fun ArticleList(
    articleList: List<Article>
) {
    LazyColumn {
        items(items = articleList) { item ->
            ArticleItem(
                article = item
            )
        }
    }
}