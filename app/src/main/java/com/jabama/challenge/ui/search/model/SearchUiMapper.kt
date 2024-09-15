package com.jabama.challenge.ui.search.model

import android.app.Application
import com.jabama.challenge.domain.search.models.SearchModel
import com.jabama.challenge.login.R

class SearchUiMapper(private val appContext: Application) {

    fun mapToUi(searchModel: SearchModel): SearchUiModel {
        return SearchUiModel(
            id = searchModel.id,
            fullName = searchModel.fullName,
            avatarUrl = searchModel.avatarUrl,
            url = searchModel.url,
            privacy = if (searchModel.isPrivate)
                appContext.getString(R.string.private_repo)
            else
                appContext.getString(R.string.public_repo)
        )
    }
}