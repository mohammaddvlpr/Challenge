package com.jabama.challenge.data.repository.search

import com.jabama.challenge.data.network.search.models.SearchRepositorySingleModel
import com.jabama.challenge.domain.search.model.SearchModel

class SearchMapper {

    fun mapToDomain(items: List<SearchRepositorySingleModel>): List<SearchModel> {
        return items.map {
            SearchModel(
                id = it.id,
                fullName = it.fullName,
                avatarUrl = it.avatarUrl,
                url = it.url,
                isPrivate = it.isPrivate
            )
        }
    }
}