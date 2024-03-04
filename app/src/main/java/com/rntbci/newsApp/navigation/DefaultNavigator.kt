package com.rntbci.newsApp.navigation

import com.rntbci.common_utils.Activities
import com.rntbci.common_utils.Navigator
import com.rntbci.news_presentation.GoToNewsActivity
import com.rntbci.search_presentation.GoToSearchActivity

class DefaultNavigator : Navigator.Provider {

    override fun getActivities(activities: Activities): Navigator {
        return when (activities) {
            Activities.NewsActivity -> {
                GoToNewsActivity
            }

            Activities.SearchActivity -> {
                GoToSearchActivity
            }
        }

    }

}