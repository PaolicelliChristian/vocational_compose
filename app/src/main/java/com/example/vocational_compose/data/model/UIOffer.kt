package com.example.vocational_compose.data.model

data class UIOffer(

    val id: String,
    val title: String,
    val position: String,
    val description: String,
    val anonymous: Boolean,
    val location: UILocation,
    val responsible: UIResponsible,
    val company: UICompany,
    val workSector: String,
    val experience: String,
    val impegnoRichiesto: String,
    val insertMode: String,
    val freeQuestions: Boolean,
    val showExpiry: Boolean,
    val expiry: Long,
    val state: String,
    val visualization: Long,
    val candidateCount: Long,
    val dateCreated: Long,
    val approved: Boolean,
    val offertLink: String,
    val isCompanyEnabled: Boolean,
    val sendNotificationMail: Boolean,
)


