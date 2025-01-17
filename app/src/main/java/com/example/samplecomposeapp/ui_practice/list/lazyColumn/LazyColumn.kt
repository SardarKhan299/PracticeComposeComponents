package com.example.samplecomposeapp.ui_practice.list.lazyColumn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplecomposeapp.ui_practice.list.components.CustomItem
import com.example.samplecomposeapp.ui_practice.list.model.Person
import com.example.samplecomposeapp.ui_practice.list.repository.PersonRepository

@Composable
fun CustomLazyColumn(modifier: Modifier = Modifier, list: List<Person>) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(list, key = { it.id }) { person ->
            CustomItem(person)
        }

    }

}


@Preview(showBackground = true)
@Composable
private fun CustomLazyColumnPreview() {
    MaterialTheme {
        val personList = remember {
            mutableStateListOf<Person>().apply {
                addAll(
                    PersonRepository().getAllData()
                )
            }
        }
        CustomLazyColumn(
            list = personList
        )
    }
}