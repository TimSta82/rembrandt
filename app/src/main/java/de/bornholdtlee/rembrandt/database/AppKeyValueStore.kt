package de.bornholdtlee.rembrandt.database

import android.content.Context
import android.content.SharedPreferences
import de.bornholdtlee.rembrandt.R
import java.util.*

class AppKeyValueStore(val context: Context) {

    companion object {
        private const val PREF_KEY_FIREBASE_UID = "PREF_KEY_FIREBASE_UID"
//
//
//        // BKK STUFF
//        private const val PREF_KEY_CUSTOMIZING_CODE = "CUSTOMIZING_CODE"
//        private const val PREF_KEY_CUSTOMIZING_NAME = "CUSTOMIZING_NAME"
//        private const val PREF_KEY_CUSTOMIZING_LOGO_PATH = "CUSTOMIZING_LOGO_PATH"
//        private const val PREF_KEY_CUSTOMIZING_COMPANY_LOGO_PATH = "CUSTOMIZING_COMPANY_LOGO_PATH"
//        private const val PREF_KEY_CUSTOMIZING_COLOR_BKK_100 = "PREF_KEY_CUSTOMIZING_COLOR_BKK_100"
//        private const val PREF_KEY_CUSTOMIZING_COLOR_BKK_60 = "PREF_KEY_CUSTOMIZING_COLOR_BKK_60"
//        private const val PREF_KEY_CUSTOMIZING_COLOR_BKK_30 = "PREF_KEY_CUSTOMIZING_COLOR_BKK_30"
//        private const val PREF_KEY_CUSTOMIZING_COLOR_ASSISTANT =
//            "PREF_KEY_CUSTOMIZING_COLOR_ASSISSTENT"
//        private const val PREF_KEY_CUSTOMIZING_COMPANY_NAME = "CUSTOMIZING_COMPANY_NAME"
//        private const val PREF_KEY_CUSTOMIZING_COMPANY_TOC = "PREF_KEY_CUSTOMIZING_COMPANY_TOC"
//        private const val PREF_KEY_CUSTOMIZING_COMPANY_LEGAL = "PREF_KEY_CUSTOMIZING_COMPANY_LEGAL"
//        private const val PREF_KEY_CUSTOMIZING_COMPANY_DATA_PRIVACY =
//            "PREF_KEY_CUSTOMIZING_COMPANY_DATA_PRIVACY"
//        private const val PREF_KEY_CUSTOMIZING_COMPANY_ENABLED = "CUSTOMIZING_COMPANY_ENABLED"
//
//        private const val PREF_KEY_IS_TUTORIAL_DONE = "TUTORIAL_DONE"
//        private const val PREF_KEY_ASSESSMENT_EXPLAINED = "ASSESSMENT_EXPLAINED"
//        private const val PREF_KEY_PUSH_ENABLED = "PUSH_ENABLED"
//        private const val PREF_KEY_LAST_SAVED_ANSWER = "LAST_SAVED_ANSWER"
//        private const val PREF_KEY_TESTING_LENGTH_OF_DAY = "TESTING_LENGTH_OF_DAY"
//        private const val PREF_KEY_ASSISTANT = "PREF_KEY_ASSISTANT"
//        private const val PREF_KEY_ASSISTANT_NAME = "PREF_KEY_ASSISTANT_NAME"
//        private const val PREF_KEY_API_TOKEN = "PREF_KEY_API_TOKEN"
//        private const val PREF_KEY_USER_NAME = "PREF_KEY_USER_NAME"
//        private const val PREF_KEY_ASSESSMENT_QUESTION_INDEX = "PREF_KEY_ASSESSMENT_QUESTION_INDEX"
//
//        private const val PREF_KEY_PUSH_TOKEN = "PREF_KEY_PUSH_TOKEN"
//        private const val PREF_KEY_APP_USER_ID = "PREF_KEY_APP_USER_ID"
//
//        private const val PREF_KEY_SUBSCRIBED_CATEGORIES = "PREF_KEY_SUBSCRIBED_CATEGORIES"
//
//        private const val PREF_KEY_APP_START_USER_ACTION = "PREF_KEY_APP_START_USER_ACTION"
//        private const val PREF_KEY_ASSESSMENT_FINISHED_USER_ACTION =
//            "PREF_KEY_ASSESSMENT_FINISHED_USER_ACTION"
//        private const val PREF_KEY_READ_GOAL_ARTICLE_USER_ACTION =
//            "PREF_KEY_READ_GOAL_ARTICLE_USER_ACTION"
//        private const val PREF_KEY_READ_DISCOVERY_ARTICLE_USER_ACTION =
//            "PREF_KEY_READ_DISCOVERY_ARTICLE_USER_ACTION"
//        private const val PREF_KEY_DISCOVERY_ARTICLE_FEEDBACK_USER_ACTION =
//            "PREF_KEY_DISCOVERY_ARTICLE_FEEDBACK_USER_ACTION"
//        private const val PREF_KEY_ACTION_PROGRESS_IN_TIME_USER_ACTION =
//            "PREF_KEY_ACTION_PROGRESS_IN_TIME_USER_ACTION"
//        private const val PREF_KEY_ACTION_PROGRESS_AFTER_TIME_USER_ACTION =
//            "PREF_KEY_ACTION_PROGRESS_AFTER_TIME_USER_ACTION"
//
//        const val DEFAULT_EMPTY = ""
//        const val DEFAULT_NAME = "BKK Dachverband"
//        const val DEFAULT_CODE = "00000000"
    }

    private val sharedPreferencesReader: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
    private val sharedPreferencesWriter: SharedPreferences.Editor = sharedPreferencesReader.edit()

    var fireBaseUid: String
        get() = getString(PREF_KEY_FIREBASE_UID, "-1")
        set(value) = putString(PREF_KEY_FIREBASE_UID, value)


//    // BKK Stuff
//    fun getSubscribedCategories() = getKeySet(PREF_KEY_SUBSCRIBED_CATEGORIES).map { it.toLong() }
//    fun addSubscribedCategory(categoryId: Long) =
//        addToKeySet(PREF_KEY_SUBSCRIBED_CATEGORIES, categoryId.toString())
//
//    fun removeSubscribedCategory(categoryId: Long) =
//        removeFromKeySet(PREF_KEY_SUBSCRIBED_CATEGORIES, categoryId.toString())
//
//    fun getAppStartUserAction() = getKeySet(PREF_KEY_APP_START_USER_ACTION).map { it.toLong() }
//    fun addAppStartUserAction(timestamp: Long) =
//        addToKeySet(PREF_KEY_APP_START_USER_ACTION, timestamp.toString())
//
//    fun getAssessmentFinishedUserAction() =
//        getKeySet(PREF_KEY_ASSESSMENT_FINISHED_USER_ACTION).map { it.toLong() }
//
//    fun addAssessmentFinishedUserAction(timestamp: Long) =
//        addToKeySet(PREF_KEY_ASSESSMENT_FINISHED_USER_ACTION, timestamp.toString())
//
//    fun getReadGoalArticleUserAction() =
//        getKeySet(PREF_KEY_READ_GOAL_ARTICLE_USER_ACTION).map { it.toLong() }
//
//    fun addReadGoalArticleUserAction(timestamp: Long) =
//        addToKeySet(PREF_KEY_READ_GOAL_ARTICLE_USER_ACTION, timestamp.toString())
//
//    fun getReadDiscoveryArticleUserAction() =
//        getKeySet(PREF_KEY_READ_DISCOVERY_ARTICLE_USER_ACTION).map { it.toLong() }
//
//    fun addReadDiscoveryArticleUserAction(timestamp: Long) =
//        addToKeySet(PREF_KEY_READ_DISCOVERY_ARTICLE_USER_ACTION, timestamp.toString())
//
//    fun getDiscoveryArticleFeedbackUserAction() =
//        getKeySet(PREF_KEY_DISCOVERY_ARTICLE_FEEDBACK_USER_ACTION).map { it.toLong() }
//
//    fun addDiscoveryArticleFeedbackUserAction(timestamp: Long) =
//        addToKeySet(PREF_KEY_DISCOVERY_ARTICLE_FEEDBACK_USER_ACTION, timestamp.toString())
//
//    fun getActionProgressInTimeUserAction() =
//        getKeySet(PREF_KEY_ACTION_PROGRESS_IN_TIME_USER_ACTION).map { it.toLong() }
//
//    fun addActionProgressInTimeUserAction(timestamp: Long) =
//        addToKeySet(PREF_KEY_ACTION_PROGRESS_IN_TIME_USER_ACTION, timestamp.toString())
//
//    fun getActionProgressAfterTimeUserAction() =
//        getKeySet(PREF_KEY_ACTION_PROGRESS_AFTER_TIME_USER_ACTION).map { it.toLong() }
//
//    fun addActionProgressAfterTimeUserAction(timestamp: Long) =
//        addToKeySet(PREF_KEY_ACTION_PROGRESS_AFTER_TIME_USER_ACTION, timestamp.toString())
//
//    var appUserId: String?
//        get() {
//            val token = getString(PREF_KEY_APP_USER_ID, "")
//            return if (token.isEmpty()) null else token
//        }
//        set(value) = putString(PREF_KEY_APP_USER_ID, value)
//    var pushToken: String?
//        get() {
//            val token = getString(PREF_KEY_PUSH_TOKEN, "")
//            return if (token.isEmpty()) null else token
//        }
//        set(value) = putString(PREF_KEY_PUSH_TOKEN, value)
//
//    var lastSavedAnswerId: Long
//        get() = getLong(PREF_KEY_LAST_SAVED_ANSWER, 0)
//        set(value) = putLong(PREF_KEY_LAST_SAVED_ANSWER, value)
//
//    var isPushEnabled: Boolean
//        get() = getBoolean(PREF_KEY_PUSH_ENABLED, false)
//        set(value) = putBoolean(PREF_KEY_PUSH_ENABLED, value)
//
//    var isTutorialDone: Boolean
//        get() = getBoolean(PREF_KEY_IS_TUTORIAL_DONE, false)
//        set(value) = putBoolean(PREF_KEY_IS_TUTORIAL_DONE, value)
//
//    var wasAssessmentExplained: Boolean
//        get() = getBoolean(PREF_KEY_ASSESSMENT_EXPLAINED, false)
//        set(value) = putBoolean(PREF_KEY_ASSESSMENT_EXPLAINED, value)
//
//    var customizingCode: String
//        get() = getString(PREF_KEY_CUSTOMIZING_CODE, DEFAULT_CODE)
//        set(value) = putString(PREF_KEY_CUSTOMIZING_CODE, value)
//    var customizingName: String
//        get() = getString(PREF_KEY_CUSTOMIZING_NAME, DEFAULT_NAME)
//        set(value) = putString(PREF_KEY_CUSTOMIZING_NAME, value)
//    var customizingLogoPath: String
//        get() = getString(PREF_KEY_CUSTOMIZING_LOGO_PATH, DEFAULT_EMPTY)
//        set(value) = putString(PREF_KEY_CUSTOMIZING_LOGO_PATH, value)
//    var customizingCompanyLogoPath: String?
//        get() = getString(PREF_KEY_CUSTOMIZING_COMPANY_LOGO_PATH, DEFAULT_EMPTY)
//        set(value) = putString(PREF_KEY_CUSTOMIZING_COMPANY_LOGO_PATH, value)
////    var customizingColorBkk100: String
//        get() = getString(PREF_KEY_CUSTOMIZING_COLOR_BKK_100, "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.bkk100Default)))
//        set(value) = putString(PREF_KEY_CUSTOMIZING_COLOR_BKK_100, value)
//    var customizingColorBkk60: String
//        get() = getString(PREF_KEY_CUSTOMIZING_COLOR_BKK_60, "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.bkk60Default)))
//        set(value) = putString(PREF_KEY_CUSTOMIZING_COLOR_BKK_60, value)
//    var customizingColorBkk30: String
//        get() = getString(PREF_KEY_CUSTOMIZING_COLOR_BKK_30, "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.bkk30Default)))
//        set(value) = putString(PREF_KEY_CUSTOMIZING_COLOR_BKK_30, value)
//    var customizingColorAssistant: String?
//        get() = getString(PREF_KEY_CUSTOMIZING_COLOR_ASSISTANT, "#" + Integer.toHexString(ContextCompat.getColor(context, R.color.assisstentDefault)))
//    set(value) = putString(PREF_KEY_CUSTOMIZING_COLOR_ASSISTANT, value)
//
//    var customizingCompanyName: String?
//        get() = getString(PREF_KEY_CUSTOMIZING_COMPANY_NAME, DEFAULT_EMPTY)
//        set(value) = putString(PREF_KEY_CUSTOMIZING_COMPANY_NAME, value)
//    var customizingCompanyToc: String
//        get() = getString(PREF_KEY_CUSTOMIZING_COMPANY_TOC, DEFAULT_EMPTY)
//        set(value) = putString(PREF_KEY_CUSTOMIZING_COMPANY_TOC, value)
//    var customizingCompanyLegal: String
//        get() = getString(PREF_KEY_CUSTOMIZING_COMPANY_LEGAL, DEFAULT_EMPTY)
//        set(value) = putString(PREF_KEY_CUSTOMIZING_COMPANY_LEGAL, value)
//    var customizingCompanyDataPrivacy: String
//        get() = getString(PREF_KEY_CUSTOMIZING_COMPANY_DATA_PRIVACY, DEFAULT_EMPTY)
//        set(value) = putString(PREF_KEY_CUSTOMIZING_COMPANY_DATA_PRIVACY, value)
//    var customizingCompanyEnabled: Boolean
//        get() = getBoolean(PREF_KEY_CUSTOMIZING_COMPANY_ENABLED, false)
//        set(value) = putBoolean(PREF_KEY_CUSTOMIZING_COMPANY_ENABLED, value)

//    var testingLengthOfDayInSeconds: Long
//        get() = getLong(PREF_KEY_TESTING_LENGTH_OF_DAY, ONE_DAY_IN_SECONDS)
//        set(value) = putLong(PREF_KEY_TESTING_LENGTH_OF_DAY, value)
//
//    var assessmentQuestionIndex: Int
//        get() = getInt(PREF_KEY_ASSESSMENT_QUESTION_INDEX, 0)
//        set(value) = putInt(PREF_KEY_ASSESSMENT_QUESTION_INDEX, value)

//    var assistant: Assistant
//        get() = Assistant.valueOf(getString(PREF_KEY_ASSISTANT, Assistant.AVATAR_LEONIE.name))
//        set(value) = putString(PREF_KEY_ASSISTANT, value.name)
//    var assistantName: String
//        get() = getString(PREF_KEY_ASSISTANT_NAME, "")
//        set(value) = putString(PREF_KEY_ASSISTANT_NAME, value)
//
//    var apiToken: String
//        get() = getString(PREF_KEY_API_TOKEN, if (BuildConfig.FLAVOR == "stage") API_STAGE_TOKEN else if (BuildConfig.FLAVOR == "prod") API_PROD_TOKEN else API_TEST_TOKEN)
//        set(value) = putString(PREF_KEY_API_TOKEN, value)
//
//    var userName: String
//        get() = getString(PREF_KEY_USER_NAME, "")
//        set(value) = putString(PREF_KEY_USER_NAME, value)
//
//    fun resetCustomizing() {
//        sharedPreferencesWriter
//            .remove(PREF_KEY_CUSTOMIZING_CODE)
//            .remove(PREF_KEY_CUSTOMIZING_NAME)
//            .remove(PREF_KEY_CUSTOMIZING_LOGO_PATH)
//            .remove(PREF_KEY_CUSTOMIZING_COLOR_BKK_100)
//            .remove(PREF_KEY_CUSTOMIZING_COLOR_BKK_60)
//            .remove(PREF_KEY_CUSTOMIZING_COLOR_BKK_30)
//            .remove(PREF_KEY_CUSTOMIZING_COMPANY_NAME)
//            .remove(PREF_KEY_CUSTOMIZING_COMPANY_ENABLED)
//            .remove(PREF_KEY_CUSTOMIZING_COMPANY_LEGAL)
//            .remove(PREF_KEY_CUSTOMIZING_COMPANY_DATA_PRIVACY)
//            .remove(PREF_KEY_CUSTOMIZING_COMPANY_TOC)
//            .remove(PREF_KEY_CUSTOMIZING_COLOR_ASSISTANT)
//            .apply()
//    }
//
//    fun hasUserGivenArticleFeedback(article: Article?) = contains(article?.id.toString())
//    fun setUserGaveArticleFeedback(article: Article) = putInt(article.id.toString(), 1)

    fun getTagPoints(tag: String) = getInt(tag, 0)
    fun incrementTagPoints(tag: String, increment: Int) {
        val oldPoints = getTagPoints(tag)
        val newPoints = oldPoints + increment
        putInt(tag, if (newPoints < 0) 0 else newPoints)
    }

    private fun putString(key: String, value: String?) {
        sharedPreferencesWriter.putString(key, value).apply()
    }

    private fun putBoolean(key: String, value: Boolean) {
        sharedPreferencesWriter.putBoolean(key, value).apply()
    }

    private fun putInt(key: String, value: Int) {
        sharedPreferencesWriter.putInt(key, value).apply()
    }

    private fun putLong(key: String, value: Long) {
        sharedPreferencesWriter.putLong(key, value).apply()
    }

    private fun putFloat(key: String, value: Float) {
        sharedPreferencesWriter.putFloat(key, value).apply()
    }

    private fun addToKeySet(key: String, setEntry: String) {
        val set = getKeySet(key)
        set.add(setEntry)
        sharedPreferencesWriter.putStringSet(key, set).apply()
    }

    private fun removeFromKeySet(key: String, setEntry: String) {
        val set = getKeySet(key)
        set.remove(setEntry)
        sharedPreferencesWriter.putStringSet(key, set).apply()
    }

    private fun remove(key: String) {
        sharedPreferencesWriter.remove(key).apply()
    }

    private fun removeAll() {
        sharedPreferencesWriter.clear().apply()
    }

    private fun getString(key: String, defaultValue: String): String =
        sharedPreferencesReader.getString(key, defaultValue) ?: defaultValue

    private fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        sharedPreferencesReader.getBoolean(key, defaultValue)

    private fun getLong(key: String, defaultValue: Long): Long =
        sharedPreferencesReader.getLong(key, defaultValue)

    private fun getInt(key: String, defaultValue: Int): Int =
        sharedPreferencesReader.getInt(key, defaultValue)

    private fun getFloat(key: String, defaultValue: Float): Float =
        sharedPreferencesReader.getFloat(key, defaultValue)

    private fun getKeySet(key: String): HashSet<String> =
        HashSet(sharedPreferencesReader.getStringSet(key, HashSet()) ?: hashSetOf())

    private fun contains(key: String): Boolean = sharedPreferencesReader.contains(key)
}
