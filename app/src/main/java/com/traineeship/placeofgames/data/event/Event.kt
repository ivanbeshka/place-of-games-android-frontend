package com.traineeship.placeofgames.data.event

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Event(
    val id: Int,
    val name: String,
    val time: String,
    val duration: Int,
    val place: Place,
    val maxNumberOfParticipants: Int,
    val numberOfParticipants: Int,
    val description: String,
    val isCurrentUserEnrolled: Boolean,
    val participants: List<Participant>?
)