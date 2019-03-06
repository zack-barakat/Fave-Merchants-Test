package com.android.favemerchants.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.android.favemerchants.di.qualifiers.ApplicationContext
import com.android.favemerchants.di.scopes.ApplicationScope
import javax.inject.Inject

interface IPreferencesHelper {
}

@ApplicationScope
class AppPreferencesHelper @Inject
constructor(@ApplicationContext context: Context) : IPreferencesHelper {

    companion object {
        private const val PREF_FILE_NAME = "FAVE_MERCHANTS"
    }

    private val mSharedPreferences: SharedPreferences
    private val mPreferenceEditors
        get() = mSharedPreferences.edit()

    init {
        mSharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }
}
