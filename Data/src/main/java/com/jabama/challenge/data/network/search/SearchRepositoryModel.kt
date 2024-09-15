package com.jabama.challenge.data.network.search

import com.google.gson.annotations.SerializedName

data class SearchRepositoryModel(@SerializedName("items") val items: List<SearchRepositorySingleModel>)
