package com.example.vaccinationcontrol.services.pushes

import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import com.example.vaccinationcontrol.R
import com.example.vaccinationcontrol.domain.repositories.FCMTokenRepository
import com.example.vaccinationcontrol.domain.repositories.SharedPrefsRepository
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class PushService : FirebaseMessagingService() {

    private val sharedPrefsRepository: SharedPrefsRepository by inject()

    private val fcmTokenRepository: FCMTokenRepository by inject()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onNewToken(token: String) {
        sendRegistrationToServer(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val title = message.data["title"] ?: ""
        val body = message.data["body"] ?: ""

        val notificationBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)

        val notificationManager = getSystemService(NotificationManager::class.java)

        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
    }

    private fun createNotificationChannel() {
        val notificationManager = getSystemService(NotificationManager::class.java)
        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)
    }

    private fun sendRegistrationToServer(token: String) {
        coroutineScope.launch {
            val userId = sharedPrefsRepository.getUserId()
            if (userId != -1) {
                fcmTokenRepository.saveFcmToken(token, userId)
            }
        }
    }

    companion object {
        private const val CHANNEL_ID = "appointment"
        private const val CHANNEL_NAME = "appointment_push"
        private const val NOTIFICATION_ID = 121
    }
}