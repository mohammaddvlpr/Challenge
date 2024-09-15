package com.jabama.challenge.data.network.search.models

import com.google.gson.annotations.SerializedName

data class SearchRepositoryModel(@SerializedName("items") val items: List<SearchRepositorySingleModel>)
